package cn.huhuiyu.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.huhuiyu.dao.Db;
import cn.huhuiyu.dao.TbGoodsDAO;
import cn.huhuiyu.entity.TbGoods;

@WebServlet(name = "modify", urlPatterns = "/modify.servlet")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = -8434907418389075799L;

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
			goods.setGname(req.getParameter("gname"));
			goods.setGinfo(req.getParameter("ginfo"));
			goods.setPrice(new BigDecimal(
					req.getParameter("price")));
			goods.setAmount(Integer.parseInt(
					req.getParameter("amount")));
			TbGoodsDAO dao=new TbGoodsDAO();
			dao.setConnection(Db.getConn());
			dao.modify(goods);
			dao.getConnection().close();
		} catch (Exception e) {
			throw new ServletException(e);
		}
		resp.sendRedirect("list.servlet");
	}
}
