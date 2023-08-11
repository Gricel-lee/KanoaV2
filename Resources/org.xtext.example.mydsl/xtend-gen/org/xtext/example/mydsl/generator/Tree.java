package org.xtext.example.mydsl.generator;

import com.google.common.collect.Iterators;
import dsl.AtomicTask;
import dsl.CompoundTask;
import dsl.Location;
import dsl.MissionTask;
import dsl.TasksModel;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Tasks tree - extract information from DSL
 */
@SuppressWarnings("all")
public class Tree {
  /**
   * Create Global variables
   */
  public final GlobalVar gv = new GlobalVar();

  /**
   * Create tree
   */
  public void createTree(final Resource resource, final IFileSystemAccess2 fsa) {
    this.gv.fsa = fsa;
    this.gv.checkEndStartTimes(resource);
    final Iterator<MissionTask> mtList = Iterators.<MissionTask>filter(resource.getAllContents(), MissionTask.class);
    while (mtList.hasNext()) {
      {
        final MissionTask m = mtList.next();
        String _name = m.getName();
        String _plus = ("\nGetting mission:" + _name);
        InputOutput.<String>println(_plus);
        boolean _matched = false;
        if (m instanceof MissionTask) {
          _matched=true;
          Location mlocation = null;
          Location _loc = m.getLoc();
          boolean _tripleNotEquals = (_loc != null);
          if (_tripleNotEquals) {
            mlocation = m.getLoc();
          }
          String mstart = "null";
          String mend = "null";
          boolean _containsKey = this.gv.startTime.containsKey(m.getName());
          if (_containsKey) {
            mstart = this.gv.startTime.get(m.getName()).toString();
          }
          boolean _containsKey_1 = this.gv.endTime.containsKey(m.getName());
          if (_containsKey_1) {
            mend = this.gv.endTime.get(m.getName()).toString();
          }
          CompoundTask _ct = m.getCt();
          boolean _tripleNotEquals_1 = (_ct != null);
          if (_tripleNotEquals_1) {
            int _countCTpython = this.gv.countCTpython;
            this.gv.countCTpython = (_countCTpython + 1);
            String _name_1 = m.getCt().getName();
            String _plus_1 = (" [\'" + _name_1);
            String _plus_2 = (_plus_1 + "_");
            String _plus_3 = (_plus_2 + Integer.valueOf(this.gv.countCTpython));
            String childStr = (_plus_3 + "\']");
            String _dbTaskTree = this.gv.dbTaskTree;
            String _missionTreeString = Tree.missionTreeString(m.getName(), "NaN", childStr, "NaN", "NaN", "NaN", "NaN", "NaN", "null", "null");
            this.gv.dbTaskTree = (_dbTaskTree + _missionTreeString);
            this.recursiveAddSubTasks(m.getName(), m.getCt(), this.gv.countCTpython, mlocation, mstart, mend, m);
          } else {
            AtomicTask _at = m.getAt();
            boolean _tripleNotEquals_2 = (_at != null);
            if (_tripleNotEquals_2) {
              int _countATpython = this.gv.countATpython;
              this.gv.countATpython = (_countATpython + 1);
              int n = this.gv.countATpython;
              String _name_2 = m.getAt().getName();
              String _plus_4 = (" [\'" + _name_2);
              String _plus_5 = (_plus_4 + "_");
              String _plus_6 = (_plus_5 + Integer.valueOf(n));
              String childStr_1 = (_plus_6 + "\']");
              String _dbTaskTree_1 = this.gv.dbTaskTree;
              String _missionTreeString_1 = Tree.missionTreeString(m.getName(), "NaN", childStr_1, "NaN", "NaN", "NaN", "NaN", "NaN", "null", "null");
              this.gv.dbTaskTree = (_dbTaskTree_1 + _missionTreeString_1);
              Tree.addAtomicTask(this.gv, m.getAt(), n, m.getName(), mlocation, mstart, mend, m);
            } else {
              throw new UnsupportedOperationException("ERROR - no compound or atomic task found in mission task");
            }
          }
        }
      }
    }
  }

  /**
   * Recursive save subtasks - (parent id, task, task count instance, mission location, parent start and end time constraints)
   */
  public void recursiveAddSubTasks(final String parentId, final CompoundTask task, final int i, final Location missionLoc, final String startParent, final String endParent, final MissionTask topMission) {
    List<String> subtasks_id = new ArrayList<String>();
    List<Integer> subtaskcounter = new ArrayList<Integer>();
    EList<TasksModel> _canDoTask = task.getCanDoTask();
    for (final TasksModel t : _canDoTask) {
      boolean _matched = false;
      if (t instanceof AtomicTask) {
        _matched=true;
        int _countATpython = this.gv.countATpython;
        this.gv.countATpython = (_countATpython + 1);
        String _name = ((AtomicTask)t).getName();
        String _plus = (_name + "_");
        String _plus_1 = (_plus + Integer.valueOf(this.gv.countATpython));
        subtasks_id.add(_plus_1);
        subtaskcounter.add(Integer.valueOf(this.gv.countATpython));
      }
      if (!_matched) {
        if (t instanceof CompoundTask) {
          _matched=true;
          int _countCTpython = this.gv.countCTpython;
          this.gv.countCTpython = (_countCTpython + 1);
          String _name = ((CompoundTask)t).getName();
          String _plus = (_name + "_");
          String _plus_1 = (_plus + Integer.valueOf(this.gv.countCTpython));
          subtasks_id.add(_plus_1);
          subtaskcounter.add(Integer.valueOf(this.gv.countCTpython));
        }
      }
    }
    String _name = task.getName();
    String _plus = (_name + "_");
    String ctName = (_plus + Integer.valueOf(i));
    String _dbTaskTree = this.gv.dbTaskTree;
    String _join = IterableExtensions.join(subtasks_id, "\',\'");
    String _plus_1 = ("[\'" + _join);
    String _plus_2 = (_plus_1 + "\']");
    String _missionTreeString = Tree.missionTreeString(ctName, parentId, _plus_2, "NaN", "NaN", "NaN", Boolean.valueOf(task.isOrdered()).toString(), Boolean.valueOf(task.isConsecutive()).toString(), "null", "null");
    this.gv.dbTaskTree = (_dbTaskTree + _missionTreeString);
    CompoundTaskInstance ctInstance = new CompoundTaskInstance();
    ctInstance.ct = task;
    ctInstance.inum = Integer.valueOf(i);
    ctInstance.subtasksInstances = subtasks_id;
    ctInstance.parentId = parentId;
    this.gv.compoundTaskInstances.put(ctName, ctInstance);
    String startCT = "null";
    String endCT = "null";
    if ((startParent != "null")) {
      startCT = startParent;
    } else {
      boolean _containsKey = this.gv.startTime.containsKey(task.getName());
      if (_containsKey) {
        startCT = this.gv.startTime.get(task.getName()).toString();
      }
    }
    if ((endParent != "null")) {
      endCT = endParent;
    } else {
      boolean _containsKey_1 = this.gv.endTime.containsKey(task.getName());
      if (_containsKey_1) {
        endCT = this.gv.endTime.get(task.getName()).toString();
      }
    }
    ListIterator<Integer> sbc = subtaskcounter.listIterator();
    EList<TasksModel> _canDoTask_1 = task.getCanDoTask();
    for (final TasksModel t_1 : _canDoTask_1) {
      boolean _matched_1 = false;
      if (t_1 instanceof AtomicTask) {
        _matched_1=true;
        Tree.addAtomicTask(this.gv, ((AtomicTask)t_1), (sbc.next()).intValue(), ctName, missionLoc, startCT, endCT, topMission);
      }
      if (!_matched_1) {
        if (t_1 instanceof CompoundTask) {
          _matched_1=true;
          int _countCTpython = this.gv.countCTpython;
          this.gv.countCTpython = (_countCTpython + 1);
          this.recursiveAddSubTasks(ctName, ((CompoundTask)t_1), (sbc.next()).intValue(), missionLoc, startCT, endCT, topMission);
        }
      }
    }
  }

  /**
   * Add atomic task to tree
   */
  public static String addAtomicTask(final GlobalVar gv, final AtomicTask t, final int i, final String parent, final Location missionLoc, final String startParent, final String endParent, final MissionTask mission) {
    String _xblockexpression = null;
    {
      gv.at_in_mission.add(t);
      String _name = t.getName();
      String _plus = (_name + "_");
      String atName = (_plus + Integer.valueOf(i));
      Hashtable<MissionTask, ArrayList<String>> missonAtInstances = gv.missionTask2atomicTasksInstances;
      boolean _containsKey = missonAtInstances.containsKey(mission);
      if (_containsKey) {
        ArrayList<String> b = missonAtInstances.get(mission);
        b.add(atName);
        gv.missionTask2atomicTasksInstances.put(mission, b);
      } else {
        ArrayList<String> b_1 = new ArrayList<String>();
        b_1.add(atName);
        gv.missionTask2atomicTasksInstances.put(mission, b_1);
      }
      Location location = t.getLoc();
      if ((missionLoc != null)) {
        location = missionLoc;
      }
      String joint = "false";
      int _robots = t.getRobots();
      boolean _greaterThan = (_robots > 1);
      if (_greaterThan) {
        joint = "true";
      }
      gv.atLoc.put(atName, location);
      String start = "null";
      if ((startParent != "null")) {
        start = startParent;
      } else {
        if ((startParent == "null")) {
          boolean _containsKey_1 = gv.startTime.containsKey(t.getName());
          if (_containsKey_1) {
            start = gv.startTime.get(t.getName()).toString();
          }
        } else {
          String _name_1 = t.getName();
          String _plus_1 = ("ERROR - cannot retrieved end time constraint for atomic task " + _name_1);
          throw new UnsupportedOperationException(_plus_1);
        }
      }
      String end = "null";
      if ((endParent != "null")) {
        end = endParent;
      } else {
        if ((endParent == "null")) {
          boolean _containsKey_2 = gv.endTime.containsKey(t.getName());
          if (_containsKey_2) {
            end = gv.endTime.get(t.getName()).toString();
          }
        } else {
          String _name_2 = t.getName();
          String _plus_2 = ("ERROR - cannot retrieved start time constraint for atomic task " + _name_2);
          throw new UnsupportedOperationException(_plus_2);
        }
      }
      String _dbTaskTree = gv.dbTaskTree;
      String _missionTreeString = Tree.missionTreeString(atName, parent, "NaN", location.getName(), Integer.valueOf(t.getRobots()).toString(), joint, "NaN", "NaN", start, end);
      _xblockexpression = gv.dbTaskTree = (_dbTaskTree + _missionTreeString);
    }
    return _xblockexpression;
  }

  /**
   * Row in .txt file used for a dataframe df in python
   */
  public static String missionTreeString(final String id, final String par, final String child, final String location, final String numrobots, final String joint, final String order, final String consec, final String end, final String start) {
    String separator = ",,";
    String _replaceAll = id.replaceAll("\\s+", "");
    String _plus = ("\n" + _replaceAll);
    String _plus_1 = (_plus + separator);
    String _replaceAll_1 = par.replaceAll("\\s+", "");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + separator);
    String _replaceAll_2 = child.replaceAll("\\s+", "");
    String _plus_4 = (_plus_3 + _replaceAll_2);
    String _plus_5 = (_plus_4 + separator);
    String _replaceAll_3 = location.replaceAll("\\s+", "");
    String _plus_6 = (_plus_5 + _replaceAll_3);
    String _plus_7 = (_plus_6 + separator);
    String _replaceAll_4 = numrobots.replaceAll("\\s+", "");
    String _plus_8 = (_plus_7 + _replaceAll_4);
    String _plus_9 = (_plus_8 + separator);
    String _replaceAll_5 = joint.replaceAll("\\s+", "");
    String _plus_10 = (_plus_9 + _replaceAll_5);
    String _plus_11 = (_plus_10 + separator);
    String _replaceAll_6 = order.replaceAll("\\s+", "");
    String _plus_12 = (_plus_11 + _replaceAll_6);
    String _plus_13 = (_plus_12 + separator);
    String _replaceAll_7 = consec.replaceAll("\\s+", "");
    String _plus_14 = (_plus_13 + _replaceAll_7);
    String _plus_15 = (_plus_14 + separator);
    String _replaceAll_8 = end.replaceAll("\\s+", "");
    String _plus_16 = (_plus_15 + _replaceAll_8);
    String _plus_17 = (_plus_16 + separator);
    String _replaceAll_9 = start.replaceAll("\\s+", "");
    String dfAllocationLine = (_plus_17 + _replaceAll_9);
    return dfAllocationLine;
  }

  /**
   * Generate tree file
   */
  public void generateTreeFile(final String fileName) {
    this.gv.fsa.deleteFile(fileName);
    this.generateFile(fileName, this.gv.dbTaskTree);
  }

  public void generateFile(final String fileName, final String finalString) {
    this.gv.fsa.deleteFile(fileName);
    this.gv.fsa.generateFile(fileName, finalString);
  }
}
