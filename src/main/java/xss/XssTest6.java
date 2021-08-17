package xss;
import org.owasp.encoder.Encode;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class XssTest6 {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        unsafe(request, response);
    }

    private void unsafe(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.write("<html>");
            out.write("<head>");
            out.write("<style>");
            out.write("h1 {background-image: url(\"" + name + "\");}");
            out.write("</style>");
            out.write("</head>");
            out.write("<body>");
            out.write("<br><br>Unsafe CSS style block url context:<br>");
            out.write("<h1>" + Encode.forHtml(name) + "</h1>");
            out.write("</body>");
            out.write("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
