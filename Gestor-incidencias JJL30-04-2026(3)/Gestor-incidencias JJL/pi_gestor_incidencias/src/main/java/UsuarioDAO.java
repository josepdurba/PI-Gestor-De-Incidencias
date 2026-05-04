public class UsuarioDAO {

    public Usuario login(String nombre, String password) {
        String sql = "SELECT * FROM usuarios WHERE nombre=? AND password=?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Usuario u = new Usuario();
                u.setNombre(rs.getString("nombre"));
                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}