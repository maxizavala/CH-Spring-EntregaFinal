-- DDL **********************************************************************************

CREATE database store;

USE store;
CREATE TABLE clients (
 	id INT AUTO_INCREMENT PRIMARY KEY,
 	name VARCHAR(75) NOT NULL,
 	lastname VARCHAR(75) NOT NULL,
 	docnumber VARCHAR(11) NOT NULL
);

USE store;
CREATE TABLE products(
	id INT AUTO_INCREMENT PRIMARY KEY,
  	description VARCHAR(50),
  	code VARCHAR(50),
  	stock INT,
  	price DOUBLE
);

USE store;
CREATE TABLE invoice(
	id INT AUTO_INCREMENT PRIMARY KEY,
  	client_id INT NOT NULL,
  	created_at DATETIME,
  	total DOUBLE,
  	constraint fk_invoice_clients foreign key(client_id) references clients(id) 
);

USE store;
CREATE TABLE invoice_details(
	id INT AUTO_INCREMENT PRIMARY KEY,
  	invoice_id INT NOT NULL,
  	amount INT,
  	product_id INT NOT NULL,
  	price DOUBLE,
  	constraint fk_invoicedetails_invoice foreign key(invoice_id) references invoice(id),
  	constraint fk_invoicedetails_products foreign key(product_id) references products(id)
);

-- DML **********************************************************************************

INSERT INTO clients (name, lastname, docnumber) VALUES
('Jorge', 'Sanchez', '12345678901'),
('Laura', 'González', '23456789012'),
('Carlos', 'Ramírez', '34567890123'),
('María', 'Pérez', '45678901234'),
('Juan', 'Ortiz', '56789012345');

INSERT INTO products (description, code, stock, price) VALUES
('Lavadora Whirlpool', 'LAV001', 5, 159900),
('Nevera LG', 'NEV001', 8, 214900),
('Televisor Samsung', 'TV001', 3, 299900),
('Aspiradora Philips', 'ASP001', 12, 29900),
('Horno microondas LG', 'HOR001', 7, 53900),
('Licuadora Oster', 'LIC001', 10, 17900),
('Cafetera DeLonghi', 'CAF001', 4, 99900),
('Batidora KitchenAid', 'BAT001', 6, 39900),
('Plancha Black+Decker', 'PLA001', 15, 9900),
('Ventilador de techo', 'VEN001', 0, 29900);

INSERT INTO invoice (client_id, created_at, total) VALUES 
(1, '2023-05-01 10:00:00', 759700);

INSERT INTO invoice_details (invoice_id, amount, product_id, price) VALUES 
(1, 1, 1, 159900),
(1, 2, 3, 299900);
