package cn.edu.xjtu.se.vampire.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Goods entity.
 * @author Aetf
 */

public class Goods implements java.io.Serializable, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4438150005113731675L;
	private Integer id;
	private GoodsType type;
	private String goodsName;
	private String goodsNumber;
	private String tags;
	private Set<Comments> comments = new HashSet<>(0);
	private GoodsDetail goodsDetail;
	private Set<OrderDetail> orderDetails = new HashSet<>(0);
	private Set<Favorite> favorites = new HashSet<>(0);
	private Set<History> histories = new HashSet<>(0);

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(GoodsType type, String goodsName, String goodsNumber) {
		this.type = type;
		this.goodsName = goodsName;
		this.goodsNumber = goodsNumber;
	}

	/** full constructor */
	public Goods(GoodsType goodstype, String goodsName, String goodsNumber,
			String tags, Set<Comments> comments, GoodsDetail goodsDetail,
			Set<OrderDetail> orderDetails, Set<Favorite> favorites, Set<History> histories) {
		this.type = goodstype;
		this.goodsName = goodsName;
		this.goodsNumber = goodsNumber;
		this.tags = tags;
		this.comments = comments;
		this.goodsDetail = goodsDetail;
		this.orderDetails = orderDetails;
		this.favorites = favorites;
		this.histories = histories;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GoodsType getType() {
		return this.type;
	}

	public void setType(GoodsType type) {
		this.type = type;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Set<Comments> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comments> commentses) {
		this.comments = commentses;
	}

	public GoodsDetail getGoodsDetail() {
		return this.goodsDetail;
	}

	public void setGoodsDetail(GoodsDetail goodsdetail) {
		this.goodsDetail = goodsdetail;
	}

	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Set<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(Set<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Set<History> getHistories() {
		return this.histories;
	}

	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		return clone(true);
	}
	
	public Object clone(boolean withDetail) {
		Goods adm = null;
		try {
			adm = (Goods)super.clone();
			adm.comments = null;
			adm.favorites = null;
			adm.histories = null;
			adm.orderDetails = null;
			if(this.type != null)
				adm.type = (GoodsType)this.type.clone();
			if(this.goodsDetail != null && withDetail)
				adm.goodsDetail = (GoodsDetail)this.goodsDetail.clone();
			else
				adm.goodsDetail = null;
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
		if (!(obj instanceof Goods)) {
			return false;
		}
		Goods other = (Goods) obj;
		if (comments == null) {
			if (other.comments != null) {
				return false;
			}
		} else if (!comments.equals(other.comments)) {
			return false;
		}
		if (favorites == null) {
			if (other.favorites != null) {
				return false;
			}
		} else if (!favorites.equals(other.favorites)) {
			return false;
		}
		if (goodsDetail == null) {
			if (other.goodsDetail != null) {
				return false;
			}
		} else if (!goodsDetail.equals(other.goodsDetail)) {
			return false;
		}
		if (goodsName == null) {
			if (other.goodsName != null) {
				return false;
			}
		} else if (!goodsName.equals(other.goodsName)) {
			return false;
		}
		if (goodsNumber == null) {
			if (other.goodsNumber != null) {
				return false;
			}
		} else if (!goodsNumber.equals(other.goodsNumber)) {
			return false;
		}
		if (histories == null) {
			if (other.histories != null) {
				return false;
			}
		} else if (!histories.equals(other.histories)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (orderDetails == null) {
			if (other.orderDetails != null) {
				return false;
			}
		} else if (!orderDetails.equals(other.orderDetails)) {
			return false;
		}
		if (tags == null) {
			if (other.tags != null) {
				return false;
			}
		} else if (!tags.equals(other.tags)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

}