package mysql.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JDBCTool {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    private static Connection conn = null;
    private static Statement stmt = null;

    static {
        try {
            Properties pro = new Properties();
            InputStream is = JDBCTool.class.getClassLoader().getResourceAsStream("jdbctool.propertis");
            pro.load(is);
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     */
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 获取SQL语句执行对象
     */
    public static Statement getStatement() {
        if (conn == null) getConnection();
        else try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    /**
     * 释放资源
     */
    public static void close() {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (stmt != null)
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
