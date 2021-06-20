#Ex 01

ALTER TABLE `travel_cards` AUTO_INCREMENT = 96;

INSERT INTO `travel_cards`(`card_number`, `job_during_journey`, `colonist_id`, `journey_id`) 
SELECT IF(`birth_date` > '1980-01-01', CONCAT(YEAR(`birth_date`), DAY(`birth_date`), LEFT(`ucn`,4)),
 CONCAT(YEAR(`birth_date`), MONTH(`birth_date`), RIGHT(`ucn`,4))),
IF (`id` % 2 = 0, 'Pilot', IF(`id` % 3 = 0, 'Cook','Engineer'))
,`id`, SUBSTRING(`ucn`,1,1)
FROM `colonists`
WHERE `id` >= 96 AND `id` <= 100;

SELECT * FROM travel_cards
WHERE id > 95;

CREATE TABLE ss(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` DATE,
`name2` DATE
);

INSERT INTO `ss`(`name`, `name2`)
VALUES
('1950-05-01', '1955-08-03'),
('1990-09-05', '2090-01-05');

DROP TABLE `ss`;

SELECT month(`name2`) - month(`name`) FROM `ss`
WHERE day(`name2`) - day(`name`) > 1;


#Ex 02

UPDATE `journeys` SET `purpose` = 
	CASE
		WHEN `id` % 2 = 0 THEN 'Medical'
		WHEN `id` % 3 = 0 THEN 'Technical'
		WHEN `id` % 5 = 0 THEN 'Educational'
		WHEN `id` % 7 = 0 THEN 'Military'

	END;
WHERE `id` % 2 = 0 OR `id` % 3 = 0 OR `id` % 5 = 0 OR `id` % 7 = 0;

#Ex 03

DELETE from `colonists` AS c
WHERE c.`id` NOT IN (SELECT `colonist_id` FROM `travel_cards`);

#Ex 04

SELECT `card_number`, `job_during_journey` FROM `travel_cards`
ORDER BY `card_number`;

#Ex 05

SELECT `id`, CONCAT(`first_name`, ' ', `last_name`) AS `full_name`, `ucn` 
FROM `colonists`
ORDER BY first_name, last_name, id;

#Ex 06

SELECT `id`, `journey_start`, `journey_end`
FROM `journeys`
WHERE `purpose` = 'Military'
ORDER BY journey_start;

#Ex 07

SELECT c.`id`, CONCAT(`first_name`, ' ', `last_name`) AS 'full_name'
FROM `colonists` AS c
JOIN `travel_cards` AS tc
ON c.`id` = tc.`colonist_id`
WHERE `job_during_journey` = 'Pilot'
ORDER BY c.`id`;

#Ex 08

SELECT COUNT(`journey_id`) AS 'count'
FROM `travel_cards` AS tc
JOIN `journeys` AS j
ON j.`id` = tc.`journey_id`
WHERE `purpose` = 'Technical';

#Ex 09

SELECT ss.`name` AS `spaceships_name`, sp.`name` AS `spaceport_name`
FROM `spaceships` AS ss
JOIN `journeys` AS j
ON j.`spaceship_id` = ss.`id`
JOIN `spaceports` AS sp
ON j.`destination_spaceport_id` = sp.`id`
ORDER BY ss.`light_speed_rate` DESC LIMIT 1;

#Ex 10

SELECT ss.`name`, ss.`manufacturer`
FROM `spaceships`AS ss
JOIN `journeys` AS j
ON j.`spaceship_id` = ss.`id`
JOIN `travel_cards` AS tc
ON j.`id` = tc.`journey_id`
JOIN `colonists` AS c
ON tc.`colonist_id` = c.`id`
WHERE YEAR('2019-01-01') - YEAR(c.`birth_date`) < 30 AND `job_during_journey` = 'Pilot'
ORDER BY ss.`name`;

#Ex 11

SELECT p.`name` AS 'planet_name', sp.`name` AS 'spaceport_name'
FROM `planets` AS p
JOIN `spaceports` AS sp
ON sp.`planet_id` = p.`id`
JOIN `journeys` AS j
ON j.`destination_spaceport_id` = sp.`id`
WHERE j.`purpose` = 'Educational'
ORDER BY spaceport_name DESC;

#Ex 12

SELECT p.`name` AS 'planet_name', COUNT(p.`id`) AS 'journeys_count'
FROM `planets` AS p
JOIN `spaceports` AS sp
ON sp.`planet_id` = p.`id`
JOIN `journeys` AS j
ON j.`destination_spaceport_id` = sp.`id`
WHERE sp.id = j.`destination_spaceport_id`
GROUP BY sp.`planet_id`
ORDER BY `journeys_count` DESC, `planet_name`;

#Ex 13

SELECT j.`id`, p.`name` AS 'planet_name', sp.`name` AS 'spaceport_name', j.`purpose` AS 'journey_purpose'
FROM `planets` AS p
JOIN `spaceports` AS sp
ON sp.`planet_id` = p.`id`
JOIN `journeys` AS j
ON j.`destination_spaceport_id` = sp.`id`
ORDER BY TIMESTAMPDIFF(day,`journey_start`, `journey_end`) LIMIT 1;

#Ex 14

SELECT `job_during_journey` AS 'job_name'
FROM `travel_cards` AS tc
JOIN  `journeys` AS j
ON j.`id` = tc.`journey_id`
ORDER BY datediff(`journey_end`, `journey_start`) DESC LIMIT 1;

#Ex 15

DELIMITER $$
CREATE FUNCTION udf_count_colonists_by_destination_planet(planet_name VARCHAR (30))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (
    
		SELECT COUNT(c.`id`) FROM `colonists` AS c
		JOIN `travel_cards` AS tc
		ON tc.`colonist_id` = c.`id`
		JOIN `journeys` AS j
		ON j.`id` = tc.`journey_id`
		JOIN `spaceports` AS sp
		ON sp.`id` = j.`destination_spaceport_id`
		JOIN `planets` AS p
		ON p.`id` = sp.`planet_id`
		WHERE p.`name` = planet_name  
    );
END $$
DELIMITER ;

SELECT COUNT(c.`id`) FROM `colonists` AS c
JOIN `travel_cards` AS tc
ON tc.`colonist_id` = c.`id`
JOIN `journeys` AS j
ON j.`id` = tc.`journey_id`
JOIN `spaceports` AS sp
ON sp.`id` = j.`destination_spaceport_id`
JOIN `planets` AS p
ON p.`id` = sp.`planet_id`
WHERE p.`name` = 'Otroyphus';

#Ex 16

CREATE VIEW spaceship_do_not_exist AS 'Spaceship you are trying to modify does not exists.';


DELIMITER $$
CREATE PROCEDURE udp_modify_spaceship_light_speed_rate(spaceship_name VARCHAR(50), light_speed_rate_increse INT)
BEGIN
	DECLARE specialty CONDITION FOR SQLSTATE '45000';
    IF spaceship_name = ss.`name` THEN
        SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';
    ELSE
		UPDATE `spaceships` AS ss
		SET `light_speed_rate` = `light_speed_rate` + light_speed_rate_increse
		WHERE spaceship_name = `name`;
    END IF;
END$$
DELIMITER ;

DROP PROCEDURE udp_modify_spaceship_light_speed_rate;


CALL udp_modify_spaceship_light_speed_rate ('Na Pesho koraba', 1914);
SELECT name, light_speed_rate FROM spacheships WHERE name = 'Na Pesho koraba';

UPDATE `spaceships`
SET `light_speed_rate` = `light_speed_rate` + 10
WHERE 'USS Templar' = IF(`name` IS NULL, 'Spaceship you are trying to modify does not exists.', `name`);


DELIMITER $$
CREATE PROCEDURE udp_modify_spaceship_light_speed_rate(spaceship_name VARCHAR(50), light_speed_rate_increse INT)
BEGIN

    DECLARE errorMessage VARCHAR(255);
    SET errorMessage = 'Spaceship you are trying to modify does not exists.';
                        
    IF (SELECT `name` AS 'Responce' FROM `spaceships` WHERE (spaceship_name = `name`) IS NULL) THEN
        SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = errorMessage;
    ELSE
		UPDATE `spaceships`
		SET `light_speed_rate` = `light_speed_rate` + light_speed_rate_increse;
    END if;
    
END $$
DELIMITER ;

DROP PROCEDURE udp_modify_spaceship_light_speed_rate;
CALL udp_modify_spaceship_light_speed_rate ('Na Pesho koraba', 1914);
SELECT name, light_speed_rate FROM spaceships WHERE name = 'Na Pesho koraba';

CALL udp_modify_spaceship_light_speed_rate ('USS Templar', 5);
SELECT name, light_speed_rate FROM spaceships WHERE name = 'USS Templar';

SELECT `name` AS 'Responce' FROM `spaceships` WHERE IF ('USS f' != `name`, `name` = 'Spaceship you are trying to modify does not exists.', `name`) ;









