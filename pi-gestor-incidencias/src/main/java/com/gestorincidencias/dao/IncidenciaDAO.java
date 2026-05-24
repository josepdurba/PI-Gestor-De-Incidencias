package com.gestorincidencias.dao;

import com.gestorincidencias.model.Incidencia;
import com.gestorincidencias.model.IncidenciaView;
import com.gestorincidencias.util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncidenciaDAO {

    // =========================
    // CREATE (SIN FECHA)
    // =========================
    public void insertar(Incidencia i) {

        String sql = "INSERT INTO incidencias " +
                "(descripcion, observaciones, fk_usuario, fk_estado, fecha) " +
                "VALUES (?, ?, ?, ?, CURRENT_DATE)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, i.getDescripcion());
            ps.setString(2, i.getObservaciones());
            ps.setInt(3, i.getFkUsuario());
            ps.setInt(4, i.getFkEstado());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // UPDATE ESTADO
    // =========================
    public void actualizarEstado(int idIncidencia, int nuevoEstado) {
        
        String sql = "UPDATE incidencias SET fk_estado = ? WHERE id = ?";
        
        try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, nuevoEstado);
            ps.setInt(2, idIncidencia);
            
            ps.executeUpdate();
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // =========================
    // LISTAR TODAS (TECNICO)
    // =========================
    public List<IncidenciaView> listar() {

        List<IncidenciaView> lista = new ArrayList<>();

        String sql =
                "SELECT i.id, i.fecha, i.descripcion, e.estado " +
                        "FROM incidencias i " +
                        "JOIN estados e ON i.fk_estado = e.id " +
                        "ORDER BY i.id DESC";

        try (Connection con = Conexion.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Date fechaSql = rs.getDate("fecha");

                String fecha = (fechaSql != null)
                        ? fechaSql.toString()
                        : "Sin fecha";

                IncidenciaView view = new IncidenciaView(
                    rs.getInt("id"),
                    rs.getString("descripcion"),
                    fecha,
                    rs.getString("estado")
                );

                lista.add(view);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lista;
    }


// LISTAR SOLO DEL USUARIO
    public List<IncidenciaView> listarPorUsuario(int idUsuario) {

        List<IncidenciaView> lista = new ArrayList<>();

        String sql =
                "SELECT i.id, i.fecha, i.descripcion, e.estado " +
                "FROM incidencias i " +
                "JOIN estados e ON i.fk_estado = e.id " +
                "WHERE i.fk_usuario = ? " +
                "ORDER BY i.id DESC";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Date fechaSql = rs.getDate("fecha");

                String fecha = (fechaSql != null)
                        ? fechaSql.toString()
                        : "Sin fecha";

                IncidenciaView view = new IncidenciaView(
                        rs.getInt("id"),
                        rs.getString("descripcion"),
                        fecha,
                        rs.getString("estado")
                );

                lista.add(view);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}