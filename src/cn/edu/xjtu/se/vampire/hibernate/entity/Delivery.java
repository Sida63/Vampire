package cn.edu.xjtu.se.vampire.hibernate.entity;

/**
 * Delivery entity.
 * @author Aetf
 */

public class Delivery implements java.io.Serializable, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1852296803556281513L;
	private Integer id;
	private User user;
	private AreaInfo areaCode;
	private String receiver;
	private String detailAddr;
	private String tel;

	// Constructors

	/** default constructor */
	public Delivery() {
	}

	/** full constructor */
	public Delivery(User user, AreaInfo areaCode, String receiver,
			String detailAddr, String tel) {
		this.user = user;
		this.areaCode = areaCode;
		this.receiver = receiver;
		this.detailAddr = detailAddr;
		this.tel = tel;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AreaInfo getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(AreaInfo areaCode) {
		this.areaCode = areaCode;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getDetailAddr() {
		return this.detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		Delivery adm = null;
		try {
			adm = (Delivery)super.clone();
			if(this.user != null)
				adm.user = (User)this.user.clone(false);
			if(this.areaCode != null)
				adm.areaCode = (AreaInfo)this.areaCode.clone();
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
		if (!(obj instanceof Delivery)) {
			return false;
		}
		Delivery other = (Delivery) obj;
		if (areaCode == null) {
			if (other.areaCode != null) {
				return false;
			}
		} else if (!areaCode.equals(other.areaCode)) {
			return false;
		}
		if (detailAddr == null) {
			if (other.detailAddr != null) {
				return false;
			}
		} else if (!detailAddr.equals(other.detailAddr)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (receiver == null) {
			if (other.receiver != null) {
				return false;
			}
		} else if (!receiver.equals(other.receiver)) {
			return false;
		}
		if (tel == null) {
			if (other.tel != null) {
				return false;
			}
		} else if (!tel.equals(other.tel)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

}