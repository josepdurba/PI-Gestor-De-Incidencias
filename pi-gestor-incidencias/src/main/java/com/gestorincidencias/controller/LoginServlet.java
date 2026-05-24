package com.gestorincidencias.controller;

import com.gestorincidencias.dao.UsuarioDAO;
import com.gestorincidencias.model.Usuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // 📥 Parámetros del formulario
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");

        // 🧼 Normalización básica
        if (nombre != null) nombre = nombre.trim();
        if (password != null) password = password.trim();

        // ❌ Validación de campos vacíos
        if (nombre == null || password == null ||
                nombre.isEmpty() || password.isEmpty()) {

            response.sendRedirect("login.html?error=vacio");
            return;
        }

        // 🧠 Lógica delegada al DAO
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = dao.login(nombre, password);

        // 🔐 Control de acceso
        if (u != null) {

            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", u);

            response.sendRedirect("incidencias.html");

        } else {

            response.sendRedirect("login.html?error=1");
        }
    }
}