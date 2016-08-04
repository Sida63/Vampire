package cn.edu.xjtu.se.vampire.entity;



import java.util.Date;
import java.util.Set;

import cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable;

public class Order implements Identifiable{

	private int id;
	private String OrderNumber;
	private Date Time;
	private Double TotalAmount;
	private Double DiscountAmount;
	private Boolean PayWay;
	private Boolean PayStatus;
	private User user;
	private int Status;
	private String Remark;
	private Set<OrderLine> Choosen;
 
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}

	
	public void setID(int id) {
		// TODO Auto-generated method stub
		this.id=id;
	}
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getOrderNumber() {
		return OrderNumber;
	}


	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}


	public Date getTime() {
		return Time;
	}


	public void setTime(Date time) {
		Time = time;
	}


	public Double getTotalAmount() {
		return TotalAmount;
	}


	public void setTotalAmount(Double totalAmount) {
		TotalAmount = totalAmount;
	}


	public Double getDiscountAmount() {
		return DiscountAmount;
	}


	public void setDiscountAmount(Double discountAmount) {
		DiscountAmount = discountAmount;
	}


	public Boolean getPayWay() {
		return PayWay;
	}


	public void setPayWay(Boolean payWay) {
		PayWay = payWay;
	}


	public Boolean getPayStatus() {
		return PayStatus;
	}


	public void setPayStatus(Boolean payStatus) {
		PayStatus = payStatus;
	}


	public int getStatus() {
		return Status;
	}


	public void setStatus(int status) {
		Status = status;
	}


	public String getRemark() {
		return Remark;
	}


	public void setRemark(String remark) {
		Remark = remark;
	}
	
    public Set<OrderLine> getChoosen(){
    	return Choosen;
    }
    public void setChoosen(Set<OrderLine> t){
    	Choosen=t;
    }


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Choosen == null) ? 0 : Choosen.hashCode());
		result = prime * result
				+ ((DiscountAmount == null) ? 0 : DiscountAmount.hashCode());
		result = prime * result
				+ ((OrderNumber == null) ? 0 : OrderNumber.hashCode());
		result = prime * result
				+ ((PayStatus == null) ? 0 : PayStatus.hashCode());
		result = prime * result + ((PayWay == null) ? 0 : PayWay.hashCode());
		result = prime * result + ((Remark == null) ? 0 : Remark.hashCode());
		result = prime * result + Status;
		result = prime * result + ((Time == null) ? 0 : Time.hashCode());
		result = prime * result
				+ ((TotalAmount == null) ? 0 : TotalAmount.hashCode());
		result = prime * result + id;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Order other = (Order) obj;
		if (Choosen == null) {
			if (other.Choosen != null)
				return false;
		} else if (!Choosen.equals(other.Choosen))
			return false;
		if (DiscountAmount == null) {
			if (other.DiscountAmount != null)
				return false;
		} else if (!DiscountAmount.equals(other.DiscountAmount))
			return false;
		if (OrderNumber == null) {
			if (other.OrderNumber != null)
				return false;
		} else if (!OrderNumber.equals(other.OrderNumber))
			return false;
		if (PayStatus == null) {
			if (other.PayStatus != null)
				return false;
		} else if (!PayStatus.equals(other.PayStatus))
			return false;
		if (PayWay == null) {
			if (other.PayWay != null)
				return false;
		} else if (!PayWay.equals(other.PayWay))
			return false;
		if (Remark == null) {
			if (other.Remark != null)
				return false;
		} else if (!Remark.equals(other.Remark))
			return false;
		if (Status != other.Status)
			return false;
		if (Time == null) {
			if (other.Time != null)
				return false;
		} else if (!Time.equals(other.Time))
			return false;
		if (TotalAmount == null) {
			if (other.TotalAmount != null)
				return false;
		} else if (!TotalAmount.equals(other.TotalAmount))
			return false;
		if (id != other.id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
    
}
