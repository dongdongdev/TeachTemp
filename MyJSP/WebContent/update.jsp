<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update.jsp</title>
</head>
<body>
	<form action="modify.servlet" method="post">
		<input type="hidden" name="gid" value="${goods.gid}">
		<label>
			名称：
			<input type="text" name="gname" value="${goods.gname}">
		</label>
		<label>
			描述：
			<input type="text" name="ginfo" value="${goods.ginfo}">
		</label>
		<label>
			价格：
			<input type="text" name="price" value="${goods.price}">
		</label>
		<label>
			数量:
			<input type="text" name="amount" value="${goods.amount}">
		</label>
		<input type="submit" value="保存">
	</form>
</body>
</html>