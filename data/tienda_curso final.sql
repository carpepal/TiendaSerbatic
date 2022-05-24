-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-05-2022 a las 23:04:42
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda_curso`
--
CREATE DATABASE IF NOT EXISTS `tienda_curso` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `tienda_curso`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE IF NOT EXISTS `categorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id`, `nombre`, `descripcion`) VALUES
(1, 'electronica', 'componentes electronicos'),
(2, 'otros', 'otros');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descuento`
--

CREATE TABLE IF NOT EXISTS `descuento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `descuento` float NOT NULL,
  `fecha_fin` datetime DEFAULT NULL,
  `fecha_inicio` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles_pedido`
--

CREATE TABLE IF NOT EXISTS `detalles_pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `impuesto` float NOT NULL,
  `precio_cantidad` float DEFAULT NULL,
  `total` double NOT NULL,
  `unidades` int(11) NOT NULL,
  `pedidos_id` int(11) DEFAULT NULL,
  `id_pedido` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `precio_unidad` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp1htob4rs7mhp73s6m69abuv6` (`pedidos_id`),
  KEY `FKrvkloxugyfhcls33cvc1no8rm` (`id_pedido`),
  KEY `FKpswk4x0p0wk0myw3f7penop0q` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalles_pedido`
--

INSERT INTO `detalles_pedido` (`id`, `impuesto`, `precio_cantidad`, `total`, `unidades`, `pedidos_id`, `id_pedido`, `id_producto`, `precio_unidad`) VALUES
(40, 2, NULL, 530, 2, NULL, 26, 8, 93),
(41, 2, NULL, 866, 1, NULL, 23, 6, 97),
(42, 5, NULL, 36, 0, NULL, 29, 5, 70),
(43, 2, NULL, 577, 8, NULL, 21, 5, 52),
(44, 6, NULL, 865, 7, NULL, 26, 5, 101),
(45, 6, NULL, 178, 9, NULL, 28, 2, 80),
(46, 0, NULL, 295, 3, NULL, 28, 3, 97),
(47, 6, NULL, 128, 7, NULL, 30, 11, 64),
(48, 8, NULL, 573, 7, NULL, 22, 1, 24),
(49, 9, NULL, 85, 9, NULL, 26, 2, 52),
(50, 0, NULL, 501, 3, NULL, 22, 9, 85),
(51, 4, NULL, 139, 8, NULL, 24, 7, 109),
(53, 9, NULL, 30, 5, NULL, 21, 2, 74),
(54, 1, NULL, 245, 5, NULL, 26, 5, 96),
(55, 9, NULL, 460, 9, NULL, 26, 2, 92),
(56, 4, NULL, 444, 1, NULL, 24, 3, 16),
(57, 3, NULL, 334, 8, NULL, 23, 4, 64),
(58, 5, NULL, 273, 2, NULL, 25, 9, 37),
(59, 10, NULL, 684, 2, NULL, 30, 1, 91),
(60, 1.4, NULL, 139.98, 2, NULL, 5, 0, 69.99),
(61, 1.4, NULL, 100, 1, NULL, 9, 0, 100),
(62, 1.4, NULL, 750.99, 1, NULL, 1, 0, 750.99),
(63, 1.4, NULL, 200, 2, NULL, 0, 8, 100),
(64, 1.4, NULL, 200, 2, NULL, 0, 9, 100),
(65, 1.4, NULL, 750.99, 1, NULL, 0, 1, 750.99),
(66, 1.4, NULL, 300, 3, NULL, NULL, 8, 100),
(67, 1.4, NULL, 1501.98, 2, NULL, NULL, 1, 750.99),
(68, 1.4, NULL, 750.99, 1, NULL, 45, 1, 750.99),
(69, 1.4, NULL, 13.3, 1, NULL, 45, 11, 13.3),
(70, 1.4, NULL, 139.98, 2, NULL, 46, 2, 69.99),
(71, 1.4, NULL, 100, 1, NULL, 46, 8, 100),
(72, 1.4, NULL, 26.6, 2, NULL, 47, 11, 13.3),
(73, 1.4, NULL, 26.6, 2, NULL, 48, 11, 13.3),
(74, 1.4, NULL, 26.6, 2, NULL, 49, 11, 13.3),
(75, 1.4, NULL, 26.6, 2, NULL, 50, 11, 13.3),
(76, 1.4, NULL, 69.99, 1, NULL, 50, 2, 69.99),
(77, 1.4, NULL, 1501.98, 2, NULL, 50, 1, 750.99),
(78, 1.4, NULL, 50.99, 1, NULL, 51, 6, 50.99),
(79, 1.4, NULL, 100, 1, NULL, 51, 9, 100),
(80, 1.4, NULL, 750.99, 1, NULL, 51, 1, 750.99),
(81, 1.4, NULL, 750.99, 1, NULL, 52, 1, 750.99),
(82, 1.4, NULL, 3003.96, 4, NULL, 53, 1, 750.99),
(83, 1.4, NULL, 69.99, 1, NULL, 53, 2, 69.99),
(84, 1.4, NULL, 69.99, 1, NULL, 54, 2, 69.99),
(85, 1.4, NULL, 50.99, 1, NULL, 54, 6, 50.99),
(87, 1.4, NULL, 69.99, 1, NULL, 64, 2, 69.99),
(88, 1.4, NULL, 1501.98, 2, NULL, 65, 1, 750.99),
(89, 1.4, NULL, 69.99, 1, NULL, 66, 2, 69.99),
(90, 1.4, NULL, 1501.98, 2, NULL, 67, 1, 750.99),
(91, 1.4, NULL, 26.6, 2, NULL, 68, 11, 13.3),
(92, 1.4, NULL, 1501.98, 2, NULL, 70, 1, 750.99),
(93, 1.4, NULL, 1501.98, 2, NULL, 71, 1, 750.99),
(94, 1.4, NULL, 1501.98, 2, NULL, 72, 1, 750.99),
(95, 1.4, NULL, 1501.98, 2, NULL, 73, 1, 750.99),
(96, 1.4, NULL, 1501.98, 2, NULL, 74, 1, 750.99),
(97, 1.4, NULL, 750.99, 1, NULL, 75, 1, 750.99),
(98, 1.4, NULL, 1501.98, 2, NULL, 76, 1, 750.99),
(99, 1.4, NULL, 1501.98, 2, NULL, 77, 1, 750.99),
(100, 1.4, NULL, 2252.9700000000003, 3, NULL, 78, 1, 750.99),
(101, 1.4, NULL, 1501.98, 2, NULL, 79, 1, 750.99),
(102, 1.4, NULL, 69.99, 1, NULL, 80, 5, 69.99),
(103, 1.4, NULL, 13.3, 1, NULL, 80, 11, 13.3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles_pedido_productos`
--

CREATE TABLE IF NOT EXISTS `detalles_pedido_productos` (
  `detalles_pedidos_id` int(11) NOT NULL,
  `productos_id` int(11) NOT NULL,
  PRIMARY KEY (`detalles_pedidos_id`,`productos_id`),
  UNIQUE KEY `UK_pfrblo40ho6ae1158axukt0lt` (`productos_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE IF NOT EXISTS `pedidos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `metodo_pago` varchar(255) DEFAULT NULL,
  `num_factura` varchar(255) DEFAULT NULL,
  `total` double NOT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5g0es69v35nmkmpi8uewbphs2` (`usuario_id`),
  KEY `FK4a0lfwlpmytywxpwjfa1a3ar2` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`id`, `estado`, `fecha`, `metodo_pago`, `num_factura`, `total`, `usuario_id`, `id_usuario`) VALUES
(21, 'cancelado', NULL, '2', NULL, 75, NULL, NULL),
(22, 'pendiente', NULL, '1', NULL, 2, NULL, NULL),
(23, 'pendiente', NULL, '1', NULL, 56, NULL, NULL),
(24, 'pendiente', NULL, '2', NULL, 42, NULL, NULL),
(25, 'pendiente', NULL, '1', NULL, 92, NULL, NULL),
(26, 'pendiente', NULL, '2', NULL, 53, NULL, NULL),
(27, 'pendiente', NULL, '2', NULL, 11, NULL, NULL),
(28, 'pendiente', NULL, '3', NULL, 17, NULL, NULL),
(29, 'pendiente', NULL, '3', NULL, 83, NULL, NULL),
(30, NULL, '2022-05-17 12:11:18', NULL, NULL, 11, NULL, NULL),
(31, 'Pendiente', '2022-05-17 16:25:40', 'tarjeta', '1', 4764.91, NULL, NULL),
(32, 'Pendiente', '2022-05-17 16:36:15', 'tarjeta', '1', 871.97, NULL, NULL),
(33, 'Pendiente', '2022-05-17 16:39:46', 'tarjeta', '1', 2070.9700000000003, NULL, NULL),
(34, 'Pendiente', '2022-05-17 16:42:51', 'tarjeta', '1', 3994.9299999999994, NULL, NULL),
(35, 'Pendiente', '2022-05-17 16:46:53', 'tarjeta', '1', 999.96, NULL, NULL),
(36, 'Pendiente', '2022-05-17 16:47:31', 'tarjeta', '1', 139.98, NULL, NULL),
(37, 'Pendiente', '2022-05-17 17:24:43', 'tarjeta', '1', 1751.97, NULL, NULL),
(38, 'Pendiente', '2022-05-17 17:25:23', 'tarjeta', '1', 1751.97, NULL, NULL),
(41, 'Pendiente', '2022-05-17 20:29:06', 'tarjeta', '1', 990.97, NULL, NULL),
(42, 'Pendiente', '2022-05-17 20:31:27', 'tarjeta', '1', 1150.99, NULL, NULL),
(43, 'Pendiente', '2022-05-17 20:36:55', 'tarjeta', '1', 300, NULL, NULL),
(44, 'cancelado', '2022-05-17 21:13:52', 'tarjeta', '1', 1501.98, NULL, 5),
(45, 'Pendiente', '2022-05-17 21:17:37', 'tarjeta', '1', 764.29, NULL, 5),
(46, 'Pendiente', '2022-05-18 12:10:44', 'Paypal', '1', 239.98, NULL, 5),
(47, 'Pendiente', '2022-05-18 12:14:37', 'Paypal', '1', 26.6, NULL, 5),
(48, 'Pendiente', '2022-05-18 12:16:11', 'Paypal', '1', 26.6, NULL, 5),
(49, 'Pendiente', '2022-05-18 12:19:39', 'Tarjeta', '1', 26.6, NULL, 5),
(50, 'Pendiente', '2022-05-18 12:22:55', 'Paypal', '1', 1598.57, NULL, 5),
(51, 'Pendiente', '2022-05-18 12:24:49', 'Paypal', '1', 901.98, NULL, 5),
(52, 'Pendiente', '2022-05-18 12:26:30', 'Tarjeta', '1', 750.99, NULL, 5),
(53, 'Pendiente', '2022-05-18 12:43:30', 'Paypal', '1', 3073.95, NULL, 5),
(54, 'Pendiente', '2022-05-18 12:54:51', 'Paypal', '1', 120.97999999999999, NULL, 5),
(55, 'Pendiente', '2022-05-18 14:03:58', 'Paypal', '1', 1501.98, NULL, NULL),
(56, 'Pendiente', '2022-05-18 14:06:56', 'Paypal', '1', 1501.98, NULL, NULL),
(57, 'Pendiente', '2022-05-18 14:07:31', 'Paypal', '1', 1501.98, NULL, NULL),
(58, 'Pendiente', '2022-05-18 14:09:39', 'Tarjeta', '1', 1501.98, NULL, NULL),
(59, 'Pendiente', '2022-05-18 14:12:49', 'Tarjeta', '1', 1501.98, NULL, NULL),
(60, 'Pendiente', '2022-05-18 14:19:04', 'Tarjeta', '1', 1501.98, NULL, NULL),
(61, 'Pendiente', '2022-05-18 14:29:01', 'Tarjeta', '1', 3003.96, NULL, NULL),
(62, 'Pendiente', '2022-05-18 14:33:21', 'Tarjeta', '1', 2422.96, NULL, 5),
(63, 'Pendiente', '2022-05-18 14:33:48', 'Tarjeta', '1', 2422.96, NULL, 5),
(64, 'Pendiente', '2022-05-18 14:37:58', 'Paypal', '1', 69.99, NULL, 5),
(65, 'Pendiente', '2022-05-20 14:28:31', 'Tarjeta', '1', 1501.98, NULL, NULL),
(66, 'Pendiente', '2022-05-21 11:29:16', 'Tarjeta', '1', 69.99, NULL, NULL),
(67, 'Pendiente', '2022-05-21 11:30:27', 'Paypal', '1', 1501.98, NULL, NULL),
(68, 'Pendiente', '2022-05-21 11:34:08', 'Paypal', '1', 26.6, NULL, NULL),
(69, 'Pendiente', '2022-05-21 11:34:53', 'Paypal', '1', 0, NULL, NULL),
(70, 'Pendiente', '2022-05-21 11:35:41', 'Tarjeta', '1', 1501.98, NULL, NULL),
(71, 'Pendiente', '2022-05-21 11:39:21', 'Paypal', '1', 1501.98, NULL, NULL),
(72, 'Pendiente', '2022-05-21 11:41:34', 'Paypal', '1', 1501.98, NULL, 5),
(73, 'Pendiente', '2022-05-21 11:43:27', 'Tarjeta', '1', 1501.98, NULL, 5),
(74, 'Pendiente', '2022-05-21 11:45:55', 'Tarjeta', '1', 1501.98, NULL, 5),
(75, 'Pendiente', '2022-05-21 11:46:21', 'Tarjeta', '1', 750.99, NULL, 5),
(76, 'Pendiente', '2022-05-21 11:48:00', 'Tarjeta', '1', 1501.98, NULL, 5),
(77, 'Pendiente', '2022-05-21 11:58:36', 'Tarjeta', '1', 1501.98, NULL, 5),
(78, 'cancelado', '2022-05-22 20:46:21', 'Paypal', '1', 2252.9700000000003, NULL, 6),
(79, 'Pendiente', '2022-05-22 20:49:48', 'Tarjeta', '1', 1501.98, NULL, 8),
(80, 'Pendiente', '2022-05-22 20:51:28', 'Tarjeta', '1', 83.28999999999999, NULL, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_categoria` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `fecha_alta` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `fecha_baja` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `impuesto` float DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_categoria` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `id_categoria`, `nombre`, `descripcion`, `precio`, `stock`, `fecha_alta`, `fecha_baja`, `impuesto`, `imagen`) VALUES
(1, 1, 'PS5', 'Consola de Ultima generacion de Sony', 750.99, 5, '2022-05-23 15:42:44', '2022-05-23 14:42:05', 1.4, '/assets/img.png'),
(2, 2, 'F1 2022', 'Juego de simulacion de carreras de F1', 69.99, 10, '2022-05-23 15:42:44', '2022-05-23 14:42:10', 1.4, '/assets/img.png'),
(3, 1, 'PC Gamer', 'Ordenador de Ultima generacion', 1750.99, 20, '2022-05-17 18:22:30', '2022-05-23 15:46:32', 1.4, '/assets/img.png'),
(4, 2, 'Saco boxeo', 'Saco donde podemos liberar craga de trabajo', 499.99, 30, '2022-05-17 18:22:30', '2022-05-23 15:46:53', 1.4, '/assets/img.png'),
(5, 2, 'Bici de montaña', 'Bici para subir cualquier montaña', 69.99, 40, '2022-05-17 18:22:30', '2022-05-23 20:01:32', 1.4, '/assets/img.png'),
(6, 2, 'Cortasetos', 'Corta los setos con esta herramienta', 50.99, 20, '2022-05-17 18:22:30', '2022-05-23 20:02:45', 1.4, '/assets/img.png'),
(7, NULL, 'Taladro', 'Mejor taladro del mundo', 249.99, 20, '2022-05-17 18:22:30', '0000-00-00 00:00:00', 1.4, '/assets/img.png'),
(8, 1, 'cable link', 'Descripcion 1', 100, 5, '2022-05-23 13:43:51', '2022-05-23 13:43:51', 1.4, '/assets/img.png'),
(9, 1, 'ninvento', 'Descripcion 1', 100, 2, '2022-05-23 13:44:08', '2022-05-23 13:44:08', 1.4, '/assets/img.png'),
(11, NULL, 'chaqueta', 'dfa', 10, 3, '2022-05-23 13:42:19', '2022-05-23 13:42:19', 1.4, '/assets/img.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `rol`) VALUES
(1, 'admin'),
(2, 'user'),
(3, 'guest'),
(18, 'emp'),
(19, 'emp');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_rol` int(11) DEFAULT 1,
  `email` varchar(255) DEFAULT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido1` varchar(255) DEFAULT NULL,
  `apellido2` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `provincia` varchar(255) DEFAULT NULL,
  `localidad` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3kl77pehgupicftwfreqnjkll` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `id_rol`, `email`, `clave`, `nombre`, `apellido1`, `apellido2`, `direccion`, `provincia`, `localidad`, `telefono`, `dni`) VALUES
(4, 3, 'cpellico@serbatic.es', '1UocYQErUlLz3eo5DTsC6eI9hgoIkzVDTu3N0SqE0TKpxkKANjG6ZkD2HqVJvM1l', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 2, 'admin', NULL, 'carlos', 'pellico', 'feijoo', '', '', '', '', ''),
(6, 2, 'car', NULL, 'carlos', 'pellico', 'feijoo', '', '', '', '', ''),
(8, 1, 'admin@admin.com', 'xQ2xqQsihjr9XPRFvbnNpCX8jPWSu35Rzj9m0gdkRmEIhpMeGGI+BEKYEX/90Dx8', 'carlos', 'pellico', 'feijoo', '', '', '', '', ''),
(9, 18, 'emp@emp.com', '7kmKpMQMGSvTSQQ0MwH8b8nyqM2lmCNQVYkFdd4sAovugEIAg05WGpE/fCI3UCPy', '', '', '', '', '', '', '', '');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalles_pedido`
--
ALTER TABLE `detalles_pedido`
  ADD CONSTRAINT `FKp1htob4rs7mhp73s6m69abuv6` FOREIGN KEY (`pedidos_id`) REFERENCES `pedidos` (`id`);

--
-- Filtros para la tabla `detalles_pedido_productos`
--
ALTER TABLE `detalles_pedido_productos`
  ADD CONSTRAINT `FKex87glpaaq67qip90o1jk4r3e` FOREIGN KEY (`detalles_pedidos_id`) REFERENCES `detalles_pedido` (`id`),
  ADD CONSTRAINT `FKhxg26kl3qnny7pg10oaivk7qh` FOREIGN KEY (`productos_id`) REFERENCES `productos` (`id`);

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `FK5g0es69v35nmkmpi8uewbphs2` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
