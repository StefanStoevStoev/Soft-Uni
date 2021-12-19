CREATE DATABASE stc;
USE stc;

#Ex 02

ALTER TABLE `clients` AUTO_INCREMENT = 100;
INSERT INTO `clients`(`full_name`, `phone_number`)
SELECT CONCAT(`first_name`, ' ', `last_name`), CONCAT('(088) 9999', `id` * 2)
FROM `drivers`
WHERE `id` > 9 AND `id` < 21;

#Ex 03

UPDATE `cars`
SET `condition` = 'C'
WHERE `mileage` IS NULL OR `mileage` >= 800000 AND `year` <= 2010 AND `make` NOT LIKE 'Mercedes-Benz';

SELECT COUNT(*) FROM cars WHERE `condition` = 'C';

#Ex 04

DELETE FROM `clients`
WHERE `id` NOT IN (SELECT `client_id` FROM `courses`);

#Ex 05

SELECT `make`, `model`, `condition` FROM `cars`
ORDER BY `id`;

#Ex 06

SELECT d.`first_name`, d.`last_name`, c.`make`, c.`model`, c.`mileage` FROM `drivers` AS d
JOIN `cars_drivers` AS cd
ON cd.`driver_id` = d.`id`
JOIN `cars` AS c
ON c.`id` = cd.`car_id`
WHERE c.`mileage` IS NOT NULL
ORDER BY c.`mileage` DESC, d.`first_name`;

#Ex 07

SELECT c.`id` AS 'car_id', c.`make`, c.`mileage`, COUNT(`car_id`) AS 'count_of_courses', ROUND(AVG(`bill`), 2) AS `avg_bill`
FROM `cars` AS c
LEFT JOIN `courses` AS cs
ON cs.`car_id` = c.`id`
GROUP BY c.`id`
HAVING `count_of_courses` != 2
ORDER BY `count_of_courses` DESC, `car_id`;

#Ex 08

SELECT cl.`full_name`, COUNT(c.`id`) AS 'count_of_cars', SUM(`bill`) AS 'total_sum'
FROM `clients` AS cl
JOIN `courses` AS cs 
ON cs.`client_id` = cl.`id`
JOIN `cars` AS c
ON cs.`car_id` = c.`id`
WHERE cl.`full_name` LIKE '_a%'
GROUP BY cl.`full_name`
HAVING `count_of_cars` > 1
ORDER BY cl.`full_name`;

#Ex 09

SELECT a.`name`,(
							CASE 
								WHEN HOUR(cs.`start`) >= 6 AND HOUR(cs.`start`) <= 20 THEN 'Day'
                                ELSE 'Night' 
							END)
                                AS `day_time`, cs.`bill`, cl.`full_name`, c.`make`, c.`model`, ct.`name` AS `category_name`
FROM `clients` AS cl
JOIN `courses` AS cs 
ON cs.`client_id` = cl.`id`
JOIN `cars` AS c
ON cs.`car_id` = c.`id`
JOIN `categories` AS ct
ON ct.`id` = c.`category_id`
JOIN `addresses` AS a
ON a.`id` = cs.`from_address_id`
ORDER BY cs.`id`;

#Ex 10

DELIMITER $$
CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN(SELECT COUNT(`phone_number`) AS 'count'
		FROM `clients` AS cl
		JOIN `courses` AS cs
		ON cl.`id` = cs.`client_id`
		WHERE `phone_number` LIKE phone_num);
END $$
DELIMITER ;

SELECT udf_courses_by_client ('(803) 6386812') as `count`; 

SELECT COUNT(`phone_number`) 
FROM `clients` AS cl
JOIN `courses` AS cs
ON cl.`id` = cs.`client_id`
WHERE `phone_number` LIKE '(803) 6386812';


#Ex 11

DELIMITER $$
CREATE PROCEDURE udp_courses_by_address(address_name VARCHAR(100))
BEGIN
	SELECT a.`name`, cl.`full_name`, (CASE 
										WHEN `bill` < 21 THEN 'Low'
										WHEN `bill` < 31 THEN 'Medium'
										ELSE 'High'
									END) AS `level_of_bill`, c.`make`, c.`condition`,ct.`name` AS 'cat_name'
	FROM `clients` AS cl
	JOIN `courses` AS cs 
	ON cs.`client_id` = cl.`id`
	JOIN `cars` AS c
	ON cs.`car_id` = c.`id`
	JOIN `categories` AS ct
	ON ct.`id` = c.`category_id`
	JOIN `addresses` AS a
	ON a.`id` = cs.`from_address_id`
	WHERE a.`name` LIKE address_name
	ORDER BY c.`make`, cl.`full_name`;
END $$
DELIMITER ;

SELECT a.`name`, cl.`full_name`, (CASE 
										WHEN `bill` < 21 THEN 'Low'
										WHEN `bill` < 31 THEN 'Medium'
										ELSE 'High'
									END) AS `level_of_bill`, c.`make`, c.`condition`,ct.`name` AS 'cat_name'
FROM `clients` AS cl
JOIN `courses` AS cs 
ON cs.`client_id` = cl.`id`
JOIN `cars` AS c
ON cs.`car_id` = c.`id`
JOIN `categories` AS ct
ON ct.`id` = c.`category_id`
JOIN `addresses` AS a
ON a.`id` = cs.`from_address_id`
WHERE a.`name` LIKE '700 Monterey Avenue'
ORDER BY c.`make`, cl.`full_name`;

SELECT DAY(2012-02-31);
SELECT EXTRACT(day FROM '2017-06-15');
SELECT DAY('2017-06-15');  

