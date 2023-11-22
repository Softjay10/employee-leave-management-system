/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 10.4.17-MariaDB : Database - employeedb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`employeedb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `employeedb`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `department_name` varchar(255) DEFAULT NULL,
  `department_short_name` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `department` */

insert  into `department`(`id`,`created_at`,`creation_date`,`department_name`,`department_short_name`,`updated_at`) values 
(1,NULL,'2023-11-14 16:00:00.000000','Information Technology','IT','2023-11-15 13:25:00.000000'),
(2,'2023-11-15 13:04:44.000000','2023-11-14 16:00:00.000000','Accounting Information','AI','2023-11-15 13:04:44.000000'),
(3,'2023-11-15 14:17:05.000000','2023-11-15 16:00:00.000000','Finance Information ','FI','2023-11-15 14:17:05.000000'),
(4,'2023-11-15 20:03:07.000000','2023-11-17 16:00:00.000000','Logistic Information','LI','2023-11-15 20:03:07.000000');

/*Table structure for table `designation` */

DROP TABLE IF EXISTS `designation`;

CREATE TABLE `designation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `designation_name` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `designation` */

insert  into `designation`(`id`,`created_at`,`description`,`designation_name`,`updated_at`) values 
(1,NULL,'Resign','Jay','2023-11-15 20:03:20.000000'),
(2,'2023-11-15 15:00:52.000000','Resign','Gino G','2023-11-15 15:00:52.000000');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `date_register` datetime(6) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `employee_number` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `employee` */

insert  into `employee`(`id`,`age`,`contact`,`date_register`,`department`,`designation`,`email`,`employee_number`,`first_name`,`gender`,`last_name`,`middle_name`,`password`,`status`,`username`) values 
(2,25,'09456123123','2023-11-17 16:00:00.000000','3','2','rommel@gmail.com',11002,'Rommel','Male','Blanco','Betlog','admin1','Active','rommel'),
(3,25,'09456123123','2023-11-17 16:00:00.000000','3','1','jfornias10@gmail.com',11001,'Jay','Male','Fornias','Bernales','admin1','Not Active','jay10');

/*Table structure for table `leave_type` */

DROP TABLE IF EXISTS `leave_type`;

CREATE TABLE `leave_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `date_register` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `leave_name` varchar(255) DEFAULT NULL,
  `number_of_leave_days` int(11) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `leave_type` */

insert  into `leave_type`(`id`,`created_at`,`date_register`,`description`,`leave_name`,`number_of_leave_days`,`updated_at`,`status`) values 
(1,NULL,NULL,'Absent ','jay',2,'2023-11-19 04:18:11.000000','approved'),
(2,NULL,NULL,'1 Day leave','Rommel',3,'2023-11-19 04:18:20.000000','not approved'),
(3,NULL,'2023-11-18 16:00:00.000000','Rest Day','Omak',2,'2023-11-19 07:40:43.000000','pending'),
(7,'2023-11-19 09:20:51.000000','2023-11-18 16:00:00.000000','Casual Leave','Noah',1,'2023-11-19 09:20:51.000000','not approved');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
