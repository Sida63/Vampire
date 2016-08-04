package cn.edu.xjtu.se.vampire.entity;

import cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable;
import cn.edu.xjtu.se.vampire.util.OnePair;

/**
 * 
 * @author albert
 * @version 1.0
 * @since 2014.2.21
 */
public class Administrator implements Identifiable {// 管理员信息表

	private int ID;// 管理员ID
	private String name;// 管理员名
	private String password;// 管理员密码
	private String salt;// 密码加盐处理
	private OnePair Group;// 管理员角色。0.超级管理员（SM）；1.用户管理员（UM）；2.商品管理员（GM）；3.订单管理员（OM）。

	private boolean status;// 账号状态。0表示停用，1表示启用

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public OnePair getGroup() {
		return Group;
	}

	public void setGroup(OnePair group) {
		Group = group;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Group == null) ? 0 : Group.hashCode());
		result = prime * result + ID;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
		result = prime * result + (status ? 1231 : 1237);
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
		Administrator other = (Administrator) obj;
		if (Group == null) {
			if (other.Group != null)
				return false;
		} else if (!Group.equals(other.Group))
			return false;
		if (ID != other.ID)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!salt.equals(other.salt))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}
