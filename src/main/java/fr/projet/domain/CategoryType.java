package fr.projet.domain;

public enum CategoryType {
	QUOTIDIEN("QUOTIDIEN"),
	PROFESSIONNEL("PROFESSIONEL"),
	HOBBY("HOBBY");
	
	String categoryType;
	
	CategoryType(String category) {
		this.categoryType = category;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
}
