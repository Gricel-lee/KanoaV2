package uoy.mrs.uoy.mrs.types;

public interface CompoundTaskInstance {
	
	String getID();
	
	String getparent();
	
	String getorderedChildren();
	
	String getordered();
	
	String getconseutive();

	void print();

	String getInst();
}
