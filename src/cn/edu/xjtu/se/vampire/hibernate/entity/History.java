package cn.edu.xjtu.se.vampire.hibernate.entity;

import java.util.Date;

/**
 * History entity.
 * @author Aetf
 */

public class History implements java.io.Serializable, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2615513816848991420L;
	private Integer id;
	private Goods goods;
	private User user;
	private Date browseTime;

	// Constructors

	/** default constructor */
	public History() {
	}

	/** full constructor */
	public History(Goods goods, User user, Date browseTime) {
		this.goods = goods;
		this.user = user;
		this.browseTime = browseTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getBrowseTime() {
		return this.browseTime;
	}

	public void setBrowseTime(Date browseTime) {
		this.browseTime = browseTime;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		return clone(false);
	}
	
	
	public Object clone(boolean withGoodsDetail) {
		History adm = null;
		try {
			adm = (History)super.clone();
			if(this.goods != null)
				adm.goods = (Goods)this.goods.clone(withGoodsDetail);
			if(this.user != null)
				adm.user = (User)this.user.clone(false);
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return adm;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof History)) {
			return false;
		}
		History other = (History) obj;
		if (browseTime == null) {
			if (other.browseTime != null) {
				return false;
			}
		} else if (!browseTime.equals(other.browseTime)) {
			return false;
		}
		if (goods == null) {
			if (other.goods != null) {
				return false;
			}
		} else if (!goods.equals(other.goods)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

}