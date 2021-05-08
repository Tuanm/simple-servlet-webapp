import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "App", urlPatterns = "/")
public class App extends HttpServlet {
    private static final String JSP_HOME = "index.jsp";
    private static final String JSP_ABOUT = "about.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsp = "";
        switch (request.getRequestURI()) {
            case "/about":
                jsp = JSP_ABOUT;
                break;
            default:
                jsp = JSP_HOME;
        }
        request.getRequestDispatcher(jsp)
                .forward(request, response);
    }
}
