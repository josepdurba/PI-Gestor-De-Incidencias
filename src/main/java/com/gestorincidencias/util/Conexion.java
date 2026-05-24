package com.gestorincidencias.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // 🔗 configuración de BD
    private static final String URL =
            "jdbc:mysql://localhost:3306/pi_gestor_incidencias";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    // 🧠 conexión única
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}