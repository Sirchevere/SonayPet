-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-05-2020 a las 21:44:50
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sonaypet_cliveterinaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `nombres` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `dni`, `nombres`, `direccion`) VALUES
(7, '654', 'Patricio', 'Bajo una roca'),
(8, '', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventas`
--

CREATE TABLE `detalleventas` (
  `idDetalleVentas` int(11) NOT NULL,
  `idVentas` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precioVenta` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombre` varchar(244) NOT NULL,
  `precio` double NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombre`, `precio`, `stock`) VALUES
(9, 'asdf', 50, 50),
(10, 'tret', 10, 11),
(11, 'chaca', 8, 300);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tab_citas`
--

CREATE TABLE `tab_citas` (
  `ID_CITAS` int(11) NOT NULL,
  `CLIENTE_ID` int(11) DEFAULT NULL,
  `MASCOTA_ID` int(11) DEFAULT NULL,
  `CITA_FECHAHR` date NOT NULL,
  `CITA_HORA` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tab_citas`
--

INSERT INTO `tab_citas` (`ID_CITAS`, `CLIENTE_ID`, `MASCOTA_ID`, `CITA_FECHAHR`, `CITA_HORA`) VALUES
(6, 21, 9, '2020-05-27', '11:00:00'),
(9, 21, 9, '2020-05-22', '03:30:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tab_cliente`
--

CREATE TABLE `tab_cliente` (
  `ID_CLIENTE` int(11) NOT NULL,
  `CLI_NOMBRES` varchar(50) NOT NULL,
  `CLI_APELLIDOS` varchar(60) NOT NULL,
  `CLI_FECHANAC` date DEFAULT NULL,
  `CLI_DIRECCION` varchar(100) NOT NULL,
  `CLI_TELEFONO` varchar(20) DEFAULT NULL,
  `CLI_GENERO` varchar(1) DEFAULT NULL,
  `CLI_EMAIL` varchar(100) DEFAULT NULL,
  `CLI_PASS` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tab_cliente`
--

INSERT INTO `tab_cliente` (`ID_CLIENTE`, `CLI_NOMBRES`, `CLI_APELLIDOS`, `CLI_FECHANAC`, `CLI_DIRECCION`, `CLI_TELEFONO`, `CLI_GENERO`, `CLI_EMAIL`, `CLI_PASS`) VALUES
(21, 'asd', 'asd', '2020-05-13', 'asd', '1', 'F', 'a@a.com', 0x2a2a6957ba6e5964e7f5b43368c22ed4),
(22, '', '', NULL, '', NULL, NULL, NULL, NULL),
(25, 'Cesar', 'Ramirez', '1996-04-16', 'Su casa', '2229025982', 'M', 'cesar@mail.com', 0xaa31bc9280d704c8567eed9243c28469);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tab_mascota`
--

CREATE TABLE `tab_mascota` (
  `ID_MASCOTA` int(11) NOT NULL,
  `ID_CLIENTE` int(11) DEFAULT NULL,
  `MASC_NOMBRE` varchar(50) NOT NULL,
  `MASC_FECHANAC` date NOT NULL,
  `MASC_ESPECIE` varchar(20) NOT NULL,
  `MASC_RAZA` varchar(20) NOT NULL,
  `MASC_GENERO` varchar(20) NOT NULL,
  `MASC_COLOR` varchar(20) DEFAULT NULL,
  `MASC_PELAJE` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tab_mascota`
--

INSERT INTO `tab_mascota` (`ID_MASCOTA`, `ID_CLIENTE`, `MASC_NOMBRE`, `MASC_FECHANAC`, `MASC_ESPECIE`, `MASC_RAZA`, `MASC_GENERO`, `MASC_COLOR`, `MASC_PELAJE`) VALUES
(9, 21, 'Pepito', '2020-05-12', 'Perro', 'Labrador', 'SELECCIONAR', 'Negro', 'Rizado'),
(12, 25, 'Bayo', '2013-02-08', 'Perro', 'French', 'MACHO', 'Blanco', 'Rizado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE `vendedor` (
  `idVendedor` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `usuario` varchar(8) NOT NULL,
  `dni` blob NOT NULL,
  `acceso` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`idVendedor`, `nombre`, `telefono`, `usuario`, `dni`, `acceso`) VALUES
(3, 'cesar', '6221578961', 'cesar', 0xaa31bc9280d704c8567eed9243c28469, 'Administrador'),
(8, 'Omar', '6224577965', 'omar', 0x7b27f9b39b3fcf47f74d87037963f8dc, 'Empleado'),
(10, 'Empleado', '6545454', 'empleado', 0x2ff0ea9f0219b0a4b0d884d5de5fdd40, 'Empleado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idVentas` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idVendedor` int(11) NOT NULL,
  `numeroSerie` varchar(12) NOT NULL,
  `fechaVenta` date NOT NULL,
  `monto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `detalleventas`
--
ALTER TABLE `detalleventas`
  ADD PRIMARY KEY (`idDetalleVentas`),
  ADD KEY `idVentas` (`idVentas`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `tab_citas`
--
ALTER TABLE `tab_citas`
  ADD PRIMARY KEY (`ID_CITAS`),
  ADD KEY `CLIENTE_ID` (`CLIENTE_ID`),
  ADD KEY `MASCOTA_ID` (`MASCOTA_ID`);

--
-- Indices de la tabla `tab_cliente`
--
ALTER TABLE `tab_cliente`
  ADD PRIMARY KEY (`ID_CLIENTE`);

--
-- Indices de la tabla `tab_mascota`
--
ALTER TABLE `tab_mascota`
  ADD PRIMARY KEY (`ID_MASCOTA`),
  ADD KEY `FK_RELATIONSHIP_3` (`ID_CLIENTE`);

--
-- Indices de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`idVendedor`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idVentas`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idEmpleado` (`idVendedor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `detalleventas`
--
ALTER TABLE `detalleventas`
  MODIFY `idDetalleVentas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `tab_citas`
--
ALTER TABLE `tab_citas`
  MODIFY `ID_CITAS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `tab_cliente`
--
ALTER TABLE `tab_cliente`
  MODIFY `ID_CLIENTE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `tab_mascota`
--
ALTER TABLE `tab_mascota`
  MODIFY `ID_MASCOTA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `idVendedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idVentas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalleventas`
--
ALTER TABLE `detalleventas`
  ADD CONSTRAINT `detalleventas_ibfk_1` FOREIGN KEY (`idVentas`) REFERENCES `ventas` (`idVentas`) ON UPDATE CASCADE,
  ADD CONSTRAINT `detalleventas_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `tab_citas`
--
ALTER TABLE `tab_citas`
  ADD CONSTRAINT `FK1` FOREIGN KEY (`CLIENTE_ID`) REFERENCES `tab_cliente` (`ID_CLIENTE`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK2` FOREIGN KEY (`MASCOTA_ID`) REFERENCES `tab_mascota` (`ID_MASCOTA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tab_mascota`
--
ALTER TABLE `tab_mascota`
  ADD CONSTRAINT `FK_RELATIONSHIP_3` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `tab_cliente` (`ID_CLIENTE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON UPDATE CASCADE,
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`idVendedor`) REFERENCES `vendedor` (`idVendedor`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
