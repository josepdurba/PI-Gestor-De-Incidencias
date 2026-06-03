package com.gestorincidencias.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.gestorincidencias.model.Usuario;

class UsuarioTest {

    @Test
    void testGettersSetters() {

        Usuario u = new Usuario();

        u.setId(1);
        u.setRol(2);
        u.setNombre("admin");
        u.setPassword("1234");

        assertEquals(1, u.getId());
        assertEquals(2, u.getRol());
        assertEquals("admin", u.getNombre());
        assertEquals("1234", u.getPassword());
    }
}