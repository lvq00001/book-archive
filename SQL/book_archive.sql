-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 03, 2022 at 10:23 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `book_archive`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
CREATE TABLE IF NOT EXISTS `books` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Author` varchar(30) NOT NULL,
  `Title` varchar(255) NOT NULL,
  `Year` int(4) NOT NULL,
  `Publisher` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Publisher` (`Publisher`)
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`ID`, `Author`, `Title`, `Year`, `Publisher`, `image`) VALUES
(9, 'John C. Shovic', 'Python All-In-One For Dummies', 2021, 4, 'Python All-In-One For Dummies.jpg'),
(11, 'Amuthan Ganeshan', 'Spring MVC Beginners Guide', 2016, 2, 'Spring MVC Beginners Guide.jpg'),
(12, 'Andrew Stellman', 'Head First C#_ A Learner\'s Guide to Real-World Programming with C# and .NET Core', 2021, 3, 'Head First C#_ A Learner\'s Guide to Real-World Programming with C# and .NET Core.jpg'),
(13, 'Jeff Friesen', 'Java I_O, NIO and NIO.2', 2015, 1, 'Java I_O, NIO and NIO.2.jpg'),
(14, 'Greg L. Turnquist', 'Learning Spring Boot', 2014, 2, 'Learning Spring Boot.jpg'),
(15, 'Josephine Bush', 'Learn SQL Database Programming_ Query and manipulate databases from popular relational database servers using SQL', 2020, 2, 'Learn SQL Database Programming_ Query and manipulate databases from popular relational database servers using SQL.jpg'),
(16, 'Eric T. Freeman', 'Head First JavaScript Programming_ A Brain-Friendly Guide', 2014, 3, 'Head First JavaScript Programming_ A Brain-Friendly Guide.jpg'),
(1007, 'a', 'b', 2012, 4, 'a'),
(1009, 'a', 'b', 2000, 1, 'c'),
(1010, 'abc', 'java', 2020, 4, 'java.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `book_user`
--

DROP TABLE IF EXISTS `book_user`;
CREATE TABLE IF NOT EXISTS `book_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) DEFAULT NULL,
  `user_password` char(60) DEFAULT NULL,
  `user_role` char(5) NOT NULL DEFAULT 'USER',
  `enabled` int(11) DEFAULT '1',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book_user`
--

INSERT INTO `book_user` (`ID`, `username`, `user_password`, `user_role`, `enabled`) VALUES
(1, 'lvq', '$2a$12$u14r/HI1cFuwMk1kXqoaru.kRpFjsoskfkYjU0h9/ahjys7fGoBJu', 'USER', 1),
(2, 'hcm', '$2a$10$R/G/yR19hyaPRbaNsk/QFee42PsIybF42r/pwqw7/aq7HjF0PU0Wy', 'USER', 1),
(11, 'abcde', '$2a$10$eIp3BRmfNlaNnGTPl0J.6eXU6qbhoMYH3/XXNJws8MlpDG.3JPCtW', 'USER', 1);

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
CREATE TABLE IF NOT EXISTS `publisher` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `publisher` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `publisher`
--

INSERT INTO `publisher` (`ID`, `publisher`) VALUES
(1, 'Apress'),
(2, 'Packt Publishing'),
(3, 'O\'Reilly Media'),
(4, 'John Wiley & Son, Inc');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `books`
--
ALTER TABLE `books`
  ADD CONSTRAINT `books_ibfk_1` FOREIGN KEY (`Publisher`) REFERENCES `publisher` (`ID`) ON DELETE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
