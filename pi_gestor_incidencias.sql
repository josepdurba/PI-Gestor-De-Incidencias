-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         9.4.0 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.11.0.7065
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para pi_gestor_incidencias
CREATE DATABASE IF NOT EXISTS `pi_gestor_incidencias` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pi_gestor_incidencias`;

-- Volcando estructura para tabla pi_gestor_incidencias.estados
CREATE TABLE IF NOT EXISTS `estados` (
  `id` int NOT NULL AUTO_INCREMENT,
  `estado` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla pi_gestor_incidencias.estados: ~3 rows (aproximadamente)
INSERT INTO `estados` (`id`, `estado`) VALUES
	(1, 'Abierta'),
	(2, 'En proceso'),
	(3, 'Resuelta');

-- Volcando estructura para tabla pi_gestor_incidencias.incidencias
CREATE TABLE IF NOT EXISTS `incidencias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fk_estado` int NOT NULL,
  `fk_usuario` int NOT NULL,
  `descripcion` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `observaciones` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_incidencias_estado_idx` (`fk_estado`),
  KEY `fk_incidencias_Usuario1_idx` (`fk_usuario`),
  CONSTRAINT `fk_incidencias_estado` FOREIGN KEY (`fk_estado`) REFERENCES `estados` (`id`),
  CONSTRAINT `fk_incidencias_Usuario1` FOREIGN KEY (`fk_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla pi_gestor_incidencias.incidencias: ~10 rows (aproximadamente)
INSERT INTO `incidencias` (`id`, `fk_estado`, `fk_usuario`, `descripcion`, `observaciones`, `fecha`) VALUES
	(1, 1, 9, 'Incidencia de sistema 36', 'Observación automática', '2026-01-28'),
	(2, 2, 1, 'Incidencia de sistema 269', 'Observación automática', '2026-02-19'),
	(3, 3, 6, 'Incidencia de sistema 344', 'Observación automática', '2026-02-13'),
	(4, 2, 4, 'Incidencia de sistema 467', 'Observación automática', '2026-02-09'),
	(5, 3, 3, 'Incidencia de sistema 505', 'Observación automática', '2026-02-01'),
	(6, 1, 10, 'Incidencia de sistema 556', 'Observación automática', '2026-02-16'),
	(7, 2, 4, 'Incidencia de sistema 833', 'Observación automática', '2026-02-19'),
	(8, 1, 8, 'Incidencia de sistema 726', 'Observación automática', '2026-02-06'),
	(9, 3, 3, 'Incidencia de sistema 817', 'Observación automática', '2026-02-13'),
	(10, 1, 4, 'Incidencia de sistema 634', 'Observación automática', '2026-02-14');

-- Volcando estructura para tabla pi_gestor_incidencias.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `DNI` varchar(9) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `tlf` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `contrasena_hash` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `DNI_UNIQUE` (`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla pi_gestor_incidencias.usuarios: ~11 rows (aproximadamente)
INSERT INTO `usuarios` (`id`, `DNI`, `nombre`, `apellido`, `tlf`, `email`, `contrasena_hash`) VALUES
	(1, '12345678T', 'Paco', 'Rodriguez Rodriguez', '619546987', 'paco.rodriguez@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
	(2, '33951440J', 'Sara', 'García López ', '626252229', 'sara.garcia@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
	(3, '39296239A', 'Luz', 'Martínez Ruiz', '687785187', 'luz.martinez@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
	(4, '84626880J', 'Gemma', 'Fernández Gómez', '781648527', 'gemma.fernandez@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
	(5, '25245687J', 'Aitor', 'Sánchez Pérez', '641255356', 'aitor.sanchez@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
	(6, '42347798Z', 'Carlos', 'Rodríguez Martín', '749015047', 'carlos.rodriguez@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
	(7, '36001930F', 'Roberto', 'López Torres', '619987728', 'roberto.lopez@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
	(8, '42966261F', 'Antonio', 'Díaz Navarro', '628631439', 'antonio.diaz@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
	(9, '96825516R', 'Leo', 'Romero Castillo', '694107814', 'leo.romero@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
	(10, '75228802B', 'Clara', 'Morales Herrera', '690365552', 'clara.morales@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
	(11, '75667465H', 'Vega', 'Jiménez Serrano', '659975186', 'vega.jimenez@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
