package sqli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class SQLTest13 {

  public void sqlTest13(HttpServletRequest request) {
    String ip = request.getParameter("ip");
    if (ip == "") {
      ip = ip + ".a";
    }
    ip = ip + ".b";
    try {
      String sql =
          "INSERT INTO banned_ip(id, ip) VALUE('"
              + UUID.randomUUID().toString()
              + "','"
              + "?"
              + "')";
      PreparedStatement statement = getJDBCConnection().prepareStatement(sql);
      statement.setString(1, ip);
      statement.execute();
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    System.out.print("sdfdsf");
  }

  Connection getJDBCConnection() {
    return null;
  }
}
