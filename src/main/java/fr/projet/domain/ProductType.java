package fr.projet.domain;

public enum ProductType {
	ECOUTEURS("ECOUTEURS"),
	SMARTPHONE("SMARTPHONE"),
	SMARTWATCH("SMARTWATCH"),
	PCPORTABLE("PCPORTABLE"),
	CASQUEVR("CASQUEVR"),
	SPORTCONNECTE("SPORTCONNECTE"),
	SIMULATEURS("SIMULATEURS"),
	READER("READER");
	
	String productType;
	
	private ProductType(String productType) {
		this.productType = productType;
	}
	
	
}
