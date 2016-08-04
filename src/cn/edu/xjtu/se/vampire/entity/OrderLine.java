package cn.edu.xjtu.se.vampire.entity;

import cn.edu.xjtu.se.vampire.dao.interfaces.Identifiable;

public class OrderLine implements Identifiable{
	
    Goods goods;
	private int amount;
	private double price;
	private int id;
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public void setID(int id) {
		// TODO Auto-generated method stub
		this.id=id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
    public Goods getGoods(){
    	return goods;
    }
    public void setGoods(Goods goods) {
    	this.goods = goods;
    }
    
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		OrderLine other = (OrderLine) obj;
		if (amount != other.amount)
			return false;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}
}
