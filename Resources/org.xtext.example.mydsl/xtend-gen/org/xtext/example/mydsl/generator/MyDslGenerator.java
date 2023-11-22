/**
 * Github version v2: https://github.com/Gricel-lee/Kanoa/blob/main/Resources/src/1%20DSL%20Generation/code/org.xtext.example.mydsl/bin/org/xtext/example/mydsl/generator/MyDslGenerator.xtend
 * Author: Gricel Vazquez
 * 2023
 */
package org.xtext.example.mydsl.generator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class MyDslGenerator extends AbstractGenerator {
  private Preallocation kanoa;

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    final String path = "/Users/grisv/GitHub/KanoaV2/Resources/org.xtext.example.mydsl/src/org/xtext/example/mydsl/generator//";
    Errors.checkDSL(resource);
    InputOutput.<String>println("\n=== Reading Kanoa problem specifications. ===");
    Preallocation _preallocation = new Preallocation(resource, fsa, "modelMissionsTree.txt");
    this.kanoa = _preallocation;
    AlloyFile.createAlloyFile(this.kanoa, resource, path);
    TreeFile.createTreeFile(this.kanoa, resource, path);
    LocFile.createLocFile(this.kanoa, resource, path);
    InfoDSLFile.createFile(this.kanoa, resource, path);
    InputOutput.<String>println("\n=== Done. ===");
  }
}
