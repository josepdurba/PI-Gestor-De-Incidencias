import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/estado-incidencias")
public class EstadoIncidenciasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Incidencia> incidencias = new ArrayList<>();

        String sql =
            "SELECT i.dni, i.fecha, e.estado " +
            "FROM incidencias i " +
            "JOIN estados e ON i.fk_estado = e.id";

        try (Connection con = Conexion.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Incidencia incidencia = new Incidencia(
                        rs.getString("dni"),
                        rs.getString("fecha"),
                        rs.getString("estado")
                );

                incidencias.add(incidencia);
            }

        } catch (SQLException e) {
            throw new ServletException("Error al obtener las incidencias", e);
        }

        request.setAttribute("incidencias", incidencias);

        request.getRequestDispatcher("estado-incidencias.jsp")
                .forward(request, response);
    }
}