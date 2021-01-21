package mysql.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Demo {
    public static void main(String[] args) throws SQLException {
        //使用默认配置
        DataSource ds = new ComboPooledDataSource();
        //传入自定义配置名可使用自定义配置
        //DataSource ds=new ComboPooledDataSource(“otherc3p0”);
        Connection conn = null;
        conn = ds.getConnection();
        /**
         * 数据库操作代码
         */
        conn.close();
    }
}
