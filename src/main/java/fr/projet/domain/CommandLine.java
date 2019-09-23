package fr.projet.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "commandline_")
public class CommandLine implements Serializable {

	private static final long serialVersionUID = -3326848200375558388L;

	@EmbeddedId
	private CommandLineId id;

	private Integer quantities;

	@ManyToOne
	@JoinColumn(name = "product_id"/*, insertable = false, updatable = false*/)
	private Product product;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "order_id"/*, insertable = false, updatable = false*/)
	private Order order;

//	@ManyToOne
//	private Basket basket;
	
	public CommandLine() {
	}

	public CommandLine(CommandLineId id, Integer quantities) {
		this.id = id;
		this.quantities = quantities;
	}

	public CommandLine(Long productId, Long orderId, Integer quantities) {
		this.id = new CommandLineId(orderId, productId);
		this.quantities = quantities;
	}

	public Integer getQuantities() {
		return quantities;
	}

	public void setQuantities(Integer quantities) {
		this.quantities = quantities;
	}

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	public Order getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}

	public CommandLineId getId() {
		return id;
	}

	public void setId(CommandLineId id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
