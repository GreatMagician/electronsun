-- http://stackoverflow.com/questions/13223820/postgresql-delete-all-content
-- TRUNCATE public CASCADE;

-- http://stackoverflow.com/a/4991969/548473
-- TRUNCATE SCHEMA public AND COMMIT;

DELETE FROM user_roles;
DELETE FROM users;


-- admin
INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'pass';


INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),

