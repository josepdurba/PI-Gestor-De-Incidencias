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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla pi_gestor_incidencias.estados: ~4 rows (aproximadamente)
DELETE FROM `estados`;
INSERT INTO `estados` (`id`, `estado`) VALUES
	(1, 'Abierta'),
	(2, 'En proceso'),
	(3, 'Resuelta'),
	(4, 'Cerrada');

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla pi_gestor_incidencias.incidencias: ~14 rows (aproximadamente)
DELETE FROM `incidencias`;
INSERT INTO `incidencias` (`id`, `fk_estado`, `fk_usuario`, `descripcion`, `observaciones`, `fecha`) VALUES
	(1, 2, 9, 'Incidencia de sistema 36', 'Observación automática', '2026-01-28'),
	(2, 2, 1, 'Incidencia de sistema 269', 'Observación automática', '2026-02-19'),
	(3, 3, 6, 'Incidencia de sistema 344', 'Observación automática', '2026-02-13'),
	(4, 2, 4, 'Incidencia de sistema 467', 'Observación automática', '2026-02-09'),
	(5, 3, 3, 'Incidencia de sistema 505', 'Observación automática', '2026-02-01'),
	(6, 1, 10, 'Incidencia de sistema 556', 'Observación automática', '2026-02-16'),
	(7, 2, 4, 'Incidencia de sistema 833', 'Observación automática', '2026-02-19'),
	(8, 1, 8, 'Incidencia de sistema 726', 'Observación automática', '2026-02-06'),
	(9, 3, 3, 'Incidencia de sistema 817', 'Observación automática', '2026-02-13'),
	(10, 1, 4, 'Incidencia de sistema 634', 'Observación automática', '2026-02-14'),
	(11, 1, 1, 'Hola, prueba de que esto funciona', '1234412412421412', '2026-05-24'),
	(12, 3, 2, 'Prueba de usuario comun', 'A ver si esta se ve', '2026-05-24'),
	(13, 1, 2, 'Hola esto funciona', 'Esto funciona?\r\n', '2026-05-29'),
	(14, 1, 1, 'Test', 'Test obs', '2026-06-03');

-- Volcando estructura para tabla pi_gestor_incidencias.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `contrasena_hash` varchar(64) DEFAULT NULL,
  `rol` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla pi_gestor_incidencias.usuarios: ~11 rows (aproximadamente)
DELETE FROM `usuarios`;
INSERT INTO `usuarios` (`id`, `nombre`, `contrasena_hash`, `rol`) VALUES
	(1, 'Paco', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 1),
	(2, 'Sara', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
	(3, 'Luz', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
	(4, 'Gemma', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
	(5, 'Aitor', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
	(6, 'Carlos', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
	(7, 'Roberto', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
	(8, 'Antonio', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
	(9, 'Leo', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
	(10, 'Clara', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
	(11, 'Vega', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
