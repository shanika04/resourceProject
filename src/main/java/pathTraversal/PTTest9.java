package pathTraversal;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class PTTest9 {
    private final String BASE_DIRECTORY = "src";

    public void Test(HttpServletRequest request) {
        String filename = request.getParameter("filename");
        try {
            int a =0;
            String f = request.getParameter("name");
            String s = BASE_DIRECTORY + "qqq" + f + getvalue("abc");
            new File(s + filename).delete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.print("sdfsf");
    }

    public String getvalue(String s){
        return "rrr" + s + "aaa";
    }
}