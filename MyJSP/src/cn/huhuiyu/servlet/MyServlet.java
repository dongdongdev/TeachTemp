package cn.huhuiyu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servlet是java服务器小程序,是传统网页开发技术cgi的java版本
//cgi是通用网关接口的意思，是c语言开发的
//一个标准的Servlet继承于HttpServlet
//通过@WebServlet映射url,name表示名称，urlPatterns是url
@WebServlet(name="myservlet",urlPatterns="/my.servlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = -5727087642870239196L;
	
	//处理网页get请求的方法
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//HttpServletRequest是请求对象
		//HttpServletResponse是应答对象
		//设置应答的编码,必须是第一句
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("<h1>servlet你好！</h1>");
	}
}
