package cn.edu.xjtu.se.vampire.test;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cn.edu.xjtu.se.vampire.dao.CommentDaoImpl;
import cn.edu.xjtu.se.vampire.entity.Comment;
import cn.edu.xjtu.se.vampire.util.JDBCUtil;

public class TestBelongQian {
	public static void main(String args[]) throws Exception{
		Connection conn = JDBCUtil.getConnection();
		assert(conn != null);
		//System.out.println(JDBCUtil.getConnection());
		CommentDaoImpl commentDao=new CommentDaoImpl();
		Comment comment=new Comment();
		comment.setGoodsid(4);
		comment.setUserID(5);
		comment.setRate(5);
		comment.setText("=.=");
//		boolean result=commentDao.add(comment);
//		boolean result=commentDao.update(comment);	
//		boolean result=commentDao.delete(comment);	
//		commentDao.select("`id`=4");
		Set<Comment> set=new HashSet<Comment>();
		set=commentDao.select("`id`=4");
		Iterator<Comment> it=set.iterator();
		 while(it.hasNext()){  
	            Comment g=(Comment)it.next(); 
	            System.out.println(g.getText());  
	        }
//		System.out.println(result);
		
		
	}


}
