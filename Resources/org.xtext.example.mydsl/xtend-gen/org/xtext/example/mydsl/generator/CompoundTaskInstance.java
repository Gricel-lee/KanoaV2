package org.xtext.example.mydsl.generator;

import dsl.CompoundTask;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;

/**
 * Compound Task instance
 */
@SuppressWarnings("all")
public class CompoundTaskInstance {
  public CompoundTask ct;

  public Integer count;

  public String parent;

  public List<String> children;

  public String ordered;

  public String consecutive;

  private ArrayList<String> atReachable = new ArrayList<String>();

  public String set(final CompoundTask ct, final Integer count, final String parent, final List<String> children) {
    String _xblockexpression = null;
    {
      this.ct = ct;
      this.count = count;
      this.parent = parent;
      this.children = children;
      this.ordered = String.valueOf(ct.isOrdered());
      _xblockexpression = this.consecutive = String.valueOf(ct.isConsecutive());
    }
    return _xblockexpression;
  }

  /**
   * Get instance id
   */
  public String getId() {
    String _name = this.ct.getName();
    String _plus = (_name + "_");
    return (_plus + this.count);
  }

  public String print() {
    String _xblockexpression = null;
    {
      String _id = this.getId();
      String _plus = ("=== compound task:" + _id);
      String _plus_1 = (_plus + " ===");
      InputOutput.<String>println(_plus_1);
      InputOutput.<String>println(("parent:" + this.parent));
      InputOutput.<String>println(("children:" + this.children));
      String _xifexpression = null;
      boolean _isEmpty = this.atReachable.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _xifexpression = InputOutput.<String>println(("atomic tasks reachable:" + this.atReachable));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * Get atomic reachable subtasks
   */
  public ArrayList<String> getatSubtasks(final GlobalVar gv) {
    boolean _isEmpty = this.atReachable.isEmpty();
    if (_isEmpty) {
      this.getatomicInstancesReachable(gv);
    }
    return this.atReachable;
  }

  /**
   * Get reachable instances of atomic tasks
   */
  public ArrayList<String> getatomicInstancesReachable(final GlobalVar gv) {
    boolean _isEmpty = this.atReachable.isEmpty();
    if (_isEmpty) {
      this.atReachable.addAll(this.getatomicInstancesReachable(gv, this.getId()));
    }
    boolean _isEmpty_1 = this.atReachable.isEmpty();
    if (_isEmpty_1) {
      String _id = this.getId();
      String _plus = ("ERROR: getatomicInstancesReachable on compound task:" + _id);
      String _plus_1 = (_plus + " returned empty.");
      throw new UnsupportedOperationException(_plus_1);
    }
    return this.atReachable;
  }

  /**
   * Compute reachable instances of atomic tasks. Complete STEP 1 before to ensure all children instances are added.
   */
  private ArrayList<String> getatomicInstancesReachable(final GlobalVar gv, final String ctIdInstance) {
    ArrayList<String> atId_reachable = new ArrayList<String>();
    for (final String id : gv.compoundList.get(ctIdInstance).children) {
      boolean _containsKey = gv.atomicList.containsKey(id);
      if (_containsKey) {
        atId_reachable.add(id);
      } else {
        boolean _containsKey_1 = gv.compoundList.containsKey(id);
        if (_containsKey_1) {
          atId_reachable.addAll(this.getatomicInstancesReachable(gv, id));
        }
      }
    }
    return atId_reachable;
  }
}
