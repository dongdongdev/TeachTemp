package cn.huhuiyu.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestOne {
	public static void main(String[] args) throws SQLException {
		//添加数据
		Connection conn=Db.getConn();
		//sql语句中的数据参数都用问号代替
		//这样可以防范sql注入攻击
		String sql="insert into TbDept(deptName,deptInfo) "
				+" values(?,?)";
		//参数值
		String deptName="测'试部1";
		String deptInfo="测试软件是否有问题的部门";
		//创建预处理语句(可以处理sql语句中?的参数值)
		PreparedStatement ps=conn.prepareStatement(sql);
		//设置参数值
		ps.setString(1, deptName); //将第一个?的值替换成deptName
		ps.setString(2, deptInfo); //将第二个?的值替换成deptInfo
		//执行语句并返回结果
		int result=ps.executeUpdate(); 
		//executeUpdate表示执行的是会影响数据库记录的语句
		//返回的是影响的记录行数
		System.out.println(result+"行受影响");
		//关闭数据库相关对象
		ps.close();
		conn.close();
		//错误对照组
//		sql=String.format("insert into TbDept(deptName,deptInfo)"
//				+ " values('%s','%s')",deptName,deptInfo);
//		System.out.println(sql);
		
		
	}
}
