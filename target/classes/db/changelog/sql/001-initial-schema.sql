CREATE TABLE IF NOT EXISTS products (
    product_id  SERIAL PRIMARY KEY,
    name        VARCHAR(150) NOT NULL,
    description TEXT,
    price       DECIMAL(10,2) NOT NULL CHECK (price >= 0),
    stock_qty   INT NOT NULL CHECK (stock_qty >= 0) DEFAULT 0,
    created_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP,
    is_deleted  BOOLEAN NOT NULL DEFAULT FALSE
);

INSERT INTO products (name, description, price, stock_qty)
VALUES
('Wireless Mouse', 'Ergonomic wireless mouse with USB receiver', 1499.99, 50),
('Mechanical Keyboard', 'RGB backlit mechanical keyboard with blue switches', 8999.50, 30),
('Gaming Headset', 'Noise-cancelling gaming headset with microphone', 5999.00, 20),
('USB-C Charger', 'Fast charging 25W USB-C charger', 1999.00, 100),
('Laptop Stand', 'Adjustable aluminum laptop stand', 2999.99, 40);
