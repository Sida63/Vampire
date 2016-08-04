package cn.edu.xjtu.se.vampire.hibernate.entity;

/**
 * GoodsDetail entity.
 * @author Aetf
 */

public class GoodsDetail implements java.io.Serializable, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6855731011366218201L;
	private Integer id;
	private Goods goods;
	private String goodsDesc;
	private String provider;
	private Integer storage;
	private double price;
	private Integer sales;
	private String imgPath;

	// Constructors

	/** default constructor */
	public GoodsDetail() {
	}

	/** minimal constructor */
	public GoodsDetail(Integer storage, double price, Integer sales) {
		this.storage = storage;
		this.price = price;
		this.sales = sales;
	}

	/** full constructor */
	public GoodsDetail(Goods goods, String goodsDesc, String provider,
			Integer storage, double price, Integer sales, String imgPath) {
		this.goods = goods;
		this.goodsDesc = goodsDesc;
		this.provider = provider;
		this.storage = storage;
		this.price = price;
		this.sales = sales;
		this.imgPath = imgPath;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getGoodsDesc() {
		return this.goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Integer getStorage() {
		return this.storage;
	}

	public void setStorage(Integer storage) {
		this.storage = storage;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getSales() {
		return this.sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		GoodsDetail adm = null;
		try {
			adm = (GoodsDetail)super.clone();
			adm.goods = null;
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
		if (!(obj instanceof GoodsDetail)) {
			return false;
		}
		GoodsDetail other = (GoodsDetail) obj;
		if (goods == null) {
			if (other.goods != null) {
				return false;
			}
		} else if (!goods.equals(other.goods)) {
			return false;
		}
		if (goodsDesc == null) {
			if (other.goodsDesc != null) {
				return false;
			}
		} else if (!goodsDesc.equals(other.goodsDesc)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (imgPath == null) {
			if (other.imgPath != null) {
				return false;
			}
		} else if (!imgPath.equals(other.imgPath)) {
			return false;
		}
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price)) {
			return false;
		}
		if (provider == null) {
			if (other.provider != null) {
				return false;
			}
		} else if (!provider.equals(other.provider)) {
			return false;
		}
		if (sales == null) {
			if (other.sales != null) {
				return false;
			}
		} else if (!sales.equals(other.sales)) {
			return false;
		}
		if (storage == null) {
			if (other.storage != null) {
				return false;
			}
		} else if (!storage.equals(other.storage)) {
			return false;
		}
		return true;
	}

}