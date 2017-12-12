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

@WebServlet(name="delete",urlPatterns="/delete.servlet")
public class DeleteServlet extends HttpServlet{

	private static final long serialVersionUID = -7585057585263330185L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) 
					throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		TbGoods goods=new TbGoods();
		goods.setGid(Integer.parseInt(req.getParameter("gid")));
		TbGoodsDAO dao=new TbGoodsDAO();
		try {
			dao.setConnection(Db.getConn());
			dao.delete(goods);
			dao.getConnection().close();
		} catch (Exception e) {
			throw new ServletException(e);
		}
		resp.sendRedirect("list.servlet");
	}
	
}
