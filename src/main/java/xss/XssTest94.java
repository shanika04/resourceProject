package xss;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class XssTest94 {
  HttpServletRequest request;
  HttpServletResponse response;

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.request = request;
    this.response = response;
    String name = request.getParameter("name");
    unsafe(name);
  }

  private void unsafe(String name) {
    try {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      out.write("<br><br>Unsafe CSS style attribute context:<br>");
      out.write("<div style=\"background-image: url('" + Encode.forCssUrl(name) + "')\">");
      out.write("<h1>TEXT</h1>");
      out.write("</div>");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //    private void safe(HttpServletRequest request, HttpServletResponse response) {
  //        try {
  //            response.setContentType("text/html");
  //            PrintWriter out = response.getWriter();
  //            out.write("<br><br>Unsafe CSS style attribute context:<br>");
  //            out.write("<div style=\"background-image: url('" + Encode.forCssUrl(name) +
  // "')\">");
  //            out.write("<h1>TEXT</h1>");
  //            out.write("</div>");
  //        } catch (IOException e) {
  //            e.printStackTrace();
  //        }
  //    }
}
