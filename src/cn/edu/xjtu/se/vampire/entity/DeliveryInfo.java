/*
 * Copyright (c) 2014, Aetf
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
import cn.edu.xjtu.se.vampire.util.OnePair;

/**
 * Model class of DeliveryInfo.
 * 
 * @author Aetf
 */
public class DeliveryInfo implements Identifiable {

	/** ID. */
	private int id;

	/** User. */
	private int userid;

	/** Receiver. */
	private String receiver;

	/** AreaInfo. */
	private OnePair areacodeareainfo;

	/** DetailAddr. */
	private String detailaddr;

	/** Tel. */
	private String tel;

	/**
	 * Constructor.
	 */
	public DeliveryInfo() {
	}

	/**
	 * Set the ID.
	 * 
	 * @param id
	 *            ID
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * Get the ID.
	 * 
	 * @return ID
	 */
	public int getID() {
		return this.id;
	}

	/**
	 * Set the User.
	 * 
	 * @param user
	 *            User
	 */
	public void setUser(int userid) {
		this.userid = userid;
	}

	/**
	 * Get the User.
	 * 
	 * @return User
	 */
	public int getUser() {
		return this.userid;
	}

	/**
	 * Set the Receiver.
	 * 
	 * @param receiver
	 *            Receiver
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * Get the Receiver.
	 * 
	 * @return Receiver
	 */
	public String getReceiver() {
		return this.receiver;
	}

	/**
	 * Set the AreaInfo.
	 * 
	 * @param areacodeareainfo
	 *            AreaInfo
	 */
	public void setAreacodeareainfo(OnePair areacodeareainfo) {
		this.areacodeareainfo = areacodeareainfo;
	}

	/**
	 * Get the AreaInfo.
	 * 
	 * @return AreaInfo
	 */
	public OnePair getAreacodeareainfo() {
		return this.areacodeareainfo;
	}

	/**
	 * Set the DetailAddr.
	 * 
	 * @param detailaddr
	 *            DetailAddr
	 */
	public void setDetailaddr(String detailaddr) {
		this.detailaddr = detailaddr;
	}

	/**
	 * Get the DetailAddr.
	 * 
	 * @return DetailAddr
	 */
	public String getDetailaddr() {
		return this.detailaddr;
	}

	/**
	 * Set the Tel.
	 * 
	 * @param tel
	 *            Tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * Get the Tel.
	 * 
	 * @return Tel
	 */
	public String getTel() {
		return this.tel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((areacodeareainfo == null) ? 0 : areacodeareainfo.hashCode());
		result = prime * result
				+ ((detailaddr == null) ? 0 : detailaddr.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		DeliveryInfo other = (DeliveryInfo) obj;
		if (areacodeareainfo == null) {
			if (other.areacodeareainfo != null)
				return false;
		} else if (!areacodeareainfo.equals(other.areacodeareainfo))
			return false;
		if (detailaddr == null) {
			if (other.detailaddr != null)
				return false;
		} else if (!detailaddr.equals(other.detailaddr))
			return false;
		if (id != other.id)
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}


}

