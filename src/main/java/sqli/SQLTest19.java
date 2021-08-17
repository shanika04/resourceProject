package sqli;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class SQLTest19 {

    public void sqlTest19(HttpServletRequest request) {
        String ip_1 = request.getParameter("ip_1");
        String ip_2 = request.getParameter("ip_2");
        try {
            String sql = "INSERT INTO banned_ip(id, ip) VALUE('" + UUID.randomUUID().toString() + "','" + "?" + "','" + ip_2 + "')";
            PreparedStatement wssPreparedStatement = getJDBCConnection().prepareStatement(sql);
            wssPreparedStatement.setString(1, ip_1);
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