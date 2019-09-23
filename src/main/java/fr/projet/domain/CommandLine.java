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
public class CommandLine implements IoEntity {

	private static final long serialVersionUID = -3326848200375558388L;

	@EmbeddedId
	private Long id;

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

	public Integer getQuantities() {
		return quantities;
	}

	public void setQuantities(Integer quantities) {
		this.quantities = quantities;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
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
