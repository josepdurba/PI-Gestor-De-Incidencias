import com.gestorincidencias.dao.IncidenciaDAO;
import com.gestorincidencias.util.PasswordUtil;

public class Main {
    public static void main(String[] args) {

        System.out.println(PasswordUtil.sha256("1234"));
    }
}
