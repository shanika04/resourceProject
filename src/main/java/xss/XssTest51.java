package xss;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class XssTest51 {
    HttpServletRequest request;
    HttpServletResponse response;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        String name = request.getParameter("name");
        unsafe(name);
    }

    private void unsafe(String name) {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.write("<br><br>Unsafe unquoted attribute with bad sanitizer:<br>");
//            out.write("<button value=" + Encode.forHtmlAttribute(name) + ">Unsafe unquoted attribute with bad sanitizer</button>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}