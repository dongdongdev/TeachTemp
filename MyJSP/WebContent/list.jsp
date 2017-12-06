<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</body>
</html>