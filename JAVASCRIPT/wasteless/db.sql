-- Drop the table if it exists (optional, use it if you want to start fresh)
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS products;

-- Create the "users" table
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL
);

-- Insert sample data into the "users" table
INSERT INTO users (name, email, password, address)
VALUES ('Condis', 'condis@example.com', 'password1', 'Av. del Carrilet, 72');

INSERT INTO users (name, email, password, address)
VALUES ('Mercadona', 'mercadona@example.com', 'password2', 'Av. del Carrilet, 67');

INSERT INTO users (name, email, password, address)
VALUES ('Sohaib', 'sohaib@example.com', 'password3', 'Ronda de la Torrassa, 112');


CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,

    CONSTRAINT fk_user_id
    FOREIGN KEY (user_id)
    REFERENCES users(id)
);

INSERT INTO products (user_id, name, description, quantity, price)
VALUES
    -- User 1 products
    (1, 'Pizza', 'Delicious cheese pizza', 2, 12.99),
    (1, 'Burger', 'Juicy beef burger', 3, 8.50),
    (1, 'Salad', 'Fresh vegetable salad', 4, 5.99),
    (1, 'Soup', 'Creamy tomato soup', 2, 6.50),

    -- User 2 products
    (2, 'Pasta', 'Classic Italian pasta', 2, 10.99),
    (2, 'Steak', 'Tender grilled steak', 1, 20.50),
    (2, 'Ice Cream', 'Assorted ice cream flavors', 4, 0),

    -- User 3 products
    (3, 'Sushi', 'Assorted sushi rolls', 12, 18.99),
    (3, 'Ramen', 'Traditional Japanese ramen', 3, 11.50),
    (3, 'Tempura', 'Crispy vegetable tempura', 6, 8.99),
    (3, 'Green Tea', 'Refreshing green tea', 1, 0);

SELECT * FROM users;
SELECT * FROM products;

SELECT p.name AS product_name, p.description AS product_description,
       p.quantity AS product_quantity, p.price AS product_price,
       u.name AS store_name, u.address AS store_address
FROM products p
JOIN users u ON p.user_id = u.id;