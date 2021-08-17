package pathTraversal;

import java.util.UUID;
import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class PTTest2 {
    private final String BASE_DIRECTORY = "src";

    public void Test(HttpServletRequest request) {
        String path = request.getParameter("path");
        try {
            File dictionaryFile = new File(BASE_DIRECTORY + "abc/" + path);
            dictionaryFile.delete();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.print("sdfsf");
    }

}