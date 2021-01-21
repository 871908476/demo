package mysql.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCToolDemo {
    public static void main(String[] args) {
        Connection conn = JDBCTool.getConnection();
        Statement stmt = JDBCTool.getStatement(conn);
        try {
            int i = stmt.executeUpdate("INSERT INTO student(name) value ('张三')");
            System.out.println("影响行数："+i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCTool.close();
    }
}
