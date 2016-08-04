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

import cn.edu.xjtu.se.vampire.dao.interfaces.ICouponDao;
import cn.edu.xjtu.se.vampire.entity.Coupon;
import cn.edu.xjtu.se.vampire.entity.CouponProp;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author totran
 * @version 1.0 Created at 2014年2月25日 上午10:12:47
 * 
 */
public class CouponDaoImpl implements ICouponDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xjtu.se.vampire.dao.IDBAccessor#add(cn.edu.xjtu.se.vampire.dao
	 * .Identifiable)
	 */
	@Override
	public boolean add(Coupon t) {
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into Coupon (UserID,Property,CouponNumber,IssuedTime) values (?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, t.getUserID());
			pstm.setInt(2, t.getProperty().getID());
			pstm.setString(3, t.getCouponNum());
			pstm.setTimestamp(4, new java.sql.Timestamp(t.getIssueTime().getTime()));
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closes(null, pstm, conn);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xjtu.se.vampire.dao.IDBAccessor#update(cn.edu.xjtu.se.vampire.
	 * dao.Identifiable)
	 */
	@Override
	public boolean update(Coupon t) {
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = JDBCUtil.getConnection();
			String sql = "update Coupon set UserID=?,Property=?,CouponNumber=?,IssuedTime=? where ID=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, t.getUserID());
			pstm.setInt(2, t.getProperty().getID());
			pstm.setString(3, t.getCouponNum());
			pstm.setTimestamp(4, new java.sql.Timestamp(t.getIssueTime().getTime()));
			pstm.setInt(5, t.getID());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closes(null, pstm, conn);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xjtu.se.vampire.dao.IDBAccessor#delete(cn.edu.xjtu.se.vampire.
	 * dao.Identifiable)
	 */
	@Override
	public boolean delete(Coupon t) {
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from Coupon where ID=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, t.getID());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closes(null, pstm, conn);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.edu.xjtu.se.vampire.dao.IDBAccessor#select(java.lang.String)
	 */
	@Override
	public Set<Coupon> select(String key) {
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		HashSet<Coupon> coupons = new HashSet<>();

		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from Coupon "
					+ Utilities.generateWhereStatement(key);
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Coupon coupon = new Coupon();
				CouponProp couponProp = Utilities.first(new CouponPropDaoImpl()
						.select("ID=" + rs.getInt("Property")));
				coupon.setID(rs.getInt("ID"));
				coupon.setUserID(rs.getInt("UserID"));
				coupon.setProperty(couponProp);
				coupon.setCouponNum(rs.getString("CouponNumber"));
				coupon.setIssueTime(rs.getDate("IssuedTime"));
				coupons.add(coupon);
			}
			return coupons;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closes(rs, stm, conn);
		}
		return null;
	}
}
