package cn.edu.xjtu.se.vampire.test;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import cn.edu.xjtu.se.vampire.dao.UserDaoImpl;
import cn.edu.xjtu.se.vampire.entity.User;
import cn.edu.xjtu.se.vampire.entity.UserExtendInfo;

public class TestBelongTe {

	public static void main(String[] args) {
		
		
		testLogin();


	}

	public static void testAdd(){
		User user1 =new User();
	
		user1.setName("zhangte");
		user1.setPassword("123456789");
		user1.setMailBox("34343434@qq.com");
		user1.setSalt("232323");
		UserExtendInfo userex = new UserExtendInfo();
		
		userex.setPhone("1384535342");
		
		userex.setScore(100);
		userex.setStatus(2);
		userex.setReputation(60);
		userex.setRegistTime(new Date());
		user1.setExtendInfo(userex);
		
		UserDaoImpl udi = new UserDaoImpl();
		udi.add(user1);
	} 
	public  static void testUpdate(){
		User user1 =new User();
		user1.setID(2);
		user1.setName("albert");
		user1.setPassword("123456789");
		user1.setMailBox("34343434@qq.com");
		user1.setSalt("232323");
		UserExtendInfo userex = new UserExtendInfo();
		userex.setID(3);
		userex.setPhone("1384535342");
		
		userex.setScore(100);
		userex.setStatus(2);
		userex.setReputation(60);
		userex.setRegistTime(new Date());
		user1.setExtendInfo(userex);
		
		UserDaoImpl udi = new UserDaoImpl();
		udi.update(user1);
	} 
	
	public static void testDelete(){
		User user1 =new User();
		user1.setID(2);
		user1.setName("zhangte");
		user1.setPassword("123456789");
		user1.setMailBox("34343434@qq.com");
		user1.setSalt("232323");
		UserExtendInfo userex = new UserExtendInfo();
		userex.setID(3);
		userex.setPhone("1384535342");
		
		userex.setScore(100);
		userex.setStatus(2);
		userex.setReputation(60);
		userex.setRegistTime(new Date());
		user1.setExtendInfo(userex);
		
		UserDaoImpl udi = new UserDaoImpl();
		udi.delete(user1);
	} 
	
	
	public static void testSelect(){
		UserDaoImpl udi = new UserDaoImpl();
		Set<User> set=udi.select("UserName=zhangte");
		Iterator<User> it=set.iterator();
		while(it.hasNext()){
			User user1=it.next();
			System.out.println(user1.getID());
			System.out.println(user1.getName());
			System.out.println(user1.getMailBox());
			System.out.println(user1.getSalt());
			
			
		}
		
		
	} 
	
	public static void testLogin(){
		
		UserDaoImpl udi1 = new UserDaoImpl();
		User user2=udi1.login("zhangte","123456789");
		
		System.out.println(user2.getID());
		System.out.println(user2.getPassword());
			
		}
	
	
public static void testPopulateExtendInfo(){
		
		User user1 =new User();
	
		user1.setName("zhangte");
		user1.setPassword("123456789");
		user1.setMailBox("34343434@qq.com");
		user1.setSalt("232323");
		UserDaoImpl udi1 = new UserDaoImpl();
		udi1.populateExtendInfo(user1,2);
		
		System.out.println(user1.getID());
		System.out.println(user1.getPassword());
			
		}
			
	
}
