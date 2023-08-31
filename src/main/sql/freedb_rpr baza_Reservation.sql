-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: sql.freedb.tech    Database: freedb_rpr baza
-- ------------------------------------------------------
-- Server version	8.0.34-0ubuntu0.22.04.1

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
-- Table structure for table `Reservation`
--

DROP TABLE IF EXISTS `Reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Reservation` (
  `reservation_id` int NOT NULL,
  `customer_id` int NOT NULL,
  `treatment_id` int NOT NULL,
  `reservation_date` date NOT NULL,
  `reservation_time` time NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `treatment_id_idx` (`treatment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reservation`
--

LOCK TABLES `Reservation` WRITE;
/*!40000 ALTER TABLE `Reservation` DISABLE KEYS */;
INSERT INTO `Reservation` VALUES (3,1,0,'2023-08-31','20:30:00','Pending'),(4,4,0,'2023-08-29','12:30:00','Pending'),(5,3,0,'2023-09-01','15:30:00','Pending'),(6,3,0,'2023-10-07','12:35:00','Pending'),(7,0,0,'2023-09-03','20:00:00','Pending'),(8,0,0,'2023-09-09','15:50:00','Pending'),(9,6,0,'2023-09-02','08:00:00','Pending'),(10,5,0,'2023-08-30','12:00:00','Pending'),(11,4,0,'2023-09-10','08:00:00','Pending'),(12,5,0,'2023-09-07','12:30:00','Pending'),(13,4,0,'2023-09-06','12:30:00','Pending'),(14,3,0,'2023-11-03','12:40:00','Pending'),(15,3,0,'2023-11-16','12:30:00','Pending'),(16,7,0,'2023-12-07','12:30:00','Pending'),(17,2,0,'2023-12-12','13:00:00','Pending');
/*!40000 ALTER TABLE `Reservation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-31 11:47:52
