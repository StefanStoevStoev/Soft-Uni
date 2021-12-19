CREATE DATABASE `lab_05`;
USE `lab_05`;

#Lab Many To One

CREATE TABLE `mountains`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)NOT NULL
);
INSERT INTO `mountains`
VALUES (1, 'Causasus');

DROP TABLE `mountains`;

CREATE TABLE `peaks`(
	`peak_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `mountain_id` INT,
    CONSTRAINT `fk_peaks_mountains`
    FOREIGN KEY (`mountain_id`)
    REFERENCES `mountains`(`id`)
);

INSERT INTO `peaks`
VALUE
(61, 'Sveti Ivan', 1),
(60, 'Botev', 1);

DROP TABLE `peaks`;

# Lab Many To Many

CREATE TABLE `employees`(
	`employee_id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL);

INSERT INTO `employees`
VALUES
(1, Ivan),
(40, Petq);

CREATE TABLE `projects`(
	`project_id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(30));
    
INSERT INTO `projects`
VALUES
(4, 'Project1'),
(24, 'Project1');

CREATE TABLE `employees_projects`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`employee_id` INT,
	`project_id` INT,
    CONSTRAINT `fk_e_p_empl`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employees`(`employee_id`),
    CONSTRAINT `fk_e_p__proj`
    FOREIGN KEY (`project_id`)
    REFERENCES `projects`(`project_id`)
);

#Lab One to One
CREATE TABLE `drivers`(
  `driver_id` INT PRIMARY KEY,
  `driver_name` VARCHAR(50)
);

CREATE TABLE `cars`(
  `car_id` INT PRIMARY KEY,
  `driver_id` INT UNIQUE,
  CONSTRAINT `fk_cars_drivers` 
  FOREIGN KEY  (`driver_id`) 
  REFERENCES `drivers`(`driver_id`)
);

#Lab Cascade update/delate

CREATE TABLE drivers(
  driver_id INT PRIMARY KEY,
  driver_name VARCHAR(50)
);

CREATE TABLE cars(
  car_id INT PRIMARY KEY,
  driver_id INT,
  CONSTRAINT fk_car_driver FOREIGN KEY(driver_id)
  REFERENCES drivers(driver_id) ON DELETE CASCADE);

CREATE TABLE drivers(
  driver_id INT PRIMARY KEY,
  driver_name VARCHAR(50)
);

CREATE TABLE cars(
  car_id INT PRIMARY KEY,
  driver_id INT,
  CONSTRAINT fk_car_driver FOREIGN KEY(driver_id)
  REFERENCES drivers(driver_id) ON UPDATE CASCADE);

# LAB 01

CREATE TABLE `mountains`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE `peaks`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
    `mountain_id` INT
);

ALTER TABLE `peaks`
ADD CONSTRAINT `fk_peaks_montains`
FOREIGN KEY (`mountain_id`)
REFERENCES `mountains`(`id`)
ON DELETE CASCADE;

DROP TABLE `mountains`;
DROP TABLE `peaks`;



# LAB 02

SELECT `driver_id`, `vehicle_type`, concat(`first_name`, ' ',`last_name`)
AS `driver_name`
FROM `vehicles` AS `v`
JOIN `campers` AS `c`
ON `v`.`driver_id` = `c`.`id`;

# LAB 03

SELECT `starting_point`, `end_point`, `leader_id`, CONCAT(`first_name`, ' ', `last_name`)
AS `leader_name`
FROM `routes` AS r
JOIN `campers` AS c
ON r.`leader_id` = c.`id`;








