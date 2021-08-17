package xxe;

import javax.servlet.http.HttpServletRequest;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import org.xml.sax.InputSource;

import java.io.StringReader;

public class SAXReaderTest1 {

  public String getXml(HttpServletRequest request) {
    String xmlStr = request.getParameter("xmlStr");
    String result = unsafe(xmlStr);

    if (result != null) {
      return result;
    }

    return "XML error";
  }

  private String unsafe(String xmlString) {

    try {
      SAXReader xmlReader = new SAXReader();
      xmlReader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
      org.dom4j.Document document = xmlReader.read(new InputSource(new StringReader(xmlString)));

      Element root = document.getRootElement();

      return root.getText();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
