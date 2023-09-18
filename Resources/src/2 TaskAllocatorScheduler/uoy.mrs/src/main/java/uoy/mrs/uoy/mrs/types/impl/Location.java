package uoy.mrs.uoy.mrs.types.impl;

public class Location {
	
	private String id;
	private String x;
	private String y;
	
	public Location(String id, String x, String y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}

	
	public String getID() {
		return id;
	}

	
	public String getx() {
		return x;
	}

	
	public String gety() {
		return y;
	}

}
