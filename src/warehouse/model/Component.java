package warehouse.model;

import warehouse.model.visitor.Element;
import warehouse.model.visitor.Visitor;

public abstract class Component implements Element{

	public void accept(Visitor visitor){}
}

