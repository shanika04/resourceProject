package xss;
import org.owasp.encoder.Encode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class XssTest1 {

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
            out.write("<br><br>Unsafe unquoted attribute with bad sanitizer:<br>");
            out.write("<button value=" + Encode.forHtmlAttribute(name) + ">Unsafe unquoted attribute with bad sanitizer</button>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
