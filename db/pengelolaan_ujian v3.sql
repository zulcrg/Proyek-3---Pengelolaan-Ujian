-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 09, 2014 at 01:54 PM
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
-- Table structure for table `ujian`
--

CREATE TABLE IF NOT EXISTS `ujian` (
  `UJIAN_KODE` char(5) NOT NULL,
  `EVENT_KODE` char(4) NOT NULL,
  `SOAL_KODE` char(5) NOT NULL,
  `UJIAN_MULAI` date NOT NULL,
  `UJIAN_MENIT` tinyint(4) NOT NULL,
  `UJIAN_NAMA` varchar(30) NOT NULL,
  PRIMARY KEY (`UJIAN_KODE`),
  KEY `FK_EVENT_TO_UJIAN` (`EVENT_KODE`),
  KEY `FK_SOAL_TO_UJIAN` (`SOAL_KODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ujian`
--


--
-- Constraints for dumped tables
--

--
-- Constraints for table `ujian`
--
ALTER TABLE `ujian`
  ADD CONSTRAINT `FK_EVENT_TO_UJIAN` FOREIGN KEY (`EVENT_KODE`) REFERENCES `event` (`EVENT_KODE`),
  ADD CONSTRAINT `FK_SOAL_TO_UJIAN` FOREIGN KEY (`SOAL_KODE`) REFERENCES `soal` (`SOAL_KODE`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
