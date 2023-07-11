-- 1
SELECT postalZip as codigo_postal, region as region, country as pais FROM myTable;
-- 2
SELECT * FROM myTable WHERE phone LIKE '(811%';
-- 3 
SELECT * FROM myTable WHERE country IN ('Italy', 'Spain');
-- 4
SELECT COUNT(*) FROM myTable;
-- 5
SELECT country, postalZip FROM myTable;
SELECT id FROM myTable WHERE country IN ('Germany', 'Turkey');
-- 6
SELECT MAX(id) as max, MIN(id) as min FROM myTable;
-- 7
SELECT COUNT(*), country FROM myTable GROUP BY country;
-- 8
SELECT * FROM myTable ORDER BY postalZip ASC LIMIT 10;
-- 9
DELETE FROM myTable WHERE country = 'Singapore'

