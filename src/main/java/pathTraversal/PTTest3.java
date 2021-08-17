package pathTraversal;

import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PTTest3 {
    private final String BASE_DIRECTORY = "src";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String contentType = request.getContentType();
        int ind = contentType.indexOf("boundary=");
        String boundary = contentType.substring(ind+9);
        String pLine = new String();
        String uploadLocation = new String("abc");
        if (contentType != null && contentType.indexOf("multipart/form-data") != -1) {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            pLine = br.readLine();
            String filename = pLine.substring(pLine.lastIndexOf("\\"), pLine.lastIndexOf("\""));
            File dictionaryFile = new File(BASE_DIRECTORY,filename);
            dictionaryFile.delete();
        }
        else
        {System.out.print("sdfsf");}
    }

}