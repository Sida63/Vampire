package cn.edu.xjtu.se.vampire.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xjtu.se.vampire.hibernate.dao.CouponDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.CouponPropDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.OrderDetailDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.OrdersDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.UserDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.Coupon;
import cn.edu.xjtu.se.vampire.hibernate.entity.CouponProp;
import cn.edu.xjtu.se.vampire.hibernate.entity.OrderDetail;
import cn.edu.xjtu.se.vampire.hibernate.entity.Orders;
import cn.edu.xjtu.se.vampire.hibernate.entity.User;
import cn.edu.xjtu.se.vampire.util.Utilities;

public class OrderManServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OrderManServlet() {
		super();
	}
	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String path=request.getRequestURI();
		switch(path){
		case "/Vampire/garlic/user/orderman/table":
			show(request,response);
		break;
		case "/Vampire/garlic/user/orderman/load":
			showmain(request,response);
		default:
			response.sendRedirect("/Vampire/garlic/404.html");
		}
		
	}
	
	public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		response.setCharacterEncoding("utf-8");
		
		
			//int id = Integer.parseInt(request.getParameter("id"));
		int id=7;
			OrdersDAO ordersdao = new OrdersDAO();
			Orders order=ordersdao.findById(id);
			if(null == order) {
				response.sendError(401);
				return;
			}
			String url = request.getRequestURI();
			
			System.out.println(url);
			Set<OrderDetail> ord=order.getOrderDetails();
			StringBuilder sb = new StringBuilder();
			
			 // a delivery info list for the logined user
			Set<OrderDetail> res = new HashSet<>();
			for(OrderDetail dl : ord) {
				res.add((OrderDetail)dl.clone(true));
			}
			
			sb.append(Utilities.toJSONStringFiltered(res));

			
		PrintWriter out = response.getWriter();
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public void showmain(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("application/json");
		
		// whether logined
	
		List<Orders> ors=new OrdersDAO().findAll();
		//User user = (User) request.getSession().getAttribute("user");
		if(null == ors) {
			response.sendError(401);
			return;
		}
		
		// if this is a valid url
		String url = request.getRequestURI();
		
		System.out.println(url);
		
		
		Pattern ptn = Pattern.compile(".*/garlic/user/orderman/load");
		Matcher matcher = ptn.matcher(url);
		if(!matcher.matches()) {
			response.sendError(400);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		
		 // a delivery info list for the logined user
		
			Iterator it = ors.iterator();
			List<Orders> res1=new ArrayList<Orders>();
			Orders temp=null;
			while(it.hasNext()){
				temp=(Orders)it.next();
				res1.add((Orders)temp.clone());
			}
			sb.append(Utilities.toJSONStringFiltered(res1));
		
		
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}
	
	

}
