package osi;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

public class OSITest5 {
  private String data;

  public void test(HttpServletRequest request) throws IOException, InterruptedException {
    this.data = request.getParameter("data");
    doStuff("mkdir");
  }

  private void doStuff(String command) throws InterruptedException, IOException {
    /* POTENTIAL FLAW: command injection */
    Process process = Runtime.getRuntime().exec(command + encodeForOS(data));
    process.waitFor();
  }

  private String encodeForOS(String param) {
    if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
      return ESAPI.encoder().encodeForOS(new WindowsCodec(), param);
    } else {
      return ESAPI.encoder().encodeForOS(new UnixCodec(), param);
    }
  }
}
