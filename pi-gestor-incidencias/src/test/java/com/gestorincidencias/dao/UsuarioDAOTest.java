package com.gestorincidencias.dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.gestorincidencias.model.Usuario;

class UsuarioDAOTest {

    UsuarioDAO dao = new UsuarioDAO();

    @Test
    void testLoginCorrecto() {

        Usuario u = dao.login("Paco", "1234");

        assertNotNull(u);
        assertEquals("Paco", u.getNombre());
        assertTrue(u.getId() > 0);
    }

    @Test
    void testLoginIncorrecto() {

        Usuario u = dao.login("Paco", "password_falsa");

        assertNull(u);
    }
}