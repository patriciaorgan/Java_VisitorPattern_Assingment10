package warehouse.model.visitor;

import warehouse.model.Assembly;
import warehouse.model.Part;



public class NumPartsVisitor extends Visitor {
	//create a variable to hold the total number of parts
	private int totalParts = 0;

	
	public void visit (Assembly assembly){
		// no implementation required
	}

	public void visit (Part part){
		//increase the total for each part found by 1
		totalParts++;
	}
	
	public int getNumParts(){
		//return the local variable that has the grand total populated by visit method
		return totalParts;
	}
}
