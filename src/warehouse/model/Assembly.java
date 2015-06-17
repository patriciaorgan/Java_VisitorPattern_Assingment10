package warehouse.model;

import java.util.ArrayList;
import java.util.List;

import warehouse.model.visitor.Visitor;



public class Assembly extends Component {
	private List<Component> components = 
		new ArrayList<Component>() ;
	private String name;
	
	public Assembly (String nme){
		this.name=nme;
	}

	public void addComponent(Component c) {
		components.add(c);
	}
	
	public void accept(Visitor visitor){
		// asks the visitor to perform 
		// its operation
		visitor.visit(this); 
		// then sends the visitor to 
		// all its sub components
		for(Component comp : components){
			comp.accept(visitor);
		}
	}
	
	
	public String getName(){
		return name;
	}
	
	
	
}

