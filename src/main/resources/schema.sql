CREATE DATABASE demo
  DEFAULT CHARSET = UTF8;

USE demo;

CREATE TABLE user (
  id       INT         NOT NULL AUTO_INCREMENT,
  name     VARCHAR(20) NOT NULL,
  birthday TIMESTAMP   NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE landlord (
  id     INT NOT NULL AUTO_INCREMENT,
  userId INT NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE tenant (
  id     INT NOT NULL AUTO_INCREMENT,
  userId INT NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE house (
  id         INT          NOT NULL AUTO_INCREMENT,
  landlordId INT          NOT NULL,
  name       VARCHAR(30)  NOT NULL,
  area       DOUBLE(8, 2) NOT NULL,
  rooms      INT          NOT NULL,
  buildTime  DATETIME,
  rentState  VARCHAR(20)  NOT NULL,
  used       BOOLEAN      NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE room (
  id      INT          NOT NULL AUTO_INCREMENT,
  houseId INT          NOT NULL,
  name    VARCHAR(30)  NOT NULL,
  area    DOUBLE(8, 2) NOT NULL,
  used    BOOLEAN      NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE feeref (
  id       INT          NOT NULL AUTO_INCREMENT,
  gridId   INT          NOT NULL,
  gridType VARCHAR(20)  NOT NULL,
  feeType  VARCHAR(20)  NOT NULL,
  calcType VARCHAR(20)  NOT NULL,
  price    DOUBLE(8, 2) NOT NULL,
  unit     VARCHAR(12)  NOT NULL,
  begin    TIMESTAMP    NOT NULL,
  end      TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE feecount (
  id      INT           NOT NULL AUTO_INCREMENT,
  houseId INT           NOT NULL,
  feeType VARCHAR(20)   NOT NULL,
  ruling  DOUBLE(10, 2) NOT NULL,
  date    TIMESTAMP     NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE orders (
  id       INT         NOT NULL AUTO_INCREMENT,
  orderNo  VARCHAR(30) NOT NULL,
  houseId  INT         NOT NULL,
  tenantId INT         NOT NULL,
  gridType VARCHAR(20) NOT NULL,
  begin    TIMESTAMP   NOT NULL,
  end      TIMESTAMP   NOT NULL,
  happen   TIMESTAMP   NOT NULL,
  status   VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE orderdetail (
  id      INT     NOT NULL AUTO_INCREMENT,
  orderId INT(30) NOT NULL,
  roomId  INT     NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

INSERT INTO user (name, birthday) VALUES
  ('zsy', '1985-11-24'),
  ('cjj', '1985-03-12'),
  ('crg', '1984-10-08');



