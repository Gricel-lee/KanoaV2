package uoy.mrs.uoy.mrs.types.impl;

public class Path {
	
	public String loc1;
	public String loc2;
	public String dist;
	public double probSucc;
	
	
	//constructor
	public Path(String loc1, String loc2, String dist, double probSucc) {
		this.loc1 = loc1;
		this.loc2 = loc2;
		this.dist = dist;
		this.probSucc = probSucc;
	}
	
	public void print() {
		System.out.println("path from: "+loc1+" to: "+loc2+" distance: "+dist+" prob: "+probSucc);
	}
	
	
	
}
