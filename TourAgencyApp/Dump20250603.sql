-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: tour_agency
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS booking;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE booking (
  booking_id int NOT NULL,
  tourist_id int DEFAULT NULL,
  tour_id int DEFAULT NULL,
  booking_date datetime DEFAULT NULL,
  number_of_people int DEFAULT NULL,
  total_price decimal(10,2) DEFAULT NULL,
  max_seats int DEFAULT NULL,
  PRIMARY KEY (booking_id),
  KEY tourist_id (tourist_id),
  KEY tour_id (tour_id),
  CONSTRAINT booking_ibfk_1 FOREIGN KEY (tourist_id) REFERENCES tourist (tourist_id),
  CONSTRAINT booking_ibfk_2 FOREIGN KEY (tour_id) REFERENCES tour (tour_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES booking WRITE;
/*!40000 ALTER TABLE booking DISABLE KEYS */;
INSERT INTO booking VALUES (1,1,1,'2025-05-28 00:00:00',2,100.00,15),(2,2,2,'2025-05-28 00:00:00',3,360.00,20),(3,3,3,'2025-06-05 00:00:00',2,400.00,10),(4,4,4,'2025-06-06 00:00:00',1,80.00,12),(5,5,5,'2025-06-07 00:00:00',3,450.00,18),(6,6,6,'2025-06-08 00:00:00',4,360.00,15),(7,7,7,'2025-07-01 00:00:00',2,200.00,20),(8,8,8,'2025-07-02 00:00:00',3,225.00,15),(9,9,9,'2025-07-03 00:00:00',1,180.00,12),(10,10,10,'2025-07-04 00:00:00',4,480.00,18);
/*!40000 ALTER TABLE booking ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guide`
--

DROP TABLE IF EXISTS guide;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE guide (
  guide_id int NOT NULL,
  first_name varchar(50) DEFAULT NULL,
  last_name varchar(50) DEFAULT NULL,
  phone_number varchar(20) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  experience_years int DEFAULT NULL,
  specialization varchar(100) DEFAULT NULL,
  availability varchar(100) DEFAULT NULL,
  languages_spoken varchar(100) DEFAULT NULL,
  rating decimal(3,2) DEFAULT NULL,
  PRIMARY KEY (guide_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guide`
--

LOCK TABLES guide WRITE;
/*!40000 ALTER TABLE guide DISABLE KEYS */;
INSERT INTO guide VALUES (1,'Олександр','Ковальчук','+380671234567','olexandr.k@example.com',5,'Історичні тури','Доступний','Українська, Англійська',4.80),(2,'Марина','Горобець','+380501234567','marina.g@example.com',3,'Культурні тури','Доступний','Українська, Польська',4.50),(3,'Іван','Мельник','+380671234568','ivan.m@example.com',7,'Пригодницькі тури','Доступний','Українська, Англійська',4.90),(4,'Юлія','Дорошенко','+380501234568','yulia.d@example.com',4,'Кулінарні тури','Доступний','Українська, Французька',4.60),(5,'Петро','Гнатюк','+380931234569','petro.g@example.com',6,'Екскурсії на природу','Недоступний','Українська, Німецька',4.70),(6,'Софія','Лисенко','+380671234570','sofia.l@example.com',5,'Історичні тури','Доступний','Українська, Англійська',4.80),(7,'Михайло','Захарченко','+380671234573','mykhailo.z@example.com',8,'Культурні тури','Доступний','Українська, Англійська',4.90),(8,'Оксана','Романюк','+380501234574','oksana.r@example.com',5,'Природні екскурсії','Доступний','Українська, Іспанська',4.70),(9,'Василь','Соловйов','+380931234575','vasyl.s@example.com',6,'Архітектурні тури','Недоступний','Українська, Німецька',4.80),(10,'Ганна','Коваленко','+380671234576','hanna.k@example.com',7,'Гастрономічні тури','Доступний','Українська, Французька',4.60);
/*!40000 ALTER TABLE guide ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS location;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE location (
  location_id int NOT NULL,
  location_name varchar(100) DEFAULT NULL,
  address varchar(200) DEFAULT NULL,
  PRIMARY KEY (location_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES location WRITE;
/*!40000 ALTER TABLE location DISABLE KEYS */;
INSERT INTO location VALUES (1,'Площа Ринок','Львів, Україна'),(2,'Замок Паланок','Мукачево, Україна'),(3,'Говерла','Карпати, Україна'),(4,'Львівська майстерня шоколаду','Львів, Україна'),(5,'Олеський замок','Олесько, Україна'),(6,'Карпатський біосферний заповідник','Закарпаття, Україна'),(7,'Софійський собор','Київ, Україна'),(8,'Підземелля Львова','Львів, Україна'),(9,'Дністровський каньйон','Чернівецька область, Україна'),(10,'Закарпатська виноробня','Закарпаття, Україна');
/*!40000 ALTER TABLE location ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS payment;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE payment (
  payment_id int NOT NULL,
  booking_id int DEFAULT NULL,
  payment_date datetime DEFAULT NULL,
  amount_paid decimal(10,2) DEFAULT NULL,
  payment_method varchar(50) DEFAULT NULL,
  tourist_id int DEFAULT NULL,
  tour_id int DEFAULT NULL,
  PRIMARY KEY (payment_id),
  KEY booking_id (booking_id),
  KEY tourist_id (tourist_id),
  KEY tour_id (tour_id),
  CONSTRAINT payment_ibfk_1 FOREIGN KEY (booking_id) REFERENCES booking (booking_id),
  CONSTRAINT payment_ibfk_2 FOREIGN KEY (tourist_id) REFERENCES tourist (tourist_id),
  CONSTRAINT payment_ibfk_3 FOREIGN KEY (tour_id) REFERENCES tour (tour_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES payment WRITE;
/*!40000 ALTER TABLE payment DISABLE KEYS */;
INSERT INTO payment VALUES (1,1,'2025-05-28 00:00:00',100.00,'Кредитна картка',1,1),(2,2,'2025-05-28 00:00:00',360.00,'Банківський переказ',2,2),(3,3,'2025-06-05 00:00:00',400.00,'Кредитна картка',3,3),(4,4,'2025-06-06 00:00:00',80.00,'Готівка',4,4),(5,5,'2025-06-07 00:00:00',450.00,'Банківський переказ',5,5),(6,6,'2025-06-08 00:00:00',360.00,'Кредитна картка',6,6),(7,7,'2025-07-01 00:00:00',200.00,'Кредитна картка',7,7),(8,8,'2025-07-02 00:00:00',225.00,'Готівка',8,8),(9,9,'2025-07-03 00:00:00',180.00,'Банківський переказ',9,9),(10,10,'2025-07-04 00:00:00',480.00,'Кредитна картка',10,10);
/*!40000 ALTER TABLE payment ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS schedule;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  schedule_id int NOT NULL,
  tour_id int DEFAULT NULL,
  guide_id int DEFAULT NULL,
  start_time datetime DEFAULT NULL,
  end_time datetime DEFAULT NULL,
  PRIMARY KEY (schedule_id),
  KEY tour_id (tour_id),
  KEY guide_id (guide_id),
  CONSTRAINT schedule_ibfk_1 FOREIGN KEY (tour_id) REFERENCES tour (tour_id),
  CONSTRAINT schedule_ibfk_2 FOREIGN KEY (guide_id) REFERENCES guide (guide_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES schedule WRITE;
/*!40000 ALTER TABLE schedule DISABLE KEYS */;
INSERT INTO schedule VALUES (1,1,1,'2025-06-15 10:00:00','2025-06-15 12:30:00'),(2,2,2,'2025-06-20 08:00:00','2025-06-20 14:00:00');
/*!40000 ALTER TABLE schedule ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour`
--

DROP TABLE IF EXISTS tour;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE tour (
  tour_id int NOT NULL,
  tour_name varchar(100) DEFAULT NULL,
  `description` text,
  price decimal(10,2) DEFAULT NULL,
  duration time DEFAULT NULL,
  date_time datetime DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `language` varchar(50) DEFAULT NULL,
  max_group_size int DEFAULT NULL,
  difficulty_level varchar(50) DEFAULT NULL,
  detailed_description text,
  tour_type varchar(50) DEFAULT NULL,
  rating decimal(3,2) DEFAULT NULL,
  tour_category varchar(50) DEFAULT NULL,
  PRIMARY KEY (tour_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour`
--

LOCK TABLES tour WRITE;
/*!40000 ALTER TABLE tour DISABLE KEYS */;
INSERT INTO tour VALUES (1,'Львівська спадщина','Екскурсія історичними місцями Львова',50.00,'02:30:00','2025-06-15 10:00:00','Пішохідний','Українська',15,'Середній','Детальний огляд визначних пам\'яток','Культурний',4.70,'Історичні'),(2,'Замки Західної України','Подорож найвідомішими замками регіону',120.00,'06:00:00','2025-06-20 08:00:00','Автобусний','Українська',20,'Легкий','Відвідування кількох замків','Екскурсійний',4.90,'Архітектура'),(3,'Карпати: дикі стежки','Тур у гори для любителів пригод',200.00,'08:00:00','2025-07-10 06:00:00','Пішохідний','Українська',10,'Складний','Виживання, походи, кемпінг','Пригодницький',4.80,'Природа'),(4,'Гастрономічний Львів','Спробуйте найкращі страви Львова',80.00,'04:00:00','2025-07-15 12:00:00','Пішохідний','Українська',12,'Легкий','Дегустація традиційної їжі','Кулінарний',4.60,'Гастрономія'),(5,'Замки Львівщини','Подорож найстарішими замками регіону',150.00,'07:00:00','2025-07-20 09:00:00','Автобусний','Українська',18,'Середній','Відвідування історичних місць','Екскурсійний',4.90,'Архітектура'),(6,'Еко-тур у заповідник','Ознайомлення з природними ландшафтами та тваринами',90.00,'05:00:00','2025-07-25 07:00:00','Пішохідний','Українська',15,'Легкий','Вивчення флори та фауни','Природний',4.70,'Екологія'),(7,'Стародавній Київ','Історичний екскурс в життя Києва',100.00,'05:00:00','2025-08-10 09:00:00','Пішохідний','Українська',20,'Середній','Огляд старовинних кварталів','Історичний',4.70,'Культура'),(8,'Таємниці Львова','Містичні історії старого Львова',75.00,'03:30:00','2025-08-15 18:00:00','Пішохідний','Українська',15,'Легкий','Розповіді про легенди міста','Культурний',4.60,'Легенди'),(9,'Дністровський каньйон','Еко-тур по Дністровському каньйону',180.00,'08:00:00','2025-08-20 07:00:00','Автобусний','Українська',12,'Середній','Вивчення природи та пейзажів','Природний',4.80,'Екологія'),(10,'Винні дороги Закарпаття','Дегустація найкращих вин Закарпаття',120.00,'06:00:00','2025-08-25 10:00:00','Автобусний','Українська',18,'Легкий','Відвідування виноробень','Гастрономічний',4.90,'Гастрономія');
/*!40000 ALTER TABLE tour ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour_guide`
--

DROP TABLE IF EXISTS tour_guide;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE tour_guide (
  tour_id int NOT NULL,
  guide_id int NOT NULL,
  PRIMARY KEY (tour_id,guide_id),
  KEY guide_id (guide_id),
  CONSTRAINT tour_guide_ibfk_1 FOREIGN KEY (tour_id) REFERENCES tour (tour_id),
  CONSTRAINT tour_guide_ibfk_2 FOREIGN KEY (guide_id) REFERENCES guide (guide_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour_guide`
--

LOCK TABLES tour_guide WRITE;
/*!40000 ALTER TABLE tour_guide DISABLE KEYS */;
/*!40000 ALTER TABLE tour_guide ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour_location`
--

DROP TABLE IF EXISTS tour_location;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE tour_location (
  tour_id int NOT NULL,
  location_id int NOT NULL,
  sequence int DEFAULT NULL,
  PRIMARY KEY (tour_id,location_id),
  KEY location_id (location_id),
  CONSTRAINT tour_location_ibfk_1 FOREIGN KEY (tour_id) REFERENCES tour (tour_id),
  CONSTRAINT tour_location_ibfk_2 FOREIGN KEY (location_id) REFERENCES location (location_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour_location`
--

LOCK TABLES tour_location WRITE;
/*!40000 ALTER TABLE tour_location DISABLE KEYS */;
INSERT INTO tour_location VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,1),(5,5,1),(6,6,1),(7,7,1),(8,8,1),(9,9,1),(10,10,1);
/*!40000 ALTER TABLE tour_location ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourist`
--

DROP TABLE IF EXISTS tourist;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE tourist (
  tourist_id int NOT NULL,
  first_name varchar(50) DEFAULT NULL,
  last_name varchar(50) DEFAULT NULL,
  phone_number varchar(20) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  PRIMARY KEY (tourist_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourist`
--

LOCK TABLES tourist WRITE;
/*!40000 ALTER TABLE tourist DISABLE KEYS */;
INSERT INTO tourist VALUES (1,'Андрій','Петренко','+380931234567','andriy.p@example.com'),(2,'Ольга','Сидоренко','+380671234890','olga.s@example.com'),(3,'Володимир','Кириленко','+380931234571','volodymyr.k@example.com'),(4,'Катерина','Захаренко','+380671234572','kateryna.z@example.com'),(5,'Дмитро','Лобач','+380501234573','dmytro.l@example.com'),(6,'Наталія','Семенюк','+380931234574','nataliya.s@example.com'),(7,'Ірина','Бойко','+380931234577','iryna.b@example.com'),(8,'Роман','Міщенко','+380671234578','roman.m@example.com'),(9,'Анастасія','Федоренко','+380501234579','anastasia.f@example.com'),(10,'Юрій','Павленко','+380931234580','yuriy.p@example.com');
/*!40000 ALTER TABLE tourist ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tour_agency'
--

--
-- Dumping routines for database 'tour_agency'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-03  0:15:59
