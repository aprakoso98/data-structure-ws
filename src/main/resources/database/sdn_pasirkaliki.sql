/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 5.0.77-community-nt : Database - sdn_pasirkaliki
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sdn_pasirkaliki` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sdn_pasirkaliki`;

/*Table structure for table `tmguru` */

DROP TABLE IF EXISTS `tmguru`;

CREATE TABLE `tmguru` (
  `ID_GURU` varchar(10) NOT NULL,
  `NIP` char(11) NOT NULL,
  `NAMA_GURU` varchar(30) default NULL,
  `ALAMAT` varchar(50) default NULL,
  `CREATED_BY` varchar(30) default NULL,
  `CREATED_DT` datetime default NULL,
  `MODIFIED_BY` varchar(30) default NULL,
  `MODIFIED_DT` datetime default NULL,
  PRIMARY KEY  (`ID_GURU`,`NIP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tmguru` */

insert  into `tmguru`(`ID_GURU`,`NIP`,`NAMA_GURU`,`ALAMAT`,`CREATED_BY`,`CREATED_DT`,`MODIFIED_BY`,`MODIFIED_DT`) values 
('2','NIP0001','Fachrizal','Perumnas','Admin','2018-12-07 01:17:19',NULL,NULL),
('GU0001','20181209001','Abdul Aziz','Rawamerta','Admin','2018-12-06 22:08:50',NULL,NULL);

/*Table structure for table `tmkelas` */

DROP TABLE IF EXISTS `tmkelas`;

CREATE TABLE `tmkelas` (
  `ID_KELAS` varchar(5) NOT NULL,
  `ID_WALIKELAS` varchar(10) default NULL,
  `JUMLAH_KURSI` int(11) default NULL,
  `JUMLAH_MEJA` int(11) default NULL,
  `CREATED_BY` varchar(30) default 'Admin',
  `CREATED_DT` datetime default NULL,
  `MODIFIED_BY` varchar(30) default NULL,
  `MODIFIED_DT` datetime default NULL,
  PRIMARY KEY  (`ID_KELAS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tmkelas` */

insert  into `tmkelas`(`ID_KELAS`,`ID_WALIKELAS`,`JUMLAH_KURSI`,`JUMLAH_MEJA`,`CREATED_BY`,`CREATED_DT`,`MODIFIED_BY`,`MODIFIED_DT`) values 
('1.a','GU0004',20,20,'Admin','2018-12-01 14:30:18',NULL,NULL),
('1.b','GU0001',20,20,'Admin','2018-12-01 14:30:18',NULL,NULL),
('1.c','GU0001',20,20,'Admin','2018-12-01 14:30:18',NULL,NULL),
('2.a','GU0001',20,20,'Admin','2018-12-01 14:30:18',NULL,NULL),
('2.b','GU0004',20,20,'Admin','2018-12-01 14:30:18',NULL,NULL),
('2.c','GU0004',20,20,'Admin','2018-12-01 14:30:18',NULL,NULL),
('3.a','6U0003',20,20,'Admin','2018-12-01 14:30:18',NULL,NULL),
('3.b','6U0003',20,20,'Admin','2018-12-01 14:30:18',NULL,NULL),
('3.c','6U0003',20,20,'Admin','2018-12-01 14:30:18',NULL,NULL),
('6.a','GU0001',20,20,'Admin','2018-12-01 14:30:18',NULL,NULL),
('6.b','GU0002',20,20,'Admin','2018-12-01 14:30:18',NULL,NULL),
('6.c','6U0003',20,20,'Admin','2018-12-01 14:30:18',NULL,NULL);

/*Table structure for table `tmsekolah` */

DROP TABLE IF EXISTS `tmsekolah`;

CREATE TABLE `tmsekolah` (
  `ID_SEKOLAH` char(6) NOT NULL,
  `NAMA_SEKOLAH` varchar(20) default NULL,
  `ALAMAT` varchar(80) default NULL,
  `TGL_BERDIRI` date default NULL,
  `CREATED_BY` varchar(30) default NULL,
  `CREATED_DT` datetime default NULL,
  `MODIFIED_BY` varchar(30) default NULL,
  `MODIFIED_DT` datetime default NULL,
  PRIMARY KEY  (`ID_SEKOLAH`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tmsekolah` */

insert  into `tmsekolah`(`ID_SEKOLAH`,`NAMA_SEKOLAH`,`ALAMAT`,`TGL_BERDIRI`,`CREATED_BY`,`CREATED_DT`,`MODIFIED_BY`,`MODIFIED_DT`) values 
('pk001','SDN Pasirkaliki 1','Dusun Sempur Desa Pasirkaliki Kec. Rawamerta Kab. Karawang Kode Pos 41383','2002-01-01','Admin','2002-01-01 00:00:00',NULL,NULL);

/*Table structure for table `tmsiswa` */

DROP TABLE IF EXISTS `tmsiswa`;

CREATE TABLE `tmsiswa` (
  `NIS` char(9) NOT NULL,
  `NISN` char(10) NOT NULL,
  `NAMA` varchar(30) default NULL,
  `JENIS_KELAMIN` char(1) default NULL,
  `TEMPAT_LAHIR` varchar(20) default NULL,
  `TGL_LAHIR` date default NULL,
  `AGAMA` varchar(20) default NULL,
  `ALAMAT` varchar(50) default NULL,
  `KELAS` varchar(5) default NULL,
  `CREATED_BY` varchar(30) default NULL,
  `CREATED_DT` datetime default NULL,
  `MODIFIED_BY` varchar(30) default NULL,
  `MODIFIED_DT` datetime default NULL,
  `ASAL_SEKOLAH` varchar(50) default NULL,
  `STATUS` varchar(10) NOT NULL,
  PRIMARY KEY  (`NIS`,`NISN`),
  KEY `TMSISWA_FK1` (`KELAS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tmsiswa` */

insert  into `tmsiswa`(`NIS`,`NISN`,`NAMA`,`JENIS_KELAMIN`,`TEMPAT_LAHIR`,`TGL_LAHIR`,`AGAMA`,`ALAMAT`,`KELAS`,`CREATED_BY`,`CREATED_DT`,`MODIFIED_BY`,`MODIFIED_DT`,`ASAL_SEKOLAH`,`STATUS`) values 
('121301044','56155754','Rohendi','L','Karawang','2005-12-12','Islam','Pasirkaliki','6.b','Admin','2018-12-01 14:23:37',NULL,NULL,'SDN Telukjambe I','baru'),
('131401002','73148803','Alvia Jakariya','P','Karawang','2007-01-19','Islam','Pasirkaliki','1.a','Admin','2018-12-01 14:23:37',NULL,NULL,NULL,'baru'),
('131401003','69606393','Andika','L','Karawang','2006-11-25','Islam','Pasirkaliki','2.a','Admin','2018-12-01 14:23:37',NULL,NULL,NULL,'naik kelas'),
('131401009','72025998','Ferdinand Wiranta','L','Karawang','2007-07-29','Islam','Pasirkaliki','6.a','Admin','2018-12-01 14:23:37',NULL,NULL,'SDN Cengkong IV','naik kelas'),
('131401010','63346569','Fitri Amelia','P','Karawang','2006-10-23','Islam','Pasirkaliki','6.a','Admin','2018-12-01 14:23:37',NULL,NULL,'SDN Telukjambe I','pindahan'),
('131401015','79993737','Lisma Maelani','P','Karawang','2007-03-24','Islam','Pasirkaliki','2.b','Admin','2018-12-01 14:23:37',NULL,NULL,NULL,'pindahan'),
('131401019','65667278','Mira Hilda Sari','P','Karawang','2006-06-12','Islam','Pasirkaliki','2.b','Admin','2018-12-01 14:23:37',NULL,NULL,NULL,'baru'),
('131401020','61716053','Mohamad Rapli Handani','L','Karawang','2006-06-12','Islam','Pasirkaliki','3.b','Admin','2018-12-01 14:23:37',NULL,NULL,NULL,'naik kelas'),
('131401024','67339223','Muhamad Rifki Anugrah','L','Karawang','2006-11-15','Islam','Pasirkaliki','6.b','Admin','2018-12-01 14:23:37',NULL,NULL,'SDN Cengkong IV','naik kelas'),
('131401025','68340067','Muhamad Saeful Rohman','L','Karawang','2006-05-02','Islam','Pasirkaliki','6.b','Admin','2018-12-01 14:23:37',NULL,NULL,'SDN Telukjambe I','naik kelas'),
('131401028','69495089','Nadya Khalisa Putri','P','Karawang','2006-12-26','Islam','Pasirkaliki','6.b','Admin','2018-12-01 14:23:37',NULL,NULL,'SDN Lemahabang I','pindahan'),
('131401031','69332162','Nova Rahmah','P','Karawang','2006-10-09','Islam','Pasirkaliki','6.b','Admin','2018-12-01 14:23:37',NULL,NULL,'SDN Lemahabang I','pindahan'),
('131401034','63976299','Rafli','L','Karawang','2006-05-17','Islam','Pasrkaliki','6.b','Admin','2018-12-01 14:23:37',NULL,NULL,'SDN Lemahabang I','pindahan'),
('131401040','79148098','Sahadah','P','Karawang','2007-03-02','Islam','Kutawargi','1.c','Admin','2018-12-01 14:23:37',NULL,NULL,NULL,'pindahan'),
('131401048','72901721','Siti Patonah','P','Karawang','2007-10-21','Islam','Pasirkaliki','1.c','Admin','2018-12-01 14:23:37',NULL,NULL,NULL,'pindahan'),
('131401049','76686466','Sri Rahayu Pratiwi','P','Karawang','2007-04-28','Islam','Pasirkaliki','2.c','Admin','2018-12-01 14:23:37',NULL,NULL,NULL,'pindahan'),
('131401054','64027532','Wardiah','P','Karawang','2006-11-11','Islam','Pasirkaliki','3.c','Admin','2018-12-01 14:23:38',NULL,NULL,NULL,'baru'),
('131401056','62930572','Wulan Sari','P','Karawang','2006-01-30','Islam','Pasirkaliki','6.c','Admin','2018-12-01 14:23:38',NULL,NULL,'SDN Lemahabang I','naik kelas'),
('141502068','73238653','Alisya Salsabila','P','Karawang','2007-07-24','Islam','Pasirkaliki','1.a','Admin','2018-12-01 14:23:37',NULL,NULL,NULL,'naik kelas'),
('151603063','65691208','Tasa Nur Muhamad','L','Karawang','2006-01-11','Islam','Pasirawi','3.c','Admin','2018-12-01 14:23:38',NULL,NULL,NULL,'pindahan'),
('161704095','79548721','Febby Widyaningsih','P','Karawang','2007-02-01','Islam','Pasirkaliki','3.a','Admin','2018-12-01 14:23:37',NULL,NULL,NULL,'pindahan'),
('181906092','75031397','Irli Tasya Prawesti','P','JAKARTA','2007-01-10','Islam','JURANG MANGU BARAT','1.b','Admin','2018-12-01 14:23:37',NULL,NULL,NULL,'pindahan');

/*Table structure for table `tmwalisiswa` */

DROP TABLE IF EXISTS `tmwalisiswa`;

CREATE TABLE `tmwalisiswa` (
  `NIS` int(11) NOT NULL,
  `NAMA_AYAH` varchar(30) default NULL,
  `TAHUN_LAHIR_AYAH` varchar(4) default NULL,
  `PENDIDIKAN_AYAH` varchar(30) default NULL,
  `PEKERJAAN_AYAH` varchar(20) default NULL,
  `PENGHASILAN_MIN_AYAH` int(11) default NULL,
  `PENGHASILAN_MAX_AYAH` int(11) default NULL,
  `NAMA_IBU` varchar(30) default NULL,
  `TAHUN_LAHIT_IBU` varchar(4) default NULL,
  `PENDIDIKAN_IBU` varchar(30) default NULL,
  `PEKERJAAN_IBU` varchar(20) default NULL,
  `PENGHASILAN_MIN_IBU` int(11) default NULL,
  `PENGHASILAN_MAX_IBU` int(11) default NULL,
  `CREATED_BY` varchar(30) default NULL,
  `CREATED_DT` datetime default NULL,
  `MODIFIED_BY` varchar(30) default NULL,
  `MODIFIED_DT` datetime default NULL,
  PRIMARY KEY  (`NIS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tmwalisiswa` */

insert  into `tmwalisiswa`(`NIS`,`NAMA_AYAH`,`TAHUN_LAHIR_AYAH`,`PENDIDIKAN_AYAH`,`PEKERJAAN_AYAH`,`PENGHASILAN_MIN_AYAH`,`PENGHASILAN_MAX_AYAH`,`NAMA_IBU`,`TAHUN_LAHIT_IBU`,`PENDIDIKAN_IBU`,`PEKERJAAN_IBU`,`PENGHASILAN_MIN_IBU`,`PENGHASILAN_MAX_IBU`,`CREATED_BY`,`CREATED_DT`,`MODIFIED_BY`,`MODIFIED_DT`) values 
(121301044,'IGA ','1960','SD / sederajat','Sudah Meninggal',NULL,NULL,'DAMI','1961','SD / sederajat','Buruh',500000,999999,'Admin','2018-12-06 22:50:03',NULL,NULL),
(131401002,'JAKARIYA','1976','SD / sederajat','Wiraswasta',2000000,4999999,'SITI AISYAH','1981','SMP / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:46',NULL,NULL),
(131401003,'CAYIM','1975','SD / sederajat','Wiraswasta',1000000,1999999,'IKAH','1981','SD / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:46',NULL,NULL),
(131401009,'TARSUM WIRANTA','1983','SMA / sederajat','Wiraswasta',1000000,1999999,'SITI JUBAEDAH','1988','SMP / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:46',NULL,NULL),
(131401010,'JABARUDIN','1976','SD / sederajat','Petani',1000000,1999999,'SITI ROHMAH','1979','SD / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:46',NULL,NULL),
(131401015,'AHMAN','1978','SD / sederajat','Wiraswasta',1000000,1999999,'TARSIH','1978','SD / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:46',NULL,NULL),
(131401019,'MISAR','1967','SMA / sederajat','Karyawan Swasta',2000000,4999999,'OTOH MASITOH','1978','SD / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:46',NULL,NULL),
(131401020,'MOHAMAD ROPI','1984','SMA / sederajat','Karyawan Swasta',2000000,4999999,'HAOLA','1986','SMP / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:46',NULL,NULL),
(131401024,'UJANG','1971','SD / sederajat','Petani',1000000,1999999,'EDAH','1974','SD / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:46',NULL,NULL),
(131401025,'ICAM SETIAWAN','1979','SD / sederajat','Wiraswasta',1000000,1999999,'MINTARSIH','1981','SMP / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:46',NULL,NULL),
(131401028,'APENDI','1978','SMA / sederajat','Karyawan Swasta',2000000,4999999,'EUIS KARTIKA SUNDARI','1978','SMA / sederajat','',0,500000,'Admin','2018-12-06 22:43:46',NULL,NULL),
(131401031,'ATAM','1981','SMP / sederajat','Wiraswasta',1000000,1999999,'WAWAS WASILAWATI','1985','SMA / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:47',NULL,NULL),
(131401034,'UMAR','1980','SD / sederajat','Wiraswasta',1000000,1999999,'WARNIAH','1984','SD / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:47',NULL,NULL),
(131401040,'WASDA','1972','SMP / sederajat','Karyawan Swasta',2000000,4999999,'WARMAH','1976','SD / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:47',NULL,NULL),
(131401048,'ASEP SOBANDI','1984','SD / sederajat','Buruh',1000000,1999999,'NAMI','1985','SD / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:47',NULL,NULL),
(131401049,'HADI','1980','SMA / sederajat','Karyawan Swasta',2000000,4999999,'TASMAH','1981','SD / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:47',NULL,NULL),
(131401054,'TARWA','1987','SD / sederajat','Buruh',1000000,1999999,'WIDIANENGSIH','1986','SD / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:47',NULL,NULL),
(131401056,'ALANG DARLAM','1965','SD / sederajat','Wiraswasta',2000000,4999999,'ROKAYAH','1968','SD / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:47',NULL,NULL),
(141502068,'ALI NURDIN','1975','SMA / sederajat','Karyawan Swasta',2000000,4999999,'WARTIAH','1977','SMA / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:46',NULL,NULL),
(151603063,'KARI','1985','SD / sederajat','Buruh',500000,999999,'ROMSIH','1986','SD / sederajat','Tidak bekerja',0,500000,'Admin','2018-12-06 22:43:47',NULL,NULL),
(161704095,'YUL ATMAWIDYA','1984','S1','PNS/TNI/Polri',2000000,4999999,'NONENG','1986','SMA / sederajat','Tidak bekerja',0,0,'Admin','2018-12-06 22:43:46',NULL,NULL),
(181906092,'TARSIMAN','1979',NULL,NULL,NULL,NULL,'DONA QURAENI','1986',NULL,NULL,0,0,'Admin','2018-12-06 22:49:39',NULL,NULL);

/*Table structure for table `ttsiswahistory` */

DROP TABLE IF EXISTS `ttsiswahistory`;

CREATE TABLE `ttsiswahistory` (
  `ORDER_NO` int(11) NOT NULL auto_increment,
  `NIS` int(11) default NULL,
  `NISN` int(11) default NULL,
  `STATUS` varchar(20) default NULL,
  `KELAS` varchar(5) default NULL,
  `CREATED_BY` varchar(30) default NULL,
  `CREATED_DT` datetime default NULL,
  `MODIFIED_BY` varchar(30) default NULL,
  `MODIFIED_DT` datetime default NULL,
  PRIMARY KEY  (`ORDER_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

/*Data for the table `ttsiswahistory` */

insert  into `ttsiswahistory`(`ORDER_NO`,`NIS`,`NISN`,`STATUS`,`KELAS`,`CREATED_BY`,`CREATED_DT`,`MODIFIED_BY`,`MODIFIED_DT`) values 
(1,141502068,73238653,'baru','1.a','Admin','2018-12-06 22:06:10',NULL,NULL),
(2,131401002,73148803,'baru','1.a','Admin','2018-12-06 22:06:10',NULL,NULL),
(3,131401003,69606393,'naik kelas','2.a','Admin','2018-12-06 22:06:10',NULL,NULL),
(4,161704095,79548721,'naik kelas','3.a','Admin','2018-12-06 22:06:10',NULL,NULL),
(5,131401009,72025998,'pindahan','6.a','Admin','2018-12-06 22:06:10',NULL,NULL),
(6,131401010,63346569,'pindahan','6.a','Admin','2018-12-06 22:06:10',NULL,NULL),
(7,181906092,75031397,'baru','1.b','Admin','2018-12-06 22:06:10',NULL,NULL),
(8,131401015,79993737,'naik kelas','2.b','Admin','2018-12-06 22:06:10',NULL,NULL),
(9,131401019,65667278,'naik kelas','2.b','Admin','2018-12-06 22:06:10',NULL,NULL),
(10,131401020,61716053,'naik kelas','3.b','Admin','2018-12-06 22:06:10',NULL,NULL),
(11,131401024,67339223,'pindahan','6.b','Admin','2018-12-06 22:06:10',NULL,NULL),
(12,131401025,68340067,'pindahan','6.b','Admin','2018-12-06 22:06:10',NULL,NULL),
(13,131401028,69495089,'pindahan','6.b','Admin','2018-12-06 22:06:10',NULL,NULL),
(14,131401031,69332162,'pindahan','6.b','Admin','2018-12-06 22:06:10',NULL,NULL),
(15,131401034,63976299,'pindahan','6.b','Admin','2018-12-06 22:06:10',NULL,NULL),
(16,121301044,56155754,'pindahan','6.b','Admin','2018-12-06 22:06:10',NULL,NULL),
(17,131401040,79148098,'baru','1.c','Admin','2018-12-06 22:06:10',NULL,NULL),
(18,131401048,72901721,'naik kelas','1.c','Admin','2018-12-06 22:06:10',NULL,NULL),
(19,131401049,76686466,'naik kelas','2.c','Admin','2018-12-06 22:06:10',NULL,NULL),
(20,151603063,65691208,'pindahan','3.c','Admin','2018-12-06 22:06:10',NULL,NULL),
(21,131401054,64027532,'pindahan','3.c','Admin','2018-12-06 22:06:10',NULL,NULL),
(22,131401056,62930572,'pindahan','6.c','Admin','2018-12-06 22:06:10',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
