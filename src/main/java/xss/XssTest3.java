package xss;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class XssTest3 {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    unsafe(request, response);
  }

  private void unsafe(HttpServletRequest request, HttpServletResponse response) {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    try {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      out.println(
          "<br><br><h1 align=center><font color=\"red\">Unsafe Javascript Attribute context:<br></font></h1>");
      out.println("<a onclick=\"alert('" + Encode.forJavaScriptAttribute(name) + "');\">");
      out.println("Click me</a>");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
