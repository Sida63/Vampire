package cn.edu.xjtu.se.vampire.test;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import cn.edu.xjtu.se.vampire.hibernate.dao.GoodsDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.Goods;
import cn.edu.xjtu.se.vampire.hibernate.entity.GoodsDetail;
import cn.edu.xjtu.se.vampire.hibernate.entity.GoodsType;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.Utilities;
public class TestGoodsDao {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated constructor stub
		Connection conn=null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * Test the save method
		 */
		
//		assert(conn != null);
//		GoodsDAO tgd=new GoodsDAO();
//		Goods good=new Goods();
//		assert(good != null);
//		GoodsDetail detail =new GoodsDetail();
//		GoodsType type=new GoodsType();
//		String name="SDEER女装";
//		String num="5442";
//		String tag="裙子好漂漂";
//		type.setId(1);
//		detail.setPrice(499);
//		detail.setStorage(3);
//		detail.setSales(0);
//		detail.setGoods(good);
//		good.setGoodsName(name);
//		good.setGoodsNumber(num);
//		good.setTags(tag);
//		good.setGoodsDetail(detail);
//		good.setType(type);
		
//		tgd.save(good);
		/*
		 * Test the find and select method
		 */
		assert(conn != null);
		GoodsDAO tgd=new GoodsDAO();
		StringBuilder sb = new StringBuilder();
		List<Goods> goods;
		goods=tgd.selectLastest("order by id desc limit 5");
		Iterator it=goods.iterator();
		Goods goods1=null;
		Goods goods2=null;
		while(it.hasNext()){
			goods1=(Goods) it.next();
			goods2=(Goods) goods1.clone();
			sb.append(Utilities.toJSONStringFiltered(goods2));
			
		}
		System.out.println(sb);
//		System.out.println(good1.getGoodsName());
		
//		List<Goods> goodselect =tgd.select("tags="+tag);
//		for(Goods good2:goodselect)
//			System.out.println(good2.getGoodsName());
		/*
		 * Test the delete method...before doing this you must find an object
		 */
		
//		tgd.delete(good1);
		
	}

}
