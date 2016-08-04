package cn.edu.xjtu.se.vampire.entity;
import cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable;

/**
 * 
 * @author albert
 * @version 1.0
 * @since 2014.2.21
 */
public class User implements Identifiable {//用户基本信息表
		
	private int ID;//用户ID
	private String name;//用户名。用户名唯一，长度不超过32

	private String password;//用户密码。长度8-64

	private String salt;//密码加盐
	
	private String MailBox;
	public String getMailBox() {
		return MailBox;
	}
	public void setMailBox(String mailBox) {
		MailBox = mailBox;
	}
	private UserExtendInfo extendInfo;//扩展信息ID
	
	
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		this.ID = id;
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
	public UserExtendInfo getExtendInfo() {
		return extendInfo;
	}
	public void setExtendInfo(UserExtendInfo extendInfo) {
		this.extendInfo = extendInfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((MailBox == null) ? 0 : MailBox.hashCode());
		result = prime * result
				+ ((extendInfo == null) ? 0 : extendInfo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
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
		User other = (User) obj;
		if (ID != other.ID)
			return false;
		if (MailBox == null) {
			if (other.MailBox != null)
				return false;
		} else if (!MailBox.equals(other.MailBox))
			return false;
		if (extendInfo == null) {
			if (other.extendInfo != null)
				return false;
		} else if (!extendInfo.equals(other.extendInfo))
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
		return true;
	}
	
	
}
