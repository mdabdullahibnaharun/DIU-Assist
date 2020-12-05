-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2020 at 05:17 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `diuassist_dbms`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `sl` int(250) NOT NULL,
  `id` varchar(100) NOT NULL,
  `batch` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `section` varchar(100) NOT NULL,
  `department` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`sl`, `id`, `batch`, `name`, `mobile`, `email`, `section`, `department`) VALUES
(1, '193-15-13426', '54', 'Md. Abdullah Ibna Harun', '01786287766', 'abdullah15-13426@diu.edu.bd', 'A', 'CSE'),
(2, '193-15-13416', '54', 'Md Mahfuzur Rahman', '01405145165', 'zumafu@diu.edu.bd', 'A', 'CSE'),
(3, '193-15-13355', '54', 'Mahade Hassan Forhad ', '01161616517', 'mahade15-13355@diu.edu.bd', 'A', 'CSE'),
(4, '193-15-13374', '54', 'Abidur Rahman Khan', '01755116165', 'abidur15-13374@diu.edu.bd', 'A', 'CSE');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `tslno` int(110) NOT NULL,
  `tid` varchar(100) NOT NULL,
  `tteacherinitial` varchar(200) NOT NULL,
  `tname` varchar(200) NOT NULL,
  `tmobile` varchar(200) NOT NULL,
  `temail` varchar(100) NOT NULL,
  `tcoursecode` varchar(20) NOT NULL,
  `tcoursename` varchar(200) NOT NULL,
  `tdepartment` varchar(200) NOT NULL,
  `tfaculty` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`tslno`, `tid`, `tteacherinitial`, `tname`, `tmobile`, `temail`, `tcoursecode`, `tcoursename`, `tdepartment`, `tfaculty`) VALUES
(1, '710001961', 'MJM', 'Mr. Md. Jueal Mia', '+8801911142859', 'jueal.cse@diu.edu.bd', 'CSE 113', 'Software Project 2', 'CSE', 'FSIT'),
(2, '700007222', 'SAH', 'Sayed Akhter Hosain', '+8801752223871', 'sah@diu.edu.bd', 'CSE 221', 'OOP', 'CSE', 'FSIT'),
(3, '1001664', 'SA', 'Sarmin Akhter', '+8801841565188', 'sa.cse@diu.edu.bd', 'END 111', 'Basic English', 'English', 'GED');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`sl`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`tslno`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
