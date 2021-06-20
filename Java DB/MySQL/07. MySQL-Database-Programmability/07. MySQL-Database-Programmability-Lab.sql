SELECT * 
  FROM employees
  WHERE ROUND((DATEDIFF(NOW(), hire_date) / 365.25)) < 20;

SELECT `employee_id`, `first_name`, `last_name`
 FROM `employees`
 WHERE `first_name` REGEXP '^\[^K\]{4}\$';
 
 #Ex 01
 
SELECT ufn_count_employees_by_town('Sofia');

#Ex 02

CALL usp_raise_salaries('Finance');

SELECT `first_name`, `salary` FROM `employees`
JOIN `departments` AS d
USING(`department_id`)
WHERE d.`name` = 'Finance'
ORDER BY first_name;

#Ex 03

CALL `usp_raise_salary_by_id`(1);

SELECT `first_name`, `salary` FROM `employees`
WHERE `employee_id` = 1;

#Ex 04

CREATE TABLE deleted_employees(
	employee_id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	middle_name VARCHAR(50),
	job_title VARCHAR(50),
	department_id INT,
	salary DECIMAL(19,4)
);

CREATE TRIGGER tr_deleted_employees
AFTER DELETE
ON employees
FOR EACH ROW
BEGIN
	INSERT INTO deleted_employees (first_name,last_name, middle_name,job_title,department_id,salary)
	VALUES(OLD.first_name,OLD.last_name,OLD.middle_name, OLD.job_title, OLD.department_id, OLD.salary);
END;


 
 




