import java.sql.*;

public class Conexion {
    public static Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/pi_gestor_incidencias";
        String user = "root";
        String password = "1234";

        return DriverManager.getConnection(url, user, password);
    }
}