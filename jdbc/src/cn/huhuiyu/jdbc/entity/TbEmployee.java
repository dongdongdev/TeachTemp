package cn.huhuiyu.jdbc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbEmployee implements Serializable {

	private static final long serialVersionUID = 9141827345143496725L;
	private int eid;
	private String ename;
	private String sex;
	private BigDecimal salary;
	private String phone;
	private int deptId;
	private Date indate;

	public TbEmployee() {
	}
	
	@Override
	public String toString() {
		return "TbEmployee [eid=" + eid + ", ename=" + ename + ", sex=" + sex + ", salary=" + salary + ", phone="
				+ phone + ", deptId=" + deptId + ", indate=" + indate + "]";
	}



	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

}
