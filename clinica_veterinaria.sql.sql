-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-10-2023 a las 14:33:10
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `clinica_veterinaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `telefono` int(20) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefonoAlternativo` int(20) DEFAULT NULL,
  `activo` tinyint(1) NOT NULL,
  `nombreAlternativo` varchar(40) DEFAULT NULL,
  `usuarioLog` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `dni`, `nombre`, `apellido`, `telefono`, `direccion`, `telefonoAlternativo`, `activo`, `nombreAlternativo`, `usuarioLog`) VALUES
(1, 2222222, 'pepe', 'loko', 11232323, 'pipoletti 3343', 22299922, 1, NULL, ''),
(2, 23234456, 'Pirulo', 'Martinez', 345439388, 'Loma verde  32', 2147483647, 1, NULL, ''),
(3, 29343434, 'tito', 'Moro', 232323232, 'Fufufu 43', 2147483647, 0, NULL, ''),
(4, 20123456, 'JAaacinto', 'Smith', 111111111, 'piporete 32', 22222222, 1, 'titi', 'titus');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `loggin`
--

CREATE TABLE `loggin` (
  `idLoggin` int(11) NOT NULL,
  `usuario` varchar(10) NOT NULL,
  `pw` varchar(10) NOT NULL,
  `avatar` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `loggin`
--

INSERT INTO `loggin` (`idLoggin`, `usuario`, `pw`, `avatar`) VALUES
(1, '1234', '1234', '/Avatar/monstruo.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota`
--

CREATE TABLE `mascota` (
  `idMascota` int(11) NOT NULL,
  `alias` varchar(30) NOT NULL,
  `sexo` char(1) NOT NULL,
  `especie` varchar(30) NOT NULL,
  `raza` varchar(30) NOT NULL,
  `colorPelo` varchar(50) NOT NULL,
  `fechaNac` date NOT NULL,
  `idCliente` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `pesoUltimo` double DEFAULT NULL,
  `pesoPromedio` double DEFAULT NULL,
  `fechaDefuncion` date DEFAULT NULL,
  `usuarioLog` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mascota`
--

INSERT INTO `mascota` (`idMascota`, `alias`, `sexo`, `especie`, `raza`, `colorPelo`, `fechaNac`, `idCliente`, `activo`, `pesoUltimo`, `pesoPromedio`, `fechaDefuncion`, `usuarioLog`) VALUES
(1, 'toto', 'm', 'perro', 'cocker', 'dorado', '2018-08-09', 1, 0, 1, 0, NULL, ''),
(2, 'dido', 'm', 'gato', 'persa', 'blanco', '2019-08-15', 2, 1, 6, 5.75, NULL, ''),
(3, 'fuji', 'm', 'elefante', 'chuki', 'gris', '2023-08-08', 1, 1, 0, 0, NULL, ''),
(4, 'coco', 'm', 'canino', 'golden', 'rubio', '2010-03-23', 4, 1, 6, 9, NULL, 'jose');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamiento`
--

CREATE TABLE `tratamiento` (
  `idTratamiento` int(11) NOT NULL,
  `descripcion` text NOT NULL,
  `medicamento` varchar(50) DEFAULT NULL,
  `importe` double NOT NULL,
  `tipoTratamiento` varchar(30) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `usuarioLog` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tratamiento`
--

INSERT INTO `tratamiento` (`idTratamiento`, `descripcion`, `medicamento`, `importe`, `tipoTratamiento`, `activo`, `usuarioLog`) VALUES
(1, 'mucho bardo', 'pipeta', 3000, 'pulgas', 1, ''),
(2, 'normal', 'forte500mg', 0, '3000.0', 1, ''),
(3, 'normal', 'forte500mg', 0, '3000.0', 1, ''),
(4, 'jhkasdkfa', 'ajkshf', 1000, 'CONTROL', 1, ''),
(5, 'tgsdgsd', 'stget', 1000, 'CONTROL', 1, ''),
(6, 'dca', 'dcf', 1000, 'CONTROL', 1, ''),
(7, 'fgdfsg', 'fsdgdfg', 1000, 'VACUNACION', 1, ''),
(8, 'sadfas', 'asfdasd', 1000, 'VACUNACION', 1, ''),
(9, 'dsfgsd', 'dfasdfads', 4000, 'VACUNACION', 1, ''),
(10, 'erqwe', 'afsdfasd', 1000, 'VACUNACION', 1, ''),
(11, 'qwerq', 'qwerqwe', 1000, 'VACUNACION', 1, ''),
(12, 'asdfasd', 'dfasdfasd', 1000, 'VACUNACION', 1, ''),
(13, 'sdfasdf', 'fsdfasdf', 1000, 'VACUNACION', 1, ''),
(14, 'asdfasd', 'sdfasdf', 1000, 'VACUNACION', 1, ''),
(15, 'sdgsdg', 'gfsdgsd', 1000, 'VACUNACION', 1, ''),
(16, 'sdg', 'sfdsdf', 234, 'VACUNACION', 1, ''),
(17, 'dfs', 'sdf', 234, 'VACUNACION', 1, ''),
(18, 'asdfadsf', 'asdfasdf', 1000, 'VACUNACION', 1, ''),
(19, 'asdfasd', 'asdfasdf', 1000, 'VACUNACION', 1, ''),
(20, 'asdfasd', 'asdfasdf', 1000, 'VACUNACION', 1, ''),
(21, 'vdasdv', 'asdvasd', 1000, 'VACUNACION', 1, ''),
(22, 'sdfgsdf', 'gsdfgsd', 1000, 'VACUNACION', 1, ''),
(23, 'ghdfghd', 'hdfghdfg', 1000, 'VACUNACION', 1, ''),
(24, 'asdfasd', 'vsdfvsdfv', 1000, 'VACUNACION', 1, ''),
(25, 'gsdfgsdf', 'vvdsfbsbsdfb', 1000, 'VACUNACION', 1, ''),
(26, 'fasdfads', 'asdfasdf', 1000, 'VACUNACION', 1, ''),
(27, 'sdfds', 'sdfsdafds', 123, 'VACUNACION', 1, ''),
(28, 'sdf', 'sdf', 123, 'VACUNACION', 1, ''),
(29, 'sdf', '2asfs', 123, 'VACUNACION', 1, ''),
(30, 'fsdf', 'dsfsf', 123, 'VACUNACION', 1, ''),
(31, 'sdf', 'sdf', 123, 'VACUNACION', 1, ''),
(32, 'asd', 'asfd', 123, 'VACUNACION', 1, ''),
(33, 'sdf', '123a', 12, 'VACUNACION', 1, ''),
(34, 'fsd', '123', 123, 'VACUNACION', 1, ''),
(35, 'sdfsd', 'fsdfsd', 1222, 'VACUNACION', 1, ''),
(36, 'df', 'sdf', 1, 'VACUNACION', 1, ''),
(37, 'fsdf', 'sf', 123, 'VACUNACION', 1, ''),
(38, 'zxc', 'zxc', 112, 'VACUNACION', 1, ''),
(39, 'aklsjd', 'asdasd', 0, 'VACUNACION', 1, ''),
(40, 'asd', 'asd', 0, 'VACUNACION', 1, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `visita`
--

CREATE TABLE `visita` (
  `idVisita` int(11) NOT NULL,
  `idMascota` int(11) NOT NULL,
  `fechaVisita` date NOT NULL,
  `detalle` varchar(50) NOT NULL,
  `pesoActual` double NOT NULL,
  `idTratamiento` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `internado` tinyint(1) NOT NULL,
  `fechaAlta` date DEFAULT NULL,
  `usuarioLog` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `visita`
--

INSERT INTO `visita` (`idVisita`, `idMascota`, `fechaVisita`, `detalle`, `pesoActual`, `idTratamiento`, `activo`, `internado`, `fechaAlta`, `usuarioLog`) VALUES
(3, 2, '2023-06-25', 'moquillo', 5, 1, 1, 0, NULL, ''),
(18, 3, '2023-10-30', 'dafsdf', 1, 14, 1, 0, '2023-10-30', 'fifi'),
(43, 4, '2023-10-31', 'kajsd', 12, 39, 1, 0, '2023-10-31', 'fifi'),
(44, 4, '2023-10-31', 'asfd', 6, 40, 1, 0, '2023-10-31', 'fifi');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`),
  ADD UNIQUE KEY `dni` (`dni`,`telefono`);

--
-- Indices de la tabla `loggin`
--
ALTER TABLE `loggin`
  ADD PRIMARY KEY (`idLoggin`),
  ADD UNIQUE KEY `usuario` (`usuario`),
  ADD UNIQUE KEY `avatar` (`avatar`);

--
-- Indices de la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD PRIMARY KEY (`idMascota`),
  ADD KEY `idCliente` (`idCliente`);

--
-- Indices de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  ADD PRIMARY KEY (`idTratamiento`);

--
-- Indices de la tabla `visita`
--
ALTER TABLE `visita`
  ADD PRIMARY KEY (`idVisita`),
  ADD KEY `idMascota` (`idMascota`,`idTratamiento`),
  ADD KEY `idTratamiento` (`idTratamiento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `loggin`
--
ALTER TABLE `loggin`
  MODIFY `idLoggin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `mascota`
--
ALTER TABLE `mascota`
  MODIFY `idMascota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  MODIFY `idTratamiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `visita`
--
ALTER TABLE `visita`
  MODIFY `idVisita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD CONSTRAINT `mascota_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `visita`
--
ALTER TABLE `visita`
  ADD CONSTRAINT `visita_ibfk_1` FOREIGN KEY (`idMascota`) REFERENCES `mascota` (`idMascota`),
  ADD CONSTRAINT `visita_ibfk_2` FOREIGN KEY (`idTratamiento`) REFERENCES `tratamiento` (`idTratamiento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
