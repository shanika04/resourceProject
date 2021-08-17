package xxe;

import javax.servlet.http.HttpServletRequest;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.StringReader;

public class SAXBuilderTest1 {

  public String getXml(HttpServletRequest request) {
    String xmlStr = request.getParameter("xmlStr");
    String result = unsafe(xmlStr);

    if (result != null) {
      return result;
    }

    return "XML parse error";
  }

  private String unsafe(String xmlString) {

    try {

      SAXBuilder saxBuilder = new SAXBuilder();
      saxBuilder.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

      Document document = saxBuilder.build(new InputSource(new StringReader(xmlString)));

      Element root = document.getRootElement();

      return root.getText();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
