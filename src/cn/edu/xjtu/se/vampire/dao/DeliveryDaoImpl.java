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
package cn.edu.xjtu.se.vampire.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import com.mysql.jdbc.Statement;

import cn.edu.xjtu.se.vampire.dao.interfaces.IDeliveryDao;
import cn.edu.xjtu.se.vampire.entity.DeliveryInfo;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.OnePair;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author Aetf
 * @version 1.0
 * Created at 2014年2月26日 下午1:44:18
 */
public class DeliveryDaoImpl implements IDeliveryDao {
	
	private static PreparedStatement pstadd = null;
	private static PreparedStatement pstupdate = null;
	private static PreparedStatement pstdel = null;
	
	public DeliveryDaoImpl() {
		
	}

	/* (non-Javadoc)
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#add(cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean add(DeliveryInfo t) {
		Connection conn = null;
		boolean done = false;

		try {
			if (null == pstadd) {
				conn = JDBCUtil.getConnection();
				pstadd = conn.prepareStatement("insert into DeliveryInfo "
						+ "(UserID, Receiver, AreaCode, DetailAddr, Tel) "
						+ "values(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			}

			pstadd.setInt(1, t.getUser());
			pstadd.setString(2, t.getReceiver());
			pstadd.setInt(3, t.getAreacodeareainfo().getID());
			pstadd.setString(4, t.getDetailaddr());
			pstadd.setString(5, t.getTel());

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

	/* (non-Javadoc)
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#update(cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean update(DeliveryInfo t) {
		Connection conn = null;
		boolean done = false;

		try {
			if (null == pstupdate) {
				conn = JDBCUtil.getConnection();
				pstupdate = conn
						.prepareStatement("update DeliveryInfo "
								+ "set UserID=?, Receiver=?, AreaCode=?, DetailAddr=?, Tel=? "
								+ "where ID=?");
			}

			pstupdate.setInt(1, t.getUser());
			pstupdate.setString(2, t.getReceiver());
			pstupdate.setInt(3, t.getAreacodeareainfo().getID());
			pstupdate.setString(4, t.getDetailaddr());
			pstupdate.setString(5, t.getTel());
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

	/* (non-Javadoc)
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#delete(cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean delete(DeliveryInfo t) {
		Connection conn = null;
		boolean done = false;

		try {
			if (null == pstdel) {
				conn = JDBCUtil.getConnection();
				pstdel = conn.prepareStatement("delete from DeliveryInfo "
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

	/* (non-Javadoc)
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#select(java.lang.String)
	 */
	@Override
	public Set<DeliveryInfo> select(String key) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		HashSet<DeliveryInfo> result = new HashSet<DeliveryInfo>();

		StringBuilder sb = new StringBuilder();
		sb.append("select * from DeliveryInfo ");
		// append where statement
		sb.append(Utilities.generateWhereStatement(key));
		
		try {
			conn = JDBCUtil.getConnection();
			pst = conn.prepareStatement(sb.toString());
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				DeliveryInfo adm = new DeliveryInfo();
				adm.setID(rs.getInt("ID"));
				adm.setUser(rs.getInt("UserID"));
				adm.setReceiver(rs.getString("Receiver"));
				adm.setAreacodeareainfo(OnePair.Retrive("AreaInfo", rs.getInt("AreaCode")));
				adm.setDetailaddr(rs.getString("DetailAddr"));
				adm.setTel(rs.getString("Tel"));
				
				result.add(adm);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.closes(rs, pst, conn);
		}

		return result;
	}

}
