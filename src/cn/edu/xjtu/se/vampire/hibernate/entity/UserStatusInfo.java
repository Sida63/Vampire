package cn.edu.xjtu.se.vampire.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * UserStatusInfo entity.
 * @author Aetf
 */

public class UserStatusInfo implements java.io.Serializable, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1505560528039976079L;
	private Integer id;
	private String userStatus;
	private Set<UserDetail> userDetails = new HashSet<>(0);

	// Constructors

	/** default constructor */
	public UserStatusInfo() {
	}

	/** minimal constructor */
	public UserStatusInfo(String userStatus) {
		this.userStatus = userStatus;
	}

	/** full constructor */
	public UserStatusInfo(String userStatus, Set<UserDetail> userDetails) {
		this.userStatus = userStatus;
		this.userDetails = userDetails;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Set<UserDetail> getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(Set<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		UserStatusInfo adm = null;
		try {
			adm = (UserStatusInfo)super.clone();
			adm.userDetails = null;
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
		if (!(obj instanceof UserStatusInfo)) {
			return false;
		}
		UserStatusInfo other = (UserStatusInfo) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (userDetails == null) {
			if (other.userDetails != null) {
				return false;
			}
		} else if (!userDetails.equals(other.userDetails)) {
			return false;
		}
		if (userStatus == null) {
			if (other.userStatus != null) {
				return false;
			}
		} else if (!userStatus.equals(other.userStatus)) {
			return false;
		}
		return true;
	}

}