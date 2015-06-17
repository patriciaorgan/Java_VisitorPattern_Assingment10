package warehouse.model.visitor;

import warehouse.model.Assembly;
import warehouse.model.Part;

public class CostVisitor extends Visitor {

	private int total ;

	public void visit(Part part) {
		total += part.getCost() ;
	}
	public void visit(Assembly a) {
		// no implementation 
		//necessary in this case
	}
	public int getTotal(){
		return total;
	}
}

