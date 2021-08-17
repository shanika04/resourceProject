package sqli;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class SQLTest16 {

  public void sqlTest16(int x, HttpServletRequest request) {
    String d = request.getParameter("d");
    String y = request.getParameter("y");
    try {
      int u = x + 1;
      System.out.println(d + "blabla");
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
