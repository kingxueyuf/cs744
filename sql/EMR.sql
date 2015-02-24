-- phpMyAdmin SQL Dump
-- version 4.0.10.2
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2015-02-24 15:15:45
-- 服务器版本: 5.1.69
-- PHP 版本: 5.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `EMR`
--

-- --------------------------------------------------------

--
-- 表的结构 `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_account` varchar(128) NOT NULL,
  `admin_password` varchar(256) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `emr`
--

CREATE TABLE IF NOT EXISTS `emr` (
  `emr_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `patient_name` varchar(128) NOT NULL,
  PRIMARY KEY (`emr_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `emr`
--

INSERT INTO `emr` (`emr_id`, `patient_id`, `patient_name`) VALUES
(1, 2, 'lee');

-- --------------------------------------------------------

--
-- 表的结构 `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(128) NOT NULL,
  `patient_gender` varchar(64) NOT NULL,
  `patient_age` varchar(64) NOT NULL,
  `patient_birthday` date NOT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `patient`
--

INSERT INTO `patient` (`patient_id`, `patient_name`, `patient_gender`, `patient_age`, `patient_birthday`) VALUES
(1, 'john', 'male', '18', '2015-02-23'),
(2, 'lee', 'male', '19', '2015-02-02');

-- --------------------------------------------------------

--
-- 表的结构 `physician`
--

CREATE TABLE IF NOT EXISTS `physician` (
  `physician_id` int(11) NOT NULL AUTO_INCREMENT,
  `physician_name` varchar(128) NOT NULL,
  `physician_gender` varchar(64) NOT NULL,
  `physician_birthday` date NOT NULL,
  `account` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  PRIMARY KEY (`physician_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `physician`
--

INSERT INTO `physician` (`physician_id`, `physician_name`, `physician_gender`, `physician_birthday`, `account`, `password`) VALUES
(1, 'milk', 'male', '1991-06-02', 'milk', 'milk'),
(2, 'kobe', 'male', '1991-11-03', 'kobe', 'kobe');

-- --------------------------------------------------------

--
-- 表的结构 `prescription`
--

CREATE TABLE IF NOT EXISTS `prescription` (
  `prescription_id` int(11) NOT NULL AUTO_INCREMENT,
  `transcription_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `patient_name` varchar(128) NOT NULL,
  `physician_id` int(11) NOT NULL,
  `physician_name` varchar(128) NOT NULL,
  `create_date` date NOT NULL,
  `content` varchar(256) NOT NULL,
  PRIMARY KEY (`prescription_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `relation_physician_patient`
--

CREATE TABLE IF NOT EXISTS `relation_physician_patient` (
  `relation_id` int(11) NOT NULL AUTO_INCREMENT,
  `physician_id` int(11) NOT NULL,
  `physician_name` varchar(128) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `patient_name` varchar(128) NOT NULL,
  `patient_gender` varchar(64) NOT NULL,
  `patient_birthday` date NOT NULL,
  `relation_type` varchar(64) NOT NULL,
  `primary_physician_id` int(11) NOT NULL,
  `primary_physician_name` varchar(128) NOT NULL,
  `access_right` varchar(64) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`relation_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `relation_physician_patient`
--

INSERT INTO `relation_physician_patient` (`relation_id`, `physician_id`, `physician_name`, `patient_id`, `patient_name`, `patient_gender`, `patient_birthday`, `relation_type`, `primary_physician_id`, `primary_physician_name`, `access_right`, `start_date`, `end_date`) VALUES
(1, 1, 'milk', 1, 'john', 'male', '1991-10-12', 'PRIMARY_CARE', 1, 'milk', '11', '2015-02-09', '2015-02-10'),
(2, 1, 'milk', 2, 'lee', 'male', '1991-10-13', 'TEMPORARY_CARE', 2, 'kobe', '11', '2015-02-16', '2015-03-26');

-- --------------------------------------------------------

--
-- 表的结构 `transcription`
--

CREATE TABLE IF NOT EXISTS `transcription` (
  `transcription_id` int(11) NOT NULL AUTO_INCREMENT,
  `emr_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `patient_name` varchar(128) NOT NULL,
  `physician_id` int(11) NOT NULL,
  `physician_name` varchar(128) NOT NULL,
  `create_date` date NOT NULL,
  PRIMARY KEY (`transcription_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
