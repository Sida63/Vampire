package cn.edu.xjtu.se.vampire.test;

import cn.edu.xjtu.se.vampire.hibernate.dao.HistoryDAO;
//import cn.edu.xjtu.se.vampire.dao.HistoryDaoImpl;
//import cn.edu.xjtu.se.vampire.dao.interfaces.IHistoryDao;
//import cn.edu.xjtu.se.vampire.entity.Goods;
//import cn.edu.xjtu.se.vampire.entity.HistoryLine;
import cn.edu.xjtu.se.vampire.hibernate.entity.Goods;
import cn.edu.xjtu.se.vampire.hibernate.entity.History;
import cn.edu.xjtu.se.vampire.hibernate.entity.User;
import cn.edu.xjtu.se.vampire.util.Utilities;

public class TestHistoryDao {
	public static void main(String[] args) throws Exception{
//		Connection conn = JDBCUtil.getConnection();
//		
//		assert(conn != null);
//		
//		//Administrator adm = new Administrator();
//		HistoryLine his=new HistoryLine();
//		//OrderLine ol=new OrderLine();
//		//Set<OrderLine> s=new HashSet<OrderLine>();
//		Goods t=new Goods();
//		t.setID(7);
//		his.setUserID(4);
//		his.setGoods(t);
//		his.setBrowseTime(new java.sql.Timestamp(new java.util.Date().getTime()));
//		
//		assert(his.getUserID()==4);
//		assert(his.getBrowseTime()!=null);
//		assert(his.getGoods()!=null);
//		
//		IHistoryDao ihis=new HistoryDaoImpl();
//		
//		boolean res;
//		
//		res=ihis.add(his);
//		assert(res==true);
//		//boolean res;
//		//res = adi.add(adm);
//		//assert(res == true);
//		
//		//adm2 = adi.login("adm", pw);
//		//assert(adm2 != null);
//		//assert(adm2.getGroup().equals(op));
//		//assert(adm2.getName().equals("adm"));
//		//assert(adm2.getPassword().equals(spw));
//		//assert(adm2.getSalt().equals(salt));
//		//assert(adm2.isStatus() == true);
//		
//		his.setUserID(1);
//		his.setID(4);
//		res = ihis.update(his);
//		assert(res == true);
//		
//		Set<HistoryLine> s1 = ihis.select("UserID=4");
//		assert(s1.size() == 0);
//		
//		his.setID(4);
//		res = ihis.delete(his);
//		assert(res == true);
//============================================================================================		
		//Administrator adm = new Administrator();
		History his=new History();
		//OrderLine ol=new OrderLine();
		//Set<OrderLine> s=new HashSet<OrderLine>();
		Goods t=new Goods();
		User user=new User();
		user.setId(5);
		user.setUserName("haha");
		user.setPassword("f5dfc723acc44fe6b9f52da5d6477253");
		user.setSalt(Utilities.generateSalt());
		t.setId(4);
		his.setUser(user);
		his.setGoods(t);
		his.setBrowseTime(new java.sql.Timestamp(new java.util.Date().getTime()));
//		
//		HistoryDAO ihis=new HistoryDAO();
//		
//		boolean res;
//		
//		ihis.save(his);
//=======================================================================================
//		HistoryDAO ihis=new HistoryDAO();
//		History his=new History();
//		his=ihis.findById(1);
//		System.out.println(his.getBrowseTime());
//=============================================================================================
		
		his.setId(1);
		HistoryDAO ihis=new HistoryDAO();
		ihis.delete(his);
//=============================================================================================		
	}

}
