package cn.edu.xjtu.se.vampire.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cn.edu.xjtu.se.vampire.dao.GoodsDaoImpl;
import cn.edu.xjtu.se.vampire.entity.Goods;
import cn.edu.xjtu.se.vampire.entity.GoodsDetail;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.OnePair;

public class TestBelongQiong {

	public static void main(String[] args) throws Exception {
		System.out.println(JDBCUtil.getConnection());
		TestBelongQiong test=new TestBelongQiong();
		test.TestAdd();
		test.TestSelect();
		test.TestUpdate();

		
	}
	public void TestAdd(){
		GoodsDaoImpl goodsdao= new GoodsDaoImpl();
		GoodsDetail detail=new GoodsDetail();
		Goods good=new Goods();
		good.setName("小当家干脆面");
		good.setGoodNumber("125");
		good.setDetail(detail);
		detail.setPrice(0.5);
		good.setTags("粉色的好吃");
		good.setType(OnePair.Retrive("GoodsTypeInfo", 2));
		goodsdao.add(good);
	}
	public void TestUpdate(){
		GoodsDaoImpl goodsdao= new GoodsDaoImpl();
		GoodsDetail detail=new GoodsDetail();
		Goods good=new Goods();
		good.setID(9);
		good.setName("沙琪玛");
		detail.setSales(100);
		good.setDetail(detail);
		good.setType(OnePair.Retrive("GoodsTypeInfo", 1));
		good.setGoodNumber("123");
		goodsdao.update(good);
	}
	public void TestSelect(){
		
		GoodsDaoImpl goodsdao= new GoodsDaoImpl();
		Set<Goods> set=new HashSet<Goods>();
		set=goodsdao.select("Goods.ID=7");
		Iterator<Goods> it=set.iterator();  
        while(it.hasNext()){  
            Goods g=(Goods)it.next(); 
            System.out.println(g.getName());  
            System.out.println(g.getDetail().getPrice());
        }
	
	}
	
}