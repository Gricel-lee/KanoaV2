package uoy.mrs.uoy.mrs.types;

public class SolutionData {
	
	public double probSucc;
	public double idle;
	public double travel;
	public double feasibility;
	public Allocation allocation;
	public String permutation;
	
	/**constructor*/
	public SolutionData(double prob,double Idle,double Travel,double Feasibility,
			Allocation alloc,	String Permutation) {
		probSucc = prob;
		idle = Idle;
		travel = Travel;
		feasibility=Feasibility;
		allocation = alloc;
		permutation=Permutation;
		
	}
}
