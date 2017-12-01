package cn.huhuiyu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*dao是数据库访问对象database access object*/
public class Db {
	/*
	 * 没有说明的部分都是固定的语法 127.0.0.1部分是sqlserver的服务器ip地址 1433是服务器端口（有的服务器会修改这个默认端口）
	 * database=要连接的数据库名称 user=数据库用户 password=数据库用户登陆密码
	 */
	public static final String CONN_STRING = "jdbc:sqlserver://127.0.0.1:1433;database=shop;user=sa;password=abc123";

	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 获取数据库连接对象
	 * 
	 * @return 数据库连接对象
	 * @throws SQLException
	 */
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(CONN_STRING);
	}

	public static void main(String[] args) throws SQLException {
		/* 显示连接的数据库名称 */
		System.out.println(Db.getConn().getCatalog());
	}

}
