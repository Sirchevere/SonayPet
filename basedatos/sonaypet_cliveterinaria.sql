-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-05-2020 a las 04:30:29
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
  `direccion` varchar(255) NOT NULL,
  `estado` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `stock` int(11) NOT NULL,
  `estado` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tab_animal`
--

CREATE TABLE `tab_animal` (
  `ID_ANIMAL` int(11) NOT NULL,
  `ANI_NOMBRE` varchar(50) NOT NULL,
  `ANI_DESCRIPCION` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tab_animal`
--

INSERT INTO `tab_animal` (`ID_ANIMAL`, `ANI_NOMBRE`, `ANI_DESCRIPCION`) VALUES
(1, 'PERRO', 'SAD'),
(2, 'Otro', 'Otro');

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
(22, '', '', NULL, '', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tab_mascota`
--

CREATE TABLE `tab_mascota` (
  `ID_MASCOTA` int(11) NOT NULL,
  `ID_CLIENTE` int(11) DEFAULT NULL,
  `ID_ANIMAL` int(11) DEFAULT NULL,
  `ID_RAZA` int(11) DEFAULT NULL,
  `MASC_NOMBRE` varchar(50) NOT NULL,
  `MASC_FECHANAC` date NOT NULL,
  `MASC_GENERO` varchar(20) NOT NULL,
  `MASC_COLOR` varchar(20) DEFAULT NULL,
  `MASC_PELAJE` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tab_raza`
--

CREATE TABLE `tab_raza` (
  `ID_RAZA` int(11) NOT NULL,
  `RAZA_NOMBRE` varchar(100) NOT NULL,
  `RAZA_DESCRIPCION` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tab_raza`
--

INSERT INTO `tab_raza` (`ID_RAZA`, `RAZA_NOMBRE`, `RAZA_DESCRIPCION`) VALUES
(1, 'ASD', 'ASD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE `vendedor` (
  `idVendedor` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `usuario` varchar(8) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `estado` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`idVendedor`, `nombre`, `telefono`, `usuario`, `dni`, `estado`) VALUES
(1, 'Empleado 0001', '6222230071', 'emp01', '123', '1');

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
  `monto` double NOT NULL,
  `estado` varchar(1) NOT NULL
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
-- Indices de la tabla `tab_animal`
--
ALTER TABLE `tab_animal`
  ADD PRIMARY KEY (`ID_ANIMAL`);

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
  ADD KEY `FK_RELATIONSHIP_1` (`ID_ANIMAL`),
  ADD KEY `FK_RELATIONSHIP_2` (`ID_RAZA`),
  ADD KEY `FK_RELATIONSHIP_3` (`ID_CLIENTE`);

--
-- Indices de la tabla `tab_raza`
--
ALTER TABLE `tab_raza`
  ADD PRIMARY KEY (`ID_RAZA`);

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
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `detalleventas`
--
ALTER TABLE `detalleventas`
  MODIFY `idDetalleVentas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tab_animal`
--
ALTER TABLE `tab_animal`
  MODIFY `ID_ANIMAL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tab_citas`
--
ALTER TABLE `tab_citas`
  MODIFY `ID_CITAS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tab_cliente`
--
ALTER TABLE `tab_cliente`
  MODIFY `ID_CLIENTE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `tab_mascota`
--
ALTER TABLE `tab_mascota`
  MODIFY `ID_MASCOTA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tab_raza`
--
ALTER TABLE `tab_raza`
  MODIFY `ID_RAZA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `idVendedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
  ADD CONSTRAINT `FK_RELATIONSHIP_1` FOREIGN KEY (`ID_ANIMAL`) REFERENCES `tab_animal` (`ID_ANIMAL`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RELATIONSHIP_2` FOREIGN KEY (`ID_RAZA`) REFERENCES `tab_raza` (`ID_RAZA`) ON DELETE CASCADE ON UPDATE CASCADE,
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
