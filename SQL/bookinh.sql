CREATE DATABASE  IF NOT EXISTS `booking_tour` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `booking_tour`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: booking_tour
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `tbl_account`
--

DROP TABLE IF EXISTS `tbl_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_account` (
  `account_id` int NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `state` int DEFAULT NULL,
  `role` int DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_account`
--

LOCK TABLES `tbl_account` WRITE;
/*!40000 ALTER TABLE `tbl_account` DISABLE KEYS */;
INSERT INTO `tbl_account` VALUES (1,'Kenna Lerner','kX9~Frx0','http://dummyimage.com/0x87.png/ff4444/ffffff',0,0),(2,'Rog O\'Leahy','dH0>VmX=','http://dummyimage.com/0x34.png/ff4444/ffffff',1,0),(3,'Dominica Hullins','wP0@#h+A','http://dummyimage.com/0x44.png/5fa2dd/ffffff',1,1),(4,'Rudolph Provost','bK3\'|Cx+8G}g','http://dummyimage.com/0x41.png/dddddd/000000',0,1),(5,'Gloriana Hannaway','dE8&!bK&<`','http://dummyimage.com/0x52.png/cc0000/ffffff',0,2),(6,'Dorri Binch','eD5>D8){NhI','http://dummyimage.com/0x0.png/cc0000/ffffff',1,2),(7,'Scarlet Insko','rJ2<Pu}pi3Du','http://dummyimage.com/0x42.png/cc0000/ffffff',0,2),(8,'Cele Hulks','oL8.%.B*`0gViG','http://dummyimage.com/0x13.png/dddddd/000000',1,2),(9,'Andriette Staples','sX5%lX2`Xh{7','http://dummyimage.com/0x54.png/ff4444/ffffff',0,1),(10,'Dominick Atlay','qQ9`oi#{,UM%','http://dummyimage.com/0x33.png/cc0000/ffffff',1,0);
/*!40000 ALTER TABLE `tbl_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_booking`
--

DROP TABLE IF EXISTS `tbl_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_booking` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `customers_id` int DEFAULT NULL,
  `booking_name` varchar(45) DEFAULT NULL,
  `booking_date` datetime DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  `payment` varchar(45) DEFAULT NULL,
  `number_of_people` int DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `fk_customer_idx` (`customers_id`),
  CONSTRAINT `fk_customer` FOREIGN KEY (`customers_id`) REFERENCES `tbl_customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_booking`
--

LOCK TABLES `tbl_booking` WRITE;
/*!40000 ALTER TABLE `tbl_booking` DISABLE KEYS */;
INSERT INTO `tbl_booking` VALUES (1,1,'Lucian Gors','1999-10-09 00:00:00',1,'Gustie Tankard',26),(2,2,'Osgood Kilpatrick','1996-06-24 00:00:00',0,'Keeley Jakubovsky',27),(3,3,'Aretha Betham','1995-11-06 00:00:00',1,'Daphna Ditty',29),(4,4,'Raynard Elliss','2001-05-06 00:00:00',0,'Clemmie Deville',30),(5,5,'Fabian Pash','1998-01-28 00:00:00',1,'Shela Coggell',27),(6,6,'Andree Durden','1995-11-06 00:00:00',1,'Cirillo Snazel',30),(7,7,'Austin Lavens','1992-12-30 00:00:00',1,'Sheelah Bignal',30),(8,8,'Jan Espinheira','1992-04-07 00:00:00',0,'Carita Etock',21),(9,9,'Lona Milbank','1998-11-27 00:00:00',1,'Sherri Sunderland',26),(10,10,'Emelyne Compson','2002-03-07 00:00:00',1,'Shana Spelwood',30);
/*!40000 ALTER TABLE `tbl_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_comment`
--

DROP TABLE IF EXISTS `tbl_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_comment` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(45) DEFAULT NULL,
  `state` int DEFAULT NULL,
  `comment_date` datetime DEFAULT NULL,
  `account_id` int DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `fk_account_2_idx` (`account_id`),
  CONSTRAINT `fk_account_2` FOREIGN KEY (`account_id`) REFERENCES `tbl_account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_comment`
--

LOCK TABLES `tbl_comment` WRITE;
/*!40000 ALTER TABLE `tbl_comment` DISABLE KEYS */;
INSERT INTO `tbl_comment` VALUES (1,'Paulo Parslow',0,'2023-03-12 00:00:00',1),(2,'Rici Cicculi',1,'2023-02-13 00:00:00',2),(3,'Allan Riehm',1,'2023-08-13 00:00:00',3),(4,'Benji Archbell',0,'2023-05-16 00:00:00',1),(5,'Gennie Iiannone',1,'2023-03-24 00:00:00',5),(6,'Hilarius Roycroft',0,'2023-01-20 00:00:00',5),(7,'Yorgo McGurk',1,'2023-07-25 00:00:00',7),(8,'Ardenia Thorius',0,'2023-02-20 00:00:00',3),(9,'Dianemarie Eddow',0,'2023-01-26 00:00:00',9),(10,'Schuyler Scarr',0,'2023-03-23 00:00:00',10);
/*!40000 ALTER TABLE `tbl_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_customer`
--

DROP TABLE IF EXISTS `tbl_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `account_id` int DEFAULT NULL,
  `customer_name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `fk_account_idx` (`account_id`),
  CONSTRAINT `fk_account` FOREIGN KEY (`account_id`) REFERENCES `tbl_account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customer`
--

LOCK TABLES `tbl_customer` WRITE;
/*!40000 ALTER TABLE `tbl_customer` DISABLE KEYS */;
INSERT INTO `tbl_customer` VALUES (1,1,'Tallie Labone','Vasilis Seefus','8653607285','vseefus0@phpbb.com','1','1998-04-15 00:00:00'),(2,2,'Alick Iannetti','Vivie Speek','8549509188','vspeek1@aol.com','1','1992-04-19 00:00:00'),(3,3,'Lorna Amery','Marquita Livingstone','5748928902','mlivingstone2@unblog.fr','0','1993-10-27 00:00:00'),(4,4,'Baudoin Maffi','Antonino Winward','3696487028','awinward3@vkontakte.ru','0','2000-10-21 00:00:00'),(5,5,'Lilian Gorce','Brandais Lynagh','3669066556','blynagh4@aol.com','0','1994-02-17 00:00:00'),(6,6,'Kristen Oylett','Dodi Clacey','3027564387','dclacey5@yahoo.co.jp','0','1997-06-29 00:00:00'),(7,7,'Sherill Fincke','Edwin Foukx','5254482218','efoukx6@reddit.com','1','1992-08-07 00:00:00'),(8,8,'Chrystel Jopp','Ashely Hanvey','6489629810','ahanvey7@spiegel.de','0','1997-05-26 00:00:00'),(9,9,'Vivia Hedling','Ingeberg Hartus','2309168975','ihartus8@livejournal.com','1','1995-01-20 00:00:00'),(10,10,'Cicily Sawood','Judd Branche','5923282691','jbranche9@parallels.com','1','1996-04-01 00:00:00');
/*!40000 ALTER TABLE `tbl_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_customer_tour`
--

DROP TABLE IF EXISTS `tbl_customer_tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_customer_tour` (
  `customers_tours_id` int NOT NULL AUTO_INCREMENT,
  `tours_id` int DEFAULT NULL,
  `customers_id` int DEFAULT NULL,
  `state` int DEFAULT NULL,
  PRIMARY KEY (`customers_tours_id`),
  KEY `fk_tours_3_idx` (`tours_id`),
  KEY `fk_customer_idx` (`customers_id`),
  CONSTRAINT `fk_customer_2` FOREIGN KEY (`customers_id`) REFERENCES `tbl_customer` (`customer_id`),
  CONSTRAINT `fk_tours_5` FOREIGN KEY (`tours_id`) REFERENCES `tbl_tours` (`tours_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customer_tour`
--

LOCK TABLES `tbl_customer_tour` WRITE;
/*!40000 ALTER TABLE `tbl_customer_tour` DISABLE KEYS */;
INSERT INTO `tbl_customer_tour` VALUES (1,6,6,0),(2,5,9,1),(3,8,6,0),(4,7,1,0),(5,10,10,1),(6,6,2,1),(7,1,4,0),(8,1,3,1),(9,1,2,1),(10,3,1,1);
/*!40000 ALTER TABLE `tbl_customer_tour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_hotels`
--

DROP TABLE IF EXISTS `tbl_hotels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_hotels` (
  `hotels_id` int NOT NULL AUTO_INCREMENT,
  `hotels_name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `hotline` varchar(45) DEFAULT NULL,
  `standard` int DEFAULT NULL,
  `website` varchar(45) DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  `comment_id` int DEFAULT NULL,
  `available_room` int DEFAULT NULL,
  PRIMARY KEY (`hotels_id`),
  KEY `fk_comment_idx` (`comment_id`),
  CONSTRAINT `fk_comment` FOREIGN KEY (`comment_id`) REFERENCES `tbl_comment` (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_hotels`
--

LOCK TABLES `tbl_hotels` WRITE;
/*!40000 ALTER TABLE `tbl_hotels` DISABLE KEYS */;
INSERT INTO `tbl_hotels` VALUES (1,'Pen Andrick','Lane','702 290 2494',4,'webnode.com','Ibbie Archibald',1,8),(2,'Bailie Limeburner','Court','264 677 3149',3,'networkadvertising.org','Mikkel Harbach',2,7),(3,'Tiffi Bumphrey','Alley','695 123 8593',2,'ustream.tv','Cullan Jeaycock',3,13),(4,'Leroi Llewelly','Drive','720 604 4132',3,'toplist.cz','Luisa Crowdy',4,16),(5,'Taylor Donahue','Parkway','566 218 9918',3,'cbc.ca','Whitaker Mibourne',5,3),(6,'Pasquale Lakes','Way','781 776 6067',1,'buzzfeed.com','Nolan Dummigan',6,9),(7,'Rycca Poppy','Road','675 553 0458',1,'cpanel.net','Winne Picardo',7,19),(8,'Otto Sutherington','Avenue','791 857 4098',2,'mediafire.com','Nance Cuchey',8,12),(9,'Aguistin Lummus','Place','546 965 2532',2,'answers.com','Berton Rodriguez',9,16),(10,'Marne Quinet','Trail','603 801 9413',2,'oracle.com','Farra Oleszkiewicz',10,3);
/*!40000 ALTER TABLE `tbl_hotels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_news`
--

DROP TABLE IF EXISTS `tbl_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_news` (
  `news_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `post_date` datetime DEFAULT NULL,
  `state` int DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  `places_id` int DEFAULT NULL,
  PRIMARY KEY (`news_id`),
  KEY `fk_places_idx` (`places_id`),
  CONSTRAINT `fk_places_3` FOREIGN KEY (`places_id`) REFERENCES `tbl_places` (`places_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_news`
--

LOCK TABLES `tbl_news` WRITE;
/*!40000 ALTER TABLE `tbl_news` DISABLE KEYS */;
INSERT INTO `tbl_news` VALUES (1,'Jamaal Cicutto','Hilda Huckabe','2023-01-02 00:00:00',1,'Ginger Gayter',1),(2,'Whitney Penkman','Wynny Kahan','2023-03-02 00:00:00',0,'Allene Crampton',2),(3,'Joelly Marchelli','Fitzgerald Scandrick','2023-08-28 00:00:00',1,'Rachel Clendennen',3),(4,'Bartel Bachman','Bab Bruckshaw','2023-03-29 00:00:00',1,'Dennie Carillo',4),(5,'Tomlin Klulik','Rosette Berk','2023-07-01 00:00:00',1,'Selene Campa',5),(6,'Tanny Benez','Merilyn Iston','2022-12-14 00:00:00',0,'Beatriz Kineton',6),(7,'Ermina Grace','Thornton Hanhart','2023-06-27 00:00:00',1,'Johannes Hawse',7),(8,'Clarie Langrick','Laina Blare','2023-03-16 00:00:00',0,'Georgianna Francesc',8),(9,'Demetria Buesnel','Guilbert Leaney','2023-09-24 00:00:00',1,'Sonnie Stile',9),(10,'Jolene Dockwray','Susi Abramov','2023-05-05 00:00:00',0,'Nanni Headan',10);
/*!40000 ALTER TABLE `tbl_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_places`
--

DROP TABLE IF EXISTS `tbl_places`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_places` (
  `places_id` int NOT NULL AUTO_INCREMENT,
  `places_name` varchar(45) DEFAULT NULL,
  `contents` varchar(45) DEFAULT NULL,
  `images` varchar(45) DEFAULT NULL,
  `scenic_spots_id` int DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  `hotels_id` int DEFAULT NULL,
  PRIMARY KEY (`places_id`),
  KEY `fk_hotel_idx` (`hotels_id`),
  KEY `fk_scen_spots_idx` (`scenic_spots_id`),
  CONSTRAINT `fk_hotel` FOREIGN KEY (`hotels_id`) REFERENCES `tbl_hotels` (`hotels_id`),
  CONSTRAINT `fk_scen_spots` FOREIGN KEY (`scenic_spots_id`) REFERENCES `tbl_scenic_spots` (`scenic_spots_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_places`
--

LOCK TABLES `tbl_places` WRITE;
/*!40000 ALTER TABLE `tbl_places` DISABLE KEYS */;
INSERT INTO `tbl_places` VALUES (1,'Maurita MacRory','Road','http://dummyimage.com/0x40.png/5fa2dd/ffffff',1,'Estell Beagen',1),(2,'Hilly Westcott','Junction','http://dummyimage.com/0x76.png/cc0000/ffffff',2,'Lorena Boardman',2),(3,'Ebony Back','Crossing','http://dummyimage.com/0x43.png/ff4444/ffffff',3,'Angeline Selman',3),(4,'Fin Conman','Pass','http://dummyimage.com/0x53.png/dddddd/000000',4,'Teri Schoolfield',4),(5,'Uriel Bushrod','Way','http://dummyimage.com/0x65.png/cc0000/ffffff',5,'Lela Stanton',5),(6,'Colet Manders','Point','http://dummyimage.com/0x45.png/dddddd/000000',6,'Trudy Burgess',6),(7,'Amery Kiddye','Way','http://dummyimage.com/0x59.png/5fa2dd/ffffff',7,'Gerta Woodnutt',7),(8,'Bradly Wanjek','Road','http://dummyimage.com/0x4.png/dddddd/000000',8,'Katuscha Bond',8),(9,'Berti Vogele','Point','http://dummyimage.com/0x38.png/ff4444/ffffff',9,'Pebrook Ksandra',9),(10,'Phedra Blucher','Drive','http://dummyimage.com/0x25.png/dddddd/000000',10,'Elana Devereux',10);
/*!40000 ALTER TABLE `tbl_places` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_scenic_spots`
--

DROP TABLE IF EXISTS `tbl_scenic_spots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_scenic_spots` (
  `scenic_spots_id` int NOT NULL AUTO_INCREMENT,
  `scenic_spots_name` varchar(45) DEFAULT NULL,
  `contents` varchar(45) DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  `state` int DEFAULT NULL,
  `visitor_io_number` varchar(45) DEFAULT NULL,
  `ticket_price` double DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`scenic_spots_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_scenic_spots`
--

LOCK TABLES `tbl_scenic_spots` WRITE;
/*!40000 ALTER TABLE `tbl_scenic_spots` DISABLE KEYS */;
INSERT INTO `tbl_scenic_spots` VALUES (1,'Morley Braunstein','Plaza','http://dummyimage.com/0x72.png/5fa2dd/ffffff',1,'96',10,'Kienan Roust'),(2,'Horst Klaaasen','Way','http://dummyimage.com/0x37.png/cc0000/ffffff',1,'37',20,'Amandie Braddick'),(3,'Hammad Salleir','Crossing','http://dummyimage.com/0x67.png/5fa2dd/ffffff',1,'53',19,'Robby Kreuzer'),(4,'Malissa Tretter','Place','http://dummyimage.com/0x19.png/cc0000/ffffff',1,'74',12,'Bartholomeo Root'),(5,'Ingaberg Campsall','Crossing','http://dummyimage.com/0x30.png/ff4444/ffffff',1,'30',19,'Eduino Klimpke'),(6,'Will Ramiro','Trail','http://dummyimage.com/0x48.png/cc0000/ffffff',0,'27',17,'Niels Stoner'),(7,'Franny Kobus','Park','http://dummyimage.com/0x74.png/5fa2dd/ffffff',0,'96',13,'Stephan Ernke'),(8,'Avigdor Paskell','Trail','http://dummyimage.com/0x48.png/cc0000/ffffff',1,'55',14,'Brietta Houseago'),(9,'Noell Allsebrook','Circle','http://dummyimage.com/0x48.png/ff4444/ffffff',1,'30',11,'Nevin Brewis'),(10,'Antonietta Tomaskunas','Circle','http://dummyimage.com/0x88.png/5fa2dd/ffffff',0,'97',17,'Neils Currao');
/*!40000 ALTER TABLE `tbl_scenic_spots` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tour_guide`
--

DROP TABLE IF EXISTS `tbl_tour_guide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_tour_guide` (
  `tour_guide_id` int NOT NULL AUTO_INCREMENT,
  `tour_guide_name` varchar(45) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tour_guide_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tour_guide`
--

LOCK TABLES `tbl_tour_guide` WRITE;
/*!40000 ALTER TABLE `tbl_tour_guide` DISABLE KEYS */;
INSERT INTO `tbl_tour_guide` VALUES (1,'Brod Poulney','1992-06-02 00:00:00','9285384755','Center','bpoulney0@guardian.co.uk',0,'http://dummyimage.com/0x83.png/ff4444/ffffff'),(2,'Lucky Brockett','1999-01-02 00:00:00','7678150928','Alley','lbrockett1@shutterfly.com',1,'http://dummyimage.com/0x86.png/ff4444/ffffff'),(3,'Adan Martelet','1990-10-28 00:00:00','4023148688','Junction','amartelet2@skype.com',1,'http://dummyimage.com/0x3.png/dddddd/000000'),(4,'Gabi Holhouse','1999-06-09 00:00:00','6776854157','Junction','gholhouse3@europa.eu',0,'http://dummyimage.com/0x38.png/cc0000/ffffff'),(5,'Granny Scallon','1996-02-13 00:00:00','3045119378','Parkway','gscallon4@microsoft.com',0,'http://dummyimage.com/0x84.png/5fa2dd/ffffff'),(6,'Benedicto Schuchmacher','1999-06-17 00:00:00','9036128644','Crossing','bschuchmacher5@indiegogo.com',1,'http://dummyimage.com/0x33.png/dddddd/000000'),(7,'Cchaddie Summers','1995-07-05 00:00:00','4153319942','Point','csummers6@bravesites.com',0,'http://dummyimage.com/0x7.png/5fa2dd/ffffff'),(8,'Devin Keech','1991-07-11 00:00:00','8703864818','Avenue','dkeech7@sohu.com',0,'http://dummyimage.com/0x79.png/cc0000/ffffff'),(9,'Wilt Bunstone','1996-01-17 00:00:00','1094697867','Alley','wbunstone8@amazonaws.com',1,'http://dummyimage.com/0x29.png/dddddd/000000'),(10,'Sherman McCuis','1992-06-17 00:00:00','6876445294','Way','smccuis9@timesonline.co.uk',0,'http://dummyimage.com/0x75.png/cc0000/ffffff');
/*!40000 ALTER TABLE `tbl_tour_guide` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tours`
--

DROP TABLE IF EXISTS `tbl_tours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_tours` (
  `tours_id` int NOT NULL,
  `tours_name` varchar(45) DEFAULT NULL,
  `contents` varchar(45) DEFAULT NULL,
  `date_go` datetime DEFAULT NULL,
  `date_back` datetime DEFAULT NULL,
  `places_id` int DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  `timeline` varchar(45) DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  `comment_id` int DEFAULT NULL,
  `price_tour` double DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  `tour_guide_id` int DEFAULT NULL,
  PRIMARY KEY (`tours_id`),
  KEY `fk_places_idx` (`places_id`),
  KEY `fk_tour_guide_idx` (`tour_guide_id`),
  KEY `fk_comment_2_idx` (`comment_id`),
  CONSTRAINT `fk_comment_2` FOREIGN KEY (`comment_id`) REFERENCES `tbl_comment` (`comment_id`),
  CONSTRAINT `fk_places` FOREIGN KEY (`places_id`) REFERENCES `tbl_places` (`places_id`),
  CONSTRAINT `fk_tour_guide` FOREIGN KEY (`tour_guide_id`) REFERENCES `tbl_tour_guide` (`tour_guide_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tours`
--

LOCK TABLES `tbl_tours` WRITE;
/*!40000 ALTER TABLE `tbl_tours` DISABLE KEYS */;
INSERT INTO `tbl_tours` VALUES (1,'Donaugh Balk','5043266425','2022-10-11 00:00:00','2022-11-04 00:00:00',1,0,'Guido Braidwood','Julie Cotterell',1,32,NULL,1),(2,'Roosevelt Jonathon','3989220142','2022-10-31 00:00:00','2022-11-07 00:00:00',2,1,'Petronella Bowling','Chariot Batisse',2,56,NULL,2),(3,'Midge Stivani','7308707522','2023-03-08 00:00:00','2023-04-01 00:00:00',3,0,'Chad Lutas','Gates Portch',3,29,NULL,3),(4,'Reg Wiffill','1533668230','2023-06-26 00:00:00','2023-08-07 00:00:00',4,0,'Kermit Silby','Barbabra Tamblingson',4,30,NULL,4),(5,'Rudd Esseby','6512680424','2023-05-04 00:00:00','2023-03-19 00:00:00',5,0,'Melinda Jendrys','Niki Colleford',5,75,NULL,5),(6,'Veriee Dalgleish','4213142820','2023-08-26 00:00:00','2022-12-27 00:00:00',6,0,'Kliment Coch','Brook Toffano',6,42,NULL,6),(7,'Elvin Lawman','7138385390','2023-07-11 00:00:00','2023-09-19 00:00:00',7,1,'Donica Waiting','Kat Cuesta',7,42,NULL,7),(8,'Kalli Hirtz','4372252901','2023-09-20 00:00:00','2023-05-02 00:00:00',8,0,'Rosana Nobles','Cynthie Mogie',8,80,NULL,8),(9,'Buddie Hadrill','9202213716','2023-09-03 00:00:00','2023-03-12 00:00:00',9,1,'Gregorius Hamblington','Bowie Tremain',9,76,NULL,9),(10,'Malvin Gordon-Giles','9904822637','2023-07-21 00:00:00','2023-08-06 00:00:00',10,1,'Udell Shortcliffe','Ardisj Rodgers',10,76,NULL,10);
/*!40000 ALTER TABLE `tbl_tours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tours_booking`
--

DROP TABLE IF EXISTS `tbl_tours_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_tours_booking` (
  `tours_booking_id` int NOT NULL AUTO_INCREMENT,
  `tours_id` int DEFAULT NULL,
  `booking_id` int DEFAULT NULL,
  PRIMARY KEY (`tours_booking_id`),
  KEY `fk_tours_idx` (`tours_id`),
  KEY `fk_booking_idx` (`booking_id`),
  CONSTRAINT `fk_booking` FOREIGN KEY (`booking_id`) REFERENCES `tbl_booking` (`booking_id`),
  CONSTRAINT `fk_tours` FOREIGN KEY (`tours_id`) REFERENCES `tbl_tours` (`tours_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tours_booking`
--

LOCK TABLES `tbl_tours_booking` WRITE;
/*!40000 ALTER TABLE `tbl_tours_booking` DISABLE KEYS */;
INSERT INTO `tbl_tours_booking` VALUES (1,9,2),(2,10,3),(3,7,4),(4,2,10),(5,6,1),(6,7,1),(7,6,9),(8,8,10),(9,7,6),(10,1,9);
/*!40000 ALTER TABLE `tbl_tours_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tours_places`
--

DROP TABLE IF EXISTS `tbl_tours_places`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_tours_places` (
  `tours_places_id` int NOT NULL AUTO_INCREMENT,
  `tours_id` int DEFAULT NULL,
  `places_id` int DEFAULT NULL,
  PRIMARY KEY (`tours_places_id`),
  KEY `fk_tours_2_idx` (`tours_id`),
  KEY `fk_places_2_idx` (`places_id`),
  CONSTRAINT `fk_places_2` FOREIGN KEY (`places_id`) REFERENCES `tbl_places` (`places_id`),
  CONSTRAINT `fk_tours_2` FOREIGN KEY (`tours_id`) REFERENCES `tbl_tours` (`tours_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tours_places`
--

LOCK TABLES `tbl_tours_places` WRITE;
/*!40000 ALTER TABLE `tbl_tours_places` DISABLE KEYS */;
INSERT INTO `tbl_tours_places` VALUES (1,10,1),(2,6,2),(3,2,9),(4,10,3),(5,9,4),(6,7,4),(7,7,3),(8,5,1),(9,2,9),(10,3,10);
/*!40000 ALTER TABLE `tbl_tours_places` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tours_scenic_spots`
--

DROP TABLE IF EXISTS `tbl_tours_scenic_spots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_tours_scenic_spots` (
  `tours_scenic_spots_id` int NOT NULL AUTO_INCREMENT,
  `tours_id` int DEFAULT NULL,
  `scenic_spots_id` int DEFAULT NULL,
  PRIMARY KEY (`tours_scenic_spots_id`),
  KEY `fk_tours_3_idx` (`tours_id`),
  KEY `fk_scen_spots_idx` (`scenic_spots_id`),
  CONSTRAINT `fk_scen_spots_2` FOREIGN KEY (`scenic_spots_id`) REFERENCES `tbl_scenic_spots` (`scenic_spots_id`),
  CONSTRAINT `fk_tours_3` FOREIGN KEY (`tours_id`) REFERENCES `tbl_tours` (`tours_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tours_scenic_spots`
--

LOCK TABLES `tbl_tours_scenic_spots` WRITE;
/*!40000 ALTER TABLE `tbl_tours_scenic_spots` DISABLE KEYS */;
INSERT INTO `tbl_tours_scenic_spots` VALUES (1,4,7),(2,9,6),(3,6,8),(4,8,1),(5,9,10),(6,5,1),(7,5,4),(8,9,5),(9,8,4),(10,1,4);
/*!40000 ALTER TABLE `tbl_tours_scenic_spots` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-08 23:41:42
