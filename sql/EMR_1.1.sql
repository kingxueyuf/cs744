-- phpMyAdmin SQL Dump
-- version 4.0.10.2
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2015-03-09 15:16:38
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
-- 表的结构 `diagnostic_test`
--

CREATE TABLE IF NOT EXISTS `diagnostic_test` (
  `diagnostic_test_id` int(11) NOT NULL AUTO_INCREMENT,
  `diagnostic_test_name` varchar(128) NOT NULL,
  `cost` int(11) NOT NULL,
  PRIMARY KEY (`diagnostic_test_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `diagnostic_test`
--

INSERT INTO `diagnostic_test` (`diagnostic_test_id`, `diagnostic_test_name`, `cost`) VALUES
(1, 'Blood Pressure', 0),
(2, 'Tuberculosis', 0),
(3, 'Lead test', 0),
(4, 'Malaria', 0),
(5, 'Intestinal and Tissue Invasive Parasites(ITIp)', 0),
(6, 'X Ray', 0),
(7, 'CT', 0),
(8, 'Blood test', 0),
(9, 'Pregnancy test', 0);

-- --------------------------------------------------------

--
-- 表的结构 `drug`
--

CREATE TABLE IF NOT EXISTS `drug` (
  `drug_id` int(11) NOT NULL AUTO_INCREMENT,
  `drug_name` varchar(128) NOT NULL,
  `drug_term` varchar(128) NOT NULL,
  `drug_dispense` varchar(128) NOT NULL,
  PRIMARY KEY (`drug_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `drug`
--

INSERT INTO `drug` (`drug_id`, `drug_name`, `drug_term`, `drug_dispense`) VALUES
(1, 'druggg', 'abc', 'abc'),
(2, 'druggggs', 'asd', 'sdfsdg'),
(3, 'drugs', 'sfdgfbcv', 'dxcvb');

-- --------------------------------------------------------

--
-- 表的结构 `emr`
--

CREATE TABLE IF NOT EXISTS `emr` (
  `emr_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `patient_name` varchar(128) NOT NULL,
  `birthday` date NOT NULL,
  `race` varchar(64) NOT NULL,
  `occupation` varchar(64) NOT NULL,
  `address` varchar(64) NOT NULL,
  `height` varchar(64) NOT NULL,
  `weight` varchar(64) NOT NULL,
  `blood_group` varchar(64) NOT NULL,
  `vaccinations` text NOT NULL,
  `diabetes` varchar(64) NOT NULL,
  `allergies` text NOT NULL,
  PRIMARY KEY (`emr_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `emr`
--

INSERT INTO `emr` (`emr_id`, `patient_id`, `patient_name`, `birthday`, `race`, `occupation`, `address`, `height`, `weight`, `blood_group`, `vaccinations`, `diabetes`, `allergies`) VALUES
(1, 2, 'lee', '2015-02-10', 'male', 'singer', '1108 ', '180', '90', 'O', 'none test1', 'yes', 'none'),
(7, 1, 'john', '1970-03-23', '123', '123', '123', '123', '123', '123', '123', '123', '123'),
(8, 4, 'richard', '2015-02-10', 'male', 'singer', '1108 ', '180', '90', 'O', 'none', 'yes', 'none'),
(9, 5, 'richard', '1996-02-10', 'male', 'singer', '1108 ', '180', '90', 'O', 'none', 'yes', 'none'),
(10, 3, 'smith', '1995-03-03', 'Caucasian', 'single', '123', '145', '154', 'd', 'testv', 'no', 'none');

-- --------------------------------------------------------

--
-- 表的结构 `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(128) NOT NULL,
  `patient_gender` varchar(64) NOT NULL,
  `patient_age` int(64) NOT NULL,
  `patient_birthday` date NOT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `patient`
--

INSERT INTO `patient` (`patient_id`, `patient_name`, `patient_gender`, `patient_age`, `patient_birthday`) VALUES
(1, 'john', 'male', 18, '1970-03-23'),
(2, 'lee', 'male', 19, '2015-02-02'),
(3, 'smith', 'male', 0, '1995-03-03');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- 转存表中的数据 `physician`
--

INSERT INTO `physician` (`physician_id`, `physician_name`, `physician_gender`, `physician_birthday`, `account`, `password`) VALUES
(1, 'milk', 'male', '1991-06-02', 'milk', 'milk'),
(2, 'kobe', 'male', '1991-11-03', 'kobe', 'kobe'),
(3, 'amy', 'female', '1991-11-03', '123', 'amy'),
(4, 'allen', 'male', '1991-11-03', '123', 'allen');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `prescription`
--

INSERT INTO `prescription` (`prescription_id`, `transcription_id`, `patient_id`, `patient_name`, `physician_id`, `physician_name`, `create_date`, `content`) VALUES
(1, 1, 1, 'john', 1, 'milk', '2015-03-09', 'test'),
(2, 1, 1, 'john', 1, 'milk', '2015-03-07', '');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- 转存表中的数据 `relation_physician_patient`
--

INSERT INTO `relation_physician_patient` (`relation_id`, `physician_id`, `physician_name`, `patient_id`, `patient_name`, `patient_gender`, `patient_birthday`, `relation_type`, `primary_physician_id`, `primary_physician_name`, `access_right`, `start_date`, `end_date`) VALUES
(1, 1, 'milk', 1, 'john', 'male', '1991-10-12', 'PRIMARY_CARE', 1, 'milk', '11', '2015-02-09', '2015-02-10'),
(2, 1, 'milk', 2, 'lee', 'male', '1991-10-13', 'TEMPORARY_CARE', 2, 'kobe', '11', '2015-02-16', '2015-03-26'),
(3, 2, 'kobe', 2, 'lee', 'male', '1991-10-13', 'PRIMARY_CARE', 2, 'kobe', '11', '2015-02-16', '2015-02-17'),
(4, 1, 'milk', 3, 'smith', 'male', '1995-03-03', 'PRIMARY_CARE', 1, 'milk', '11', '2015-02-17', '2015-02-20'),
(5, 2, 'kobe', 1, 'john', 'male', '1991-10-12', 'TEMPORARY_CARE', 1, 'milk', '11', '2015-02-09', '2015-02-10'),
(6, 3, 'amy', 1, 'john', 'male', '1991-10-12', 'TEMPORARY_CARE', 1, 'milk', '11', '2015-02-09', '2015-02-10');

-- --------------------------------------------------------

--
-- 表的结构 `relation_prescription_drug`
--

CREATE TABLE IF NOT EXISTS `relation_prescription_drug` (
  `rpd_id` int(11) NOT NULL AUTO_INCREMENT,
  `prescription_id` int(11) NOT NULL,
  `drug_id` int(11) NOT NULL,
  `drug_name` varchar(128) NOT NULL,
  `amount` varchar(128) NOT NULL,
  PRIMARY KEY (`rpd_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `relation_prescription_drug`
--

INSERT INTO `relation_prescription_drug` (`rpd_id`, `prescription_id`, `drug_id`, `drug_name`, `amount`) VALUES
(1, 1, 1, 'druggg', '123'),
(2, 1, 2, 'drug2', '23'),
(3, 1, 3, 'drug3', '24'),
(4, 2, 1, 'drug1', '123'),
(5, 2, 2, 'drug2', '234');

-- --------------------------------------------------------

--
-- 表的结构 `relation_transcription_diagnostic_test`
--

CREATE TABLE IF NOT EXISTS `relation_transcription_diagnostic_test` (
  `relation_id` int(11) NOT NULL AUTO_INCREMENT,
  `transcription_id` int(11) NOT NULL,
  `diagnostic_test_id` int(11) NOT NULL,
  `diagnostic_test_name` varchar(128) NOT NULL,
  PRIMARY KEY (`relation_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `relation_transcription_diagnostic_test`
--

INSERT INTO `relation_transcription_diagnostic_test` (`relation_id`, `transcription_id`, `diagnostic_test_id`, `diagnostic_test_name`) VALUES
(1, 1, 1, 'Blood Pressure'),
(2, 1, 2, 'Tuberculosis');

-- --------------------------------------------------------

--
-- 表的结构 `relation_transcription_surgery`
--

CREATE TABLE IF NOT EXISTS `relation_transcription_surgery` (
  `relation_id` int(11) NOT NULL AUTO_INCREMENT,
  `surgery_id` int(11) NOT NULL,
  `transcription_id` int(11) NOT NULL,
  `surgery_name` varchar(128) NOT NULL,
  PRIMARY KEY (`relation_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `relation_transcription_surgery`
--

INSERT INTO `relation_transcription_surgery` (`relation_id`, `surgery_id`, `transcription_id`, `surgery_name`) VALUES
(1, 1, 1, 'Hand Surgery');

-- --------------------------------------------------------

--
-- 表的结构 `surgery`
--

CREATE TABLE IF NOT EXISTS `surgery` (
  `surgery_id` int(11) NOT NULL AUTO_INCREMENT,
  `surgery_name` varchar(128) NOT NULL,
  `cost` int(11) NOT NULL,
  PRIMARY KEY (`surgery_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- 转存表中的数据 `surgery`
--

INSERT INTO `surgery` (`surgery_id`, `surgery_name`, `cost`) VALUES
(1, 'Hand Surgery', 0),
(2, 'head and Neck Surgery', 0),
(3, 'Hernia Surgery', 0),
(4, 'Neurosurgery', 0),
(5, 'Orthopedic Surgery', 0),
(6, 'Ophthalmological Surgery', 0);

-- --------------------------------------------------------

--
-- 表的结构 `transcription`
--

CREATE TABLE IF NOT EXISTS `transcription` (
  `transcription_id` int(11) NOT NULL AUTO_INCREMENT,
  `emr_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `patient_name` varchar(128) NOT NULL,
  `abstraction` varchar(128) NOT NULL,
  `diagnostic_test` varchar(128) NOT NULL,
  `surgery` varchar(128) NOT NULL,
  `content` varchar(2048) NOT NULL,
  `physician_id` int(11) NOT NULL,
  `physician_name` varchar(128) NOT NULL,
  `create_date` date NOT NULL,
  PRIMARY KEY (`transcription_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `transcription`
--

INSERT INTO `transcription` (`transcription_id`, `emr_id`, `patient_id`, `patient_name`, `abstraction`, `diagnostic_test`, `surgery`, `content`, `physician_id`, `physician_name`, `create_date`) VALUES
(1, 7, 1, 'john', 'abstract1', '', '', 'CASE HISTORY:\r\n\r\nThe patient tells me that on ____ she was the belted passenger riding in the front seat of her car that apparently ran into the side of a van at approximately 30 miles per hour. The patient sustained a temporary loss of consciousness. She was taken to the emergency room where cervical spine x-rays were taken. She was given a soft cervical collar and she was given medication. She was subsequently released.\r\n\r\nShe then came under the care of her family physician for further evaluation. The patient presented to my office on ____ for evaluation and further treatment options. She had a chief complaint of ongoing neck pain and pain that was radiating across her upper back and both shoulders. This was aggravated with prolonged sitting.\r\n\r\nPAST HISTORY:\r\n\r\nThe patient denies any previous injuries or accidents to her cervical spine prior to the incident of ______________.\r\n\r\nWORK HISTORY:\r\n\r\nWork history reveals that at the time of the accident, the patient was a student at college. She also did some social work-type activity while at college. She was able to continue doing such, yet she was attending classes and doing her social work duties through her neck pain. For the most part, she was inconvenienced by such.\r\n\r\nREVIEW OF DIAGNOSTIC IMAGING:\r\n\r\nReview of diagnostic imaging notes that an MRI was taken of her cervical spine because of ongoing neck pain. This was taken at a local MRI center on ________. This was reported as an unremarkable study.\r\n\r\nPHYSICAL EXAMINATION:\r\n\r\nInitial evaluation of the cervical spine demonstrated that flexion was capable of 50/60 degrees. Extension was 45/50 degrees. Right lateral bending was 40/45 degrees. Left lateral bending was 45/45 degrees. Right rotation was 75/80 degrees and left rotation was 70/80 degrees. Most of her pain noted was with end range with flexion and extension. Sensory, motor, and reflex examinations were within normal limits. Compression test was positive for increasing neck pain. Distraction test was positive whereas traction gave relief. Jackson t', 1, 'milk', '2015-03-01'),
(2, 1, 2, 'lee', 'abstract for lee ', '', '', 'CASE HISTORY:\r\n\r\nThe patient tells me that on ____ she was the belted passenger riding in the front seat of her car that apparently ran into the side of a van at approximately 30 miles per hour. The patient sustained a temporary loss of consciousness. She was taken to the emergency room where cervical spine x-rays were taken. She was given a soft cervical collar and she was given medication. She was subsequently released.\r\n\r\nShe then came under the care of her family physician for further evaluation. The patient presented to my office on ____ for evaluation and further treatment options. She had a chief complaint of ongoing neck pain and pain that was radiating across her upper back and both shoulders. This was aggravated with prolonged sitting.\r\n\r\nPAST HISTORY:\r\n\r\nThe patient denies any previous injuries or accidents to her cervical spine prior to the incident of ______________.\r\n\r\nWORK HISTORY:\r\n\r\nWork history reveals that at the time of the accident, the patient was a student at college. She also did some social work-type activity while at college. She was able to continue doing such, yet she was attending classes and doing her social work duties through her neck pain. For the most part, she was inconvenienced by such.\r\n\r\nREVIEW OF DIAGNOSTIC IMAGING:\r\n\r\nReview of diagnostic imaging notes that an MRI was taken of her cervical spine because of ongoing neck pain. This was taken at a local MRI center on ________. This was reported as an unremarkable study.\r\n\r\nPHYSICAL EXAMINATION:\r\n\r\nInitial evaluation of the cervical spine demonstrated that flexion was capable of 50/60 degrees. Extension was 45/50 degrees. Right lateral bending was 40/45 degrees. Left lateral bending was 45/45 degrees. Right rotation was 75/80 degrees and left rotation was 70/80 degrees. Most of her pain noted was with end range with flexion and extension. Sensory, motor, and reflex examinations were within normal limits. Compression test was positive for increasing neck pain. Distraction test was positive whereas traction gave relief. Jackson t', 2, 'kobe', '2015-03-01'),
(3, 1, 2, 'lee', 'abstract for lee 2', '', '', '', 2, 'kobe', '2015-03-01');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
