import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.gestorincidencias.util.PasswordUtil;

class PasswordUtilTest {

    // 1. No debe devolver null
    @Test
    void testHashNotNull() {
        String result = PasswordUtil.sha256("hola");

        assertNotNull(result);
    }

    // 2. Misma entrada = mismo hash (determinista)
    @Test
    void testHashDeterminista() {
        String pass = "hola";

        String hash1 = PasswordUtil.sha256(pass);
        String hash2 = PasswordUtil.sha256(pass);

        assertEquals(hash1, hash2);
    }

    // 3. Diferentes entradas = hashes diferentes
    @Test
    void testHashDiferente() {
        String hash1 = PasswordUtil.sha256("hola");
        String hash2 = PasswordUtil.sha256("adios");

        assertNotEquals(hash1, hash2);
    }
}