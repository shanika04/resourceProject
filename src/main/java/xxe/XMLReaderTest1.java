package xxe;

import javax.servlet.http.HttpServletRequest;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.StringReader;

public class XMLReaderTest1 {

    public String getXml(HttpServletRequest request) {
        String xmlStr = request.getParameter("xmlStr");
        String result = unsafe(xmlStr);

        if(result != null) {
            return result;
        }

        return "XML parse error";
    }

    private String unsafe(String xmlString)
    {
        try {
            FooReaderHandler handler = new FooReaderHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();

            reader.setContentHandler(handler);
            reader.parse(new InputSource(new StringReader(xmlString)));

            return handler.getFoo();

        } catch (Exception e) {
			e.printStackTrace();
        }

        return null;
    }
}

class FooReaderHandler implements ContentHandler {

    boolean isFoo = false;
    String foo;

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("foo")) {
            isFoo = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

    }

    public void characters(char ch[], int start, int length) {
        if (isFoo) {
            foo = new String(ch, start, length);
            isFoo = false;
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }

    public String getFoo() {
        return foo;
    }
}