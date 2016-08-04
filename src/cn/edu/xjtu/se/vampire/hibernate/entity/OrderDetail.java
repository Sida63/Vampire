package cn.edu.xjtu.se.vampire.hibernate.entity;

/**
 * OrderDetail entity.
 * @author Aetf
 */

public class OrderDetail implements java.io.Serializable, Cloneable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4831576151596254684L;
	private Integer id;
	private Goods goods;
	private Orders orders;
	private Integer amount;
	private double price;

	// Constructors

	/** default constructor */
	public OrderDetail() {
	}

	/** full constructor */
	public OrderDetail(Goods goods, Orders orders, Integer amount, double price) {
		this.goods = goods;
		this.orders = orders;
		this.amount = amount;
		this.price = price;
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

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		return clone(false);
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone(boolean withGoodsDetail) {
		OrderDetail adm = null;
		try {
			adm = (OrderDetail)super.clone();
			adm.orders = null;
			if(this.goods != null)
				adm.goods = (Goods)this.goods.clone(withGoodsDetail);
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
		if (!(obj instanceof OrderDetail)) {
			return false;
		}
		OrderDetail other = (OrderDetail) obj;
		if (amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!amount.equals(other.amount)) {
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
		if (orders == null) {
			if (other.orders != null) {
				return false;
			}
		} else if (!orders.equals(other.orders)) {
			return false;
		}
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price)) {
			return false;
		}
		return true;
	}

}