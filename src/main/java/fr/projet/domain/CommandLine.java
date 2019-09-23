package fr.projet.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "commandline_")
@IdClass(CommandLineId.class)
public class CommandLine implements Serializable {

	private static final long serialVersionUID = -3326848200375558388L;

	private Integer quantities;

	@ManyToOne
	private Product product;

//	@JsonIgnore
	@ManyToOne
	private Order order;

//	@ManyToOne
//	private Basket basket;

	@Id
	@NotNull
	@Size(max=20)
	@Column(name = "order_id", insertable = false, updatable = false)
	private Long productId;

	@Id
	@NotNull
	@Size(max=20)
	@Column(name = "product_id", insertable = false, updatable = false)
	private Long orderId;
	
	public CommandLine() {
		
	}

	public CommandLine(Long productId, Long orderId, Integer quantities) {
		this.productId = productId;
		this.orderId = orderId;
		this.quantities = quantities;
	}

	public Integer getQuantities() {
		return quantities;
	}

	public void setQuantities(Integer quantities) {
		this.quantities = quantities;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}
