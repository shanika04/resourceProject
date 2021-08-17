package osi;

import java.io.IOException;
import java.util.UUID;

public class OSITest2 {
  public void runCommand() throws IOException, InterruptedException {
      test("&&rm -rf /", "");
  }

  public void test(String data1, String data2) throws IOException, InterruptedException {
    String osCommand;
    String uuid = UUID.randomUUID().toString();
    if (System.getProperty("os.name").toLowerCase().contains("win")) {
      /* running on Windows */
      osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";
    } else {
      /* running on non-Windows */
      osCommand = "/bin/ls ";
    }
    String newData = data1 + uuid + data2;

    /* POTENTIAL FLAW: command injection */
    Process process = Runtime.getRuntime().exec(osCommand + newData);
    process.waitFor();
  }
}

