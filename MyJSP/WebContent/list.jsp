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
				<th>操作</th>
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
			<td>
			<!-- 
				onclick表示当所在元素被点击的时候要执行的脚本
			 -->
				<a href="javascript:void(0);"
		onclick="toDelete('${goods.gid}','${goods.gname}')">删除</a>
				<a href="toModify.servlet?gid=${goods.gid}">修改</a>
			</td>
		</tr>	
		</c:forEach>				
		</tbody>
	</table>
	
	<script type="text/javascript">
		/* script标记用于编写页面脚本(编程语言)，
			一般都是javascript(js)*/
		/* function是定义方法，格式是function 名称(参数...){} */
		function toDelete(id, name) {
			//在浏览器的控制台输出信息(ie系浏览器无效)
			console.log("删除的信息：", id, "-", name);
			//确认对话框
			var r = confirm("是否删除:" + name + "(" + id + ")");
			alert(r); //弹出对话框显示用户的选择
			//用户确认就删除
			
			if (r) {
				//location.href="url地址"
				//表示将当前页面切换到url地址指定的值
				location.href = "delete.servlet?gid=" + id;
			}

		}
		
		
		
	</script>
</body>
</html>