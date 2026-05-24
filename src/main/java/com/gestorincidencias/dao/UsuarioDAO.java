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

            ps.setString(1, nombre);

            // 🔐 AQUÍ ESTÁ EL CAMBIO IMPORTANTE
            String hash = PasswordUtil.sha256(password);
            ps.setString(2, hash);

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