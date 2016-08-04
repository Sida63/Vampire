package cn.edu.xjtu.se.vampire.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xjtu.se.vampire.hibernate.entity.Goods;

public class BestGoodsServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("我是init()方法！用来进行初始化工作");
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/json");
		resp.setCharacterEncoding("GB18030");
		Goods []goods=new Goods[5];
		
		
		
		
	  System.out.println("我是doGet()方法！用来处理GET请求");
	  PrintWriter out = resp.getWriter();
	  out.println("<HTML>");
	  out.println("<BODY>");
	  out.println("这是Servlet的例子");
	  out.println("</BODY>");
	  out.println("</HTML>");
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("我是destroy()方法！用来进行销毁实例的工作");
	}



}
