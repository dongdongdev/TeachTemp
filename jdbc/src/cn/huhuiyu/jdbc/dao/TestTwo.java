package cn.huhuiyu.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class TestTwo {
	public static void main(String[] args) throws SQLException {
		Connection conn = Db.getConn();
		Random rand = new Random();
		String sql = "insert into TbDept(deptName,deptInfo) " + " values(?,?)";
		// 第二个参数表示执行语句后尝试拿回自动增长的主键值
		// 只对insert into语句有效果，且有自动增长的主键字段
		PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setString(1, "部门" + rand.nextInt());
		ps.setString(2, "描述" + rand.nextInt());
		// 首先要执行成功
		int result = ps.executeUpdate();
		if (result == 1) {
			//取回来自动增长主键
			ResultSet rs=ps.getGeneratedKeys();
			//获取唯一的一笔记录
			rs.next();
			System.out.println("主键值："+rs.getInt(1));
			rs.close();
		}
		ps.close();
		conn.close();
	}
}
