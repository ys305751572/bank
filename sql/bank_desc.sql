/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.11 : Database - bank
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bank` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bank`;

/*Table structure for table `tb_em_cust` */

DROP TABLE IF EXISTS `tb_em_cust`;

CREATE TABLE `tb_em_cust` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `wnumber` varchar(50) NOT NULL COMMENT '员工工号',
  `name` varchar(50) NOT NULL COMMENT '员工姓名',
  `mobile` varchar(50) DEFAULT NULL COMMENT '员工电话',
  `customer_id` varchar(50) DEFAULT NULL COMMENT '客户ID',
  `customer_name` varchar(50) DEFAULT NULL COMMENT '客户姓名',
  `bf` bigint(20) DEFAULT NULL COMMENT '保费',
  `be` bigint(20) DEFAULT NULL COMMENT '保额',
  `year` int(11) DEFAULT NULL COMMENT '年份',
  `be_insurance_name` varchar(50) DEFAULT NULL COMMENT '被保人姓名',
  `limit` int(11) DEFAULT NULL COMMENT '缴费年期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200858 DEFAULT CHARSET=utf8;

/*Table structure for table `tb_em_visit_record` */

DROP TABLE IF EXISTS `tb_em_visit_record`;

CREATE TABLE `tb_em_visit_record` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `wnumber` varchar(50) NOT NULL COMMENT '员工工号',
  `wname` varchar(50) DEFAULT NULL COMMENT '员工姓名',
  `customer_id` varchar(50) DEFAULT NULL COMMENT '客户ID',
  `customer_name` varchar(50) DEFAULT NULL COMMENT '客户姓名',
  `mobile` varchar(50) NOT NULL COMMENT '本人电话',
  `image` varchar(300) NOT NULL COMMENT '图片地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
