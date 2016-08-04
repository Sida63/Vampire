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
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xjtu.se.vampire.hibernate.entity.Coupon;
import cn.edu.xjtu.se.vampire.hibernate.entity.Favorite;
import cn.edu.xjtu.se.vampire.hibernate.entity.History;
import cn.edu.xjtu.se.vampire.hibernate.entity.User;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author totran
 * @version 1.0 Created at 2014年3月6日 上午9:25:19
 * 
 */
public class ProfileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3837103688211301784L;

	/**
	 * Constructor of the object.
	 */
	public ProfileServlet() {
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
		doPost(request, response);
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
		User user = (User) request.getSession().getAttribute("user");
		Set<Favorite> favorites = user.getFavorites();
		Set<Coupon> coupons = user.getCoupons();
		Set<History> histories = user.getHistories();
		StringBuffer jpsb = new StringBuffer();
		jpsb.append("{");
		jpsb.append("\"user\":")
				.append(Utilities.toJSONStringFiltered(user.clone(true)))
				.append(",");
		Set<Coupon> cpsClone = new HashSet<>();
		for (Coupon cp : coupons) {
			cpsClone.add((Coupon) cp.clone());
		}
		jpsb.append("\"coupons\":")
				.append(Utilities.toJSONStringFiltered(cpsClone)).append(",");
		Set<Favorite> fsClone = new HashSet<>();
		for (Favorite favor : favorites) {
			fsClone.add((Favorite) favor.clone(true));
		}
		jpsb.append("\"favorites\":")
				.append(Utilities.toJSONStringFiltered(fsClone)).append(",");
		Set<History> hisClone = new HashSet<>();
		for (History his : histories) {
			hisClone.add((History) his.clone(true));
		}
		jpsb.append("\"histories\":").append(
				Utilities.toJSONStringFiltered(hisClone));
		jpsb.append("}");
		response.setContentType("application/json");
		response.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		out.write(jpsb.toString());
		out.flush();
		out.close();
	}

}
