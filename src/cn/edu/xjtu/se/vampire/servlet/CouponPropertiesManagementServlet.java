/**
 * Copyright (c) 2014, totran <392165719@qq.com>
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
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xjtu.se.vampire.hibernate.dao.CouponDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.CouponPropDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.Coupon;
import cn.edu.xjtu.se.vampire.hibernate.entity.CouponProp;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author totran
 * @version 1.0 Created at 2014年3月8日 上午9:54:00
 * 
 */
public class CouponPropertiesManagementServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1404531787881825920L;

	/**
	 * Constructor of the object.
	 */
	public CouponPropertiesManagementServlet() {
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
		String path = request.getRequestURI();
		switch (path) {
			case "/Vampire/management/coupon_prop/man":
				getCouponProps(request, response);
				break;
			case "/Vampire/management/coupon_prop/add":
				addCouponProp(request, response);
				break;
			case "/Vampire/management/coupon_prop/update":
				updateCouponProp(request, response);
				break;
			case "/Vampire/management/coupon_prop/del":
				deleteCouponProp(request, response);
				break;
			default:
				response.sendRedirect("/Vampire/garlic/404.html");
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void updateCouponProp(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean flag = true;
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			int limits = Integer.parseInt(request.getParameter("limits"));
			double discount = Double.parseDouble(request
					.getParameter("discount"));
			double least = Double.parseDouble(request.getParameter("least"));
			int guarantee = Integer.parseInt(request.getParameter("guarantee"));
			String description = request.getParameter("description");
			CouponPropDAO cpd = new CouponPropDAO();
			CouponProp cp = cpd.findById(id);
			cp.setLimits(limits);
			cp.setDiscount(discount);
			cp.setLeast(least);
			cp.setGuarantee(guarantee);
			cp.setDescription(description);
			flag = cpd.update(cp);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(Boolean.toString(flag));
		out.flush();
		out.close();
	}

	public void getCouponProps(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<CouponProp> cpList = new CouponPropDAO().findAll();
		List<CouponProp> cpClone = new ArrayList<>();
		for (CouponProp cp : cpList) {
			cpClone.add((CouponProp) cp.clone());
		}
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(Utilities.toJSONStringFiltered(cpClone));
		out.flush();
		out.close();
	}

	public void addCouponProp(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean flag = true;
		try {
			int limits = Integer.parseInt(request.getParameter("limits"));
			double discount = Double.parseDouble(request
					.getParameter("discount"));
			double least = Double.parseDouble(request.getParameter("least"));
			int guarantee = Integer.parseInt(request.getParameter("guarantee"));
			String description = request.getParameter("description");
			CouponProp cp = new CouponProp();
			cp.setLimits(limits);
			cp.setDiscount(discount);
			cp.setLeast(least);
			cp.setGuarantee(guarantee);
			cp.setDescription(description);
			flag = new CouponPropDAO().save(cp);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(Boolean.toString(flag));
		out.flush();
		out.close();
	}

	public void deleteCouponProp(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean flag = true;
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			CouponPropDAO couponPropDAO = new CouponPropDAO();
			CouponProp couponProp = couponPropDAO.findById(id);
			CouponDAO couponDAO = new CouponDAO();
			List<Coupon> coupons = couponDAO.findAll();
			for (Coupon coupon : coupons) {
				if (coupon.getProperty().equals(couponProp)) {
					flag = flag && couponDAO.delete(coupon);
				}
			}
			flag = flag && couponPropDAO.delete(couponProp);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(Boolean.toString(flag));
		out.flush();
		out.close();
	}
}
