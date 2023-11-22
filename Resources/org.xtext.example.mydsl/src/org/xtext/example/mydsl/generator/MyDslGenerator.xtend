/* Github version v2: https://github.com/Gricel-lee/Kanoa/blob/main/Resources/src/1%20DSL%20Generation/code/org.xtext.example.mydsl/bin/org/xtext/example/mydsl/generator/MyDslGenerator.xtend
 * Author: Gricel Vazquez
 * 2023
 */
package org.xtext.example.mydsl.generator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

class MyDslGenerator extends AbstractGenerator {
	var Preallocation kanoa; //tasks tree	
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val path = "/Users/grisv/GitHub/KanoaV2/Resources/org.xtext.example.mydsl/src/org/xtext/example/mydsl/generator//"
		
		// -check DSL
		Errors.checkDSL(resource)
		
		println("\n=== Reading Kanoa problem specifications. ===");
		// -Preallocation stage
		kanoa = new Preallocation(resource, fsa, 'modelMissionsTree.txt')
		
		// -Create alloy .als file
		AlloyFile.createAlloyFile(kanoa, resource, path);
		
		// -Create tasks tree
		TreeFile.createTreeFile(kanoa, resource, path)
		
		// -Locations-paths file
		LocFile.createLocFile(kanoa,resource,path)
		
		// -Other DSL info file
		InfoDSLFile.createFile(kanoa,resource,path)
		
		println("\n=== Done. ===");
	}
	
	
	
}
