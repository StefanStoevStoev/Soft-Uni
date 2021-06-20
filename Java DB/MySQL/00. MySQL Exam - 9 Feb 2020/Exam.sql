USE `fsd`;

#Ex 02

INSERT INTO `coaches`(`first_name`, `last_name`, `salary`, `coach_level`)
SELECT `first_name`, `last_name`, p.`salary` * 2 , CHAR_LENGTH(p.`first_name`)
FROM `players` AS p
WHERE p.`age` >= 45;

#Ex 03

UPDATE `coaches` AS c
JOIN `players_coaches` AS pc
ON c.`id` = pc.`coach_id`
SET `coach_level` = `coach_level` + 1
WHERE c.`first_name` LIKE 'A%' AND pc.`coach_id` = c.`id`;

#Ex 04

DELETE FROM `players`
WHERE `age` > 44;

#Ex 05

SELECT `first_name`, `age`, `salary`
FROM `players`
ORDER BY `salary` DESC;

#Ex 06

SELECT p.`id`, CONCAT(`first_name`, ' ', `last_name`) AS 'full_name', p.`age`, p.`position`, p.`hire_date`
FROM `players` AS p
JOIN `skills_data` AS sd
ON p.`skills_data_id` = sd.`id`
WHERE `position` LIKE 'A' AND `age` < 23 AND `hire_date` IS NULL AND `strength` > 50
ORDER BY `salary`, `age`;

#Ex 07

SELECT t.name, t.established, t.fan_base,
(SELECT COUNT(*)
FROM players 
WHERE team_id = t.id) AS cnt
FROM `teams` AS t 
ORDER BY cnt DESC, fan_base DESC;

#Ex 08

SELECT MAX(`speed`) AS 'max_speed', tw.`name` AS 'town_name'
FROM `skills_data` AS sd
RIGHT JOIN `players` AS p
ON sd.`id` = p.`skills_data_id`
RIGHT JOIN `teams` AS t
ON t.`id` = p.`team_id`
JOIN `stadiums` AS s
ON s.`id` = t.`stadium_id`
LEFT JOIN `towns` AS tw
ON tw.`id` = s.`town_id`
WHERE t.`name` != 'Devify'
GROUP BY `town_name`
ORDER BY `max_speed` DESC, `town_name`;

#Ex 09

SELECT c.`name`, COUNT(p.`id`) AS 'total_count_of_players', SUM(p.`salary`) AS 'total_sum_of_salaries'
FROM `players` AS p
RIGHT JOIN `teams` AS t
ON t.`id` = p.`team_id`
RIGHT JOIN  `stadiums` AS s
ON s.`id` = t.`stadium_id`
RIGHT JOIN  `towns` AS tw
ON tw.`id` = s.`town_id`
RIGHT JOIN `countries` AS c
ON c.`id` = tw.`country_id`
GROUP BY c.`name`
ORDER BY `total_count_of_players` DESC, c.`name`;

#Ex 10

DELIMITER $$
CREATE FUNCTION udf_stadium_players_count(stadium_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN(
		SELECT COUNT(p.`id`)
		FROM `players` AS p
		RIGHT JOIN `teams` AS t
		ON t.`id` = p.`team_id`
		RIGHT JOIN  `stadiums` AS s
		ON s.`id` = t.`stadium_id`
		WHERE s.`name` = stadium_name
    );
END $$
DELIMITER ;

SELECT udf_stadium_players_count ('Jaxworks') as `count`; 

#Ex 11

DELIMITER $$
CREATE PROCEDURE udp_find_playmaker(min_dribble_points INT, team_name VARCHAR(45))
BEGIN
	SELECT CONCAT(p.`first_name`, ' ', p.`last_name`) AS 'full_name',
    p.`age`, p.`salary`, sd.`dribbling`, sd.`speed`, t.`name` AS 'team_name'
    FROM `players` AS p
    JOIN `skills_data` AS sd
    ON sd.`id` = p.`skills_data_id`
    JOIN `teams` AS t
    ON p.`team_id` = t.`id`
    WHERE t.`name` = team_name AND sd.`dribbling` > min_dribble_points AND sd.`speed` > (SELECT AVG(`speed`) FROM `skills_data`)
    ORDER BY sd.`speed` DESC LIMIT 1;
    
END $$
DELIMITER ;

DROP PROCEDURE udp_find_playmaker;
CALL udp_find_playmaker (20, 'Skyble');






