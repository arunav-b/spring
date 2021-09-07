DROP TABLE PLAYER IF EXISTS ;
CREATE TABLE Player
(
    ID          INTEGER      NOT NULL,
    Name        VARCHAR(255) NOT NULL,
    Nationality VARCHAR(255) NOT NULL,
    Birth_date  TIMESTAMP,
    Titles      INTEGER,
    PRIMARY KEY (ID)
);

DROP TABLE ITEM IF EXISTS ;
CREATE TABLE Item
(
    ID       INTEGER        NOT NULL,
    Name     VARCHAR(255)   NOT NULL,
    Price    DECIMAL(16, 4) NOT NULL,
    Quantity INTEGER,
    PRIMARY KEY (ID)
);