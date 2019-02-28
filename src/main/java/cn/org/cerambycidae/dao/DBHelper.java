package cn.org.cerambycidae.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBHelper {
    private static final Properties properties;
    private static String driver;                                                   //数据库驱动
    private static String url;                                                      //数据库地址
    private static String username;                                                 //用户名
    private static String password;                                                 //密码
    private static  final String JDBC_PROPERTIES_PATH="properties/jdbc.properties";       //配置文件路径


    static{
        properties=new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(JDBC_PROPERTIES_PATH));
            driver=properties.getProperty("jdbc.driver");
            url=properties.getProperty("jdbc.url");
            username=properties.getProperty("jdbc.username");
            password=properties.getProperty("jdbc.password");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName(driver);
        Connection connection= DriverManager.getConnection(url,username,password);
        return connection;
    }

    public static void closeResource(Connection conn)throws Exception{
        closeResource(conn,null);
    }

    public static void closeResource(Connection conn, PreparedStatement pst)throws Exception{
        closeResource(conn,pst,null);
    }

    public static void closeResource(Connection conn, PreparedStatement pst, ResultSet rs)throws Exception{
        if(rs!=null){
            rs.close();
        }

        if(pst!=null){
            pst.close();
        }

        if(conn!=null){
            conn.close();
        }
    }
}
