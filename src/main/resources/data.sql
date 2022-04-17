INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100001),
       ('ADMIN', 100001),
       ('USER', 100000);

INSERT INTO restoration (name)
VALUES ('12 Стульев'),
       ('Макдональдс');

INSERT INTO dish(name, price)
VALUES ('Жульен', 100),
       ('Борщ', 200);

INSERT INTO menu (date_menu, restoration_id, dish_id)
VALUES ('2022-04-01', 100002, 100004),
       ('2022-04-01', 100003, 100005);