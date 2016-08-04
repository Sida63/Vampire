package cn.edu.xjtu.se.vampire.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xjtu.se.vampire.hibernate.dao.GoodsDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.GoodsTypeDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.Goods;
import cn.edu.xjtu.se.vampire.hibernate.entity.GoodsDetail;
import cn.edu.xjtu.se.vampire.hibernate.entity.GoodsType;
import cn.edu.xjtu.se.vampire.util.Utilities;

public class GoodsDetailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7716536627101248431L;

	/**
	 * Constructor of the object.
	 */
	public GoodsDetailServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");

		// if this is a valid url
		String url = request.getRequestURI();

		System.out.println(url);

		Pattern ptn = Pattern
				.compile(".*/goods(/(?=\\d))?(\\d*)/(brief|detail)$");
		Matcher matcher = ptn.matcher(url);
		if (!matcher.matches()) {
			response.sendError(400);
			return;
		}

		int goodsid = Utilities.parseId(matcher.group(2));
		boolean isdetail = "detail".equals(matcher.group(3));

		StringBuilder sb = new StringBuilder();
		GoodsDAO goodsdao = new GoodsDAO();
		Goods goods = goodsdao.findById(goodsid);
		if (goods == null) {
			response.sendError(404);
			return;
		}
		goods = (Goods)goods.clone();
		if (!isdetail) { // for brief delivery info
			goods.setGoodsDetail(null);
		}
		sb.append(Utilities.toJSONStringFiltered(goods));
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Goods goods = new Goods();
		GoodsDetail detail = new GoodsDetail();
		GoodsTypeDAO typedao = new GoodsTypeDAO();
		goods.setGoodsName(request.getParameter("name"));
		goods.setGoodsNumber(request.getParameter("number"));
		goods.setTags(request.getParameter("tags"));
		List<GoodsType> type = typedao.select("goodsType="
				+ request.getParameter("type"));
		for (GoodsType tp : type)
			goods.setType(tp);
		detail.setGoodsDesc(request.getParameter("description"));
		detail.setProvider(request.getParameter("provider"));
		detail.setSales(Integer.valueOf(request.getParameter("sales")));
		detail.setStorage(Integer.valueOf(request.getParameter("storage")));
		goods.setGoodsDetail(detail);

		GoodsDAO gd = new GoodsDAO();
		gd.save(goods);

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
