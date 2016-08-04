
package cn.edu.xjtu.se.vampire.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;







import cn.edu.xjtu.se.vampire.dao.interfaces.ICommentDao;
import cn.edu.xjtu.se.vampire.entity.Comment;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;
import cn.edu.xjtu.se.vampire.util.Utilities;


public class CommentDaoImpl implements ICommentDao {

//添加评论
	public boolean add(Comment t) {
		Connection conn=null;
		PreparedStatement pst = null;
		try{
			conn = JDBCUtil.getConnection();
			String sql="INSERT INTO `vampiredb`.`comments`(GoodsID,UserID,Rate,Text) VALUES (?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1,t.getGoodsid() );
			pst.setInt(2,t.getUserID());
			pst.setInt(3, t.getRate());
			pst.setString(4,t.getText());
			pst.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.closes(null, pst, conn);
		}
		
		return false;
	}

//修改评论
	public boolean update(Comment t) {
		Connection conn=null;
		PreparedStatement pst = null;
		try{
			conn = JDBCUtil.getConnection();
			String sql="UPDATE `vampiredb`.`comments` SET `GoodsID`=?,UserID=?,Rate=?,Text=? where id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, t.getGoodsid());
			pst.setInt(2, t.getUserID());
			pst.setInt(3, t.getRate());
			pst.setString(4,t.getText());
			pst.setInt(5, t.getID());
			pst.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.closes(null, pst, conn);
		}
		
		return false;

		
	}
//删除评论
	public boolean delete(Comment t) {
		Connection conn=null;
		PreparedStatement pst = null;
		try{
			conn = JDBCUtil.getConnection();
			String sql="delete from `vampiredb`.`comments` where `id` =?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, t.getID());
			pst.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.closes(null, pst, conn);
		}
		
		return false;

	
	}
//选择评论

	public Set<Comment> select(String key) {
		Connection conn=null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		Comment comment=new Comment();
		HashSet<Comment> selectComment=new HashSet<Comment>();
		try{
			conn = JDBCUtil.getConnection();
			String sql="select * from `vampiredb`.`comments` "+Utilities.generateWhereStatement(key);
			pst = conn.prepareStatement(sql);
			rs=pst.executeQuery();
			System.out.println("true");
			while(rs.next()){
				comment.setID(rs.getInt("ID"));
				comment.setGoodsid(rs.getInt("GoodsID"));
				comment.setUserID(rs.getInt("UserID"));
				comment.setRate(rs.getInt("rate"));
				comment.setText(rs.getString("Text"));
				selectComment.add(comment);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.closes(null, pst, conn);
		}

		return selectComment;
	}

}
