-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2021 at 10:45 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gb_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `ID` int(11) NOT NULL,
  `empId` varchar(45) NOT NULL,
  `empName` varchar(250) NOT NULL,
  `empSalary` varchar(20) NOT NULL,
  `department` varchar(150) NOT NULL,
  `project` varchar(450) NOT NULL,
  `skill` varchar(450) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`ID`, `empId`, `empName`, `empSalary`, `department`, `project`, `skill`) VALUES
(1, 'IT3500', 'Thahseen', '45000.0', 'IT', 'Web Application', 'Css,JS,Html'),
(2, 'E00091', 'Shajith', '75000.0', 'IT', 'Developing', 'Java'),
(4, '123', 'Shajith', '5000.0', 'dhudh', 'bee', 'java'),
(5, '12223', 'sqwqdW', '23344.0', 'assAD', 'DSADSa', 'efwqe'),
(6, 'e9089', 'Kumar', '68000.0', 'Developing', 'hgssg', 'java'),
(7, 'E0092', 'Sjakik', '234455.0', 'sdd', 'sss', 'ddd'),
(8, 'E009', 'Shaji', '124000.0', 'eee', 'eee', 'sssw'),
(9, 'ww', 'ww', '12.0', 'ww', 'qqq', 'www'),
(10, 'sss', 'aa', '123.0', 'dd', 'www', 'aa');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
