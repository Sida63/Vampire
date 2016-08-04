/**
 * Copyright (c) 2014, totran <392165719@qq.com>
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

package cn.edu.xjtu.se.vampire.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import cn.edu.xjtu.se.vampire.dao.interfaces.IHistoryDao;
import cn.edu.xjtu.se.vampire.entity.HistoryLine;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author totran
 * @version 1.0 Created at 2014年2月25日 上午10:28:55
 * 
 */
public class HistoryDaoImpl implements IHistoryDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#add(cn.edu.xjtu.se.
	 * vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean add(HistoryLine t) {
		Connection conn = null;
		PreparedStatement pst1 = null;
		boolean done = false;
		ResultSet rs=null;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql1 = "insert into History(UserID,GoodsID,BrowseTime) values(?,?,?)";
			pst1 = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			pst1.setInt(1, t.getUserID());
			pst1.setInt(2, t.getGoods().getID());
			pst1.setTimestamp(3,new java.sql.Timestamp(new java.util.Date().getTime()));
			
			done = pst1.executeUpdate() != 0;
			 rs=pst1.getGeneratedKeys();
				rs.next();
				t.setID(rs.getInt(1));
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 6：关闭资源 先开后关
			JDBCUtil.closes(null, pst1, conn);

		}
		// TODO Auto-generated method stub
		return done;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#update(cn.edu.xjtu.
	 * se.vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean update(HistoryLine t) {
		Connection conn = null;
		PreparedStatement pst1 = null;
		boolean done = false;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql1 = "update History set UserID=?,GoodsID=?,BrowseTime=?"
					+ " where ID=?";
			pst1 = conn.prepareStatement(sql1);
			pst1.setInt(1, t.getUserID());
			pst1.setInt(2, t.getGoods().getID());
			pst1.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
			pst1.setInt(4, t.getID());
			
			done = pst1.executeUpdate() != 0;
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 6：关闭资源 先开后关
			JDBCUtil.closes(null, pst1, conn);

		}
		return done;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#delete(cn.edu.xjtu.
	 * se.vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean delete(HistoryLine t) {
		Connection conn = null;
		PreparedStatement pst1 = null;
		boolean done = false;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql1 = "delete from History where ID=?";
			pst1 = conn.prepareStatement(sql1);
			pst1.setInt(1, t.getID());
			done = pst1.executeUpdate() != 0;
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 6：关闭资源 先开后关
			JDBCUtil.closes(null, pst1, conn);

		}
		return done;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#select(java.lang.String
	 * )
	 */
	@Override
	public Set<HistoryLine> select(String key) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		Set<HistoryLine> result = new HashSet<HistoryLine>();

		try {
			conn = JDBCUtil.getConnection();
			st = conn.createStatement();
			String sql1 = "select * from History "
					+ Utilities.generateWhereStatement(key);
			rs = st.executeQuery(sql1);

			while (rs.next()) {
				HistoryLine hl = new HistoryLine();
				hl.setID(rs.getInt("ID"));
				hl.setUserID(rs.getInt("UserID"));
				hl.setGoods(Utilities.first(new GoodsDaoImpl().select("ID="
						+ rs.getInt("GoodsID"))));
				hl.setBrowseTime(new java.sql.Timestamp(new java.util.Date().getTime()));

				result.add(hl);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 6：关闭资源 先开后关
			JDBCUtil.closes(rs, st, conn);

		}
		return result;
	}

}
