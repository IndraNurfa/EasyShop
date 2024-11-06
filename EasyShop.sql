-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2020 at 07:53 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `EasyShop`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_admin`
--

CREATE TABLE `data_admin` (
  `username` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_admin`
--

INSERT INTO `data_admin` (`username`, `nama`, `email`) VALUES
('admin', 'admin', 'admin@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `data_user`
--

CREATE TABLE `data_user` (
  `username` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_user`
--

INSERT INTO `data_user` (`username`, `nama`, `email`) VALUES
('user', 'user', 'user'),
('Indra', 'Ahmad Indra', 'indra@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `level` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`, `level`) VALUES
('admin', 'admin', 'admin'),
('Indra', '123', 'user'),
('user', '123', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `makanan`
--

CREATE TABLE `makanan` (
  `id` varchar(10) NOT NULL,
  `merek` varchar(20) NOT NULL,
  `tipe` varchar(50) NOT NULL,
  `berat` int(11) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `makanan`
--

INSERT INTO `makanan` (`id`, `merek`, `tipe`, `berat`, `harga`) VALUES
('002', 'Lays', 'Rasa Rumput Laut', 300, 3000),
('asd', 'Chitato', 'BBQ', 500, 3000),
('Qaz', 'Qtella', 'Singkong', 250, 3000),
('qwe', 'Chitato', 'Keju', 500, 4000);

-- --------------------------------------------------------

--
-- Table structure for table `minuman`
--

CREATE TABLE `minuman` (
  `id` varchar(10) NOT NULL,
  `merek` varchar(20) NOT NULL,
  `tipe` varchar(50) NOT NULL,
  `berat` int(11) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `minuman`
--

INSERT INTO `minuman` (`id`, `merek`, `tipe`, `berat`, `harga`) VALUES
('001', 'Aqua', 'Botol', 250, 4000),
('Fnt001', 'Fanta', 'Rasa Strawberry', 500, 2000),
('GD001', 'Goodday', 'Cappucino', 250, 3000),
('LMnr', 'Le Mineral', 'Botol', 500, 2000);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_detail`
--

CREATE TABLE `transaksi_detail` (
  `id` int(11) NOT NULL,
  `merek` varchar(20) NOT NULL,
  `tipe` varchar(50) NOT NULL,
  `berat` int(11) NOT NULL,
  `banyak` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi_detail`
--

INSERT INTO `transaksi_detail` (`id`, `merek`, `tipe`, `berat`, `banyak`, `total_harga`) VALUES
(9, 'Aqua', 'Botol', 250, 1, 2500),
(9, 'Le Mineral', 'Botol', 250, 2, 16000),
(10, 'Aqua', 'Botol', 500, 1, 4000),
(10, 'Le Mineral', 'Botol', 500, 2, 8000),
(11, 'Aqua', 'Botol', 250, 1, 2500),
(11, 'Le Mineral', 'Botol', 500, 1, 2000),
(12, 'Lays', 'Rasa Keju', 250, 1, 2500),
(12, 'Lays', 'Rasa Rumput Laut', 500, 1, 4000),
(13, 'Aqua', 'Botol', 250, 1, 2500),
(13, 'Le Mineral', 'Botol', 250, 2, 16000),
(14, 'Aqua', 'Botol', 250, 1, 2500),
(14, 'Le Mineral', 'Botol', 500, 1, 2000),
(15, 'Aqua', 'Botol', 250, 1, 4000),
(15, 'Le Mineral', 'Botol', 500, 3, 18000),
(16, 'Lays', 'Rasa Keju', 250, 3, 22500),
(16, 'Lays', 'Rasa Rumput Laut', 500, 2, 12000),
(17, 'Lays', 'Rasa Keju', 250, 1, 4000),
(17, 'Lays', 'Rasa Rumput Laut', 500, 3, 18000),
(17, 'Chitato', 'BBQ', 500, 2, 12000),
(18, 'Aqua', 'Botol', 300, 2, 12000),
(18, 'Fanta', 'Rasa Strawberry', 250, 1, 3000),
(18, 'Goodday', 'Cappucino', 250, 3, 36000),
(19, 'Aqua', 'Botol', 300, 1, 3000),
(19, 'Fanta', 'Rasa Strawberry', 250, 2, 12000),
(19, 'Goodday', 'Cappucino', 250, 1, 4000),
(19, 'Le Mineral', 'Botol', 250, 2, 12000);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_master`
--

CREATE TABLE `transaksi_master` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `total_harga` int(11) NOT NULL,
  `waktu` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi_master`
--

INSERT INTO `transaksi_master` (`id`, `username`, `total_harga`, `waktu`) VALUES
(9, 'user', 10500, '2020-12-20 09:25:10'),
(10, 'user', 8000, '2020-12-20 10:51:18'),
(11, 'user', 4500, '2020-12-20 10:53:02'),
(12, 'user', 6500, '2020-12-20 10:53:51'),
(13, 'user', 10500, '2020-12-20 11:00:14'),
(14, 'user', 4500, '2020-12-20 11:05:50'),
(15, 'user', 10000, '2020-12-21 10:47:55'),
(16, 'user', 13500, '2020-12-21 11:02:00'),
(17, 'user', 16000, '2020-12-21 11:26:53'),
(19, 'Indra', 19000, '2020-12-23 13:34:32');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_admin`
--
ALTER TABLE `data_admin`
  ADD KEY `Cons_Admin` (`username`);

--
-- Indexes for table `data_user`
--
ALTER TABLE `data_user`
  ADD KEY `Cons_username` (`username`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `makanan`
--
ALTER TABLE `makanan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `minuman`
--
ALTER TABLE `minuman`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaksi_master`
--
ALTER TABLE `transaksi_master`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transaksi_master`
--
ALTER TABLE `transaksi_master`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `data_admin`
--
ALTER TABLE `data_admin`
  ADD CONSTRAINT `Cons_Admin` FOREIGN KEY (`username`) REFERENCES `login` (`username`) ON DELETE CASCADE;

--
-- Constraints for table `data_user`
--
ALTER TABLE `data_user`
  ADD CONSTRAINT `Cons_username` FOREIGN KEY (`username`) REFERENCES `login` (`username`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
