-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2025 at 06:41 PM
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
  `BirthDate` date DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `CreatedAt` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`CustomerID`, `FullName`, `BirthDate`, `Phone`, `Email`, `Address`, `CreatedAt`) VALUES
(1, 'Nguyễn Văn A', '2000-01-01', '0123456789', 'a@example.com', 'Hà Nội', '2025-05-04 22:50:02'),
(2, 'Trần Thị B', '1995-03-15', '0911222333', 'tranb@example.com', 'Đà Nẵng', '2025-05-04 23:33:55'),
(3, 'Lê Văn C', '1988-07-20', '0988777666', 'levanc@example.com', 'Hồ Chí Minh', '2025-05-04 23:33:55'),
(4, 'Phạm Thị D', '1992-11-05', '0901234567', 'phamtd@example.com', 'Hải Phòng', '2025-05-04 23:33:55'),
(5, 'Hoàng Văn E', '1990-06-30', '0933456789', 'hoange@example.com', 'Cần Thơ', '2025-05-04 23:33:55'),
(6, 'Ngô Thị F', '1999-09-10', '0977654321', 'ngotf@example.com', 'Huế', '2025-05-04 23:33:55');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `EmployeeID` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`EmployeeID`, `Username`, `Password`, `Phone`) VALUES
(1, 'hiu', '123123123', '1231231231'),
(2, 'h', '123123123', '1234567890');

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
  `Date` date DEFAULT curdate()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`ProductID`, `ProductName`, `Type`, `Brand`, `Stock`, `Status`, `Prices`, `Date`) VALUES
(21321, 'Iphone 16', 'Ios', 'Apple', 12, 'Còn Hàng', 20102002.00, '2025-05-04'),
(21322, 'xiaomi haha hihi', 'Android', 'Xiaomi', 15, 'Còn Hàng', 12312312.00, '2025-05-04'),
(21323, 'RealOne 1 plus haha', 'Android', 'Realme', 150, 'Còn Hàng', 21323222.00, '2025-05-04'),
(21324, 'sadasd', 'Ios', 'Apple', 1, 'Còn Hàng', 23113.00, '2025-05-04'),
(21325, 'ádasda', 'Android', 'Huawei', 0, 'Hết Hàng', 212312312.00, '2025-05-04'),
(21326, 'dsads', 'Ios', 'Apple', 0, 'Hết Hàng', 2123.00, '2025-05-04'),
(21327, 'asssss', 'Ios', 'Apple', 12, 'Còn Hàng', 2123.00, '2025-05-04'),
(21328, 'dfdd', 'Ios', 'Apple', 12, 'Còn Hàng', 232323.00, '2025-05-04'),
(21330, 'ddáda', 'Ios', 'Apple', 12, 'Còn Hàng', 232323.00, '2025-05-04');

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
  `Prices` decimal(15,2) NOT NULL,
  `TotalPrices` decimal(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `salesinvoicedetails`
--

INSERT INTO `salesinvoicedetails` (`DetailID`, `InvoiceID`, `ProductID`, `Quantity`, `Prices`, `TotalPrices`) VALUES
(1, 1, 21327, 1, 2123.00, 2123.00),
(2, 1, 21328, 1, 232323.00, 232323.00),
(3, 2, 21330, 1, 232323.00, 232323.00),
(4, 3, 21321, 1, 20102002.00, 20102002.00),
(5, 4, 21322, 2, 12312312.00, 24624624.00),
(6, 5, 21323, 1, 21323222.00, 21323222.00),
(7, 6, 21324, 3, 23113.00, 69339.00),
(8, 7, 21327, 2, 2123.00, 4246.00);

-- --------------------------------------------------------

--
-- Table structure for table `salesinvoices`
--

CREATE TABLE `salesinvoices` (
  `InvoiceID` int(11) NOT NULL,
  `CustomerID` int(11) DEFAULT NULL,
  `EmployeeID` int(11) DEFAULT NULL,
  `TotalAmount` decimal(15,2) DEFAULT 0.00,
  `SaleDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `salesinvoices`
--

INSERT INTO `salesinvoices` (`InvoiceID`, `CustomerID`, `EmployeeID`, `TotalAmount`, `SaleDate`) VALUES
(1, 1, 1, 234446.00, '2025-05-03 14:30:00'),
(2, 1, 1, 232323.00, '2025-05-04 09:00:00'),
(3, 2, 1, 4500000.00, '2025-05-04 10:30:00'),
(4, 3, 1, 9123000.00, '2025-05-04 11:15:00'),
(5, 4, 1, 15400000.00, '2025-05-04 12:00:00'),
(6, 5, 1, 3230000.00, '2025-05-04 13:30:00'),
(7, 6, 1, 7878000.00, '2025-05-04 15:45:00');

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
  MODIFY `CustomerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `EmployeeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `ProductID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21331;

--
-- AUTO_INCREMENT for table `salesinvoicedetails`
--
ALTER TABLE `salesinvoicedetails`
  MODIFY `DetailID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `salesinvoices`
--
ALTER TABLE `salesinvoices`
  MODIFY `InvoiceID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

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
