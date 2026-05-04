import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOexception;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String nombre = request.getParameter("usuario");
        String password = request.getParameter("password");

        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = dao.login(nombre, password);

        if (u != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", u);

            response.sendRedirect("estado-incidencias");
        } else {
            response.sendRedirect("login.html?error=1");
        }
    }
}