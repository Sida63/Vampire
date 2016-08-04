package cn.edu.xjtu.se.vampire.test;

import java.util.Date;
import java.util.Random;
import java.util.Set;

import cn.edu.xjtu.se.vampire.dao.CouponDaoImpl;
import cn.edu.xjtu.se.vampire.dao.CouponPropDaoImpl;
import cn.edu.xjtu.se.vampire.dao.GoodsTypeDaoImpl;
import cn.edu.xjtu.se.vampire.entity.Coupon;
import cn.edu.xjtu.se.vampire.entity.CouponProp;
import cn.edu.xjtu.se.vampire.entity.GoodsType;
import cn.edu.xjtu.se.vampire.util.Utilities;

public class TestBelongTang {

	public static void main(String[] args) throws Exception {
		
	}
	
	public static void selectGoodsType(String key){
		Set<GoodsType> set = new GoodsTypeDaoImpl().select(key);
		for(GoodsType gt : set){
			StringBuffer jpsb = new StringBuffer();
			jpsb.append(gt.getID()).append("\t")
			.append(gt.getGoodsType());
			System.out.println(jpsb.toString());
		}
	}
	
	public static void deleteGoodsType(){
		GoodsType gt = new GoodsType();
		gt.setID(4);
		new GoodsTypeDaoImpl().delete(gt);
	}
	
	public static void updateGoodsType(){
		GoodsType gt = new GoodsType();
		gt.setID(4);
		gt.setGoodsType("¼á¹û");
		new GoodsTypeDaoImpl().update(gt);
	}
	
	public static void addGoodsType(){
		GoodsType gt = new GoodsType();
		gt.setGoodsType("ÅÝÃæ");
		new GoodsTypeDaoImpl().add(gt);
	}
	
	public static void selectCoupon(String key){
		Set<Coupon> set = new CouponDaoImpl().select(key);
		for(Coupon coupon : set){
			StringBuffer jpsb = new StringBuffer();
			jpsb.append(coupon.getID()).append("\t")
			.append(coupon.getCouponNum()).append("\t")
			.append(coupon.getUserID()).append("\t")
			.append(coupon.getProperty().getID()).append("\t")
			.append(coupon.getIssueTime().toString());
			System.out.println(jpsb.toString());
		}
	}

	public static void deleteCoupon(){
		Coupon coupon = new Coupon();
		coupon.setID(3);
		new CouponDaoImpl().delete(coupon);
	}
	
	public static void updateCoupon(){
		Coupon coupon = new Coupon();
		coupon.setID(2);
		coupon.setCouponNum(Utilities.generateCodes(32));
		coupon.setUserID(1);
		CouponProp prop = new CouponProp();
		prop.setID(4);
		coupon.setProperty(prop);
		coupon.setIssueTime(new Date());
		new CouponDaoImpl().update(coupon);
	}
	
	public static void addCoupon(){
		Coupon coupon = new Coupon();
		coupon.setCouponNum(Utilities.generateCodes(32));
		coupon.setUserID(1);
		CouponProp prop = new CouponProp();
		prop.setID(8);
		coupon.setProperty(prop);
		coupon.setIssueTime(new Date());
		new CouponDaoImpl().add(coupon);
	}
	
	public static void selectCouponProp(String key) {
		Set<CouponProp> set = new CouponPropDaoImpl().select(key);
		for (CouponProp prop : set) {
			StringBuffer jpsb = new StringBuffer();
			jpsb.append(prop.getID()).append("\t").append(prop.getLimit())
					.append("\t").append(prop.getDiscount()).append("\t")
					.append(prop.getLeast()).append("\t")
					.append(prop.getGuarantee());
			System.out.println(jpsb.toString());
		}
	}

	public static void deleteCouponProp() {
		Random random = new Random();
		CouponPropDaoImpl couponPropDaoImpl = new CouponPropDaoImpl();
		CouponProp prop = new CouponProp();
		prop.setID(random.nextInt(10));
		couponPropDaoImpl.delete(prop);
		System.out.println(prop.getID());
	}

	public static void updateCouponProp() {
		Random random = new Random();
		CouponPropDaoImpl couponPropDaoImpl = new CouponPropDaoImpl();
		CouponProp prop = new CouponProp();
		prop.setID(random.nextInt(10));
		prop.setLimit(random.nextInt(10));
		prop.setDiscount(random.nextInt(10) * 100 + 100);
		prop.setLeast(0);
		prop.setGuarantee(random.nextInt(100));
		couponPropDaoImpl.update(prop);
		System.out.println(prop.getID());
	}

	public static void addCouponProp(int n) {
		Random random = new Random();
		CouponPropDaoImpl couponPropDaoImpl = new CouponPropDaoImpl();
		for (int i = 0; i < n; i++) {
			CouponProp prop = new CouponProp();
			prop.setLimit(random.nextInt(10));
			prop.setDiscount(random.nextInt(10) * 100 + 100);
			prop.setLeast(0);
			prop.setGuarantee(random.nextInt(100));
			couponPropDaoImpl.add(prop);
		}
	}
}
