package pathTraversal;

import java.util.UUID;
import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class PTTest4 {
    private final String BASE_DIRECTORY = "src";

    public void Test(HttpServletRequest request) {
        String filename = request.getParameter("filename");
        try {
            String fullPath = createPath(BASE_DIRECTORY, filename);
            File file = new File(fullPath);
            file.delete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.print("sdfsf");
    }

    public String createPath(String base, String filename){
        return base + filename;
    }
}

