package pathTraversal;

import java.util.UUID;
import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class PTTest6 {
    private final String BASE_DIRECTORY = "src";

    public void Test(HttpServletRequest request) {
        String file = request.getParameter("file");
        System.out.print("sdfsf");
        String a = file + "abc";
        sink(file);
    }

    private void sink(String filename) {
        int a =0;
        File dictionaryFile = new File(BASE_DIRECTORY , filename);
        dictionaryFile.delete();
    }
}
