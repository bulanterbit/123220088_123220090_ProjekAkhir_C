-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2024 at 12:03 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `toserba_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL,
  `nama_barang` varchar(255) DEFAULT NULL,
  `harga_barang` int(11) DEFAULT NULL,
  `jumlah_stok` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `harga_barang`, `jumlah_stok`) VALUES
(1000, 'Susu Indomilk', 20000, 50),
(1001, 'Kopi Kapal Api', 50000, 100),
(1002, 'Mie Instan Indomie', 3000, 200),
(1003, 'Minyak Goreng Bimoli', 14000, 70),
(1004, 'Beras Rojolele', 60000, 30),
(1005, 'Teh Botol Sosro', 4000, 150),
(1006, 'Sabun Lifebuoy', 2500, 96),
(1007, 'Shampoo Clear', 28000, 80),
(1008, 'Oreo', 10000, 118),
(1009, 'Aqua', 4000, 200),
(1010, 'Gula Pasir Gulaku', 12000, 90),
(1011, 'Susu Kental Manis Frisian Flag', 10000, 110),
(1012, 'Kecap Manis ABC', 7000, 85),
(1013, 'Sari Roti', 12000, 60),
(1015, 'Pasta Gigi Pepsodent', 12000, 95),
(1016, 'Tissue Paseo', 15000, 75),
(1017, 'Kopi Good Day', 8000, 140),
(1018, 'Coklat SilverQueen', 15000, 50),
(1019, 'Deterjen Rinso', 18000, 70),
(2000, 'ultra disk', 20000, 30),
(2001, 'Makaroni susu', 12000, 90);

-- --------------------------------------------------------

--
-- Table structure for table `detail_pembelian`
--

CREATE TABLE `detail_pembelian` (
  `id_pembelian` varchar(11) NOT NULL,
  `nama_barang` varchar(255) NOT NULL,
  `jumlah_beli` int(8) NOT NULL,
  `harga_barang` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_pembelian`
--

INSERT INTO `detail_pembelian` (`id_pembelian`, `nama_barang`, `jumlah_beli`, `harga_barang`) VALUES
('1', 'Shampoo Clear', 3, 84000),
('12', 'Oreo', 3, 30000),
('12', 'Shampoo Clear', 3, 84000),
('12', 'Shampoo Clear', 3, 84000),
('12', 'Susu Kental Manis Frisian Flag', 3, 30000),
('100', 'Shampoo Clear', 12, 336000),
('10', 'Sari Roti', 10, 120000),
('6', 'Susu Kental Manis Frisian Flag', 2, 20000),
('3', 'Aqua', 4, 16000),
('19', 'Gula Pasir Gulaku', 5, 60000),
('15', 'Oreo', 2, 20000),
('56', 'Aqua', 10, 40000),
('56', 'Aqua', 10, 40000),
('34', 'Kecap Manis ABC', 3, 21000),
('23', 'Sari Roti', 3, 36000),
('1', 'Aqua', 2, 8000),
('22', 'Oreo', 2, 20000),
('11', 'Sabun Lifebuoy', 4, 10000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2002;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
