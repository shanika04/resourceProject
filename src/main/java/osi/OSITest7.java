package osi;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

public class OSITest7 {

  public void test(HttpServletRequest request) throws IOException, InterruptedException {
    String data = request.getParameter("data");
    Inner inner = new Inner();
    inner.setSuperInner(data);
    doStuff("mkdir", inner);
  }

  private void doStuff(String command, Inner inner) throws IOException, InterruptedException {
    /* POTENTIAL FLAW: command injection */
    Process process = Runtime.getRuntime().exec(command + encodeForOS(inner.getSuperInner()));
    process.waitFor();
  }

  private String encodeForOS(String param) {
    if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
      return ESAPI.encoder().encodeForOS(new WindowsCodec(), param);
    } else {
      return ESAPI.encoder().encodeForOS(new UnixCodec(), param);
    }
  }

  public static class Inner {
    private String superInner;

    public Inner() {}

    public void setSuperInner(String superInner) {
      this.superInner = superInner;
    }

    public String getSuperInner() {
      return superInner;
    }
  }
}
