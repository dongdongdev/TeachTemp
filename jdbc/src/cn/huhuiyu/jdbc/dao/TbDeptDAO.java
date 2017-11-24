package cn.huhuiyu.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.huhuiyu.jdbc.entity.TbDept;

/**
 * 数据库TbDept表的操作类
 * 
 * @author huhuiyu
 *
 */
public class TbDeptDAO {
	public static final String QUERY = "select * from TbDept";
	public static final String INSERT = "insert into TbDept(deptName,deptInfo) values(?,?)";
	public static final String DELETE = "delete from TbDept where deptId=?";
	public static final String UPDATE = "update TbDept set deptName=?,deptInfo=? where deptId=?";
	public static final String QUERY_BY_KEY = "select * from TbDept where deptId=?";

	public int modify(TbDept dept) throws Exception {
		PreparedStatement ps = connection.prepareStatement(UPDATE);
		ps.setString(1, dept.getDeptName());
		ps.setString(2, dept.getDeptInfo());
		ps.setInt(3, dept.getDeptId());
		int result = ps.executeUpdate();
		ps.close();
		return result;
	}

	// 方法的定义
	// 方法的访问修饰符 返回值 方法名称(方法的参数列表) throws 异常{方法代码}
	// 修饰符包括 public private protected 和 static
	// public表示任何类都可以访问，private只有类自己可以访问
	// protected只有类自己和子类可以访问
	// 没有写表示类自己和相同package中的类可以访问
	// static表示通过类名称访问
	// 返回值可以是任意类型（包含自定义的类），也可以是void，表示无返回值
	// 如果不是void，那么方法必须返回（return）一个对应类型的值
	// throws Excption表示方法的调用者要准备处理异常的可能性
	// Exception是所有异常的父类型，可以代表任何异常
	// SqlException是sql相关的异常

	// jdbc常用方法和类型
	// 第一个核心是java.sql包，包含所有的数据库相关类
	// 数据库连接类Connection，表示连接到一个具体的数据库
	// 所有的sql操作都必须从它开始
	// 数据库预编译语句执行类PreparedStatement
	// 可以处理带?参数的数据库语句
	// 例如语句是select * from 表名称 where 主键=?
	// 通过PreparedStatement.set参数数据类型(参数值)
	// 将?处理成正确的值
	// 例如上面的语句参数用PreparedStatement.setInt(1)处理
	// 语句执行有两种结果，一种是影响数据库记录的，返回值影响行数
	// 例如 int result = PreparedStatement.executeUpdate()
	// 添加删除修改语句都是通过这个方法执行
	// 一种是查询数据库记录，返回值是结果集
	// 例如ResultSet rs=PreparedStatement.executeQuery();
	// 结果集的读取
	// ResultSet.next()表示移动到结果集的下一行，如果成功就返回true
	// 通过ResultSet.get列数据类型（"列名称"）获取列的数据
	// 例如 rs.getString("deptName")表示获取deptName的数据	
	
	public TbDept queryByKey(TbDept dept) throws Exception {
		// 按照主键查询记录（最多只有一笔记录）
		PreparedStatement ps = connection.prepareStatement(QUERY_BY_KEY);
		ps.setInt(1, dept.getDeptId());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) { // 如果有记录，肯定只有一笔
			dept.setDeptName(rs.getString("deptName"));
			dept.setDeptInfo(rs.getString("deptInfo"));
			dept.setCreated(rs.getTimestamp("created"));
		}
		rs.close();
		ps.close();
		return dept;
	}

	public int delete(TbDept dept) throws Exception {
		PreparedStatement ps = connection.prepareStatement(DELETE);
		ps.setInt(1, dept.getDeptId());
		int result = ps.executeUpdate();
		ps.close();
		return result;
	}

	public int add(TbDept dept) throws Exception {
		//ResultSet=查询的结果
		//结果是一个表格，包括n行m列
		//deptId,deptName
		//1,dddd
		//2,ffff
		//查询的结果是定位到第一行记录的上一行
		//通过next方法移动到下一行
		//第一次执行就会移动到第一行，如果没有记录了就返会false
		
		
		PreparedStatement ps = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setString(1, dept.getDeptName());
		ps.setString(2, dept.getDeptInfo());
		int result = ps.executeUpdate();
		if (result == 1) {
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			dept.setDeptId(rs.getInt(1));
			rs.close();
		}
		ps.close();
		return result;
	}

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
		// 添加的测试
		// Random rand = new Random();
		// TbDept dept = new TbDept();
		// dept.setDeptName("部门" + rand.nextInt());
		// dept.setDeptInfo("描述" + rand.nextInt());
		// dao.add(dept);
		// System.out.println(dept);

		// 删除的测试
		TbDept dept = new TbDept();
		dept.setDeptId(1);
		int result = dao.delete(dept);
		System.out.println(result);

		// 查询测试
		// List<TbDept> list = dao.query();
		// for (TbDept tbDept : list) {
		// System.out.println(tbDept);
		// }
		conn.close();
	}

	// 作业一
	// 将上次作业创建的数据表映射到实体类
	// 比如学生表对应到学生类
	// 然后添加学生表的DAO类
	// 完成查询全部数据表
	// 完成删除学生，添加学生，按照主键查询学生的方法并测试

	// 作业二
	// 添加学生表的修改和删除记录的测试类
	

}
