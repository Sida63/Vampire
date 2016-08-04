package cn.edu.xjtu.se.vampire.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * OrderStatusInfo entity.
 * @author Aetf
 */

public class OrderStatusInfo implements java.io.Serializable, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1621742974515769970L;
	private Integer id;
	private String orderStatus;
	private Set<Orders> orders = new HashSet<>(0);

	// Constructors

	/** default constructor */
	public OrderStatusInfo() {
	}

	/** minimal constructor */
	public OrderStatusInfo(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/** full constructor */
	public OrderStatusInfo(String orderStatus, Set<Orders> orders) {
		this.orderStatus = orderStatus;
		this.orders = orders;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Set<Orders> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Orders> orderses) {
		this.orders = orderses;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		OrderStatusInfo adm = null;
		try {
			adm = (OrderStatusInfo)super.clone();
			adm.orders = null;
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
		if (!(obj instanceof OrderStatusInfo)) {
			return false;
		}
		OrderStatusInfo other = (OrderStatusInfo) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (orderStatus == null) {
			if (other.orderStatus != null) {
				return false;
			}
		} else if (!orderStatus.equals(other.orderStatus)) {
			return false;
		}
		if (orders == null) {
			if (other.orders != null) {
				return false;
			}
		} else if (!orders.equals(other.orders)) {
			return false;
		}
		return true;
	}

}