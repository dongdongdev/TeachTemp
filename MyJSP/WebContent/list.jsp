<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //导入jstl（java标准标签库），前缀是c，标签库用于扩展html标记 %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp配合servlet</title>
</head>
<body>
	<%
		//jsp可以获取servlet里面通过request.setAttribute中的数据
	%>
	<h1>获取到servlet的数据：</h1>
	<%=request.getAttribute("list") %>
	<hr>
	<form action="submit.servlet" method="post">
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
	<hr>
	<table border="1" style="width: 800px;margin: 0px auto;">
		<thead>
			<tr>
				<th>序号</th>
				<th>商品名称</th>
				<th>商品信息</th>
				<th>价格</th>
				<th>数量</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="goods" varStatus="vs">
			<c:if test="${vs.count % 2==1}">
				<c:set var="color" value="yellow"></c:set>
			</c:if>				
			<c:if test="${vs.count % 2==0}">
				<c:set var="color" value="red"></c:set>
			</c:if>			
		<tr style="background-color: ${color};">
			<td>${vs.count}-${vs.index}</td>
			<td>${goods.gname}</td>
			<td>${goods.ginfo}</td>
			<td>${goods.price}</td>
			<td>${goods.amount}</td>
		</tr>	
		</c:forEach>				
		</tbody>
	</table>
	
	
</body>
</html>