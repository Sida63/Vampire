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
package cn.edu.xjtu.se.vampire.test;

import java.sql.Connection;
import java.util.Set;

import cn.edu.xjtu.se.vampire.dao.DeliveryDaoImpl;
import cn.edu.xjtu.se.vampire.dao.interfaces.IDeliveryDao;
import cn.edu.xjtu.se.vampire.entity.DeliveryInfo;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.OnePair;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author Aetf
 * Created at 2014年2月26日 下午2:04:39
 */
public class TestDeliveryDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Connection conn = JDBCUtil.getConnection();
		
		assert(conn != null);
		
		DeliveryInfo dly = new DeliveryInfo();
		assert(dly != null);
		OnePair op = OnePair.Retrive("AreaInfo", 1);
		assert(op != null);
		
		dly.setID(123);
		dly.setUser(1);
		dly.setReceiver("abcreceiver测试好的");
		dly.setAreacodeareainfo(op);
		dly.setDetailaddr("detail地址地址");
		dly.setTel("11233342");
		
		assert(dly.getID() == 123);
		assert(dly.getUser() == 1);
		assert(dly.getReceiver().equals("abcreceiver测试好的"));
		assert(dly.getAreacodeareainfo().equals(op));
		assert(dly.getDetailaddr().equals("detail地址地址"));
		assert(dly.getTel().equals("11233342"));
		
		IDeliveryDao idd = new DeliveryDaoImpl();
		DeliveryInfo dly2 = null, dly3 = null;
		boolean res;
		res = idd.add(dly);
		assert(res == true);
		
		Set<DeliveryInfo> s = idd.select("Tel=adm");
		assert(s.size() == 0);
		s = idd.select("ID="+dly.getID());
		assert(s.size() == 1);
		dly2 = Utilities.first(s);
		assert(dly2 != null);
		assert(dly.equals(dly2));
		
		dly2.setReceiver("adm2");
		res = idd.update(dly2);
		assert(res == true);
		
		s = idd.select("ID="+dly.getID());
		assert(s.size() == 1);
		dly3 = Utilities.first(s);
		assert(dly3 != null);
		assert(dly3.equals(dly3));
		
		res = idd.delete(dly3);
		assert(res == true);
		
		s = idd.select("ID="+dly3.getID());
		assert(s.size() == 0);
	}

}
