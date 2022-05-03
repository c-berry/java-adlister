CREATE DATABASE IF NOT EXISTS adlister_db;

CREATE USER IF NOT EXISTS 'adlister_user'@'localhost' IDENTIFIED BY 'password';

SELECT user, host FROM mysql.user;

GRANT ALL ON adlister_db.* TO 'adlister_user'@'localhost';

USE adlister_db;

# DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users
(
#       unsigned,NOT SIGNED , no negative values!
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username          VARCHAR(50)  NOT NULL,
    email         VARCHAR(100),
    password        VARCHAR(50),
    PRIMARY KEY (id)
);

# DROP TABLE IF EXISTS ads;
CREATE TABLE IF NOT EXISTS ads
(
#       unsigned,NOT SIGNED , no negative values!
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id           int unsigned NOT NULL,
    title         VARCHAR(100),
    description        TEXT,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

SHOW TABLES;

SELECT * FROM users;
SELECT * FROM ads;

