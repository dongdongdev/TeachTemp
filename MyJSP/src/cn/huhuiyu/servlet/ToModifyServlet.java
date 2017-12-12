package cn.huhuiyu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.huhuiyu.dao.Db;
import cn.huhuiyu.dao.TbGoodsDAO;
import cn.huhuiyu.entity.TbGoods;

@WebServlet(name="tomodify",urlPatterns="/toModify.servlet")
public class ToModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 3444072226465576740L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");
			TbGoods goods=new TbGoods();
			goods.setGid(Integer.parseInt(req.getParameter("gid")));
			TbGoodsDAO dao=new TbGoodsDAO();
			dao.setConnection(Db.getConn());
			goods=dao.queryByKey(goods);
			dao.getConnection().close();
			req.setAttribute("goods", goods);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		req.getRequestDispatcher("modify.jsp").forward(req, resp);
	}
	
}
