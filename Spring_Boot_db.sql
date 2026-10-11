-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_boot
-- ------------------------------------------------------
-- Server version	8.0.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `st_role`
--

DROP TABLE IF EXISTS `st_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `st_role` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st_role`
--

LOCK TABLES `st_role` WRITE;
/*!40000 ALTER TABLE `st_role` DISABLE KEYS */;
INSERT INTO `st_role` VALUES (1,'System administrator','Admin'),(2,'Normal system user','User'),(3,'Manages team and operations','Manager'),(4,'Regular employee','Employee'),(5,'Human resource management','HR'),(6,'Handles financial operations','Accountant'),(7,'Software development role','Developer'),(8,'Software testing role','Tester'),(9,'Supervises employees','Supervisor'),(10,'Limited access user','Guest');
/*!40000 ALTER TABLE `st_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `st_student`
--

DROP TABLE IF EXISTS `st_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `st_student` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `dob` datetime(6) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st_student`
--

LOCK TABLES `st_student` WRITE;
/*!40000 ALTER TABLE `st_student` DISABLE KEYS */;
INSERT INTO `st_student` VALUES (1,'1987-09-10 05:30:00.000000','amit@gmail.com','Amit','Sharma','9876543210');
/*!40000 ALTER TABLE `st_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `st_user`
--

DROP TABLE IF EXISTS `st_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `st_user` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `login` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `roleId` bigint DEFAULT NULL,
  `roleName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st_user`
--

LOCK TABLES `st_user` WRITE;
/*!40000 ALTER TABLE `st_user` DISABLE KEYS */;
INSERT INTO `st_user` VALUES (1,'Nitin','Sharma','nitin@gmail.com','123',1,'Admin'),(2,'Amit','Verma','amit@gmail.com','123',2,'User'),(3,'Rahul','Patel','rahul@gmail.com','123',3,'Manager'),(4,'Priya','Singh','priya@gmail.com','123',4,'Employee'),(5,'Neha','Gupta','neha@gmail.com','123',5,'HR'),(6,'Rohit','Kumar','rohit@gmail.com','123',6,'Accountant'),(7,'Anjali','Mehta','anjali@gmail.com','123',7,'Developer'),(8,'Vikas','Joshi','vikas@gmail.com','123',8,'Tester'),(9,'Pooja','Yadav','pooja@gmail.com','123',9,'Supervisor'),(10,'Suresh','Mishra','suresh@gmail.com','123',10,'Guest'),(11,'Karan','Sharma','karan@gmail.com','123',2,'User'),(12,'Kiran','Karma','karma@gmail.com','123',2,'User');
/*!40000 ALTER TABLE `st_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-10-11 17:44:58
