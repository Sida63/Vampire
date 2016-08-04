package cn.edu.xjtu.se.vampire.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity.
 * @author Aetf
 */

public class User implements java.io.Serializable, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6602975413640307909L;
	private Integer id;
	private String userName;
	private String password;
	private String salt;
	private String mailBox;
	private Set<Coupon> coupons = new HashSet<>(0);
	private Set<Comments> comments = new HashSet<>(0);
	private Set<History> histories = new HashSet<>(0);
	private Set<Delivery> deliveries = new HashSet<>(0);
	private Set<Favorite> favorites = new HashSet<>(0);
	private Set<Orders> orders = new HashSet<>(0);
	private UserDetail userDetail;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String password, String salt, String mailBox) {
		this.userName = userName;
		this.password = password;
		this.salt = salt;
		this.mailBox = mailBox;
	}

	/** full constructor */
	public User(String userName, String password, String salt, String mailBox,
			Set<Coupon> coupons, Set<Comments> comments, Set<History> histories, Set<Delivery> deliveries,
			Set<Favorite> favorites, UserDetail userDetail) {
		this.userName = userName;
		this.password = password;
		this.salt = salt;
		this.mailBox = mailBox;
		this.coupons = coupons;
		this.comments = comments;
		this.histories = histories;
		this.deliveries = deliveries;
		this.favorites = favorites;
		this.userDetail = userDetail;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getMailBox() {
		return this.mailBox;
	}

	public void setMailBox(String mailBox) {
		this.mailBox = mailBox;
	}

	public Set<Coupon> getCoupons() {
		return this.coupons;
	}

	public void setCoupons(Set<Coupon> coupons) {
		this.coupons = coupons;
	}

	public Set<Comments> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}

	public Set<History> getHistories() {
		return this.histories;
	}

	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}

	public Set<Delivery> getDeliveries() {
		return this.deliveries;
	}

	public void setDeliveries(Set<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public Set<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(Set<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userdetail) {
		this.userDetail = userdetail;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		return clone(true);
	}
	
	public Object clone(boolean withDetail) {
		User adm = null;
		try {
			adm = (User)super.clone();
			adm.coupons = null;
			adm.comments = null;
			adm.histories = null;
			adm.deliveries = null;
			adm.favorites = null;
			adm.orders = null;
			if(this.userDetail != null && withDetail)
				adm.userDetail = (UserDetail)this.userDetail.clone();
			else
				adm.userDetail = null;
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
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (comments == null) {
			if (other.comments != null) {
				return false;
			}
		} else if (!comments.equals(other.comments)) {
			return false;
		}
		if (coupons == null) {
			if (other.coupons != null) {
				return false;
			}
		} else if (!coupons.equals(other.coupons)) {
			return false;
		}
		if (deliveries == null) {
			if (other.deliveries != null) {
				return false;
			}
		} else if (!deliveries.equals(other.deliveries)) {
			return false;
		}
		if (favorites == null) {
			if (other.favorites != null) {
				return false;
			}
		} else if (!favorites.equals(other.favorites)) {
			return false;
		}
		if (histories == null) {
			if (other.histories != null) {
				return false;
			}
		} else if (!histories.equals(other.histories)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (mailBox == null) {
			if (other.mailBox != null) {
				return false;
			}
		} else if (!mailBox.equals(other.mailBox)) {
			return false;
		}
		if (orders == null) {
			if (other.orders != null) {
				return false;
			}
		} else if (!orders.equals(other.orders)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (salt == null) {
			if (other.salt != null) {
				return false;
			}
		} else if (!salt.equals(other.salt)) {
			return false;
		}
		if (userDetail == null) {
			if (other.userDetail != null) {
				return false;
			}
		} else if (!userDetail.equals(other.userDetail)) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		return true;
	}

}