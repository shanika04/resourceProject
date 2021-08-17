package pathTraversal;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class PTTest5 {
    private final String BASE_DIRECTORY = "/users/ws/profiles/";

    public void Test(HttpServletRequest request) {
        String filename = request.getParameter("filename");
        try {
            File myFile = new File(BASE_DIRECTORY + filename);
            delFile(myFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void delFile(File f) {
        f.delete();
    }
}