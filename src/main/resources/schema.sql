DROP TABLE user_roles IF EXISTS;
DROP TABLE dish IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE restoration IF EXISTS;
DROP SEQUENCE global_seq IF EXISTS;

CREATE SEQUENCE global_seq START WITH 100000 INCREMENT BY 1;

CREATE TABLE restoration
(
    id   INTEGER DEFAULT nextval('global_seq') PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE users
(
    id             INTEGER DEFAULT nextval('global_seq') PRIMARY KEY,
    name           VARCHAR(255) NOT NULL,
    email          VARCHAR(255) NOT NULL,
    password       VARCHAR(255) NOT NULL,
    restoration_id INTEGER,
    FOREIGN KEY (restoration_id) REFERENCES restoration (id)
);

CREATE UNIQUE INDEX users_unique_email_idx ON USERS (email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR(255),
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE dish
(
    id             INTEGER DEFAULT nextval('global_seq') PRIMARY KEY,
    restoration_id INTEGER      NOT NULL,
    name           VARCHAR(255) NOT NULL,
    price          DOUBLE       NOT NULL,
    CONSTRAINT restoration_dish_id UNIQUE (restoration_id, id),
    FOREIGN KEY (restoration_id) REFERENCES restoration (id) ON DELETE CASCADE
)