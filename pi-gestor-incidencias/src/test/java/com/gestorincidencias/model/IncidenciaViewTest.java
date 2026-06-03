package com.gestorincidencias.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.gestorincidencias.model.IncidenciaView;

class IncidenciaViewTest {

    @Test
    void testGettersSetters() {

        IncidenciaView view = new IncidenciaView();

        view.setId(1);
        view.setDescripcion("Error login");
        view.setFecha("2026-01-01");
        view.setEstado("Pendiente");

        assertEquals(1, view.getId());
        assertEquals("Error login", view.getDescripcion());
        assertEquals("2026-01-01", view.getFecha());
        assertEquals("Pendiente", view.getEstado());
    }
}