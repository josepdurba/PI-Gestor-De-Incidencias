package com.gestorincidencias.controller;

import com.gestorincidencias.dao.IncidenciaDAO;
import com.gestorincidencias.model.Usuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/modificar-estado")
public class ModificarEstadoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);
        Usuario u = (session != null)
                ? (Usuario) session.getAttribute("usuario")
                : null;

        if (u == null) {
            response.sendRedirect("login.html");
            return;
        }

        if (u.getRol() != 1) {
            response.sendRedirect("estado-incidencias");
            return;
        }

        int idIncidencia = Integer.parseInt(request.getParameter("idIncidencia"));
        int nuevoEstado = Integer.parseInt(request.getParameter("nuevoEstado"));

        IncidenciaDAO dao = new IncidenciaDAO();
        dao.actualizarEstado(idIncidencia, nuevoEstado);

        response.sendRedirect("estado-incidencias");
    }
}