package org.xtext.example.mydsl.generator

import org.eclipse.emf.ecore.resource.Resource
import dsl.Paths
import java.util.ArrayList

class Errors {
	
	def static checkDSL(Resource resource){
		checkNoPathsRepeated(resource)
	}
	
	
	// Check that no paths from A to B are repeated
	def static checkNoPathsRepeated(Resource resource) {
		var ArrayList<String> pathsNames = new ArrayList<String>
		val paths = resource.allContents.filter(Paths).toList();
		for (p : paths){
			var s = p.loc1.name + "," + p.loc2.name
			if (pathsNames.contains(s)){throw new UnsupportedOperationException("ERROR: Check your paths. Path repeated: " + s)}
			else{pathsNames.add(s)}
		}		
	}
	
	
	
}