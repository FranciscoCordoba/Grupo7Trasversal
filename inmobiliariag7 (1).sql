-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 07, 2022 at 06:14 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inmobiliariag7`
--

-- --------------------------------------------------------

--
-- Table structure for table `contrato`
--

CREATE TABLE `contrato` (
  `idContrato` int(11) NOT NULL,
  `fechaIninio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `monto` double NOT NULL,
  `inquilinoContrato` int(11) NOT NULL,
  `propietarioContrato` int(11) NOT NULL,
  `propiedadContrato` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `inmueble`
--

CREATE TABLE `inmueble` (
  `direccion` varchar(255) NOT NULL,
  `altura` int(11) NOT NULL,
  `disponibilidad` tinyint(1) NOT NULL,
  `tipoDeInmueble` varchar(255) NOT NULL,
  `zona` varchar(255) NOT NULL,
  `superficie` double NOT NULL,
  `precioBase` double NOT NULL,
  `idInmueble` int(11) NOT NULL,
  `ocupante` int(11) DEFAULT NULL,
  `propietarioInmueble` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `inquilino`
--

CREATE TABLE `inquilino` (
  `idInquilino` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `dni` int(11) NOT NULL,
  `cuit` int(11) NOT NULL,
  `lugarTrabajo` varchar(255) NOT NULL,
  `nombreGarante` varchar(255) NOT NULL,
  `dniGarante` varchar(255) NOT NULL,
  `propiedades` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `propietario`
--

CREATE TABLE `propietario` (
  `idPropietario` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `dni` int(11) NOT NULL,
  `domicilio` varchar(255) NOT NULL,
  `telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contrato`
--
ALTER TABLE `contrato`
  ADD PRIMARY KEY (`idContrato`),
  ADD KEY `inquilinoContrato` (`inquilinoContrato`),
  ADD KEY `propiedadContrato` (`propiedadContrato`),
  ADD KEY `propietarioContrato` (`propietarioContrato`);

--
-- Indexes for table `inmueble`
--
ALTER TABLE `inmueble`
  ADD PRIMARY KEY (`idInmueble`),
  ADD KEY `ocupante` (`ocupante`),
  ADD KEY `propietarioInmueble` (`propietarioInmueble`);

--
-- Indexes for table `inquilino`
--
ALTER TABLE `inquilino`
  ADD PRIMARY KEY (`idInquilino`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `cuit` (`cuit`),
  ADD UNIQUE KEY `dniGarante` (`dniGarante`);

--
-- Indexes for table `propietario`
--
ALTER TABLE `propietario`
  ADD PRIMARY KEY (`idPropietario`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contrato`
--
ALTER TABLE `contrato`
  ADD CONSTRAINT `inquilinoContrato` FOREIGN KEY (`inquilinoContrato`) REFERENCES `inquilino` (`idInquilino`),
  ADD CONSTRAINT `propiedadContrato` FOREIGN KEY (`propiedadContrato`) REFERENCES `inmueble` (`idInmueble`);

--
-- Constraints for table `inmueble`
--
ALTER TABLE `inmueble`
  ADD CONSTRAINT `ocupante` FOREIGN KEY (`ocupante`) REFERENCES `inquilino` (`idInquilino`),
  ADD CONSTRAINT `propietarioInmueble` FOREIGN KEY (`propietarioInmueble`) REFERENCES `propietario` (`idPropietario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
