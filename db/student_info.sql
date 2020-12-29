-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: student_info
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE `student_info`;

USE `student_info`;

--
-- Table structure for table `course`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coz_num` varchar(100) NOT NULL,
  `coz_name` varchar(100) DEFAULT NULL,
  `coz_time` int(11) NOT NULL,
  `coz_point` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_id_uindex` (`id`),
  UNIQUE KEY `course_coz_num_uindex` (`coz_num`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`id`, `coz_num`, `coz_name`, `coz_time`, `coz_point`) VALUES (5,'1','软件工程',32,1),(6,'2','数据库设计',32,1),(7,'3','计算机导论',32,1),(8,'4','C语言程序设计',32,1),(9,'5','高等数学',32,1),(10,'6','大学物理',32,1),(11,'7','线性代数',32,1),(12,'8','计算机网络',32,1),(13,'9','Java（I）',32,1),(14,'10','Java（II）',32,1),(15,'11','Java（III）',32,1),(16,'12','大学英语',32,1),(17,'13','计算机组成原理',32,1),(18,'14','软件测试',32,1),(19,'15','软件结构',32,1),(20,'16','软件构造',32,1),(21,'17','脚本编程',32,1),(22,'18','需求工程',32,1),(23,'19','数据结构',32,1),(24,'20','体育1',32,1),(25,'21','体育2',32,1),(26,'22','体育3',32,1),(27,'23','体育4',32,1),(28,'24','离散数学',32,1),(29,'25','线性代数',32,1),(30,'26','马克思主义基本原理',32,1),(31,'27','思想道德',32,1),(32,'28','大学音乐',32,1),(33,'29','大学心理健康',32,1),(36,'30','大学语文',32,1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

--
-- Table structure for table `student`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_num` varchar(20) NOT NULL,
  `stu_name` varchar(20) NOT NULL,
  `stu_sex` enum('Male','Female') NOT NULL,
  `stu_birthday` date NOT NULL,
  `stu_class` varchar(50) NOT NULL,
  `stu_profession` varchar(100) NOT NULL,
  `stu_department` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_id_uindex` (`id`),
  UNIQUE KEY `student_stu_num_uindex` (`stu_num`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `stu_num`, `stu_name`, `stu_sex`, `stu_birthday`, `stu_class`, `stu_profession`, `stu_department`) VALUES (9,'201819901','王1','Male','1999-12-23','2018199','软件工程','信息工程学院'),(10,'201819902','王2','Male','2000-01-02','2018199','软件工程','信息工程学院'),(11,'201819903','王3','Female','2000-01-03','2018199','软件工程','信息工程学院'),(12,'201819904','王4','Male','2000-01-04','2018199','软件工程','信息工程学院'),(13,'201819905','王5','Female','2000-01-05','2018199','软件工程','信息工程学院'),(14,'201819906','王6','Male','2000-01-06','2018199','软件工程','信息工程学院'),(15,'201819907','王7','Female','2000-01-07','2018199','软件工程','信息工程学院'),(16,'201819908','王8','Male','2000-01-08','2018199','软件工程','信息工程学院'),(17,'201819909','王9','Female','2000-01-09','2018199','软件工程','信息工程学院'),(19,'201819910','王10','Male','2000-01-10','2018199','软件工程','信息工程学院'),(20,'201819911','王11','Male','2000-01-11','2018199','软件工程','信息工程学院'),(21,'201819912','王12','Male','2000-01-12','2018199','软件工程','信息工程学院'),(22,'201819913','王13','Male','2000-01-13','2018199','软件工程','信息工程学院'),(23,'201819915','王15','Female','2000-01-14','2018199','软件工程','信息工程学院'),(24,'201819916','王16','Male','2000-01-15','2018199','软件工程','信息工程学院'),(25,'201819917','李16','Male','2000-01-16','2018199','软件工程','信息工程学院'),(26,'201819918','李17','Male','2000-01-17','2018199','软件工程','信息工程学院'),(27,'201819919','李18','Female','2000-01-18','2018199','软件工程','信息工程学院'),(28,'201819920','李19','Male','2000-02-15','2018199','软件工程','信息工程学院'),(29,'201819921','李20','Male','2000-03-15','2018199','软件工程','信息工程学院'),(30,'201819922','赵16','Male','2000-04-15','2018199','软件工程','信息工程学院'),(31,'201819923','赵15','Male','2000-05-15','2018199','软件工程','信息工程学院'),(32,'201819924','赵14','Male','2000-06-15','2018199','软件工程','信息工程学院'),(33,'201702404','赵17','Male','2000-07-15','2018200','软件工程','信息工程学院'),(34,'201702405','赵1','Male','2000-08-15','2018200','软件工程','信息工程学院'),(35,'201702406','赵7','Male','2000-09-15','2018200','软件工程','信息工程学院'),(36,'201910910','孙10','Male','2001-01-30','2019109','网络工程','信息工程学院'),(37,'201910911','孙11','Male','2001-01-11','2019109','网络工程','信息工程学院'),(38,'201910912','孙12','Male','2001-01-10','2019109','网络工程','信息工程学院'),(39,'201910913','孙13','Male','2001-01-25','2019109','网络工程','信息工程学院');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

--
-- Table structure for table `score`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_num` varchar(20) NOT NULL,
  `coz_num` varchar(100) NOT NULL,
  `score` int(11) NOT NULL,
  `retest_score` int(11) DEFAULT NULL,
  `coz_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `score_id_uindex` (`id`),
  UNIQUE KEY `stu_num` (`stu_num`,`coz_num`),
  KEY `score_course_coz_num_fk` (`coz_num`),
  CONSTRAINT `score_course_coz_num_fk` FOREIGN KEY (`coz_num`) REFERENCES `course` (`coz_num`),
  CONSTRAINT `score_student_stu_num_fk` FOREIGN KEY (`stu_num`) REFERENCES `student` (`stu_num`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='成绩表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` (`id`, `stu_num`, `coz_num`, `score`, `retest_score`, `coz_name`) VALUES (11,'201819902','2',67,NULL,'数据库设计'),(12,'201819903','2',67,NULL,'数据库设计'),(13,'201819904','3',78,NULL,'计算机导论'),(14,'201819905','5',78,NULL,'高等数学'),(15,'201819906','1',90,NULL,'软件工程'),(16,'201819907','2',89,NULL,'数据库设计'),(17,'201819907','3',67,NULL,'计算机导论'),(18,'201819907','4',89,NULL,'C语言程序设计'),(19,'201819908','3',89,NULL,'计算机导论'),(20,'201819908','4',45,NULL,'C语言程序设计'),(21,'201819909','5',78,NULL,'高等数学'),(22,'201819909','10',78,NULL,'Java（II）'),(23,'201819910','20',67,NULL,'体育1'),(24,'201819911','23',59,70,'体育4'),(25,'201819920','25',78,NULL,'线性代数'),(26,'201819913','22',72,NULL,'体育3'),(27,'201819915','14',78,NULL,'软件测试'),(28,'201819915','1',78,NULL,'软件工程'),(29,'201819915','2',67,NULL,'数据库设计'),(30,'201819915','3',67,NULL,'计算机导论'),(31,'201819915','5',89,NULL,'高等数学'),(32,'201819916','7',89,NULL,'线性代数'),(33,'201910913','3',78,NULL,'计算机导论'),(34,'201910913','8',90,NULL,'计算机网络'),(35,'201910913','6',56,NULL,'大学物理'),(36,'201702406','23',67,NULL,'体育4'),(37,'201702406','10',47,NULL,'Java（II）'),(38,'201702406','1',90,NULL,'软件工程'),(39,'201702404','4',78,NULL,'C语言程序设计'),(40,'201702404','28',90,NULL,'大学音乐');
/*!40000 ALTER TABLE `score` ENABLE KEYS */;

--
-- Table structure for table `user`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `token` varchar(50) DEFAULT NULL,
  `role` enum('Admin','Other') NOT NULL DEFAULT 'Other',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_uindex` (`id`),
  UNIQUE KEY `user_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `password`, `token`, `role`) VALUES (1,'admin','2daceebc4e31654d326ae7889b397ed50ff7e5afff374d1f89525865fd87efe0','64450ad37043d85e70bf85559efa431d','Admin'),(2,'201819914','59d7f0154f5101b34d2b88fe28c632da463b51dd29aa13e3921eaefb5a5a0380',NULL,'Other');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-29 16:47:19
