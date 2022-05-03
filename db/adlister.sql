CREATE DATABASE IF NOT EXISTS adlister_db;

CREATE USER IF NOT EXISTS 'adlister_user'@'localhost' IDENTIFIED BY 'password';

SELECT user, host FROM mysql.user;

GRANT ALL ON adlister_db.* TO 'adlister_user'@'localhost';

USE adlister_db;

DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users
(
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username          VARCHAR(50)  NOT NULL,
    email         VARCHAR(100),
    password        VARCHAR(50),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS ads;
CREATE TABLE IF NOT EXISTS ads
(
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT,
    userId           INT UNSIGNED NOT NULL,
    title         VARCHAR(100),
    description        VARCHAR(500),
    PRIMARY KEY (id),
    FOREIGN KEY (userId) REFERENCES users (id)
);

SHOW TABLES;

SELECT * FROM users;
SELECT * FROM ads;

INSERT INTO users(username, email, password) VALUES ('Moe', 'moe@email.com', 'password');