create database webapp;
use webapp;

CREATE TABLE `user` (
	`id` int NOT NULL AUTO_INCREMENT,
	`login` varchar(100) NOT NULL,
	`password` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `user_data` (
	`id` int NOT NULL AUTO_INCREMENT,
	`role` int NOT NULL,
	`name` varchar(20) NOT NULL,
	`surname` varchar(20) NOT NULL,
	`patronymic` varchar(20) NOT NULL,
	`date_of_birth` DATE NOT NULL,
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

CREATE TABLE `book` (
	`id` int NOT NULL AUTO_INCREMENT,
	`book_name` varchar(30) NOT NULL,
	`book_genre` int NOT NULL,
	`author` int NOT NULL,
	`book_cost` int NOT NULL,
	`book_status` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `author` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	`surname` varchar(50) NOT NULL,
	`patronymic` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `book_description` (
	`id` int NOT NULL AUTO_INCREMENT,
	`title` varchar(20) NOT NULL,
	`description` varchar(30) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `genre` (
	`id` int NOT NULL AUTO_INCREMENT,
	`genre` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `user_address` (
	`id` int NOT NULL AUTO_INCREMENT,
    `user` int NOT NULL,
	`street` varchar(20) NOT NULL,
	`city` varchar(20) ,
	`region` varchar(20) NOT NULL,
	`country` varchar(20) NOT NULL,
	`index` int(30) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `recall` (
	`id` int NOT NULL AUTO_INCREMENT,
	`book` int NOT NULL,
	`recall` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `shop_contact` (
	`id` int NOT NULL AUTO_INCREMENT,
	`phone` int NOT NULL,
	`shop_address` int,
	PRIMARY KEY (`id`)
);

CREATE TABLE `shop_data` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(30) NOT NULL,
	 PRIMARY KEY (`id`)
);

CREATE TABLE `user_contact` (
	`id` int NOT NULL AUTO_INCREMENT,
	`email` varchar(60) NOT NULL,
	`phone` int(30) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `shop_address` (
	`id` int NOT NULL AUTO_INCREMENT,
	`street` varchar(30) NOT NULL,
	`city` varchar(30) NOT NULL,
	`region` varchar(30) NOT NULL,
	`country` varchar(30) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `user` ADD CONSTRAINT `user_fk0` FOREIGN KEY (`id`) REFERENCES `user_data`(`id`);

ALTER TABLE `user_data` ADD CONSTRAINT `user_data_fk0` FOREIGN KEY (`id`) REFERENCES `user_contact`(`id`);



ALTER TABLE `user_data` ADD CONSTRAINT `user_data_fk2` FOREIGN KEY (`id`) REFERENCES `user_address`(`id`);

ALTER TABLE `order` ADD CONSTRAINT `order_fk0` FOREIGN KEY (`user_id`) REFERENCES `user_data`(`id`);

ALTER TABLE `order` ADD CONSTRAINT `order_fk1` FOREIGN KEY (`book_id`) REFERENCES `book`(`id`);



ALTER TABLE `book` ADD CONSTRAINT `book_fk0` FOREIGN KEY (`id`) REFERENCES `book_description`(`id`);

ALTER TABLE `book` ADD CONSTRAINT `book_fk1` FOREIGN KEY (`book_genre`) REFERENCES `genre`(`id`);

ALTER TABLE `book` ADD CONSTRAINT `book_fk2` FOREIGN KEY (`author`) REFERENCES `author`(`id`);



ALTER TABLE `recall` ADD CONSTRAINT `recall_fk0` FOREIGN KEY (`book`) REFERENCES `book`(`id`);

ALTER TABLE `shop_contact` ADD CONSTRAINT `shop_contact_fk0` FOREIGN KEY (`shop_address`) REFERENCES `shop_address`(`id`);

ALTER TABLE `shop_data` ADD CONSTRAINT `shop_data_fk0` FOREIGN KEY (`id`) REFERENCES `shop_contact`(`id`);


