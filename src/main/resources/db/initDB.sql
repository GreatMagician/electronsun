DROP TABLE IF EXISTS effect_time_start CASCADE;
DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS order_products CASCADE;
DROP TABLE IF EXISTS lightShows CASCADE;
DROP TABLE IF EXISTS devices CASCADE;
DROP TABLE IF EXISTS leds CASCADE;
DROP TABLE IF EXISTS effects CASCADE;
DROP TABLE IF EXISTS effect_beginLedList CASCADE;
DROP TABLE IF EXISTS effect_endLedList CASCADE;
DROP TABLE IF EXISTS audios;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 10;


CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL UNIQUE,
  email      VARCHAR NOT NULL UNIQUE,
  password   VARCHAR NOT NULL,
  registered TIMESTAMP DEFAULT now(),
  enabled    BOOL DEFAULT TRUE,
  firstName  VARCHAR,
  LastName   VARCHAR,
  address    VARCHAR,
  deleted    BOOL DEFAULT FALSE
);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE products (
  id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name            VARCHAR NOT NULL UNIQUE,
  description     TEXT,
  price           MONEY NOT NULL,
  discount        INTEGER,
  discount_price  MONEY,
  maxLed          INTEGER NOT NULL
);

CREATE TABLE orders (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  registered  TIMESTAMP DEFAULT now(),
  user_id     integer REFERENCES users (id),
  paid        BOOL DEFAULT FALSE,
  statusOrder VARCHAR
);

CREATE TABLE order_products (
  order_id    INTEGER NOT NULL,
  product_id  INTEGER NOT NULL,
  number      INTEGER,
  UNIQUE (order_id, product_id),
  FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE,
  FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE
);

CREATE TABLE devices (
  id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  product_id     INTEGER REFERENCES products (id),
  maxLed         INTEGER NOT NULL,
  enabled        BOOL DEFAULT FALSE,
  uuid           UUID,
  user_id        INTEGER REFERENCES users (id)
);

CREATE TABLE audios(
  id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name           VARCHAR NOT NULL,
  path           VARCHAR NOT NULL
);


CREATE TABLE lightShows (
  id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name           VARCHAR NOT NULL,
  device_id      INTEGER REFERENCES devices (id),
  user_id        INTEGER REFERENCES users (id),
  remix_user_id  INTEGER REFERENCES users (id),
  time           INTEGER NOT NULL,
  audio_id       INTEGER REFERENCES audios (id)
);

CREATE TABLE effects(
  id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name           VARCHAR NOT NULL,
  commonTime     INTEGER NOT NULL,
  attenuation    BOOL DEFAULT FALSE,
  appearance     BOOL DEFAULT FALSE,
  lightShow_id   INTEGER REFERENCES lightShows (id),
  FOREIGN KEY (lightShow_id) REFERENCES lightShows (id) ON DELETE CASCADE
);

CREATE TABLE effect_time_start (
  lightShow_id   INTEGER REFERENCES lightShows (id),
  effect_id      INTEGER REFERENCES effects (id),
  time           INTEGER NOT NULL,
  FOREIGN KEY (lightShow_id) REFERENCES lightShows (id) ON DELETE CASCADE,
  FOREIGN KEY (effect_id) REFERENCES effects (id) ON DELETE CASCADE
);


CREATE TABLE leds(
  id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  r              BYTEA,
  g              BYTEA,
  b              BYTEA,
  enabled        BOOL DEFAULT FALSE,
  number         INTEGER NOT NULL,
  effect_id      INTEGER REFERENCES effects (id),
  FOREIGN KEY (effect_id) REFERENCES effects (id) ON DELETE CASCADE
);


CREATE TABLE effect_beginLedList(
  effect_id      INTEGER REFERENCES effects (id),
  led_id         INTEGER REFERENCES leds (id),
  FOREIGN KEY (effect_id) REFERENCES effects (id) ON DELETE CASCADE
);

CREATE TABLE effect_endLedList(
  effect_id      INTEGER REFERENCES effects (id),
  led_id         INTEGER REFERENCES leds (id),
  FOREIGN KEY (effect_id) REFERENCES effects (id) ON DELETE CASCADE
);

