import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.gestorincidencias.model.Incidencia;
import java.time.LocalDate;

class IncidenciaTest {

    @Test
    void testGettersSetters() {

        Incidencia i = new Incidencia();

        i.setId(1);
        i.setDescripcion("Error login");
        i.setObservaciones("No funciona el botón");
        i.setFkUsuario(10);
        i.setFkEstado(2);

        LocalDate fecha = LocalDate.of(2026, 1, 1);
        i.setFecha(fecha);

        assertEquals(1, i.getId());
        assertEquals("Error login", i.getDescripcion());
        assertEquals("No funciona el botón", i.getObservaciones());
        assertEquals(10, i.getFkUsuario());
        assertEquals(2, i.getFkEstado());
        assertEquals(fecha, i.getFecha());
    }
}