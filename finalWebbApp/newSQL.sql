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
	`user_id` int ,
	`role` int ,
	`name` varchar(20) ,
	`surname` varchar(20) ,
	`patronymic` varchar(20) ,
	`date_of_birth` DATE ,
	`contact` int ,
	`address` int ,
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
	`book_name` varchar(20) NOT NULL,
	`book_genre` int ,
	`author` int ,
	`book_cost` int ,
	`book_status` int ,
	`book_description` int ,
	PRIMARY KEY (`id`)
);

CREATE TABLE `author` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	`surname` varchar(50) NOT NULL,
	`patronymic` varchar(50) ,
	PRIMARY KEY (`id`)
);

CREATE TABLE `book_description` (
	`id` int NOT NULL AUTO_INCREMENT,
	`description` varchar(20) ,
	PRIMARY KEY (`id`)
);

CREATE TABLE `genre` (
	`id` int NOT NULL AUTO_INCREMENT,
	`genre` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);



CREATE TABLE `recall` (
	`id` int NOT NULL AUTO_INCREMENT,
	`book` int NOT NULL,
	`user_data_id` int NOT NULL,
	`title` varchar(20) NOT NULL,
	`recall` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `shop_contact` (
	`id` int NOT NULL AUTO_INCREMENT,
	`phone` int ,
	`shop_address` int ,
	PRIMARY KEY (`id`)
);

CREATE TABLE `shop_data` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(30) ,
	`contact` int(30) ,
	PRIMARY KEY (`id`)
);

CREATE TABLE `user_contact` (
	`id` int NOT NULL AUTO_INCREMENT,
	`email` varchar(60) ,
	`phone` int(30) ,
	PRIMARY KEY (`id`)
);

CREATE TABLE `user_address` (
	`id` int NOT NULL AUTO_INCREMENT,
	`street` varchar(20) ,
	`city` varchar(20)  ,
	`region` varchar(20) ,
	`country` varchar(20) ,
	`post_index` int(30) ,
	PRIMARY KEY (`id`)
);

CREATE TABLE `shop_address` (
	`id` int NOT NULL AUTO_INCREMENT,
	`street` varchar(30) ,
	`city` varchar(30) ,
	`region` varchar(30) ,
	`country` varchar(30) ,
	PRIMARY KEY (`id`)
);


ALTER TABLE `user_data` ADD CONSTRAINT `user_data_fk0` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ;
ALTER TABLE `user_data` ADD CONSTRAINT `user_data_fk2` FOREIGN KEY (`contact`) REFERENCES `user_contact`(`id`);

ALTER TABLE `user_data` ADD CONSTRAINT `user_data_fk3` FOREIGN KEY (`address`) REFERENCES `user_address`(`id`);

ALTER TABLE `order` ADD CONSTRAINT `order_fk0` FOREIGN KEY (`user_id`) REFERENCES `user_data`(`id`);

ALTER TABLE `order` ADD CONSTRAINT `order_fk1` FOREIGN KEY (`book_id`) REFERENCES `book`(`id`);

ALTER TABLE `book` ADD CONSTRAINT `book_fk0` FOREIGN KEY (`book_genre`) REFERENCES `genre`(`id`);

ALTER TABLE `book` ADD CONSTRAINT `book_fk1` FOREIGN KEY (`author`) REFERENCES `author`(`id`);

ALTER TABLE `book` ADD CONSTRAINT `book_fk3` FOREIGN KEY (`book_description`) REFERENCES `book_description`(`id`);

ALTER TABLE `recall` ADD CONSTRAINT `recall_fk0` FOREIGN KEY (`book`) REFERENCES `book`(`id`);
ALTER TABLE `recall` ADD CONSTRAINT `recall_fk1` FOREIGN KEY (`user_data_id`) REFERENCES `user_data`(`id`);

ALTER TABLE `shop_contact` ADD CONSTRAINT `shop_contact_fk0` FOREIGN KEY (`shop_address`) REFERENCES `shop_address`(`id`);

ALTER TABLE `shop_data` ADD CONSTRAINT `shop_data_fk0` FOREIGN KEY (`contact`) REFERENCES `shop_contact`(`id`);



