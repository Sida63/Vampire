package cn.edu.xjtu.se.vampire.hibernate.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity.
 * @author Aetf
 */

public class Orders implements java.io.Serializable,Cloneable{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -220601951401085918L;
	private Integer id;
	private OrderStatusInfo status;
	private User user;
	private String orderNumber;
	private Date time;
	private double totalAmount;
	private double discountAmount;
	private boolean payWay;
	private boolean payStatus;
	private String remark;
	private Set<OrderDetail> orderDetails = new HashSet<>(0);

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(OrderStatusInfo status, User user,
			String orderNumber, Date time, double totalAmount,
			double discountAmount, boolean payWay, boolean payStatus,
			String remark) {
		this.status = status;
		this.user = user;
		this.orderNumber = orderNumber;
		this.time = time;
		this.totalAmount = totalAmount;
		this.discountAmount = discountAmount;
		this.payWay = payWay;
		this.payStatus = payStatus;
		this.remark = remark;
	}

	/** full constructor */
	public Orders(OrderStatusInfo status, User user,
			String orderNumber, Date time, double totalAmount,
			double discountAmount, boolean payWay, boolean payStatus,
			String remark, Set<OrderDetail> orderdetails) {
		this.status = status;
		this.user = user;
		this.orderNumber = orderNumber;
		this.time = time;
		this.totalAmount = totalAmount;
		this.discountAmount = discountAmount;
		this.payWay = payWay;
		this.payStatus = payStatus;
		this.remark = remark;
		this.orderDetails = orderdetails;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderStatusInfo getStatus() {
		return this.status;
	}

	public void setStatus(OrderStatusInfo status) {
		this.status = status;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getDiscountAmount() {
		return this.discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public boolean getPayWay() {
		return this.payWay;
	}

	public void setPayWay(boolean payWay) {
		this.payWay = payWay;
	}

	public boolean getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(boolean payStatus) {
		this.payStatus = payStatus;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		Orders adm = null;
		try {
			adm = (Orders)super.clone();
			if(this.status != null)
				adm.status = (OrderStatusInfo)this.status.clone();
			if(this.user != null)
				adm.user = (User)this.user.clone(false);
			if(this.orderDetails != null) {
				adm.orderDetails = new HashSet<>();
				for(OrderDetail od : this.orderDetails)
					adm.orderDetails.add((OrderDetail)od.clone());
			}
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
		if (!(obj instanceof Orders)) {
			return false;
		}
		Orders other = (Orders) obj;
		if (Double.doubleToLongBits(discountAmount) != Double
				.doubleToLongBits(other.discountAmount)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (orderDetails == null) {
			if (other.orderDetails != null) {
				return false;
			}
		} else if (!orderDetails.equals(other.orderDetails)) {
			return false;
		}
		if (orderNumber == null) {
			if (other.orderNumber != null) {
				return false;
			}
		} else if (!orderNumber.equals(other.orderNumber)) {
			return false;
		}
		if (payStatus != other.payStatus) {
			return false;
		}
		if (payWay != other.payWay) {
			return false;
		}
		if (remark == null) {
			if (other.remark != null) {
				return false;
			}
		} else if (!remark.equals(other.remark)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		if (time == null) {
			if (other.time != null) {
				return false;
			}
		} else if (!time.equals(other.time)) {
			return false;
		}
		if (Double.doubleToLongBits(totalAmount) != Double
				.doubleToLongBits(other.totalAmount)) {
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