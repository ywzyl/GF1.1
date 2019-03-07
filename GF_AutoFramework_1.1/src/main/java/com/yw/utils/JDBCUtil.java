package com.yw.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil extends TestBase{
	//url
	private static String url=null;
	//username
	private static String username=null;
	//password
	private static String password=null;
	//驱动程序
	private static String driverClass=null;
	
	/**
	 * 只注册一次，静态代码块
	 */
	static {
		//注册驱动程序
		try {
			TestBase testBase=new TestBase();
			url=testBase.prop.getProperty("url");
			username=testBase.prop.getProperty("username");
			password=testBase.prop.getProperty("password");
			driverClass=testBase.prop.getProperty("driverClass");
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	/**
	 * 获取连接方法
	 */
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 释放资源的方法
	 */
	public static void close(ResultSet rs,Statement stmt,Connection conn) {
		if (stmt!=null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if (rs!=null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	/**
	 * 释放资源的方法
	 */
	public static void close(Statement stmt,Connection conn) {
		if (stmt!=null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
