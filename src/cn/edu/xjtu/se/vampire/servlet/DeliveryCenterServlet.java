/*
 * Copyright (c) 2014, Aetf <7437103@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package cn.edu.xjtu.se.vampire.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xjtu.se.vampire.hibernate.dao.AreaInfoDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.DeliveryDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.AreaInfo;
import cn.edu.xjtu.se.vampire.hibernate.entity.Delivery;
import cn.edu.xjtu.se.vampire.hibernate.entity.User;
import cn.edu.xjtu.se.vampire.util.AreaCodeHelper;
import cn.edu.xjtu.se.vampire.util.UtilForNet;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author Aetf Created at 2014年3月5日 下午7:13:53
 */
public class DeliveryCenterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8200708590494545253L;

	/**
	 * Constructor of the object.
	 */
	public DeliveryCenterServlet() {
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
	 * The doDelete method of the servlet. <br>
	 * 
	 * This method is called when a HTTP delete request is received.
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
	public void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("GB18030");

		// whether logined
		User user = (User) request.getSession().getAttribute("user");
		if (null == user) {
			response.sendError(401);
			return;
		}

		// if this is a valid url
		String url = request.getRequestURI();
		Pattern ptn = Pattern.compile("^/user/deliveries/(\\d+)/?$");
		Matcher matcher = ptn.matcher(url);
		int deliverId = -1;
		if (!matcher.matches()
				|| (deliverId = Utilities.parseId(matcher.group(1))) == -1) {
			response.sendError(400);
			return;
		}

		DeliveryDAO dld = new DeliveryDAO();
		Delivery dl = dld.findById(deliverId);

		dld.delete(dl);

		PrintWriter out = response.getWriter();
		out.print("{ \"status\" : \"done\" }");
		out.flush();
		out.close();
	}

	/**
	 * The doGet method of the servlet. <br>
	 * Return a list of deliveries of the specific user or a specific delivery
	 * info if an id is supplied in the url.
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
		Pattern ptn2 = Pattern
				.compile(".*/area(/(?=\\d))?(\\d*)/list$");
		Matcher matcher2 = ptn2.matcher(url);
		if (matcher2.matches()) {
			doArea(matcher2, response);
			return;
		}
		
		// whether logined
		User user = (User) request.getSession().getAttribute("user");
		if (null == user) {
			response.sendError(401);
			return;
		}
		
		Pattern ptn1 = Pattern
				.compile(".*/user/deliveries(/(\\d*)((?<=\\d)/)?)?$");
		Matcher matcher1 = ptn1.matcher(url);
		if (matcher1.matches()) {
			doDelivery(matcher1, user, response);
			return;
		}
	}
	
	protected void doArea(Matcher matcher, HttpServletResponse response)
			throws IOException {
		String ids = matcher.group(2);
		int code = Utilities.parseId(ids);
		AreaInfoDAO aid = new AreaInfoDAO();
		List<AreaInfo> lp = null, lc = null, lt = null;
		
		if(code == -1) {
			lp = aid.findAllProvince();
			lc = new ArrayList<>();
			lt = new ArrayList<>();
		} else{
			if(AreaCodeHelper.isProvince(code)) {
				lp = new ArrayList<>();
				lp.add(aid.findById(code));
				lc = aid.findAllCity(code);
				lt = new ArrayList<>();
			} else if(AreaCodeHelper.isCity(code)) {
				lp = new ArrayList<>();
				lp.add(aid.findById(AreaCodeHelper.getProvince(code)));
				lc = new ArrayList<>();
				lc.add(aid.findById(code));
				lt = aid.findAllTown(code);
			} else{
				lp = new ArrayList<>();
				lp.add(aid.findById(AreaCodeHelper.getProvince(code)));
				lc = new ArrayList<>();
				lc.add(aid.findById(AreaCodeHelper.getCity(code)));
				lt = new ArrayList<>();
				lt.add(aid.findById(code));
			}
		}
		
		Map<String, Object> map = new HashMap<>();
		List<AreaInfo> res;
		
		res = new ArrayList<>();
		for(AreaInfo ai : lp) {
			res.add((AreaInfo) ai.clone());
		}
		map.put("provinces", res);
		
		res = new ArrayList<>();
		for(AreaInfo ai : lc) {
			res.add((AreaInfo) ai.clone());
		}
		map.put("cities", res);
		
		res = new ArrayList<>();
		for(AreaInfo ai : lt) {
			res.add((AreaInfo) ai.clone());
		}
		map.put("towns", res);
		
		StringBuilder sb = new StringBuilder();
		sb.append(Utilities.toJSONStringFiltered(map));
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
		out.flush();
		out.close();
	}

	protected void doDelivery(Matcher matcher, User user, HttpServletResponse response)
			throws IOException {
		
		int deliverId = Utilities.parseId(matcher.group(2));
		StringBuilder sb = new StringBuilder();
		DeliveryDAO dld = new DeliveryDAO();
		if (deliverId != -1) { // for detail delivery info
			Delivery dl = dld.findById(deliverId);
			if (dl == null) {
				response.sendError(404);
				return;
			}

			// we don't need to return user info and other infos here,
			// so clone a copy, detach it from hibernate, and set unused
			// properties to null.
			// it is detached from the hibernate session before we can modify
			// it.
			// to avoid unwanted changes in database.
			dl = (Delivery) dl.clone();
			sb.append(Utilities.toJSONStringFiltered(dl));
		} else { // a delivery info list for the logined user
			Set<Delivery> ldl = user.getDeliveries();
			Set<Delivery> res = new HashSet<>();
			for (Delivery dl : ldl) {
				Delivery d = (Delivery) dl.clone();
				d.setDetailAddr(AreaCodeHelper.getFullString(d.getAreaCode()
						.getId()) + d.getDetailAddr());
				res.add(d);
			}

			Map<String, Object> map = new HashMap<>();
			map.put("defDelivery", user.getUserDetail().getDefDelivery());
			map.put("deliveries", res);

			sb.append(Utilities.toJSONStringFiltered(map));
		}
		
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

		response.setContentType("application/json");

		// whether logined
		User user = (User) request.getSession().getAttribute("user");
		if (null == user) {
			response.sendError(401);
			return;
		}

		// if this is a valid url
		String url = request.getRequestURI();
		Pattern ptn = Pattern.compile(".*/user/deliveries/?$");
		Matcher matcher = ptn.matcher(url);
		if (!matcher.matches()) {
			response.sendError(400);
			return;
		}

		DeliveryDAO dld = new DeliveryDAO();
		Delivery dl = new Delivery();

		dl.setReceiver(UtilForNet.getParamString(request, "delivery.name"));
		dl.setTel(UtilForNet.getParamString(request, "delivery.tel"));
		dl.setAreaCode(new AreaInfoDAO().findById(UtilForNet.getParamInt(request, "delivery.code")));
		dl.getAreaCode().getDeliveries().add(dl);
		dl.setDetailAddr(UtilForNet.getParamString(request, "delivery.addr"));
		dl.setUser(user);
		user.getDeliveries().add(dl);
		
		System.out.println("Got delivery info:");
		System.out.println(dl.getReceiver());
		System.out.println(dl.getTel());
		System.out.println(dl.getAreaCode().getArea());
		System.out.println(dl.getDetailAddr());
		
		dld.save(dl);

		response.setStatus(201);
		PrintWriter out = response.getWriter();
		out.print("{ \"status\" : \"ok\" }");
		out.flush();
		out.close();
	}

	/**
	 * The doPut method of the servlet. <br>
	 * 
	 * This method is called when a HTTP put request is received.
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
	public void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Put your code here
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
