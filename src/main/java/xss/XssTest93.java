package xss;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class XssTest93{
    private HttpServletRequest request;
    private HttpServletResponse response;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        unsafe(request.getParameter("name"), "<div <style>color:");
    }

    private void unsafe(String name, String prefix) {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.write("<br><br>Unsafe CSS style attribute context:<br>");
            out.write( prefix + name + "<style>>");
            out.write("<h1>TEXT</h1>");
            out.write("</div>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}