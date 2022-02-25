/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17-log : Database - novel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`novel` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `novel`;

/*Table structure for table `novel_admin` */

DROP TABLE IF EXISTS `novel_admin`;

CREATE TABLE `novel_admin` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `password` varchar(32) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `novel_admin` */

/*Table structure for table `novel_author` */

DROP TABLE IF EXISTS `novel_author`;

CREATE TABLE `novel_author` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `nickname` varchar(256) NOT NULL COMMENT '昵称',
  `info` varchar(1024) DEFAULT NULL COMMENT '作者简介',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nickname_uk` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `novel_author` */

/*Table structure for table `novel_book` */

DROP TABLE IF EXISTS `novel_book`;

CREATE TABLE `novel_book` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `author_id` bigint(20) NOT NULL COMMENT '作者id',
  `author_nickname` varchar(256) DEFAULT NULL COMMENT '作者昵称',
  `cover_image` varchar(2048) DEFAULT NULL COMMENT '封面图片地址',
  `novel_title` varchar(256) NOT NULL COMMENT '小说名字',
  `description` varchar(2048) DEFAULT NULL COMMENT '简介',
  `shelf_time` date DEFAULT NULL COMMENT '上架时间',
  `update_time` date DEFAULT NULL COMMENT '更新时间',
  `type_id` bigint(20) DEFAULT NULL COMMENT '分类id',
  `type_name` varchar(256) DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `author_novel_uk` (`author_id`,`novel_title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `novel_book` */

/*Table structure for table `novel_bookshelf` */

DROP TABLE IF EXISTS `novel_bookshelf`;

CREATE TABLE `novel_bookshelf` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `book_id` bigint(20) NOT NULL COMMENT '书籍id',
  `update_time` date NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_book_uk` (`user_id`,`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `novel_bookshelf` */

/*Table structure for table `novel_chapter` */

DROP TABLE IF EXISTS `novel_chapter`;

CREATE TABLE `novel_chapter` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `book_id` bigint(20) NOT NULL COMMENT '书籍id',
  `title` varchar(256) NOT NULL COMMENT '章节标题',
  `file_location` varchar(1024) DEFAULT NULL COMMENT '文件位置',
  `upload_time` date DEFAULT NULL COMMENT '上传时间',
  `show_status` tinyint(4) DEFAULT NULL COMMENT '显示状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `novel_chapter` */

insert  into `novel_chapter`(`id`,`book_id`,`title`,`file_location`,`upload_time`,`show_status`) values (1,1,'第一章','http://localhost:8080/upload/file/1/35d1ea3c-9dc9-4a23-9345-45e53351ac41.txt','2022-02-19',1);

/*Table structure for table `novel_type` */

DROP TABLE IF EXISTS `novel_type`;

CREATE TABLE `novel_type` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(256) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_uk` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `novel_type` */

/*Table structure for table `novel_user` */

DROP TABLE IF EXISTS `novel_user`;

CREATE TABLE `novel_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `nickname` varchar(256) NOT NULL COMMENT '昵称',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `role` varchar(32) NOT NULL DEFAULT 'user' COMMENT '用户角色',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nickname_uk` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `novel_user` */

insert  into `novel_user`(`id`,`nickname`,`password`,`role`) values (1,'fjz','e10adc3949ba59abbe56e057f20f883e','user'),(2,'admin','e10adc3949ba59abbe56e057f20f883e','admin'),(3,'author','e10adc3949ba59abbe56e057f20f883e','author');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
