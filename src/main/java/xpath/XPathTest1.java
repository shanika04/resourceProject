package xpath;

import javax.servlet.http.HttpServletRequest;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

public class XPathTest1 {

  public String authenticate(HttpServletRequest request) {
    String user = request.getParameter("user");
    String pass = request.getParameter("pass");
    XPath xPath = XPathFactory.newInstance().newXPath();
    String expression = "/users/user[@name='" + user + "' and @pass='" + pass + "']";
    try {
      return xPath.evaluate(expression, "null");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }
}