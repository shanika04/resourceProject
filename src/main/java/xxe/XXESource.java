package xxe;

import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XXESource {

    private void source(HttpServletRequest request) throws XMLStreamException {
        String filename = request.getParameter("filename");
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        new FactorySink().getXml(filename, inputFactory);
    }

}
