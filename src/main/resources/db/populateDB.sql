DELETE FROM user_roles;
DELETE FROM products;
DELETE FROM users;
DELETE FROM orders;
DELETE FROM order_products;
DELETE FROM lightShows;
DELETE FROM lightShow_effect_time_start;
DELETE FROM lightShow_devices;
DELETE FROM devices;
DELETE FROM leds;
DELETE FROM effects;
DELETE FROM effect_beginLedList;
DELETE FROM effect_endLedList;
DELETE FROM audios;

ALTER SEQUENCE global_seq RESTART WITH 10;

-- user
INSERT INTO users (name, email, password, firstName, LastName, address)
VALUES ('Юзер', 'user@yandex.ru', 'pass', 'Имя', 'Фамилия', 'адрес');

-- admin
INSERT INTO users (name, email, password, firstName, LastName, address)
VALUES ('Admin', 'admin@yandex.ru', 'pass', 'Имя', 'Фамилия', 'адрес');

INSERT INTO users (name, email, password, firstName, LastName, address)
VALUES ('Delete', 'delete@yandex.ru', 'pass', 'Имя', 'Фамилия', 'адрес');

INSERT INTO user_roles (user_id, role) VALUES
  (10, 'ROLE_USER'),
  (11, 'ROLE_USER'),
  (11, 'ROLE_ADMIN'),
  (12, 'ROLE_USER');

INSERT INTO products (name, description, price, discount, maxLed) VALUES
  ('ELECTRON_SUN_8_8', 'светодиодная матрица 8*8', 250, 5, 64),
  ('ELECTRON_SUN_32_32', 'светодиодная матрица 32*32', 2500, 8, 1024),
  ('deleteTest', 'test', 2502, 8, 1024); -- 15

INSERT INTO orders (user_id, statusOrder) VALUES
  (10, 'PENDING_PAYMENT'),
  (11, 'PENDING'); --17

INSERT INTO order_products (order_id, product_id, number) VALUES
  (16, 13, 1),
  (17, 14, 2);

INSERT INTO audios (name, path) VALUES
  ('test', 'd:\\test.mp3'),
  ('testDelete', 'd:\\delete.mp3');--19

INSERT INTO devices (product_id, maxLed, user_id) VALUES
  (13, 64, 10),
  (14, 64, 11);

INSERT INTO lightshows (name, user_id, time) VALUES
  ('test',10,1000),
  ('testDelete',10,1002); -- id 23

INSERT INTO effects (name, commonTime, lightShow_id) VALUES
  ('test', 200, 22),
  ('testDelete', 210, 23); -- id 25

INSERT INTO leds (r, g, b, number, effect_id) VALUES
  (200, 0, 22, 1,24),
  (0, 250, 22, 2,25); -- id 27

INSERT INTO lightShow_devices (lightShow_id, device_id) VALUES
  (23, 21);



