package warehouse.model.visitor;

import warehouse.model.Assembly;
import warehouse.model.Part;


public class CheckDuplicateVisitor extends Visitor {
	//set a local private viable to hold the particulate passed part from the constructor so it can be used in
	//the other methods
	private Part checkpart;
	//create a boolean variable to be defaulted to false
	private boolean duplicate= false;

	public CheckDuplicateVisitor (Part query){
		//assign the parameter to the local variable
		checkpart = query;
	}
	
	
	public void visit (Assembly assembly){

		// no implementation required
	}

	public void visit (Part part){
		// this method will be called on all the hierarchy of parts so only need to check the passed value
		
		if (part == checkpart){
			duplicate = true;
		}
		
		
	}
	
	public boolean duplicateFound(){
		//return the variable that found in visit method weather a part exists already or not
		return duplicate;
	}
}


