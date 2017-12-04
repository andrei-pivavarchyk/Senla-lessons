create database hotel;

use hotel;

CREATE TABLE room (
`number` int NOT NULL PRIMARY KEY,
`cost` int,
`capacity` smallint,
`stars` smallint
);


CREATE TABLE guest (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`name` varchar(50),
`surname` varchar(50)
);


CREATE TABLE guestroominfo(
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`arrivaldate` date,
`departuredate` date,
`guest` int,
`room` int,
`isstillliving` boolean,
FOREIGN KEY(guest) REFERENCES guest(id),
FOREIGN KEY(room) REFERENCES room(number)
);


CREATE TABLE service (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`name` varchar(50),
`cost` int,
`type` varchar(50)
);

CREATE TABLE guestserviceinfo(
`guest` int,
`service` int,
`date` date,
FOREIGN KEY(guest) REFERENCES guest(id),
FOREIGN KEY(service) REFERENCES service(id)
);