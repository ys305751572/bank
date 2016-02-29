/*
Navicat MySQL Data Transfer

Source Server         : bank
Source Server Version : 50518
Source Host           : rdsnja73ieerzrz.mysql.rds.aliyuncs.com:3306
Source Database       : aal

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2015-03-24 21:23:05
*/

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `tb_em_cust`
create table `tb_em_cust`(

	`id` int(32) not null auto_increment,
	`wnumber` varchar(50) not null comment '员工工号',
	`name` varchar(50) not null comment '员工姓名',
	`mobile`varchar(50) comment '员工电话',
	`customer_id` varchar(50) comment '客户ID',
	`customer_name` varchar(50) comment '客户姓名',
	`bf` bigint comment '保费',
	`be` bigint comment '保额',
	`year` int comment '年份',
	`limit` int comment '缴费年期',
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tb_em_visit_record`;
create table `tb_em_visit_record` (
	`id` int(32) not null auto_increment,
	`wnumber` varchar(50) not null comment '员工工号',
	`wname` varchar(50) comment '员工姓名',
	`customer_id` varchar(50) comment '客户ID',
	`customer_name` varchar(50) comment '客户姓名',
	`mobile` varchar(50) not null comment '本人电话',
	`image` varchar(300) not null comment '图片地址',
	`create_date` datetime comment '创建时间',
	`modify_date` datetime comment '修改时间',
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;