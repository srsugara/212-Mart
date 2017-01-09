-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 03 Jan 2017 pada 05.38
-- Versi Server: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `212_mart`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `id_barang` varchar(5) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `stok` int(5) NOT NULL,
  `harga` int(15) NOT NULL,
  PRIMARY KEY (`id_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `stok`, `harga`) VALUES
('KB001', 'Teh Pucuk', 20, 3500),
('KB002', 'Pop Mie Ayam', 10, 4000),
('KB003', 'Oreo Vanilla', 15, 8000),
('KB004', 'Bear Brand', 20, 7000),
('KB005', 'Kacang Garuda', 13, 8500),
('KB006', 'Pepsodent', 10, 6000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesan_barang`
--

CREATE TABLE IF NOT EXISTS `pesan_barang` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `id_pesanan` int(11) NOT NULL,
  `id_barang` varchar(5) NOT NULL,
  `jumlah_barang` int(4) NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data untuk tabel `pesan_barang`
--

INSERT INTO `pesan_barang` (`no`, `id_pesanan`, `id_barang`, `jumlah_barang`, `total`) VALUES
(1, 1, 'KB002', 4, 16000),
(3, 2, 'KB001', 5, 17500),
(4, 3, 'KB002', 8, 32000),
(6, 4, 'KB001', 2, 7000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `id_transaksi` int(5) NOT NULL AUTO_INCREMENT,
  `tanggal_transaksi` date NOT NULL,
  `id_pesanan` varchar(5) NOT NULL,
  `total_harga` int(15) NOT NULL,
  `id_petugas` varchar(5) NOT NULL,
  PRIMARY KEY (`id_transaksi`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `tanggal_transaksi`, `id_pesanan`, `total_harga`, `id_petugas`) VALUES
(1, '2016-12-01', 'P001', 4500, 'PT001');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
