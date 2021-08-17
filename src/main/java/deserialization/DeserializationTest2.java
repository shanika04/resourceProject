package deserialization;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;
import java.io.ObjectInputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.xml.sax.helpers.XMLReaderFactory;

@Controller
public class DeserializationTest2 {
    @PostMapping("/test")
    public void test(HttpServletRequest request) throws IOException, InterruptedException, ClassNotFoundException {
        String filename = request.getParameter("filename");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        XMLReaderFactory xmlParser = (XMLReaderFactory) new ObjectInputStream(new FileInputStream(filename)).readObject();
        XMLReaderFactory xmlParser_two = (XMLReaderFactory) xmlParser;
        in.close();
    }
}