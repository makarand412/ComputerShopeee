-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 24, 2019 at 12:38 PM
-- Server version: 5.7.23-0ubuntu0.16.04.1
-- PHP Version: 7.0.4-7ubuntu2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `OnlineComputerShopee`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminid` int(11) NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminid`, `username`, `password`) VALUES
(1, 'govind@gmail.com', '-599a5ba6dfbdd062be81b7981023b0475fb5e0c000e05f8166717908085d851d');

-- --------------------------------------------------------

--
-- Table structure for table `carts`
--

CREATE TABLE `carts` (
  `cartid` int(11) NOT NULL,
  `productid` int(11) DEFAULT NULL,
  `customerid` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `carts`
--

INSERT INTO `carts` (`cartid`, `productid`, `customerid`, `quantity`) VALUES
(10, 6, 29, 3),
(13, 2, 32, 2),
(14, 7, 32, 4);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customerid` int(11) NOT NULL,
  `customername` text NOT NULL,
  `customerusername` text NOT NULL,
  `customerpassword` text NOT NULL,
  `customeraddress` text NOT NULL,
  `customercontact` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customerid`, `customername`, `customerusername`, `customerpassword`, `customeraddress`, `customercontact`) VALUES
(1, 'Govind', 'govind@gmail.com', '123', 'baner', '3214569870'),
(28, 'govind parve', 'govindp@gmail.com', '-72dc30937917cb585591212ab3d931d44d18b6fcac739e422a2de6866854d08e', 'Address [street=baner road, area=baner, city=pune, pincode=405045]', '45613297871'),
(29, 'govinda parve ', 'govindpp@gmail.com', '-4c571f1e0654e401c5c90dce098908744cf5ae62d4de193acf3f1117144b5a30', 'baner road, baner, pune, 405045', '7896541230'),
(30, 'raj', 'raj@gmail.com', '-4c571f1e0654e401c5c90dce098908744cf5ae62d4de193acf3f1117144b5a30', 'baner, road, pune, 450005', '8965741235'),
(31, 'vishal', 'vishal@gmail.com', '35a9e381b1a27567549b5f8a6f783c167ebf809f1c4d6a9e367240484d8ce281', 'jm_rd, shivaji_nr, pune, 1245454', '2563147895'),
(32, 'Parve', 'parve@gmail.com', '-7b01179d2a27be54551e842fe6853629bead83d17830167cd5fa21614ce52ce7', 'baner_road# baner# pune# 411045', '6932587145'),
(33, 'ram', 'ram@gmail.com', '-599a5ba6dfbdd062be81b7981023b0475fb5e0c000e05f8166717908085d851d', 'baner_road# baner# pune# 411045', '9988775645'),
(34, 'sham', 'sham@gmail.com', '-599a5ba6dfbdd062be81b7981023b0475fb5e0c000e05f8166717908085d851d', 'br# ba# pun# 123456', '6547891336');

-- --------------------------------------------------------

--
-- Table structure for table `orderdetails`
--

CREATE TABLE `orderdetails` (
  `orderid` int(11) DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderdetails`
--

INSERT INTO `orderdetails` (`orderid`, `productid`, `quantity`) VALUES
(12599, 5, 2),
(12599, 4, 2);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL,
  `customerid` int(11) DEFAULT NULL,
  `shippingaddress` text,
  `orderdate` text,
  `totalbill` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`orderid`, `customerid`, `shippingaddress`, `orderdate`, `totalbill`) VALUES
(1403, 31, 'baner', 'Sun Apr 21 17:08:44 IST 2019', 10000),
(3592, 28, 'BANER', 'Sun Apr 21 16:39:46 IST 2019', 4200),
(5251, 29, 'PUN$E', 'Wed Apr 17 10:01:02 IST 2019', 30000),
(6699, 30, 'AUNDH', 'Sun Apr 21 16:41:31 IST 2019', 103000),
(8186, 29, 'PUN$E', 'Tue Apr 16 13:34:33 IST 2019', 30000),
(8208, 29, 'PUN$E', 'Wed Apr 17 10:02:16 IST 2019', 0),
(8885, 29, 'PUN$E', 'Wed Apr 17 09:51:11 IST 2019', 30000),
(12599, 28, 'dattanager,pune', 'Sun Apr 21 17:13:32 IST 2019', 14000);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `productid` int(11) NOT NULL,
  `productname` text NOT NULL,
  `productprice` double NOT NULL,
  `productcategory` text NOT NULL,
  `productdescription` text NOT NULL,
  `productfeatures` text NOT NULL,
  `productbrand` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`productid`, `productname`, `productprice`, `productcategory`, `productdescription`, `productfeatures`, `productbrand`) VALUES
(1, 'yxz', 500, 'a', 'xyz', 'xyz', 'gp'),
(2, 'AAA', 10000, 'A', 'AA', 'AAA', 'AAAA'),
(3, 'Product1', 2000, 'P1', 'PP1', 'PPP', 'PP'),
(4, 'Product2', 3000, 'P2', 'PP2', 'PPP2', 'PP2'),
(5, 'P3', 4000, 'PP3', 'PPP3', 'PPP3', 'PP3'),
(6, 'product6', 600, 'p6', 'ppp', 'pp', 'p6'),
(7, 'product7', 7000, 'P7', 'PP7', 'PPP', 'p'),
(9, 'product8', 8000, 'a', 'product888', 'pro888', 'a');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminid`);

--
-- Indexes for table `carts`
--
ALTER TABLE `carts`
  ADD PRIMARY KEY (`cartid`),
  ADD KEY `productid` (`productid`),
  ADD KEY `customerid` (`customerid`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customerid`);

--
-- Indexes for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD KEY `orderid` (`orderid`),
  ADD KEY `productid` (`productid`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderid`),
  ADD KEY `customerid` (`customerid`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`productid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `carts`
--
ALTER TABLE `carts`
  MODIFY `cartid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `customerid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `orderid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12600;
--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `productid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `carts`
--
ALTER TABLE `carts`
  ADD CONSTRAINT `carts_ibfk_1` FOREIGN KEY (`productid`) REFERENCES `products` (`productid`),
  ADD CONSTRAINT `carts_ibfk_2` FOREIGN KEY (`customerid`) REFERENCES `customers` (`customerid`);

--
-- Constraints for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD CONSTRAINT `orderdetails_ibfk_1` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`),
  ADD CONSTRAINT `orderdetails_ibfk_2` FOREIGN KEY (`productid`) REFERENCES `products` (`productid`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customerid`) REFERENCES `customers` (`customerid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
