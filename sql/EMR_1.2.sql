-- phpMyAdmin SQL Dump
-- version 4.0.10.2
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2015-03-10 15:20:41
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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- 转存表中的数据 `diagnostic_test`
--

INSERT INTO `diagnostic_test` (`diagnostic_test_id`, `diagnostic_test_name`, `cost`) VALUES
(1, 'Blood Pressure', 130),
(2, 'Tuberculosis', 120),
(3, 'Lead test', 200),
(4, 'Malaria', 300),
(5, 'Intestinal and Tissue Invasive Parasites(ITIp)', 400),
(6, 'X Ray', 500),
(7, 'CT', 600),
(8, 'Blood test', 700),
(9, 'Pregnancy test', 170),
(11, 'Abdominoplasty (Tummy Tuck ( Abdominoplasty))', 12),
(12, 'Acupuncture', 210),
(13, 'Barrier Methods of Birth Control', 123),
(14, 'Capsule Endoscopy', 210),
(15, 'Dental (Fillings)', 128),
(16, 'Ear Tubes', 321);

-- --------------------------------------------------------

--
-- 表的结构 `drug`
--

CREATE TABLE IF NOT EXISTS `drug` (
  `drug_id` int(11) NOT NULL AUTO_INCREMENT,
  `drug_name` varchar(128) NOT NULL,
  PRIMARY KEY (`drug_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- 转存表中的数据 `drug`
--

INSERT INTO `drug` (`drug_id`, `drug_name`) VALUES
(1, 'druggg'),
(2, 'druggggs'),
(3, 'drugs'),
(4, 'Abacavir Sulfate (Ziagen)'),
(5, 'Abilify (Aripiprazole)'),
(6, 'Abiraterone Acetate Tablets (Zytiga)'),
(7, 'Actigall (Ursodiol, USP Capsules)'),
(8, 'Aflibercept (Eylea)'),
(9, 'Baclofen (Kemstro)'),
(10, 'Bacteriostatic Water (Bacteriostatic Water for Injection)'),
(11, 'Basiliximab (Simulect)');

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
(1, 'john doe', 'male', 18, '1970-03-23'),
(2, 'lee xin', 'male', 19, '2015-02-02'),
(3, 'smith wang', 'male', 0, '1995-03-03');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- 转存表中的数据 `prescription`
--

INSERT INTO `prescription` (`prescription_id`, `transcription_id`, `patient_id`, `patient_name`, `physician_id`, `physician_name`, `create_date`, `content`) VALUES
(8, 55, 1, 'john doe', 1, 'milk', '2015-03-10', ''),
(9, 56, 1, 'john doe', 1, 'milk', '2015-03-10', ''),
(10, 57, 1, 'john doe', 1, 'milk', '2015-03-10', ''),
(11, 58, 1, 'john doe', 1, 'milk', '2015-03-10', '');

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
(1, 1, 'milk', 1, 'john doe', 'male', '1991-10-12', 'PRIMARY_CARE', 1, 'milk', '11', '2015-02-09', '2015-02-10'),
(2, 1, 'milk', 2, 'lee xin', 'male', '1991-10-13', 'TEMPORARY_CARE', 2, 'kobe', '11', '2015-02-16', '2015-03-26'),
(3, 2, 'kobe', 2, 'lee xin', 'male', '1991-10-13', 'PRIMARY_CARE', 2, 'kobe', '11', '2015-02-16', '2015-02-17'),
(4, 1, 'milk', 3, 'smith wang', 'male', '1995-03-03', 'PRIMARY_CARE', 1, 'milk', '11', '2015-02-17', '2015-02-20'),
(5, 2, 'kobe', 1, 'john doe', 'male', '1991-10-12', 'TEMPORARY_CARE', 1, 'milk', '11', '2015-02-09', '2015-02-10'),
(6, 3, 'amy', 1, 'john doe', 'male', '1991-10-12', 'TEMPORARY_CARE', 1, 'milk', '11', '2015-02-09', '2015-02-10');

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `relation_prescription_drug`
--

INSERT INTO `relation_prescription_drug` (`rpd_id`, `prescription_id`, `drug_id`, `drug_name`, `amount`) VALUES
(1, 9, 4, 'Abacavir Sulfate (Ziagen)', '12'),
(2, 9, 9, 'Baclofen (Kemstro)', '12');

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- 转存表中的数据 `relation_transcription_diagnostic_test`
--

INSERT INTO `relation_transcription_diagnostic_test` (`relation_id`, `transcription_id`, `diagnostic_test_id`, `diagnostic_test_name`) VALUES
(1, 56, 11, 'Abdominoplasty (Tummy Tuck ( Abdominoplasty))'),
(2, 56, 8, 'Blood test'),
(3, 56, 7, 'CT'),
(4, 57, 11, 'Abdominoplasty (Tummy Tuck ( Abdominoplasty))'),
(5, 57, 1, 'Blood Pressure'),
(6, 57, 6, 'X Ray'),
(7, 57, 7, 'CT'),
(8, 58, 11, 'Abdominoplasty (Tummy Tuck ( Abdominoplasty))'),
(9, 58, 1, 'Blood Pressure'),
(10, 58, 7, 'CT'),
(11, 58, 6, 'X Ray'),
(12, 59, 11, 'Abdominoplasty (Tummy Tuck ( Abdominoplasty))'),
(13, 59, 1, 'Blood Pressure'),
(14, 59, 7, 'CT'),
(15, 59, 6, 'X Ray');

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- 转存表中的数据 `relation_transcription_surgery`
--

INSERT INTO `relation_transcription_surgery` (`relation_id`, `surgery_id`, `transcription_id`, `surgery_name`) VALUES
(1, 1, 56, 'Hand Surgery'),
(2, 1, 57, 'Hand Surgery'),
(3, 7, 57, 'Amputation'),
(4, 1, 58, 'Hand Surgery'),
(5, 7, 58, 'Amputation'),
(6, 7, 59, 'Amputation'),
(7, 9, 59, 'Blepharoplasty'),
(8, 2, 59, 'head and Neck Surgery');

-- --------------------------------------------------------

--
-- 表的结构 `surgery`
--

CREATE TABLE IF NOT EXISTS `surgery` (
  `surgery_id` int(11) NOT NULL AUTO_INCREMENT,
  `surgery_name` varchar(128) NOT NULL,
  `cost` int(11) NOT NULL,
  PRIMARY KEY (`surgery_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `surgery`
--

INSERT INTO `surgery` (`surgery_id`, `surgery_name`, `cost`) VALUES
(1, 'Hand Surgery', 0),
(2, 'head and Neck Surgery', 0),
(3, 'Hernia Surgery', 0),
(4, 'Neurosurgery', 0),
(5, 'Orthopedic Surgery', 0),
(6, 'Ophthalmological Surgery', 0),
(7, 'Amputation', 121),
(8, 'Appendectomy', 0),
(9, 'Blepharoplasty', 0),
(10, 'Hysterectomy', 0);

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
  `content` varchar(2048) NOT NULL,
  `physician_id` int(11) NOT NULL,
  `physician_name` varchar(128) NOT NULL,
  `create_date` date NOT NULL,
  PRIMARY KEY (`transcription_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=60 ;

--
-- 转存表中的数据 `transcription`
--

INSERT INTO `transcription` (`transcription_id`, `emr_id`, `patient_id`, `patient_name`, `abstraction`, `content`, `physician_id`, `physician_name`, `create_date`) VALUES
(1, 7, 1, 'john doe', 'abstract1', 'CASE HISTORY:\r\n\r\nThe patient tells me that on ____ she was the belted passenger riding in the front seat of her car that apparently ran into the side of a van at approximately 30 miles per hour. The patient sustained a temporary loss of consciousness. She was taken to the emergency room where cervical spine x-rays were taken. She was given a soft cervical collar and she was given medication. She was subsequently released.\r\n\r\nShe then came under the care of her family physician for further evaluation. The patient presented to my office on ____ for evaluation and further treatment options. She had a chief complaint of ongoing neck pain and pain that was radiating across her upper back and both shoulders. This was aggravated with prolonged sitting.\r\n\r\nPAST HISTORY:\r\n\r\nThe patient denies any previous injuries or accidents to her cervical spine prior to the incident of ______________.\r\n\r\nWORK HISTORY:\r\n\r\nWork history reveals that at the time of the accident, the patient was a student at college. She also did some social work-type activity while at college. She was able to continue doing such, yet she was attending classes and doing her social work duties through her neck pain. For the most part, she was inconvenienced by such.\r\n\r\nREVIEW OF DIAGNOSTIC IMAGING:\r\n\r\nReview of diagnostic imaging notes that an MRI was taken of her cervical spine because of ongoing neck pain. This was taken at a local MRI center on ________. This was reported as an unremarkable study.\r\n\r\nPHYSICAL EXAMINATION:\r\n\r\nInitial evaluation of the cervical spine demonstrated that flexion was capable of 50/60 degrees. Extension was 45/50 degrees. Right lateral bending was 40/45 degrees. Left lateral bending was 45/45 degrees. Right rotation was 75/80 degrees and left rotation was 70/80 degrees. Most of her pain noted was with end range with flexion and extension. Sensory, motor, and reflex examinations were within normal limits. Compression test was positive for increasing neck pain. Distraction test was positive whereas traction gave relief. Jackson t', 1, 'milk', '2015-03-01'),
(2, 1, 2, 'lee wang', 'abstract for lee ', 'CASE HISTORY:\r\n\r\nThe patient tells me that on ____ she was the belted passenger riding in the front seat of her car that apparently ran into the side of a van at approximately 30 miles per hour. The patient sustained a temporary loss of consciousness. She was taken to the emergency room where cervical spine x-rays were taken. She was given a soft cervical collar and she was given medication. She was subsequently released.\r\n\r\nShe then came under the care of her family physician for further evaluation. The patient presented to my office on ____ for evaluation and further treatment options. She had a chief complaint of ongoing neck pain and pain that was radiating across her upper back and both shoulders. This was aggravated with prolonged sitting.\r\n\r\nPAST HISTORY:\r\n\r\nThe patient denies any previous injuries or accidents to her cervical spine prior to the incident of ______________.\r\n\r\nWORK HISTORY:\r\n\r\nWork history reveals that at the time of the accident, the patient was a student at college. She also did some social work-type activity while at college. She was able to continue doing such, yet she was attending classes and doing her social work duties through her neck pain. For the most part, she was inconvenienced by such.\r\n\r\nREVIEW OF DIAGNOSTIC IMAGING:\r\n\r\nReview of diagnostic imaging notes that an MRI was taken of her cervical spine because of ongoing neck pain. This was taken at a local MRI center on ________. This was reported as an unremarkable study.\r\n\r\nPHYSICAL EXAMINATION:\r\n\r\nInitial evaluation of the cervical spine demonstrated that flexion was capable of 50/60 degrees. Extension was 45/50 degrees. Right lateral bending was 40/45 degrees. Left lateral bending was 45/45 degrees. Right rotation was 75/80 degrees and left rotation was 70/80 degrees. Most of her pain noted was with end range with flexion and extension. Sensory, motor, and reflex examinations were within normal limits. Compression test was positive for increasing neck pain. Distraction test was positive whereas traction gave relief. Jackson t', 2, 'kobe', '2015-03-01'),
(3, 1, 2, 'lee wang', 'abstract for lee 2', '', 2, 'kobe', '2015-03-01'),
(55, 7, 1, 'john doe', '', '', 1, 'milk', '2015-03-10'),
(56, 7, 1, 'john doe', '', '', 1, 'milk', '2015-03-10'),
(57, 7, 1, 'john doe', '', '', 1, 'milk', '2015-03-10'),
(58, 7, 1, 'john doe', '', '', 1, 'milk', '2015-03-10'),
(59, 7, 1, 'john doe', '', '', 1, 'milk', '2015-03-10');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
