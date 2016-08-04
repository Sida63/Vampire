package cn.edu.xjtu.se.vampire.test.hibernate;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import cn.edu.xjtu.se.vampire.hibernate.dao.UserDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.User;
import cn.edu.xjtu.se.vampire.hibernate.entity.UserDetail;
import cn.edu.xjtu.se.vampire.hibernate.entity.UserStatusInfo;
import cn.edu.xjtu.se.vampire.util.Utilities;

public class TestUserDao {

	public static void main(String[] args) {
		testFindByExample();
		
		
	}
	
	
	public static void testSave(){
		User user = new User();
		user.setMailBox("1jh2223@16qcom");
		String salt = Utilities.generateSalt();
		user.setPassword(Utilities.generateSecPass("ha2haqw", salt));
		user.setSalt(salt);
		user.setUserName("ha2jqjhha");
		UserDetail ud = new UserDetail();
		ud.setPhone("1123890");
		ud.setRegisteTime(new Date());
		ud.setReputation(0);
		ud.setScore(0);
		ud.setUser(user);
		UserStatusInfo usi = new UserStatusInfo();
		usi.setId(2);
		usi.setUserStatus("∆Ù”√");
		ud.setStatus(usi);
		user.setUserDetail(ud);
		new UserDAO().save(user);
	}
	
	public static void testDelete(){
	
		User user = new UserDAO().findById(120);
		new UserDAO().delete(user);
	}
	
	public static void testFindById(){
		
		User user = new UserDAO().findById(115);
		System.out.println(user.getMailBox());
		
	}
	public static void testFindByExample(){
		
		User user = new User();
		user.setMailBox("csm3iVYV@163.com");
		
		List<User> list = (List<User>) new UserDAO().findByExample(user);
		Iterator<User> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getMailBox());
		}
		
		
	}
	
	
	
}
