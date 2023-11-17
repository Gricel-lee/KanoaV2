package org.xtext.example.mydsl.generator;

import com.google.common.base.Objects;
import dsl.MissionTask;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.InputOutput;

/**
 * Mission Task instance. Its identifier is the "type of compound task + _ + counter".
 */
@SuppressWarnings("all")
public class MissionTaskInstance {
  public MissionTask mt;

  public String child;

  private ArrayList<String> atReachable = new ArrayList<String>();

  public String set(final MissionTask mt, final String child) {
    String _xblockexpression = null;
    {
      this.mt = mt;
      _xblockexpression = this.child = child;
    }
    return _xblockexpression;
  }

  /**
   * Get id
   */
  public String getId() {
    return this.mt.getName();
  }

  public String print() {
    String _xblockexpression = null;
    {
      String _id = this.getId();
      String _plus = ("\n=== Mission task:" + _id);
      String _plus_1 = (_plus + " ===");
      InputOutput.<String>println(_plus_1);
      InputOutput.<String>println(("child:" + this.child));
      String _xifexpression = null;
      boolean _isEmpty = this.atReachable.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _xifexpression = InputOutput.<String>println(("atomic subtasks:" + this.atReachable));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * Get atomic subtasks
   */
  public ArrayList<String> getatomicInstancesReachable(final GlobalVar gv) {
    boolean _isEmpty = this.atReachable.isEmpty();
    if (_isEmpty) {
      this.atReachable.addAll(this.getatomicInst(gv));
    }
    boolean _isEmpty_1 = this.atReachable.isEmpty();
    if (_isEmpty_1) {
      String _id = this.getId();
      String _plus = ("ERROR: getatomicInstancesReachable on mission task:" + _id);
      String _plus_1 = (_plus + " returned empty.");
      throw new UnsupportedOperationException(_plus_1);
    }
    return this.atReachable;
  }

  /**
   * Compute reachable instances of atomic tasks. Complete STEP 1 before to ensure all children instances are added.
   */
  private ArrayList<String> getatomicInst(final GlobalVar gv) {
    ArrayList<String> atId_reachable = new ArrayList<String>();
    int _size = gv.tasksList.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      String _get = gv.tasksList.get((i).intValue());
      String _id = this.getId();
      boolean _equals = Objects.equal(_get, _id);
      if (_equals) {
        int _size_1 = gv.tasksList.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(((i).intValue() + 1), _size_1, true);
        for (final Integer j : _doubleDotLessThan_1) {
          {
            String id = gv.tasksList.get((j).intValue());
            boolean _containsKey = gv.atomicList.containsKey(id);
            if (_containsKey) {
              atId_reachable.add(id);
            } else {
              boolean _containsKey_1 = gv.compoundList.containsKey(id);
              if (_containsKey_1) {
              } else {
                boolean _containsKey_2 = gv.missionList.containsKey(id);
                if (_containsKey_2) {
                  return atId_reachable;
                } else {
                  String _id_1 = this.getId();
                  String _plus = ("Error in retrieven atomic tasks of mission: " + _id_1);
                  throw new UnsupportedOperationException(_plus);
                }
              }
            }
          }
        }
        return atId_reachable;
      }
    }
    return null;
  }
}
