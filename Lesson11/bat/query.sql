CREATE DATABASE IF NOT EXISTS hotel4;

use hotel4;



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
`arrivaldate` timestamp,
`departuredate` timestamp,
`guest` int,
`room` int,
`isstillliving` tinyint,
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

INSERT INTO room ( number,cost,capacity,stars,status ) VALUES
( 1,20,3,5,1),
( 2,30,2,4,1),
( 3,40,1,3,1),
( 4,50,4,4,1),
( 5,60,5,3,1);



INSERT INTO service ( name, cost,type ) VALUES
( 'spa',20,'SPA'),
( 'pelmeni',20,'EAT'),
( 'pizza',20,'EAT'),
( 'telek',20,'SPA'),
( 'cola',20,'EAT');



INSERT INTO guest( name, surname ) VALUES
( 'bob','white'),
( 'jack','black'),
( 'alice','red'),
( 'grag','yellow');





































