/*
 * Copyright (c) 2014, Aetf <7437103@gmail.com>
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

import cn.edu.xjtu.se.vampire.hibernate.dao.AdminDAO;
import cn.edu.xjtu.se.vampire.hibernate.dao.AdminGroupInfoDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.Admin;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author Aetf
 * Created at 2014年3月3日 上午9:15:51
 */
public class TestAdmin {
	
	static String pw;
	static String salt;
	static String spw;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pw = "11111";
		salt = Utilities.generateSalt();
		spw = Utilities.generateSecPass(pw, salt);
		
		saveTest();
		selectTest();
		findTest();
		deleteTest();
	}
	
	public static boolean saveTest() {
		Admin adm = new Admin();
				
		
		adm.setId(123);
		adm.setAdminGroup(Utilities.first(new AdminGroupInfoDAO().findByAdminGroup("SM")));
		adm.setAdminName("adm");
		adm.setSalt(salt);
		adm.setPassword(spw);
		adm.setStatus(true);
		
		new AdminDAO().save(adm);
		
		return true;
	}
	
	public static boolean selectTest() {
		Admin adm = Utilities.first(new AdminDAO().select("status=1;adminName=adm"));
		
		assert(adm != null);
		assert(adm.getAdminGroup().getAdminGroup().equals("SM"));
		assert(adm.getAdminName().equals("adm"));
		assert(adm.getPassword().equals(spw));
		assert(adm.getSalt().equals(salt));
		assert(adm.getStatus() == true);
		
		return true;
	}
	
	public static boolean findTest() {
		Admin adm = Utilities.first(new AdminDAO().findByAdminName("adm"));
		
		assert(adm != null);
		assert(adm.getAdminGroup().getAdminGroup().equals("SM"));
		assert(adm.getAdminName().equals("adm"));
		assert(adm.getPassword().equals(spw));
		assert(adm.getSalt().equals(salt));
		assert(adm.getStatus() == true);
		return true;
	}
	
	public static boolean deleteTest() {
		AdminDAO ada = new AdminDAO();
		Admin adm = Utilities.first(ada.select("status=true;adminName=adm"));
		ada.delete(adm);
		
		return true;
	}
	
}
