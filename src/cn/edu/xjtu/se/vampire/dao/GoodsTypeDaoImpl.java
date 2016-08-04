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

import cn.edu.xjtu.se.vampire.dao.interfaces.IGoodsTypeDao;
import cn.edu.xjtu.se.vampire.entity.GoodsType;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author totran
 * @version 1.0 Created at 2014年2月26日 下午3:51:19
 * 
 */
public class GoodsTypeDaoImpl implements IGoodsTypeDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#add(cn.edu.xjtu.se.
	 * vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean add(GoodsType t) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into GoodsTypeInfo (GoodsType) values (?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, t.getGoodsType());
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
	 * cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#update(cn.edu.xjtu.
	 * se.vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean update(GoodsType t) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update GoodsTypeInfo set GoodsType=? where ID=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, t.getGoodsType());
			pstm.setInt(2, t.getID());
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
	 * cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#delete(cn.edu.xjtu.
	 * se.vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean delete(GoodsType t) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from GoodsTypeInfo where ID=?";
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
	 * @see
	 * cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#select(java.lang.String
	 * )
	 */
	@Override
	public Set<GoodsType> select(String key) {
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		Set<GoodsType> set = new HashSet<>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from GoodsTypeInfo " + Utilities.generateWhereStatement(key);
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()){
				GoodsType goodsType = new GoodsType();
				goodsType.setID(rs.getInt("ID"));
				goodsType.setGoodsType(rs.getString("GoodsType"));
				goodsType.setParentID(rs.getInt("ParentID"));
				set.add(goodsType);
			}
			return set;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closes(rs, stm, conn);
		}
		return null;
	}

}
