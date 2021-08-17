package sqli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class SQLTest8 {

  public void sqlTest8(HttpServletRequest request) {
    String ip = request.getParameter("ip");
    ip = ip + ".a";
    try {
      PreparedStatement preparedStatement =
          getJDBCConnection()
              .prepareStatement(
                  "INSERT INTO banned_ip(id, ip) VALUE('"
                      + UUID.randomUUID().toString()
                      + "','"
                      + "?"
                      + "')");
      preparedStatement.setString(1, ip);
      preparedStatement.execute();
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    System.out.print("sdfdsf");
  }

  Connection getJDBCConnection() {
    return null;
  }
}
