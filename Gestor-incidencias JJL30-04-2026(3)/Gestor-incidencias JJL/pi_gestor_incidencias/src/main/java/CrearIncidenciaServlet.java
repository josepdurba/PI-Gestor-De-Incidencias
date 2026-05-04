import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/crear-incidencia")
public class CrearIncidenciaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String dni = request.getParameter("dni");
        String fecha = request.getParameter("fecha");
        String descripcion = request.getParameter("descripcion");
        String observaciones = request.getParameter("observaciones");

        Incidencia incidencia = new Incidencia();
        incidencia.setDni(dni);
        incidencia.setFecha(fecha);
        incidencia.setDescripcion(descripcion);
        incidencia.setObservaciones(observaciones);
        incidencia.setFkUsuario(1);
        incidencia.setFkEstado(1);

        IncidenciaDAO dao = new IncidenciaDAO();
        dao.insertar(incidencia);

        response.sendRedirect("estado-incidencias");
    }
}