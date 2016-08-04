/**
 * Copyright (c) 2014, totran <392165719@qq.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package cn.edu.xjtu.se.vampire.entity;

import java.util.Date;

import cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable;

/**
 * @author totran
 * @version 1.0
 * Created at 2014��2��21��
 *
 */
public class Coupon implements Identifiable{
	/**
	 * ID
	 * �Ż�ȯID
	 */
	private int id;
	
	/**
	 * UserID
	 * �Ż�ȯ�����û�ID
	 */
	private int userID;
	
	/**
	 * Property
	 * �Ż�ȯ����
	 */
	private CouponProp property = new CouponProp();
	
	/**
	 * CouponNumber
	 * �Ż�ȯ���
	 */
	private String couponNum;
	
	/**
	 * IssueTime
	 * ����ʱ��
	 */
	private Date issuedTime;

	/**
	 * ���ID
	 * @return the id
	 */
	@Override
	public int getID() {
		return this.getId();
	}

	/**
	 * ����ID
	 */
	@Override
	public void setID(int id) {
		this.setId(id);
	}

	/**
	 * ���ID
	 * @return the id
	 */
	private int getId() {
		return id;
	}

	/**
	 * ����ID
	 * @param id the id to set
	 */
	private void setId(int id) {
		this.id = id;
	}

	/**
	 * ����Ż�ȯ���Զ���
	 * @return the property
	 */
	public CouponProp getProperty() {
		return property;
	}

	/**
	 * �����Ż�ȯ���Զ���
	 * @param property the property to set
	 */
	public void setProperty(CouponProp property) {
		this.property = property;
	}

	/**
	 * ����Ż�ȯ���
	 * @return the couponNum
	 */
	public String getCouponNum() {
		return couponNum;
	}

	/**
	 * �����Ż�ȯ���
	 * @param couponNum the couponNum to set
	 */
	public void setCouponNum(String couponNum) {
		this.couponNum = couponNum;
	}

	/**
	 * ����Ż�ȯ����ʱ��
	 * @return the issueTime
	 */
	public Date getIssueTime() {
		return issuedTime;
	}

	/**
	 * �����Ż�ȯ����ʱ��
	 * @param issueTime the issueTime to set
	 */
	public void setIssueTime(Date issueTime) {
		this.issuedTime = issueTime;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((couponNum == null) ? 0 : couponNum.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((issuedTime == null) ? 0 : issuedTime.hashCode());
		result = prime * result
				+ ((property == null) ? 0 : property.hashCode());
		result = prime * result + userID;
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
		Coupon other = (Coupon) obj;
		if (couponNum == null) {
			if (other.couponNum != null)
				return false;
		} else if (!couponNum.equals(other.couponNum))
			return false;
		if (id != other.id)
			return false;
		if (issuedTime == null) {
			if (other.issuedTime != null)
				return false;
		} else if (!issuedTime.equals(other.issuedTime))
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}
	
}
