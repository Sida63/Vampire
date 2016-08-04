/**
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

package cn.edu.xjtu.se.vampire.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import com.mysql.jdbc.Statement;

import cn.edu.xjtu.se.vampire.dao.interfaces.IFavorDao;
import cn.edu.xjtu.se.vampire.entity.FavorLine;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author totran
 * @version 1.0 Created at 2014年2月25日 上午10:26:38
 * 
 * @author Aetf
 * @version 1.1 Modified at 2014年2月25日 下午4:10:00
 * 
 */
public class FavorDaoImpl implements IFavorDao {

	private static PreparedStatement pstadd = null;
	private static PreparedStatement pstupdate = null;
	private static PreparedStatement pstdel = null;

	public FavorDaoImpl() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#add(cn.edu.xjtu.se.
	 * vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean add(FavorLine t) {
		boolean done = false;
		Connection conn = null;

		try {
			if (null == pstadd) {
				conn = JDBCUtil.getConnection();
				pstadd = conn.prepareStatement("insert into favorite "
						+ "(UserID, GoodsID) " + "values(?, ?)", Statement.RETURN_GENERATED_KEYS);
			}

			pstadd.setInt(1, t.getUserID());
			pstadd.setInt(2, t.getGoods().getID());

			done = pstadd.executeUpdate() != 0;
			
			if(done) {
				ResultSet rsk = pstadd.getGeneratedKeys();
				if(rsk.next()) {
					t.setID(rsk.getInt(1));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.closes(null, pstadd, conn);
			pstadd = null;
		}

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
	public boolean update(FavorLine t) {
		Connection conn = null;
		boolean done = false;

		try {
			if (null == pstupdate) {
				conn = JDBCUtil.getConnection();
				pstupdate = conn.prepareStatement("update favorite "
						+ "set UserID=?, GoodsID=? " + "where ID=?");
			}

			pstadd.setInt(1, t.getUserID());
			pstadd.setInt(2, t.getGoods().getID());
			pstupdate.setInt(3, t.getID());

			done = pstupdate.executeUpdate() != 0;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.closes(null, pstupdate, conn);
			pstupdate = null;
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
	public boolean delete(FavorLine t) {
		Connection conn = null;
		boolean done = false;

		try {
			if (null == pstdel) {
				conn = JDBCUtil.getConnection();
				pstdel = conn.prepareStatement("delete from favorite "
						+ "where ID=? " + "limit 1");
			}

			pstdel.setInt(1, t.getID());

			done = pstdel.executeUpdate() != 0;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.closes(null, pstdel, conn);
			pstdel = null;
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
	public Set<FavorLine> select(String key) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		HashSet<FavorLine> result = new HashSet<FavorLine>();

		StringBuilder sb = new StringBuilder();
		sb.append("select * from favorite ");
		// append where statement
		sb.append(Utilities.generateWhereStatement(key));

		try {
			conn = JDBCUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());

			rs = pst.executeQuery();

			while (rs.next()) {
				FavorLine fl = new FavorLine();
				fl.setID(rs.getInt("ID"));
				fl.setUserID(rs.getInt("UserID"));

				GoodsDaoImpl gdi = new GoodsDaoImpl();
				fl.setGoods(
						Utilities.first(
								gdi.select("ID="
								+ rs.getInt("GoodsID"))));

				result.add(fl);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.closes(rs, pst, conn);
		}

		return result;
	}

}
