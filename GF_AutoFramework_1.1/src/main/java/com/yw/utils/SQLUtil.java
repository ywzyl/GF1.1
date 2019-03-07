package com.yw.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.yw.utils.JDBCUtil;;

public class SQLUtil {
	private static Connection conn=null;
	private static Statement stmt=null;
	public static void deleteFromTable(String sql) {		
		try {
			// 获取连接
			conn=JDBCUtil.getConnection();
			stmt=conn.createStatement();
			int count=stmt.executeUpdate(sql);
			System.out.println(""+count+"行被影响了");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	public static void insertIntoTable(String sql) {
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.createStatement();
			int count=stmt.executeUpdate(sql);
			System.out.println(""+count+"行被影响了");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	public static void createTable(String sql) {
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.createStatement();
			int count=stmt.executeUpdate(sql);
			System.out.println(""+count+"行被影响了");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	public static ResultSet selectTable(String sql) {
		ResultSet rs=null;
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return rs;
	}
}
