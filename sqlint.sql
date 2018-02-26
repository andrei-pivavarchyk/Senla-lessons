
create database  webapp;
use webapp;

-- -----------------------------------------------------
-- Table `webapp`.`address`
-- -----------------------------------------------------
CREATE TABLE  `address` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(50) ,
  `country` VARCHAR(50) ,
  `post_index` INT(20) ,
  `region` VARCHAR(50) ,
  `street` VARCHAR(50) ,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`author`
-- -----------------------------------------------------
CREATE TABLE `author` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) ,
  `surname` VARCHAR(50),
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`book`
-- -----------------------------------------------------
CREATE TABLE `book` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `book_cost` INT(11) ,
  `book_description` VARCHAR(600) ,
  `book_name` VARCHAR(50),
  `book_status` SMALLINT(6),
  `genre` INT ,
  `author` INT(20),
  PRIMARY KEY (`id`))
;

-- ----------------------------------------------------
-- Table `webapp`.`shop_contact`
-- -----------------------------------------------------
CREATE TABLE  `shop_contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `filial_status` SMALLINT(6),
  `address` INT ,
  `shop_data` INT ,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`shop_phone`
-- -----------------------------------------------------
CREATE TABLE  `shop_phone` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `phone` INT(20) NULL DEFAULT NULL,
  `shop_contact` INT ,
  `phone_type` SMALLINT(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `webapp`.`shop_data`
-- -----------------------------------------------------
CREATE TABLE `shop_data` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `shop_name` VARCHAR(255) ,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `webapp`.`user`
-- -----------------------------------------------------
CREATE TABLE `user` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `user_active` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`user_data`
-- -----------------------------------------------------
CREATE TABLE `user_data` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) ,
  `name` VARCHAR(255) ,
  `surname` VARCHAR(255),
  `phone` BIGINT,
  `role` SMALLINT(6)  DEFAULT 0,
  `patronymic` VARCHAR(255) ,
  `address` INT ,
  `user_id` INT,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `feedback` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `feedback` VARCHAR(255) NULL DEFAULT NULL,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  `book` INT(11) NULL DEFAULT NULL,
  `user_data` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));





-- -----------------------------------------------------
-- Table `webapp`.`user_data_book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_data_book` (
  `user_data_id` INT NOT NULL,
  `favorites_id` INT NOT NULL,
  PRIMARY KEY (`user_data_id`, `favorites_id`));


-- -----------------------------------------------------
-- Table `webapp`.`user_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `creation_date` DATETIME NOT NULL,
  `order_cost` INT(11) ,
  `order_status` SMALLINT(6),
  `user_data` INT,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `webapp`.`user_order_book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_order_book` (
  `user_order_id` INT NOT NULL,
  `listOrderBooks_id` INT NOT NULL,
  PRIMARY KEY (`user_order_id`, `listOrderBooks_id`));




ALTER TABLE `book` ADD CONSTRAINT `FK2E3AE9701F8CE8` FOREIGN KEY (`author`) REFERENCES `webapp`.`author` (`id`);
ALTER TABLE `shop_contact` ADD CONSTRAINT `FK80C54FD758132856` FOREIGN KEY (`address`) REFERENCES  `webapp`.`address` (`id`);
ALTER TABLE `shop_contact` ADD CONSTRAINT `FK80C54FD758132857` FOREIGN KEY (`shop_data`) REFERENCES  `webapp`.`shop_data` (`id`);
ALTER TABLE `shop_phone` ADD CONSTRAINT `FK80C54FD758132858` FOREIGN KEY (`shop_contact`) REFERENCES  `webapp`.`shop_contact` (`id`);


ALTER TABLE `user_data` ADD CONSTRAINT `FK1435639E3D43702C` FOREIGN KEY (`user_id`) REFERENCES  `webapp`.`user` (`id`);
ALTER TABLE `user_data` ADD CONSTRAINT `FK1435639E58132856` FOREIGN KEY (`address`) REFERENCES  `webapp`.`address` (`id`);
ALTER TABLE `user_data_book` ADD CONSTRAINT `FK47B722EA6561253E` FOREIGN KEY (`favorites_id`) REFERENCES `webapp`.`book` (`id`);
ALTER TABLE `user_data_book` ADD CONSTRAINT `FK47B722EADCA590C3` FOREIGN KEY (`user_data_id`) REFERENCES  `webapp`.`user_data` (`id`);
ALTER TABLE `user_order` ADD CONSTRAINT `FK731991DA3FE5F305` FOREIGN KEY (`user_data`) REFERENCES  `webapp`.`user_data` (`id`);
ALTER TABLE `user_order_book` ADD CONSTRAINT `FK7CA27A2E68CC417B` FOREIGN KEY (`listOrderBooks_id`) REFERENCES  `webapp`.`book` (`id`);
ALTER TABLE `user_order_book` ADD CONSTRAINT `FK7CA27A2EC74814DC` FOREIGN KEY (`user_order_id`) REFERENCES  `webapp`.`user_order` (`id`);
ALTER TABLE `feedback` ADD CONSTRAINT `FKF495EB853FE5F305` FOREIGN KEY (`user_data`) REFERENCES  `webapp`.`user_data` (`id`);
ALTER TABLE `feedback` ADD CONSTRAINT `FKF495EB85462E0C24` FOREIGN KEY (`book`) REFERENCES  `webapp`.`book` (`id`);







INSERT INTO `webapp`.`user` (`id`, `login`, `password`, `user_active`) VALUES ('1', 'admin', 'admin', '1');
INSERT INTO `webapp`.`user` (`id`, `login`, `password`, `user_active`) VALUES ('2', 'Bob', 'password', '1');
INSERT INTO `webapp`.`user` (`id`, `login`, `password`, `user_active`) VALUES ('3', 'Nataly', 'password', '1');
INSERT INTO `webapp`.`user` (`id`, `login`, `password`, `user_active`) VALUES ('4', 'Andrei', 'password', '1');
INSERT INTO `webapp`.`user` (`id`, `login`, `password`, `user_active`) VALUES ('5', 'andrey666', 'password', '1');
INSERT INTO `webapp`.`user` (`id`, `login`, `password`, `user_active`) VALUES ('6', 'superUser', 'password', '1');
INSERT INTO `webapp`.`user` (`id`, `login`, `password`, `user_active`) VALUES ('7', 'Megareader', 'password', '1');
INSERT INTO `webapp`.`user` (`id`, `login`, `password`, `user_active`) VALUES ('8', 'Ebooker', 'password', '1');
INSERT INTO `webapp`.`user` (`id`, `login`, `password`, `user_active`) VALUES ('9', 'manager', 'password', '1');
INSERT INTO `webapp`.`user` (`id`, `login`, `password`, `user_active`) VALUES ('10', 'superManager', 'password', '1');



INSERT INTO `webapp`.`address` (`id`, `city`, `country`, `post_index`, `region`, `street`) VALUES ('1', '������', '��������', '240000', '�����������', '���� ��������');
INSERT INTO `webapp`.`address` (`id`, `city`, `country`, `post_index`, `region`, `street`) VALUES ('2', '������', '��������', '240000', '�����������', '���� ��������');
INSERT INTO `webapp`.`address` (`id`, `city`, `country`, `post_index`, `region`, `street`) VALUES ('3', '������', '��������', '240000', '�����������', '���� ��������');
INSERT INTO `webapp`.`address` (`id`, `city`, `country`, `post_index`, `region`, `street`) VALUES ('4', '������', '��������', '240000', '�����������', '���� ��������');
INSERT INTO `webapp`.`address` (`id`, `city`, `country`, `post_index`, `region`, `street`) VALUES ('5', '������', '��������', '240000', '�����������', '���� ��������');
INSERT INTO `webapp`.`address` (`id`, `city`, `country`, `post_index`, `region`, `street`) VALUES ('6', '������', '��������', '240000', '�����������', '���� ��������');
INSERT INTO `webapp`.`address` (`id`, `city`, `country`, `post_index`, `region`, `street`) VALUES ('7', '������', '��������', '240000', '�����������', '���� ��������');
INSERT INTO `webapp`.`address` (`id`, `city`, `country`, `post_index`, `region`, `street`) VALUES ('8', '������', '��������', '240000', '�����������', '���� ��������');
INSERT INTO `webapp`.`address` (`id`, `city`, `country`, `post_index`, `region`, `street`) VALUES ('9', '������', '��������', '240000', '�����������', '���� ��������');
INSERT INTO `webapp`.`address` (`id`, `city`, `country`, `post_index`, `region`, `street`) VALUES ('10', '������', '��������', '240000', '�����������', '���� ��������');

INSERT INTO `webapp`.`address` (`id`, `city`, `country`, `post_index`, `region`, `street`) VALUES ('11', '������', '��������', '240000', '�����������', '���� ��������');




INSERT INTO `webapp`.`user_data` (`id`, `email`, `name`, `surname`, `phone`, `role`, `patronymic`, `address`, `user_id`) VALUES ('1', 'andreyatake666@mailo.ru', 'Andrei', 'Hrumov', '292816940', '0', 'White', '1', '1');
INSERT INTO `webapp`.`user_data` (`id`, `email`, `name`, `surname`, `phone`, `role`, `patronymic`, `address`, `user_id`) VALUES ('2', 'andreyatake666@mailo.ru', 'Andrei', 'Hrumov', '292816940', '0', 'White', '2', '2');
INSERT INTO `webapp`.`user_data` (`id`, `email`, `name`, `surname`, `phone`, `role`, `patronymic`, `address`, `user_id`) VALUES ('3', 'andreyatake666@mailo.ru', 'Andrei', 'Hrumov', '292816940', '0', 'White', '3', '3');
INSERT INTO `webapp`.`user_data` (`id`, `email`, `name`, `surname`, `phone`, `role`, `patronymic`, `address`, `user_id`) VALUES ('4', 'andreyatake666@mailo.ru', 'Andrei', 'Hrumov', '292816940', '0', 'White', '4', '4');
INSERT INTO `webapp`.`user_data` (`id`, `email`, `name`, `surname`, `phone`, `role`, `patronymic`, `address`, `user_id`) VALUES ('5', 'andreyatake666@mailo.ru', 'Andrei', 'Hrumov', '292816940', '0', 'White', '5', '5');
INSERT INTO `webapp`.`user_data` (`id`, `email`, `name`, `surname`, `phone`, `role`, `patronymic`, `address`, `user_id`) VALUES ('6', 'andreyatake666@mailo.ru', 'Andrei', 'Hrumov', '292816940', '0', 'White', '6', '6');
INSERT INTO `webapp`.`user_data` (`id`, `email`, `name`, `surname`, `phone`, `role`, `patronymic`, `address`, `user_id`) VALUES ('7', 'andreyatake666@mailo.ru', 'Andrei', 'Hrumov', '292816940', '0', 'White', '7', '7');
INSERT INTO `webapp`.`user_data` (`id`, `email`, `name`, `surname`, `phone`, `role`, `patronymic`, `address`, `user_id`) VALUES ('8', 'andreyatake666@mailo.ru', 'Andrei', 'Hrumov', '292816940', '0', 'White', '8', '8');
INSERT INTO `webapp`.`user_data` (`id`, `email`, `name`, `surname`, `phone`, `role`, `patronymic`, `address`, `user_id`) VALUES ('9', 'andreyatake666@mailo.ru', 'Andrei', 'Hrumov', '292816940', '0', 'White', '9', '9');
INSERT INTO `webapp`.`user_data` (`id`, `email`, `name`, `surname`, `phone`, `role`, `patronymic`, `address`, `user_id`) VALUES ('10', 'andreyatake666@mailo.ru', 'Andrei', 'Hrumov', '292816940', '0', 'White', '10', '10');








INSERT INTO `webapp`.`shop_data` (`id`, `shop_name`) VALUES ('1', 'BookShop');
INSERT INTO `webapp`.`shop_contact` (`id`, `filial_status`, `address`, `shop_data`) VALUES ('1', '0', '11', '1');

INSERT INTO `webapp`.`shop_phone` (`id`, `phone`, `shop_contact`, `phone_type`) VALUES ('1', '292816940', '1', '0');
INSERT INTO `webapp`.`shop_phone` (`id`, `phone`, `shop_contact`, `phone_type`) VALUES ('2', '292816940', '1', '0');
INSERT INTO `webapp`.`shop_phone` (`id`, `phone`, `shop_contact`, `phone_type`) VALUES ('3', '292816940', '1', '0');






INSERT INTO `webapp`.`author` (`id`, `name`, `surname`) VALUES ('1', 'Bob', 'White');
INSERT INTO `webapp`.`author` (`id`, `name`, `surname`) VALUES ('2', 'Grag', 'Martin');
INSERT INTO `webapp`.`author` (`id`, `name`, `surname`) VALUES ('3', 'Andrei', 'Hrumov');
INSERT INTO `webapp`.`author` (`id`, `name`, `surname`) VALUES ('4', 'Sapkovsky', 'Yellow');
INSERT INTO `webapp`.`author` (`id`, `name`, `surname`) VALUES ('5', 'Tolkien', 'Grey');
INSERT INTO `webapp`.`author` (`id`, `name`, `surname`) VALUES ('6', 'Charly', 'Black');
INSERT INTO `webapp`.`author` (`id`, `name`, `surname`) VALUES ('7', 'Batman', 'Call');
INSERT INTO `webapp`.`author` (`id`, `name`, `surname`) VALUES ('8', 'Superman', 'Red');
INSERT INTO `webapp`.`author` (`id`, `name`, `surname`) VALUES ('9', 'Nataly', 'Potter');
INSERT INTO `webapp`.`author` (`id`, `name`, `surname`) VALUES ('10', 'Katya', 'Grotter');
INSERT INTO `webapp`.`author` (`id`, `name`, `surname`) VALUES ('11', 'Hergy', 'Ken');
INSERT INTO `webapp`.`author` (`id`, `name`, `surname`) VALUES ('12', 'Marta', 'Samanta');
INSERT INTO `webapp`.`author` (`id`, `name`, `surname`) VALUES ('13', 'Linkoln', 'Martin');




INSERT INTO `webapp`.`book` (`id`, `book_cost`, `book_description`, `book_name`, `book_status`, `genre`, `author`) VALUES ('1', '100', '������� �����', 'name', '0', '0', '1');
INSERT INTO `webapp`.`book` (`id`, `book_cost`, `book_description`, `book_name`, `book_status`, `genre`, `author`) VALUES ('2', '100', '����� ����', 'name', '0', '0', '1');
INSERT INTO `webapp`.`book` (`id`, `book_cost`, `book_description`, `book_name`, `book_status`, `genre`, `author`) VALUES ('3', '100', '��� ����', 'name', '0', '0', '1');
INSERT INTO `webapp`.`book` (`id`, `book_cost`, `book_description`, `book_name`, `book_status`, `genre`, `author`) VALUES ('4', '100', '������� �����', 'name', '0', '0', '1');
INSERT INTO `webapp`.`book` (`id`, `book_cost`, `book_description`, `book_name`, `book_status`, `genre`, `author`) VALUES ('5', '100', '������� �����', 'name', '0', '0', '1');
INSERT INTO `webapp`.`book` (`id`, `book_cost`, `book_description`, `book_name`, `book_status`, `genre`, `author`) VALUES ('6', '100', '������� �����', 'name', '0', '0', '1');
INSERT INTO `webapp`.`book` (`id`, `book_cost`, `book_description`, `book_name`, `book_status`, `genre`, `author`) VALUES ('7', '100', '������� �����', 'name', '0', '0', '1');
INSERT INTO `webapp`.`book` (`id`, `book_cost`, `book_description`, `book_name`, `book_status`, `genre`, `author`) VALUES ('8', '100', '������� �����', 'name', '0', '0', '1');
INSERT INTO `webapp`.`book` (`id`, `book_cost`, `book_description`, `book_name`, `book_status`, `genre`, `author`) VALUES ('9', '100', '������� �����', 'name', '0', '0', '1');
INSERT INTO `webapp`.`book` (`id`, `book_cost`, `book_description`, `book_name`, `book_status`, `genre`, `author`) VALUES ('10', '100', '������� �����', 'name', '0', '0', '1');
INSERT INTO `webapp`.`book` (`id`, `book_cost`, `book_description`, `book_name`, `book_status`, `genre`, `author`) VALUES ('11', '100', '������� �����', 'name', '0', '0', '1');
INSERT INTO `webapp`.`book` (`id`, `book_cost`, `book_description`, `book_name`, `book_status`, `genre`, `author`) VALUES ('12', '100', '������� �����', 'name', '0', '0', '1');
INSERT INTO `webapp`.`book` (`id`, `book_cost`, `book_description`, `book_name`, `book_status`, `genre`, `author`) VALUES ('13', '100', '������� �����', 'name', '0', '0', '1');
INSERT INTO `webapp`.`book` (`id`, `book_cost`, `book_description`, `book_name`, `book_status`, `genre`, `author`) VALUES ('14', '100', '������� �����', 'name', '0', '0', '1');







INSERT INTO `webapp`.`user_data_book` (`user_data_id`, `favorites_id`) VALUES ('1', '1');
INSERT INTO `webapp`.`user_data_book` (`user_data_id`, `favorites_id`) VALUES ('1', '2');
INSERT INTO `webapp`.`user_data_book` (`user_data_id`, `favorites_id`) VALUES ('1', '3');
INSERT INTO `webapp`.`user_data_book` (`user_data_id`, `favorites_id`) VALUES ('1', '4');
INSERT INTO `webapp`.`user_data_book` (`user_data_id`, `favorites_id`) VALUES ('1', '5');
INSERT INTO `webapp`.`user_data_book` (`user_data_id`, `favorites_id`) VALUES ('1', '6');
INSERT INTO `webapp`.`user_data_book` (`user_data_id`, `favorites_id`) VALUES ('2', '1');
INSERT INTO `webapp`.`user_data_book` (`user_data_id`, `favorites_id`) VALUES ('2', '2');
INSERT INTO `webapp`.`user_data_book` (`user_data_id`, `favorites_id`) VALUES ('2', '3');
INSERT INTO `webapp`.`user_data_book` (`user_data_id`, `favorites_id`) VALUES ('2', '4');



INSERT INTO `webapp`.`feedback` (`id`, `feedback`, `title`, `book`, `user_data`) VALUES ('1', '����� ������', '���������', '1', '1');
INSERT INTO `webapp`.`feedback` (`id`, `feedback`, `title`, `book`, `user_data`) VALUES ('2', '����� ������', '���������', '1', '2');
INSERT INTO `webapp`.`feedback` (`id`, `feedback`, `title`, `book`, `user_data`) VALUES ('3', '����� ������', '���������', '1', '3');
INSERT INTO `webapp`.`feedback` (`id`, `feedback`, `title`, `book`, `user_data`) VALUES ('4', '����� ������', '���������', '1', '4');
INSERT INTO `webapp`.`feedback` (`id`, `feedback`, `title`, `book`, `user_data`) VALUES ('5', '����� ������', '���������', '1', '5');
INSERT INTO `webapp`.`feedback` (`id`, `feedback`, `title`, `book`, `user_data`) VALUES ('6', '����� ������', '���������', '1', '6');
INSERT INTO `webapp`.`feedback` (`id`, `feedback`, `title`, `book`, `user_data`) VALUES ('7', '����� ������', '���������', '1', '7');
INSERT INTO `webapp`.`feedback` (`id`, `feedback`, `title`, `book`, `user_data`) VALUES ('8', '����� ������', '���������', '1', '8');
INSERT INTO `webapp`.`feedback` (`id`, `feedback`, `title`, `book`, `user_data`) VALUES ('9', '����� ������', '���������', '1', '9');
INSERT INTO `webapp`.`feedback` (`id`, `feedback`, `title`, `book`, `user_data`) VALUES ('10', '����� ������', '���������', '1', '1');
INSERT INTO `webapp`.`feedback` (`id`, `feedback`, `title`, `book`, `user_data`) VALUES ('11', '����� ������', '���������', '1', '1');
INSERT INTO `webapp`.`feedback` (`id`, `feedback`, `title`, `book`, `user_data`) VALUES ('12', '����� ������', '���������', '1', '1');
INSERT INTO `webapp`.`feedback` (`id`, `feedback`, `title`, `book`, `user_data`) VALUES ('13', '����� ������', '���������', '1', '1');
INSERT INTO `webapp`.`feedback` (`id`, `feedback`, `title`, `book`, `user_data`) VALUES ('14', '����� ������', '���������', '1', '1');
INSERT INTO `webapp`.`feedback` (`id`, `feedback`, `title`, `book`, `user_data`) VALUES ('15', '����� ������', '���������', '1', '1');



INSERT INTO `webapp`.`user_order` (`id`, `creation_date`, `order_cost`, `order_status`, `user_data`) VALUES ('1', '2012-06-18 10:34:09', '33', '1', '1');
INSERT INTO `webapp`.`user_order` (`id`, `creation_date`, `order_cost`, `order_status`, `user_data`) VALUES ('2', '2012-06-18 10:34:09', '55', '1', '2');
INSERT INTO `webapp`.`user_order` (`id`, `creation_date`, `order_cost`, `order_status`, `user_data`) VALUES ('3', '2012-06-18 10:34:09', '66', '1', '3');
INSERT INTO `webapp`.`user_order` (`id`, `creation_date`, `order_cost`, `order_status`, `user_data`) VALUES ('4', '2012-06-18 10:34:09', '32', '1', '4');
INSERT INTO `webapp`.`user_order` (`id`, `creation_date`, `order_cost`, `order_status`, `user_data`) VALUES ('5', '2012-06-18 10:34:09', '67', '1', '5');
INSERT INTO `webapp`.`user_order` (`id`, `creation_date`, `order_cost`, `order_status`, `user_data`) VALUES ('6', '2012-06-18 10:34:09', '87', '1', '6');
INSERT INTO `webapp`.`user_order` (`id`, `creation_date`, `order_cost`, `order_status`, `user_data`) VALUES ('7', '2012-06-18 10:34:09', '90', '1', '1');
INSERT INTO `webapp`.`user_order` (`id`, `creation_date`, `order_cost`, `order_status`, `user_data`) VALUES ('8', '2012-06-18 10:34:09', '34', '1', '1');
INSERT INTO `webapp`.`user_order` (`id`, `creation_date`, `order_cost`, `order_status`, `user_data`) VALUES ('9', '2012-06-18 10:34:09', '67', '1', '1');
INSERT INTO `webapp`.`user_order` (`id`, `creation_date`, `order_cost`, `order_status`, `user_data`) VALUES ('10','2012-06-18 10:34:09', '78', '1', '3');


INSERT INTO `webapp`.`user_order_book` (`user_order_id`, `listOrderBooks_id`) VALUES ('1', '1');
INSERT INTO `webapp`.`user_order_book` (`user_order_id`, `listOrderBooks_id`) VALUES ('2', '1');
INSERT INTO `webapp`.`user_order_book` (`user_order_id`, `listOrderBooks_id`) VALUES ('3', '1');
INSERT INTO `webapp`.`user_order_book` (`user_order_id`, `listOrderBooks_id`) VALUES ('4', '1');
INSERT INTO `webapp`.`user_order_book` (`user_order_id`, `listOrderBooks_id`) VALUES ('5', '1');
INSERT INTO `webapp`.`user_order_book` (`user_order_id`, `listOrderBooks_id`) VALUES ('6', '2');
INSERT INTO `webapp`.`user_order_book` (`user_order_id`, `listOrderBooks_id`) VALUES ('7', '3');
INSERT INTO `webapp`.`user_order_book` (`user_order_id`, `listOrderBooks_id`) VALUES ('8', '4');
INSERT INTO `webapp`.`user_order_book` (`user_order_id`, `listOrderBooks_id`) VALUES ('9', '4');
INSERT INTO `webapp`.`user_order_book` (`user_order_id`, `listOrderBooks_id`) VALUES ('10', '1');























