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

## 🏗️ Arquitectura del proyecto

El proyecto sigue el patrón **MVC**:

- **Model** → Clases POJO (Usuario, Incidencia, IncidenciaView)
- **DAO** → Acceso a base de datos (JDBC)
- **Controller** → Servlets (lógica de control)
- **Util** → Conexión a BD y utilidades (hash de contraseñas)

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

Ejecuta en MySQL:

```sql
CREATE DATABASE pi_gestor_incidencias;