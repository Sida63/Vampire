package cn.edu.xjtu.se.vampire.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xjtu.se.vampire.hibernate.dao.CommentsDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.GoodsDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.Comments;
import cn.edu.xjtu.se.vampire.hibernate.entity.User;
import cn.edu.xjtu.se.vampire.util.Utilities;

public class CommentsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4766799179162277992L;

	/**
	 * Constructor of the object.
	 */
	public CommentsServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("GB18030");

		// if this is a valid url
		String url = request.getRequestURI();
		
		System.out.println(url);
		
//		Pattern ptn = Pattern.compile(".*/goods(/(\\d*)((?<=\\d)/)?)?$/brief");
//		Matcher matcher = ptn.matcher(url);
//		if(!matcher.matches()) {
//			response.sendError(400);
//			return;
//		}
//		
//		int goodsid = Utilities.parseId(matcher.group(2));
		int goodsid=21;
		StringBuilder sb = new StringBuilder();
		GoodsDAO goodsdao = new GoodsDAO();
		if(goodsid != -1) { // for detail delivery info			
			Set<Comments> comments=goodsdao.findById(goodsid).getComments();
			if(comments == null) {
				response.sendError(404);
				return;
			}
			
			// we don't need to return user info and other infos here,
			// so clone a copy, detach it from hibernate, and set unused properties to null.
			// it is detached from the hibernate session before we can modify it.
			// to avoid unwanted changes in database.

		
			
			Set<Comments> res = new HashSet<>();
			for(Comments comment : comments) {
				res.add((Comments)comment.clone());
			}
			
			sb.append(Utilities.toJSONStringFiltered(res));
		}
		
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
		out.flush();
		out.close();
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("GB18030");
		
		// whether logined
		User user = (User) request.getSession().getAttribute("user");
		if(null == user) {
			response.sendError(401);
			return;
		}
		
		// build comment
		int rate = Integer.valueOf(request.getParameter("rate"));
		String text = request.getParameter("text");
		int ID=Integer.valueOf(request.getParameter("ID"));
		GoodsDAO goodsdao=new GoodsDAO();
		Comments com=new Comments();
		
		com.setGoods(goodsdao.findById(ID));
		com.setUser(user);
		com.setRate((short)rate);
		com.setText(text);
		
		new CommentsDAO().save(com);
		
		
	}

	/**
	 * The doPut method of the servlet. <br>
	 *
	 * This method is called when a HTTP put request is received.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Put your code here
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
