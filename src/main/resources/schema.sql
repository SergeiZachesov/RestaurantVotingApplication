DROP TABLE user_roles IF EXISTS;
DROP TABLE voice IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE dish IF EXISTS;
DROP TABLE menu IF EXISTS;
DROP TABLE restoration IF EXISTS;

DROP SEQUENCE global_seq IF EXISTS;

CREATE SEQUENCE global_seq START WITH 100000 INCREMENT BY 1;

CREATE TABLE users
(
    id       INTEGER DEFAULT nextval('global_seq') PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR(255),
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restoration
(
    id   INTEGER DEFAULT nextval('global_seq') PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE dish
(
    id    INTEGER DEFAULT nextval('global_seq') PRIMARY KEY,
    name  VARCHAR(255) NOT NULL,
    price DOUBLE       NOT NULL
);

CREATE TABLE menu
(
    id             INTEGER DEFAULT nextval('global_seq') PRIMARY KEY,
    date_menu      DATE    NOT NULL,
    restoration_id INTEGER NOT NULL,
    dish_id        INTEGER NOT NULL,
    FOREIGN KEY (restoration_id) REFERENCES restoration (id) ON DELETE CASCADE,
    FOREIGN KEY (dish_id) REFERENCES dish (id) ON DELETE CASCADE,
    CONSTRAINT restoration_dish_date UNIQUE (restoration_id, dish_id, date_menu)
);

CREATE TABLE voice
(
    id             INTEGER DEFAULT nextval('global_seq') PRIMARY KEY,
    user_id        INTEGER   NOT NULL,
    restoration_id INTEGER   NOT NULL,
    date_time      TIMESTAMP NOT NULL,
    CONSTRAINT user_date_time UNIQUE (user_id, date_time),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (restoration_id) REFERENCES restoration (id)
);