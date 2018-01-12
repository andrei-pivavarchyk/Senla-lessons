CREATE DATABASE IF NOT EXISTS hotel7;

use hotel7;



CREATE TABLE room (
`number` int NOT NULL PRIMARY KEY,
`cost` int,
`capacity` smallint,
`stars` smallint,
`status` tinyint
);


CREATE TABLE guest  (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`name` varchar(50),
`surname` varchar(50)
);


CREATE TABLE guestroominfo (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`arrivaldate` datetime,
`departuredate` datetime,
`guest` int,
`room` int,
`isstillliving` tinyint,
FOREIGN KEY(guest) REFERENCES guest(id) ON DELETE CASCADE,
FOREIGN KEY(room) REFERENCES room(number) ON DELETE CASCADE
);


CREATE TABLE service (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`name` varchar(50),
`cost` int,
`type` varchar(50)
);

CREATE TABLE guestserviceinfo(
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`guest` int,
`service` int,
`date` datetime,
FOREIGN KEY(guest) REFERENCES guest(id) ON DELETE CASCADE,
FOREIGN KEY(service) REFERENCES service(id) ON DELETE CASCADE
);
































