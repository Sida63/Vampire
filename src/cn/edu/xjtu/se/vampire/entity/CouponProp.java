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
 * Created at 2014年2月21日
 * 
 */
public class CouponProp implements Identifiable {
	
	/**
	 * ID 
	 * 优惠券的ID
	 */
	private int id;
	
	/**
	 * Limit 
	 * 使用限额
	 */
	private int limit;
	
	/**
	 * Discount
	 * 减免金额
	 */
	private double discount;
	
	/**
	 * Least
	 * 起用限额
	 */
	private double least;
	
	/**
	 * Guarantee
	 * 有效期
	 */
	private int guarantee;

	/**
	 * 获得ID
	 * @return the id
	 */
	@Override
	public int getID() {
		return this.getId();
	}

	/**
	 * 设置ID
	 */
	@Override
	public void setID(int id) {
		this.setId(id);
	}

	/**
	 * 获得ID
	 * @return the id
	 */
	private int getId() {
		return id;
	}

	/**
	 * 设置ID
	 * @param id the id to set
	 */
	private void setId(int id) {
		this.id = id;
	}

	/**
	 * 获得使用限额
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * 设置使用限额
	 * @param limit the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * 获得减免金额
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * 设置减免金额
	 * @param discount the discount to set
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	/**
	 * 获得起用金额
	 * @return the least
	 */
	public double getLeast() {
		return least;
	}

	/**
	 * 设置起用金额
	 * @param least the least to set
	 */
	public void setLeast(double least) {
		this.least = least;
	}

	/**
	 * 获得有效期
	 * @return the guarantee
	 */
	public int getGuarantee() {
		return guarantee;
	}

	/**
	 * 设置有效期
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
