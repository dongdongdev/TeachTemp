<%@page import="cn.huhuiyu.dao.Db"%>
<%@page import="cn.huhuiyu.dao.TbGoodsDAO"%>
<%@page import="cn.huhuiyu.entity.TbGoods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//delete.jsp?gid=x
	TbGoods goods=new TbGoods();
	//get提交也是request.getParameter获取提交的数据
	goods.setGid(Integer.parseInt(request.getParameter("gid")));
	TbGoodsDAO dao=new TbGoodsDAO();
	dao.setConnection(Db.getConn());
	dao.delete(goods);
	dao.getConnection().close();
	//通知浏览器强制转到其它页面（form.jsp）
	Thread.sleep(3000);
	response.sendRedirect("form.jsp");
%>