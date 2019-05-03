-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 03, 2019 at 11:43 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `asrama`
--

-- --------------------------------------------------------

--
-- Table structure for table `Admin`
--

CREATE TABLE `Admin` (
  `id_admin` varchar(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL,
  `no_telp` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `id_akun` varchar(11) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `JR_Asrama`
--

CREATE TABLE `JR_Asrama` (
  `id_jr` varchar(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `no_telp` varchar(12) NOT NULL,
  `no_ruangan` varchar(4) NOT NULL,
  `email` varchar(50) NOT NULL,
  `prov` varchar(20) NOT NULL,
  `kota` varchar(20) NOT NULL,
  `jalan` varchar(100) NOT NULL,
  `riwayat_penyakit` varchar(120) DEFAULT NULL,
  `id_paket` varchar(3) DEFAULT NULL,
  `id_sr` varchar(11) NOT NULL,
  `id_kelas_m` varchar(5) NOT NULL,
  `id_kelas_f` varchar(5) NOT NULL,
  `id_kelas_k` varchar(5) NOT NULL,
  `id_kelas_b` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `katering`
--

CREATE TABLE `katering` (
  `id_katering` varchar(3) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `no_telp` varchar(25) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `kelastutor`
--

CREATE TABLE `kelastutor` (
  `id_kelas` varchar(5) NOT NULL,
  `matakuliah` varchar(20) DEFAULT NULL,
  `jadwal` varchar(20) DEFAULT NULL,
  `id_sr` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `paket`
--

CREATE TABLE `paket` (
  `id_paket` varchar(3) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `harga` int(6) NOT NULL,
  `id_katering` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE `ruangan` (
  `no_ruangan` varchar(4) NOT NULL,
  `gedung` varchar(1) NOT NULL,
  `lorong` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `SR_Asrama`
--

CREATE TABLE `SR_Asrama` (
  `id_sr` varchar(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `no_telp` varchar(12) NOT NULL,
  `no_ruangan` varchar(4) NOT NULL,
  `email` varchar(50) NOT NULL,
  `prov` varchar(20) NOT NULL,
  `kota` varchar(20) NOT NULL,
  `jalan` varchar(100) NOT NULL,
  `riwayat_penyakit` varchar(120) DEFAULT NULL,
  `id_paket` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Admin`
--
ALTER TABLE `Admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id_akun`);

--
-- Indexes for table `JR_Asrama`
--
ALTER TABLE `JR_Asrama`
  ADD PRIMARY KEY (`id_jr`),
  ADD KEY `id_kelas_m` (`id_kelas_m`),
  ADD KEY `id_kelas_f` (`id_kelas_f`),
  ADD KEY `id_kelas_k` (`id_kelas_k`),
  ADD KEY `id_kelas_b` (`id_kelas_b`),
  ADD KEY `id_sr` (`id_sr`),
  ADD KEY `no_ruangan` (`no_ruangan`),
  ADD KEY `id_paket` (`id_paket`);

--
-- Indexes for table `katering`
--
ALTER TABLE `katering`
  ADD PRIMARY KEY (`id_katering`);

--
-- Indexes for table `kelastutor`
--
ALTER TABLE `kelastutor`
  ADD PRIMARY KEY (`id_kelas`),
  ADD KEY `id_sr` (`id_sr`);

--
-- Indexes for table `paket`
--
ALTER TABLE `paket`
  ADD PRIMARY KEY (`id_paket`),
  ADD KEY `id_katering` (`id_katering`);

--
-- Indexes for table `ruangan`
--
ALTER TABLE `ruangan`
  ADD PRIMARY KEY (`no_ruangan`);

--
-- Indexes for table `SR_Asrama`
--
ALTER TABLE `SR_Asrama`
  ADD PRIMARY KEY (`id_sr`),
  ADD KEY `no_ruangan` (`no_ruangan`),
  ADD KEY `id_paket` (`id_paket`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Admin`
--
ALTER TABLE `Admin`
  ADD CONSTRAINT `Admin_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `akun` (`id_akun`);

--
-- Constraints for table `JR_Asrama`
--
ALTER TABLE `JR_Asrama`
  ADD CONSTRAINT `JR_Asrama_ibfk_1` FOREIGN KEY (`id_jr`) REFERENCES `akun` (`id_akun`),
  ADD CONSTRAINT `JR_Asrama_ibfk_2` FOREIGN KEY (`id_kelas_m`) REFERENCES `kelastutor` (`id_kelas`),
  ADD CONSTRAINT `JR_Asrama_ibfk_3` FOREIGN KEY (`id_kelas_f`) REFERENCES `kelastutor` (`id_kelas`),
  ADD CONSTRAINT `JR_Asrama_ibfk_4` FOREIGN KEY (`id_kelas_k`) REFERENCES `kelastutor` (`id_kelas`),
  ADD CONSTRAINT `JR_Asrama_ibfk_5` FOREIGN KEY (`id_kelas_b`) REFERENCES `kelastutor` (`id_kelas`),
  ADD CONSTRAINT `JR_Asrama_ibfk_6` FOREIGN KEY (`id_sr`) REFERENCES `SR_Asrama` (`id_sr`),
  ADD CONSTRAINT `JR_Asrama_ibfk_7` FOREIGN KEY (`no_ruangan`) REFERENCES `ruangan` (`no_ruangan`),
  ADD CONSTRAINT `JR_Asrama_ibfk_8` FOREIGN KEY (`id_paket`) REFERENCES `paket` (`id_paket`);

--
-- Constraints for table `kelastutor`
--
ALTER TABLE `kelastutor`
  ADD CONSTRAINT `kelastutor_ibfk_1` FOREIGN KEY (`id_sr`) REFERENCES `SR_Asrama` (`id_sr`);

--
-- Constraints for table `paket`
--
ALTER TABLE `paket`
  ADD CONSTRAINT `paket_ibfk_1` FOREIGN KEY (`id_katering`) REFERENCES `katering` (`id_katering`);

--
-- Constraints for table `SR_Asrama`
--
ALTER TABLE `SR_Asrama`
  ADD CONSTRAINT `SR_Asrama_ibfk_1` FOREIGN KEY (`id_sr`) REFERENCES `akun` (`id_akun`),
  ADD CONSTRAINT `SR_Asrama_ibfk_2` FOREIGN KEY (`no_ruangan`) REFERENCES `ruangan` (`no_ruangan`),
  ADD CONSTRAINT `SR_Asrama_ibfk_3` FOREIGN KEY (`id_paket`) REFERENCES `paket` (`id_paket`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
