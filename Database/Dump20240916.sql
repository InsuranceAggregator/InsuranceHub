-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: insurance
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `claim_details`
--

DROP TABLE IF EXISTS `claim_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `claim_details` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `claim_number` varchar(255) DEFAULT NULL,
  `claimant_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `policy_number` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claim_details`
--

LOCK TABLES `claim_details` WRITE;
/*!40000 ALTER TABLE `claim_details` DISABLE KEYS */;
INSERT INTO `claim_details` VALUES (1,'C1966','Sangeetha','Unexpected Incident, need to claim.','sangeetha@gmail.com','9988776655','P7360','processing'),(2,'C6283','Sangeetha','Met with an accident and vehicle got damaged, so need to claim.','sangeetha@gmail.com','9988776655','P5733','pending'),(3,'C5508','Rizwan','Due to earthquake, need to claim. ','rijjuclash@gmail.com','9959056068','P0548','processing'),(4,'C2361','Rizwan','Our home suffered water damage due to a burst pipe. Furniture and electronics in the living room were affected. Seeking coverage for repair costs and replacement of damaged items. ','rijjuclash@gmail.com','9959056068','P0824','approved'),(5,'C5170','Rizwan','Our home suffered water damage due to a burst pipe. Furniture and electronics in the living room were affected. Seeking coverage for repair costs and replacement of damaged items. ','rijjuclash@gmail.com','9959056068','P7289','approved'),(6,'C7025','Rizwan','Need to claim','rijjuclash@gmail.com','9959056068','P9081','pending'),(7,'C0054','Rizwan','Need to claim','rijjuclash@gmail.com','9959056068','P9081','approved');
/*!40000 ALTER TABLE `claim_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,'rijjuclash@gmail.com','I need help to buy vehicle policy ','Rizwan','9959056068'),(6,'rijjuclash@gmail.com','Hi have query regarding claim process','Rizwan','9959056068');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `home_insurance_plan`
--

DROP TABLE IF EXISTS `home_insurance_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `home_insurance_plan` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `policy_number` varchar(255) DEFAULT NULL,
  `premium` double DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_insurance_plan`
--

LOCK TABLES `home_insurance_plan` WRITE;
/*!40000 ALTER TABLE `home_insurance_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `home_insurance_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance`
--

DROP TABLE IF EXISTS `insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insurance` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `policy_name` varchar(255) DEFAULT NULL,
  `policy_type` varchar(255) DEFAULT NULL,
  `premium` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance`
--

LOCK TABLES `insurance` WRITE;
/*!40000 ALTER TABLE `insurance` DISABLE KEYS */;
INSERT INTO `insurance` VALUES (1,'Insurance for motorcycles providing coverage against accidents, theft, and damage. Offers protection for bodily injury and property damage liability, as well as coverage for accessories and safety apparel','Vehicle insurance','MotorcycleShield',2868),(2,'Comprehensive auto insurance policy offering protection for your vehicle against accidents, theft, vandalism, and natural disasters. Also includes coverage for medical expenses and liability claims in case of an accident','Vehicle insurance','DriveSafe Premier',3948),(3,'This policy offers robust coverage for homeowners, safeguarding against a wide range of perils including fire, burglary, natural disasters, and personal liability','Home insurance','HomeGuard Secure',6348),(4,'Coverage for your rented dwelling, personal property, and liability. Protects against theft, fire, vandalism, and certain natural disasters. Offers additional coverage for valuables and temporary living expenses','Home insurance','RentersGuard',5148);
/*!40000 ALTER TABLE `insurance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifications` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,'you have just bought a new policy'),(3,'you have just bought a new policy');
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy_holder`
--

DROP TABLE IF EXISTS `policy_holder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `policy_holder` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` int NOT NULL,
  `amount` double NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `policy_number` varchar(255) DEFAULT NULL,
  `policy_type` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy_holder`
--

LOCK TABLES `policy_holder` WRITE;
/*!40000 ALTER TABLE `policy_holder` DISABLE KEYS */;
INSERT INTO `policy_holder` VALUES (1,24,6348,'sangeetha@gmail.com','2025-04-19','female','9988776655','Sangeetha','P5733','HomeGuard Secure','2024-04-19'),(2,24,2868,'sangeetha@gmail.com','2025-04-19','female','9988776655','Sangeetha','P7360','MotorcycleShield','2024-04-19'),(3,24,5148,'rijjuclash@gmail.com','2025-04-19','male','9959056068','Rizwan','P0548','RentersGuard','2024-04-19'),(4,24,6348,'rijjuclash@gmail.com','2025-04-23','male','9959056068','Rizwan','P0824','HomeGuard Secure','2024-04-23'),(5,24,3948,'rijjuclash@gmail.com','2025-04-23','male','9959056068','Rizwan','P7289','DriveSafe Premier','2024-04-23'),(6,23,2868,'rijjuclash@gmail.com','2025-04-23','male','9959056068','Rizwan','P9081','MotorcycleShield','2024-04-23');
/*!40000 ALTER TABLE `policy_holder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdetails`
--

DROP TABLE IF EXISTS `userdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdetails` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `confirmpassword` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobilenumber` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdetails`
--

LOCK TABLES `userdetails` WRITE;
/*!40000 ALTER TABLE `userdetails` DISABLE KEYS */;
INSERT INTO `userdetails` VALUES (1,'Hyderabad','Rizwan12','Insurance Seeker, and here to get policies for home, vehicle and etc .\nI want smoother process to complete the policy buying .','rijjuclash@gmail.com','9959056068','Rizwan','Rizwan12'),(2,'Hyderabad','Preethi12','Developer','preethireddy572@gmail.com','9988776655','Preethi','Preethi12'),(3,'Bangalore','preethi@123','Insurance Seeker','preethi@gmail.com','9845673456','preethi','preethi@123'),(4,'Karnataka','Sangeetha12','Insurance Seeker','sangeetha@gmail.com','9988776655','Sangeetha','Sangeetha12'),(5,NULL,'Pavani12',NULL,'pavaniayama123@gmail.com','9182972018','pavani','Pavani12');
/*!40000 ALTER TABLE `userdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'insurance'
--

--
-- Dumping routines for database 'insurance'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-16 14:29:19
