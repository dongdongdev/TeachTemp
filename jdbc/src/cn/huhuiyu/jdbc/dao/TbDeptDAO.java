package cn.huhuiyu.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.huhuiyu.jdbc.entity.TbDept;

/**
 * 数据库TbDept表的操作类
 * 
 * @author huhuiyu
 *
 */
public class TbDeptDAO {
	public static final String QUERY = "select * from TbDept";
	
	public List<TbDept> query() throws Exception {
		List<TbDept> list = new ArrayList<TbDept>();
		PreparedStatement ps = connection.prepareStatement(QUERY);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			// 一行记录对应一个实体类的实例，这个就是实体类的意义
			TbDept dept = new TbDept();
			// 实体字段对数据表字段
			dept.setDeptId(rs.getInt("deptId"));
			dept.setDeptName(rs.getString("deptName"));
			dept.setDeptInfo(rs.getString("deptInfo"));
			dept.setCreated(rs.getTimestamp("created"));
			// 添加到集合中
			list.add(dept);
		}
		rs.close();
		ps.close();
		return list;
	}

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public static void main(String[] args) throws Exception {
		TbDeptDAO dao = new TbDeptDAO();
		Connection conn = Db.getConn();
		dao.setConnection(conn);
		List<TbDept> list = dao.query();
		for (TbDept tbDept : list) {
			System.out.println(tbDept);
		}
		conn.close();
	}
	
	//作业一
	//将上次作业创建的数据表映射到实体类
	//比如学生表对应到学生类
	//然后添加学生表的DAO类
	// 完成查询全部数据表
	
	//作业二
	//添加学生表的修改和删除记录的测试类
		
}
