package cn.huhuiyu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.huhuiyu.entity.TbGoods;

public class TbGoodsDAO extends BaseDAO {
	public static final String INSERT = "insert into TbGoods(gname,ginfo,price,amount) values(?,?,?,?) ";

	public int add(TbGoods goods) throws Exception {
		PreparedStatement ps = connection.prepareStatement(INSERT);
		ps.setString(1, goods.getGname());
		ps.setString(2, goods.getGinfo());
		ps.setBigDecimal(3, goods.getPrice());
		ps.setInt(4, goods.getAmount());
		int result = ps.executeUpdate();
		ps.close();
		return result;
	}	
	
	public int delete(TbGoods goods) throws Exception {
		throw new Exception("删除的功能需要你们自己完成");
	}

	public int modify(TbGoods goods) throws Exception {
		throw new Exception("修改的功能需要你们自己完成");
	}

	public TbGoods queryByKey(TbGoods goods) throws Exception {
		throw new Exception("按照主键查询的功能需要你们自己完成");
	}
	
	public List<TbGoods> query() throws Exception{
		List<TbGoods> list=new ArrayList<TbGoods>();
		PreparedStatement ps=connection.prepareStatement(
				"select * from TbGoods");		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			TbGoods goods=new TbGoods();		
			goods.setGid(rs.getInt("gid"));
			goods.setGname(rs.getString("gname"));
			goods.setGinfo(rs.getString("ginfo"));
			goods.setPrice(rs.getBigDecimal("price"));
			goods.setAmount(rs.getInt("amount"));
			list.add(goods);
		}
		rs.close();
		ps.close();
		return list;
	}

}
