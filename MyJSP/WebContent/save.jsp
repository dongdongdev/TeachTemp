<%@page import="cn.huhuiyu.dao.Db"%>
<%@page import="cn.huhuiyu.dao.TbGoodsDAO"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="cn.huhuiyu.entity.TbGoods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	TbGoods goods = new TbGoods();
	goods.setGid(Integer.parseInt(request.getParameter("gid")));
	goods.setGname(request.getParameter("gname"));
	goods.setGinfo(request.getParameter("ginfo"));
	goods.setPrice(new BigDecimal(request.getParameter("price")));
	goods.setAmount(Integer.parseInt(request.getParameter("amount")));
	TbGoodsDAO dao = new TbGoodsDAO();
	dao.setConnection(Db.getConn());
	dao.modify(goods);
	dao.getConnection().close();
	//response.sendRedirect("form.jsp");
%>
<html>
<head>
<meta charset="UTF-8">
<title>修改商品</title>

</head>
<body>
	<h1 style="text-align: center;">
		修改成功,<span id="spTime"></span>秒后 
		<a href="form.jsp">转到首页</a>
	</h1>
	
	<script type="text/javascript">
		//通过js提示信息并跳转页面
		//alert("修改成功！");
		//location="form.jsp";
		var times = 5;
		//修改id为spTime的元素的内容为times的值
		document.getElementById("spTime").innerHTML = times;
		//倒计时执行代码setInterval(执行的函数,计时毫秒数)
		setInterval(function(){
			times=times-1;
			document.getElementById("spTime").innerHTML = times;
			if(times<=0){
				location="form.jsp";
			}
		}, 1000); 
	</script>
	
</body>
</html>

