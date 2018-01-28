
    CREATE DATABASE IF NOT EXISTS webapp;

    use webapp;

    CREATE TABLE `user_autifification` (
            `id` int NOT NULL AUTO_INCREMENT,
        `login` varchar(255) NOT NULL,
        `password` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
        ) ;
    CREATE TABLE `user_data` (
            `id` int NOT NULL AUTO_INCREMENT,
        `name` varchar(50),
        `surname` varchar(50),
        `patronymic` varchar(50),
        `date_of_birth` datetime DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `autifification_data` FOREIGN KEY (`id`) REFERENCES `user_autifification` (`id`) ON DELETE CASCADE
        )


