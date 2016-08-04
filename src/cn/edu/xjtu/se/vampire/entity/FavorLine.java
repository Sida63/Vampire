package cn.edu.xjtu.se.vampire.entity;

import cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable;

public class FavorLine implements Identifiable {

	Goods goods;
	private int id;
	private int m_userid;

	@Override
	public int getID() { // 得到id
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setID(int id) { // 设置id
		// TODO Auto-generated method stub
		this.id = id;
	}

	/**
	 * 获取该收藏条目的相关商品
	 * 
	 * @return
	 */
	public Goods getGoods() {
		return goods;
	}

	/**
	 * 设置该收藏条目的相关商品
	 * 
	 * @param goods
	 */
	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	/**
	 * 获取该收藏条目的相关联用户ID
	 * 
	 * @return
	 */
	public int getUserID() {
		return m_userid;
	}

	/**
	 * 设置该收藏条目的相关联用户ID
	 * 
	 * @param id
	 */
	public void setUserID(int id) {
		m_userid = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result + id;
		result = prime * result + m_userid;
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
		FavorLine other = (FavorLine) obj;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (id != other.id)
			return false;
		if (m_userid != other.m_userid)
			return false;
		return true;
	}

	
}
