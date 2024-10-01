-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 23, 2024 at 07:18 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `ID` varchar(10) NOT NULL,
  `Title` varchar(100) NOT NULL,
  `Author` varchar(100) NOT NULL,
  `Genre` varchar(100) NOT NULL,
  `ISBN` varchar(13) NOT NULL,
  `Availability` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`ID`, `Title`, `Author`, `Genre`, `ISBN`, `Availability`) VALUES
('0', 'Art', 'saman', 'Art', '79', 'Yes'),
('200', 'sa', 'sa', 'sa', 'sa', 'No'),
('3', 'Science', 'sasi', 'Zoo', '09', 'Yes'),
('300', 'Scicence Story', 'sasika', 'Science Fiction', '78', 'Yes'),
('4', '4', '4', '4', '4', 'No'),
('66', 'Geography', 'heshan', 'Geography', '23', 'Yes'),
('B1', 'Networking', 'kamal', 'Sceiece finction', '1', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `borrowbook`
--

CREATE TABLE `borrowbook` (
  `ID` varchar(10) NOT NULL,
  `Title` varchar(100) NOT NULL,
  `BorrowerName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `borrowbook`
--

INSERT INTO `borrowbook` (`ID`, `Title`, `BorrowerName`) VALUES
('200', 'AI', 'vx'),
('4', '4', 'x');

-- --------------------------------------------------------

--
-- Table structure for table `borrowdvd`
--

CREATE TABLE `borrowdvd` (
  `ID` varchar(10) NOT NULL,
  `Title` varchar(100) NOT NULL,
  `BorrowerName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `borrowdvd`
--

INSERT INTO `borrowdvd` (`ID`, `Title`, `BorrowerName`) VALUES
('100', '100', 'c'),
('203', 'AI', 's');

-- --------------------------------------------------------

--
-- Table structure for table `customerregistration`
--

CREATE TABLE `customerregistration` (
  `First Name` varchar(100) NOT NULL,
  `Last Name` varchar(100) NOT NULL,
  `UserName` varchar(11) NOT NULL,
  `Password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customerregistration`
--

INSERT INTO `customerregistration` (`First Name`, `Last Name`, `UserName`, `Password`) VALUES
('customer1', 'customer1', 'cus123', '1234'),
('kamal', 'kamal', 'kamal', 'kamal'),
('kasuni', 'kasuni', 'kasuni123', '123'),
('sunil', 'sunil', 'sunil123', '123');

-- --------------------------------------------------------

--
-- Table structure for table `dvd`
--

CREATE TABLE `dvd` (
  `ID` varchar(10) NOT NULL,
  `Title` varchar(100) NOT NULL,
  `Director` varchar(100) NOT NULL,
  `Duration` varchar(20) NOT NULL,
  `Availability` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dvd`
--

INSERT INTO `dvd` (`ID`, `Title`, `Director`, `Duration`, `Availability`) VALUES
('123', 'Music', 'saman', '77', 'Yes'),
('203', 'AI', 'kamal', '78', 'No'),
('300', 'Machine Learning', 'kamal', '6', 'yes'),
('400', 'AI', 'saman', '9', 'yes'),
('500', '500', '500', '500', 'yes'),
('D1', 'Networking', 'saman', '9', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `returnbook`
--

CREATE TABLE `returnbook` (
  `ID` varchar(20) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `BorrowerName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `returnbook`
--

INSERT INTO `returnbook` (`ID`, `Title`, `BorrowerName`) VALUES
('2', 'AI', 'mala'),
('3', 'Science', 'z');

-- --------------------------------------------------------

--
-- Table structure for table `returndvd`
--

CREATE TABLE `returndvd` (
  `ID` varchar(20) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `BorrowerName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `returndvd`
--

INSERT INTO `returndvd` (`ID`, `Title`, `BorrowerName`) VALUES
('100', '100', 'saman'),
('D1', 'Networking', 'kamal'),
('203', 'AI', 'fxb'),
('123', 'Music', 'bf');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ID`(5));

--
-- Indexes for table `borrowbook`
--
ALTER TABLE `borrowbook`
  ADD PRIMARY KEY (`ID`(9));

--
-- Indexes for table `borrowdvd`
--
ALTER TABLE `borrowdvd`
  ADD PRIMARY KEY (`ID`(5));

--
-- Indexes for table `customerregistration`
--
ALTER TABLE `customerregistration`
  ADD PRIMARY KEY (`UserName`(5));

--
-- Indexes for table `dvd`
--
ALTER TABLE `dvd`
  ADD PRIMARY KEY (`ID`(5));
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
