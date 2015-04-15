DROP DATABASE `user_db3`;
CREATE DATABASE  IF NOT EXISTS `user_db3` CHARACTER SET cp1251 COLLATE cp1251_general_ci;
USE `user_db3`;

DROP TABLE IF EXISTS `city_or_region`;
CREATE TABLE `city_or_region` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNI_CITY_NAME` (`city_name`)
) CHARACTER SET cp1251 COLLATE cp1251_general_ci ;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `middle_name` varchar(100) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `city_or_region_id` int(100) DEFAULT NULL,
  `IIN_BIN` varchar(100) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNI_EMAIL` (`email`),
  CONSTRAINT `FK_CITY_OR_REGION_ID` FOREIGN KEY (`city_or_region_id`) REFERENCES `city_or_region` (`id`)  ON DELETE CASCADE ON UPDATE CASCADE
) CHARACTER SET cp1251 COLLATE cp1251_general_ci ;


