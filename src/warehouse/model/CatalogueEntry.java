package warehouse.model;

public class CatalogueEntry {
	
	private String name;
	private long number;
	private int cost; // use integer to avoid double rounding errors
	

	public CatalogueEntry(String nm, long num, int cst) {
		name = nm;
		number = num;
		cost=cst;
	}
	
	public int getCost(){
	return cost;
	}
	
	public long getCatNumber(){
		return number;
	}
	
	public String getCatName(){
		return name;
	}

}
