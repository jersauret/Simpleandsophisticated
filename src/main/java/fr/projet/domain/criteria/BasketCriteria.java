package fr.projet.domain.criteria;

public class BasketCriteria {
	private Integer discount;

	private Integer shippingCost;

	public BasketCriteria() {
		
	}
	public BasketCriteria(Integer discount, Integer shippingCost) {
		super();
		this.discount = discount;
		this.shippingCost = shippingCost;
	}
	public boolean hasCriterias() {
		return discount !=null || shippingCost !=null;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Integer shippingCost) {
		this.shippingCost = shippingCost;
	}
}
