package cn.edu.xjtu.se.vampire.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * GoodsType entity.
 * @author Aetf
 */

public class GoodsType implements java.io.Serializable, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6309306514706291266L;
	private Integer id;
	private GoodsType parent;
	private String typeName;
	private Set<GoodsType> children;
	private Set<Goods> goods = new HashSet<>(0);

	// Constructors

	/** default constructor */
	public GoodsType() {
	}

	/** minimal constructor */
	public GoodsType(String typeName) {
		this.typeName = typeName;
	}

	/** full constructor */
	public GoodsType(GoodsType parent, String typeName, Set<GoodsType> children,
			Set<Goods> goods) {
		this.parent = parent;
		this.typeName = typeName;
		this.children = children;
		this.goods = goods;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GoodsType getParent() {
		return this.parent;
	}

	public void setParent(GoodsType parent) {
		this.parent = parent;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set<GoodsType> getChildren() {
		return this.children;
	}

	public void setChildren(Set<GoodsType> children) {
		this.children = children;
	}

	public Set<Goods> getGoods() {
		return this.goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		GoodsType adm = null;
		try {
			adm = (GoodsType)super.clone();
			adm.goods = null;
			adm.children = null;
			if(this.parent != null)
				adm.parent = (GoodsType)this.parent.clone();
//			else
//				adm.parent = null;
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
		if (!(obj instanceof GoodsType)) {
			return false;
		}
		GoodsType other = (GoodsType) obj;
		if (children == null) {
			if (other.children != null) {
				return false;
			}
		} else if (!children.equals(other.children)) {
			return false;
		}
		if (goods == null) {
			if (other.goods != null) {
				return false;
			}
		} else if (!goods.equals(other.goods)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (parent == null) {
			if (other.parent != null) {
				return false;
			}
		} else if (!parent.equals(other.parent)) {
			return false;
		}
		if (typeName == null) {
			if (other.typeName != null) {
				return false;
			}
		} else if (!typeName.equals(other.typeName)) {
			return false;
		}
		return true;
	}

}