# Lab 01

SELECT `title` 
FROM `books`
WHERE substr(`title`, 1, 3)  = 'The';

# Lab 02

SELECT REPLACE(`title`, 'The', '***') AS 'title'
FROM `books`
where substring(title, 1, 3) = 'The'
ORDER BY `id`;


# Lab 03

SELECT ROUND(SUM(`cost`),2) 
AS `SUM` 
FROM `books`;

# Lab3 04

SELECT concat_ws(' ', `first_name`, `last_name`) AS `Full Name`,
TIMESTAMPDIFF(day, `born`, `died`) AS `Days Lived`
FROM `authors`;

#Lab3 05

SELECT `title`
FROM `books`
WHERE `title` LIKE "Harry Potter %";
