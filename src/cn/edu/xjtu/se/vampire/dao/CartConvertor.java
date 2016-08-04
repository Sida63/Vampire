
package cn.edu.xjtu.se.vampire.dao;


import javax.servlet.http.Cookie;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cn.edu.xjtu.se.vampire.dao.interfaces.ICartConvertor;
import cn.edu.xjtu.se.vampire.entity.Cart;
import cn.edu.xjtu.se.vampire.entity.CartLine;

/**
 * @author totran
 * @version 1.0
 * Created at 2014年2月25日 上午10:25:30
 * 
 */
public class CartConvertor implements ICartConvertor {

	/* (non-Javadoc)
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.ICartConvertor#toCookieString(cn.edu.xjtu.se.vampire.entity.Cart)
	 */
	
	public String toCookieString(Cart cart) {
		// TODO Auto-generated method stub
		Group group = new Group();
		group.setId(cart.getID());
		group.setUserID(cart.getUserid());
		group.setChoosen(cart.getChoosen());
		String jsonString=JSON.toJSONString(group);
		Cookie cookie = new Cookie("Cookie",jsonString);	 
		cookie.setMaxAge(3600*24*365);		 
		cookie.setPath("/");

		return null;
	}

	/* (non-Javadoc)
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.ICartConvertor#fromCookieString(java.lang.String)
	 */
	@Override
	public Cart fromCookieString(String cookieRead) {
		if(cookieRead!=null){
			cookieRead =cookieRead.substring(0, cookieRead.length() - 1); // 去掉尾部的 ')'			
			Cart jp=(Cart) JSONObject.parseObject(cookieRead, Cart.class);
			return jp;		
			
		}
		
		// TODO Auto-generated method stub
		
		return null;
	}
		 
		public class Group {
		private int id;
		private int UserID ;
		private CartLine choosen[];
		public int getId() { return id; }
		public void setId(int id) { this.id = id; }
		public int getUserID() { return UserID; }
		public void setUserID(int userID) { this.UserID = userID; }
		public CartLine[] getChoosen() {
			return choosen;
		}
		public void setChoosen(CartLine[] choosen) {
			this.choosen = choosen;
		}
	   


		}
		 

}
