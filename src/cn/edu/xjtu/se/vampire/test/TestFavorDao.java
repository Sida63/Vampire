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

import cn.edu.xjtu.se.vampire.dao.FavorDaoImpl;
import cn.edu.xjtu.se.vampire.dao.GoodsDaoImpl;
import cn.edu.xjtu.se.vampire.dao.interfaces.IFavorDao;
import cn.edu.xjtu.se.vampire.entity.FavorLine;
import cn.edu.xjtu.se.vampire.entity.Goods;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author Aetf
 * Created at 2014年2月26日 下午2:47:20
 */
public class TestFavorDao {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Connection conn = JDBCUtil.getConnection();		
		assert(conn != null);
		
		FavorLine fl = new FavorLine();
		assert(fl != null);
		Goods goods = Utilities.first(new GoodsDaoImpl().select(""));
		assert(goods != null);
		
		fl.setID(123);
		fl.setGoods(goods);
		fl.setUserID(1);
		
		assert(fl.getID() == 123);
		assert(fl.getUserID() == 1);
		assert(fl.getGoods().equals(goods));
		
		IFavorDao ifd = new FavorDaoImpl();
		FavorLine fl2 = null, fl3 = null;
		boolean res;
		res = ifd.add(fl);
		assert(res == true);
		
		Set<FavorLine> s = ifd.select("UserID="+222);
		assert(s.size() == 0);
		s = ifd.select("ID="+fl.getID());
		assert(s.size() == 1);
		fl2 = Utilities.first(s);
		assert(fl2 != null);
		assert(fl.equals(fl2));
		
		res = ifd.update(fl2);
		assert(res == false);
		
		s = ifd.select("ID="+fl.getID());
		assert(s.size() == 1);
		fl3 = Utilities.first(s);
		assert(fl3 != null);
		assert(fl3.equals(fl3));
		
		res = ifd.delete(fl3);
		assert(res == true);
		
		s = ifd.select("ID="+fl3.getID());
		assert(s.size() == 0);
	}

}
