package com.gestorincidencias.controller;

//import com.gestorincidencias.dao.UsuarioDAO;
import com.gestorincidencias.model.Usuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // 📥 datos del formulario (alineados con login.html)
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");

        // 🧠 validación mínima backend
        if (nombre == null || password == null ||
                nombre.trim().isEmpty() || password.trim().isEmpty()) {

            response.sendRedirect("login.html?error=vacio");
            return;
        }

        // 📦 DAO
     //   UsuarioDAO dao = new UsuarioDAO();
     //  Usuario u = dao.login(nombre.trim(), password);

        // 🔐 autenticación 

    /*if (u != null) {
        HttpSession session = request.getSession(true);
        session.setAttribute("usuario", u);

        response.sendRedirect("incidencias.html");*/

        if(nombre.equals("test") && password.equals("1234")){
            
             Usuario us = new Usuario();
             us.setId(1);
             us.setNombre("test");
             us.setPassword("1234");
             us.setRol(1);


            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", us);
            response.sendRedirect("incidencias.html");

        } else {

            // ❌ login incorrecto
            response.sendRedirect("login.html?error=1");
        }
    }
}