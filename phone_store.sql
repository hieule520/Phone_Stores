-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2025 at 03:09 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phone_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `CustomerID` int(11) NOT NULL,
  `FullName` varchar(100) NOT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp(),
  `Gender` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`CustomerID`, `FullName`, `Phone`, `Email`, `CreateDate`, `Gender`) VALUES
(1, 'Trần Hạnh Hương', '0878886423', 'huong@gmail.com', '2025-05-06 02:57:18', 'Nữ');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `EmployeeID` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `JoinDate` date DEFAULT curdate(),
  `Address` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`EmployeeID`, `Username`, `Password`, `Phone`, `Email`, `JoinDate`, `Address`) VALUES
(9, 'a', '123123123', '0878985119', 'hiu@gmail.com', '2025-05-05', '36');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `ProductID` int(11) NOT NULL,
  `ProductName` varchar(255) NOT NULL,
  `Type` varchar(100) DEFAULT NULL,
  `Brand` varchar(100) DEFAULT NULL,
  `Stock` int(11) DEFAULT 0,
  `Status` varchar(255) DEFAULT NULL,
  `Prices` decimal(14,2) NOT NULL,
  `Date` date DEFAULT curdate(),
  `Image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`ProductID`, `ProductName`, `Type`, `Brand`, `Stock`, `Status`, `Prices`, `Date`, `Image`) VALUES
(1, 'iphone 6', 'Ios', 'Iphone', 123, 'Còn Hàng', 4200000.00, '2025-05-03', 'C:\\Users\\HELIOS 300\\OneDrive\\ドキュメント\\GitHub\\Web_ban_game\\admin\\assets\\icon\\MT3H.png'),
(2, 'realme neo 4', 'Android', 'Realme', 123, 'Còn Hàng', 1350000.00, '2025-05-04', 'C:\\Users\\HELIOS 300\\OneDrive\\ドキュメント\\GitHub\\Web_ban_game\\admin\\assets\\icon\\MT3H.png');

-- --------------------------------------------------------

--
-- Table structure for table `purchaseinvoicedetails`
--

CREATE TABLE `purchaseinvoicedetails` (
  `DetailID` int(11) NOT NULL,
  `PurchaseID` int(11) DEFAULT NULL,
  `ProductID` int(11) DEFAULT NULL,
  `Quantity` int(11) NOT NULL,
  `UnitPrice` decimal(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `purchaseinvoices`
--

CREATE TABLE `purchaseinvoices` (
  `PurchaseID` int(11) NOT NULL,
  `SupplierID` int(11) DEFAULT NULL,
  `EmployeeID` int(11) DEFAULT NULL,
  `PurchaseDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `salesinvoicedetails`
--

CREATE TABLE `salesinvoicedetails` (
  `DetailID` int(11) NOT NULL,
  `InvoiceID` int(11) DEFAULT NULL,
  `ProductID` int(11) DEFAULT NULL,
  `Quantity` int(11) NOT NULL,
  `UnitPrice` decimal(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `salesinvoices`
--

CREATE TABLE `salesinvoices` (
  `InvoiceID` int(11) NOT NULL,
  `CustomerID` int(11) DEFAULT NULL,
  `EmployeeID` int(11) DEFAULT NULL,
  `SaleDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `SupplierID` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`EmployeeID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ProductID`);

--
-- Indexes for table `purchaseinvoicedetails`
--
ALTER TABLE `purchaseinvoicedetails`
  ADD PRIMARY KEY (`DetailID`),
  ADD KEY `PurchaseID` (`PurchaseID`),
  ADD KEY `ProductID` (`ProductID`);

--
-- Indexes for table `purchaseinvoices`
--
ALTER TABLE `purchaseinvoices`
  ADD PRIMARY KEY (`PurchaseID`),
  ADD KEY `SupplierID` (`SupplierID`),
  ADD KEY `EmployeeID` (`EmployeeID`);

--
-- Indexes for table `salesinvoicedetails`
--
ALTER TABLE `salesinvoicedetails`
  ADD PRIMARY KEY (`DetailID`),
  ADD KEY `InvoiceID` (`InvoiceID`),
  ADD KEY `ProductID` (`ProductID`);

--
-- Indexes for table `salesinvoices`
--
ALTER TABLE `salesinvoices`
  ADD PRIMARY KEY (`InvoiceID`),
  ADD KEY `CustomerID` (`CustomerID`),
  ADD KEY `EmployeeID` (`EmployeeID`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`SupplierID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `CustomerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `EmployeeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `ProductID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21313;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `purchaseinvoicedetails`
--
ALTER TABLE `purchaseinvoicedetails`
  ADD CONSTRAINT `fk_purchaseinvoicedetails_product` FOREIGN KEY (`ProductID`) REFERENCES `products` (`ProductID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_purchaseinvoicedetails_purchase` FOREIGN KEY (`PurchaseID`) REFERENCES `purchaseinvoices` (`PurchaseID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `purchaseinvoices`
--
ALTER TABLE `purchaseinvoices`
  ADD CONSTRAINT `fk_purchaseinvoices_employee` FOREIGN KEY (`EmployeeID`) REFERENCES `employees` (`EmployeeID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_purchaseinvoices_supplier` FOREIGN KEY (`SupplierID`) REFERENCES `suppliers` (`SupplierID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `salesinvoicedetails`
--
ALTER TABLE `salesinvoicedetails`
  ADD CONSTRAINT `fk_salesinvoicedetails_invoice` FOREIGN KEY (`InvoiceID`) REFERENCES `salesinvoices` (`InvoiceID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_salesinvoicedetails_product` FOREIGN KEY (`ProductID`) REFERENCES `products` (`ProductID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `salesinvoices`
--
ALTER TABLE `salesinvoices`
  ADD CONSTRAINT `fk_salesinvoices_customer` FOREIGN KEY (`CustomerID`) REFERENCES `customers` (`CustomerID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_salesinvoices_employee` FOREIGN KEY (`EmployeeID`) REFERENCES `employees` (`EmployeeID`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
