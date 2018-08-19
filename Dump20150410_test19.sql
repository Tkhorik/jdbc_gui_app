CREATE DATABASE  IF NOT EXISTS `test19` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test19`;
-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: test19
-- ------------------------------------------------------
-- Server version	5.5.41-0ubuntu0.12.04.1

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
-- Table structure for table `A`
--

DROP TABLE IF EXISTS `A`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `A` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sdafasdfasdf` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `A`
--

LOCK TABLES `A` WRITE;
/*!40000 ALTER TABLE `A` DISABLE KEYS */;
INSERT INTO `A` VALUES (1,'sdfgsdfgsd'),(2,'');
/*!40000 ALTER TABLE `A` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `C`
--

DROP TABLE IF EXISTS `C`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `C` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Ccolasdfgasdfasd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `C`
--

LOCK TABLES `C` WRITE;
/*!40000 ALTER TABLE `C` DISABLE KEYS */;
/*!40000 ALTER TABLE `C` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `B`
--

DROP TABLE IF EXISTS `B`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `B` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sdfasdfsda` varchar(45) DEFAULT NULL,
  `idA` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_B_1sdfadfs` (`idA`),
  CONSTRAINT `fk_B_1sdfadfs` FOREIGN KEY (`idA`) REFERENCES `A` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `B`
--

LOCK TABLES `B` WRITE;
/*!40000 ALTER TABLE `B` DISABLE KEYS */;
/*!40000 ALTER TABLE `B` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Categorie`
--

DROP TABLE IF EXISTS `Categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Categorie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `denumire` varchar(45) DEFAULT NULL,
  `descriere` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Categorie`
--

LOCK TABLES `Categorie` WRITE;
/*!40000 ALTER TABLE `Categorie` DISABLE KEYS */;
INSERT INTO `Categorie` VALUES (2,'dfdd','fdd'),(3,'dffgvfsd','ffffvfvfv'),(4,'fsddfsf','fdffvvvsdvvfvff'),(5,'aaaaaa','aaaaaaaaaaaaaddd'),(6,'jTextField2','dfvffgfggf'),(7,'jTextField2','sdsds'),(8,'jTextField2www','sdsdswwww');
/*!40000 ALTER TABLE `Categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cursant`
--

DROP TABLE IF EXISTS `Cursant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cursant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) DEFAULT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  `idGrupa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Cursant_1ddd` (`idGrupa`),
  CONSTRAINT `fk_Cursant_1ddd` FOREIGN KEY (`idGrupa`) REFERENCES `Grupa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cursant`
--

LOCK TABLES `Cursant` WRITE;
/*!40000 ALTER TABLE `Cursant` DISABLE KEYS */;
INSERT INTO `Cursant` VALUES (2,'nn','aaa',1);
/*!40000 ALTER TABLE `Cursant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AC`
--

DROP TABLE IF EXISTS `AC`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AC` (
  `idA` int(11) NOT NULL,
  `idC` int(11) NOT NULL,
  KEY `fk_AC_sadffdsfdsdsfa` (`idA`),
  KEY `fk_AC_1dsfsadf` (`idC`),
  CONSTRAINT `fk_AC_1dsfsadf` FOREIGN KEY (`idC`) REFERENCES `C` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_AC_sadffdsfdsdsfa` FOREIGN KEY (`idA`) REFERENCES `A` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AC`
--

LOCK TABLES `AC` WRITE;
/*!40000 ALTER TABLE `AC` DISABLE KEYS */;
/*!40000 ALTER TABLE `AC` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produs`
--

DROP TABLE IF EXISTS `produs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titlu` varchar(45) DEFAULT NULL,
  `autor` varchar(45) DEFAULT NULL,
  `anuleditiei` int(11) DEFAULT NULL,
  `idCategorie` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_produs_1dff` (`idCategorie`),
  CONSTRAINT `fk_produs_1dff` FOREIGN KEY (`idCategorie`) REFERENCES `Categorie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produs`
--

LOCK TABLES `produs` WRITE;
/*!40000 ALTER TABLE `produs` DISABLE KEYS */;
/*!40000 ALTER TABLE `produs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ddimag`
--

DROP TABLE IF EXISTS `ddimag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ddimag` (
  `iddd` int(11) NOT NULL,
  `data` varchar(45) DEFAULT NULL,
  `imgdata` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iddd`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ddimag`
--

LOCK TABLES `ddimag` WRITE;
/*!40000 ALTER TABLE `ddimag` DISABLE KEYS */;
INSERT INTO `ddimag` VALUES (1,'2002-12-23',NULL);
/*!40000 ALTER TABLE `ddimag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Grupa`
--

DROP TABLE IF EXISTS `Grupa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Grupa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `denumire` varchar(45) DEFAULT NULL,
  `descriere` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Grupa`
--

LOCK TABLES `Grupa` WRITE;
/*!40000 ALTER TABLE `Grupa` DISABLE KEYS */;
INSERT INTO `Grupa` VALUES (1,'A','aaa'),(3,'B','bbb');
/*!40000 ALTER TABLE `Grupa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departament`
--

DROP TABLE IF EXISTS `departament`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departament` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `denumire` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `denumire_UNIQUE` (`denumire`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departament`
--

LOCK TABLES `departament` WRITE;
/*!40000 ALTER TABLE `departament` DISABLE KEYS */;
INSERT INTO `departament` VALUES (1,'AA'),(8,'aaa'),(9,'aaaaaaaaaa'),(10,'bbbb'),(20,'ffff'),(21,'ffffffff'),(23,'sdddd'),(22,'ssssssss'),(24,'ssssssssssssssssssssssssssssss'),(25,'zz');
/*!40000 ALTER TABLE `departament` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ANGAJAT`
--

DROP TABLE IF EXISTS `ANGAJAT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ANGAJAT` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) DEFAULT NULL,
  `prenume` varchar(45) DEFAULT NULL,
  `slariu` int(11) DEFAULT NULL,
  `idDepartament` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_ANGAJAT_1` (`idDepartament`),
  CONSTRAINT `fk_ANGAJAT_1` FOREIGN KEY (`idDepartament`) REFERENCES `departament` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ANGAJAT`
--

LOCK TABLES `ANGAJAT` WRITE;
/*!40000 ALTER TABLE `ANGAJAT` DISABLE KEYS */;
INSERT INTO `ANGAJAT` VALUES (1,'Coropceanu','Iurie',20000,1),(2,'Ion','IOnnn',5000,8),(3,'NUme19','pre',19000,9),(4,'aaa','bbb',12234,1),(7,'sss','ffff',333,8),(8,'dddd','dddd',333,9),(9,'etyert','4545',4545,9),(11,'AAAAAAA','VVVVVV',333,9),(13,'aaaaa','bbbbbbbbbb',33,8),(14,'ssdd','ssrr',33,1),(15,'abbb','pppzzz12',345,1),(16,'aaaa','bbb',4,25);
/*!40000 ALTER TABLE `ANGAJAT` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-10 17:00:32
