package sqli;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class SQLTest21 {

  public void sqlTest21(HttpServletRequest request) {
    String ip = request.getParameter("ip");
    try {
      String sql =
          "INSERT INTO banned_ip(id, ip) VALUE('"
              + UUID.randomUUID().toString()
              + "','"
              + "?"
              + "')";
      PreparedStatement statement = getJDBCConnection().prepareStatement(sql);
      sink(sql, statement);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

  public void sink(String sql, Statement statement) {
    try {
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
