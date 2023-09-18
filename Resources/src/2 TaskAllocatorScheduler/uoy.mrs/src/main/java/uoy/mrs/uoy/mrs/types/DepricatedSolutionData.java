package uoy.mrs.uoy.mrs.types;

public class DepricatedSolutionData {
	
	public double probSucc;
	public double idle;
	public double travel;
	public double feasibility;
	public DepricatedAllocation allocation;
	public String permutation;
	
	/**constructor*/
	public DepricatedSolutionData(double prob,double Idle,double Travel,double Feasibility,
			DepricatedAllocation alloc,	String Permutation) {
		probSucc = prob;
		idle = Idle;
		travel = Travel;
		feasibility=Feasibility;
		allocation = alloc;
		permutation=Permutation;
		
	}
}
