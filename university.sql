-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 23, 2018 at 01:20 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `university`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `reg_no` bigint(20) NOT NULL,
  `class` varchar(30) NOT NULL,
  `section` varchar(20) NOT NULL,
  `contact` bigint(20) NOT NULL,
  `address` mediumtext NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `reg_no`, `class`, `section`, `contact`, `address`) VALUES
(1, 'Faseih', 131, 'BESE-6', 'B', 923004497022, 'Room 317'),
(2, 'Asfa', 132, 'BESE-6', 'B', 923004497021, 'Room 218'),
(3, 'Rafay', 133, 'BESE-6', 'A', 923004497020, 'Room 216'),
(4, 'Saad', 135, 'BEE-7', 'D', 923004497029, 'Room 205'),
(5, 'Ambreen', 136, 'BESE-6', 'B', 923004497026, 'Islamabad');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
