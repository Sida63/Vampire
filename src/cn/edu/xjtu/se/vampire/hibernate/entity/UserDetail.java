package cn.edu.xjtu.se.vampire.hibernate.entity;

import java.util.Date;

/**
 * UserDetail entity.
 * @author Aetf
 */

public class UserDetail implements java.io.Serializable, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6658372135564909528L;
	private Integer id;
	private UserStatusInfo status;
	private User user;
	private String phone;
	private Integer score;
	private Integer reputation;
	private Integer defDelivery;
	private Date registeTime;
	private String xcode;
	private Date xtime;

	// Constructors

	/** default constructor */
	public UserDetail() {
	}

	/** minimal constructor */
	public UserDetail(UserStatusInfo status, Integer score,
			Integer reputation, Date registeTime) {
		this.status = status;
		this.score = score;
		this.reputation = reputation;
		this.registeTime = registeTime;
	}

	/** full constructor */
	public UserDetail(UserStatusInfo userstatusinfo, User user, String phone,
			Integer score, Integer reputation, Integer defDelivery,
			Date registeTime, String xcode, Date xtime) {
		this.status = userstatusinfo;
		this.user = user;
		this.phone = phone;
		this.score = score;
		this.reputation = reputation;
		this.defDelivery = defDelivery;
		this.registeTime = registeTime;
		this.xcode = xcode;
		this.xtime = xtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserStatusInfo getStatus() {
		return this.status;
	}

	public void setStatus(UserStatusInfo status) {
		this.status = status;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getReputation() {
		return this.reputation;
	}

	public void setReputation(Integer reputation) {
		this.reputation = reputation;
	}

	public Integer getDefDelivery() {
		return this.defDelivery;
	}

	public void setDefDelivery(Integer defDelivery) {
		this.defDelivery = defDelivery;
	}

	public Date getRegisteTime() {
		return this.registeTime;
	}

	public void setRegisteTime(Date registeTime) {
		this.registeTime = registeTime;
	}

	public String getXcode() {
		return this.xcode;
	}

	public void setXcode(String xcode) {
		this.xcode = xcode;
	}

	public Date getXtime() {
		return this.xtime;
	}

	public void setXtime(Date xtime) {
		this.xtime = xtime;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		UserDetail adm = null;
		try {
			adm = (UserDetail)super.clone();
			if(this.status != null)
				adm.status = (UserStatusInfo)this.status.clone();
			adm.user = null;
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
		if (!(obj instanceof UserDetail)) {
			return false;
		}
		UserDetail other = (UserDetail) obj;
		if (defDelivery == null) {
			if (other.defDelivery != null) {
				return false;
			}
		} else if (!defDelivery.equals(other.defDelivery)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!phone.equals(other.phone)) {
			return false;
		}
		if (registeTime == null) {
			if (other.registeTime != null) {
				return false;
			}
		} else if (!registeTime.equals(other.registeTime)) {
			return false;
		}
		if (reputation == null) {
			if (other.reputation != null) {
				return false;
			}
		} else if (!reputation.equals(other.reputation)) {
			return false;
		}
		if (score == null) {
			if (other.score != null) {
				return false;
			}
		} else if (!score.equals(other.score)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		if (xcode == null) {
			if (other.xcode != null) {
				return false;
			}
		} else if (!xcode.equals(other.xcode)) {
			return false;
		}
		if (xtime == null) {
			if (other.xtime != null) {
				return false;
			}
		} else if (!xtime.equals(other.xtime)) {
			return false;
		}
		return true;
	}

}