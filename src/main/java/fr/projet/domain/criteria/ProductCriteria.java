package fr.projet.domain.criteria;

import org.springframework.util.StringUtils;

import fr.projet.domain.CategoryType;
import fr.projet.domain.ProductType;

public class ProductCriteria {
	private Long id;
	private String name;
	private String supplier;
	private Integer retailPriceMin;
	private Integer retailPriceMax;
	private StockLevelType stockLevel;
	private ProductType productType;
	private CategoryType categoryType;
	private String reference;

	public ProductCriteria(Long id, String name, String supplier, Integer retailPriceMin, Integer retailPriceMax,
			StockLevelType stockLevel, ProductType product, CategoryType category, String reference) {
		this.id = id;
		this.name = name;
		this.supplier = supplier;
		this.retailPriceMin = retailPriceMin;
		this.retailPriceMax = retailPriceMax;
		this.stockLevel = stockLevel;
		this.productType = product;
		this.categoryType = category;
		this.reference = reference;
	}
	
	public boolean hasCriterias() {
		return id != null || !StringUtils.isEmpty(name) || !StringUtils.isEmpty(supplier) || retailPriceMin != null || retailPriceMax != null 
				|| stockLevel != null || productType != null || categoryType != null || !StringUtils.isEmpty(reference);
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

	public Integer getRetailPriceMin() {
		return retailPriceMin;
	}

	public void setRetailPriceMin(Integer retailPriceMin) {
		this.retailPriceMin = retailPriceMin;
	}

	public Integer getRetailPriceMax() {
		return retailPriceMax;
	}

	public void setRetailPriceMax(Integer retailPriceMax) {
		this.retailPriceMax = retailPriceMax;
	}

	public StockLevelType getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(StockLevelType stockLevel) {
		this.stockLevel = stockLevel;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public CategoryType getCategory() {
		return categoryType;
	}

	public void setCategory(CategoryType category) {
		this.categoryType = category;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

}
