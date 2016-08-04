package cn.edu.xjtu.se.vampire.entity;

import java.util.Date;
import java.util.Set;

import cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable;

/**
 * 
 * @author albert
 * @version 1.0
 * @since 2014.2.21
 * 
 */
public class UserExtendInfo implements Identifiable {// �û���չ��Ϣ��

	private int ID;// ������ϢID
	private String mailBox;// ����
	private String phone;// �ֻ�
	private int status;// �û�״̬��0.δ���1.���ã�2.���á�
	private int score;// ���֡���������1Ԫ���1����
	private int reputation;// �����ȡ���ʼΪ100��ÿ��Υ���涨���֣��������üӷ֣�������Խ������Խ�á�������涨�պ����飩

	private DeliveryInfo defDelivery;// ������Ϣ��ID

	private Date RegistTime;// ע��ʱ��
	private Set<HistoryLine> History;// �����ʷ
	private Set<FavorLine> Favorite;// �ղ�
	private Set<DeliveryInfo> Deliveries;// ������Ϣ
	private Set<Coupon> Coupons;// �Ż�ȯ
	private String XCode;// ʶ���롣ʶ���������û���������һصȣ�������Ϊһ�� 24Сʱ 864000000000 ʱ������

	private Date XTime;// ʶ��������ʱ�䡣ʶ��������ʱ�������ж�ʶ�����Ƿ����

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getMailBox() {
		return mailBox;
	}

	public void setMailBox(String mailBox) {
		this.mailBox = mailBox;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	public DeliveryInfo getDefDelivery() {
		return defDelivery;
	}

	public void setDefDelivery(DeliveryInfo defDelivery) {
		this.defDelivery = defDelivery;
	}

	public Date getRegistTime() {
		return RegistTime;
	}

	public void setRegistTime(Date registTime) {
		RegistTime = registTime;
	}

	public Set<HistoryLine> getHistory() {
		return History;
	}

	public void setHistory(Set<HistoryLine> history) {
		History = history;
	}

	public Set<FavorLine> getFavorite() {
		return Favorite;
	}

	public void setFavorite(Set<FavorLine> favorite) {
		Favorite = favorite;
	}

	public Set<DeliveryInfo> getDeliveries() {
		return Deliveries;
	}

	public void setDeliveries(Set<DeliveryInfo> deliveries) {
		Deliveries = deliveries;
	}

	public Set<Coupon> getCoupons() {
		return Coupons;
	}

	public void setCoupons(Set<Coupon> coupons) {
		Coupons = coupons;
	}

	public String getXCode() {
		return XCode;
	}

	public void setXCode(String xCode) {
		XCode = xCode;
	}

	public Date getXTime() {
		return XTime;
	}

	public void setXTime(Date xTime) {
		XTime = xTime;
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
		result = prime * result + ((Coupons == null) ? 0 : Coupons.hashCode());
		result = prime * result
				+ ((Deliveries == null) ? 0 : Deliveries.hashCode());
		result = prime * result
				+ ((Favorite == null) ? 0 : Favorite.hashCode());
		result = prime * result + ((History == null) ? 0 : History.hashCode());
		result = prime * result + ID;
		result = prime * result
				+ ((RegistTime == null) ? 0 : RegistTime.hashCode());
		result = prime * result + ((XCode == null) ? 0 : XCode.hashCode());
		result = prime * result + ((XTime == null) ? 0 : XTime.hashCode());
		result = prime * result
				+ ((defDelivery == null) ? 0 : defDelivery.hashCode());
		result = prime * result + ((mailBox == null) ? 0 : mailBox.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + reputation;
		result = prime * result + score;
		result = prime * result + status;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		UserExtendInfo other = (UserExtendInfo) obj;
		if (Coupons == null) {
			if (other.Coupons != null)
				return false;
		} else if (!Coupons.equals(other.Coupons))
			return false;
		if (Deliveries == null) {
			if (other.Deliveries != null)
				return false;
		} else if (!Deliveries.equals(other.Deliveries))
			return false;
		if (Favorite == null) {
			if (other.Favorite != null)
				return false;
		} else if (!Favorite.equals(other.Favorite))
			return false;
		if (History == null) {
			if (other.History != null)
				return false;
		} else if (!History.equals(other.History))
			return false;
		if (ID != other.ID)
			return false;
		if (RegistTime == null) {
			if (other.RegistTime != null)
				return false;
		} else if (!RegistTime.equals(other.RegistTime))
			return false;
		if (XCode == null) {
			if (other.XCode != null)
				return false;
		} else if (!XCode.equals(other.XCode))
			return false;
		if (XTime == null) {
			if (other.XTime != null)
				return false;
		} else if (!XTime.equals(other.XTime))
			return false;
		if (defDelivery == null) {
			if (other.defDelivery != null)
				return false;
		} else if (!defDelivery.equals(other.defDelivery))
			return false;
		if (mailBox == null) {
			if (other.mailBox != null)
				return false;
		} else if (!mailBox.equals(other.mailBox))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (reputation != other.reputation)
			return false;
		if (score != other.score)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}
