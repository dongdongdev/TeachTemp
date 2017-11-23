package cn.huhuiyu.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestFour {
	public static void main(String[] args) throws SQLException {
		Connection conn = Db.getConn();
		// 死亡幻觉
		String sql = "update TbDept set deptInfo=?,created=? where deptId=?";
		int deptId = 1;
		String deptInfo = "修改信息";
		String created = "2011-11-11";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, deptInfo);
		ps.setString(2, created);
		ps.setInt(3, deptId);
		int result = ps.executeUpdate();
		ps.close();
		System.out.println("数据库影响行数:" + result);
		conn.close();
	}
}
