package com.gestorincidencias.dao;

import com.gestorincidencias.model.Usuario;
import com.gestorincidencias.util.Conexion;
import com.gestorincidencias.util.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public Usuario login(String nombre, String password) {

        String sql =
                "SELECT id, nombre, rol " +
                        "FROM usuarios " +
                        "WHERE nombre = ? AND contrasena_hash = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.println("PASSWORD RAW: [" + password + "]");
            System.out.println("HASH GENERADO: " + PasswordUtil.sha256(password));

            ps.setString(1, nombre.trim());
            ps.setString(2, PasswordUtil.sha256(password.trim()));

            ResultSet rs = ps.executeQuery();


            if (rs.next()) {

                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setRol(rs.getInt("rol"));

                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}