package pathTraversal;

import java.util.UUID;
import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class PTTest1 {
	private final String BASE_DIRECTORY = "src";

	public void Test(HttpServletRequest request) {
		String filename = request.getParameter("filename");
		try {
			File dictionaryFile = new File(BASE_DIRECTORY,filename);
			dictionaryFile.delete();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.print("sdfsf");
	}
}