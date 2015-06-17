package warehouse.model.visitor;

import warehouse.model.Assembly;
import warehouse.model.Part;

public abstract class Visitor {

	public abstract void visit(Part part);

	public abstract void visit(Assembly assmbl);

}

