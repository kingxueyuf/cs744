-- phpMyAdmin SQL Dump
-- version 4.0.10.2
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2015-03-31 14:34:39
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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_account`, `admin_password`) VALUES
(1, 'admin', '123'),
(2, 'kasi', 'kasi');

-- --------------------------------------------------------

--
-- 表的结构 `department`
--

CREATE TABLE IF NOT EXISTS `department` (
  `department_id` int(64) NOT NULL AUTO_INCREMENT,
  `department_name` text,
  PRIMARY KEY (`department_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- 转存表中的数据 `department`
--

INSERT INTO `department` (`department_id`, `department_name`) VALUES
(1, 'Burn_Center'),
(2, 'Acute_Assessment_Unit'),
(3, 'Central_Sterile_Services'),
(4, 'Coronary_Care_Unit'),
(5, 'Emergency_Department'),
(6, 'Geriatric_Intensive-care_Unit'),
(7, 'Intensive_Care_Unit'),
(8, 'Medical_Records_Department'),
(9, 'Neonatal_Intensive_Care_Unit'),
(10, 'On-call_Room'),
(11, 'Operating_Room'),
(12, 'Pediatric_Intensive_Care_Unit'),
(13, 'Hospital_Pharmacy'),
(14, 'Physical_Therapy'),
(15, 'Post-anesthesia_Care_Unit'),
(16, 'Psychiatric_Hospital'),
(17, 'Release_of_Information'),
(18, 'Hospital_Warehouse');

-- --------------------------------------------------------

--
-- 表的结构 `diagnostic_test`
--

CREATE TABLE IF NOT EXISTS `diagnostic_test` (
  `diagnostic_test_id` int(11) NOT NULL AUTO_INCREMENT,
  `diagnostic_test_name` varchar(128) NOT NULL,
  `cost` int(11) NOT NULL,
  PRIMARY KEY (`diagnostic_test_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

--
-- 转存表中的数据 `diagnostic_test`
--

INSERT INTO `diagnostic_test` (`diagnostic_test_id`, `diagnostic_test_name`, `cost`) VALUES
(6, 'X Ray', 500),
(7, 'CT', 600),
(8, 'Blood test', 700),
(9, 'Pregnancy test', 170),
(11, 'Abdominoplasty (Tummy Tuck ( Abdominoplasty))', 12),
(13, 'Barrier Methods of Birth Control', 123),
(14, 'Capsule Endoscopy', 210);

-- --------------------------------------------------------

--
-- 表的结构 `drug`
--

CREATE TABLE IF NOT EXISTS `drug` (
  `drug_id` int(11) NOT NULL AUTO_INCREMENT,
  `drug_name` varchar(128) NOT NULL,
  PRIMARY KEY (`drug_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- 转存表中的数据 `drug`
--

INSERT INTO `drug` (`drug_id`, `drug_name`) VALUES
(1, 'lets test!'),
(2, 'druggggs'),
(3, 'drugs'),
(4, 'Abacavir Sulfate (Ziagen)'),
(5, 'Abilify (Aripiprazole)'),
(6, 'Abiraterone Acetate Tablets (Zytiga)'),
(7, 'Actigall (Ursodiol, USP Capsules)'),
(8, 'Aflibercept (Eylea)'),
(9, 'Baclofen (Kemstro)'),
(10, 'Bacteriostatic Water (Bacteriostatic Water for Injection)'),
(11, 'Basiliximab (Simulect)'),
(12, 'drugstest1'),
(13, 'drugsTest'),
(14, 'drugs1123123123');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- 转存表中的数据 `emr`
--

INSERT INTO `emr` (`emr_id`, `patient_id`, `patient_name`, `birthday`, `race`, `occupation`, `address`, `height`, `weight`, `blood_group`, `vaccinations`, `diabetes`, `allergies`) VALUES
(1, 2, 'lee', '2015-02-10', 'asian', 'singer', '1108 ', '180', '90', 'O', 'none test1', 'yes', 'none'),
(13, 1, 'john doe', '1970-03-23', 'asian', 'o', '1108 state st', '190', '90', 'O ', 'ANTHRAX  02/13/15CHICKENPOX 01/13/14DIPHTHERIA 04/12/11HEPATITIS A 01/03/10HEPATITIS B 02/13/15HIB 02/13/15', 'NO', 'MILKEGGHONEY'),
(14, 3, 'smith wang', '1995-03-03', 'asian', 'O', '11001', '190', '90', 'O', 'ANTHRAX  02/13/15CHICKENPOX 01/13/14DIPHTHERIA 04/12/11HEPATITIS A 01/03/10HEPATITIS B 02/13/15HIB 02/13/15', 'no', 'MILKEGGHONEY');

-- --------------------------------------------------------

--
-- 表的结构 `medical_staff`
--

CREATE TABLE IF NOT EXISTS `medical_staff` (
  `msid` int(11) NOT NULL AUTO_INCREMENT,
  `ms_name` varchar(128) NOT NULL,
  `ms_account` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  `physician_id` int(11) NOT NULL,
  `physician_name` varchar(128) NOT NULL,
  PRIMARY KEY (`msid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `medical_staff`
--

INSERT INTO `medical_staff` (`msid`, `ms_name`, `ms_account`, `password`, `physician_id`, `physician_name`) VALUES
(1, 'Kasi Periyasamy', 'Kasi Periyasamy', 'kasi', 1, 'milk xue');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

--
-- 转存表中的数据 `physician`
--

INSERT INTO `physician` (`physician_id`, `physician_name`, `physician_gender`, `physician_birthday`, `account`, `password`) VALUES
(1, 'milk xue', 'male', '1991-06-02', 'milk xue', 'milk'),
(2, 'kobe', 'male', '1991-11-03', 'kobe', 'kobe'),
(3, 'amy', 'female', '1991-11-03', '123', 'amy'),
(4, 'allen', 'male', '1991-11-03', '123', 'allen'),
(5, 'Bob', 'male', '1991-11-15', 'bob', '123'),
(6, 'lily', 'female', '1991-11-04', 'lily', '123'),
(7, 'tracy', 'female', '1993-11-04', 'tracy', '123'),
(8, 'jack', 'male', '1993-11-04', 'jack', '123'),
(9, 'jason', 'male', '1993-11-04', 'jason', '123'),
(10, 'alvin', 'male', '1993-11-04', 'alvin', '123'),
(11, 'lee', 'male', '1993-11-04', 'lee', '123'),
(12, 'wellson', 'male', '1995-11-04', 'wellson', '123'),
(13, 'neo', 'male', '1995-11-04', 'neo', '123'),
(14, 'tyler', 'male', '1992-11-04', 'tyler', '123'),
(15, 'calvin', 'male', '1992-11-04', 'calvin', '123'),
(16, 'dogge', 'male', '1992-11-04', 'dogge', '123'),
(17, 'edison', 'male', '1992-11-04', 'edison', '123'),
(18, 'frank', 'male', '1992-11-04', 'frank', '123'),
(19, 'goodman', 'male', '1992-11-04', 'goodman', '123'),
(20, 'hebe', 'female', '1993-11-04', 'hebe', '123'),
(21, 'ibby', 'female', '1993-11-04', 'ibby', '123'),
(22, 'obama', 'male', '1995-11-04', 'obama', '123'),
(23, 'petter', 'male', '1995-11-04', 'petter', '123'),
(24, 'queen', 'female', '1993-11-04', 'queen', '123'),
(25, 'rose', 'female', '1995-11-04', 'rose', '123'),
(26, 'sarah', 'female', '1994-11-04', 'sarah', '123'),
(27, 'uliana', 'female', '1992-11-04', 'uliana', '123'),
(28, 'vicky', 'female', '1992-11-04', 'vicky', '123'),
(29, 'xu', 'male', '1990-11-04', 'xu', '123'),
(30, 'yuliy', 'male', '1990-11-04', 'yuliy', '123'),
(31, 'zane', 'male', '1990-11-04', 'zane', '123');

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
  `writer_id` int(11) NOT NULL,
  `writer_name` varchar(128) NOT NULL,
  `writer_type` varchar(128) NOT NULL,
  `create_date` date NOT NULL,
  `content` varchar(256) NOT NULL,
  PRIMARY KEY (`prescription_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `prescription`
--

INSERT INTO `prescription` (`prescription_id`, `transcription_id`, `patient_id`, `patient_name`, `physician_id`, `physician_name`, `writer_id`, `writer_name`, `writer_type`, `create_date`, `content`) VALUES
(1, 1, 1, 'john doe', 1, 'milk xue', 1, 'milk xue', 'PHYSICIAN', '2015-03-31', ''),
(2, 2, 1, 'john doe', 1, 'milk xue', 1, 'Kasi Periyasamy', 'MEDICAL_STAFF', '2015-03-31', '');

-- --------------------------------------------------------

--
-- 表的结构 `relation_physician_department`
--

CREATE TABLE IF NOT EXISTS `relation_physician_department` (
  `relation_id` int(11) NOT NULL AUTO_INCREMENT,
  `physician_id` int(11) NOT NULL,
  `physician_name` text NOT NULL,
  `department_id` int(11) NOT NULL,
  `department_name` text NOT NULL,
  PRIMARY KEY (`relation_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `relation_physician_department`
--

INSERT INTO `relation_physician_department` (`relation_id`, `physician_id`, `physician_name`, `department_id`, `department_name`) VALUES
(1, 1, 'milk', 1, 'Burn_Center'),
(2, 31, 'zane', 1, 'Burn_Center'),
(6, 11, 'lee', 1, 'Burn_Center'),
(10, 19, 'goodman', 1, 'Burn_Center'),
(9, 20, 'hebe', 1, 'Burn_Center');

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
(1, 1, 'milk xue', 1, 'john doe', 'male', '1991-10-12', 'PRIMARY_CARE', 1, 'milk xue', '11', '2015-02-09', '2015-02-10'),
(2, 1, 'milk xue', 2, 'lee xin', 'male', '1991-10-13', 'TEMPORARY_CARE', 2, 'kobe', '11', '2015-02-16', '2015-03-26'),
(3, 2, 'kobe', 2, 'lee xin', 'male', '1991-10-13', 'PRIMARY_CARE', 2, 'kobe', '11', '2015-02-16', '2015-02-17'),
(4, 1, 'milk xue', 3, 'smith wang', 'male', '1995-03-03', 'PRIMARY_CARE', 1, 'milk xue', '11', '2015-02-17', '2015-02-20'),
(5, 2, 'kobe', 1, 'john doe', 'male', '1991-10-12', 'TEMPORARY_CARE', 1, 'milk xue', '11', '2015-02-09', '2015-02-10'),
(6, 3, 'amy', 1, 'john doe', 'male', '1991-10-12', 'TEMPORARY_CARE', 1, 'milk xue', '11', '2015-02-09', '2015-02-10');

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
(1, 1, 4, 'Abacavir Sulfate (Ziagen)', '123'),
(2, 2, 4, 'Abacavir Sulfate (Ziagen)', '123');

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
(1, 1, 11, 'Abdominoplasty (Tummy Tuck ( Abdominoplasty))'),
(2, 2, 11, 'Abdominoplasty (Tummy Tuck ( Abdominoplasty))');

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
(1, 7, 1, 'Amputation');

-- --------------------------------------------------------

--
-- 表的结构 `relation_transcription_treatment`
--

CREATE TABLE IF NOT EXISTS `relation_transcription_treatment` (
  `relation_id` int(11) NOT NULL AUTO_INCREMENT,
  `transcription_id` int(11) NOT NULL,
  `treatment_id` int(11) NOT NULL,
  `treatment_name` varchar(128) NOT NULL,
  `treatment_operator_id` int(11) NOT NULL,
  `treatment_operator_name` varchar(128) NOT NULL,
  `treatment_operator_type` varchar(128) NOT NULL,
  PRIMARY KEY (`relation_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `relation_transcription_treatment`
--

INSERT INTO `relation_transcription_treatment` (`relation_id`, `transcription_id`, `treatment_id`, `treatment_name`, `treatment_operator_id`, `treatment_operator_name`, `treatment_operator_type`) VALUES
(1, 1, 4, 'ONLY CAN BE DONE BY PHYSICIAN', 1, 'milk xue', 'PHYSICIAN');

-- --------------------------------------------------------

--
-- 表的结构 `surgery`
--

CREATE TABLE IF NOT EXISTS `surgery` (
  `surgery_id` int(11) NOT NULL AUTO_INCREMENT,
  `surgery_name` varchar(128) NOT NULL,
  `cost` int(11) NOT NULL,
  PRIMARY KEY (`surgery_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- 转存表中的数据 `surgery`
--

INSERT INTO `surgery` (`surgery_id`, `surgery_name`, `cost`) VALUES
(1, 'Hand Surgery', 1000),
(2, 'head and Neck Surgery', 0),
(3, 'Hernia Surgery', 0),
(4, 'Neurosurgery', 0),
(5, 'Orthopedic Surgery', 0),
(6, 'Ophthalmological Surgery', 0),
(7, 'Amputation', 121),
(8, 'Appendectomy', 0),
(9, 'Blepharoplasty', 0),
(10, 'Hysterectomy', 0),
(11, 'testSurgery1', 200);

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
  `content` varchar(4096) NOT NULL,
  `physician_id` int(11) NOT NULL,
  `physician_name` varchar(128) NOT NULL,
  `writer_id` int(11) NOT NULL,
  `writer_name` varchar(128) NOT NULL,
  `writer_type` varchar(128) NOT NULL,
  `create_date` date NOT NULL,
  PRIMARY KEY (`transcription_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `transcription`
--

INSERT INTO `transcription` (`transcription_id`, `emr_id`, `patient_id`, `patient_name`, `abstraction`, `content`, `physician_id`, `physician_name`, `writer_id`, `writer_name`, `writer_type`, `create_date`) VALUES
(1, 13, 1, 'john doe', '', '', 1, 'milk xue', 1, 'milk xue', 'PHYSICIAN', '2015-03-31'),
(2, 13, 1, 'john doe', '123', '123', 1, 'milk xue', 1, 'Kasi Periyasamy', 'MEDICAL_STAFF', '2015-03-31');

-- --------------------------------------------------------

--
-- 表的结构 `treatment`
--

CREATE TABLE IF NOT EXISTS `treatment` (
  `treatment_id` int(11) NOT NULL AUTO_INCREMENT,
  `treatment_name` varchar(128) NOT NULL,
  `treatment_price` varchar(128) NOT NULL,
  `can_medical_staff` varchar(16) NOT NULL,
  PRIMARY KEY (`treatment_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- 转存表中的数据 `treatment`
--

INSERT INTO `treatment` (`treatment_id`, `treatment_name`, `treatment_price`, `can_medical_staff`) VALUES
(1, 'clean wound', '12', 'yes'),
(2, 'put needle', '12', 'yes'),
(3, 'check blood pressure', '124', 'yes'),
(4, 'ONLY CAN BE DONE BY PHYSICIAN', '123', 'no');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
