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

@WebServlet(name = "submit", urlPatterns = "/submit.servlet")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = -8554043919683628505L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		TbGoods goods = new TbGoods();
		goods.setGname(req.getParameter("gname"));
		goods.setGinfo(req.getParameter("ginfo"));
		goods.setPrice(new BigDecimal(req.getParameter("price")));
		goods.setAmount(Integer.parseInt(req.getParameter("amount")));
		try {
			TbGoodsDAO dao = new TbGoodsDAO();
			dao.setConnection(Db.getConn());
			dao.add(goods);
			dao.getConnection().close();
		} catch (Exception e) {
			throw new ServletException(e);
		}
		// 添加完成后，请求重定向转到list.servlet
		resp.sendRedirect("list.servlet");
	}

}
