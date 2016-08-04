package cn.edu.xjtu.se.vampire.hibernate.entity;

/**
 * Comments entity. 
 * @author Aetf
 */

public class Comments implements java.io.Serializable, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6500989561817789351L;
	private Integer id;
	private Goods goods;
	private User user;
	private short rate;
	private String text;

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** minimal constructor */
	public Comments(Goods goods, User user, short rate) {
		this.goods = goods;
		this.user = user;
		this.rate = rate;
	}

	/** full constructor */
	public Comments(Goods goods, User user, short rate, String text) {
		this.goods = goods;
		this.user = user;
		this.rate = rate;
		this.text = text;
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

	public short getRate() {
		return this.rate;
	}

	public void setRate(short rate) {
		this.rate = rate;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		Comments adm = null;
		try {
			adm = (Comments)super.clone();
			if(this.goods != null)
				adm.goods = (Goods)this.goods.clone(false);
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
		result = prime * result + rate;
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
		if (!(obj instanceof Comments)) {
			return false;
		}
		Comments other = (Comments) obj;
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
		if (rate != other.rate) {
			return false;
		}
		if (text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!text.equals(other.text)) {
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