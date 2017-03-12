DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS order_products CASCADE;
DROP TABLE IF EXISTS lightshows CASCADE;
DROP TABLE IF EXISTS lightshow_remixes CASCADE;
DROP TABLE IF EXISTS lightshow_devices CASCADE;
DROP TABLE IF EXISTS effects CASCADE;
DROP TABLE IF EXISTS effects_timestart CASCADE;
DROP TABLE IF EXISTS devices CASCADE;
DROP TABLE IF EXISTS leds CASCADE;
DROP TABLE IF EXISTS eventeffect CASCADE;
DROP TABLE IF EXISTS audios;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 10;


CREATE TABLE users
(
  id         int8 PRIMARY KEY DEFAULT nextval('global_seq'),
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
  user_id int8 NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE products (
  id              int8 PRIMARY KEY DEFAULT nextval('global_seq'),
  name            VARCHAR NOT NULL UNIQUE,
  description     TEXT,
  price           DOUBLE PRECISION NOT NULL,
  discount        INTEGER DEFAULT 0,
  discount_price  DOUBLE PRECISION DEFAULT 0,
  maxLed          INTEGER NOT NULL
);

CREATE TABLE orders (
  id          int8 PRIMARY KEY DEFAULT nextval('global_seq'),
  registered  TIMESTAMP DEFAULT now(),
  user_id     int8 REFERENCES users (id) ON DELETE CASCADE,
  paid        BOOL DEFAULT FALSE,
  statusOrder VARCHAR
);

CREATE TABLE order_products (
  order_id    int8 NOT NULL,
  product_id  int8 NOT NULL,
  number      INTEGER,
  UNIQUE (order_id, product_id),
  FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE,
  FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE
);

CREATE TABLE devices (
  id             int8 PRIMARY KEY DEFAULT nextval('global_seq'),
  product_id     int8 REFERENCES products (id) ON DELETE CASCADE,
  description    TEXT,
  maxLed         INTEGER NOT NULL,
  enabled        BOOL DEFAULT FALSE,
  uuid           UUID UNIQUE,
  user_id        int8 REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE audios(
  id             int8 PRIMARY KEY DEFAULT nextval('global_seq'),
  name           VARCHAR NOT NULL,
  path           VARCHAR NOT NULL
);


CREATE TABLE lightshows (
  id                  int8 PRIMARY KEY DEFAULT nextval('global_seq'),
  name                VARCHAR NOT NULL,
  counteffect         INT DEFAULT 0,
  user_id             int8 NOT NULL,
  lightshow_remix_id  int8,
  time                INTEGER NOT NULL,
  audio_id            int8 REFERENCES audios (id),
  public              BOOL DEFAULT FALSE,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE lightshow_remixes (
  lightshow_id   int8 NOT NULL,
  remixid        int8 NOT NULL,
  FOREIGN KEY (lightshow_id) REFERENCES lightshows (id) ON DELETE CASCADE
);

CREATE TABLE lightshow_devices (
  lightshow_id   int8 NOT NULL,
  devices_id      int8 NOT NULL,
  FOREIGN KEY (lightshow_id) REFERENCES lightshows (id) ON DELETE CASCADE,
  FOREIGN KEY (devices_id) REFERENCES devices (id) ON DELETE CASCADE
);

CREATE TABLE effects(
  id                  int8 PRIMARY KEY DEFAULT nextval('global_seq'),
  name                VARCHAR NOT NULL,
  counteventeffect    INT DEFAULT 0,
  colortext           VARCHAR,
  colorbackground     VARCHAR,
  track               INT DEFAULT 0,
  lightshow_id        int8 NOT NULL,
  user_id             int8 NOT NULL,
  FOREIGN KEY (lightshow_id) REFERENCES lightshows (id) ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE effects_timestart (
  effect_id      int8 NOT NULL,
  timestart      INT DEFAULT 0,
  FOREIGN KEY (effect_id) REFERENCES effects (id) ON DELETE CASCADE
);

CREATE TABLE eventeffect(
  id                  int8 PRIMARY KEY DEFAULT nextval('global_seq'),
  numberofeffect      INT NOT NULL,
  color               VARCHAR NOT NULL,
  countLed            INT DEFAULT 0,
  appearance          INT DEFAULT 0,
  glow                INT,
  brightness          INT DEFAULT 100,
  newcolor            BOOL DEFAULT FALSE,
  newcolorled         VARCHAR,
  transition          INT DEFAULT 0,
  attenuation         INT DEFAULT 0,
  pause               INT DEFAULT 0,
  effects_id          int8,
  FOREIGN KEY (effects_id) REFERENCES effects (id) ON DELETE CASCADE
);

CREATE TABLE leds(
  id                int8 PRIMARY KEY DEFAULT nextval('global_seq'),
  r                 INTEGER CHECK (r >= 0) CHECK (r < 256),
  g                 INTEGER CHECK (g >= 0) CHECK (g < 256),
  b                 INTEGER CHECK (b >= 0) CHECK (b < 256),
  enabled           BOOL DEFAULT FALSE,
  number            INTEGER NOT NULL,
  eventeffect_id    int8,
  FOREIGN KEY (eventeffect_id) REFERENCES eventeffect (id) ON DELETE CASCADE
);



