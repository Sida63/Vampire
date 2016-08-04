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
 * Created at 2014��2��21�� ����4:09:42
 * 
 */
public class Comment implements Identifiable {

	/**
	 * ID
	 * ����ID
	 */
	private int id;
	/**
	 * ��ƷID
	 */
	private int Goodsid;
	/**
	 * �û�
	 */
	private int userid;
	
	/**
	 * ����
	 */
	private int rate;
	

	/**
	 * ����
	 */
	private String text;
	
	
	/**
	 * ���ID
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable#getID()
	 */
	@Override
	public int getID() {
		return this.getId();
	}

	/**
	 * ����ID
	 * @see cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable#setID(int)
	 */
	@Override
	public void setID(int id) {
		this.setId(id);
	}

	/**
	 * @return the id
	 */
	private int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	private void setId(int id) {
		this.id = id;
	}

	/**
	 * ����û�
	 * @return the user
	 */
	public int getUserID() {
		return userid;
	}

	/**
	 * �����û�
	 * @param use the user to set
	 */
	public void setUserID(int userid) {
		this.userid = userid;
	}

	/**
	 * �������
	 * @return the rate
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * ��������
	 * @param rate the rate to set
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}

	/**
	 * �������
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * ��������
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * ��ȡ��ƷID
	 * @param text the text to set
	 */
	public int getGoodsid() {
		return Goodsid;
	}
	/**
	 * ������ƷID
	 * @param text the text to set
	 */
	public void setGoodsid(int goodsid) {
		Goodsid = goodsid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Goodsid;
		result = prime * result + id;
		result = prime * result + rate;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + userid;
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
		Comment other = (Comment) obj;
		if (Goodsid != other.Goodsid)
			return false;
		if (id != other.id)
			return false;
		if (rate != other.rate)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
}
