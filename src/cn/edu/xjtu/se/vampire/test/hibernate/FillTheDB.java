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

import cn.edu.xjtu.se.vampire.hibernate.dao.CommentsDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.CouponDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.CouponPropDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.FavoriteDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.GoodsDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.GoodsTypeDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.HistoryDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.UserDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.Comments;
import cn.edu.xjtu.se.vampire.hibernate.entity.Coupon;
import cn.edu.xjtu.se.vampire.hibernate.entity.CouponProp;
import cn.edu.xjtu.se.vampire.hibernate.entity.Favorite;
import cn.edu.xjtu.se.vampire.hibernate.entity.Goods;
import cn.edu.xjtu.se.vampire.hibernate.entity.GoodsDetail;
import cn.edu.xjtu.se.vampire.hibernate.entity.GoodsType;
import cn.edu.xjtu.se.vampire.hibernate.entity.History;
import cn.edu.xjtu.se.vampire.hibernate.entity.User;
import cn.edu.xjtu.se.vampire.hibernate.entity.UserDetail;
import cn.edu.xjtu.se.vampire.hibernate.entity.UserStatusInfo;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author totran
 * @version 1.0 Created at 2014年2月28日 下午8:03:44
 * 
 */
public class FillTheDB {

	public static final Random random = new Random();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		addCoupon(500);
	}

	public static void addHistories(int n) {
		List<Goods> goodsList = new GoodsDAO().findAll();
		List<User> userList = new UserDAO().findAll();
		HistoryDAO hd = new HistoryDAO();
		for (int i = 0; i < n; i++) {
			try {
				History history = new History();
				history.setBrowseTime(new Date());
				history.setGoods(goodsList.get(random.nextInt(goodsList.size())));
				history.setUser(userList.get(random.nextInt(userList.size())));
				hd.save(history);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void fixNamingImgPath() {
		int bugLength = 23;
		GoodsDAO gd = new GoodsDAO();
		List<Goods> goodsList = gd.findAll();
		for (Goods goods : goodsList) {
			StringBuffer jpsb = new StringBuffer(goods.getGoodsDetail()
					.getImgPath());
			if (jpsb.length() == bugLength) {
				jpsb.deleteCharAt(13);
				goods.getGoodsDetail().setImgPath(jpsb.toString());
				System.out.println(goods.getGoodsDetail().getImgPath());
				gd.getSession().getTransaction().begin();
				gd.getSession().update(goods);
				gd.getSession().getTransaction().commit();
			}
		}
		gd.getSession().close();
	}

	public static void addComments(int n) {
		// List<Goods> goodsList = new GoodsDAO().findAll();
		List<User> userList = new UserDAO().findAll();
		Goods goods = new GoodsDAO().findById(21);
		CommentsDAO cd = new CommentsDAO();
		for (int i = 0; i < n; i++) {
			try {
				Comments comments = new Comments();
				// comments.setGoods(goodsList.get(random.nextInt(goodsList.size())));
				comments.setGoods(goods);
				comments.setUser(userList.get(random.nextInt(userList.size())));
				comments.setRate((short) random.nextInt(5));
				comments.setText(Utilities.generateCodes(64));
				cd.save(comments);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void addCoupon(int n) {
		List<CouponProp> couponPropList = new CouponPropDAO().findAll();
		List<User> userList = new UserDAO().findAll();
		CouponDAO cd = new CouponDAO();
		for (int i = 0; i < n; i++) {
			try {
				Coupon coupon = new Coupon();
				coupon.setCouponNumber(Utilities.generateCodes(32));
				coupon.setIssuedTime(new Date());
				coupon.setProperty(couponPropList.get(random
						.nextInt(couponPropList.size())));
				coupon.setUser(userList.get(random.nextInt(userList.size())));
				cd.save(coupon);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void addCouponProp(int n) {
		CouponPropDAO cpd = new CouponPropDAO();
		for (int i = 0; i < n; i++) {
			try {
				CouponProp cp = new CouponProp();
				cp.setDescription(Utilities.generateCodes(16));
				cp.setLimits(random.nextInt(7));
				double discount = random.nextDouble() * 1024;
				cp.setDiscount(discount);
				cp.setLeast(discount * (random.nextInt(4) + 1));
				cp.setGuarantee(random.nextInt(64) + 1);
				cpd.save(cp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void fixCouponProp() {
		CouponPropDAO cpd = new CouponPropDAO();
		List<CouponProp> cpl = cpd.findAll();
		for (CouponProp cp : cpl) {
			try {
				if (cp.getDescription() == null
						|| cp.getDescription().equals("")) {
					cp.setDescription(Utilities.generateCodes(16));
					cpd.getSession().getTransaction().begin();
					cpd.getSession().update(cp);
					cpd.getSession().getTransaction().commit();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void addGoods(int n) {
		List<GoodsType> typeList = new GoodsTypeDAO().findAll();
		GoodsDAO gdao = new GoodsDAO();
		for (int i = 0; i < n; i++) {
			try {
				Goods goods = new Goods();
				GoodsDetail gd = new GoodsDetail();
				goods.setGoodsName(Utilities.generateCodes(8));
				goods.setGoodsNumber(Utilities.generateMd5sum(Integer
						.toString(i)));
				goods.setTags(Utilities.generateCodes(16));
				goods.setType(typeList.get(random.nextInt(typeList.size())));
				goods.setGoodsDetail(gd);
				gd.setGoods(goods);
				gd.setGoodsDesc(Utilities.generateCodes(64));
				gd.setPrice(random.nextDouble() * 1024);
				gd.setImgPath(getGoodsImg());
				gd.setProvider(Utilities.generateCodes(8));
				gd.setSales(random.nextInt(1024));
				gd.setStorage(random.nextInt(1024));
				gdao.save(goods);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static String getGoodsImg() {
		int max = 100;
		String base_path = "images/goods/";
		String path = Integer.toString(random.nextInt(max));
		StringBuffer img = new StringBuffer(base_path);
		for (int i = 0; i < 9 - path.length(); i++) {
			img.append(0);
		}
		img.append(path);
		return img.toString();
	}

	public static void addFavorites(int n) {
		List<Goods> goodsList = new GoodsDAO().findAll();
		List<User> userList = new UserDAO().findAll();
		FavoriteDAO fd = new FavoriteDAO();
		for (int i = 0; i < n; i++) {
			try {
				Favorite favorite = new Favorite();
				favorite.setGoods(goodsList.get(random.nextInt(goodsList.size())));
				favorite.setUser(userList.get(random.nextInt(userList.size())));
				fd.save(favorite);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void addUsers(int n) {
		for (int i = 0; i < n; i++) {
			try {
				User user = new User();
				user.setMailBox(Utilities.generateCodes(8) + "@163.com");
				String salt = Utilities.generateSalt();
				user.setPassword(Utilities.generateSecPass(
						Utilities.generateCodes(8), salt));
				user.setSalt(salt);
				user.setUserName(Utilities.generateName3());
				UserDetail ud = new UserDetail();
				ud.setPhone(Utilities.generatePhoneNumber());
				ud.setRegisteTime(new Date());
				ud.setReputation(0);
				ud.setScore(0);
				ud.setUser(user);
				UserStatusInfo usi = new UserStatusInfo();
				usi.setId(2);
				usi.setUserStatus("启用");
				ud.setStatus(usi);
				user.setUserDetail(ud);
				new UserDAO().save(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
