package fr.projet.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="product_")
public class Product implements IoEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5217758503937831079L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String supplier;
	private Integer retailPrice;
	private Integer stock;
	@Enumerated(EnumType.STRING)
	private ProductType productType;
	@Enumerated(EnumType.STRING)
	private CategoryType category;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private List<CommandLine> commandLine;
	
	public Product() {
		
	}

	public Product(Long id, String name, String supplier, Integer retailPrice, Integer stock, ProductType productType,
			CategoryType category) {
		super();
		this.id = id;
		this.name = name;
		this.supplier = supplier;
		this.retailPrice = retailPrice;
		this.stock = stock;
		this.productType = productType;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Integer getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Integer retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public ProductType getItemType() {
		return productType;
	}

	public void setItemType(ProductType productType) {
		this.productType = productType;
	}

	public CategoryType getCategory() {
		return category;
	}

	public void setCategory(CategoryType category) {
		this.category = category;
	}
	
	
	
}
