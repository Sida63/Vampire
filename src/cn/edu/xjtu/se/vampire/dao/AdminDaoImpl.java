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

import java.util.HashSet;
import java.util.Set;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.edu.xjtu.se.vampire.dao.interfaces.IAdminDao;
import cn.edu.xjtu.se.vampire.entity.Administrator;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.OnePair;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author totran
 * @version 1.0 Created at 2014年2月25日 上午10:25:02
 * 
 * @author Aetf
 * @version 1.1 Modified at 2014年2月25日 下午2:12:00
 * 
 */
public class AdminDaoImpl implements IAdminDao {

	private static PreparedStatement pstadd = null;
	private static PreparedStatement pstupdate = null;
	private static PreparedStatement pstdel = null;

	public AdminDaoImpl() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#add(cn.edu.xjtu.se.
	 * vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean add(Administrator t) {
		Connection conn = null;
		boolean done = false;

		try {
			if (null == pstadd) {
				conn = JDBCUtil.getConnection();
				pstadd = conn.prepareStatement("insert into admin "
						+ "(AdminName, Password, Salt, AdminGroup, Status) "
						+ "values(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			}

			pstadd.setString(1, t.getName());
			pstadd.setString(2, t.getPassword());
			pstadd.setString(3, t.getSalt());
			pstadd.setInt(4, t.getGroup().getID());
			pstadd.setBoolean(5, t.isStatus());

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
	public boolean update(Administrator t) {
		Connection conn = null;
		boolean done = false;

		try {
			if (null == pstupdate) {
				conn = JDBCUtil.getConnection();
				pstupdate = conn
						.prepareStatement("update admin "
								+ "set AdminName=?, Password=?, Salt=?, AdminGroup=?, Status=? "
								+ "where ID=?");
			}

			pstupdate.setString(1, t.getName());
			pstupdate.setString(2, t.getPassword());
			pstupdate.setString(3, t.getSalt());
			pstupdate.setInt(4, t.getGroup().getID());
			pstupdate.setBoolean(5, t.isStatus());
			pstupdate.setInt(6, t.getID());

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
	public boolean delete(Administrator t) {
		Connection conn = null;
		boolean done = false;

		try {
			if (null == pstdel) {
				conn = JDBCUtil.getConnection();
				pstdel = conn.prepareStatement("delete from admin "
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
	public Set<Administrator> select(String key) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		HashSet<Administrator> result = new HashSet<Administrator>();

		StringBuilder sb = new StringBuilder();
		sb.append("select * from admin ");
		// append where statement
		sb.append(Utilities.generateWhereStatement(key));
		
		try {
			conn = JDBCUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Administrator adm = new Administrator();
				adm.setID(rs.getInt("ID"));
				adm.setName(rs.getString("AdminName"));
				adm.setPassword(rs.getString("Password"));
				adm.setSalt(rs.getString("Salt"));
				adm.setStatus(rs.getBoolean("Status"));
				adm.setGroup(OnePair.Retrive("AdminGroupInfo", rs.getInt("AdminGroup")));
				
				result.add(adm);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.closes(rs, pst, conn);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xjtu.se.vampire.dao.interfaces.IAdminDao#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Administrator login(String name, String password) {
		Administrator a = Utilities.first(
						select("AdminName=" + name));
		
		if(!a.getPassword().equals(
				Utilities.generateSecPass(password, a.getSalt()))) {
			a = null;
		}
		
		return a;
	}

}
