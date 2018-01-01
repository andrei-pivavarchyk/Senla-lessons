create database SomeDevices;

use SomeDevices;

CREATE TABLE product (
`maker` varchar(10) ,
`model` varchar(10) PRIMARY KEY,
`type` varchar(10) 
);


CREATE TABLE pc (
`code` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`model` varchar(50) ,
`speed` smallint,
`ram` smallint,
`hd` real,
`cd` varchar(10),
`price` int,
FOREIGN KEY(model) REFERENCES product(model)
);


CREATE TABLE laptop(
`code` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`model` varchar(50),
`speed` smallint,
`ram` smallint,
`hd` real,
`price` int,
`screen` tinyint,
FOREIGN KEY(model) REFERENCES product(model)
);


CREATE TABLE printer(
`code` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`model` varchar(50),
`color` char(1),
`type` varchar(10),
`price` int,
FOREIGN KEY(model) REFERENCES product(model)

);
