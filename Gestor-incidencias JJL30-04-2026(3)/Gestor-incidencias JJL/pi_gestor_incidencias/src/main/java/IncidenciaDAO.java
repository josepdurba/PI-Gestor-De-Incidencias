import java.sql.*;

public class IncidenciaDAO {

    // CREATE
    public void insertar(Incidencia i) {

        String sql = "INSERT INTO incidencias (dni, fecha, descripcion, observaciones, fk_usuario, fk_estado) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1,i.getDni());
            ps.setString(2, i.getFecha());
            ps.setString(3, i.getDescripcion());
            ps.setString(4, i.getObservaciones());
            ps.setInt(5, i.getFkUsuario());
            ps.setInt(6, i.getFkEstado());

            ps.executeUpdate();
            System.out.println("Incidencia creada");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // READ
    public void listar() {

        String sql =
            "SELECT i.dni, i.descripcion, u.nombre, e.estado" +
            "FROM incidencias i" +
            "JOIN usuarios u ON i.fk_usuario = u.id" +
            "JOIN estados e ON i.fk_estado = e.id";

        try (Connection con = Conexion.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("descripcion") + " - " +
                                rs.getString("nombre") + " - " +
                                rs.getString("estado")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // UPDATE
    public void actualizarEstado(int id, int estado) {

        String sql = "UPDATE incidencias SET fk_estado=? WHERE id=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, estado);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Actualizada");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // DELETE
    public void eliminar(int id) {

        String sql = "DELETE FROM incidencias WHERE id=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Eliminada");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}