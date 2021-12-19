#Ex 01

DELIMITER $$

CREATE PROCEDURE `usp_get_employees_salary_above_35000`() 
BEGIN

	SELECT `first_name`, `last_name`
    FROM `employees`
    WHERE `salary` > 35000
    ORDER BY `first_name`, `last_name`;
    
END $$

DELIMITER ;

DROP PROCEDURE `usp_get_employees_salary_above_35000`;

CALL `usp_get_employees_salary_above_35000`();

#Ex 02

DELIMITER $$

CREATE PROCEDURE usp_get_employees_salary_above(`decimal` DECIMAL(15,4))
BEGIN
	SELECT `first_name`, `last_name` FROM `employees`
    WHERE `salary` >= `decimal`
    ORDER BY `first_name`, `last_name`, `employee_id`;

END $$
DELIMITER ;

DROP PROCEDURE usp_get_employees_salary_above;
CALL usp_get_employees_salary_above(45000.00);

#Ex 03

DELIMITER $$

CREATE PROCEDURE `usp_get_towns_starting_with`(town_names VARCHAR(50))
BEGIN
	SELECT `name` FROM `towns`
    WHERE `name` LIKE CONCAT(town_names,'%')
    ORDER BY `name`;

END $$
DELIMITER ;

DROP PROCEDURE `usp_get_towns_starting_with`;
CALL `usp_get_towns_starting_with`('b');

#Ex 04

DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(50))
BEGIN
	SELECT `first_name`, `last_name` FROM `employees` AS e
    JOIN `addresses` AS a
    USING(address_id)
    JOIN `towns` AS t
    USING(town_id)
    WHERE t.`name` = town_name
    ORDER BY `first_name`, `last_name`, t.`town_id`;
END $$
DELIMITER ;

DROP PROCEDURE  usp_get_employees_from_town;
CALL usp_get_employees_from_town('Sofia');

#Ex 05

DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(`decimal` DECIMAL(15,2))
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
	DECLARE salary_level VARCHAR(50);
		IF `decimal` < 30000 THEN
			SET salary_level = 'Low';
		ELSEIF `decimal` <= 50000 THEN
			SET salary_level = 'Average';
		ELSE SET salary_level = 'High';
	END IF;
    RETURN (salary_level);

END$$
DELIMITER ;

SELECT `salary`, ufn_get_salary_level(`salary`) AS 'salary_Level'
FROM `employees`;

DROP FUNCTION ufn_get_salary_level;

#Ex 06

DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(rate VARCHAR(30))
BEGIN
	SELECT first_name, last_name 
    FROM employees
    WHERE ufn_get_salary_level(`salary`) = rate
    ORDER BY first_name DESC, last_name DESC;

END $$
DELIMITER ;

DROP PROCEDURE usp_get_employees_by_salary_level;
CALL usp_get_employees_by_salary_level('High');

#Ex 07

DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(
set_of_letters varchar(50), word varchar(50))
RETURNS BIT
DETERMINISTIC
BEGIN
	RETURN (SELECT lower(word) REGEXP(lower(CONCAT('^[',set_of_letters ,']+$'))));
END $$
DELIMITER ;

DROP FUNCTION ufn_is_word_comprised;
SELECT ufn_is_word_comprised('oistmiahf', 'halves') AS regex;

#Ex 08

DELIMITER $$

CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
	SELECT CONCAT_WS(' ', `first_name`, `last_name`) AS 'full_name'
    FROM `account_holders`
    ORDER BY `full_name`;
    
END$$
DELIMITER ;

DROP PROCEDURE usp_get_holders_full_name;
CALL usp_get_holders_full_name;

#Ex 10

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(
balance DECIMAL(19,4), interst_rate DECIMAL(19,4), years INT)
RETURNS DECIMAL(19,4)
DETERMINISTIC
BEGIN
	RETURN  balance * pow((1 + interst_rate), years);
END $$
DELIMITER ;

DROP FUNCTION ufn_calculate_future_value;
SELECT ufn_calculate_future_value(1000, 0.5, 5);

#Ex 11 

DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(acc_id INT, interest DECIMAL(19, 4))
BEGIN

	SELECT a.id AS account_id, ah.first_name, 
		ah.last_name, a.balance AS current_balance,
		(SELECT ufn_calculate_future_value(a.balance, interest, 5))
			AS balance_in_5_years
    FROM account_holders AS ah
    JOIN `accounts` AS a
    ON ah.id = a.account_holder_id
    WHERE a.id = acc_id;
    
END$$
DELIMITER ;

DROP PROCEDURE usp_calculate_future_value_for_account;
CALL usp_calculate_future_value_for_account(1, 0.1);

#Ex 12

DELIMITER $$
CREATE PROCEDURE usp_deposit_money(acc_id INT, money_amount DECIMAL(50,4))
BEGIN
   START TRANSACTION;
	IF (money_amount < 0) THEN 
    ROLLBACK;
    ELSE
		SELECT id AS account_id, account_holder_id, balance
		FROM accounts 
		WHERE id = acc_id and balance = balance + money_amount AND money_amount > 0;
		UPDATE accounts
		SET balance = balance + money_amount;
	END IF;
END $$
DELIMITER ;

DROP PROCEDURE usp_deposit_money;
CALL usp_deposit_money(1, 10);

#Ex 13

DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(acc_id INT, money_amount DECIMAL(20,4))
BEGIN
   START TRANSACTION;
	IF (money_amount <= 0) THEN 
    ROLLBACK;
    ELSE
		SELECT id AS account_id, account_holder_id, balance
		FROM accounts 
		WHERE id = acc_id and balance = balance - money_amount;
		UPDATE accounts
		SET balance = balance - money_amount
        WHERE balance - money_amount >= 0;
	END IF;
END $$
DELIMITER ;

DROP PROCEDURE usp_withdraw_money;
CALL usp_withdraw_money(1, 10);

#Ex 14

DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19,4))

BEGIN
	
	IF (amount >= 0)
    AND 
    (SELECT id FROM accounts WHERE id = from_account_id) IS NOT NULL
    AND 
    (SELECT id FROM accounts WHERE id = to_account_id) IS NOT NULL
    THEN
	START TRANSACTION;
            UPDATE accounts
			SET balance = balance - amount
			WHERE id = from_account_id;
            
            UPDATE accounts
			SET balance = balance + amount
            WHERE id = to_account_id;
            
			IF (SELECT balance
			FROM accounts 
            WHERE id = from_account_id) < 0
            THEN
				ROLLBACK;
			ELSE
				COMMIT;
            END IF;
	END IF;
END $$
DELIMITER ;

DROP PROCEDURE usp_transfer_money;
CALL usp_transfer_money(1, 2, 10);

#Ex 15

CREATE TABLE logs(
	log_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT,
    old_sum DECIMAL(19,4),
    new_sum DECIMAL(19,4)
);

DELIMITER $$
CREATE TRIGGER account_log
 AFTER UPDATE ON accounts
 FOR EACH ROW
 BEGIN
	INSERT INTO `logs` (account_id, old_sum, new_sum)
    VALUES(old.id, old.balance, new.balance);
END $$
DELIMITER ;

#Ex 16

CREATE TABLE notification_emails(
	`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `recipient` INT NOT NULL,
    `subject` VARCHAR(100),
    `body` VARCHAR(500)
);

DELIMITER $$
CREATE TRIGGER interest_log
AFTER UPDATE ON `logs`
FOR EACH ROW
BEGIN
	INSERT INTO `notification_emails`(`id`, `recipient`, `subject`, `body`)
    VALUES(account_id, ('Balance change for account: ', account_id), 
    ('On ',DATE_FORMAT(NOW(), '%b %d %Y at %r'),' your balance was changed from ',ROUND(NEW.old_sum, 2),' to ',ROUND(NEW.new_sum, 2),'.'));
END $$
DELIMITER ;

DROP TRIGGER interest_log;
CALL interest_log;



CREATE TABLE `date_new`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`date` TIMESTAMP
);
DROP TABLE `date_new`;

INSERT INTO `date_new`(`date`)
VALUES
('2000-03-06');

SELECT `date`, date_format(`date`,'%b %e %Y at %r') AS `date2` FROM `date_new`;

#Ex 9

DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(balance_acc INT)
BEGIN
	SELECT `first_name`, `last_name`
    FROM `account_holders` AS ah
    JOIN (SELECT * FROM accounts AS a
			GROUP BY a.account_holder_id
            HAVING SUM(balance) > balance_acc)
	AS a
    ON ah.id = a.account_holder_id
    ORDER BY ah.id;
    
END $$
DELIMITER ;

DROP PROCEDURE usp_get_holders_with_balance_higher_than;
CALL usp_get_holders_with_balance_higher_than(7000);










