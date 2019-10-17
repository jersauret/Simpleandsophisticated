package fr.projet.domain.criteria;

import java.time.LocalDate;

import fr.projet.domain.CommandStatus;

public class OrderCriteria {
	
	private LocalDate purchaseDate;
	private String orderNumber;
	

	private Integer totalPrice;
	private CommandStatus commandStatus;

	
	

	public OrderCriteria(LocalDate purchaseDate, String orderNumber, Integer totalPrice, CommandStatus commandStatus) {
		super();
		this.purchaseDate = purchaseDate;
		this.orderNumber = orderNumber;
		this.totalPrice = totalPrice;
		
	}

	public boolean hasCriterias() {
		return orderNumber !=null || purchaseDate !=null || totalPrice != null || commandStatus !=null; 
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
	public CommandStatus getCommandStatus() {
		return commandStatus;
	}

	public void setCommandStatus(CommandStatus commandStatus) {
		this.commandStatus = commandStatus;
	}
	

}
