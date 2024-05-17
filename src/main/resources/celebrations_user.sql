-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: celebrations
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(55) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `contact` varchar(45) NOT NULL,
  `id_privilege` int NOT NULL,
  `id_town` int DEFAULT NULL,
  `active` tinyint DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_user_privilege_idx` (`id_privilege`),
  KEY `fk_user_town_idx` (`id_town`),
  CONSTRAINT `fk_user_privilege` FOREIGN KEY (`id_privilege`) REFERENCES `privilege` (`id`),
  CONSTRAINT `fk_user_town` FOREIGN KEY (`id_town`) REFERENCES `town` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ismet.omerovic','PBKDF2WithHmacSHA256:2048:9NhqfU1qOQXPf4LOH2nJD/PHY/5QS+ev6qKRMCS8V2E=:DATbvSF8Az0iDRf2DADV14dpPm/qR3KB+hQvyp+w8B4=','Ismet','OmeroviÄ','ismet@gmail.com','12981319',1,6,1),(2,'nejra.kadric','PBKDF2WithHmacSHA256:2048:tFGZyuX1fhj+OMvXT4wxGes9uGeKC/1eIgBWvLTe0MU=:o03tCpTIeBEm4kFMaglkcZCVgux81JWdzXWEOANyqkk=','Nejra','Kadric','nejra@gmail.com','121313',1,3,1),(3,'alen.botic','PBKDF2WithHmacSHA256:2048:buYnmWrSO5vkGOxtOjgtiOVP4cpbHmecSvIMapH42KQ=:BAWLGZXj2pP4rsCZY8/RvMW0As57VUy1zTdFYjRHOIQ=','Alen','Botic','alen@gmail.com','12112',1,3,1),(4,'kemo','PBKDF2WithHmacSHA256:2048:5e9XqGXzSVW6+NOAAgJPnTza3UVGX0QF+erfDK7WS7E=:7dZDWkTyaRJPWbxlD4NOX3F7/XQCw/Xr6iL4jcEEsJA=','Kemal','Selimotic','kemo@gmail.com','1231333',1,4,1),(5,'emir','PBKDF2WithHmacSHA256:2048:7k6qX207ixM18ZLkaECSq9EGfdbtLAO6KtZRrwsexbc=:zvd2FiAPCrKm2H9e5Q8UH//gLmgidRFe2VN0pTdmlsc=','Emir','Puska','emir@gmail.com','3131313',1,5,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-17 20:36:32
