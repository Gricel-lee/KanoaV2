package org.xtext.example.mydsl.generator

import org.eclipse.emf.ecore.resource.Resource
import dsl.Paths
import dsl.Robot

class LocFile {
	def static createLocFile(Preallocation tree, Resource resource, String path) {
		var gv = tree.gv
		var String s="";
		
		val paths = gv.resource.allContents.filter(Paths).toList();
		for (Paths p : paths){
				s += p.loc1.name + "," + p.loc2.name + "," + String.valueOf(p.distance) "," + String.valueOf(p.success) + "\n"
		}
		
		val robs = gv.resource.allContents.filter(Robot).toList();
		for (Robot r : robs){
			s += r.name + "," + r.getInitLoc().name + "\n"
		}
		s=s.substring(0, s.length()-1);
		
		Aux.generateFile('worldmodel.txt', s, tree.gv) // -- generate file
	}
}