-- MySQL dump 10.11
--
-- Host: 127.0.0.1    Database: hrms
-- ------------------------------------------------------
-- Server version	5.0.67-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `department` (
  `depart_id` int(11) NOT NULL auto_increment,
  `depart_desc` varchar(255) default NULL,
  `depart_name` varchar(255) default NULL,
  PRIMARY KEY  (`depart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (3,'办公室','办公室'),(4,'财务部','财务部'),(5,'产品部','产品部'),(6,'人事部','人事部'),(7,'IT部','IT部');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `position` (
  `position_id` int(11) NOT NULL auto_increment,
  `depart_id` int(11) default NULL,
  `position_description` varchar(255) default NULL,
  `position_name` varchar(255) default NULL,
  PRIMARY KEY  (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (3,4,'出纳','出纳'),(4,6,'hr','hr'),(5,5,'产品经理','产品经理'),(6,3,'办公室主任','办公室主任'),(7,7,'项目经理','项目经理'),(8,7,'java程序员','java程序员');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `resource` (
  `resource_id` int(11) NOT NULL auto_increment,
  `resource_description` varchar(255) default NULL,
  `resource_name` varchar(255) default NULL,
  `resource_url` varchar(255) default NULL,
  PRIMARY KEY  (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES (1,'删除用户','deleteUser','/account/deleteUser'),(2,'删除角色','deleteRole','/authority/deleteRole'),(3,'删除资源','deleteResource','/authority/deleteResource'),(5,'删除部门','deleteDepart','/authority/deleteDepart');
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL auto_increment,
  `role_desc` varchar(255) default NULL,
  `role_name` varchar(255) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'大Boss','admin'),(2,'部门主管','manager'),(4,'小虾米','staff');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_resource`
--

DROP TABLE IF EXISTS `role_resource`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `role_resource` (
  `role_resource_id` int(11) NOT NULL auto_increment,
  `resource_id` int(11) default NULL,
  `role_id` int(11) default NULL,
  PRIMARY KEY  (`role_resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `role_resource`
--

LOCK TABLES `role_resource` WRITE;
/*!40000 ALTER TABLE `role_resource` DISABLE KEYS */;
INSERT INTO `role_resource` VALUES (21,1,1),(22,2,1),(23,3,1),(24,3,2),(25,3,4),(26,5,1);
/*!40000 ALTER TABLE `role_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL auto_increment,
  `account` varchar(255) default NULL,
  `depart_id` int(11) default NULL,
  `password` varchar(255) default NULL,
  `position_id` int(11) default NULL,
  `user_address` varchar(255) default NULL,
  `user_birthday` datetime default NULL,
  `user_diploma` varchar(255) default NULL,
  `user_email` varchar(255) default NULL,
  `user_entrytime` datetime default NULL,
  `user_name` varchar(255) default NULL,
  `user_sex` varchar(255) default NULL,
  `user_telephone` varchar(255) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin',7,'51c017d79ab2eea8548f22543409cd05',8,'成都','2019-11-12 00:00:00','本科','hj@163.com','2019-11-12 00:00:00','胡江','男','11111111111'),(3,'manager',7,'51c017d79ab2eea8548f22543409cd05',8,'成都撒擦','2019-10-29 00:00:00','本科','zcd@163.com','2019-11-06 00:00:00','赵一伤','男','11111111111'),(4,'staff',7,'51c017d79ab2eea8548f22543409cd05',8,'成第三方而产生的','2019-10-30 00:00:00','本科','cd@163.com','2019-11-21 00:00:00','钱二败','男','11111111111'),(8,'hyman',7,'51c017d79ab2eea8548f22543409cd05',8,'超大发出打岔','2019-11-05 00:00:00','硕士','cd@163.com','2019-11-12 00:00:00','hymanHu','男','11111111111');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL auto_increment,
  `role_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  PRIMARY KEY  (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (20,1,1),(21,2,1),(22,4,1),(23,2,2),(24,2,3),(25,4,4),(26,4,5),(27,4,6),(28,4,7),(29,4,8);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-21  7:40:57
