DELETE FROM user_roles;
DELETE FROM products;
DELETE FROM users;
DELETE FROM orders;
DELETE FROM order_products;
DELETE FROM lightShows;
DELETE FROM effect_time_start;
DELETE FROM devices;
DELETE FROM leds;
DELETE FROM effects;
DELETE FROM effect_beginLedList;
DELETE FROM effect_endLedList;
DELETE FROM audios;

ALTER SEQUENCE global_seq RESTART WITH 10;

-- user
INSERT INTO users (name, email, password, firstName, LastName, address)
VALUES ('User', 'user@yandex.ru', 'pass', 'Имя', 'Фамилия', 'адрес');

-- admin
INSERT INTO users (name, email, password, firstName, LastName, address)
VALUES ('Admin', 'admin@yandex.ru', 'pass', 'Имя', 'Фамилия', 'адрес');

INSERT INTO user_roles (user_id, role) VALUES
  (10, 'ROLE_USER'),
  (11, 'ROLE_USER'),
  (11, 'ROLE_ADMIN');

INSERT INTO products (name, description, price, discount, maxLed) VALUES
  ('ELECTRON_SUN_8_8', 'светодиодная матрица 8*8', 250, 5, 64),
  ('ELECTRON_SUN_32_32', 'светодиодная матрица 32*32', 2500, 8, 1024);

INSERT INTO orders (user_id, statusOrder) VALUES
  (10, 'PENDING_PAYMENT');

INSERT INTO order_products (order_id, product_id, number) VALUES
  (14, 12, 1);

-- INSERT INTO lightShows (name, device_id, user_id, time) VALUES
--   ('шоу', 10, 10);






