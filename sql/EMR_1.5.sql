-- phpMyAdmin SQL Dump
-- version 4.0.10.2
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2015-04-25 22:47:13
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
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_account` (`admin_account`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_account`, `admin_password`) VALUES
(1, 'admin', '123'),
(2, 'kasi', 'kasi'),
(4, 'EMR_Admin', '123'),
(6, 'administrator', '123456');

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
(1, 'Burn Center'),
(2, 'Acute Assessment Unit'),
(3, 'Central Sterile Services'),
(4, 'Coronary Care Unit'),
(5, 'Emergency Department'),
(6, 'Geriatric Intensive-care Unit'),
(7, 'Intensive Care Unit'),
(8, 'Medical Records Department'),
(9, 'Neonatal Intensive Care Unit'),
(10, 'On-call Room'),
(11, 'Operating Room'),
(12, 'Pediatric Intensive Care Unit'),
(13, 'Hospital Pharmacy'),
(14, 'Physical Therapy'),
(15, 'Post-anesthesia Care Unit'),
(16, 'Psychiatric Hospital'),
(17, 'Release of Information'),
(18, 'Hospital Warehouse');

-- --------------------------------------------------------

--
-- 表的结构 `diagnostic_test`
--

CREATE TABLE IF NOT EXISTS `diagnostic_test` (
  `diagnostic_test_id` int(11) NOT NULL AUTO_INCREMENT,
  `diagnostic_test_name` varchar(128) NOT NULL,
  `cost` double NOT NULL,
  PRIMARY KEY (`diagnostic_test_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=92 ;

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
  `pharmacy_drug_id` varchar(128) DEFAULT NULL,
  `drug_name` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`drug_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=65 ;

--
-- 转存表中的数据 `drug`
--

INSERT INTO `drug` (`drug_id`, `pharmacy_drug_id`, `drug_name`) VALUES
(9, '62ea5ad6-2c0f-42af-a880-719ae4f63ed3', 'Aripiprazole_ABILIFY'),
(8, '1f9e4558-a483-4825-a3d7-26e487fce263', 'some otc drug_one otc drug'),
(7, 'f433da5e-e312-40fb-b891-a403e46f53b9', 'Dilaudid-hp_Hydromorphone'),
(6, 'c202990e-4b98-4176-a639-5dbf5b7d9a2e', 'Mapap_Acetaminophen'),
(5, 'b3847f7c-1e0e-42de-aa48-a39bd05e08fe', 'Tempra_Acetaminophen'),
(4, '933a4607-167a-41c2-860c-bcac796ac649', 'Panadol_Acetaminophen'),
(3, '7777f5db-547e-425f-acad-53cef470477d', 'Dilaudid_Hydromorphone'),
(2, '4cb92d84-b497-4b23-9be5-cc19ae5e2c1a', 'Palladone_Hydromorphone'),
(1, '097a9215-ee07-451f-8ef1-dd66704b1c01', 'Exalgo_Hydromorphone');

-- --------------------------------------------------------

--
-- 表的结构 `drug_from_pharmacy`
--

CREATE TABLE IF NOT EXISTS `drug_from_pharmacy` (
  `drug_id` int(11) NOT NULL AUTO_INCREMENT,
  `drug_unique_id` text,
  `drug_type` text,
  `drug_name_medical` text,
  `drug_name_commercial` text,
  `drug_price` text,
  `drug_lv` text,
  `drug_unit` text,
  `drug_dose` text,
  `drug_description` text,
  `drug_common_uses` text,
  `drug_usage` text,
  `drug_cautions` text,
  `drug_side_effects` text,
  `drug_status` text,
  PRIMARY KEY (`drug_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- 转存表中的数据 `drug_from_pharmacy`
--

INSERT INTO `drug_from_pharmacy` (`drug_id`, `drug_unique_id`, `drug_type`, `drug_name_medical`, `drug_name_commercial`, `drug_price`, `drug_lv`, `drug_unit`, `drug_dose`, `drug_description`, `drug_common_uses`, `drug_usage`, `drug_cautions`, `drug_side_effects`, `drug_status`) VALUES
(1, '097a9215-ee07-451f-8ef1-dd66704b1c01', 'Prescription drug', 'Hydromorphone', 'Exalgo', '10.0', '1', 'MG/ML', '50', NULL, NULL, '', NULL, NULL, 'Enable'),
(2, '4cb92d84-b497-4b23-9be5-cc19ae5e2c1a', 'Prescription drug', 'Hydromorphone', 'Palladone', '10.0', '1', 'MG/ML', '50', NULL, NULL, NULL, NULL, NULL, 'Enable'),
(3, '7777f5db-547e-425f-acad-53cef470477d', 'Prescription drug', 'Hydromorphone', 'Dilaudid', '10.0', '1', 'MG/ML', '50', NULL, NULL, NULL, NULL, NULL, 'Enable'),
(4, '933a4607-167a-41c2-860c-bcac796ac649', 'Prescription drug', 'Acetaminophen', 'Panadol', '9.0', '1', 'MG', '120', NULL, NULL, NULL, NULL, NULL, 'Enable'),
(5, 'b3847f7c-1e0e-42de-aa48-a39bd05e08fe', 'Prescription drug', 'Acetaminophen', 'Tempra', '9.0', '1', 'MG', '125', NULL, NULL, NULL, NULL, NULL, 'Enable'),
(6, 'c202990e-4b98-4176-a639-5dbf5b7d9a2e', 'Prescription drug', 'Acetaminophen', 'Mapap', '9.0', '1', 'MG', '130', NULL, NULL, NULL, NULL, NULL, 'Enable'),
(7, 'f433da5e-e312-40fb-b891-a403e46f53b9', 'Prescription drug', 'Hydromorphone', 'Dilaudid-hp', '10.0', '1', 'MG/ML', '50', NULL, NULL, NULL, NULL, NULL, 'Enable'),
(8, '1f9e4558-a483-4825-a3d7-26e487fce263', 'OTC drug', 'one otc drug', 'some otc drug', '20.0', '0', 'MG', '50', NULL, NULL, 'some usage', NULL, NULL, 'Enable'),
(9, '62ea5ad6-2c0f-42af-a880-719ae4f63ed3', 'Prescription drug', 'ABILIFY', 'Aripiprazole', '12.0', '1', 'MG', '5', NULL, NULL, '1', NULL, NULL, 'Enable');

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
-- 表的结构 `log_admin`
--

CREATE TABLE IF NOT EXISTS `log_admin` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(256) NOT NULL,
  `table_name` varchar(128) NOT NULL,
  `action` varchar(256) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `log_admin`
--

INSERT INTO `log_admin` (`log_id`, `admin_name`, `table_name`, `action`, `date`) VALUES
(1, 'admin', 'Diagnostic Test', 'ADD', '2015-02-11 10:10:00'),
(2, 'admin', 'Treatment', 'ADD', '2015-02-13 13:24:31'),
(3, 'EMR_Admin', 'Surgery', 'ADD', '2015-02-20 07:39:17'),
(4, 'admin', 'Diagnostic Test', 'DEL', '2015-02-24 16:21:41'),
(5, 'EMR_Admin', 'Surgery', 'UPD', '2015-02-20 16:13:28'),
(6, 'administrator', 'Drug', 'GET', '2015-02-18 10:45:34'),
(7, 'admin', 'Diagnostic Test', 'DEL', '2015-04-25 20:45:29'),
(8, 'admin', 'Diagnostic Test', 'DEL', '2015-04-25 20:50:14'),
(9, 'admin', 'Surgery', 'ADD', '2015-04-25 20:58:44'),
(10, 'admin', 'Drug', 'GET', '2015-04-25 21:09:22');

-- --------------------------------------------------------

--
-- 表的结构 `medical_staff`
--

CREATE TABLE IF NOT EXISTS `medical_staff` (
  `msid` int(11) NOT NULL,
  `ms_name` varchar(128) NOT NULL,
  `ms_account` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  `physician_id` int(11) NOT NULL,
  `physician_name` varchar(128) NOT NULL,
  `SSN` varchar(128) NOT NULL,
  PRIMARY KEY (`msid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `medical_staff`
--

INSERT INTO `medical_staff` (`msid`, `ms_name`, `ms_account`, `password`, `physician_id`, `physician_name`, `SSN`) VALUES
(1, 'Kasi Periyasamy', 'Kasi Periyasamy', 'kasi', 1, 'milk xue', ''),
(3, 'kobe wang', 'kobe wang', 'kobe', 1, 'milk xue', '112'),
(2, 'robin li', 'robin li', 'robin', 1, 'milk xue', '123');

-- --------------------------------------------------------

--
-- 表的结构 `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `patient_id` int(11) NOT NULL,
  `patient_name` varchar(128) NOT NULL,
  `patient_gender` varchar(64) NOT NULL,
  `patient_age` int(64) NOT NULL,
  `patient_birthday` date NOT NULL,
  `SSN` varchar(128) NOT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `patient`
--

INSERT INTO `patient` (`patient_id`, `patient_name`, `patient_gender`, `patient_age`, `patient_birthday`, `SSN`) VALUES
(1, 'john doe', 'male', 18, '1970-03-23', ''),
(2, 'lee xin', 'male', 19, '2015-02-02', '5785460982'),
(3, 'smith wang', 'male', 0, '1995-03-03', ''),
(4, 'bryan butter', 'male', 26, '1990-03-04', ''),
(5, 'lee xin', 'male', 19, '2012-11-07', '192567865'),
(6, 'lee xin', 'male', 19, '2015-02-01', '189786543'),
(19, 'patient name from admin', 'male', 24, '1991-06-02', '123123'),
(20, 'patient name from admin', 'male', 24, '1991-06-02', '123123'),
(111, 'Tom Cat', 'male', 24, '1991-06-02', '1111111111'),
(123, 'Tom Cat', 'male', 24, '1991-06-02', '1111111111');

-- --------------------------------------------------------

--
-- 表的结构 `physician`
--

CREATE TABLE IF NOT EXISTS `physician` (
  `physician_id` int(11) NOT NULL,
  `physician_name` varchar(128) NOT NULL,
  `physician_gender` varchar(64) NOT NULL,
  `physician_birthday` date NOT NULL,
  `account` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  `SSN` varchar(128) NOT NULL,
  `specialty` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`physician_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `physician`
--

INSERT INTO `physician` (`physician_id`, `physician_name`, `physician_gender`, `physician_birthday`, `account`, `password`, `SSN`, `specialty`) VALUES
(1, 'milk xue', 'male', '1991-06-02', 'milk xue', 'milk', '', 'Anesthesiologist'),
(2, 'kobe biter', 'male', '1991-11-03', 'kobe', 'kobe', '', 'Anesthesiologist'),
(3, 'amy matteds', 'female', '1991-11-03', '123', 'amy', '', 'Cardiothoracic anesthesiology'),
(4, 'allen', 'male', '1991-11-03', '123', 'allen', '', 'Cardiothoracic anesthesiology'),
(5, 'Bob tigger', 'male', '1991-11-15', 'bob', '123', '', 'Emergency medicine'),
(6, 'lily', 'female', '1991-11-04', 'lily', '123', '', 'Emergency medicine'),
(7, 'tracy', 'female', '1993-11-04', 'tracy', '123', '', 'General surgery'),
(8, 'jack', 'male', '1993-11-04', 'jack', '123', '', 'General surgery'),
(9, 'jason', 'male', '1993-11-04', 'jason', '123', '', 'Internal medicine'),
(10, 'alvin', 'male', '1993-11-04', 'alvin', '123', '', 'Medical genetics'),
(11, 'lee', 'male', '1993-11-04', 'lee', '123', '', 'Neurosociology'),
(12, 'wellson', 'male', '1995-11-04', 'wellson', '123', '', 'Obstetrics and gynaecology'),
(13, 'neo', 'male', '1995-11-04', 'neo', '123', '', 'Orthopedic surgery'),
(14, 'tyler', 'male', '1992-11-04', 'tyler', '123', '', 'Pediatrics'),
(15, 'calvin', 'male', '1992-11-04', 'calvin', '123', '', 'Radiation therapy'),
(16, 'dogge', 'male', '1992-11-04', 'dogge', '123', '', 'Radiology'),
(17, 'edison', 'male', '1992-11-04', 'edison', '123', '', 'Urology'),
(18, 'frank', 'male', '1992-11-04', 'frank', '123', '', 'Plastic surgery'),
(19, 'goodman', 'male', '1992-11-04', 'goodman', '123', '', 'Preventive healthcare'),
(20, 'hebe', 'female', '1993-11-04', 'hebe', '123', '', 'Ophthalmology'),
(21, 'ibby', 'female', '1993-11-04', 'ibby', '123', '', 'Neurosurgery'),
(22, 'obama', 'male', '1995-11-04', 'obama', '123', '', 'Orthopedic surgery'),
(23, 'petter', 'male', '1995-11-04', 'petter', '123', '', 'Preventive healthcare'),
(24, 'queen', 'female', '1993-11-04', 'queen', '123', '', 'Preventive healthcare'),
(25, 'rose', 'female', '1995-11-04', 'rose', '123', '', 'Medical genetics'),
(26, 'sarah', 'female', '1994-11-04', 'sarah', '123', '', 'Medical genetics'),
(27, 'uliana', 'female', '1992-11-04', 'uliana', '123', '', 'Radiology'),
(28, 'vicky', 'female', '1992-11-04', 'vicky', '123', '', 'Radiology'),
(29, 'xu', 'male', '1990-11-04', 'xu', '123', '', 'Cardiothoracic anesthesiology'),
(30, 'yuliy', 'male', '1990-11-04', 'yuliy', '123', '', 'Cardiothoracic anesthesiology'),
(31, 'zane', 'male', '1990-11-04', 'zane', '123', '', 'Internal medicine'),
(64, 'physician name from admin', 'male', '1991-06-02', 'account for physician to login EMR component', 'password for physician to login EMR component', '123', '123'),
(65, 'physician name from admin', 'male', '1991-06-02', 'account for physician to login EMR component', 'password for physician to login EMR component', '123', '123'),
(67, 'physician name from admin', 'male', '1991-06-02', 'account for physician to login EMR component', 'password for physician to login EMR component', '123', '123'),
(68, 'physician name from admin', 'male', '1991-06-02', 'account for physician to login EMR component', 'password for physician to login EMR component', '123', '123');

-- --------------------------------------------------------

--
-- 表的结构 `prescription`
--

CREATE TABLE IF NOT EXISTS `prescription` (
  `prescription_id` int(11) NOT NULL AUTO_INCREMENT,
  `transcription_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `patient_name` varchar(128) NOT NULL,
  `patient_ssn` varchar(128) DEFAULT NULL,
  `physician_id` int(11) NOT NULL,
  `physician_name` varchar(128) NOT NULL,
  `physician_ssn` varchar(128) DEFAULT NULL,
  `writer_id` int(11) NOT NULL,
  `writer_name` varchar(128) NOT NULL,
  `writer_ssn` varchar(128) DEFAULT NULL,
  `writer_type` varchar(128) NOT NULL,
  `create_date` date NOT NULL,
  `content` varchar(256) NOT NULL,
  PRIMARY KEY (`prescription_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- 转存表中的数据 `relation_physician_department`
--

INSERT INTO `relation_physician_department` (`relation_id`, `physician_id`, `physician_name`, `department_id`, `department_name`) VALUES
(1, 1, 'milk', 1, 'Burn Center'),
(2, 31, 'zane', 1, 'Burn Center'),
(6, 11, 'lee', 1, 'Burn Center'),
(12, 19, 'goodman', 1, 'Burn Center'),
(9, 20, 'hebe', 1, 'Burn Center');

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
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
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
  `drug_id` int(11) DEFAULT NULL,
  `drug_name_medical` varchar(128) NOT NULL,
  `drug_name_commercial` varchar(128) NOT NULL,
  `drug_unit` varchar(128) NOT NULL,
  `drug_dose` varchar(128) NOT NULL,
  `drug_price` varchar(128) NOT NULL,
  `amount` varchar(128) NOT NULL,
  PRIMARY KEY (`rpd_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- 转存表中的数据 `relation_prescription_drug`
--

INSERT INTO `relation_prescription_drug` (`rpd_id`, `prescription_id`, `drug_id`, `drug_name_medical`, `drug_name_commercial`, `drug_unit`, `drug_dose`, `drug_price`, `amount`) VALUES
(1, 2, 4, 'Abacavir Sulfate (Ziagen)', '', '', '', '', '123'),
(2, 3, 4, 'Abacavir Sulfate (Ziagen)', '', '', '', '', '123'),
(3, 4, 5, 'Abilify (Aripiprazole)', '', '', '', '', '12'),
(4, 4, 9, 'Baclofen (Kemstro)', '', '', '', '', '12'),
(5, 6, 4, 'Abacavir Sulfate (Ziagen)', '', '', '', '', '123'),
(6, 6, 10, 'Bacteriostatic Water (Bacteriostatic Water for Injection)', '', '', '', '', '123'),
(7, 9, 39, 'Dilaudid', '', '', '', '', '123'),
(8, 9, 36, 'Hydromorphone', '', '', '', '', '123'),
(9, 10, 39, 'Dilaudid', '', '', '', '', '123'),
(10, 11, 4, 'Panadol', '', '', '', '', '123'),
(11, 11, 1, 'Exalgo', '', '', '', '', '123'),
(12, 11, 1, 'Exalgo', '', '', '', '', '123'),
(13, 13, 7, 'Dilaudid-hp', '', '', '', '', '12'),
(14, 14, 3, 'Dilaudid', '', '', '', '', '12'),
(15, 14, 1, 'Exalgo', '', '', '', '', '12'),
(16, 17, 1, 'Exalgo', '', '', '', '', '12'),
(17, 27, 1, 'Acetaminophen', 'Panadol', '', '', '', '123'),
(18, 27, 1, 'Acetaminophen', 'Panadol', '', '', '', '12'),
(19, 27, 1, 'Hydromorphone', 'Palladone', '', '', '', '12'),
(20, 29, 1, 'Acetaminophen', 'Panadol', 'MG', '120', '9.0', '123'),
(21, 29, 1, 'ABILIFY', 'Aripiprazole', 'MG', '5', '12.0', '12'),
(22, 30, 1, 'ABILIFY', 'Aripiprazole', 'MG', '5', '12.0', '123');

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `security_check`
--

CREATE TABLE IF NOT EXISTS `security_check` (
  `psid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_title` varchar(128) NOT NULL,
  `question1` varchar(128) NOT NULL,
  `question2` varchar(128) NOT NULL,
  `question3` varchar(128) NOT NULL,
  `answer1` varchar(128) NOT NULL,
  `answer2` varchar(128) NOT NULL,
  `answer3` varchar(128) NOT NULL,
  PRIMARY KEY (`psid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `security_check`
--

INSERT INTO `security_check` (`psid`, `user_id`, `user_title`, `question1`, `question2`, `question3`, `answer1`, `answer2`, `answer3`) VALUES
(1, 1, 'PHYSICIAN', 'What''s your first pet''s name?', 'What''s your favorite game?', 'Who''s your favorite singer?', 'miaomi', 'miaomi', 'jay');

-- --------------------------------------------------------

--
-- 表的结构 `security_question`
--

CREATE TABLE IF NOT EXISTS `security_question` (
  `sq_id` int(11) NOT NULL AUTO_INCREMENT,
  `sq_name` text NOT NULL,
  `sq_step` int(11) NOT NULL,
  PRIMARY KEY (`sq_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `security_question`
--

INSERT INTO `security_question` (`sq_id`, `sq_name`, `sq_step`) VALUES
(1, 'Which year was your father born?', 1),
(2, 'What''s your first pet''s name?', 1),
(3, 'What''s your mother''s middle name?', 1),
(4, 'Who''s your favorite movie star?', 1),
(5, 'What''s your favorite game?', 2),
(6, 'What''s your first girlfriend/boyfriend''s last name?', 2),
(7, 'What''s your father''s favorite food?', 2),
(8, 'What''s your mother''s favorite drink?', 3),
(9, 'Where did you get your driver license?', 3),
(10, 'Who''s your favorite singer?', 3);

-- --------------------------------------------------------

--
-- 表的结构 `security_question_answer_account_relation`
--

CREATE TABLE IF NOT EXISTS `security_question_answer_account_relation` (
  `sq_relation_id` int(11) NOT NULL AUTO_INCREMENT,
  `sq_id` int(11) NOT NULL,
  `admin_account` text NOT NULL,
  `answer` text NOT NULL,
  PRIMARY KEY (`sq_relation_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=49 ;

--
-- 转存表中的数据 `security_question_answer_account_relation`
--

INSERT INTO `security_question_answer_account_relation` (`sq_relation_id`, `sq_id`, `admin_account`, `answer`) VALUES
(1, 1, 'admin', '1960'),
(2, 2, 'admin', 'Ryan'),
(3, 3, 'admin', 'Ann'),
(48, 8, 'EMR_Admin', 'tea'),
(47, 5, 'EMR_Admin', 'football'),
(46, 1, 'EMR_Admin', '1970'),
(45, 5, 'administrator', 'football'),
(44, 2, 'administrator', 'dog'),
(43, 2, 'administrator', 'dog');

-- --------------------------------------------------------

--
-- 表的结构 `surgery`
--

CREATE TABLE IF NOT EXISTS `surgery` (
  `surgery_id` int(11) NOT NULL AUTO_INCREMENT,
  `surgery_name` varchar(128) NOT NULL,
  `cost` double NOT NULL,
  PRIMARY KEY (`surgery_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- 转存表中的数据 `surgery`
--

INSERT INTO `surgery` (`surgery_id`, `surgery_name`, `cost`) VALUES
(1, 'Hand Surgery', 1000),
(2, 'head and Neck Surgery', 0),
(3, 'Hernia Surgery', 200),
(4, 'Neurosurgery', 0),
(5, 'Orthopedic Surgery', 12),
(6, 'Ophthalmological Surgery', 123.5),
(7, 'Amputation', 121),
(8, 'Appendectomy', 12.45),
(9, 'Blepharoplasty', 0),
(10, 'Hysterectomy', 0),
(20, 'tesdt1', 23);

-- --------------------------------------------------------

--
-- 表的结构 `transcription`
--

CREATE TABLE IF NOT EXISTS `transcription` (
  `transcription_id` int(11) NOT NULL AUTO_INCREMENT,
  `emr_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `patient_name` varchar(128) NOT NULL,
  `patient_ssn` varchar(128) DEFAULT NULL,
  `abstraction` varchar(128) NOT NULL,
  `content` varchar(4096) NOT NULL,
  `physician_id` int(11) NOT NULL,
  `physician_name` varchar(128) NOT NULL,
  `writer_id` int(11) NOT NULL,
  `writer_name` varchar(128) NOT NULL,
  `writer_type` varchar(128) NOT NULL,
  `create_date` date NOT NULL,
  PRIMARY KEY (`transcription_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `treatment`
--

CREATE TABLE IF NOT EXISTS `treatment` (
  `treatment_id` int(11) NOT NULL AUTO_INCREMENT,
  `treatment_name` varchar(128) NOT NULL,
  `treatment_price` double NOT NULL,
  `can_medical_staff` varchar(16) NOT NULL,
  PRIMARY KEY (`treatment_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- 转存表中的数据 `treatment`
--

INSERT INTO `treatment` (`treatment_id`, `treatment_name`, `treatment_price`, `can_medical_staff`) VALUES
(1, 'clean wound', 12.23, 'yes'),
(2, 'put needle', 0, 'yes'),
(3, 'check blood pressure', 0, 'yes'),
(4, 'ONLY CAN BE DONE BY PHYSICIAN', 0, 'no'),
(7, 'massage', 0, 'yes');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
