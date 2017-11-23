package cn.huhuiyu.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestFive {
	public static void main(String[] args) throws SQLException {
		Connection conn = Db.getConn();
		String sql = "delete from TbDept where deptId=?";
		int deptId = 4;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, deptId);
		int result = ps.executeUpdate();
		ps.close();
		conn.close();
		System.out.println(result + "行受影响");
	}
}
