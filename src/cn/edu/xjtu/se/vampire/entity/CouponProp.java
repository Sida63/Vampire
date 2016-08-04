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

import cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable;

/**
 * @author totran
 * @version 1.0 
 * Created at 2014��2��21��
 * 
 */
public class CouponProp implements Identifiable {
	
	/**
	 * ID 
	 * �Ż�ȯ��ID
	 */
	private int id;
	
	/**
	 * Limit 
	 * ʹ���޶�
	 */
	private int limit;
	
	/**
	 * Discount
	 * ������
	 */
	private double discount;
	
	/**
	 * Least
	 * �����޶�
	 */
	private double least;
	
	/**
	 * Guarantee
	 * ��Ч��
	 */
	private int guarantee;

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
	 * ���ʹ���޶�
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * ����ʹ���޶�
	 * @param limit the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * ��ü�����
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * ���ü�����
	 * @param discount the discount to set
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	/**
	 * ������ý��
	 * @return the least
	 */
	public double getLeast() {
		return least;
	}

	/**
	 * �������ý��
	 * @param least the least to set
	 */
	public void setLeast(double least) {
		this.least = least;
	}

	/**
	 * �����Ч��
	 * @return the guarantee
	 */
	public int getGuarantee() {
		return guarantee;
	}

	/**
	 * ������Ч��
	 * @param guarantee the guarantee to set
	 */
	public void setGuarantee(int guarantee) {
		this.guarantee = guarantee;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + guarantee;
		result = prime * result + id;
		temp = Double.doubleToLongBits(least);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + limit;
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
		CouponProp other = (CouponProp) obj;
		if (Double.doubleToLongBits(discount) != Double
				.doubleToLongBits(other.discount))
			return false;
		if (guarantee != other.guarantee)
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(least) != Double
				.doubleToLongBits(other.least))
			return false;
		if (limit != other.limit)
			return false;
		return true;
	}
	
}
