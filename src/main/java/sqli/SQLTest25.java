package sqli;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class SQLTest25 {

  public void sqlTest17(int x, String d, javax.servlet.ServletRequest r) {
    try {
      int u = x + 1;
      System.out.println(d + "blabla");
      String y = r.getParameter("y");
      String id = getid(y);
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

  public String getid(String x) {
    String id = x;
    return id;
  }
}
