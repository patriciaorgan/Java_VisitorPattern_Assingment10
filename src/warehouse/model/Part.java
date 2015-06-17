package warehouse.model;

import warehouse.model.visitor.Visitor;


public class Part extends Component  {
	private CatalogueEntry entry;
	
	public Part(CatalogueEntry e) {
		entry = e;
	}
	
	@Override
	public void accept(Visitor visitor){
		visitor.visit(this);
	}

	public int getCost() {
		return entry.getCost();
	}
	public String getCatName(){
		return entry.getCatName();
	}
	public long getCatNumber(){
		return entry.getCatNumber();
	}
	
}
