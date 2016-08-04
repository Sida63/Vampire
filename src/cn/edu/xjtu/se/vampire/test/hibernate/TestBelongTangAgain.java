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

package cn.edu.xjtu.se.vampire.test.hibernate;

import java.util.Date;
import java.util.List;
import java.util.Random;

import cn.edu.xjtu.se.vampire.hibernate.dao.CouponDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.CouponPropDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.UserDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.Coupon;
import cn.edu.xjtu.se.vampire.hibernate.entity.CouponProp;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author totran
 * @version 1.0 Created at 2014年3月3日 上午9:51:16
 * 
 */
public class TestBelongTangAgain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		updateTestMerge();
	}

	public static void updateTestMerge() {
		CouponPropDAO cpd = new CouponPropDAO();
		CouponProp cp = cpd.findById(23);
		cp.setLimits(4);
		cp.setDiscount(200);
		cp.setLeast(300);
		cp.setGuarantee(100);
		cp.setDescription("重要的信件！！！");
		cpd.update(cp);		
	}

	public static void findCoupon() {

	}

	public static void deleteCoupon() {
		CouponDAO cpd = new CouponDAO();
		cpd.delete(cpd.findById(1));
	}

	public static void updateCoupon() {

	}

	public static void addCoupon() {
		Coupon coupon = new Coupon();
		coupon.setCouponNumber(Utilities.generateCodes(32));
		coupon.setUser(new UserDAO().findById(108));
		coupon.setProperty(new CouponPropDAO().findById(17));
		coupon.setIssuedTime(new Date());
		new CouponDAO().save(coupon);
	}

	public static void findCouponProp() {
		List<CouponProp> list = new CouponPropDAO().findAll();
		for (CouponProp cp : list) {
			System.out.println(cp.getId());
		}
	}

	public static void deleteCouponProp() {
		CouponPropDAO cpd = new CouponPropDAO();
		cpd.delete(cpd.findById(8));
	}

	public static void updateCouponProp() {

	}

	public static void addCouponProp(int n) {
		Random random = new Random();
		CouponPropDAO cpd = new CouponPropDAO();
		for (int i = 0; i < n; i++) {
			CouponProp prop = new CouponProp();
			prop.setLimits(random.nextInt(10));
			prop.setDiscount(random.nextInt(10) * 100 + 100);
			prop.setLeast(0);
			prop.setGuarantee(random.nextInt(100));
			cpd.save(prop);
		}
	}
}
