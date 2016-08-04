package cn.edu.xjtu.se.vampire.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.edu.xjtu.se.vampire.entity.Order;
import cn.edu.xjtu.se.vampire.hibernate.dao.DeliveryDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.OrdersDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.UserDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.Delivery;
import cn.edu.xjtu.se.vampire.hibernate.entity.Orders;
import cn.edu.xjtu.se.vampire.hibernate.entity.User;
import cn.edu.xjtu.se.vampire.util.Utilities;

public class OrderHistoryServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public OrderHistoryServlet() {
		super();
	}
	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("GB18030");
		
		// whether logined
		User user = new UserDAO().findById(22);
		//User user = (User) request.getSession().getAttribute("user");
		if(null == user) {
			response.sendError(401);
			return;
		}
		
		// if this is a valid url
		String url = request.getRequestURI();
		
		System.out.println(url);
		
		
		Pattern ptn = Pattern.compile(".*/user/orderhistory");
		Matcher matcher = ptn.matcher(url);
		if(!matcher.matches()) {
			response.sendError(400);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		
		 // a delivery info list for the logined user
			Set<Orders> ldl = user.getOrders();
			Set<Orders> res = new HashSet<>();
			for(Orders dl : ldl) {
				res.add((Orders)dl.clone());
			}
			
			sb.append(Utilities.toJSONStringFiltered(res));
		
		
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
		out.flush();
		out.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		Set<Orders> list;
////		User user=(User)request.getAttribute("user");
//		User user = new UserDAO().findById(22);
//		
////		String username=user.getUserName();
////		int userid=user.getId();
//		list = user.getOrders();
//		String jsonString=JSON.toJSONString(list);
//		
//		PrintWriter out = response.getWriter();
//		out.write(jsonString);
//		out.flush();
//		out.close();
//		
		
	}
	
	public void init() throws ServletException {
		// Put your code here
	}

}
