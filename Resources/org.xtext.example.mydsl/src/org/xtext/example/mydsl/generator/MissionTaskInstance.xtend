package org.xtext.example.mydsl.generator


import java.util.ArrayList
import dsl.MissionTask

/** Mission Task instance. Its identifier is the "type of compound task + _ + counter". */
class MissionTaskInstance{
	
	public MissionTask mt;
	public String child;
	ArrayList<String> atReachable = new ArrayList<String>(); //*only available after all tasks are instantiated (STAGE 1) and this.getatomicInstancesReachable is called
	
	def set(MissionTask mt, String child){
		this.mt = mt;
		this.child = child;
	}
	
	/*Get id */
	def getId(){
		return (this.mt.name)
	}
	
	def print(){
		println("\n=== Mission task:" + this.getId() + " ===")
		println("child:" + this.child)
		if (!this.atReachable.isEmpty()){
			println("atomic subtasks:" + this.atReachable)
		}
	}
	
	/*Get atomic subtasks */
	def getatomicInstancesReachable(GlobalVar gv){
		if (this.atReachable.isEmpty()){this.atReachable.addAll(this.getatomicInst(gv))}
		if (this.atReachable.isEmpty()){throw new UnsupportedOperationException("ERROR: getatomicInstancesReachable on mission task:" + this.getId() + " returned empty.")}
		return this.atReachable
	}
	
	
	/*Compute reachable instances of atomic tasks. Complete STEP 1 before to ensure all children instances are added.*/
	private def ArrayList<String> getatomicInst(GlobalVar gv){
		//it make use of the ordered vector "gv.tasksList"
		//e.g. of this vector: [m1, at1_1, m2, at1_2, m3, ct2_1, at4_3, ct1_2, at3_4, at2_5, ct0_4, at3_6, ct0_3, at3_7, m4, ct2_5, at4_8, ct1_6, at3_9, at2_10, ct0_8, at3_11, ct0_7, at3_12, m5, ct2_9, at4_13, ct1_10, at3_14, at2_15, ct0_12, at3_16, ct0_11, at3_17, m6, ct2_13, at4_18, ct1_14, at3_19, at2_20, ct0_16, at3_21, ct0_15, at3_22, m11, ct6_17, at6_23]
		//when it finds the ID of the mission, it retrieves all atomic tasks IDs until the next mission ID is found (or the end of the array)
		var atId_reachable = new ArrayList<String>()
		for (i : 0 ..< gv.tasksList.size()) {
			//when mission ID found
			if (gv.tasksList.get(i)==this.getId()){
				//check next IDs
				for (j : (i+1)..< gv.tasksList.size){
					
					var id = gv.tasksList.get(j)					
					//if atomic task - (add)
					if ( gv.atomicList.containsKey(id) ){atId_reachable.add(id)}
					//if compound task - (ignore)
					else if ( gv.compoundList.containsKey(id) ){ }
					//if mission task - (finished checking children of current mission)
					else if ( gv.missionList.containsKey(id) ){return atId_reachable}
					//error
					else{throw new UnsupportedOperationException("Error in retrieven atomic tasks of mission: " + this.getId())}
				}return  atId_reachable//end of tasks reach
			}}}
}
