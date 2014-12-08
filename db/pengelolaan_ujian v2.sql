-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 08, 2014 at 12:06 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `pengelolaan_ujian`
--

-- --------------------------------------------------------

--
-- Table structure for table `berita_acara`
--

CREATE TABLE IF NOT EXISTS `berita_acara` (
  `BERITA_KODE` char(5) NOT NULL,
  `BERITA_KET` text NOT NULL,
  `BERITA_HADIR` decimal(2,0) NOT NULL,
  `BERITA_TIDAK_HADIR` decimal(2,0) NOT NULL,
  `BERITA_SOAL_SISA` decimal(2,0) NOT NULL,
  `BERITA_JAWAB_SISA` decimal(2,0) NOT NULL,
  PRIMARY KEY (`BERITA_KODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `berita_acara`
--


-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE IF NOT EXISTS `dosen` (
  `DOSEN_KODE` char(5) NOT NULL,
  `KBK_KODE` char(7) NOT NULL,
  `STAF_NIP` char(18) NOT NULL,
  PRIMARY KEY (`DOSEN_KODE`),
  KEY `FK_MATA_KULIAH_TO_KBK` (`KBK_KODE`),
  KEY `FK_STAFF_TO_DOSEN` (`STAF_NIP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dosen`
--


-- --------------------------------------------------------

--
-- Table structure for table `dosen_to_vnv`
--

CREATE TABLE IF NOT EXISTS `dosen_to_vnv` (
  `DOSEN_KODE` char(5) NOT NULL,
  `VNV_KODE` char(5) NOT NULL,
  PRIMARY KEY (`DOSEN_KODE`,`VNV_KODE`),
  KEY `FK_DOSEN_TO_VNV2` (`VNV_KODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dosen_to_vnv`
--


-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `EVENT_KODE` char(4) NOT NULL,
  `EVENT_TGL_MULAI` date NOT NULL,
  `EVENT_TGL_SELESAI` date NOT NULL,
  `EVENT_TGL_UPLOAD_MULAI` date NOT NULL,
  `EVENT_TGL_UPLOAD_SELESAI` date NOT NULL,
  `EVENT_TGL_VNV_MULAI` date NOT NULL,
  `EVENT_TGL_VNV_SELESAI` date NOT NULL,
  `EVENT_ACTIVE` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`EVENT_KODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event`
--


-- --------------------------------------------------------

--
-- Table structure for table `kbk`
--

CREATE TABLE IF NOT EXISTS `kbk` (
  `KBK_KODE` char(7) NOT NULL,
  `KBK_NAMA` varchar(40) NOT NULL,
  PRIMARY KEY (`KBK_KODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kbk`
--


-- --------------------------------------------------------

--
-- Table structure for table `mata_kuliah`
--

CREATE TABLE IF NOT EXISTS `mata_kuliah` (
  `MATKUL_KODE` varchar(5) NOT NULL,
  `MATKUL_NAMA` varchar(40) NOT NULL,
  `MATKUL_TIPE` char(2) NOT NULL,
  PRIMARY KEY (`MATKUL_KODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mata_kuliah`
--


-- --------------------------------------------------------

--
-- Table structure for table `mata_kuliah_to_dosen`
--

CREATE TABLE IF NOT EXISTS `mata_kuliah_to_dosen` (
  `DOSEN_KODE` char(5) NOT NULL,
  `MATKUL_KODE` varchar(5) NOT NULL,
  PRIMARY KEY (`DOSEN_KODE`,`MATKUL_KODE`),
  KEY `FK_MATA_KULIAH_TO_DOSEN2` (`MATKUL_KODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mata_kuliah_to_dosen`
--


-- --------------------------------------------------------

--
-- Table structure for table `nilai`
--

CREATE TABLE IF NOT EXISTS `nilai` (
  `RUANGAN_KODE` char(4) NOT NULL,
  `UJIAN_KODE` char(5) NOT NULL,
  `NILAI_FILE` longblob,
  `NILAI_NAMA_FILE` varchar(255) NOT NULL,
  `NILAI_TIPE_FILE` varchar(4) NOT NULL,
  PRIMARY KEY (`RUANGAN_KODE`,`UJIAN_KODE`),
  KEY `UJIAN_KODE` (`UJIAN_KODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nilai`
--


-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `ROLE_KODE` varchar(1) NOT NULL,
  `ROLE_NAME` varchar(15) NOT NULL,
  PRIMARY KEY (`ROLE_KODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`ROLE_KODE`, `ROLE_NAME`) VALUES
('0', 'ADMIN'),
('1', 'DOSEN_PENGAMPU'),
('2', 'VNV'),
('3', 'PANITIA');

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE IF NOT EXISTS `ruangan` (
  `RUANGAN_KODE` char(4) NOT NULL,
  `RUANGAN_NAMA` varchar(20) NOT NULL,
  PRIMARY KEY (`RUANGAN_KODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruangan`
--


-- --------------------------------------------------------

--
-- Table structure for table `ruangan_ujian`
--

CREATE TABLE IF NOT EXISTS `ruangan_ujian` (
  `RUANGAN_KODE` char(4) NOT NULL,
  `UJIAN_KODE` char(5) NOT NULL,
  `STAF_NIP` char(18) NOT NULL,
  `BERITA_KODE` char(5) DEFAULT NULL,
  `TGL_UJIAN` date DEFAULT NULL,
  PRIMARY KEY (`RUANGAN_KODE`,`UJIAN_KODE`),
  KEY `FK_BERITAACARA_TO_RUANGANUJIAN` (`BERITA_KODE`),
  KEY `FK_RUANGANUJIAN_TO_STAF` (`STAF_NIP`),
  KEY `FK_RUANGANUJIAN_TO_UJIAN` (`UJIAN_KODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruangan_ujian`
--


-- --------------------------------------------------------

--
-- Table structure for table `soal`
--

CREATE TABLE IF NOT EXISTS `soal` (
  `SOAL_KODE` char(5) NOT NULL,
  `MATKUL_KODE` varchar(5) NOT NULL,
  `SOAL_UPLOADED` tinyint(1) NOT NULL,
  `SOAL_VNVED` tinyint(1) NOT NULL,
  `SOAL_PRINTED` tinyint(1) NOT NULL,
  `SOAL_SIFAT` varchar(20) NOT NULL,
  PRIMARY KEY (`SOAL_KODE`),
  KEY `FK_MATA_KULIAH_TO_SOAL` (`MATKUL_KODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `soal`
--


-- --------------------------------------------------------

--
-- Table structure for table `staf`
--

CREATE TABLE IF NOT EXISTS `staf` (
  `STAF_NIP` char(18) NOT NULL,
  `STAF_NAMA` varchar(35) NOT NULL,
  `STAF_EMAIL` varchar(35) NOT NULL,
  `STAF_KONTAK` varchar(15) NOT NULL,
  PRIMARY KEY (`STAF_NIP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staf`
--

INSERT INTO `staf` (`STAF_NIP`, `STAF_NAMA`, `STAF_EMAIL`, `STAF_KONTAK`) VALUES
('131511062', 'Zulkhair', 'zulcrg@gmail.com', '085659229994');

-- --------------------------------------------------------

--
-- Table structure for table `storage_soal`
--

CREATE TABLE IF NOT EXISTS `storage_soal` (
  `SOAL_KODE` char(5) NOT NULL,
  `STSOAL_NO_URUT` decimal(1,0) NOT NULL,
  `STAF_NIP` char(18) NOT NULL,
  `STSOAL_TGL_UPLOAD` datetime NOT NULL,
  `STSOAL_FILE` longblob NOT NULL,
  `STSOAL_NAMA_FILE` varchar(255) NOT NULL,
  `STSOAL_TIPE_FILE` varchar(5) NOT NULL,
  PRIMARY KEY (`SOAL_KODE`,`STSOAL_NO_URUT`),
  KEY `FK_USER_TO_STORAGE` (`STAF_NIP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `storage_soal`
--


-- --------------------------------------------------------

--
-- Table structure for table `ujian`
--

CREATE TABLE IF NOT EXISTS `ujian` (
  `UJIAN_KODE` char(5) NOT NULL,
  `EVENT_KODE` char(4) NOT NULL,
  `SOAL_KODE` char(5) NOT NULL,
  `UJIAN_MULAI` date NOT NULL,
  `UJIAN_MENIT` tinyint(4) NOT NULL,
  PRIMARY KEY (`UJIAN_KODE`),
  KEY `FK_EVENT_TO_UJIAN` (`EVENT_KODE`),
  KEY `FK_SOAL_TO_UJIAN` (`SOAL_KODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ujian`
--


-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `STAF_NIP` char(18) NOT NULL,
  `USER_USERNAME` varchar(20) NOT NULL,
  `USER_PASSWORD` varchar(20) NOT NULL,
  `USER_ACTIVE` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`STAF_NIP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`STAF_NIP`, `USER_USERNAME`, `USER_PASSWORD`, `USER_ACTIVE`) VALUES
('131511062', 'zulcrg', 'Password1', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_to_role`
--

CREATE TABLE IF NOT EXISTS `user_to_role` (
  `STAF_NIP` char(18) NOT NULL,
  `ROLE_KODE` varchar(1) NOT NULL,
  PRIMARY KEY (`STAF_NIP`,`ROLE_KODE`),
  KEY `FK_USER_TO_ROLE2` (`ROLE_KODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_to_role`
--

INSERT INTO `user_to_role` (`STAF_NIP`, `ROLE_KODE`) VALUES
('131511062', '0'),
('131511062', '1'),
('131511062', '2'),
('131511062', '3');

-- --------------------------------------------------------

--
-- Table structure for table `vnv`
--

CREATE TABLE IF NOT EXISTS `vnv` (
  `VNV_KODE` char(5) NOT NULL,
  `SOAL_KODE` char(5) NOT NULL,
  `STAF_NIP` char(18) DEFAULT NULL,
  `VNV_TGL` datetime NOT NULL,
  `VNV_STATUS` tinyint(1) NOT NULL,
  `VNV_KET` text NOT NULL,
  PRIMARY KEY (`VNV_KODE`),
  KEY `FK_SOAL_TO_VNV` (`SOAL_KODE`),
  KEY `FK_USER_TO_VNV` (`STAF_NIP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vnv`
--


--
-- Constraints for dumped tables
--

--
-- Constraints for table `dosen`
--
ALTER TABLE `dosen`
  ADD CONSTRAINT `FK_MATA_KULIAH_TO_KBK` FOREIGN KEY (`KBK_KODE`) REFERENCES `kbk` (`KBK_KODE`),
  ADD CONSTRAINT `FK_STAFF_TO_DOSEN` FOREIGN KEY (`STAF_NIP`) REFERENCES `staf` (`STAF_NIP`);

--
-- Constraints for table `dosen_to_vnv`
--
ALTER TABLE `dosen_to_vnv`
  ADD CONSTRAINT `FK_DOSEN_TO_VNV` FOREIGN KEY (`DOSEN_KODE`) REFERENCES `dosen` (`DOSEN_KODE`),
  ADD CONSTRAINT `FK_DOSEN_TO_VNV2` FOREIGN KEY (`VNV_KODE`) REFERENCES `vnv` (`VNV_KODE`);

--
-- Constraints for table `mata_kuliah_to_dosen`
--
ALTER TABLE `mata_kuliah_to_dosen`
  ADD CONSTRAINT `FK_MATA_KULIAH_TO_DOSEN` FOREIGN KEY (`DOSEN_KODE`) REFERENCES `dosen` (`DOSEN_KODE`),
  ADD CONSTRAINT `FK_MATA_KULIAH_TO_DOSEN2` FOREIGN KEY (`MATKUL_KODE`) REFERENCES `mata_kuliah` (`MATKUL_KODE`);

--
-- Constraints for table `nilai`
--
ALTER TABLE `nilai`
  ADD CONSTRAINT `FK_RUANG_UJIAN_TO_NILAI` FOREIGN KEY (`RUANGAN_KODE`, `UJIAN_KODE`) REFERENCES `ruangan_ujian` (`RUANGAN_KODE`, `UJIAN_KODE`),
  ADD CONSTRAINT `nilai_ibfk_1` FOREIGN KEY (`RUANGAN_KODE`) REFERENCES `ruangan_ujian` (`RUANGAN_KODE`),
  ADD CONSTRAINT `nilai_ibfk_2` FOREIGN KEY (`UJIAN_KODE`) REFERENCES `ruangan_ujian` (`UJIAN_KODE`);

--
-- Constraints for table `ruangan_ujian`
--
ALTER TABLE `ruangan_ujian`
  ADD CONSTRAINT `FK_BERITAACARA_TO_RUANGANUJIAN` FOREIGN KEY (`BERITA_KODE`) REFERENCES `berita_acara` (`BERITA_KODE`),
  ADD CONSTRAINT `FK_RUANGANUJIAN_TO_STAF` FOREIGN KEY (`STAF_NIP`) REFERENCES `staf` (`STAF_NIP`),
  ADD CONSTRAINT `FK_RUANGANUJIAN_TO_UJIAN` FOREIGN KEY (`UJIAN_KODE`) REFERENCES `ujian` (`UJIAN_KODE`),
  ADD CONSTRAINT `FK_RUANGAN_TO_RUANGANUJIAN` FOREIGN KEY (`RUANGAN_KODE`) REFERENCES `ruangan` (`RUANGAN_KODE`);

--
-- Constraints for table `soal`
--
ALTER TABLE `soal`
  ADD CONSTRAINT `FK_MATA_KULIAH_TO_SOAL` FOREIGN KEY (`MATKUL_KODE`) REFERENCES `mata_kuliah` (`MATKUL_KODE`);

--
-- Constraints for table `storage_soal`
--
ALTER TABLE `storage_soal`
  ADD CONSTRAINT `FK_RELATIONSHIP_12` FOREIGN KEY (`SOAL_KODE`) REFERENCES `soal` (`SOAL_KODE`),
  ADD CONSTRAINT `FK_USER_TO_STORAGE` FOREIGN KEY (`STAF_NIP`) REFERENCES `user` (`STAF_NIP`);

--
-- Constraints for table `ujian`
--
ALTER TABLE `ujian`
  ADD CONSTRAINT `FK_EVENT_TO_UJIAN` FOREIGN KEY (`EVENT_KODE`) REFERENCES `event` (`EVENT_KODE`),
  ADD CONSTRAINT `FK_SOAL_TO_UJIAN` FOREIGN KEY (`SOAL_KODE`) REFERENCES `soal` (`SOAL_KODE`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_STAF_TO_USER` FOREIGN KEY (`STAF_NIP`) REFERENCES `staf` (`STAF_NIP`);

--
-- Constraints for table `user_to_role`
--
ALTER TABLE `user_to_role`
  ADD CONSTRAINT `FK_USER_TO_ROLE` FOREIGN KEY (`STAF_NIP`) REFERENCES `user` (`STAF_NIP`),
  ADD CONSTRAINT `FK_USER_TO_ROLE2` FOREIGN KEY (`ROLE_KODE`) REFERENCES `role` (`ROLE_KODE`);

--
-- Constraints for table `vnv`
--
ALTER TABLE `vnv`
  ADD CONSTRAINT `FK_SOAL_TO_VNV` FOREIGN KEY (`SOAL_KODE`) REFERENCES `soal` (`SOAL_KODE`),
  ADD CONSTRAINT `FK_USER_TO_VNV` FOREIGN KEY (`STAF_NIP`) REFERENCES `user` (`STAF_NIP`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
