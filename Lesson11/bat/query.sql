CREATE DATABASE IF NOT EXISTS hotel4;

use hotel4;



CREATE TABLE room (
`number` int NOT NULL PRIMARY KEY,
`cost` int,
`capacity` smallint,
`stars` smallint
);


CREATE TABLE guest  (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`name` varchar(50),
`surname` varchar(50)
);


CREATE TABLE guestroominfo (
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`arrivaldate` timestamp,
`departuredate` timestamp,
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
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`guest` int,
`service` int,
`date` timestamp,
FOREIGN KEY(guest) REFERENCES guest(id),
FOREIGN KEY(service) REFERENCES service(id)
);

INSERT INTO room ( number,cost,capacity,stars ) VALUES
( 1,20,3,5),
( 2,30,2,4),
( 3,40,1,3),
( 4,50,4,4),
( 5,60,5,3);



INSERT INTO service ( name, cost,type ) VALUES
( 'spa',20,'SPA'),
( 'pelmeni',20,'EAT'),
( 'pizza',20,'EAT'),
( 'telek',20,'SPA'),
( 'cola',20,'EAT');


