package uoy.mrs.uoy.mrs;

import java.util.ArrayList;

public class Compound {
	
	public String id;
	public ArrayList<String> subtasksIDList;
	public Boolean consecutive;
	public Boolean ordered;
	
	
	public Compound(String id, ArrayList<String> subt, Boolean consec, Boolean order) {
		this.id=id;
		this.subtasksIDList = subt;
		this.consecutive = consec;
		this.ordered = order;
	}
	
}
