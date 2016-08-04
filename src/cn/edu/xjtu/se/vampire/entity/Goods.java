package cn.edu.xjtu.se.vampire.entity;
import cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable;
import cn.edu.xjtu.se.vampire.util.OnePair;
/**
 * 商品基本信息类
 * @author Yours
 *
 */
public class Goods implements Identifiable{
	private int ID;//商品ID
	private String name;//商品名称
	private String goodNumber;//商品编号
	private GoodsDetail detail;//商品详细信息
	private OnePair type;//商品类型
	private String tags;//商品标签

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}

	@Override
	public void setID(int id) {
		// TODO Auto-generated method stub
		this.ID=id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getGoodNumber() {
		return goodNumber;
	}

	public void setGoodNumber(String goodNumber) {
		this.goodNumber = goodNumber;
	}
	
	
	

	public GoodsDetail getDetail() {
		return detail;
	}

	public void setDetail(GoodsDetail detail) {
		this.detail = detail;
	}

	public OnePair getType() {
		return type;
	}

	public void setType(OnePair type) {
		this.type = type;
	}
	
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
		result = prime * result
				+ ((goodNumber == null) ? 0 : goodNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Goods other = (Goods) obj;
		if (ID != other.ID)
			return false;
		if (detail == null) {
			if (other.detail != null)
				return false;
		} else if (!detail.equals(other.detail))
			return false;
		if (goodNumber == null) {
			if (other.goodNumber != null)
				return false;
		} else if (!goodNumber.equals(other.goodNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	

}
