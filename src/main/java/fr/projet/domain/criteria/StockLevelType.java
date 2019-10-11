package fr.projet.domain.criteria;

public enum StockLevelType {
	NONE(0, 0),
	LOW(1, 9),
	IN_STOCK(10, null);
	
	private Integer min;
	private Integer max;
	
	StockLevelType(Integer min, Integer max) {
		this.min = min;
		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}	
	
}
