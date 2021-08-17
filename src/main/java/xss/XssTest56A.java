package xss;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class XssTest56A {
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
            out.write("<br><br><h1 align=center><font color=\"red\">Unsafe Javascript Block context:<br></font></h1>");
            out.write("<script type=\"text/javascript\">");
            out.write("function changeText() { document.getElementById('foo').innerHTML = \"" + name + "\"; }");
            out.write("</script>");
            out.write("<div id=\"foo\">old text</div>");
            out.write("<a onclick=\"changeText();\">");
            out.write("Click me</a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void safe(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.println("<br><br><h1 align=center><font color=\"green\">Safe Javascript Block context:<br></font></h1>");
//            out.println("<script type=\"text/javascript\">");
//            out.println("function changeText1() { document.getElementById('foo1').innerHTML = \"" + Encode.forJavaScriptBlock(name) + "\"; }");
//            out.println("</script>");
//            out.println("<div id=\"foo1\">old text</div>");
//            out.println("<a onclick=\"changeText1();\">");
//            out.println("Click me</a>");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}