package sqli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class SQLTest20 {

  public void sqlTest20(HttpServletRequest request) {
    String ip = request.getParameter("ip");
    String id = request.getParameter("id");
    try {
      String sql = "INSERT INTO banned_ip(id, ip) VALUE('" + UUID.randomUUID().toString() + "','" + "?" + "','" + "?" + "')";
      PreparedStatement wssPreparedStatement = getJDBCConnection().prepareStatement(sql);
      wssPreparedStatement.setString(2, id);
      wssPreparedStatement.setString(1, ip);
      wssPreparedStatement.execute();
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    System.out.print("sdfdsf");
  }

  Connection getJDBCConnection() {
    return null;
  }
}
