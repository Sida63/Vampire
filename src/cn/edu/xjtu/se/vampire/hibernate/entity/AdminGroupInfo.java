package cn.edu.xjtu.se.vampire.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AdminGroupInfo entity.
 * @author Aetf
 */

public class AdminGroupInfo implements java.io.Serializable, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8249539265195074852L;
	private Integer id;
	private String adminGroup;
	private Integer privilege;
	private Set<Admin> admins = new HashSet<>(0);

	// Constructors

	/** default constructor */
	public AdminGroupInfo() {
	}

	/** minimal constructor */
	public AdminGroupInfo(String adminGroup, Integer privilege) {
		this.adminGroup = adminGroup;
		this.privilege = privilege;
	}

	/** full constructor */
	public AdminGroupInfo(String adminGroup, Integer privilege, Set<Admin> admins) {
		this.adminGroup = adminGroup;
		this.privilege = privilege;
		this.admins = admins;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdminGroup() {
		return this.adminGroup;
	}

	public void setAdminGroup(String adminGroup) {
		this.adminGroup = adminGroup;
	}

	public Integer getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(Integer privilege) {
		this.privilege = privilege;
	}

	public Set<Admin> getAdmins() {
		return this.admins;
	}

	public void setAdmins(Set<Admin> admins) {
		this.admins = admins;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		AdminGroupInfo adm = null;
		try {
			adm = (AdminGroupInfo)super.clone();
			adm.admins = null;
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
		if (!(obj instanceof AdminGroupInfo)) {
			return false;
		}
		AdminGroupInfo other = (AdminGroupInfo) obj;
		if (adminGroup == null) {
			if (other.adminGroup != null) {
				return false;
			}
		} else if (!adminGroup.equals(other.adminGroup)) {
			return false;
		}
		if (admins == null) {
			if (other.admins != null) {
				return false;
			}
		} else if (!admins.equals(other.admins)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (privilege == null) {
			if (other.privilege != null) {
				return false;
			}
		} else if (!privilege.equals(other.privilege)) {
			return false;
		}
		return true;
	}

}