DROP DATABASE IF EXISTS `MYSQL_DATABASE`;
CREATE DATABASE `MYSQL_DATABASE` DEFAULT CHARACTER SET utf8mb4 ;

USE `MYSQL_DATABASE` ;

-- ---------------------------------------------------
-- hero_study_test.persons definition
-- ---------------------------------------------------

DROP TABLE IF EXISTS `MYSQL_DATABASE`.`persons` ;

CREATE TABLE `persons` (
  `person_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `sur_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
);


-- hero_study_test.status definition

DROP TABLE IF EXISTS `MYSQL_DATABASE`.`status` ;

CREATE TABLE `status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- ---------------------------------------------------
-- hero_study_test.`degree` definition
-- ---------------------------------------------------

DROP TABLE IF EXISTS `MYSQL_DATABASE`.`degree` ;

CREATE TABLE `degree` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- ---------------------------------------------------
-- hero_study_test.learners definition
-- ---------------------------------------------------

DROP TABLE IF EXISTS `MYSQL_DATABASE`.`learners` ;

CREATE TABLE `learners` (
  `id` int NOT NULL AUTO_INCREMENT,
  `person_id` int NOT NULL,
  `status_id` int NOT NULL,
  `degree_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `learners_FK_1` (`status_id`),
  KEY `learners_FK_2` (`degree_id`),
  KEY `learners_FK` (`person_id`),
  CONSTRAINT `learners_FK` FOREIGN KEY (`person_id`) REFERENCES `persons` (`person_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `learners_FK_1` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `learners_FK_2` FOREIGN KEY (`degree_id`) REFERENCES `degree` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO status (id, description) VALUES (1, 'Учится');
INSERT INTO status (id, description) VALUES (2, 'Отчислен');
INSERT INTO status (id, description) VALUES (3, 'Выпускник');

INSERT INTO `degree` (id, description) VALUES (1, 'Бакалавр');
INSERT INTO `degree` (id, description) VALUES (2, 'Магистр');
INSERT INTO `degree` (id, description) VALUES (3, 'Аспирант');
