<%@page import="cn.huhuiyu.entity.TbGoods"%>
<%@page import="java.util.List"%>
<%@page import="cn.huhuiyu.dao.Db"%>
<%@page import="cn.huhuiyu.dao.TbGoodsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	TbGoodsDAO dao=new TbGoodsDAO();
	dao.setConnection(Db.getConn());
	List<TbGoods> list=dao.query();
	dao.getConnection().close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form.jsp</title>
</head>
<body>
<!--
	form是提交数据的元素（表单）
	表单里面的输入元素都需要指定name属性
	当表单被提交的时候，会以name=值的方式传递给action指定的页面
	只有动态网站技术(jsp,asp.net,php....)才能处理表单提交的数据
	get表示通过地址栏传递数据，程序猿一般不用
	post表示通过表单体提交数据（不会出现在地址栏中）程序猿默认提交方式
 -->
	<form action="submit.jsp" method="post">
		商品名称：
		<input type="text" name="gname" placeholder="请输入">
		商品描述：
		<input type="text" name="ginfo">
		商品价格： 
		<input type="text" name="price">
		商品数量：
		<input type="text" name="amount">
		<input type="submit" value="提交">
	</form>
	<table border="1" style="width: 800px;margin: 0px auto;">
		<thead>
			<tr>
				<th>编号</th>
				<th>名称</th>
				<th>描述</th>
				<th>价格</th>
				<th>数量</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(TbGoods goods:list){
			%>
			<tr>
				<td><%=goods.getGid() %></td>
				<td><%=goods.getGname() %></td>
				<td><%=goods.getGinfo() %></td>
				<td><%=goods.getPrice() %></td>
				<td><%=goods.getAmount() %></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>