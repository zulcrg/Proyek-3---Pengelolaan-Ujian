-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Waktu pembuatan: 18. Nopember 2014 jam 06:18
-- Versi Server: 5.5.8
-- Versi PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `gammu`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `daemons`
--

CREATE TABLE IF NOT EXISTS `daemons` (
  `Start` text NOT NULL,
  `Info` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `daemons`
--


-- --------------------------------------------------------

--
-- Struktur dari tabel `gammu`
--

CREATE TABLE IF NOT EXISTS `gammu` (
  `Version` int(11) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `gammu`
--

INSERT INTO `gammu` (`Version`) VALUES
(13);

-- --------------------------------------------------------

--
-- Struktur dari tabel `inbox`
--

CREATE TABLE IF NOT EXISTS `inbox` (
  `UpdatedInDB` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ReceivingDateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `Text` text NOT NULL,
  `SenderNumber` varchar(20) NOT NULL DEFAULT '',
  `Coding` enum('Default_No_Compression','Unicode_No_Compression','8bit','Default_Compression','Unicode_Compression') NOT NULL DEFAULT 'Default_No_Compression',
  `UDH` text NOT NULL,
  `SMSCNumber` varchar(20) NOT NULL DEFAULT '',
  `Class` int(11) NOT NULL DEFAULT '-1',
  `TextDecoded` text NOT NULL,
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `RecipientID` text NOT NULL,
  `Processed` enum('false','true') NOT NULL DEFAULT 'false',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=23 ;

--
-- Dumping data untuk tabel `inbox`
--

INSERT INTO `inbox` (`UpdatedInDB`, `ReceivingDateTime`, `Text`, `SenderNumber`, `Coding`, `UDH`, `SMSCNumber`, `Class`, `TextDecoded`, `ID`, `RecipientID`, `Processed`) VALUES
('2014-11-10 06:51:14', '2014-11-09 19:59:48', '00500061006B006500740020004100580049005300500052004F002000420075006C0061006E0061006E0020004200610073006900630020006B0061006D007500200064006900700065007200700061006E006A0061006E00670020006F0074006F006D00610074006900730020003200680061007200690020006C006100670069002E00500061007300740069006B0061006E002000700075006C00730061006D00750020006D0069006E0069006D0061006C0020005200700034003900720062002E00550074006B002000620065007200680065006E00740069002C00740065006C00700020002A003100320033002A0032002A00390023002E00200049006E0066006F003800310037', 'AXIS', 'Default_No_Compression', '', '+628184422876', -1, 'Paket AXISPRO Bulanan Basic kamu diperpanjang otomatis 2hari lagi.Pastikan pulsamu minimal Rp49rb.Utk berhenti,telp *123*2*9#. Info817', 22, '', 'false');

--
-- Trigger `inbox`
--
DROP TRIGGER IF EXISTS `inbox_timestamp`;
DELIMITER //
CREATE TRIGGER `inbox_timestamp` BEFORE INSERT ON `inbox`
 FOR EACH ROW BEGIN
    IF NEW.ReceivingDateTime = '0000-00-00 00:00:00' THEN
        SET NEW.ReceivingDateTime = CURRENT_TIMESTAMP();
    END IF;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kalkulus`
--

CREATE TABLE IF NOT EXISTS `kalkulus` (
  `nim` varchar(9) NOT NULL,
  `nilai` varchar(3) NOT NULL,
  PRIMARY KEY (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kalkulus`
--

INSERT INTO `kalkulus` (`nim`, `nilai`) VALUES
('131511019', '79'),
('131511020', '80'),
('131511021', '86');

-- --------------------------------------------------------

--
-- Struktur dari tabel `outbox`
--

CREATE TABLE IF NOT EXISTS `outbox` (
  `UpdatedInDB` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `InsertIntoDB` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `SendingDateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `SendBefore` time NOT NULL DEFAULT '23:59:59',
  `SendAfter` time NOT NULL DEFAULT '00:00:00',
  `Text` text,
  `DestinationNumber` varchar(20) NOT NULL DEFAULT '',
  `Coding` enum('Default_No_Compression','Unicode_No_Compression','8bit','Default_Compression','Unicode_Compression') NOT NULL DEFAULT 'Default_No_Compression',
  `UDH` text,
  `Class` int(11) DEFAULT '-1',
  `TextDecoded` text NOT NULL,
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MultiPart` enum('false','true') DEFAULT 'false',
  `RelativeValidity` int(11) DEFAULT '-1',
  `SenderID` varchar(255) DEFAULT NULL,
  `SendingTimeOut` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `DeliveryReport` enum('default','yes','no') DEFAULT 'default',
  `CreatorID` text NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `outbox_date` (`SendingDateTime`,`SendingTimeOut`),
  KEY `outbox_sender` (`SenderID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=22 ;

--
-- Dumping data untuk tabel `outbox`
--


--
-- Trigger `outbox`
--
DROP TRIGGER IF EXISTS `outbox_timestamp`;
DELIMITER //
CREATE TRIGGER `outbox_timestamp` BEFORE INSERT ON `outbox`
 FOR EACH ROW BEGIN
    IF NEW.InsertIntoDB = '0000-00-00 00:00:00' THEN
        SET NEW.InsertIntoDB = CURRENT_TIMESTAMP();
    END IF;
    IF NEW.SendingDateTime = '0000-00-00 00:00:00' THEN
        SET NEW.SendingDateTime = CURRENT_TIMESTAMP();
    END IF;
    IF NEW.SendingTimeOut = '0000-00-00 00:00:00' THEN
        SET NEW.SendingTimeOut = CURRENT_TIMESTAMP();
    END IF;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `outbox_multipart`
--

CREATE TABLE IF NOT EXISTS `outbox_multipart` (
  `Text` text,
  `Coding` enum('Default_No_Compression','Unicode_No_Compression','8bit','Default_Compression','Unicode_Compression') NOT NULL DEFAULT 'Default_No_Compression',
  `UDH` text,
  `Class` int(11) DEFAULT '-1',
  `TextDecoded` text,
  `ID` int(10) unsigned NOT NULL DEFAULT '0',
  `SequencePosition` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`,`SequencePosition`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `outbox_multipart`
--


-- --------------------------------------------------------

--
-- Struktur dari tabel `pbk`
--

CREATE TABLE IF NOT EXISTS `pbk` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GroupID` int(11) NOT NULL DEFAULT '-1',
  `Name` text NOT NULL,
  `Number` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Dumping data untuk tabel `pbk`
--


-- --------------------------------------------------------

--
-- Struktur dari tabel `pbk_groups`
--

CREATE TABLE IF NOT EXISTS `pbk_groups` (
  `Name` text NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Dumping data untuk tabel `pbk_groups`
--


-- --------------------------------------------------------

--
-- Struktur dari tabel `phones`
--

CREATE TABLE IF NOT EXISTS `phones` (
  `ID` text NOT NULL,
  `UpdatedInDB` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `InsertIntoDB` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `TimeOut` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `Send` enum('yes','no') NOT NULL DEFAULT 'no',
  `Receive` enum('yes','no') NOT NULL DEFAULT 'no',
  `IMEI` varchar(35) NOT NULL,
  `Client` text NOT NULL,
  `Battery` int(11) NOT NULL DEFAULT '-1',
  `Signal` int(11) NOT NULL DEFAULT '-1',
  `Sent` int(11) NOT NULL DEFAULT '0',
  `Received` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IMEI`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `phones`
--

INSERT INTO `phones` (`ID`, `UpdatedInDB`, `InsertIntoDB`, `TimeOut`, `Send`, `Receive`, `IMEI`, `Client`, `Battery`, `Signal`, `Sent`, `Received`) VALUES
('', '2014-11-10 08:46:15', '2014-11-10 06:52:26', '2014-11-10 08:46:25', 'yes', 'yes', '353142034333560', 'Gammu 1.32.0, Windows Server 2007, GCC 4.7, MinGW 3.11', 0, 33, 3, 0);

--
-- Trigger `phones`
--
DROP TRIGGER IF EXISTS `phones_timestamp`;
DELIMITER //
CREATE TRIGGER `phones_timestamp` BEFORE INSERT ON `phones`
 FOR EACH ROW BEGIN
    IF NEW.InsertIntoDB = '0000-00-00 00:00:00' THEN
        SET NEW.InsertIntoDB = CURRENT_TIMESTAMP();
    END IF;
    IF NEW.TimeOut = '0000-00-00 00:00:00' THEN
        SET NEW.TimeOut = CURRENT_TIMESTAMP();
    END IF;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `sentitems`
--

CREATE TABLE IF NOT EXISTS `sentitems` (
  `UpdatedInDB` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `InsertIntoDB` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `SendingDateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `DeliveryDateTime` timestamp NULL DEFAULT NULL,
  `Text` text NOT NULL,
  `DestinationNumber` varchar(20) NOT NULL DEFAULT '',
  `Coding` enum('Default_No_Compression','Unicode_No_Compression','8bit','Default_Compression','Unicode_Compression') NOT NULL DEFAULT 'Default_No_Compression',
  `UDH` text NOT NULL,
  `SMSCNumber` varchar(20) NOT NULL DEFAULT '',
  `Class` int(11) NOT NULL DEFAULT '-1',
  `TextDecoded` text NOT NULL,
  `ID` int(10) unsigned NOT NULL DEFAULT '0',
  `SenderID` varchar(255) NOT NULL,
  `SequencePosition` int(11) NOT NULL DEFAULT '1',
  `Status` enum('SendingOK','SendingOKNoReport','SendingError','DeliveryOK','DeliveryFailed','DeliveryPending','DeliveryUnknown','Error') NOT NULL DEFAULT 'SendingOK',
  `StatusError` int(11) NOT NULL DEFAULT '-1',
  `TPMR` int(11) NOT NULL DEFAULT '-1',
  `RelativeValidity` int(11) NOT NULL DEFAULT '-1',
  `CreatorID` text NOT NULL,
  PRIMARY KEY (`ID`,`SequencePosition`),
  KEY `sentitems_date` (`DeliveryDateTime`),
  KEY `sentitems_tpmr` (`TPMR`),
  KEY `sentitems_dest` (`DestinationNumber`),
  KEY `sentitems_sender` (`SenderID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `sentitems`
--

INSERT INTO `sentitems` (`UpdatedInDB`, `InsertIntoDB`, `SendingDateTime`, `DeliveryDateTime`, `Text`, `DestinationNumber`, `Coding`, `UDH`, `SMSCNumber`, `Class`, `TextDecoded`, `ID`, `SenderID`, `SequencePosition`, `Status`, `StatusError`, `TPMR`, `RelativeValidity`, `CreatorID`) VALUES
('2014-11-10 06:53:29', '2014-11-10 06:53:07', '2014-11-10 06:53:29', NULL, '00740065007300740069006E006700200073006D0073', '085624257705', 'Default_No_Compression', '', '+628315000032', -1, 'testing sms', 19, '', 1, 'SendingOKNoReport', -1, 121, 255, 'Gammu'),
('2014-11-10 06:52:07', '2014-11-09 20:04:19', '2014-11-10 06:52:07', NULL, '006400610073006400610064', 'To :', 'Default_No_Compression', '', '+628315000032', -1, 'dasdad', 18, '', 1, 'SendingError', -1, -1, 255, 'Gammu'),
('2014-11-09 09:51:42', '2014-11-09 09:51:18', '2014-11-09 09:51:42', NULL, '00740065007300740069006E0067002000470061006D006D007500200053004D005300440052004300200073006500720069007600630065002000570069006E0064006F00770073', '085624257705', 'Default_No_Compression', '', '+628315000032', -1, 'testing Gammu SMSDRC serivce Windows', 17, '', 1, 'SendingOKNoReport', -1, 119, 255, 'Gammu'),
('2014-11-08 22:10:33', '2014-11-08 22:10:25', '2014-11-08 22:10:33', NULL, '0054006500730074', '+6285624257705', 'Default_No_Compression', '', '+628315000032', -1, 'Test', 14, '', 1, 'SendingOKNoReport', -1, 116, 255, 'Gammu'),
('2014-11-09 09:48:06', '2014-11-09 09:47:21', '2014-11-09 09:48:06', NULL, '0074006500730069006E0067002000470061006D006D007500200073006D007300200073006500720076006900630065002000410070006C0069006B006100730069002000500065006E00670065006C006F006C00610061006E00200055006A00690061006E002000760031002E0030', '085624257705', 'Default_No_Compression', '', '+628315000032', -1, 'tesing Gammu sms service Aplikasi Pengelolaan Ujian v1.0', 16, '', 1, 'SendingOKNoReport', -1, 118, 255, 'Gammu'),
('2014-11-08 22:09:26', '2014-11-08 22:08:38', '2014-11-08 22:09:26', NULL, '0024007200650070006C0079', '$noPengirim', 'Default_No_Compression', '', '+628315000032', -1, '$reply', 12, '', 1, 'SendingError', -1, -1, 255, 'Gammu'),
('2014-11-08 22:10:30', '2014-11-08 22:10:02', '2014-11-08 22:10:30', NULL, '0054006500730074', '+6285624257705', 'Default_No_Compression', '', '+628315000032', -1, 'Test', 13, '', 1, 'SendingOKNoReport', -1, 115, 255, 'Gammu'),
('2014-11-08 21:00:03', '2014-11-08 20:59:43', '2014-11-08 21:00:03', NULL, '00740065007300740069006E0067002000670075006900640065', '+6285624257705', 'Default_No_Compression', '', '+628315000032', -1, 'testing guide', 10, '', 1, 'SendingOKNoReport', -1, 112, 255, 'Gammu'),
('2014-11-08 22:07:57', '2014-11-08 22:07:16', '2014-11-08 22:07:57', NULL, '0024007200650070006C0079', '$noPengirim', 'Default_No_Compression', '', '+628315000032', -1, '$reply', 11, '', 1, 'SendingError', -1, -1, 255, 'Gammu'),
('2014-11-10 06:57:07', '2014-11-10 06:56:33', '2014-11-10 06:57:07', NULL, '00740065007300740069006E0067', '085624715501', 'Default_No_Compression', '', '+628315000032', -1, 'testing', 20, '', 1, 'SendingOKNoReport', -1, 122, 255, 'Gammu'),
('2014-11-10 07:31:44', '2014-11-10 07:31:12', '2014-11-10 07:31:44', NULL, '0069006E00690020007400650073007400200053004D0053002000470061006D006D0075', '085323655932', 'Default_No_Compression', '', '+628315000032', -1, 'ini test SMS Gammu', 21, '', 1, 'SendingOKNoReport', -1, 123, 255, 'Gammu');

--
-- Trigger `sentitems`
--
DROP TRIGGER IF EXISTS `sentitems_timestamp`;
DELIMITER //
CREATE TRIGGER `sentitems_timestamp` BEFORE INSERT ON `sentitems`
 FOR EACH ROW BEGIN
    IF NEW.InsertIntoDB = '0000-00-00 00:00:00' THEN
        SET NEW.InsertIntoDB = CURRENT_TIMESTAMP();
    END IF;
    IF NEW.SendingDateTime = '0000-00-00 00:00:00' THEN
        SET NEW.SendingDateTime = CURRENT_TIMESTAMP();
    END IF;
END
//
DELIMITER ;
