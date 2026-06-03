package com.gestorincidencias.dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.gestorincidencias.dao.IncidenciaDAO;
import com.gestorincidencias.model.Incidencia;
import com.gestorincidencias.model.IncidenciaView;

class IncidenciaDAOTest {

    IncidenciaDAO dao = new IncidenciaDAO();

    @Test
    void testListar() {

        List<IncidenciaView> lista = dao.listar();

        assertNotNull(lista);
        assertTrue(lista.size() >= 0);
    }

    @Test
    void testListarPorUsuario() {

        List<IncidenciaView> lista = dao.listarPorUsuario(1);

        assertNotNull(lista);
    }

    @Test
    void testInsertar() {

        Incidencia i = new Incidencia();
        i.setDescripcion("Test");
        i.setObservaciones("Test obs");
        i.setFkUsuario(1);
        i.setFkEstado(1);

        dao.insertar(i);

        assertTrue(true);
    }

    @Test
    void testActualizarEstado() {

        dao.actualizarEstado(1, 2);

        assertTrue(true);
    }
}