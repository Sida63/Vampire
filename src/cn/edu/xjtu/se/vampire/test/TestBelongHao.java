package cn.edu.xjtu.se.vampire.test;


import cn.edu.xjtu.se.vampire.hibernate.dao.CommentsDAO;
import cn.edu.xjtu.se.vampire.hibernate.entity.Comments;
import cn.edu.xjtu.se.vampire.hibernate.entity.Goods;
import cn.edu.xjtu.se.vampire.hibernate.entity.User;

public class TestBelongHao {
	public static void main(String[] args) {
		Goods goods=new Goods();
		User user=new User();
		goods.setId(4);
		user.setId(5);
		Comments comment=new Comments();
		comment.setGoods(goods);
		comment.setUser(user);
		comment.setRate((short)5);
		comment.setText("交大无美女");
//		save(goods,user,comment);
//		findAll();
//		delete(comment);
//		findbyid(5);
		comment.setId(4);
		//findbyid(4);
        findByProperty("id",4);
//		
		
	}
	public static void save(Goods goods,User user,Comments comment){

		new CommentsDAO().save(comment);
	}
	public static void findAll(){
		new CommentsDAO().findAll();
	}
	public static void delete(Comments comment){
		comment.setId(6);
		new CommentsDAO().delete(comment);
	}
	public static void findbyid(int id){
		new CommentsDAO().findById(id);
	}
	public static void findByProperty(String colum,Object value){
		new CommentsDAO().findByProperty(colum,value);
	}

}
