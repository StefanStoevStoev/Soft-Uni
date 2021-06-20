USE `softunistoressystem`;
#Ex 01

-- CREATE SCHEMA SoftUniStoresSystem;

CREATE TABLE pictures(
	id INT PRIMARY KEY AUTO_INCREMENT,
	url VARCHAR(100) NOT NULL,
	added_on DATETIME NOT NULL
);
CREATE TABLE categories(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL UNIQUE
);
CREATE TABLE products(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL UNIQUE,
	`best_before` DATE,
	`price` DECIMAL(10,2) NOT NULL,
	`description` TEXT,
	`category_id` INT NOT NULL,
	`picture_id` INT NOT NULL,
    CONSTRAINT `fk_products_pictures`
    FOREIGN KEY (`picture_id`)
    REFERENCES `pictures`(`id`),
    CONSTRAINT `fk_products_categories`
    FOREIGN KEY (`category_id`)
    REFERENCES `categories`(`id`)
);
CREATE TABLE towns(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(20) NOT NULL UNIQUE
);
CREATE TABLE addresses(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL UNIQUE,
	`town_id` INT NOT NULL,
    CONSTRAINT `fk_addresses_towns`
    FOREIGN KEY (town_id)
    REFERENCES `towns`(id)
);
CREATE TABLE stores(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(20) NOT NULL UNIQUE,
	`rating` FLOAT NOT NULL,
	`has_parking` TINYINT(1) DEFAULT FALSE,
	`address_id` INT NOT NULL,
    CONSTRAINT `fk_stores_addresses`
    FOREIGN KEY (`address_id`)
    REFERENCES `addresses`(`id`)
);
CREATE TABLE `products_stores`(
	`product_id` INT NOT NULL,
	`store_id` INT NOT NULL,
    CONSTRAINT `pk_products_stores`
    PRIMARY KEY (`product_id`, store_id),
    CONSTRAINT fk_products_stores_products
    FOREIGN KEY (product_id)
    REFERENCES `products`(`id`),
    CONSTRAINT fk_products_stores_stores
    FOREIGN KEY (store_id)
    REFERENCES `stores`(`id`)
);

CREATE TABLE employees(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(15) NOT NULL,
	`middle_name` CHAR(1),
	`last_name` VARCHAR(20) NOT NULL,
	`salary` DECIMAL(19,2) DEFAULT 0,
	`hire_date` DATE NOT NULL,
	`manager_id` INT,
	`store_id` INT NOT NULL,
    CONSTRAINT fk_employees_stores
    FOREIGN KEY (store_id)
    REFERENCES stores(id),
    CONSTRAINT fk_employees_employees
    FOREIGN KEY (manager_id)
    REFERENCES employees(id)
);

#Ex 02

ALTER TABLE `products_stores` 
ALTER `store_id` SET DEFAULT 1;

INSERT INTO `products_stores` (`product_id`)
SELECT p.`id` FROM `products` AS p
	LEFT JOIN `products_stores` AS ps
    ON ps.`product_id` = p.`id`
    WHERE p.`id` = ps.`product_id` IS NULL;

#Ex 03

UPDATE `employees`
SET `salary` = `salary` - 500, `manager_id` = 3
WHERE `store_id` NOT IN (5, 14) AND YEAR(`hire_date`) > 2003;

#Ex 04

DELETE FROM `employees` 
WHERE `salary` >= 6000 AND `manager_id` IS NOT NULL AND `id` != 3;

#Ex 05

SELECT `first_name`, `middle_name`, `last_name`, `salary`, `hire_date`
FROM `employees`
ORDER BY `hire_date` DESC;

#Ex 06

SELECT p.`name` AS `product_name`, p.`price`, p.`best_before`, CONCAT(LEFT(`description`, 10), '...') AS `short_description`, pic.`url`
FROM `products` AS p
JOIN `pictures` AS pic
ON pic.`id` = p.`picture_id`
WHERE CHARACTER_LENGTH(`description`) > 100 AND YEAR(`added_on`) < 2019 AND `price` > 20
ORDER BY `price` DESC;

#Ex 07

SELECT s.`name`, COUNT(p.`id`) AS `product_count`, ROUND(AVG(p.`price`),2) AS `avg`
FROM `stores` AS s
LEFT JOIN `products_stores`AS ps
ON s.`id` = ps.`store_id`
LEFT JOIN `products` AS p
ON ps.`product_id` = p.`id`
GROUP BY s.`id`
ORDER BY `product_count` DESC, `avg` DESC, s.`id`;

#Ex 08

SELECT CONCAT(e.`first_name`, ' ', e.`last_name`) AS `Full_name`, s.`name` AS `Store_name`, a.`name` AS `address`, e.`salary`
FROM `employees` AS e
JOIN `stores` AS s
ON s.`id` = e.`store_id`
JOIN `addresses` AS a
ON a.`id` = s.`address_id`
WHERE e.`salary` < 4000 AND a.`name` LIKE '%5%' 
AND CHARACTER_LENGTH(s.`name`) > 8 AND e.`last_name` LIKE '%n';

#Ex 09

SELECT REVERSE(s.`name`) AS `reversed_name`, CONCAT(UPPER(t.`name`),'-', a.`name`) AS 'full_address', COUNT(e.`id`) AS 'employees_count'
FROM `stores` AS s
JOIN `addresses` AS a
ON a.`id` = s.`address_id` 
JOIN `employees` AS e
ON s.`id` = e.`store_id`
JOIN `towns` AS t
ON t.`id` = a.`town_id`
GROUP BY s.`name`
HAVING `employees_count` >= 1
ORDER BY `full_address`;

#Ex 10

DELIMITER $$
CREATE FUNCTION udf_top_paid_employee_by_store(store_name VARCHAR(50))
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
	RETURN (SELECT CONCAT(`first_name`, ' ', `middle_name`, '. ', `last_name`,' works in store for ',
				YEAR('2020-10-18') - YEAR(`hire_date`), ' years' )
				FROM `employees` AS e
                JOIN `stores` AS s
                ON e.`store_id` = s.`id`
                WHERE s.`name` = store_name
                ORDER BY `salary` DESC LIMIT 1);
END $$
DELIMITER ;

DROP FUNCTION udf_top_paid_employee_by_store;
SELECT udf_top_paid_employee_by_store('Stronghold') as 'full_info';

#Ex 11

DELIMITER $$
CREATE FUNCTION update_price(address_id INT, add_price DECIMAL(19,4))
RETURNS DECIMAL(19,2)
DETERMINISTIC
BEGIN
	RETURN((SELECT `price` FROM`products`
    WHERE `id` = address_id) + add_price);
    
END$$
DELIMITER ;

DROP FUNCTION update_price;

DELIMITER $$
CREATE PROCEDURE udp_update_product_price (address_name VARCHAR (50))
BEGIN
	DECLARE increse_level INT;
    IF address_name LIKE '0%' THEN SET increse_level = 100;
    ELSE SET increse_level = 200;
	END IF;
    
    UPDATE products AS p
    SET price = price + increse_level
    WHERE p.id IN (
					SELECT ps.product_id 
                    FROM addresses AS a
                    JOIN stores AS s
                    ON a.id = s.address_id
                    JOIN products_stores AS ps
                    ON ps.store_id = s.id
                    WHERE a.`name` = address_name
					);
    
END $$
DELIMITER ;

DROP PROCEDURE udp_update_product_price;
CALL udp_update_product_price('07 Armistice Parkway');
/*
    UPDATE `products`
    SET `price` = IF( SUBSTR(address_name, 1, 1) LIKE '0', update_price(a.`id`, 100), update_price(a.`id`, 200))
    WHERE `id` = ;
        
    SET p.`price` = IF( SUBSTR(address_name, 1, 1) LIKE '0', update_price(a.`id`, 100), update_price(a.`id`, 200))
*/
SELECT update_price(1, 100);

