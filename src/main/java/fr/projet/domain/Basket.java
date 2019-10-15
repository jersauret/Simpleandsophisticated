package fr.projet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="basket_")
public class Basket implements IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6484690257594116288L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private Integer discount;
	
	private Integer shippingCost;
	
	
//	@OneToMany(mappedBy = "basket")
//	private List<CommandLine> CommandLines;
	//ID session ??????
	
	@OneToOne
	private Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

//	public List<CommandLine> getCommandLines() {
//		return CommandLines;
//	}
//
//	public void setCommandLines(List<CommandLine> commandLines) {
//		CommandLines = commandLines;
//	}
	
	
}
