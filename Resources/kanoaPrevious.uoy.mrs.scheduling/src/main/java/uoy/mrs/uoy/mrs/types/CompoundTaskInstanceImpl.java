package uoy.mrs.uoy.mrs.types;

public class CompoundTaskInstanceImpl implements CompoundTaskInstance{
	
	private String id;
	private String parent;
	private String ordered_children;
	private String ordered;
	private String consecutive;
	private String inst;
	


	public CompoundTaskInstanceImpl(String id, String parent, String ordered_children, String ordered,
			String consecutive, String inst) {
		//id,,parent,,ordered_children,,location,,numrobots,,joint,,ordered,,consecutive,,start,,end
		// e.g. ct,,ct1_2,,ct2_1,,['at3_4,at2_5'],,NaN,,NaN,,NaN,,false,,false,,NaN,,NaN
		this.id = id;
		this.parent = parent;
		this.ordered_children = ordered_children;
		this.ordered = ordered;
		this.consecutive = consecutive;
		this.inst = inst;
	}


	@Override
	public void print() {
		System.out.println("- Compound task "+id);
		System.out.println("parent: "+ parent);
		System.out.println("children: " + getorderedChildren());
		System.out.println("ordered: "+ordered);
		System.out.println("consecutive: "+consecutive);
		return;
	}

	@Override
	public String getID() {
		return id;
	}



	@Override
	public String getparent() {
		return parent;
	}



	@Override
	public String getorderedChildren() {
		return ordered_children;
	}



	@Override
	public String getordered() {
		return ordered;
	}



	@Override
	public String getconseutive() {
		return consecutive;
	}
	

	@Override
	public String getInst() {
		return inst;
	}
}
