package cn.edu.xjtu.se.vampire.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cn.edu.xjtu.se.vampire.dao.GoodsDaoImpl;
import cn.edu.xjtu.se.vampire.entity.Goods;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;

public class TestGoodsDelete {


		public static void main(String[] args) throws Exception {
			System.out.println(JDBCUtil.getConnection());
			GoodsDaoImpl goodsdao= new GoodsDaoImpl();
			Set<Goods> set=new HashSet<Goods>();
			set=goodsdao.select("Goods.ID=10");
			Iterator<Goods> it=set.iterator(); 
			Goods g=new Goods();
	        while(it.hasNext()){  
	            g=(Goods)it.next(); 
	            System.out.println(g.getName());  
	            System.out.println(g.getDetail().getID());
	        } 
	        goodsdao.delete(g);
	        System.out.println(goodsdao.delete(g));
			
			
			
			
	}


}