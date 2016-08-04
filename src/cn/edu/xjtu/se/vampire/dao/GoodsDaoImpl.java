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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.sql.PreparedStatement;

import cn.edu.xjtu.se.vampire.dao.interfaces.IGoodsDao;
import cn.edu.xjtu.se.vampire.entity.Goods;
import cn.edu.xjtu.se.vampire.entity.GoodsDetail;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.OnePair;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author totran
 * @version 1.0
 * Created at 2014年2月25日 上午10:28:35
 * 
 */
public class GoodsDaoImpl implements IGoodsDao {

	/* (non-Javadoc)
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#add(cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean add(Goods t) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		boolean isOK=false;
		
		try {
			conn = JDBCUtil.getConnection();
			/**
			 * insert the detailInfo of goods into table
			 */
			String sql = "insert into GoodsDetail(GoodsDesc,Provider,Storage,Price,Sales,ImgPath) values(?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//pst.setInt(1, t.getDetail().getID());
			pst.setString(1, t.getDetail().getDescription());
			pst.setString(2, t.getDetail().getProvider());
			pst.setInt(3,t.getDetail().getStorage());
			pst.setDouble(4, t.getDetail().getPrice());
			pst.setInt(5, t.getDetail().getSales());
			pst.setString(6, t.getDetail().getImagePath());
			pst.executeUpdate();
			
			/**
			 * get detail id of the goods
			 */
			rs=pst.getGeneratedKeys();
			rs.next();
			int detailID=rs.getInt(1);
			
			pst.close();
			
			
			String sql1 ="insert into Goods(GoodsName,GoodsNumber,Tags,Type,DetailInfo) values(?,?,?,?,?)";
			pst = conn.prepareStatement(sql1);
			pst.setString(1, t.getName());
			pst.setString(2,t.getGoodNumber());
			pst.setString(3,t.getTags());
			pst.setInt(4,t.getType().getID());
			pst.setInt(5, detailID);
			pst.executeUpdate();
			
			isOK=pst.executeUpdate()!=0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//close the JDBC
			JDBCUtil.closes(null, pst, conn);
		}
		
		return isOK;
	}

	/* (non-Javadoc)
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#update(cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean update(Goods t) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		boolean isOK=false;
	
		try {
			conn = JDBCUtil.getConnection();
			/**
			 * update goods info
			 */
			String sql1 ="update Goods set GoodsName=?,"
					+ "GoodsNumber=?,Tags=?,Type=? "
					+ "where ID=?";
			pst = conn.prepareStatement(sql1);
			pst.setString(1, t.getName());
			pst.setString(2,t.getGoodNumber());
			pst.setString(3,t.getTags());
			pst.setInt(4,t.getType().getID());
			pst.setInt(5, t.getID());
			pst.executeUpdate();
			
			pst.close();
			
			String sql = "update GoodsDetail "
					+ "set GoodsDesc=?,Provider=?,Storage=?,Price=?"
					+ ",Sales=?,ImgPath=? "
					+ "where ID=?";
			pst = conn.prepareStatement(sql);
			//pst.setInt(1, t.getDetail().getID());
			pst.setString(1, t.getDetail().getDescription());
			pst.setString(2, t.getDetail().getProvider());
			pst.setInt(3,t.getDetail().getStorage());
			pst.setDouble(4, t.getDetail().getPrice());
			pst.setInt(5, t.getDetail().getSales());
			pst.setString(6, t.getDetail().getImagePath());
			pst.setInt(7, t.getDetail().getID());
			pst.executeUpdate();
			
			isOK=pst.executeUpdate()!=0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//close the JDBC
			JDBCUtil.closes(null, pst, conn);
		}
		
		return isOK;
	}

	/* (non-Javadoc)
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#delete(cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean delete(Goods t) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pst = null;
		boolean isOK=false;
		try {
			conn = JDBCUtil.getConnection();
			String sql="delete from GoodsDetail where ID=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,t.getDetail().getID());
			pst.close();
			
			String sql1="delete from Goods  where ID= ?";
			pst=conn.prepareStatement(sql1);
			pst.setInt(1, t.getID());
			
			isOK=pst.executeUpdate()!=0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closes(null, pst, conn);
		}
		
		return isOK;
	}

	/* (non-Javadoc)
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#select(java.lang.String)
	 */
	@Override
	public Set<Goods> select(String key) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		Goods goods=new Goods();
		HashSet<Goods> selectGoods=new HashSet<Goods>();
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("select Goods.*,GoodsDetail.Price,GoodsDetail.GoodsDesc,"
					+ "GoodsDetail.Provider,GoodsDetail.Storage,Sales,"
					+ "GoodsDetail.ImgPath from Goods,GoodsDetail ");
			// append where statement
			sb.append(Utilities.generateWhereStatement(key, "Goods"));
			sb.append("and Goods.DetailInfo=GoodsDetail.ID");
			conn = JDBCUtil.getConnection();
			pst=conn.prepareStatement(sb.toString());
			rs=pst.executeQuery();
			
			while(rs.next()){
				GoodsDetail detail=new GoodsDetail();
				goods.setID(rs.getInt("ID"));
				goods.setName(rs.getString("GoodsName"));
				goods.setGoodNumber(rs.getString("GoodsNumber"));
				goods.setTags(rs.getString("Tags"));
				goods.setType(OnePair.Retrive("Type", rs.getInt("Type")));
				int detailID=rs.getInt("DetailInfo");
				detail.setID(detailID);
				/*
				 * get the detailInfo of the goods by detailID
				 */
				detail.setPrice(rs.getDouble("Price"));
				detail.setDescription(rs.getString("GoodsDesc"));
				detail.setProvider(rs.getString("Provider"));
				detail.setSales(rs.getInt("Sales"));
				detail.setStorage(rs.getInt("Storage"));
				detail.setImagePath(rs.getString("ImgPath"));
				goods.setDetail(detail);
				selectGoods.add(goods);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			JDBCUtil.closes(rs, pst, conn);
			
		}
		
		return selectGoods;
	}

	/* (non-Javadoc)
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.IGoodsDao#populateComments(cn.edu.xjtu.se.vampire.entity.Goods)
	 */
	@Override
	public void populateComments(Goods goods) {
		// TODO Auto-generated method stub
		// 使用CommentDaoImpl的相关方法实现
		CommentDaoImpl comment=new CommentDaoImpl();
		GoodsDetail detail=new GoodsDetail();
		detail=goods.getDetail();
		detail.setComments(comment.select("GoodsID="+goods.getID()));
		goods.setDetail(detail);
		
		
	}

}
