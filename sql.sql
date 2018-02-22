
create database  webapp;
use webapp;

-- -----------------------------------------------------
-- Table `webapp`.`address`
-- -----------------------------------------------------
CREATE TABLE  `address` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
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
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) ,
  `surname` VARCHAR(50),
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`book`
-- -----------------------------------------------------
CREATE TABLE `book` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `book_cost` INT(11) ,
  `book_description` VARCHAR(600) ,
  `book_name` VARCHAR(50),
  `book_status` SMALLINT(6),
  `genre` INT ,
  `author` BIGINT(20),
  PRIMARY KEY (`id`))
;

-- ----------------------------------------------------
-- Table `webapp`.`shop_contact`
-- -----------------------------------------------------
CREATE TABLE  `shop_contact` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `filial_status` SMALLINT(6),
  `address` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`shop_phone`
-- -----------------------------------------------------
CREATE TABLE  `shop_phone` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `phone` INT(20) NULL DEFAULT NULL,
  `phone_type` SMALLINT(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`shop_contact_shop_phone`
-- -----------------------------------------------------
CREATE TABLE  `shop_contact_shop_phone` (
  `shop_contact_id` BIGINT NOT NULL,
  `phoneList_id` BIGINT NOT NULL);

-- -----------------------------------------------------
-- Table `webapp`.`shop_data`
-- -----------------------------------------------------
CREATE TABLE `shop_data` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `shop_name` VARCHAR(255) ,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`shop_data_shop_contact`
-- -----------------------------------------------------

CREATE TABLE `shop_data_shop_contact` (
  `shop_data_id` BIGINT NOT NULL,
  `listOfContacts_id` BIGINT NOT NULL);

-- -----------------------------------------------------
-- Table `webapp`.`user`
-- -----------------------------------------------------
CREATE TABLE `user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `user_active` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`user_data`
-- -----------------------------------------------------
CREATE TABLE `user_data` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) ,
  `name` VARCHAR(255) ,
  `surname` VARCHAR(255),
  `phone` BIGINT,
  `role` SMALLINT(6)  DEFAULT 0,
  `patronymic` VARCHAR(255) ,
  `address` BIGINT ,
  `user_id` BIGINT,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`user_data_book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_data_book` (
  `user_data_id` BIGINT NOT NULL,
  `favorites_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_data_id`, `favorites_id`));


-- -----------------------------------------------------
-- Table `webapp`.`user_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_order` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `creation_date` DATETIME NOT NULL,
  `order_cost` INT(11) ,
  `order_status` SMALLINT(6),
  `user_data` BIGINT,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `webapp`.`user_order_book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_order_book` (
  `user_order_id` BIGINT NOT NULL,
  `listOrderBooks_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_order_id`, `listOrderBooks_id`));


CREATE UNIQUE INDEX `phoneList_id` ON `shop_contact_shop_phone` (`phoneList_id` ASC);
CREATE UNIQUE INDEX `listOfContacts_id` ON `shop_data_shop_contact` (`listOfContacts_id` ASC);
CREATE UNIQUE INDEX `favorites_id` ON `webapp`.`user_data_book` (`favorites_id` ASC);
CREATE UNIQUE INDEX `listOrderBooks_id` ON `user_order_book` (`listOrderBooks_id` ASC);

CREATE INDEX `FK2E3AE9701F8CE8` ON `webapp`.`book` (`author` ASC);
CREATE INDEX `FK80C54FD758132856` ON `webapp`.`shop_contact` (`address` ASC);

CREATE INDEX `FK1BD2744D3BFC6834` ON `webapp`.`shop_contact_shop_phone` (`phoneList_id` ASC);
CREATE INDEX `FK1BD2744D9D93483B` ON `webapp`.`shop_contact_shop_phone` (`shop_contact_id` ASC);

CREATE INDEX `FK328A41432CCF0C2A` ON  `shop_data_shop_contact` (`listOfContacts_id` ASC);
CREATE INDEX `FK328A4143C5118699` ON  `shop_data_shop_contact` (`shop_data_id` ASC);
CREATE INDEX `FK1435639E58132856` ON `user_data` (`address` ASC);
CREATE INDEX `FK1435639E3D43702C` ON `user_data` (`user_id` ASC);

CREATE INDEX `FK47B722EA6561253E` ON `webapp`.`user_data_book` (`favorites_id` ASC);
CREATE INDEX `FK47B722EADCA590C3` ON `webapp`.`user_data_book` (`user_data_id` ASC);
CREATE INDEX `FK731991DA3FE5F305` ON `webapp`.`user_order` (`user_data` ASC);

CREATE INDEX `FK7CA27A2E68CC417B` ON `user_order_book` (`listOrderBooks_id` ASC);
CREATE INDEX `FK7CA27A2EC74814DC` ON `user_order_book` (`user_order_id` ASC);


ALTER TABLE `book` ADD CONSTRAINT `FK2E3AE9701F8CE8` FOREIGN KEY (`author`) REFERENCES `webapp`.`author` (`id`);
ALTER TABLE `shop_contact` ADD CONSTRAINT `FK80C54FD758132856` FOREIGN KEY (`address`) REFERENCES  `webapp`.`address` (`id`);




ALTER TABLE `shop_data_shop_contact` ADD CONSTRAINT `FK328A4143C5118699` FOREIGN KEY (`shop_data_id`) REFERENCES `webapp`.`shop_data` (`id`);

ALTER TABLE `shop_data_shop_contact` ADD CONSTRAINT `FK328A41432CCF0C2A` FOREIGN KEY (`listOfContacts_id`) REFERENCES `webapp`.`shop_contact` (`id`);




ALTER TABLE `user_data` ADD CONSTRAINT `FK1435639E3D43702C` FOREIGN KEY (`user_id`) REFERENCES  `webapp`.`user` (`id`);
ALTER TABLE `user_data` ADD CONSTRAINT `FK1435639E58132856` FOREIGN KEY (`address`) REFERENCES  `webapp`.`address` (`id`);
ALTER TABLE `user_data_book` ADD CONSTRAINT `FK47B722EA6561253E` FOREIGN KEY (`favorites_id`) REFERENCES `webapp`.`book` (`id`);
ALTER TABLE `user_data_book` ADD CONSTRAINT `FK47B722EADCA590C3` FOREIGN KEY (`user_data_id`) REFERENCES  `webapp`.`user_data` (`id`);
ALTER TABLE `user_order` ADD CONSTRAINT `FK731991DA3FE5F305` FOREIGN KEY (`user_data`) REFERENCES  `webapp`.`user_data` (`id`);
ALTER TABLE `user_order_book` ADD CONSTRAINT `FK7CA27A2E68CC417B` FOREIGN KEY (`listOrderBooks_id`) REFERENCES  `webapp`.`book` (`id`);
ALTER TABLE `user_order_book` ADD CONSTRAINT `FK7CA27A2EC74814DC` FOREIGN KEY (`user_order_id`) REFERENCES  `webapp`.`user_order` (`id`);


ALTER TABLE `shop_contact_shop_phone` ADD CONSTRAINT `FK1BD2744D3BFC6834` FOREIGN KEY (`phoneList_id`) REFERENCES  `webapp`.`shop_phone` (`id`);
ALTER TABLE `shop_contact_shop_phone` ADD CONSTRAINT `FK1BD2744D9D93483B` FOREIGN KEY (`shop_contact_id`) REFERENCES  `webapp`.`shop_contact` (`id`);



