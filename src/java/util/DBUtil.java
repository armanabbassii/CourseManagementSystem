package util;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class DBUtil {
    private static String URL = "jdbc:postgresql://localhost:5432//CourseManagementSystem";
    private static String USER = "postgres";
    private static String PASSWORD = "123456";

    public Connection getConnection(){
        try{
            return DriverManager.getConnection(URL,USER,PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeQuery(String sql, Object... params) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        setParameters(stmt, params);
        try {
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // method for update db
    public void updateQuery(String sql, Object... params) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            setParameters(stmt, params);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // method for set params in queries
    private static void setParameters(PreparedStatement stmt, Object... params) {
        for (int i = 0; i < params.length; i++) {
            try {
                stmt.setObject(i + 1, params[i]);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
