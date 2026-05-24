package com.gestorincidencias.controller;

import com.gestorincidencias.dao.IncidenciaDAO;
import com.gestorincidencias.model.IncidenciaView;
import com.gestorincidencias.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/estado-incidencias")
public class EstadoIncidenciasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔐 control de sesión
        HttpSession session = request.getSession(false);
        Usuario u = (session != null)
                ? (Usuario) session.getAttribute("usuario")
                : null;

        if (u == null) {
            response.sendRedirect("login.html");
            return;
        }

        // 📦 DAO
        IncidenciaDAO dao = new IncidenciaDAO();

        // 📥 datos ya preparados para la vista
        List<IncidenciaView> incidencias;
        if (u.getRol() == 1) {
            incidencias = dao.listar();
        } else {
            incidencias = dao.listarPorUsuario(u.getId());
        }

        // 📤 enviar a JSP
        request.setAttribute("incidencias", incidencias);

        request.getRequestDispatcher("estado-incidencias.jsp")
                .forward(request, response);
    }
}