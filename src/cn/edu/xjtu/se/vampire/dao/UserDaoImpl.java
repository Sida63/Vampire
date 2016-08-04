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

import cn.edu.xjtu.se.vampire.dao.interfaces.IUserDao;
import cn.edu.xjtu.se.vampire.entity.Coupon;
import cn.edu.xjtu.se.vampire.entity.FavorLine;
import cn.edu.xjtu.se.vampire.entity.HistoryLine;
import cn.edu.xjtu.se.vampire.entity.User;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.Utilities;

/**
 * @author totran
 * @version 1.0
 * 
 * @author albert
 * @version 2.0 Created at 2014年2月25日 上午9:03:16
 * 
 */
public class UserDaoImpl implements IUserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xjtu.se.vampire.dao.IDBAccessor#add(cn.edu.xjtu.se.vampire.dao
	 * .Identifiable)
	 */
	@Override
	public boolean add(User t) {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = JDBCUtil.getConnection();
			String sql1 = "insert into UserDetail (Phone,Status,Score,Reputation,RegisteTime) values(?,?,?,?,?)";
			
			pst = conn.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);

			pst.setString(1,t.getExtendInfo().getPhone());
			pst.setInt(2,t.getExtendInfo().getStatus());
			pst.setInt(3,t.getExtendInfo().getScore());
			pst.setInt(4,t.getExtendInfo().getReputation());
			pst.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
	
			pst.executeUpdate();
			
			ResultSet rs;
			rs=pst.getGeneratedKeys();
			rs.next();
			int DetailInfo=rs.getInt(1);
			
			pst.close();
			
			
	
			String sql2 = "insert into User (UserName,Password,Salt,MailBox,DetailInfo) values(?,?,?,?,?)";
			
			pst = conn.prepareStatement(sql2);

			pst.setString(1,t.getName());
			pst.setString(2,t.getPassword());
			pst.setString(3,t.getSalt());
			pst.setString(4,t.getMailBox());
			pst.setInt(5,DetailInfo);
	
			pst.executeUpdate();
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closes(null, pst, conn);
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
	public boolean update(User t) {
		//记得加判断
		Connection conn = null;
		PreparedStatement pst = null;

		
		
		try {
//			conn = JDBCUtil.getConnection();
//			String sql = "update User set name=?,password=? where id=?";
//			pst = conn.prepareStatement(sql);
//
//			pst.setString(1, t.getName());
//			pst.setString(2, t.getPassword());
//			pst.setInt(3, t.getID());
//			pst.executeUpdate();
			
			
			conn = JDBCUtil.getConnection();
			
			if(t.getExtendInfo()!=null){
				String sql1 = "update UserDetail set Phone=?,Status=?,Score=?,Reputation=?,RegisteTime=? where ID=?";
				
				pst = conn.prepareStatement(sql1);

				pst.setString(1,t.getExtendInfo().getPhone());
				pst.setInt(2,t.getExtendInfo().getStatus());
				pst.setInt(3,t.getExtendInfo().getScore());
				pst.setInt(4,t.getExtendInfo().getReputation());
				pst.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
				pst.setInt(6,t.getExtendInfo().getID());
		
				pst.executeUpdate();
				
			
				
				pst.close();
				
				String sql2 = "update User set UserName=?,Password=?,Salt=?,MailBox=?,DetailInfo=? where ID=?";
				
				pst = conn.prepareStatement(sql2);

				pst.setString(1,t.getName());
				pst.setString(2,t.getPassword());
				pst.setString(3,t.getSalt());
				pst.setString(4,t.getMailBox());
				
				
					pst.setInt(5,t.getExtendInfo().getID());
					pst.setInt(6,t.getID());
				
				
		
				pst.executeUpdate();
			}

			
			
	
			String sql2 = "update User set UserName=?,Password=?,Salt=?,MailBox=? where ID=?";
			
			pst = conn.prepareStatement(sql2);

			pst.setString(1,t.getName());
			pst.setString(2,t.getPassword());
			pst.setString(3,t.getSalt());
			pst.setString(4,t.getMailBox());
		
			pst.setInt(5,t.getID());
			
		
				
			
	
			pst.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closes(null, pst, conn);
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
	public boolean delete(User t) {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = JDBCUtil.getConnection();
			String sql1 = "delete from User where ID = ?";
			pst = conn.prepareStatement(sql1);
			pst.setInt(1, t.getID());

			pst.executeUpdate();
			
			pst.close();
			
			String sql2 = "delete from UserDetail where ID = ?";
			pst = conn.prepareStatement(sql2);
			pst.setInt(1, t.getExtendInfo().getID());

			pst.executeUpdate();
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closes(null, pst, conn);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.edu.xjtu.se.vampire.dao.IDBAccessor#select(java.lang.String)
	 */
	@Override
	public Set<User> select(String key) {

		Connection conn = null;
		PreparedStatement pst = null;
		Set<User>  set = new HashSet<User> ();
		ResultSet rs = null;
		User user = null;
		try{
			 conn = JDBCUtil.getConnection();
			 String sql ="select * from User "+Utilities.generateWhereStatement(key);
			 pst = conn.prepareStatement(sql);
			 
			 rs = pst.executeQuery();
			 while(rs.next()){
				 user = new User();
				 user.setID(rs.getInt("ID"));
				 user.setName(rs.getString("UserName"));
				 user.setPassword(rs.getString("Password"));
				 user.setSalt(rs.getString("Salt"));
				 user.setMailBox(rs.getString("MailBox"));
	
				 set.add(user);
			 }
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			//6：关闭资源  先开后关
			JDBCUtil.closes(null, pst, conn);
		}
		return set;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.edu.xjtu.se.vampire.dao.IUserDao#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public User login(String name, String password) {
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user =  null;
		try{
			 conn = JDBCUtil.getConnection();
			
			 String sql ="select * from User where UserName=? and Password=?";
			 pst = conn.prepareStatement(sql);
			 pst.setString(1,name);
			 pst.setString(2, password);
			 rs = pst.executeQuery();
			 
			 if(rs==null||!rs.next()){
				 	return null;
			 }
				
			 user = new User();
			 user.setID(rs.getInt("ID"));
			 user.setName(rs.getString("UserName"));
			 user.setPassword(rs.getString("Password"));
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			//6：关闭资源  先开后关
			JDBCUtil.closes(null, pst, conn);
		}
		return user;
		
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xjtu.se.vampire.dao.IUserDao#populateExtendInfo(cn.edu.xjtu.se
	 * .vampire.entity.User, int)
	 */
	
	/**
	 * 填充指定User的ExtendInfo。
	 * @param user
	 * @param flags
	 * 			通过标志指定是否填充指定属性。
	 *            1:History
	 *            2:Favorite
	 *            4:Deliveries
	 *            8:Coupons
	 *          以上标志可以通过按位或进行组合。
	 *          如：
	 *          flags = （1 | 2 | 8）
	 *          则执行后UserExtendInfo的History，Favorite，Coupons属性拥有数据，而Deliveries为空
	 */
	@Override
	public void populateExtendInfo(User user, int flags) {
		
		// 使用FavorDaoImpl；HistoryDaoImpl；CouponDaoImpl类的具体方法实现
		
		try{
			if((flags&1)!=0){
				HistoryDaoImpl His = new HistoryDaoImpl();
				Set<HistoryLine> rs = His.select("ID = user.getID()");
				
				user.getExtendInfo().setHistory(rs);
				
				
			}
		
			 
			 if((flags&2)!=0) {
				 FavorDaoImpl fav = new FavorDaoImpl();
				 Set<FavorLine> rs = fav.select("ID = user.getID()");
				 
				 user.getExtendInfo().setFavorite(rs);
			 }
			 
			 if((flags&4)!=0) {
				 
			 }
			 if((flags&8)!=0) {
				 
				 CouponDaoImpl cou = new  CouponDaoImpl();
				 Set<Coupon> rs = cou.select("ID = user.getID()");
				 user.getExtendInfo().setCoupons(rs);
			 }
			 
			 
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			//6：关闭资源  先开后关
			
		}
		return;
	}

}
