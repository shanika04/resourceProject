package sqli;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class SQLTest17 {

  public void sqlTest17(int x, String name, HttpServletRequest request) {
    try {
      int u = x + 1;
      System.out.println(name + "blabla");
      String y = request.getParameter("y");
      String id = getId(y);
      String sql =
          "INSERT INTO banned_ip(id, ip) VALUE('"
              + UUID.randomUUID().toString()
              + "','"
              + "?"
              + "')";
      PreparedStatement statement = getJDBCConnection().prepareStatement(sql);
      statement.setString(1, id);
      statement.execute();
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    System.out.print("sdfdsf");
  }

  Connection getJDBCConnection() {
    return null;
  }

  public String getId(String x) {
    String id = x;
    return id;
  }
}
