	CREATE DATABASE `gamebar`;
    USE `gamebar`;
    
    CREATE TABLE `employees`(
		`id` INT PRIMARY KEY AUTO_INCREMENT,
		`first_name` VARCHAR(50) NOT NULL,
		`last_name` VARCHAR(50) NOT NULL
    );
	CREATE TABLE `categories`(
		`id` INT PRIMARY KEY AUTO_INCREMENT,
		`name` VARCHAR(50) NOT NULL
    );
	CREATE TABLE `products`(
		`id` INT PRIMARY KEY AUTO_INCREMENT,
		`name` VARCHAR(50) NOT NULL,
		`category_id` INT
    );
    
    #L2
    INSERT INTO `employees`
    VALUES
    (1,'Pesho','Peshov'),
    (2,'Gosho','Goshov'),
    (3,'Ivan','Ivanov');
    
    #L3
    ALTER TABLE `employees`
    ADD COLUMN `middle_name` VARCHAR(50);
    
    #L4
    ALTER TABLE `products`
    ADD CONSTRAINT fk_products_categories
    FOREIGN KEY (`category_id`)
    REFERENCES `categories`(`id`);
    
	#L5
ALTER TABLE `employees`
MODIFY COLUMN `middle_name` VARCHAR(100);
    
#E

CREATE DATABASE `minions`;
USE `minions`;

#E1
CREATE TABLE `minions`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40),
    `age` VARCHAR(40)
);
CREATE TABLE `towns`(
	`town_id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL
);

#

ALTER TABLE `towns`
CHANGE COLUMN `town_id` `id` INT;

#E2
ALTER TABLE `minions`
ADD COLUMN `town_id` INT,
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY `minions`(`town_id`)
REFERENCES `towns`(`id`);

#E3
INSERT INTO `towns`
VALUES
(1,'Sofia'),
(2,'Plovdiv'),
(3,'Varna');

INSERT INTO `minions`
VALUES
(1,'Kevin',22,1),
(2,'Bob',15,3),
(3,'Steward',NULL,2);

#E4
TRUNCATE `minions`;
#E5
DROP TABLE `minions`;
DROP TABLE `towns`;

#E6
CREATE TABLE `people`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(200) NOT NULL,
    `picture` BLOB,
    `height` FLOAT(5, 2),
    `weight` FLOAT(5, 2),
    `gender` CHAR(1) NOT NULL,
    `birthdate` DATE NOT NULL,
    `biography` TEXT
);
INSERT INTO `people`
VALUES
(1, 'Ivan', 'picture1', 1.92, 92.8, 'M', '1995-12-25', 'text'),
(2, 'Petyr', 'picture1', 1.82, 82.8, 'M', '1995-09-09', 'text'),
(3, 'Petq', 'picture1', 1.72, 62.8, 'W', '1995-02-28', 'text'),
(4, 'Dobri', 'picture1', 1.78, 62.8, 'M', '1995-03-14', 'text'),
(5, 'Stamen', 'picture1', 1.88, 82.8, 'M', '1995-07-01', 'text');

SELECT * FROM `people`;

#E7
CREATE TABLE `users`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(30) NOT NULL,
    `password` VARCHAR(26) NOT NULL,
    `profile_picture` BLOB,
    `last_login_time` DATETIME,
    `is_deleted` BOOLEAN
);

INSERT INTO `users`
VALUES
(1, 'Stefan', 'Didi', 'picture', '1950-05-01 10:50:00', false),
(2, 'Georgi', 'R43MN', 'picture2', '1955-05-01 10:50:00', false),
(3, 'Ivan', 'z12', 'picture3', '1970-05-01 10:50:00', false),
(4, 'Petyr', 'ss132', 'picture4', '1980-05-01 10:50:00', true),
(5, 'Stoqn', 'Refolt', 'picture5', '1977-05-01 10:50:00', false)
;

#E8
ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY (`id`, `username`);

#E9
ALTER TABLE `users` 
MODIFY `last_login_time` DATETIME DEFAULT CURRENT_TIMESTAMP ;

SELECT * FROM `users`;

#E10
ALTER TABLE `users` 
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`);

ALTER TABLE `users` 
ADD CONSTRAINT `uq_username`  UNIQUE (`username`);

#E11

CREATE DATABASE `Movies`;
USE `Movies`;

CREATE TABLE `directors`(
	`id` INT PRIMARY KEY,
    `director_name` VARCHAR(30) NOT NULL,
    `notes` TEXT
);
INSERT INTO `directors`
VALUES
(1, 'Washovski','Boza'),
(2, 'King','Agne'),
(3, 'Spilberg','Viali'),
(4, 'Valentin','Volga'),
(5, 'Valentin','Volga')
;
CREATE TABLE `genres`(
	`id` INT PRIMARY KEY,
    `genre_name` VARCHAR(30) NOT NULL,
    `notes` TEXT
);
INSERT INTO `genres`
VALUES
(1, 'Opera','Boris'),
(2, 'Teatre','Donev'),
(3, 'Cinema','Rott'),
(4, 'Art','Kristo'),
(5, 'Pantomima','Ilia')
;
CREATE TABLE `categories`(
	`id` INT PRIMARY KEY,
    `category_name` VARCHAR(30) NOT NULL,
    `notes` TEXT
);
INSERT INTO `categories`
VALUES
(1, 'Comedy','Sheen'),
(2, 'Drama','Robins'),
(3, 'Social','Wiliams'),
(4, 'Action','Niro'),
(5, 'Fantastic','Kianu')
;
CREATE TABLE `movies`(
	`id` INT PRIMARY KEY,
    `title` VARCHAR(30) NOT NULL,
    `director_id` INT,
    `copyright_year` INT,
    `length` INT,
    `genre_id` INT,
    `category_id` INT,
    `rating` INT,
    `notes` TEXT
);
INSERT INTO `movies`
VALUES
(1, 'The Matrix' ,1 ,1985 ,120, 20, 1, 5, 'TEXT'),
(2, 'Heat',3 ,1985 ,120, 20, 1, 5, 'TEXT'),
(3, 'Grean male',2 ,1985 ,120, 20, 1, 5, 'TEXT'),
(4, 'Shoushenk redemption',5 ,1985 ,120, 20, 1, 5, 'TEXT'),
(5, 'The good Will Hunting',4 ,1985 ,120, 20, 1, 5, 'TEXT');

#E12

CREATE DATABASE `car_rental`;
USE `car_rental`;

CREATE TABLE `categories`(
	`id` INT PRIMARY KEY,
    `category` VARCHAR(30),
    `daily_rate` INT,
    `weekly_rate` INT,
    `monthly_rate` INT,
    `weekend_rate` INT
);
INSERT INTO `categories`
VALUES
(1, 'SUV', 80, 320, 1200, 140),
(2, 'sedan', 60, 240, 800, 100),
(3, 'bugy', 50, 200, 700, 120)
;
CREATE TABLE `cars`(
	`id` INT PRIMARY KEY,
    `plate_number` INT,
    `make` VARCHAR(30),
    `model` VARCHAR(30),
    `car_year` INT,
    `category_id` INT,
    `doors` INT,
    `picture` BLOB,
    `car_condition` VARCHAR(30),
    `available` BOOLEAN
);
INSERT INTO `cars`
VALUES
(1, 5268, 'Mercedes', 'C200', 2003, 2, 4, 'ss', 'good', TRUE),
(2, 7325, 'Audi', 'A4', 2010, 2, 2, 'ss1', 'excelent', FALSE),
(3, 6958, 'Toyota', 'Land Cruser', 2011, 2, 4, 'ff', 'bad', TRUE)
;
CREATE TABLE `employees`(
	`id` INT PRIMARY KEY,
    `first_name` VARCHAR(30),
    `last_name` VARCHAR(30),
    `title` VARCHAR(30),
    `notes` TEXT
);
INSERT INTO `employees`
VALUES
(1, 'Ivan', 'Asenov', 'Manager', 'Needs new car'),
(2, 'Georgi', 'Antonov', 'Owner', 'Has SUV'),
(3, 'Kaloian', 'Dimov', 'Programmer', 'Needs new car')
;
CREATE TABLE `customers`(
	`id` INT PRIMARY KEY,
    `driver_licence_number` INT,
    `full_name` VARCHAR(50),
    `address` VARCHAR(200),
    `city` VARCHAR(50),
    `zip_code` INT,
    `notes` TEXT
);
INSERT INTO `customers`
VALUES
(1, 586935, 'Dimo Georgiev Petrov', 'Solunska 144', 'Sofia', 2010, 'Electrical car'),
(2, 325698, 'Miroslav Kalchev Simeonov', 'Solunska 14', 'Sofia', 2600, 'Electrical car'),
(3, 251413, 'Rumen Rosenov Kirilov', 'Solunska 44', 'Sofia', 2000, 'Electrical car')
;
CREATE TABLE `rental_orders`(
	`id` INT PRIMARY KEY,
    `employee_id` INT,
    `customer_id` INT,
    `car_id` INT,
    `car_condition` VARCHAR(200),
    `tank_level` VARCHAR(50),
    `kilometrage_start` INT,
    `kilometrage_end` INT,
    `total_kilometrage` INT,
    `start_date` DATE,
    `end_date` DATE,
    `total_days` INT,
    `rate_applied` INT,
    `tax_rate` INT,
    `order_status` BOOLEAN,
    `notes` TEXT
);
INSERT INTO `rental_orders`
VALUES
(1, 1, 1, 1, 'good', 'full', 100, 1000, 25652, '2021-01-02', '2021-01-03', 1, 1, 1, TRUE, 'Order'),
(2, 1, 1, 1, 'bad', '1/2', 100, 1000, 25652, '2021-01-02', '2021-01-03', 1, 1, 1, TRUE, 'Order'),
(3, 1, 1, 1, 'good', 'empty', 100, 1000, 25652, '2021-01-02', '2021-01-03', 1, 1, 1, TRUE, 'Order')
;

#E13

CREATE DATABASE `soft_uni`;
USE `soft_uni`;

CREATE TABLE `towns`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);
DROP TABLE `towns`;
CREATE TABLE `addresses`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `address_text` VARCHAR(100) NOT NULL,
    `town_id` INT NOT NULL,
    CONSTRAINT fk_addresses_towns
    FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`)
);
CREATE TABLE `departments`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);
DROP TABLE `departments`;
CREATE TABLE `employees`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(30) NOT NULL,
	`middle_name` VARCHAR(30) NOT NULL,
	`last_name` VARCHAR(30) NOT NULL,
	`job_title` VARCHAR(30),
	`department_id` INT NOT NULL,
	`hire_date` VARCHAR(10) NOT NULL,
	`salary` DECIMAL(6, 2) NOT NULL,
	`address_id` INT,
    CONSTRAINT fk_employees_departments
    FOREIGN KEY (`department_id`) REFERENCES `departments`(`id`),
	CONSTRAINT fk_employees_addresses
    FOREIGN KEY (`address_id`) REFERENCES `addresses`(`id`)
);
DROP TABLE `employees`;

INSERT INTO `towns`(`name`)
VALUES
('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

INSERT INTO `departments`(`name`)
VALUES
('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

INSERT INTO `employees`
VALUES
(1, 'Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', '3500.00', NULL),
(2, 'Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '02/03/2004', '4000.00', NULL),
(3, 'Maria', 'Petrova', 'Ivanova', 'Intern', 5, '28/08/2016', '525.25', NULL),
(4, 'Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '09/12/2007', '3000.00', NULL),
(5, 'Peter', 'Pan', 'Pan', 'Intern', 3, '28/08/2016', '599.88', NULL)
;
DROP TABLE `employees`;

#E14
SELECT * FROM `towns`;
SELECT * FROM `departments`;
SELECT * FROM `employees`;


#E15
SELECT * FROM `towns`
ORDER BY `name`;

SELECT * FROM `departments`
ORDER BY `name`;

SELECT * FROM `employees`
ORDER BY `salary` DESC;

#16
SELECT `name` FROM `towns`
ORDER BY `name`;
SELECT `name` FROM `departments`
ORDER BY `name`;
SELECT `first_name`, `last_name`, `job_title`, `salary` FROM `employees`
ORDER BY `salary` DESC;

#E17
UPDATE `employees`
SET `salary` = `salary` * 1.1;
SELECT `salary` FROM `employees`;

#E18

TRUNCATE `soft_uni`;


















