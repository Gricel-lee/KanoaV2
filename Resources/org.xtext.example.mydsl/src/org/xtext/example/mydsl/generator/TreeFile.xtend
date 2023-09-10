package org.xtext.example.mydsl.generator

import org.eclipse.emf.ecore.resource.Resource

class TreeFile {
	
	def static createTreeFile(Preallocation tree, Resource resource, String path) {
		var gv = tree.gv
		var String s="";
		var type ="";
		var id=""; var parent=""; var ordered_children="";
		var location=""; var numrobots="";
		var joint="" var ordered=""; var consecutive="";
		var start = ""; var end=""
		
		s += "id,,parent,,ordered_children,,location,,numrobots,,joint,,ordered,,consecutive,,start,,end";
		
		for (tID: gv.tasksList){
			//mission task
			if(gv.missionList.keySet().contains(tID)){
				type="mt"
				id=tID;
				parent="NaN"
				ordered_children= "[\'" + gv.missionList.get(tID).child + "\']"
				location = "NaN"
				numrobots = "NaN"
				joint = "NaN"
				ordered = "NaN"
				consecutive = "NaN"
				start = "NaN"
				end = "NaN"
				
				s+="\n"+type+",,"+id+",,"+parent+",,"+ordered_children+",,"+location+",,"
				+numrobots+",,"+joint+",,"+ordered+",,"+consecutive+",,"+start+",,"+end
			}
			//compound task
			else if(gv.compoundList.keySet().contains(tID)){
				type="ct"
				id=tID;
				parent= gv.compoundList.get(tID).parent
				ordered_children= "[\'" + String.join(",", gv.compoundList.get(tID).children) + "\']"
				location = "NaN"
				numrobots = "NaN"
				joint = "NaN"
				ordered = gv.compoundList.get(tID).ordered
				consecutive = gv.compoundList.get(tID).ordered
				start = "NaN"
				end = "NaN"
				
				s+="\n"+type+",,"+id+",,"+parent+",,"+ordered_children+",,"+location+",,"
				+numrobots+",,"+joint+",,"+ordered+",,"+consecutive+",,"+start+",,"+end
			}
			//atomic task
			else if(gv.atomicList.keySet().contains(tID)){
				type="at"
				id=tID;
				parent= gv.atomicList.get(tID).parent
				ordered_children= "NaN"
				location = gv.atomicList.get(tID).loc.name
				numrobots = String.valueOf(gv.atomicList.get(tID).at.robots)
				if(gv.atomicList.get(tID).at.robots>1){joint = "True"}else{joint = "False"}
				ordered = "NaN"
				consecutive = "NaN"
				
				if(gv.atomicList.get(tID).start!==null){start = String.valueOf(gv.atomicList.get(tID).start)}
				else{start = "None"}
				if(gv.atomicList.get(tID).end!==null){end = String.valueOf(gv.atomicList.get(tID).end)}
				else{end = "None"}
				s+="\n"+type+",,"+id+",,"+parent+",,"+ordered_children+",,"+location+",,"
				+numrobots+",,"+joint+",,"+ordered+",,"+consecutive+",,"+start+",,"+end
			}
		}
		
		Aux.generateFile('modelMissionsTree.txt', s, tree.gv) // -- generate file
		
		
		
	}
	
	
}