package xss;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class XssTest7 {

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
      out.write("<br><br>Unsafe CSS style attribute context:<br>");
      out.write("<div style=\"color:" + Encode.forCssString(name) + "\">");
      out.write("<h1>TEXT</h1>");
      out.write("</div>");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
