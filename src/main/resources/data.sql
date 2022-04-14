INSERT INTO restoration (name)
VALUES ('12 Стульев'),
       ('Макдональдс');

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100003),
       ('ADMIN', 100003),
       ('USER', 100002);

INSERT INTO dish(restoration_id, name, price)
VALUES (100000, 'Жульен', 100),
       (100001, 'Борщ', 200)


