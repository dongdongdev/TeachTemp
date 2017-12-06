<%@page import="cn.huhuiyu.dao.Db"%>
<%@page import="cn.huhuiyu.dao.TbGoodsDAO"%>
<%@page import="cn.huhuiyu.entity.TbGoods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	TbGoods goods=new TbGoods();
	goods.setGid(Integer.parseInt(request.getParameter("gid")));
	TbGoodsDAO dao=new TbGoodsDAO();
	dao.setConnection(Db.getConn());
	goods=dao.queryByKey(goods);
	dao.getConnection().close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
</head>
<body>
	<form action="save.jsp" method="post">
<input type="hidden" name="gid" value="<%=goods.getGid()%>">
名称：
<input type="text" name="gname" value="<%=goods.getGname()%>">
描述：
<input type="text" name="ginfo" value="<%=goods.getGinfo()%>">
价格：
<input type="text" name="price" value="<%=goods.getPrice()%>">
数量：
<input type="text" name="amount" value="<%=goods.getAmount()%>">
<input type="submit" value="保存">
	</form>
</body>
</html>