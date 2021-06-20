#Lab 01

SELECT d.`manager_id`, CONCAT(e.`first_name`, ' ', e.`last_name`) AS `full_name`, d.`department_id`, d.`name`
FROM `employees` AS e
JOIN `departments` AS d
ON e.`employee_id` = d.`manager_id`
ORDER BY `employee_id` LIMIT 5;

#Lab 02

SELECT t.`town_id`, t.`name`, a.`address_text`
FROM `towns` AS t
JOIN `addresses` AS a
ON t.`town_id` = a.`town_id`
WHERE t.`name` IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY t.`town_id`, a.`address_id`;

#Lab 03

SELECT `employee_id`, `first_name`, `last_name`, `department_id`, `salary`
FROM `employees`
WHERE `manager_id` IS NULL;

#Lab 04

SELECT COUNT(*) AS 'count' FROM `employees`
WHERE `salary` > (
	SELECT AVG(`salary`) 
    FROM `employees`);









