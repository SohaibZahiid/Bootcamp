-- 1
DROP DATABASE IF EXISTS db_ejs;
CREATE DATABASE IF NOT EXISTS db_ejs;
USE db_ejs;


CREATE TABLE IF NOT EXISTS customer (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45),
    city VARCHAR(45),
    grade INT
);

CREATE TABLE IF NOT EXISTS salesman (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45),
    city VARCHAR(45),
    commission DECIMAL
);

CREATE TABLE IF NOT EXISTS orders (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    amt DECIMAL,
    order_date DATE,
    customer_id INT UNSIGNED,
    salesman_id INT UNSIGNED,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (salesman_id) REFERENCES salesman(id)
);

-- 2
-- Inserts for the 'customer' table
INSERT INTO customer (name, city, grade) VALUES
('John Doe', 'New York', 1),
('Jane Smith', 'Los Angeles', 2),
('Michael Johnson', 'Chicago', 3),
('Emily Davis', 'Houston', 2),
('Daniel Wilson', 'Miami', 1),
('Olivia Thompson', 'San Francisco', 3),
('James Anderson', 'Seattle', 2),
('Sophia Martinez', 'Boston', 1),
('William Clark', 'Dallas', 3),
('Ava Rodriguez', 'Atlanta', 2);

-- Inserts for the 'salesman' table
INSERT INTO salesman (name, city, commission) VALUES
('Robert Brown', 'New York', 0.1),
('Emma Taylor', 'Los Angeles', 0.15),
('Joseph Davis', 'Chicago', 0.12),
('Isabella Thomas', 'Houston', 0.08),
('David Lee', 'Miami', 0.1),
('Sophia Lewis', 'San Francisco', 0.12),
('Matthew Harris', 'Seattle', 0.09),
('Olivia Walker', 'Boston', 0.11),
('Alexander King', 'Dallas', 0.07),
('Mia Green', 'Atlanta', 0.1);

-- Inserts for the 'orders' table
INSERT INTO orders (amt, order_date, customer_id, salesman_id) VALUES
(1000.00, '2023-07-01', 1, 1),
(2500.00, '2023-07-02', 2, 2),
(1800.00, '2023-07-03', 3, 3),
(3000.00, '2023-07-04', 4, 4),
(1500.00, '2023-07-05', 5, 5),
(2200.00, '2023-07-06', 6, 6),
(1700.00, '2023-07-07', 7, 7),
(2800.00, '2023-07-08', 8, 8),
(1900.00, '2023-07-09', 9, 9),
(3200.00, '2023-07-10', 10, 10);

-- 3 
SELECT COUNT(*) FROM orders;
-- 4
SELECT DISTINCT * FROM customer;
-- 5 
SELECT * FROM orders ord
INNER JOIN salesman sale ORDER BY ord.order_date DESC;
-- 6
SELECT * FROM customer ORDER BY id LIMIT 5;
-- 7
SELECT MIN(amt) FROM orders;
-- 8
SELECT MAX(amt) FROM orders;

