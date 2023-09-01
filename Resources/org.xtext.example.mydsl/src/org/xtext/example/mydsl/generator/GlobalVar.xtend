/*
 * Global variables used among the project.
 * Author: Gricel Vazquez
 */

package org.xtext.example.mydsl.generator /** Create global variables */

import dsl.Location
import java.util.ArrayList
import java.util.HashMap
import java.util.Hashtable
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2

class GlobalVar {
	/**fsa */
	public IFileSystemAccess2 fsa;
	/**fsa */
	public Resource resource;
	   
   /** Counter for instances of atomic tasks*/
   public int counterAT = 0
   /** Counter for instances of compound tasks*/
   public int counterCT = 0
   /** List of instantiated tasks*/
   public var HashMap<String, MissionTaskInstance> missionList = new HashMap<String, MissionTaskInstance>();
   public var HashMap<String, AtomicTaskinstance>atomicList = new   HashMap<String, AtomicTaskinstance>();
   public var HashMap<String, CompoundTaskInstance>compoundList = new   HashMap<String, CompoundTaskInstance>();
   /** All instantiated tasks list (in order) */
   public var List<String> tasksList = new ArrayList();
   
      
   
   
   /** List atomic tasks locations*/
   public Hashtable<String, Location> atLoc = new Hashtable();
   
   /** Header for the Task Tree file*/
   //public String dbTaskTree = "id,,parent,,ordered_children,,location,,numrobots,,joint,,ordered,,consecutive,,start,,end"; 
   
   
}
