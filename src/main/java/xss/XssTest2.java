package xss;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class XssTest2 {

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
            out.println("<br><br><h1 align=center><font color=\"red\">Unsafe Javascript Block context:<br></font></h1>");
            out.println("<script type=\"text/javascript\">");
            out.println("function changeText() { document.getElementById('foo').innerHTML = \"" + name + "\"; }");
            out.println("</script>");
            out.println("<div id=\"foo\">old text</div>");
            out.println("<a onclick=\"changeText();\">");
            out.println("Click me</a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
