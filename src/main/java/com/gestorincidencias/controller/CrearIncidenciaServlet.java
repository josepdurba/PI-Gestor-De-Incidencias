package com.gestorincidencias.controller;

import com.gestorincidencias.dao.IncidenciaDAO;
import com.gestorincidencias.model.Incidencia;
import com.gestorincidencias.model.Usuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/crear-incidencia")
public class CrearIncidenciaServlet extends HttpServlet {

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

        String descripcion = request.getParameter("descripcion");
        String observaciones = request.getParameter("observaciones");

        Incidencia incidencia = new Incidencia();

        incidencia.setDescripcion(descripcion);
        incidencia.setObservaciones(observaciones);

        // usuario logueado
        incidencia.setFkUsuario(u.getId());

        // estado inicial
        incidencia.setFkEstado(1);

        // ❌ NO fecha (la BD la genera)

        IncidenciaDAO dao = new IncidenciaDAO();
        dao.insertar(incidencia);

        response.sendRedirect("estado-incidencias");
    }
}