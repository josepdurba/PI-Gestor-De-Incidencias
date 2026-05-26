# 🛠️ Gestor de Incidencias

Aplicación web desarrollada en **Java con Jakarta Servlets** y **MySQL**, que permite gestionar incidencias dentro de un sistema con autenticación de usuarios y control de roles.

Los usuarios pueden crear y consultar incidencias, mientras que los administradores pueden gestionarlas y actualizar su estado.

---

## 🧰 Tecnologías utilizadas

- Java 17+
- Jakarta Servlets (Tomcat 10+)
- MySQL
- JDBC
- Maven
- JSP / HTML / CSS

---

## 🎯 Funcionalidades

### 👤 Usuarios
- Login de usuarios
- Creación de incidencias
- Consulta de incidencias propias

### 🛠️ Administrador / Técnico
- Visualización de todas las incidencias
- Cambio de estado de incidencias
- Gestión general del sistema

---

## 🏗️ Arquitectura del proyecto (MVC)

El proyecto sigue el patrón **Modelo-Vista-Controlador**:

- **Model:** Clases POJO (`Usuario`, `Incidencia`, `IncidenciaView`).
- **DAO:** Acceso a la base de datos mediante JDBC.
- **Controller:** Servlets que manejan la lógica de control.
- **Util:** Conexión a la base de datos y utilidades (hash de contraseñas SHA-256).

---

## 📁 Estructura del proyecto

```text
src/
 ├─ main/
 │    ├─ java/com/gestorIncidencias/
 │    │    ├─ controller/
 │    │    ├─ dao/
 │    │    ├─ model/
 │    │    └─ util/
 │    │
 │    └─ webapp/
 │         ├─ assets/
 │         │    └─ img/
 │         ├─ css/
 │         └─ js/
 │
 └─ test/java/com/gestorIncidencias/
      ├─ dao/
      ├─ model/
      └─ util/
```

---

## 📦 Requisitos

Para ejecutar el proyecto necesitas:

- JDK 17 o superior
- Apache Tomcat 10+
- MySQL Server
- Maven
- IDE compatible (IntelliJ, Eclipse o VSCode)

---

## ⚙️ Instalación y configuración

### 1. Crear la base de datos
Ejecuta el siguiente comando en tu gestor de MySQL:
```sql
CREATE DATABASE pi_gestor_incidencias;
USE pi_gestor_incidencias;
```

### 2. Crear las tablas
```sql
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `contrasena_hash` varchar(64) DEFAULT NULL,
  `rol` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;

CREATE TABLE IF NOT EXISTS `estados` (
  `id` int NOT NULL AUTO_INCREMENT,
  `estado` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
```

### 3. Insertar datos iniciales
```sql
INSERT INTO `estados` (`id`, `estado`) VALUES
	(1, 'Abierta'),
	(2, 'En proceso'),
	(3, 'Resuelta');

INSERT INTO `usuarios` (`id`, `nombre`, `contrasena_hash`, `rol`)
VALUES (1, 'Paco', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 1);
```

### 4. Configurar la conexión a la base de datos
Modifica las credenciales en la clase de utilidad de conexión:

**Archivo:** `src/main/java/com/gestorincidencias/util/Conexion.java`
```java
private static final String URL = "jdbc:mysql://localhost:3306/pi_gestor_incidencias";
private static final String USER = "root";
private static final String PASSWORD = "1234";
```

## 🧪 Testing

El proyecto incluye pruebas unitarias automatizadas con **JUnit 5**:

- **✔ Model:** Verificación de getters y setters.
- **✔ Util:** Hash SHA-256 (`PasswordUtil`).
- **✔ DAO:** Listado de incidencias y login de usuario (casos correctos e incorrectos).

Para ejecutar los tests, utiliza el siguiente comando:
```bash
mvn test
```

---

## 🔐 Seguridad

- Contraseñas encriptadas en la base de datos mediante **SHA-256**.
- Validación de inicio de sesión mediante comparación de hashes.
- Control de acceso y restricción de vistas basado en **roles de usuario**.

---

## 👤 Autor

Proyecto desarrollado como práctica para el ciclo de **DAW (Desarrollo de Aplicaciones Web)**.