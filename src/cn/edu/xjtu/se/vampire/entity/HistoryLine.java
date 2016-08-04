package cn.edu.xjtu.se.vampire.entity;


import java.util.Date;

import cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable;

public class HistoryLine implements Identifiable {
	private Goods goods;
	private int userid;
	private Date browsetime;
    private int ID;
	@Override
	public int getID() {
		return ID;
	}

	@Override
	public void setID(int id) {
		// TODO Auto-generated method stub
		this.ID = id;
	}
	
    public Goods getGoods(){
    	return goods;    	
    }
    
    public void setGoods(Goods goods) {
    	this.goods = goods;
    }
    
    public int getUserID(){
    	return userid;
    }
    
    public void setUserID(int id) {
    	userid = id;
    }
    
    public Date getBrowseTime(){
    	return browsetime;
    }
    
    public void setBrowseTime(Date date) {
    	browsetime = date;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result
				+ ((browsetime == null) ? 0 : browsetime.hashCode());
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result + userid;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoryLine other = (HistoryLine) obj;
		if (ID != other.ID)
			return false;
		if (browsetime == null) {
			if (other.browsetime != null)
				return false;
		} else if (!browsetime.equals(other.browsetime))
			return false;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
}
