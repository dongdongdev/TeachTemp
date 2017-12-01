<%@page import="cn.huhuiyu.dao.Db"%>
<%@page import="cn.huhuiyu.dao.TbGoodsDAO"%>
<%@page import="cn.huhuiyu.entity.TbGoods"%>
<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");//设置请求数据编码
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>submit.jsp</title>
</head>
<body>
	<%
		//获取表单提交的数据,参数是表单元素的name,取到的是表单元素的值
		String gname=request.getParameter("gname");
		String ginfo=request.getParameter("ginfo");
		BigDecimal price=new BigDecimal(
				request.getParameter("price"));
		int amount=Integer.parseInt(
				request.getParameter("amount"));
		//将数据包装成实体类
		TbGoods goods=new TbGoods();
		goods.setGname(gname);
		goods.setGinfo(ginfo);
		goods.setPrice(price);
		goods.setAmount(amount);
		
		TbGoodsDAO dao=new TbGoodsDAO();
		dao.setConnection(Db.getConn());
		dao.add(goods);
		dao.getConnection().close();
		
	%>
	表单数据:<%=goods %>添加成功
	<a href="form.jsp">返回查询</a>
	<br />
	
	<!-- 
		创建会员卡管理数据库
		创建会员卡表（编号，卡号，电话，余额）
		创建会员管理的web项目
		创建数据库连接类
		创建会员卡实体类
		创建会员卡信息输入界面和提交处理页面
		信息输入界面添加数据查询表格
		完成提交到数据库的功能
	 -->
</body>
</html>