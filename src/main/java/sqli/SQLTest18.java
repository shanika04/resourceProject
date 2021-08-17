package sqli;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class SQLTest18 {

    public void sqlTest18(HttpServletRequest request) {
        String ip = request.getParameter("ip");
        try {
            String sql = "INSERT INTO banned_ip(id, ip) VALUE('" + UUID.randomUUID().toString() + "','" + ip + "')";
			PreparedStatement wssPreparedStatement = getJDBCConnection().prepareStatement(sql);
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