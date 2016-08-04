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
 * Created at 2014年3月3日 上午11:25:14
 */
public class TestNightmare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Admin adm = new Admin();
		adm.setAdminGroup(Utilities.first(new AdminGroupInfoDAO().findByAdminGroup("SM")));
		adm.setAdminName("adnightmare");
		adm.setSalt("aaa");
		adm.setPassword("bb");
		adm.setStatus(true);
		
		new AdminDAO().save(adm);
		
		adm.setAdminName("adm22222");
		for(Admin admm : new AdminDAO().findAll()) {
			System.out.println("thread main: " + admm.getAdminName());
		}
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(Admin adm : new AdminDAO().findAll()) {
					System.out.println("thread new: " + adm.getAdminName());
				}
			}
		});
		thread.start();
	}

}
