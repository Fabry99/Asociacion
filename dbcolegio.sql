-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-07-2023 a las 21:14:56
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbcolegio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `ID_ALUMNO` int(100) NOT NULL,
  `NIE` int(20) NOT NULL,
  `NOMBRE_ALUMNO` text NOT NULL,
  `GRADO` varchar(50) NOT NULL,
  `NOMBRE_RESPONSABLE` text NOT NULL,
  `DUI` int(20) NOT NULL,
  `AÑO` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`ID_ALUMNO`, `NIE`, `NOMBRE_ALUMNO`, `GRADO`, `NOMBRE_RESPONSABLE`, `DUI`, `AÑO`) VALUES
(15, 192677656, 'JOSE ENRIQUEZ MEJIA FLORES', 'SEGUNDO ', 'CARLOS EDUARDO DUARTE', 123456789, '2023'),
(16, 102030, 'RIGOBERTO FLORES', 'KINDER 4', 'ANA DILIA FLORES', 123444559, '2023'),
(18, 1234455, 'JOSE ENRIQUE FLORES TREJO', 'CUARTO', 'JOSE EDUARDO FLORES MEJIA', 123456677, '2023');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta_egresos`
--

CREATE TABLE `cuenta_egresos` (
  `ID_CUENTA_EGRESOS` int(100) NOT NULL,
  `NOMBRE_CUENTA` varchar(100) NOT NULL,
  `TELEFONO` int(10) NOT NULL,
  `DIRECCION` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `cuenta_egresos`
--

INSERT INTO `cuenta_egresos` (`ID_CUENTA_EGRESOS`, `NOMBRE_CUENTA`, `TELEFONO`, `DIRECCION`) VALUES
(1, 'CLARO', 7877777, 'CALLE #14'),
(2, 'TIGO', 122323, 'SADSAD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta_ingresos`
--

CREATE TABLE `cuenta_ingresos` (
  `ID_CUENTA_INGRESOS` int(100) NOT NULL,
  `NOMBRE_CUENTA` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `egresos`
--

CREATE TABLE `egresos` (
  `ID_EGRESOS` int(100) NOT NULL,
  `NOMBRE_CUENTA` varchar(100) NOT NULL,
  `TIPO_CUENTA` varchar(100) NOT NULL,
  `CANTIDAD` double NOT NULL,
  `FECHA` date NOT NULL,
  `DESCRIPCION` varchar(100) NOT NULL,
  `TELEFONO` int(10) NOT NULL,
  `DIRECCION` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `egresos`
--

INSERT INTO `egresos` (`ID_EGRESOS`, `NOMBRE_CUENTA`, `TIPO_CUENTA`, `CANTIDAD`, `FECHA`, `DESCRIPCION`, `TELEFONO`, `DIRECCION`) VALUES
(6, 'ENERGIA ELECTRICA', 'EFECTIVO', 300, '2023-05-06', 'MES ABRIL', 0, ''),
(7, 'INTERNET', 'EFECTIVO', 60, '2023-05-13', 'MES ABRIL', 0, ''),
(8, 'CLARO', 'EFECTIVO', 344, '2023-07-01', 'PAGO', 7877777, 'CALLE #14');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingresos`
--

CREATE TABLE `ingresos` (
  `ID_INGRESOS` int(100) NOT NULL,
  `NOMBRE_CUENTA` varchar(100) NOT NULL,
  `CLIENTE` text NOT NULL,
  `DUI_NIT` int(20) NOT NULL,
  `TIPO_CUENTA` varchar(100) NOT NULL,
  `CANTIDAD` double NOT NULL,
  `FECHA` date NOT NULL,
  `DESCRIPCION` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `ingresos`
--

INSERT INTO `ingresos` (`ID_INGRESOS`, `NOMBRE_CUENTA`, `CLIENTE`, `DUI_NIT`, `TIPO_CUENTA`, `CANTIDAD`, `FECHA`, `DESCRIPCION`) VALUES
(48, 'COLEGIATURA', 'JOSE ENRIQUEZ MEJIA FLORES', 123456789, 'EFECTIVO', 60, '2023-05-06', 'PAGO MENSUALIDAD'),
(49, 'COLEGIATURA', 'JOSE ENRIQUEZ MEJIA', 123456789, 'EFECTIVO', 10000, '2023-07-01', 'PAGO DE GRADUACION'),
(50, 'COLEGIATURA', 'ZCV', 123456789, 'EFECTIVO', 11000, '2023-07-01', 'ZCV');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `ID` int(11) NOT NULL,
  `usuarios` varchar(20) NOT NULL,
  `claves` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`ID`, `usuarios`, `claves`) VALUES
(1, 'ADMIN', 'ADMIN');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_cuenta`
--

CREATE TABLE `tipo_cuenta` (
  `ID_TIPO_CUENTA` int(100) NOT NULL,
  `NOMBRE_TIPO_CUENTA` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`ID_ALUMNO`);

--
-- Indices de la tabla `cuenta_egresos`
--
ALTER TABLE `cuenta_egresos`
  ADD PRIMARY KEY (`ID_CUENTA_EGRESOS`);

--
-- Indices de la tabla `cuenta_ingresos`
--
ALTER TABLE `cuenta_ingresos`
  ADD PRIMARY KEY (`ID_CUENTA_INGRESOS`);

--
-- Indices de la tabla `egresos`
--
ALTER TABLE `egresos`
  ADD PRIMARY KEY (`ID_EGRESOS`);

--
-- Indices de la tabla `ingresos`
--
ALTER TABLE `ingresos`
  ADD PRIMARY KEY (`ID_INGRESOS`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `tipo_cuenta`
--
ALTER TABLE `tipo_cuenta`
  ADD PRIMARY KEY (`ID_TIPO_CUENTA`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `ID_ALUMNO` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `cuenta_egresos`
--
ALTER TABLE `cuenta_egresos`
  MODIFY `ID_CUENTA_EGRESOS` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `cuenta_ingresos`
--
ALTER TABLE `cuenta_ingresos`
  MODIFY `ID_CUENTA_INGRESOS` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `egresos`
--
ALTER TABLE `egresos`
  MODIFY `ID_EGRESOS` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `ingresos`
--
ALTER TABLE `ingresos`
  MODIFY `ID_INGRESOS` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipo_cuenta`
--
ALTER TABLE `tipo_cuenta`
  MODIFY `ID_TIPO_CUENTA` int(100) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
