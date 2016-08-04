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
import java.util.Iterator;
import java.util.Set;

import cn.edu.xjtu.se.vampire.dao.interfaces.IOrderDao;
import cn.edu.xjtu.se.vampire.entity.Order;
import cn.edu.xjtu.se.vampire.entity.OrderLine;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author totran
 * @version 1.0
 * Created at 2014年2月25日 上午10:29:39
 * 
 */
public class OrderDaoImpl implements IOrderDao {

	/* (non-Javadoc)
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#add(cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean add(Order t) {
		//String sql="insert into Order(ID,address) values('"+t.getID()+"','"+t.getID()+"','"+t.getID()+"','"+t.getID()+"','"+t.getID()+"')";
		Connection conn = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		ResultSet rs=null;
		
		try{
			 conn = JDBCUtil.getConnection();
			 String sql1 ="insert into orders(UserID,OrderNumber,Time,TotalAmount,DiscountAmount,PayWay,PayStatus,Status,Remark) values(?,?,?,?,?,?,?,?,?)";
			 String sql2 ="insert into orderDetail(OrderID,GoodsID,Amount,Price) values(?,?,?,?)";
			 pst1 = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			 pst1.setInt(1,t.getUser().getID());
			 pst1.setString(2,t.getOrderNumber());
			 pst1.setTimestamp(3,new java.sql.Timestamp(new java.util.Date().getTime()));
			 pst1.setDouble(4,t.getTotalAmount());
			 pst1.setDouble(5,t.getDiscountAmount());
			 pst1.setBoolean(6,t.getPayWay());
			 pst1.setBoolean(7,t.getPayStatus());
			 pst1.setInt(8,t.getStatus());
			 pst1.setString(9,t.getRemark());
			 //pst.setString(2, t.);
			 //pst.setString(3, user.getPassword());
			 pst1.executeUpdate();
	
			 rs=pst1.getGeneratedKeys();
				rs.next();
				t.setID(rs.getInt(1));
				
			 Iterator<OrderLine> it = t.getChoosen().iterator();
			 pst2 = conn.prepareStatement(sql2);
			 while(it.hasNext()){
				 OrderLine ol = it.next();
				 pst2.setInt(1,t.getID());
				 pst2.setInt(2,ol.getGoods().getID());
				 pst2.setInt(3,ol.getAmount());
				 pst2.setDouble(4,ol.getPrice());
				 
				 pst2.executeUpdate();
				}	 
			 //pst.setString(2, t.);
			 //pst.setString(3, user.getPassword());
			 return true;
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			//6：关闭资源  先开后关
			JDBCUtil.closes(null, pst1, conn);
			JDBCUtil.closes(null, pst2, null);
		}
		
		// TODO Auto-generated method stub
		// 写入数据库时先添加Order表信息，再写入OrderLine表
		return false;
	}

	/* (non-Javadoc)
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#update(cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean update(Order t) {
		Connection conn = null;
		PreparedStatement pst1 = null;
		try{
			 conn = JDBCUtil.getConnection();
			 String sql1 ="update Orders set UserID=?,OrderNumber=?,Time=?,TotalAmount=?,DiscountAmount=?,PayWay=?,PayStatus=?,Status=?,Remark=? where ID=?";
			 pst1 = conn.prepareStatement(sql1);
			 pst1.setInt(1,t.getUser().getID());
			 pst1.setString(2,t.getOrderNumber());
			 pst1.setTimestamp(3,new java.sql.Timestamp(new java.util.Date().getTime()));
			 pst1.setDouble(4,t.getTotalAmount());
			 pst1.setDouble(5,t.getDiscountAmount());
			 pst1.setBoolean(6,t.getPayWay());
			 pst1.setBoolean(7,t.getPayStatus());
			 pst1.setInt(8,t.getStatus());
			 pst1.setString(9,t.getRemark());
			 pst1.setInt(10, t.getID());
			 pst1.executeUpdate();
			 return true;
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			//6：关闭资源  先开后关
			JDBCUtil.closes(null, pst1, conn);
			
		}
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#delete(cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable)
	 */
	@Override
	public boolean delete(Order t) {
		Connection conn = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		try{
			
			 conn = JDBCUtil.getConnection();
			 String sql1="delete from OrderDetail where OrderID='"+t.getID()+"'";
			 String sql2="delete from Orders where ID='"+t.getID()+"'";
			 pst1 = conn.prepareStatement(sql1);
			 pst1.executeUpdate();
			 pst2 = conn.prepareStatement(sql2);
			 pst2.executeUpdate();
			 return true;
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			//6：关闭资源  先开后关
			JDBCUtil.closes(null, pst1, conn);
			JDBCUtil.closes(null, pst2, null);
			
			
		}
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.IDBAccessor#select(java.lang.String)
	 */
	@Override
	public Set<Order> select(String key) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Set<Order> result = new HashSet<Order>();
		try{
			 conn = JDBCUtil.getConnection();
			 st = conn.createStatement();
			 String sql1="select * from Orders "+Utilities.generateWhereStatement(key);
			 rs = st.executeQuery(sql1);
			 while (rs.next()) {
					Order ol = new Order();
					ol.setID(rs.getInt("ID"));
					ol.setUser(Utilities.first(new UserDaoImpl().select("ID="
						+ rs.getInt("UserID"))));
					ol.setOrderNumber(rs.getString("OrderNumber"));
					ol.setTime(new java.sql.Timestamp(new java.util.Date().getTime()));
					ol.setTotalAmount(rs.getDouble("TotalAmount"));
					ol.setDiscountAmount(rs.getDouble("DiscountAmount"));
					ol.setPayWay(rs.getBoolean("PayWay"));
					ol.setPayStatus(rs.getBoolean("PayStatus"));
					ol.setStatus(rs.getInt("Status"));
					ol.setRemark(rs.getString("Remark"));
					
					

					result.add(ol);
				}
			 
			 
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			//6：关闭资源  先开后关
			JDBCUtil.closes(rs, st, conn);
			
		}
		// TODO Auto-generated method stub
		return result;
	}

}
