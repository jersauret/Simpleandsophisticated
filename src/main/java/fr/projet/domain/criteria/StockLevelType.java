package fr.projet.domain.criteria;

public enum StockLevelType {
	NONE(0, 0),
	LOW(1, 9),
	IN_STOCK(10, Integer.MAX_VALUE);
	
	private int min;
	private int max;
	
	StockLevelType(Integer min, Integer max) {
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}	
	
}
