package fr.projet.domain.criteria;

import java.time.LocalDate;

public class OrderCriteria {
	
	private LocalDate purchaseDate;
	private String orderNumber;
	private Integer totalPrice;

	public OrderCriteria(LocalDate purchaseDate, String orderNumber, Integer totalPrice) {
		super();
		this.purchaseDate = purchaseDate;
		this.orderNumber = orderNumber;
		this.totalPrice = totalPrice;
	}

	public boolean hasCriterias() {
		return orderNumber !=null || purchaseDate !=null || totalPrice != null; 
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

}
