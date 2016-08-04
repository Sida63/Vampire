package cn.edu.xjtu.se.vampire.entity;

import java.util.Arrays;

import cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable;

public class Cart implements Identifiable{


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(Choosen);
		result = prime * result + id;
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
		Cart other = (Cart) obj;
		if (!Arrays.equals(Choosen, other.Choosen))
			return false;
		if (id != other.id)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setID(int id) {
		// TODO Auto-generated method stub
		this.id=id;
	}
	public int getUserid() {
		return userid;
	}

	public void setUser(int user) {
		this.userid = user;
	}

	public CartLine[] getChoosen() {
		return Choosen;
	}

	public void setChoosen(CartLine[] choosen) {
		Choosen = choosen;
	}
	
	private int userid;
    private CartLine Choosen[];
    private int id;
}
