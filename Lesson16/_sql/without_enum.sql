
CREATE DATABASE IF NOT EXISTS webapp;

use webapp;

CREATE TABLE `user` (
	`id` int NOT NULL AUTO_INCREMENT,
	`login` TEXT(100) NOT NULL,
	`password` TEXT(100) NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE `user_data` (
	`id` int NOT NULL AUTO_INCREMENT,
	`user_id` int NOT NULL,
	`name` varchar(20) ,
	`surname` varchar(20) ,
	`patronymic` varchar(20) ,
	`date_of_birth` DATE,
	`email` varchar(32),
	`role` int NOT NULL,
	`address` TEXT ,
	PRIMARY KEY (`id`)
);

CREATE TABLE `book` (
	`id` int NOT NULL AUTO_INCREMENT,
	`book_name` varchar(50) NOT NULL,
	`book_genre` int,
	`author` int ,
	`book_cost` int ,
	`book_status` int ,
	`book_description` int ,
	PRIMARY KEY (`id`)
);


CREATE TABLE `order` (
	`id` int NOT NULL AUTO_INCREMENT,
	`user_id` int NOT NULL,
	`book_id` int NOT NULL,
	`book_cost` int NOT NULL,
	`order_status` int NOT NULL,
	`creation_date` DATE NOT NULL,
	 PRIMARY KEY (`id`)
);



CREATE TABLE `author` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(32) NOT NULL,
	`surname` varchar(32) NOT NULL,
	`patronymic` varchar(20),
	`date_of_birth` DATE ,
	 PRIMARY KEY (`id`)
);

CREATE TABLE `book_description` (
	`id` int NOT NULL AUTO_INCREMENT,
	`description` TEXT NOT NULL,
	PRIMARY KEY (`id`)
);


ALTER TABLE `user_data` ADD CONSTRAINT `user_data_fk0` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON DELETE CASCADE;

ALTER TABLE `order` ADD CONSTRAINT `order_fk0` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);

ALTER TABLE `order` ADD CONSTRAINT `order_fk1` FOREIGN KEY (`book_id`) REFERENCES `book`(`id`);

ALTER TABLE `book` ADD CONSTRAINT `book_fk1` FOREIGN KEY (`author`) REFERENCES `author`(`id`);

ALTER TABLE `book` ADD CONSTRAINT `book_fk3` FOREIGN KEY (`book_description`) REFERENCES `book_description`(`id`);





INSERT INTO `webapp`.`user` (`id`, `login`, `password`) VALUES ('1', 's', 's');

