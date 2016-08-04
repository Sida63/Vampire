package cn.edu.xjtu.se.vampire.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * CouponProp entity.
 * 
 * @author Aetf
 */

public class CouponProp implements java.io.Serializable, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 9193546573928669694L;
	private Integer id;
	private Integer limits;
	private double discount;
	private double least;
	private Integer guarantee;
	private String description;
	private Set<Coupon> coupons = new HashSet<>(0);

	// Constructors

	/** default constructor */
	public CouponProp() {
	}

	/** minimal constructor */
	public CouponProp(Integer limits, double discount, double least,
			Integer guarantee) {
		this.limits = limits;
		this.discount = discount;
		this.least = least;
		this.guarantee = guarantee;
	}

	/** full constructor */
	public CouponProp(Integer limits, double discount, double least,
			Integer guarantee, Set<Coupon> coupons) {
		this.limits = limits;
		this.discount = discount;
		this.least = least;
		this.guarantee = guarantee;
		this.coupons = coupons;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLimits() {
		return this.limits;
	}

	public void setLimits(Integer limits) {
		this.limits = limits;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getLeast() {
		return this.least;
	}

	public void setLeast(double least) {
		this.least = least;
	}

	public Integer getGuarantee() {
		return this.guarantee;
	}

	public void setGuarantee(Integer guarantee) {
		this.guarantee = guarantee;
	}

	public Set<Coupon> getCoupons() {
		return this.coupons;
	}

	public void setCoupons(Set<Coupon> coupons) {
		this.coupons = coupons;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		CouponProp adm = null;
		try {
			adm = (CouponProp) super.clone();
			adm.coupons = null;
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return adm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((guarantee == null) ? 0 : guarantee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		temp = Double.doubleToLongBits(least);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((limits == null) ? 0 : limits.hashCode());
		return result;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		if (!(obj instanceof CouponProp)) {
			return false;
		}
		CouponProp other = (CouponProp) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (Double.doubleToLongBits(discount) != Double
				.doubleToLongBits(other.discount)) {
			return false;
		}
		if (guarantee == null) {
			if (other.guarantee != null) {
				return false;
			}
		} else if (!guarantee.equals(other.guarantee)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (Double.doubleToLongBits(least) != Double
				.doubleToLongBits(other.least)) {
			return false;
		}
		if (limits == null) {
			if (other.limits != null) {
				return false;
			}
		} else if (!limits.equals(other.limits)) {
			return false;
		}
		return true;
	}

}