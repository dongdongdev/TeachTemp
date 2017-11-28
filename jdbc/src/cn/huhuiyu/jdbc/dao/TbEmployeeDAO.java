package cn.huhuiyu.jdbc.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.huhuiyu.jdbc.entity.TbEmployee;

public class TbEmployeeDAO {
	public static final String INSERT = "insert into TbEmployee(ename,sex,salary,phone,deptId) " + " values(?,?,?,?,?)";
	public static final String QUERY = "select * from TbEmployee";
	public static final String DELETE = "delete from TbEmployee where eid=?";
	public static final String UPDATE = "update TbEmployee set ename=?,sex=?,salary=?,phone=?,deptId=? "
			+ " where eid=?";
	public static final String QUERY_BY_KEY = "select * from TbEmployee where eid=?";

	public static int add(TbEmployee emp) throws Exception {
		Connection conn = Db.getConn();
		PreparedStatement ps = conn.prepareStatement(INSERT);
		ps.setString(1, emp.getEname());
		ps.setString(2, emp.getSex());
		ps.setBigDecimal(3, emp.getSalary());
		ps.setString(4, emp.getPhone());
		ps.setInt(5, emp.getDeptId());
		int result = ps.executeUpdate();
		ps.close();
		conn.close();
		return result;
	}

	public static int delete(TbEmployee emp) throws Exception {
		Connection conn = Db.getConn();
		PreparedStatement ps = conn.prepareStatement(DELETE);
		ps.setInt(1, emp.getEid());
		int result = ps.executeUpdate();
		ps.close();
		conn.close();
		return result;
	}

	public static int modify(TbEmployee emp) throws Exception {
		Connection conn = Db.getConn();
		PreparedStatement ps = conn.prepareStatement(UPDATE);
		ps.setString(1, emp.getEname());
		ps.setString(2, emp.getSex());
		ps.setBigDecimal(3, emp.getSalary());
		ps.setString(4, emp.getPhone());
		ps.setInt(5, emp.getDeptId());
		ps.setInt(6, emp.getEid());
		int result = ps.executeUpdate();
		ps.close();
		conn.close();
		return result;
	}
	
	public static List<TbEmployee> query() throws Exception{
		List<TbEmployee> list=new ArrayList<TbEmployee>();
		Connection conn=Db.getConn();
		PreparedStatement ps=conn.prepareStatement(QUERY);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			TbEmployee emp=new TbEmployee();
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setSex(rs.getString("sex"));
			emp.setSalary(rs.getBigDecimal("salary"));
			emp.setPhone(rs.getString("phone"));
			emp.setIndate(rs.getTimestamp("indate"));
			emp.setDeptId(rs.getInt("deptId"));
			list.add(emp);			
		}
		rs.close();
		ps.close();
		conn.close();
		return list;
	}
	
	public static TbEmployee queryByKey(TbEmployee emp) throws Exception{
		TbEmployee employee=null;
		Connection conn=Db.getConn();
		PreparedStatement ps=conn.prepareStatement(QUERY_BY_KEY);
		ps.setInt(1, emp.getEid());
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			employee=new TbEmployee();
			
			employee.setEid(rs.getInt("eid"));
			employee.setEname(rs.getString("ename"));
			employee.setSex(rs.getString("sex"));
			employee.setSalary(rs.getBigDecimal("salary"));
			employee.setPhone(rs.getString("phone"));
			employee.setIndate(rs.getTimestamp("indate"));
			employee.setDeptId(rs.getInt("deptId"));
		}
		rs.close();
		ps.close();
		conn.close();
		return employee;
	} 
	
	public static void main(String[] args) throws Exception {
		Random rand=new Random();
		TbEmployee emp=new TbEmployee();
		emp.setEname("姓名"+rand.nextInt(100000));
		emp.setSex("f");
		emp.setSalary(new BigDecimal(""+rand.nextInt(1000000)));
		emp.setPhone("1234567890123");
		emp.setDeptId(1);
		TbEmployeeDAO.add(emp);
		List<TbEmployee> list=TbEmployeeDAO.query();
		for (TbEmployee tbEmployee : list) {
			System.out.println(tbEmployee);
		}
		
	}
	
	
}
