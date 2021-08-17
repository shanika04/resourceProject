package deserialization;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;
import java.io.ObjectInputStream;
import javax.servlet.http.HttpServletRequest;
import org.xml.sax.helpers.XMLReaderFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeserializationTest3 {
    @PostMapping("/test")
    public void test(HttpServletRequest request) throws IOException, ClassNotFoundException {
        String filename = request.getParameter("filename");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        castingMethod(in);
        in.close();
    }

    private void castingMethod(ObjectInputStream objInStream) throws IOException, ClassNotFoundException {
        XMLReaderFactory xmlParser = (XMLReaderFactory) objInStream.readObject();
        XMLReaderFactory xmlParser_two = (XMLReaderFactory) xmlParser;
    }
}