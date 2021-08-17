package sqli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class SQLTest5 {

  public void sqlTest5(HttpServletRequest request) {
    String ip = request.getParameter("ip");
    String id = request.getParameter("id");
    try {
      String sql =
          "INSERT INTO banned_ip(id, ip) VALUE('"
              + UUID.randomUUID().toString()
              + "','"
              + "?"
              + "','"
              + "?"
              + "')";
      PreparedStatement preparedStatement = getJDBCConnection().prepareStatement(sql);
      preparedStatement.setString(1, ip);
      preparedStatement.setString(2, id);
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
