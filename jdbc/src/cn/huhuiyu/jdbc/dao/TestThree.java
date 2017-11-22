package cn.huhuiyu.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TestThree {
	public static void main(String[] args) throws SQLException {
		Connection conn = Db.getConn();
		String sql = "select * from TbDept";
		PreparedStatement ps = conn.prepareStatement(sql);
		// 执行查询并返回结果
		ResultSet rs = ps.executeQuery();
		// 读取记录
		while (rs.next()) {
			// next表示读取查询记录的下一行，如果有就返回true
			// getxxx(列名称)表示获取列的数据
			// xxx是列的数据类型
			int deptId = rs.getInt("deptId");
			String deptName = rs.getString("deptName");
			String deptInfo = rs.getString("deptInfo");
			Date created = rs.getTimestamp("created");
			System.out.println(String.format("%s,%s,%s,%s", deptId, deptName, deptInfo, created));
		}
		rs.close();
		ps.close();
		conn.close();
		
		//作业一：
		//创建学生管理数据库，包含班级表和学生表，字段自己设计
		//创建学生管理java项目
		//创建数据库连接类DbConn并测试是否能连接到学生管理数据库
		//创建班级表的添加数据和查询数据操作类
		//测试添加记录和查询记录
		
		//思考题
		//添加测试删除班级信息和修改班级信息的操作类
				
		
	}
}
