-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 12 Des 2019 pada 14.00
-- Versi server: 10.3.16-MariaDB
-- Versi PHP: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistem_parkir`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `parkir_keluar`
--

CREATE TABLE `parkir_keluar` (
  `id_keluar` int(3) NOT NULL,
  `no_tiket` int(3) NOT NULL,
  `no_polisi` varchar(10) NOT NULL,
  `jenis_kendaraan` varchar(5) NOT NULL,
  `waktu_keluar` bigint(20) NOT NULL,
  `biaya` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `parkir_keluar`
--

INSERT INTO `parkir_keluar` (`id_keluar`, `no_tiket`, `no_polisi`, `jenis_kendaraan`, `waktu_keluar`, `biaya`) VALUES
(3, 19, 'W 1337 D', 'Motor', 1576074469948, 1500),
(4, 21, 'G THUN F', 'Mobil', 1576077049127, 3000),
(5, 20, 'D 234 Y', 'Mobil', 1576077169383, 3000),
(6, 22, 'B 123 RI', 'Mobil', 1576143725021, 35000),
(7, 25, 'TYT54', 'Motor', 1576151057245, 1500);

-- --------------------------------------------------------

--
-- Struktur dari tabel `parkir_masuk`
--

CREATE TABLE `parkir_masuk` (
  `no_tiket` int(3) NOT NULL,
  `no_polisi` varchar(10) NOT NULL,
  `jenis_kendaraan` varchar(5) NOT NULL,
  `waktu_masuk` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `parkir_masuk`
--

INSERT INTO `parkir_masuk` (`no_tiket`, `no_polisi`, `jenis_kendaraan`, `waktu_masuk`) VALUES
(23, 'A 1337 B', 'Motor', 1576144784621),
(24, 'W 245 G', 'Motor', 1576150659482),
(26, 'GH45', 'Motor', 1576151078657),
(27, 'W 123 D', 'Mobil', 1576151407147);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengaturan`
--

CREATE TABLE `pengaturan` (
  `id` int(11) NOT NULL,
  `tarif_awal_motor` int(15) NOT NULL,
  `tarif_jam_motor` int(15) NOT NULL,
  `kapasitas_motor` int(11) NOT NULL,
  `tarif_awal_mobil` int(15) NOT NULL,
  `tarif_jam_mobil` int(15) NOT NULL,
  `kapasitas_mobil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengaturan`
--

INSERT INTO `pengaturan` (`id`, `tarif_awal_motor`, `tarif_jam_motor`, `kapasitas_motor`, `tarif_awal_mobil`, `tarif_jam_mobil`, `kapasitas_mobil`) VALUES
(1, 2000, 1500, 20, 3000, 2000, 20);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `parkir_keluar`
--
ALTER TABLE `parkir_keluar`
  ADD PRIMARY KEY (`id_keluar`);

--
-- Indeks untuk tabel `parkir_masuk`
--
ALTER TABLE `parkir_masuk`
  ADD PRIMARY KEY (`no_tiket`);

--
-- Indeks untuk tabel `pengaturan`
--
ALTER TABLE `pengaturan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `parkir_keluar`
--
ALTER TABLE `parkir_keluar`
  MODIFY `id_keluar` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `parkir_masuk`
--
ALTER TABLE `parkir_masuk`
  MODIFY `no_tiket` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
