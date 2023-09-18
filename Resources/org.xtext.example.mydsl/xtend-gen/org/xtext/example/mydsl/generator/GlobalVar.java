/**
 * Global variables used among the project.
 * Author: Gricel Vazquez
 */
package org.xtext.example.mydsl.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;

@SuppressWarnings("all")
public class GlobalVar {
  /**
   * fsa
   */
  public IFileSystemAccess2 fsa;

  /**
   * fsa
   */
  public Resource resource;

  /**
   * Counter for instances of atomic tasks
   */
  public int counterAT = 0;

  /**
   * Counter for instances of compound tasks
   */
  public int counterCT = 0;

  /**
   * List of instantiated tasks
   */
  public HashMap<String, MissionTaskInstance> missionList = new HashMap<String, MissionTaskInstance>();

  public HashMap<String, AtomicTaskinstance> atomicList = new HashMap<String, AtomicTaskinstance>();

  public HashMap<String, CompoundTaskInstance> compoundList = new HashMap<String, CompoundTaskInstance>();

  /**
   * All instantiated tasks list (in order)
   */
  public List<String> tasksList = new ArrayList<String>();
}
