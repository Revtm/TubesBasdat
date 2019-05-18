-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 16, 2019 at 12:30 PM
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
-- Database: `asrama_v3`
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

--
-- Dumping data for table `Admin`
--

INSERT INTO `Admin` (`id_admin`, `nama`, `email`, `no_telp`) VALUES
('AD201870001', 'Budi Setiawan', 'budi@asrama.itera.ac.id', '081369245071'),
('AD201870002', 'Nabila Salsabila', 'nabila@asrama.itera.ac.id', '085324807160');

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `id_akun` varchar(11) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`id_akun`, `password`) VALUES
('AD201870001', 'A123123\r'),
('AD201870002', 'A123123\r'),
('JR118200015', 'J123123\r'),
('JR118200016', 'J123123\r'),
('JR118210002', 'J123123\r'),
('JR118220010', 'J123123\r'),
('JR118230025', 'J123123\r'),
('JR118240026', 'J123123\r'),
('JR118240031', 'J123123\r'),
('JR118240060', 'J123123\r'),
('JR118250032', 'J123123\r'),
('JR118250033', 'J123123\r'),
('JR118250034', 'J123123\r'),
('JR118250035', 'J123123\r'),
('SR121170001', 'S123123\r'),
('SR121170007', 'S123123\r'),
('SR131170008', 'S123123\r'),
('SR141170009', 'S123123\r'),
('SR141171201', 'S123123\r'),
('SR211170801', 'S123123\r'),
('SR221170101', 'S123123\r'),
('SR221171100', 'S123123\r');

-- --------------------------------------------------------

--
-- Table structure for table `belajar`
--

CREATE TABLE `belajar` (
  `id_jr` varchar(11) NOT NULL,
  `id_tutor` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `belajar`
--

INSERT INTO `belajar` (`id_jr`, `id_tutor`) VALUES
('JR118200015', 'TM_01'),
('JR118200016', 'TM_02'),
('JR118210002', 'TM_01'),
('JR118220010', 'TM_02'),
('JR118230025', 'TM_01'),
('JR118240026', 'TM_02'),
('JR118240031', 'TM_01'),
('JR118240060', 'TM_02'),
('JR118250032', 'TM_01'),
('JR118250033', 'TM_02'),
('JR118250034', 'TM_01'),
('JR118250035', 'TM_02'),
('JR118200015', 'TF_01'),
('JR118200016', 'TF_02'),
('JR118210002', 'TF_01'),
('JR118220010', 'TF_02'),
('JR118230025', 'TF_01'),
('JR118240026', 'TF_02'),
('JR118240031', 'TF_01'),
('JR118240060', 'TF_02'),
('JR118250032', 'TF_01'),
('JR118250033', 'TF_02'),
('JR118250034', 'TF_01'),
('JR118250035', 'TF_02'),
('JR118200015', 'TK_01'),
('JR118200016', 'TK_02'),
('JR118210002', 'TK_01'),
('JR118220010', 'TK_02'),
('JR118230025', 'TK_01'),
('JR118240026', 'TK_02'),
('JR118240031', 'TK_01'),
('JR118240060', 'TK_02'),
('JR118250032', 'TK_01'),
('JR118250033', 'TK_02'),
('JR118250034', 'TK_01'),
('JR118250035', 'TK_02'),
('JR118200015', 'TB_01'),
('JR118200016', 'TB_02'),
('JR118210002', 'TB_01'),
('JR118220010', 'TB_02'),
('JR118230025', 'TB_01'),
('JR118240026', 'TB_02'),
('JR118240031', 'TB_01'),
('JR118240060', 'TB_02'),
('JR118250032', 'TB_01'),
('JR118250033', 'TB_02'),
('JR118250034', 'TB_01'),
('JR118250035', 'TB_02');

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

--
-- Dumping data for table `katering`
--

INSERT INTO `katering` (`id_katering`, `nama`, `no_telp`, `alamat`) VALUES
('K01', 'Katering Bu De Wayan', '81134745676', 'Jl. Airan 1'),
('K02', 'Katering Ujung Kulon', '82377881465', 'Jl. Wayhuwi');

-- --------------------------------------------------------

--
-- Table structure for table `kelastutor`
--

CREATE TABLE `kelastutor` (
  `id_kelas` varchar(5) NOT NULL,
  `matakuliah` varchar(20) DEFAULT NULL,
  `jadwal` varchar(20) DEFAULT NULL,
  `id_sr_tutor` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kelastutor`
--

INSERT INTO `kelastutor` (`id_kelas`, `matakuliah`, `jadwal`, `id_sr_tutor`) VALUES
('TB_01', 'Biologi', 'Kamis, 19.00-20.30', 'SR141170009'),
('TB_02', 'Biologi', 'Rabu, 19.00-20.30', 'SR221170101'),
('TF_01', 'Fisika Dasar', 'Selasa, 19.00-20.30', 'SR121170007'),
('TF_02', 'Fisika Dasar', 'Senin, 19.00-20.30', 'SR211170801'),
('TK_01', 'Kimia Dasar', 'Rabu, 19.00-20.30', 'SR131170008'),
('TK_02', 'Kimia Dasar', 'Selasa, 19.00-20.30', 'SR221171100'),
('TM_01', 'Kalkulus', 'Senin, 19.00-20.30', 'SR121170001'),
('TM_02', 'Kalkulus', 'Jumat,19.00-20.30', 'SR141171201');

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

--
-- Dumping data for table `paket`
--

INSERT INTO `paket` (`id_paket`, `nama`, `harga`, `id_katering`) VALUES
('P11', 'Paket Sehat', 1000000, 'K01'),
('P12', 'Paket Hemat', 700000, 'K01'),
('P21', 'Paket Kenyang', 900000, 'K02'),
('P22', 'Paket Super', 1250000, 'K02');

-- --------------------------------------------------------

--
-- Table structure for table `Penghuni_Asrama`
--

CREATE TABLE `Penghuni_Asrama` (
  `id_penghuni` varchar(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `Jenis_kelamin` char(1) NOT NULL,
  `no_telp` varchar(12) NOT NULL,
  `no_ruangan` varchar(4) NOT NULL,
  `email` varchar(50) NOT NULL,
  `prov` varchar(20) NOT NULL,
  `kota` varchar(20) NOT NULL,
  `jalan` varchar(100) NOT NULL,
  `id_paket` varchar(3) DEFAULT NULL,
  `id_sr_pembina` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Penghuni_Asrama`
--

INSERT INTO `Penghuni_Asrama` (`id_penghuni`, `nama`, `tgl_lahir`, `Jenis_kelamin`, `no_telp`, `no_ruangan`, `email`, `prov`, `kota`, `jalan`, `id_paket`, `id_sr_pembina`) VALUES
('JR118200015', 'Reza Rahadiyan', '2000-12-21', 'L', '85369237098', 'A201', 'JR118200015@asrama.itera.ac.id', 'Sumatera Barat', 'Padang', 'Jl. Timun', 'P11', 'SR121170001'),
('JR118200016', 'Alexia Adri	', '1999-12-08', 'P', '85369211098', 'B201', 'JR118200016@asrama.itera.ac.id', 'Lampung', 'Metro', 'Jl. Ikan Berwarna', 'P12', 'SR121170007'),
('JR118210002', 'Budi Hidayat', '2000-05-23', 'L', '85369237298', 'A201', 'JR118210002@asrama.itera.ac.id', 'Banten', 'Tanggerang', 'Jl. Meteorit', 'P12', 'SR131170008'),
('JR118220010', 'Sunarto Uzumaki', '2000-01-27', 'L', '85369237048', 'A202', 'JR118220010@asrama.itera.ac.id', 'DKI Jakarta', 'Jakarta', 'Jl. Ninja', 'P21', 'SR141170009'),
('JR118230025', 'Yucup  Rizaldo', '1999-11-02', 'L', '85369237492', 'A202', 'JR118230025@asrama.itera.ac.id', 'Jawa Tengah', 'Semarang', 'Jl. Kuyaja', 'P22', 'SR141171201'),
('JR118240026', 'Riani ', '2000-08-18', 'P', '85369227098', 'B201', 'JR118240026@asrama.itera.ac.id', 'Jawa Barat', 'Depok', 'Jl. Macet', 'P12', 'SR211170801'),
('JR118240031', 'Tini', '2001-01-09', 'P', '85369237093', 'B202', 'JR118240031@asrama.itera.ac.id', 'Jambi', 'Jambi', 'Jl. Raden', 'P21', 'SR221171100'),
('JR118240060', 'Putri', '2000-12-12', 'P', '85369234088', 'B202', 'JR118240060@asrama.itera.ac.id', 'Bali', 'Denpasar', 'Jl. Sambung-Menyambung', 'P22', 'SR221170101'),
('JR118250032', 'Mario Kartono', '1999-10-07', 'L', '85169234088', 'A203', 'JR118250032@asrama.itera.ac.id', 'Lampung', 'Kotabumi', 'Jl. Salak', 'P12', 'SR121170001'),
('JR118250033', 'Rio Pradana', '2000-03-24', 'L', '85369234087', 'A203', 'JR118250033@asrama.itera.ac.id', 'Sumatera Barat', 'Bukit Tinggi', 'Jl. Pahlawan', 'P22', 'SR131170008'),
('JR118250034', 'Shinta Agustina', '1999-09-21', 'P', '85369234388', 'B203', 'JR118250034@asrama.itera.ac.id', 'Jawa Tengah', 'Kebumen', 'Jl. Lurus', 'P11', 'SR121170007'),
('JR118250035', 'Cantika Berliana', '2000-06-12', 'P', '85369234090', 'B203', 'JR118250035@asrama.itera.ac.id', 'Jawa Barat', 'Bogor', 'Jl. Rambutan', 'P22', 'SR211170801'),
('SR121170001', 'Arif Bijaksana', '2000-12-21', 'L', '085369237098', 'A101', 'arif@asrama.itera.ac.id', 'Sumatera Barat', 'Padang', 'Jl. Ryacuda', 'P11', NULL),
('SR121170007', 'Wanda Forevah', '1999-12-08', 'P', '085369211098', 'B101', 'wanda@asrama.itera.ac.id', 'Lampung', 'Metro', 'Jl. Ikan Bawel', 'P12', NULL),
('SR131170008', 'Koko Hidayat', '2000-05-23', 'L', '085369237298', 'A102', 'koko@asrama.itera.ac.id', 'Banten', 'Tanggerang', 'Jl. Planet Lain', 'P12', NULL),
('SR141170009', 'Narto Uzumaki', '2000-01-27', 'L', '085369237048', 'A103', 'narto@asrama.itera.ac.id', 'DKI Jakarta', 'Jakarta', 'Jl. Nin Aja', 'P21', NULL),
('SR141171201', 'Ucup  Rizaldy', '1999-11-02', 'L', '085369237492', 'A104', 'ucup@asrama.itera.ac.id', 'Jawa Tengah', 'Semarang', 'Jl. Terbaiq', 'P22', NULL),
('SR211170801', 'Riana Arigato', '2000-08-18', 'P', '085369227098', 'B102', 'riana@asrama.itera.ac.id', 'Jawa Barat', 'Depok', 'Jl. Macet', 'P12', NULL),
('SR221170101', 'Ruchika Saskeh', '2000-11-11', 'P', '085369234088', 'B104', 'ruchika@asrama.itera.ac.id', 'Bali', 'Denpasar', 'Jl. Sambung-Menyambung', 'P22', NULL),
('SR221171100', 'Andini Harutono', '2001-01-09', 'P', '085369237093', 'B103', 'andini@asrama.itera.ac.id', 'Jambi', 'Jambi', 'Jl. Raden', 'P21', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_penyakit_Penghuni`
--

CREATE TABLE `riwayat_penyakit_Penghuni` (
  `id` varchar(11) NOT NULL,
  `penyakit` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `riwayat_penyakit_Penghuni`
--

INSERT INTO `riwayat_penyakit_Penghuni` (`id`, `penyakit`) VALUES
('JR118200015', 'Asma'),
('JR118200015', 'Migrain'),
('JR118250035', 'Tifus'),
('JR118240060', 'Darah Rendah'),
('JR118200015', 'Asma'),
('JR118200015', 'Migrain'),
('JR118250035', 'Tifus'),
('JR118240060', 'Darah Rendah');

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE `ruangan` (
  `no_ruangan` varchar(4) NOT NULL,
  `gedung` varchar(1) NOT NULL,
  `lorong` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruangan`
--

INSERT INTO `ruangan` (`no_ruangan`, `gedung`, `lorong`) VALUES
('A101', 'A', '1'),
('A102', 'A', '1'),
('A103', 'A', '1'),
('A104', 'A', '1'),
('A201', 'A', '2'),
('A202', 'A', '2'),
('A203', 'A', '2'),
('B101', 'B', '1'),
('B102', 'B', '1'),
('B103', 'B', '1'),
('B104', 'B', '1'),
('B201', 'B', '2'),
('B202', 'B', '2'),
('B203', 'B', '2');

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
-- Indexes for table `belajar`
--
ALTER TABLE `belajar`
  ADD KEY `id_jr` (`id_jr`),
  ADD KEY `id_tutor` (`id_tutor`);

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
  ADD KEY `id_sr` (`id_sr_tutor`);

--
-- Indexes for table `paket`
--
ALTER TABLE `paket`
  ADD PRIMARY KEY (`id_paket`),
  ADD KEY `id_katering` (`id_katering`);

--
-- Indexes for table `Penghuni_Asrama`
--
ALTER TABLE `Penghuni_Asrama`
  ADD PRIMARY KEY (`id_penghuni`),
  ADD KEY `id_sr` (`id_sr_pembina`),
  ADD KEY `no_ruangan` (`no_ruangan`),
  ADD KEY `id_paket` (`id_paket`);

--
-- Indexes for table `riwayat_penyakit_Penghuni`
--
ALTER TABLE `riwayat_penyakit_Penghuni`
  ADD KEY `id` (`id`);

--
-- Indexes for table `ruangan`
--
ALTER TABLE `ruangan`
  ADD PRIMARY KEY (`no_ruangan`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Admin`
--
ALTER TABLE `Admin`
  ADD CONSTRAINT `Admin_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `akun` (`id_akun`);

--
-- Constraints for table `belajar`
--
ALTER TABLE `belajar`
  ADD CONSTRAINT `belajar_ibfk_1` FOREIGN KEY (`id_jr`) REFERENCES `Penghuni_Asrama` (`id_penghuni`),
  ADD CONSTRAINT `belajar_ibfk_2` FOREIGN KEY (`id_tutor`) REFERENCES `kelastutor` (`id_kelas`);

--
-- Constraints for table `kelastutor`
--
ALTER TABLE `kelastutor`
  ADD CONSTRAINT `kelastutor_ibfk_1` FOREIGN KEY (`id_sr_tutor`) REFERENCES `Penghuni_Asrama` (`id_penghuni`);

--
-- Constraints for table `paket`
--
ALTER TABLE `paket`
  ADD CONSTRAINT `paket_ibfk_1` FOREIGN KEY (`id_katering`) REFERENCES `katering` (`id_katering`);

--
-- Constraints for table `Penghuni_Asrama`
--
ALTER TABLE `Penghuni_Asrama`
  ADD CONSTRAINT `Penghuni_Asrama_ibfk_1` FOREIGN KEY (`id_penghuni`) REFERENCES `akun` (`id_akun`),
  ADD CONSTRAINT `Penghuni_Asrama_ibfk_6` FOREIGN KEY (`id_sr_pembina`) REFERENCES `Penghuni_Asrama` (`id_penghuni`),
  ADD CONSTRAINT `Penghuni_Asrama_ibfk_7` FOREIGN KEY (`no_ruangan`) REFERENCES `ruangan` (`no_ruangan`),
  ADD CONSTRAINT `Penghuni_Asrama_ibfk_8` FOREIGN KEY (`id_paket`) REFERENCES `paket` (`id_paket`);

--
-- Constraints for table `riwayat_penyakit_Penghuni`
--
ALTER TABLE `riwayat_penyakit_Penghuni`
  ADD CONSTRAINT `riwayat_penyakit_Penghuni_ibfk_1` FOREIGN KEY (`id`) REFERENCES `Penghuni_Asrama` (`id_penghuni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
