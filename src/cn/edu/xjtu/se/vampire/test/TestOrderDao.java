package cn.edu.xjtu.se.vampire.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.edu.xjtu.se.vampire.hibernate.dao.GoodsDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.OrderStatusInfoDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.OrdersDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.UserDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.Goods;
import cn.edu.xjtu.se.vampire.hibernate.entity.OrderDetail;
import cn.edu.xjtu.se.vampire.hibernate.entity.OrderStatusInfo;
import cn.edu.xjtu.se.vampire.hibernate.entity.Orders;
import cn.edu.xjtu.se.vampire.hibernate.entity.User;
import cn.edu.xjtu.se.vampire.util.Utilities;
//import cn.edu.xjtu.se.vampire.entity.Goods;
//import cn.edu.xjtu.se.vampire.entity.User;

public class TestOrderDao {
    
	public static void main(String[] args) throws Exception{
//		Connection conn = JDBCUtil.getConnection();
//		
//		assert(conn != null);
//		
//		//Administrator adm = new Administrator();
//		Order or=new Order();
//		OrderLine ol=new OrderLine();
//		Set<OrderLine> s=new HashSet<OrderLine>();
//		Goods t=new Goods();
//		t.setID(7);
//		User user=new User();
//		user.setID(2);
//		user.setName("zhangte");
//		user.setPassword("123456789");
//		user.setSalt(Utilities.generateSalt());
//		ol.setAmount(121);
//		ol.setID(1);
//		ol.setPrice(12);
//		ol.setGoods(t);
//		//OnePair op = OnePair.Retrive("AdminGroupInfo", 1);
//		//assert(op != null);
//		
//		//String pw = "11111";
//		//String salt = Utilities.generateSalt();
//		//String spw = Utilities.generateSecPass(pw, salt);		
//		
//		or.setDiscountAmount(0.3);
//		or.setOrderNumber("1212");
//		or.setPayStatus(true);
//		or.setPayWay(true);
//		or.setRemark("在嘎个");
//		or.setStatus(1);
//		or.setTime(new java.sql.Timestamp(new java.util.Date().getTime()));
//		or.setTotalAmount(123.42);
//		or.setUser(user);
//		s.add(ol);
//		or.setChoosen(s);
//		
//		assert(or.getChoosen()!=null);
//		assert(or.getDiscountAmount()==0.3);
//		assert(or.getID()==123);
//		assert(or.getOrderNumber().equals("1212"));
//		assert(or.getPayStatus()==true);
//		assert(or.getPayWay()==true);
//		assert(or.getRemark().equals("在嘎个"));
//		assert(or.getStatus()==1);
//		assert(or.getTime()!=null);
//		assert(or.getTotalAmount()==123.43);
//		assert(or.getUser().getID()!=0);
//		
//		//assert(adm.getID() == 123);
//		//assert(adm.getGroup().equals(op));
//		//assert(adm.getName().equals("adm"));
//		//assert(adm.getPassword().equals(spw));
//		//assert(adm.getSalt().equals(salt));
//		//assert(adm.isStatus() == true);
//		
//		//IAdminDao adi = new AdminDaoImpl();
//		//Administrator adm2 = null;
//		//Administrator adm3 = null;
//		IOrderDao od=new OrderDaoImpl();
//		Order or1=null;
//		
//		boolean res;
//		res=od.add(or);
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
//		or.setTotalAmount(1232.23);
//		res = od.update(or);
//		//adm2.setName("adm2");
//		//res = adi.update(adm2);
//		
//		assert(res == true);
//		
//		Set<Order> s1 = od.select("OrderNumber=1212");
//		assert(s1.size() != 0);
//		
//		or1 = Utilities.first(s1);
//
//		assert(or1 != null);
//		
//		
//		res = od.delete(or);
//		assert(res == true);
//		
//		s1 = od.select("OrderNumber=1212");
//		assert(s.size() == 0);
		
//================================================================================
		
		Orders or=new Orders();
		OrderDetail ol=new OrderDetail();
		OrderStatusInfo sta= new OrderStatusInfoDAO().findById(3);
		Goods t= new GoodsDAO().findById(4);
		User user=new UserDAO().findById(22);
		
		ol.setAmount(121);
		ol.setPrice(12);
		ol.setGoods(t);
			
		or.setDiscountAmount(0.3);
		or.setOrderNumber("1233");
		or.setPayStatus(true);
		or.setPayWay(true);
		or.setRemark("在嘎个");
		or.setStatus(sta);
		or.setTime(new Date());
		or.setTotalAmount(123.42);
		or.setUser(user);
		ol.setOrders(or);
		or.getOrderDetails().add(ol);
		
		OrdersDAO dao = new OrdersDAO();
		dao.save(or);

//=================================================================
//		OrdersDAO od=new OrdersDAO();
//		
//		List<?> list = od.findByOrderNumber("1212");
//		
//		System.out.println(list.size());
//		assert(s1.size() != 0);
		
//==================================================================
//		boolean res;
//		OrdersDAO od=new OrdersDAO();
//		or.setId(4);
//		od.delete(or);
		
//==================================================================
		
   
	}
}

