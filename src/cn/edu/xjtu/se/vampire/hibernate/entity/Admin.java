package cn.edu.xjtu.se.vampire.hibernate.entity;

/**
 * Admin entity.
 * @author Aetf
 */

public class Admin implements java.io.Serializable, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 832987565466656013L;
	
	private Integer id;
	private AdminGroupInfo adminGroup;
	private String adminName;
	private String password;
	private String salt;
	private boolean status;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(AdminGroupInfo adminGroup, String adminName,
			String password, String salt, boolean status) {
		this.adminGroup = adminGroup;
		this.adminName = adminName;
		this.password = password;
		this.salt = salt;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AdminGroupInfo getAdminGroup() {
		return this.adminGroup;
	}

	public void setAdminGroup(AdminGroupInfo adminGroup) {
		this.adminGroup = adminGroup;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		Admin adm = null;
		try {
			adm = (Admin)super.clone();
			if(this.adminGroup != null)
				adm.adminGroup = (AdminGroupInfo)this.adminGroup.clone();
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
		if (!(obj instanceof Admin)) {
			return false;
		}
		Admin other = (Admin) obj;
		if (adminGroup == null) {
			if (other.adminGroup != null) {
				return false;
			}
		} else if (!adminGroup.equals(other.adminGroup)) {
			return false;
		}
		if (adminName == null) {
			if (other.adminName != null) {
				return false;
			}
		} else if (!adminName.equals(other.adminName)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (salt == null) {
			if (other.salt != null) {
				return false;
			}
		} else if (!salt.equals(other.salt)) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		return true;
	}

}