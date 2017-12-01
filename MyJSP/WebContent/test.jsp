<%@page import="cn.huhuiyu.dao.Db"%>
<%@page import="cn.huhuiyu.test.Test"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>第一个jsp页面</title>
</head>
<body>
	<h1><%=Db.getConn().getCatalog() %></h1>
	<h1>
		<%
			//<%是放置服务器端的java代码，在浏览器端无法看到
			//只会显示到java代码执行后的结果
			//<%=会直接输出=号后面的数据
			//这样程序员能完美的控制页面的输出
		%>
		jsp是java服务器页面的意思<%=Test.getNow()%>

		<%
			for (int i = 1; i <= 5; i++) {
				//out是输出到浏览器的对象
				out.println("jsp页面循环:" + i + "<br/>");
			}
		%>

		<%
			for (int i = 1; i <= 5; i++) {
		%>
		<span style="color: red;">jsp嵌套<%=i%></span><br />
		<%
			}
		%>
		<!--
		 创建一个新的网站，添加一个jsp页面，用java代码输出99乘法表
	 -->
		<%
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= i; j++) {
					out.print(String.format("%s*%s=%s ", i, j, (i * j)));
				}
				out.print("<br/>");
			}
		%>
	</h1>
</body>
</html>