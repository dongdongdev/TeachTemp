package cn.huhuiyu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.huhuiyu.dao.Db;
import cn.huhuiyu.dao.TbGoodsDAO;
import cn.huhuiyu.entity.TbGoods;

@WebServlet(name = "listservlet", urlPatterns = "/list.html")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 3202859730005281176L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TbGoodsDAO dao = new TbGoodsDAO();
		try {
			dao.setConnection(Db.getConn());
			List<TbGoods> list = dao.query();
			dao.getConnection().close();
			// 将查询的数据放到请求中
			req.setAttribute("list", list);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// java代码部分完成后，将页面请求转发给jsp(list.jsp)
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}

}
