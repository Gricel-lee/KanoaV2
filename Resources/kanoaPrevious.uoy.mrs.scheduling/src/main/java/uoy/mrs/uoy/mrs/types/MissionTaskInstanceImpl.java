package uoy.mrs.uoy.mrs.types;

public class MissionTaskInstanceImpl implements MissionTaskInstance{
	
	private String id;
	private String ordered_children;
	
	//constructor
	public MissionTaskInstanceImpl(String id, String ordered_children) {
		this.id = id;
		this.ordered_children = ordered_children;
	}

	
	@Override
	public void print() {
		System.out.println("- Mission task "+id);
		System.out.println("child: " + ordered_children);
		return;
	}
	
	public static void main( String[] args )  throws Exception{
		System.out.println("Creating mission task");
		

	}


	@Override
	public String getOrdered_children() {
		return ordered_children;
	}


	@Override
	public String getID() {
		return id;
	}	

}
