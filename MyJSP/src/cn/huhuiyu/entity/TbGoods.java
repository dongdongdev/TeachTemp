package cn.huhuiyu.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TbGoods implements Serializable {

	private static final long serialVersionUID = 9007480182566719103L;
	
	private int gid;
	private String gname;
	private String ginfo;
	private BigDecimal price;
	private int amount;
	
	public TbGoods() {
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGinfo() {
		return ginfo;
	}

	public void setGinfo(String ginfo) {
		this.ginfo = ginfo;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TbGoods [gid=" + gid + ", gname=" + gname + ", ginfo=" + ginfo + ", price=" + price + ", amount="
				+ amount + "]";
	}
	
	
	

}
