package com.hqyj.servletDemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接工具类
 * @author: HymanHu
 * @date: 2019年11月23日
 */
public class DBUtil {
	
	private static String user ="";
    private static String password = "";
    private static String url = "";
    private static String driver = "";
    private static Connection conn = null;
    
    /**
     * 初始化连接属性
     */
    static {
    	driver = ConfigUtil.properties.getProperty("jdbc.driverClassName");
    	url = ConfigUtil.properties.getProperty("jdbc.url");
    	user = ConfigUtil.properties.getProperty("jdbc.username");
    	password = ConfigUtil.properties.getProperty("jdbc.password");
    }
    
    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() {
    	try {
    		Class.forName(driver);
    		conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return conn;
    }
    
    /**
     * 关闭数据库连接
     * @param conn
     */
    public static void closeConnection(Connection conn) {
    	if (conn != null) {
    		try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }
}
