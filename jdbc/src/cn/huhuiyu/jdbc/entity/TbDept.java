package cn.huhuiyu.jdbc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据库实体类，对应数据库的TbDept表 实体类一般会标注为Serializable，表示可以被序列话
 * 
 * @author huhuiyu
 *
 */
public class TbDept implements Serializable {

	private static final long serialVersionUID = -8381213525728460341L;
	/* 数据库的字段映射 */
	private int deptId;
	private String deptName;
	private String deptInfo;
	private Date created;

	public TbDept() {
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptInfo() {
		return deptInfo;
	}

	public void setDeptInfo(String deptInfo) {
		this.deptInfo = deptInfo;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "TbDept [deptId=" + deptId + ", deptName=" + deptName + ", deptInfo=" + deptInfo + ", created=" + created
				+ "]";
	}
	
}
