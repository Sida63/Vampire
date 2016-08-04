package cn.edu.xjtu.se.vampire.test;

import java.sql.Connection;
import java.util.Set;

import cn.edu.xjtu.se.vampire.dao.AdminDaoImpl;
import cn.edu.xjtu.se.vampire.dao.interfaces.IAdminDao;
import cn.edu.xjtu.se.vampire.entity.Administrator;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.OnePair;
import cn.edu.xjtu.se.vampire.util.Utilities;

public class TestAdminDao {

	public static void main(String[] args) throws Exception{
		Connection conn = JDBCUtil.getConnection();
		
		assert(conn != null);
		
		Administrator adm = new Administrator();
		OnePair op = OnePair.Retrive("AdminGroupInfo", 1);
		assert(op != null);
		
		String pw = "11111";
		String salt = Utilities.generateSalt();
		String spw = Utilities.generateSecPass(pw, salt);		
		
		adm.setID(123);
		adm.setGroup(op);
		adm.setName("adm");
		adm.setSalt(salt);
		adm.setPassword(spw);
		adm.setStatus(true);
		
		assert(adm.getID() == 123);
		assert(adm.getGroup().equals(op));
		assert(adm.getName().equals("adm"));
		assert(adm.getPassword().equals(spw));
		assert(adm.getSalt().equals(salt));
		assert(adm.isStatus() == true);
		
		IAdminDao adi = new AdminDaoImpl();
		Administrator adm2 = null;
		Administrator adm3 = null;
		boolean res;
		res = adi.add(adm);
		assert(res == true);
		
		adm2 = adi.login("adm", pw);
		assert(adm2 != null);
		assert(adm2.getID() == adm.getID()); // adi.add方法能够修改传入参数的ID
		assert(adm2.getGroup().equals(op));
		assert(adm2.getName().equals("adm"));
		assert(adm2.getPassword().equals(spw));
		assert(adm2.getSalt().equals(salt));
		assert(adm2.isStatus() == true);
		
		adm2.setName("adm2");
		res = adi.update(adm2);
		assert(res == true);
		
		Set<Administrator> s = adi.select("AdminName=adm");
		assert(s.size() == 0);
		s = adi.select("ID="+adm2.getID());
		assert(s.size() == 1);
		adm3 = Utilities.first(s);
		assert(adm3 != null);
		assert(adm3.equals(adm2));
		
		res = adi.delete(adm3);
		assert(res == true);
		
		s = adi.select("ID="+adm3.getID());
		assert(s.size() == 0);
	}

}
