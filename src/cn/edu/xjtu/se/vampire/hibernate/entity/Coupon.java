package cn.edu.xjtu.se.vampire.hibernate.entity;

import java.util.Date;

/**
 * Coupon entity.
 * @author Aetf
 */

public class Coupon implements java.io.Serializable, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7733839702612145816L;
	private Integer id;
	private CouponProp property;
	private User user;
	private String couponNumber;
	private Date issuedTime;

	// Constructors

	/** default constructor */
	public Coupon() {
	}

	/** full constructor */
	public Coupon(CouponProp property, User user, String couponNumber,
			Date issuedTime) {
		this.property = property;
		this.user = user;
		this.couponNumber = couponNumber;
		this.issuedTime = issuedTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CouponProp getProperty() {
		return this.property;
	}

	public void setProperty(CouponProp property) {
		this.property = property;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCouponNumber() {
		return this.couponNumber;
	}

	public void setCouponNumber(String couponNumber) {
		this.couponNumber = couponNumber;
	}

	public Date getIssuedTime() {
		return this.issuedTime;
	}

	public void setIssuedTime(Date issuedTime) {
		this.issuedTime = issuedTime;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		Coupon adm = null;
		try {
			adm = (Coupon)super.clone();
			adm.user = null;
			if(this.property != null)
				adm.property = (CouponProp)this.property.clone();
			
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
		if (!(obj instanceof Coupon)) {
			return false;
		}
		Coupon other = (Coupon) obj;
		if (couponNumber == null) {
			if (other.couponNumber != null) {
				return false;
			}
		} else if (!couponNumber.equals(other.couponNumber)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (issuedTime == null) {
			if (other.issuedTime != null) {
				return false;
			}
		} else if (!issuedTime.equals(other.issuedTime)) {
			return false;
		}
		if (property == null) {
			if (other.property != null) {
				return false;
			}
		} else if (!property.equals(other.property)) {
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