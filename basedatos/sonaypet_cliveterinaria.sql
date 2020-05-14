-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 13-05-2020 a las 21:59:51
-- Versión del servidor: 10.3.22-MariaDB-cll-lve
-- Versión de PHP: 7.3.6

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
-- Estructura de tabla para la tabla `tab_cita`
--

CREATE TABLE `tab_cita` (
  `ID_CITA` int(11) NOT NULL,
  `ID_HISTORIACLINICA` int(11) DEFAULT NULL,
  `ID_TRABAJADOR` int(11) DEFAULT NULL,
  `ID_MASCOTA` int(11) DEFAULT NULL,
  `CITA_FECHA` date NOT NULL,
  `CITA_HORA` varchar(20) NOT NULL,
  `CITA_EDAD` varchar(50) NOT NULL,
  `CITA_TEMPERATURA` decimal(8,2) NOT NULL,
  `CITA_PULSO` int(11) NOT NULL,
  `CITA_RESPIRACION` int(11) NOT NULL,
  `CITA_PESO` decimal(8,2) NOT NULL,
  `CITA_ALZADA` decimal(8,2) NOT NULL,
  `CITA_CICATRICES` varchar(10) DEFAULT NULL,
  `CITA_CIRUGIASESTETICAS` varchar(10) DEFAULT NULL,
  `CITA_CONDICIONCORPORAL` int(11) NOT NULL,
  `CITA_ENTORNO` varchar(50) DEFAULT NULL,
  `CITA_NUTRICION` varchar(50) DEFAULT NULL,
  `CITA_ESTILOVIDA` varchar(50) DEFAULT NULL,
  `CITA_MOTIVO` varchar(100) NOT NULL,
  `CITA_ANTECEDENTES` varchar(300) DEFAULT NULL,
  `CITA_AYUDADIAGNOSTICA` varchar(300) DEFAULT NULL,
  `CITA_DIAGPRESUNTIVO` varchar(300) NOT NULL,
  `CITA_DIAGDIFERENCIAL` varchar(300) NOT NULL,
  `CITA_TRATAMIENTO` varchar(300) NOT NULL,
  `CITA_PRONOSTICO` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
-- Estructura de tabla para la tabla `tab_ciudad`
--

CREATE TABLE `tab_ciudad` (
  `ID_CIUDAD` int(11) NOT NULL,
  `CIU_NOMBRE` varchar(50) NOT NULL,
  `CIU_DESCRIPCION` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tab_ciudad`
--

INSERT INTO `tab_ciudad` (`ID_CIUDAD`, `CIU_NOMBRE`, `CIU_DESCRIPCION`) VALUES
(1, 'EMPALME', ''),
(2, 'GUAYMAS', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tab_cliente`
--

CREATE TABLE `tab_cliente` (
  `ID_CLIENTE` int(11) NOT NULL,
  `CLI_CIUDAD` varchar(50) NOT NULL,
  `CLI_NOMBRES` varchar(50) NOT NULL,
  `CLI_APELLIDOS` varchar(60) NOT NULL,
  `CLI_TIPODOCUMENTO` varchar(20) NOT NULL,
  `CLI_NUMDOCUMENTO` varchar(20) NOT NULL,
  `CLI_FECHANAC` date DEFAULT NULL,
  `CLI_DIRECCION` varchar(100) NOT NULL,
  `CLI_TELEFONO` varchar(20) DEFAULT NULL,
  `CLI_GENERO` varchar(1) DEFAULT NULL,
  `CLI_EMAIL` varchar(100) DEFAULT NULL,
  `CLI_PASS` varbinary(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tab_cliente`
--

INSERT INTO `tab_cliente` (`ID_CLIENTE`, `CLI_CIUDAD`, `CLI_NOMBRES`, `CLI_APELLIDOS`, `CLI_TIPODOCUMENTO`, `CLI_NUMDOCUMENTO`, `CLI_FECHANAC`, `CLI_DIRECCION`, `CLI_TELEFONO`, `CLI_GENERO`, `CLI_EMAIL`, `CLI_PASS`) VALUES
(21, 'asd', 'asd', 'asd', '', '', '2020-05-13', 'asd', '1', 'F', 'a@a.com', 0x2a2a6957ba6e5964e7f5b43368c22ed4),
(22, '', '', '', '', '', NULL, '', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tab_historiaclinica`
--

CREATE TABLE `tab_historiaclinica` (
  `ID_HISTORIACLINICA` int(11) NOT NULL,
  `HIS_NOMBREMASCOTA` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
-- Estructura de tabla para la tabla `tab_trabajador`
--

CREATE TABLE `tab_trabajador` (
  `ID_TRABAJADOR` int(11) NOT NULL,
  `ID_CIUDAD` int(11) DEFAULT NULL,
  `TRA_NOMBRES` varchar(60) NOT NULL,
  `TRA_APELLIDOS` varchar(60) NOT NULL,
  `TRA_TIPODOCUMENTO` varchar(15) NOT NULL,
  `TRA_NUMDOCUMENTO` varchar(15) NOT NULL,
  `TRA_FECHANAC` date NOT NULL,
  `TRA_GENERO` varchar(1) NOT NULL,
  `TRA_DIRECCION` varchar(150) NOT NULL,
  `TRA_TELEFONO` varchar(20) NOT NULL,
  `TRA_EMAIL` varchar(100) NOT NULL,
  `TRA_ACCESO` varchar(20) NOT NULL,
  `TRA_USUARIO` varchar(20) NOT NULL,
  `TRA_PASSWORD` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tab_trabajador`
--

INSERT INTO `tab_trabajador` (`ID_TRABAJADOR`, `ID_CIUDAD`, `TRA_NOMBRES`, `TRA_APELLIDOS`, `TRA_TIPODOCUMENTO`, `TRA_NUMDOCUMENTO`, `TRA_FECHANAC`, `TRA_GENERO`, `TRA_DIRECCION`, `TRA_TELEFONO`, `TRA_EMAIL`, `TRA_ACCESO`, `TRA_USUARIO`, `TRA_PASSWORD`) VALUES
(5, 1, 'CESAR', 'RAMIREZ', 'PASAPORTE', '1', '1996-04-16', 'M', 'SU CASA', '6225831664', 'cesar@gmail.com', 'ADMINISTRADOR', 'cesar', 'cesar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tab_traspaso`
--

CREATE TABLE `tab_traspaso` (
  `ID_TRASPASO` int(11) NOT NULL,
  `ID_CLIENTE` int(11) DEFAULT NULL,
  `ID_MASCOTA` int(11) DEFAULT NULL,
  `TRAS_FECHA` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tab_animal`
--
ALTER TABLE `tab_animal`
  ADD PRIMARY KEY (`ID_ANIMAL`);

--
-- Indices de la tabla `tab_cita`
--
ALTER TABLE `tab_cita`
  ADD PRIMARY KEY (`ID_CITA`),
  ADD KEY `FK_RELATIONSHIP_7` (`ID_HISTORIACLINICA`),
  ADD KEY `FK_RELATIONSHIP_8` (`ID_TRABAJADOR`),
  ADD KEY `FK_RELATIONSHIP_9` (`ID_MASCOTA`);

--
-- Indices de la tabla `tab_citas`
--
ALTER TABLE `tab_citas`
  ADD PRIMARY KEY (`ID_CITAS`),
  ADD KEY `CLIENTE_ID` (`CLIENTE_ID`),
  ADD KEY `MASCOTA_ID` (`MASCOTA_ID`);

--
-- Indices de la tabla `tab_ciudad`
--
ALTER TABLE `tab_ciudad`
  ADD PRIMARY KEY (`ID_CIUDAD`);

--
-- Indices de la tabla `tab_cliente`
--
ALTER TABLE `tab_cliente`
  ADD PRIMARY KEY (`ID_CLIENTE`);

--
-- Indices de la tabla `tab_historiaclinica`
--
ALTER TABLE `tab_historiaclinica`
  ADD PRIMARY KEY (`ID_HISTORIACLINICA`);

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
-- Indices de la tabla `tab_trabajador`
--
ALTER TABLE `tab_trabajador`
  ADD PRIMARY KEY (`ID_TRABAJADOR`),
  ADD KEY `FK_RELATIONSHIP_4` (`ID_CIUDAD`);

--
-- Indices de la tabla `tab_traspaso`
--
ALTER TABLE `tab_traspaso`
  ADD PRIMARY KEY (`ID_TRASPASO`),
  ADD KEY `FK_RELATIONSHIP_5` (`ID_MASCOTA`),
  ADD KEY `FK_RELATIONSHIP_6` (`ID_CLIENTE`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tab_animal`
--
ALTER TABLE `tab_animal`
  MODIFY `ID_ANIMAL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tab_cita`
--
ALTER TABLE `tab_cita`
  MODIFY `ID_CITA` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tab_citas`
--
ALTER TABLE `tab_citas`
  MODIFY `ID_CITAS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tab_ciudad`
--
ALTER TABLE `tab_ciudad`
  MODIFY `ID_CIUDAD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tab_cliente`
--
ALTER TABLE `tab_cliente`
  MODIFY `ID_CLIENTE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `tab_historiaclinica`
--
ALTER TABLE `tab_historiaclinica`
  MODIFY `ID_HISTORIACLINICA` int(11) NOT NULL AUTO_INCREMENT;

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
-- AUTO_INCREMENT de la tabla `tab_trabajador`
--
ALTER TABLE `tab_trabajador`
  MODIFY `ID_TRABAJADOR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tab_traspaso`
--
ALTER TABLE `tab_traspaso`
  MODIFY `ID_TRASPASO` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tab_cita`
--
ALTER TABLE `tab_cita`
  ADD CONSTRAINT `FK_RELATIONSHIP_7` FOREIGN KEY (`ID_HISTORIACLINICA`) REFERENCES `tab_historiaclinica` (`ID_HISTORIACLINICA`),
  ADD CONSTRAINT `FK_RELATIONSHIP_8` FOREIGN KEY (`ID_TRABAJADOR`) REFERENCES `tab_trabajador` (`ID_TRABAJADOR`),
  ADD CONSTRAINT `FK_RELATIONSHIP_9` FOREIGN KEY (`ID_MASCOTA`) REFERENCES `tab_mascota` (`ID_MASCOTA`);

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
-- Filtros para la tabla `tab_trabajador`
--
ALTER TABLE `tab_trabajador`
  ADD CONSTRAINT `FK_RELATIONSHIP_4` FOREIGN KEY (`ID_CIUDAD`) REFERENCES `tab_ciudad` (`ID_CIUDAD`);

--
-- Filtros para la tabla `tab_traspaso`
--
ALTER TABLE `tab_traspaso`
  ADD CONSTRAINT `FK_RELATIONSHIP_5` FOREIGN KEY (`ID_MASCOTA`) REFERENCES `tab_mascota` (`ID_MASCOTA`),
  ADD CONSTRAINT `FK_RELATIONSHIP_6` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `tab_cliente` (`ID_CLIENTE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
