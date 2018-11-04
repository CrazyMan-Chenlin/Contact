package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtil2 {
    //创建DataSource对象
    private static DataSource ds=new ComboPooledDataSource();
    //返回对象
    public  static DataSource getDataSources(){
        return  ds;
    }
    //返回连接对象
    public static Connection getConnection()throws SQLException{
        Connection conn=ds.getConnection();
        return conn;
    }
}
