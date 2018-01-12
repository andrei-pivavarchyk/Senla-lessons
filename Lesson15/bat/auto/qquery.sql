
    CREATE DATABASE IF NOT EXISTS hotel7;

    use hotel7;

    CREATE TABLE `guest` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `name` varchar(255) DEFAULT NULL,
        `surname` varchar(255) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



        CREATE TABLE `room` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `capacity` int(11) DEFAULT NULL,
        `cost` int(11) DEFAULT NULL,
        `number` int(11) DEFAULT NULL,
        `stars` int(11) DEFAULT NULL,
        `status` int(11) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



        CREATE TABLE `service` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `cost` int(11) DEFAULT NULL,
        `name` varchar(255) DEFAULT NULL,
        `type` int(11) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;




        CREATE TABLE `guestroominfo` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `arrivaldate` datetime DEFAULT NULL,
        `departuredate` datetime DEFAULT NULL,
        `isStillLiving` int(11) NOT NULL,
        `guest` int(11) DEFAULT NULL,
        `room` int(11) DEFAULT NULL,
        PRIMARY KEY (`id`),
        KEY `FK1AD7D5E128946912` (`guest`),
        KEY `FK1AD7D5E1E892C014` (`room`),
        CONSTRAINT `FK1AD7D5E128946912` FOREIGN KEY (`guest`) REFERENCES `guest` (`id`) ON DELETE CASCADE,
        CONSTRAINT `FK1AD7D5E1E892C014` FOREIGN KEY (`room`) REFERENCES `room` (`id`) ON DELETE CASCADE
        ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;




    CREATE TABLE `guestserviceinfo` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `date` datetime DEFAULT NULL,
        `guest` int(11) DEFAULT NULL,
        `service` int(11) DEFAULT NULL,
        PRIMARY KEY (`id`),
        KEY `FK1DEC040B1589CA4C` (`service`),
        KEY `FK1DEC040B28946912` (`guest`),
        CONSTRAINT `FK1DEC040B1589CA4C` FOREIGN KEY (`service`) REFERENCES `service` (`id`),
        CONSTRAINT `FK1DEC040B28946912` FOREIGN KEY (`guest`) REFERENCES `guest` (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8




























