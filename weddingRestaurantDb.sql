-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: wedding_restaurant
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `anh_sanh`
--

DROP TABLE IF EXISTS `anh_sanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anh_sanh` (
  `id` int NOT NULL AUTO_INCREMENT,
  `anh_sanh` varchar(255) DEFAULT NULL,
  `sanh_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `anh_sanh1_idx` (`sanh_id`),
  CONSTRAINT `anh_sanh1` FOREIGN KEY (`sanh_id`) REFERENCES `thong_tin_sanh` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anh_sanh`
--

LOCK TABLES `anh_sanh` WRITE;
/*!40000 ALTER TABLE `anh_sanh` DISABLE KEYS */;
INSERT INTO `anh_sanh` VALUES (1,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1692199645/ifxbrlsjkesaxxqhzyeh.jpg',1),(2,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1692197966/zeyvhcsimpsmdvtfsf7r.jpg',1),(4,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693119989/v745ry1cpbpzyk5k8yev.jpg',10),(6,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120480/eibaqveyryhnpdgbtyki.jpg',19),(7,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120495/rdmgl3vvqma6skfq0sjb.jpg',1),(8,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120510/ci6dfyrmbyywjjjqsecb.jpg',4),(9,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120520/hcarakqa84q90m3lsxhz.jpg',5),(10,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120532/cpenpt6vda0pcdjkymn1.jpg',6),(11,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120554/fbbgkboetempc2ltakzl.jpg',12),(12,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120571/jaucu62esaaw58k3drhy.jpg',13),(13,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120596/jwxuhmsspla5dqlyx1zi.jpg',14),(14,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120607/cstj7yrwbzjch95uzbvc.jpg',14),(15,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120619/qlehqpoo0y0whtbzqquc.jpg',14),(16,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120634/xi4kdixsezswdarvslcr.jpg',15),(17,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120658/fwnwv5op3ratpijvkojj.jpg',7),(18,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120669/yidaxbnuaejqxo2bxgeh.jpg',7),(19,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120680/jtlubfdvunz8icqp24zq.jpg',7),(20,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120695/bqv67kdscuvvdajjuvwp.jpg',8),(21,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693120730/uq5ab392oyjiaragpqjo.jpg',9),(22,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693229226/qcacjdpm7qlmy3tgfipf.jpg',17),(23,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693229244/ttqmcub1pfmuzouns7pf.jpg',17),(25,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1693325141/mpuqj7y2r1kgvjz5tgtt.jpg',12),(26,'https://res.cloudinary.com/dgkrvmsli/image/upload/v1694272653/uvtzsbvpsslf55bey0t3.jpg',20);
/*!40000 ALTER TABLE `anh_sanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chi_nhanh`
--

DROP TABLE IF EXISTS `chi_nhanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chi_nhanh` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten_chi_nhanh` varchar(255) NOT NULL,
  `dia_chi` varchar(255) NOT NULL,
  `isDelete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chi_nhanh`
--

LOCK TABLES `chi_nhanh` WRITE;
/*!40000 ALTER TABLE `chi_nhanh` DISABLE KEYS */;
INSERT INTO `chi_nhanh` VALUES (1,'Sunset 1','371 Nguyễn Kiêm',0),(2,'Sunset 2','666 Lê Trọng Tấn',0),(8,'Sunset 1','371 Nguyá»n KiÃªm',1),(9,'test','666 LÃª Trá»ng Táº¥n',1),(10,'test1','666 LÃÂª TrÃ¡Â»Âng TÃ¡ÂºÂ¥n',1),(11,'test11111','test',1),(12,'Trần Phú','trần phú, trường huệ',1),(13,'test1','666 Lê Trọng Tấn',1),(14,'test 1','666 Lê Trọng Tấn 2',1),(15,'test1','666 Lê Trọng Tấn',1),(16,'test1','666 Lê Trọng Tấn',1),(17,'test1','666 Lê Trọng Tấn',1);
/*!40000 ALTER TABLE `chi_nhanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chuc_vu`
--

DROP TABLE IF EXISTS `chuc_vu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chuc_vu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `chuc_vu` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuc_vu`
--

LOCK TABLES `chuc_vu` WRITE;
/*!40000 ALTER TABLE `chuc_vu` DISABLE KEYS */;
INSERT INTO `chuc_vu` VALUES (1,'Admin'),(2,'Phục vụ'),(3,'Quản lý'),(4,'Lễ tân');
/*!40000 ALTER TABLE `chuc_vu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dich_vu`
--

DROP TABLE IF EXISTS `dich_vu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dich_vu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `loai_dich_vu` varchar(45) NOT NULL,
  `gia_dich_vu` float NOT NULL,
  `isDelete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dich_vu`
--

LOCK TABLES `dich_vu` WRITE;
/*!40000 ALTER TABLE `dich_vu` DISABLE KEYS */;
INSERT INTO `dich_vu` VALUES (1,'Dịch vụ cơ bản',4000000,0),(2,'Dịch vụ nâng cao',5500000,0),(3,'Dịch vụ cao cấp',7000000,0),(14,'test',1000,1),(15,'test1',100000000,1);
/*!40000 ALTER TABLE `dich_vu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoa_don_thanh_toan`
--

DROP TABLE IF EXISTS `hoa_don_thanh_toan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoa_don_thanh_toan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ma_thanh_toan` varchar(100) DEFAULT NULL,
  `ngay_thanh_toan` date DEFAULT NULL,
  `isActive` tinyint(1) NOT NULL,
  `nhan_vien_id` int DEFAULT NULL,
  `phieu_dat_ban_id` int DEFAULT NULL,
  `chi_nhanh_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `nhan_vien_id` (`nhan_vien_id`),
  KEY `phieu_dat_ban_id_idx` (`phieu_dat_ban_id`),
  KEY `chi_nhanh_id1_idx` (`chi_nhanh_id`),
  CONSTRAINT `chi_nhanh_id1` FOREIGN KEY (`chi_nhanh_id`) REFERENCES `chi_nhanh` (`id`),
  CONSTRAINT `hoa_don_thanh_toan_ibfk_2` FOREIGN KEY (`nhan_vien_id`) REFERENCES `nhan_vien` (`id`),
  CONSTRAINT `phieu_dat_ban_id` FOREIGN KEY (`phieu_dat_ban_id`) REFERENCES `phieu_dat_ban` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoa_don_thanh_toan`
--

LOCK TABLES `hoa_don_thanh_toan` WRITE;
/*!40000 ALTER TABLE `hoa_don_thanh_toan` DISABLE KEYS */;
INSERT INTO `hoa_don_thanh_toan` VALUES (1,NULL,'2023-08-23',1,1,1,NULL),(2,NULL,'2023-07-23',1,1,2,NULL),(3,NULL,'2023-08-24',1,1,3,NULL),(4,NULL,'2023-04-23',1,1,4,NULL),(23,'HUY123','2023-09-05',1,15,21,NULL),(24,'HUY123','2023-09-06',1,15,22,NULL),(25,'HUY123','2023-09-07',1,15,23,NULL),(28,'HUY123','2023-09-08',1,15,24,NULL),(29,'HUY123','2023-09-08',0,NULL,25,NULL),(30,'HUY123','2023-09-08',0,NULL,26,NULL),(31,'HUY123','2023-09-08',1,15,27,NULL),(32,'HUY123','2023-09-09',1,15,28,NULL);
/*!40000 ALTER TABLE `hoa_don_thanh_toan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khach_hang`
--

DROP TABLE IF EXISTS `khach_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khach_hang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten_khach_hang` varchar(50) NOT NULL,
  `so_dien_thoai` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tai_khoan_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `khach_hang_ibfk_1` (`tai_khoan_id`),
  CONSTRAINT `khach_hang_ibfk_1` FOREIGN KEY (`tai_khoan_id`) REFERENCES `tai_khoan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khach_hang`
--

LOCK TABLES `khach_hang` WRITE;
/*!40000 ALTER TABLE `khach_hang` DISABLE KEYS */;
INSERT INTO `khach_hang` VALUES (2,'Đoàn Gia Huy','0349452398','huy@gmail.com',19),(6,'Lê Quang Tới','0123456987','toi@gmail.com',29),(7,'Đoàn Gia Huy','0349452398','huy@gmail.com',32),(8,'Lê Quang Tới','0123456987','huy@gmail.com',41);
/*!40000 ALTER TABLE `khach_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loai_tiec`
--

DROP TABLE IF EXISTS `loai_tiec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loai_tiec` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten_loai_tiec` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai_tiec`
--

LOCK TABLES `loai_tiec` WRITE;
/*!40000 ALTER TABLE `loai_tiec` DISABLE KEYS */;
INSERT INTO `loai_tiec` VALUES (1,'Tiệc cưới',0),(2,'Thôi nôi - Sinh nhật',0),(3,'Tiệc doanh nghiệp',0),(4,'Hội nghị - sự kiện',0),(26,'test 1',1),(27,'test 1',1),(28,'test 1',1),(29,'test 1',1);
/*!40000 ALTER TABLE `loai_tiec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhan_vien`
--

DROP TABLE IF EXISTS `nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhan_vien` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten_nhan_vien` varchar(255) NOT NULL,
  `ngay_sinh` date NOT NULL,
  `gioi_tinh` int NOT NULL,
  `so_dien_thoai` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `dia_chi` varchar(255) NOT NULL,
  `ngay_vao_lam` date NOT NULL,
  `isDelete` tinyint(1) DEFAULT NULL,
  `chuc_vu_id` int NOT NULL,
  `tai_khoan_id` int NOT NULL,
  `chi_nhanh_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nhan_vien_ibfk_1` (`chuc_vu_id`),
  KEY `nhan_vien_ibfk_3` (`chi_nhanh_id`),
  KEY `nhan_vien_ibfk_2` (`tai_khoan_id`),
  CONSTRAINT `nhan_vien_ibfk_1` FOREIGN KEY (`chuc_vu_id`) REFERENCES `chuc_vu` (`id`),
  CONSTRAINT `nhan_vien_ibfk_2` FOREIGN KEY (`tai_khoan_id`) REFERENCES `tai_khoan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `nhan_vien_ibfk_3` FOREIGN KEY (`chi_nhanh_id`) REFERENCES `chi_nhanh` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhan_vien`
--

LOCK TABLES `nhan_vien` WRITE;
/*!40000 ALTER TABLE `nhan_vien` DISABLE KEYS */;
INSERT INTO `nhan_vien` VALUES (1,'Gia Huy','2002-01-03',1,'0123456789','huy@gmail.com','666 Lê Trọng Tấn','2022-01-03',0,1,1,1),(15,'Lê Quang Tới','2002-08-18',1,'01234523657','toi@gmail.com','59 Nhà Bè','2023-08-11',0,2,15,2),(16,'Phạm Gia Tiến','2002-07-12',1,'0125463589','tien@gmail.com','67 An Giang','2023-08-10',0,4,16,1),(17,'Ngô Thị Kim Tài','2002-03-07',0,'0152365485','tai@gmail.com','92 Quảng Nam','2023-08-05',0,3,17,2),(20,'Đoàn Gia Huy','2002-01-03',1,'0349452397','huy@gmail.com','trần phú, trường huệ','2023-09-30',0,4,30,1),(21,'Hồ Quang Văn','2002-06-13',1,'0349452398','van@gmail.com','trần phú, trường huệ','2023-09-16',0,2,31,1),(22,'Đoàn Gia Huy','2023-09-17',1,'0349452398','2051052054huy@ou.edu.vn','666 Lê Trọng Tấn','2023-09-16',0,3,34,2);
/*!40000 ALTER TABLE `nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phan_hoi_khach_hang`
--

DROP TABLE IF EXISTS `phan_hoi_khach_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phan_hoi_khach_hang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `phan_hoi` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `ngay_phan_hoi` date DEFAULT NULL,
  `tai_khoan_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tai_khoan1_id_idx` (`tai_khoan_id`),
  CONSTRAINT `tai_khoan1_id` FOREIGN KEY (`tai_khoan_id`) REFERENCES `tai_khoan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phan_hoi_khach_hang`
--

LOCK TABLES `phan_hoi_khach_hang` WRITE;
/*!40000 ALTER TABLE `phan_hoi_khach_hang` DISABLE KEYS */;
INSERT INTO `phan_hoi_khach_hang` VALUES (2,'nhân viên của bạn thật chuyên nghiệp','2023-08-28',19),(8,'hello, tôi muốn nói là nhân viên của bạn rất tuyệt, tổ chức sự kiện của nhà hàng bạn rất tốt','2023-09-08',19),(9,'tôi muốn gửi phản hồi','2023-09-08',19),(10,'fdgdfgdf','2023-09-08',19),(11,'tôi gửi phản hồi đây','2023-09-08',19);
/*!40000 ALTER TABLE `phan_hoi_khach_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_dat_ban`
--

DROP TABLE IF EXISTS `phieu_dat_ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieu_dat_ban` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tong_tien` double DEFAULT NULL,
  `tien_coc` double DEFAULT NULL,
  `tien_con_lai` double DEFAULT NULL,
  `ngay_xuat_phieu` date DEFAULT NULL,
  `isDelete` tinyint(1) NOT NULL,
  `chi_tiet_dat_tiec_id` int DEFAULT NULL,
  `chi_tiet_khach_hang_id` int DEFAULT NULL,
  `ngay_dat_coc` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `phieu_dat_ban_ibfk_1` (`chi_tiet_khach_hang_id`),
  KEY `phieu_dat_ban_ibfk_2` (`chi_tiet_dat_tiec_id`),
  CONSTRAINT `phieu_dat_ban_ibfk_1` FOREIGN KEY (`chi_tiet_khach_hang_id`) REFERENCES `thong_tin_chi_tiet_khach_hang_dat_tiec` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `phieu_dat_ban_ibfk_2` FOREIGN KEY (`chi_tiet_dat_tiec_id`) REFERENCES `thong_tin_chi_tiet_dat_tiec` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_dat_ban`
--

LOCK TABLES `phieu_dat_ban` WRITE;
/*!40000 ALTER TABLE `phieu_dat_ban` DISABLE KEYS */;
INSERT INTO `phieu_dat_ban` VALUES (1,300000000,100000000,200000000,'2023-07-18',0,1,1,NULL),(2,250000000,50000000,200000000,'2023-05-18',0,2,2,NULL),(3,100000000,40000000,60000000,'2023-05-01',0,3,3,NULL),(4,70000000,20000000,50000000,'2023-03-27',0,4,4,NULL),(21,456500000,91300000,365200000,'2023-09-05',0,25,24,'2023-09-05'),(22,828000000,165600000,662400000,'2023-09-06',0,26,25,'2023-09-06'),(23,84000000,16800000,67200000,'2023-09-07',0,27,26,'2023-09-07'),(24,330000000,66000000,264000000,'2023-09-08',0,28,27,'2023-09-08'),(25,704500000,140900000,563600000,'2023-09-08',0,29,28,'2023-09-08'),(26,231500000,46300000,185200000,'2023-09-08',0,30,29,'2023-09-08'),(27,109250000,21850000,87400000,'2023-09-08',0,31,30,'2023-09-08'),(28,658500000,131700000,526800000,'2023-09-09',0,32,31,'2023-09-09');
/*!40000 ALTER TABLE `phieu_dat_ban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tai_khoan`
--

DROP TABLE IF EXISTS `tai_khoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tai_khoan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten_dang_nhap` varchar(50) NOT NULL,
  `mat_khau` varchar(255) NOT NULL,
  `vai_tro` varchar(10) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ten_dang_nhap_UNIQUE` (`ten_dang_nhap`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tai_khoan`
--

LOCK TABLES `tai_khoan` WRITE;
/*!40000 ALTER TABLE `tai_khoan` DISABLE KEYS */;
INSERT INTO `tai_khoan` VALUES (1,'giahuy','$2a$12$LK/ATXOJ6OTgmP34/Jfa5OyQtj8MDdpf2KiiPqBukAsejXRmI6uNy','ROLE_ADMIN',NULL),(15,'toi','$2a$10$lAcy/P7AfAydPxPV/QmVF.4vRp2GQwnBiXvQcprEMVJEJlL84jIwW','ROLE_STAFF','https://res.cloudinary.com/dgkrvmsli/image/upload/v1692199645/ifxbrlsjkesaxxqhzyeh.jpg'),(16,'tien','$2a$10$/WBCIXTGLuK4ZMzZ7Gw89eFqRGtm4PEgOLYFqH6aVz9VvU6.2Jra.','ROLE_STAFF',NULL),(17,'tai','$2a$10$qD0QRbiCwPDhZ7ny7XYdM.UX704MAcSeHKfSKT0G8NNiJku716yNC','ROLE_ADMIN',NULL),(19,'huy','$2a$12$LK/ATXOJ6OTgmP34/Jfa5OyQtj8MDdpf2KiiPqBukAsejXRmI6uNy','ROLE_USER','https://res.cloudinary.com/dgkrvmsli/image/upload/v1692199645/ifxbrlsjkesaxxqhzyeh.jpg'),(29,'toi123','$2a$10$C7DnbvqGVnjyCZjt9ENaxuoZdgHh/NM5muzQx6S45cxK6R8viiana','ROLE_USER','https://res.cloudinary.com/dgkrvmsli/image/upload/v1694110022/uuhl9gp7kxsxwkn4ph5m.jpg'),(30,'huyGia','$2a$10$lq/wFkb2QBcLYCGhOjQFQOQrdqoejFNOFzbAlocNwiTVLcmCpdFWS','ROLE_STAFF',NULL),(31,'van','$2a$10$z0jJFTAeh5/dx.1oPaHLDe7gdVcEkwzt85zqPMnmML8iwdpIFBF4.','ROLE_STAFF',NULL),(32,'huydg','$2a$10$zw2kxT0NXv53A8oyZX5qVeM.4TftPPti5x160E1vrpCs2BjwYsUBe','ROLE_USER','https://res.cloudinary.com/dgkrvmsli/image/upload/v1694266446/zotbczha2tqkncytichl.jpg'),(34,'giaHuy1','$2a$10$r4BTsfGSLQQtVRpLa7HGKOOvobUxYpyr.KB42yjc4G7Mg5xID4FpK','ROLE_STAFF',NULL),(40,'huy1','$2a$10$BwbhJPN.DVFWtaWlLCFIduh9T05CmGShbTMX/4iXdVsBoDL3.ub3O','ROLE_USER','https://res.cloudinary.com/dgkrvmsli/image/upload/v1694274464/hvbsjwvfbahhhun3zsyd.jpg'),(41,'huy113','$2a$10$XUNuySzaVt44cWMbag66ZuaRlJU.VcpmluK1dxaDINBWfZtAaHN2C','ROLE_USER','https://res.cloudinary.com/dgkrvmsli/image/upload/v1694274580/mxvnw0alshjwwzgz2r2l.jpg');
/*!40000 ALTER TABLE `tai_khoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thong_tin_chi_tiet_dat_tiec`
--

DROP TABLE IF EXISTS `thong_tin_chi_tiet_dat_tiec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thong_tin_chi_tiet_dat_tiec` (
  `id` int NOT NULL AUTO_INCREMENT,
  `so_luong_ban` varchar(255) NOT NULL,
  `ca` varchar(10) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  `sanh_id` int DEFAULT NULL,
  `thuc_don_id` int DEFAULT NULL,
  `dich_vu_id` int DEFAULT NULL,
  `loai_tiec_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sanh_id` (`sanh_id`),
  KEY `thuc_don_id` (`thuc_don_id`),
  KEY `dich_vu_id` (`dich_vu_id`),
  KEY `loai_tiec_id1_idx` (`loai_tiec_id`),
  CONSTRAINT `loai_tiec_id1` FOREIGN KEY (`loai_tiec_id`) REFERENCES `loai_tiec` (`id`),
  CONSTRAINT `thong_tin_chi_tiet_dat_tiec_ibfk_1` FOREIGN KEY (`sanh_id`) REFERENCES `thong_tin_sanh` (`id`),
  CONSTRAINT `thong_tin_chi_tiet_dat_tiec_ibfk_2` FOREIGN KEY (`thuc_don_id`) REFERENCES `thuc_don` (`id`),
  CONSTRAINT `thong_tin_chi_tiet_dat_tiec_ibfk_3` FOREIGN KEY (`dich_vu_id`) REFERENCES `dich_vu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thong_tin_chi_tiet_dat_tiec`
--

LOCK TABLES `thong_tin_chi_tiet_dat_tiec` WRITE;
/*!40000 ALTER TABLE `thong_tin_chi_tiet_dat_tiec` DISABLE KEYS */;
INSERT INTO `thong_tin_chi_tiet_dat_tiec` VALUES (1,'500','SA',0,4,1,1,1),(2,'400','CH',0,8,2,2,1),(3,'200','CH',0,9,1,1,2),(4,'50','CH',0,11,2,2,1),(5,'35','SA',0,1,1,2,2),(6,'35','SA',0,1,1,2,2),(7,'35','SA',0,1,1,2,2),(8,'40','T',0,20,2,3,4),(9,'100','T',0,8,1,2,4),(10,'14','CH',0,8,2,2,3),(11,'15','T',0,18,6,2,4),(12,'15','T',0,18,6,2,4),(13,'15','T',0,18,6,2,4),(14,'1234','SA',0,18,2,2,4),(15,'14','T',0,19,1,3,4),(16,'12','CH',0,18,6,2,4),(17,'14','SA',0,18,1,2,3),(18,'15','SA',0,14,2,2,3),(19,'12','CH',0,2,2,2,4),(20,'15','CH',0,13,2,2,3),(21,'45','SA',0,9,2,3,3),(22,'145','CH',0,8,2,1,3),(23,'12','CH',0,20,2,2,3),(24,'100','T',0,2,1,3,1),(25,'100','CH',0,3,2,1,1),(26,'154','CH',0,3,6,2,2),(27,'15','SA',0,9,2,1,3),(28,'70','T',0,8,2,1,3),(29,'123','CH',0,2,6,2,1),(30,'45','T',0,8,2,2,3),(31,'15','T',0,18,6,2,2),(32,'124','CH',0,6,6,3,3);
/*!40000 ALTER TABLE `thong_tin_chi_tiet_dat_tiec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thong_tin_chi_tiet_khach_hang_dat_tiec`
--

DROP TABLE IF EXISTS `thong_tin_chi_tiet_khach_hang_dat_tiec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thong_tin_chi_tiet_khach_hang_dat_tiec` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten_khach_hang` varchar(50) NOT NULL,
  `ngay_to_chuc` date NOT NULL,
  `so_dien_thoai` varchar(12) NOT NULL,
  `dia_chi` varchar(255) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thong_tin_chi_tiet_khach_hang_dat_tiec`
--

LOCK TABLES `thong_tin_chi_tiet_khach_hang_dat_tiec` WRITE;
/*!40000 ALTER TABLE `thong_tin_chi_tiet_khach_hang_dat_tiec` DISABLE KEYS */;
INSERT INTO `thong_tin_chi_tiet_khach_hang_dat_tiec` VALUES (1,'Ngô Minh Thành','2023-08-18','0349452368','70 Tây Ninh',0),(2,'Trần Đức Hiếu','2023-07-16','0345263598','59 TP HCM',0),(3,'Ngô Thị Kim Tài','2023-06-07','0123452563','69 Cà Mau',0),(4,'Lê Quang Tới','2023-04-04','0245632563','59 TP HCM',0),(5,'Gia Huy','2023-08-30','0123456789','ấp Trường Huệ',0),(6,'Gia Huy test','2023-07-30','0123456789','ấp Trường Huệ',0),(7,'Lê Quang Tới','2023-08-31','0124578963','Trần Phú',0),(8,'Gia Huy','2023-09-08','0124578963','Trần Phú, Hòa Thành',0),(9,'Gia Huy','2023-08-11','123456789','Trần Phú, Hòa Thành 1',0),(10,'Gia Huy 123','2023-09-07','0123456789','Trần Phú, Hòa Thành 1',0),(11,'Gia Huy 1234','2023-09-07','0123456789','Trần Phú, Hòa Thành 1',0),(12,'Gia Huy 1234','2023-09-07','0123456789','Trần Phú, Hòa Thành 1',0),(13,'Gia Huy 1231','2023-09-09','0123456789','Trần Phú, Hòa Thành 1',0),(14,'Lê Quang Tới','2023-08-18','0123456789','Trần Phú, Hòa Thành 1',0),(15,'Lê Quang Tới','2023-08-11','0123456789','Trần Phú, Hòa Thành 1',0),(16,'Lê Quang Tới','2023-09-07','0123456789','Trần Phú, Hòa Thành 1',0),(17,'gh','2023-09-15','15146','Trần Phú, Hòa Thành 1',0),(18,'Lê Quang Tới','2023-09-08','0124578963','Trần Phú, Hòa Thành 1',0),(19,'Gia Huy 123','2023-09-07','0124578963','Trần Phú, Hòa Thành 1',0),(20,'Gia Huy test ','2023-09-15','0124578963','Trần Phú, Hòa Thành 1',0),(21,'Thành','2023-09-09','01234523565','Trần Phú',0),(22,'Gia Huy 1231','2023-09-15','15146','Trần Phú, Hòa Thành',0),(23,'Đoàn Gia Huy','2023-09-30','0349452398','Trần Phú, Hòa Thành 1',0),(24,'Ngô Minh Thanh','2023-09-30','0124578963','Trần Phú, Hòa Thành 1',0),(25,'Gia Huy','2023-09-30','0124578963','Trần Phú, Hòa Thành',0),(26,'Gia Huy ','2023-09-29','0123456789','Trần Phú, Hòa Thành',0),(27,'Ngô Minh Thành','2023-09-27','0349452398','Trần Phú, Hòa Thành 1',0),(28,'Trần Đức Hiếu','2023-09-13','0123456987','Trần Phú, Hòa Thành',0),(29,'Phạm Gia Tiến','2023-09-22','0987654321','Trần Phú, Hòa Thành 1',0),(30,'Ngô Thị Kim Tài','2023-09-22','0123456789','Trần Phú, Hòa Thành',0),(31,'Lê Quang Tới','2023-09-15','0124578963','Trần Phú, Hòa Thành 1',0);
/*!40000 ALTER TABLE `thong_tin_chi_tiet_khach_hang_dat_tiec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thong_tin_sanh`
--

DROP TABLE IF EXISTS `thong_tin_sanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thong_tin_sanh` (
  `id` int NOT NULL AUTO_INCREMENT,
  `loai_sanh` varchar(50) DEFAULT NULL,
  `ten_sanh` varchar(255) DEFAULT NULL,
  `so_luong_ban` int DEFAULT NULL,
  `don_gia_toi_thieu` float DEFAULT NULL,
  `isDelete` tinyint(1) NOT NULL,
  `loai_tiec_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `loai_tiec_id_idx` (`loai_tiec_id`),
  CONSTRAINT `loai_tiec1_id` FOREIGN KEY (`loai_tiec_id`) REFERENCES `loai_tiec` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thong_tin_sanh`
--

LOCK TABLES `thong_tin_sanh` WRITE;
/*!40000 ALTER TABLE `thong_tin_sanh` DISABLE KEYS */;
INSERT INTO `thong_tin_sanh` VALUES (1,'DIAMOND','DIAMOND_1',500,100000000,0,1),(2,'DIAMOND','DIAMOND_2',400,80000000,0,1),(3,'DIAMOND','DIAMOND_3',300,50000000,0,1),(4,'GOLD','GOLD_1',500,80000000,0,1),(5,'GOLD','GOLD_2',400,50000000,0,1),(6,'GOLD','GOLD_3',300,30000000,0,1),(7,'SILVER','SILVER_1',500,60000000,0,1),(8,'SILVER','SILVER_2',400,40000000,0,1),(9,'SILVER','SILVER_3',300,20000000,0,1),(10,'RUBY','RB_1',100,20000000,0,2),(11,'RUBY','RB_2',50,10000000,0,2),(12,'RUBY','RB_3',30,7000000,0,2),(13,'RUBY ','RB_4',15,5000000,0,2),(14,'SAPPIRE','SAP_1',70,20000000,0,3),(15,'SAPPIRE','SAP_2',30,15000000,0,3),(16,'SAPPIRE','SAP_3',15,10000000,0,3),(17,'GRAND DIAMOND','GD_1',70,40000000,0,4),(18,'GRAND DIAMOND','GD_2',50,25000000,0,4),(19,'GRAND RUBY','GR_1',70,30000000,0,4),(20,'GRAND RUBY','GR_2',50,15000000,0,4),(23,'test1','test11',150,1500000,1,1),(24,'test 1','test1',100,1500000,0,4),(25,'test11','test2',40,1500000,1,2);
/*!40000 ALTER TABLE `thong_tin_sanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuc_don`
--

DROP TABLE IF EXISTS `thuc_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thuc_don` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ma_thuc_don` varchar(50) DEFAULT NULL,
  `mon_khai_vi` varchar(255) DEFAULT NULL,
  `mon_chinh_1` varchar(255) DEFAULT NULL,
  `mon_chinh_2` varchar(255) DEFAULT NULL,
  `mon_chinh_3` varchar(255) DEFAULT NULL,
  `mon_chinh_4` varchar(255) DEFAULT NULL,
  `mon_trang_mieng` varchar(255) DEFAULT NULL,
  `bia` varchar(100) DEFAULT NULL,
  `nuoc_ngot` varchar(100) DEFAULT NULL,
  `gia_goi` float DEFAULT NULL,
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuc_don`
--

LOCK TABLES `thuc_don` WRITE;
/*!40000 ALTER TABLE `thuc_don` DISABLE KEYS */;
INSERT INTO `thuc_don` VALUES (1,'menu_1','Khai vị 3 món (Gỏi tôm thái, Chả giò bách thảo, Đậu hủ cuộn trứng)','Tôm sốt mật ông hạt tiêu','Cá chép giòn sốt kiwi vàng','Giò heo Đức - khoai tây chiên','Lẩu cá hồi','Rau câu','tiger','pesi',3000000,0),(2,'menu_2','Khai vị 3 món (Gỏi tôm thái Tây Thi, Chả giò GH, Chả thanh cua)','Tôm hấp bia tươi','Mì xào sa tế tôm','Cua lột sốt chanh dây','Lẩu tôm Thái Lan','Nho mỹ','tiger','coca',4000000,0),(6,'menu_3','Khai vị 4 món (Gỏi tôm, Chả giò bách thảo, Mực ống chiên xù, Nem nướng Hà Nội)','Bồ câu quay','Bò hầm rượu vang - bánh mì','Cá bống mú hấp Hồng Kong','Lẩu hải sản sa tế','Bánh plan','Tiger, SaiGon, ...','CoCa, Pesi, ...',5000000,0),(7,'menu_4','Khai vị 3 món (Gỏi tôm thái, Chả giò bách thảo, Đậu hủ cuộn trứng)','Tôm hấp bia tươi','Cá chép giòn sốt kiwi vàng','Cá bống mú hấp Hồng Kong','Lẩu cá hồi','Bánh plan','Tiger, SaiGon, ...','CoCa, Pesi, ...',5000000,0);
/*!40000 ALTER TABLE `thuc_don` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-09 23:01:29
