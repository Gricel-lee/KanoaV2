package org.xtext.example.mydsl.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import dsl.AtomicTask;
import dsl.Capability;
import dsl.CompoundTask;
import dsl.Location;
import dsl.MissionTask;
import dsl.Robot;
import dsl.TaskTime;
import dsl.TasksModel;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Create global variables
 */
@SuppressWarnings("all")
public class GlobalVar {
  /**
   * Counter for instances of atomic tasks
   */
  public int countATpython = 0;

  /**
   * Counter for instances of compound tasks
   */
  public int countCTpython = 0;

  /**
   * Header for the Task Tree file
   */
  public String dbTaskTree = "id,,parent,,ordered_children,,location,,numrobots,,joint,,ordered,,consecutive,,start,,end";

  /**
   * List of tasks' start time - if constraint is specified a task
   */
  public Hashtable<String, Double> startTime = new Hashtable<String, Double>();

  /**
   * List of tasks' end time - if constraint is specified for a task
   */
  public Hashtable<String, Double> endTime = new Hashtable<String, Double>();

  /**
   * List atomic tasks locations
   */
  public Hashtable<String, Location> atLoc = new Hashtable<String, Location>();

  /**
   * List of atomic tasks needed for the mission
   */
  public List<AtomicTask> at_in_mission = new ArrayList<AtomicTask>();

  /**
   * List of tasks instances in mission
   */
  public Hashtable<MissionTask, ArrayList<String>> missionTask2atomicTasksInstances = new Hashtable<MissionTask, ArrayList<String>>();

  /**
   * Atomic task instances
   */
  public Hashtable<String, CompoundTaskInstance> compoundTaskInstances = new Hashtable<String, CompoundTaskInstance>();

  /**
   * fsa
   */
  public IFileSystemAccess2 fsa;

  /**
   * Alloy integer scope
   */
  public int alloyIntScope = 7;

  public Resource resource;

  public IFileSystemAccess2 setFsa(final IFileSystemAccess2 fsa) {
    return this.fsa = fsa;
  }

  /**
   * Reset variables
   */
  public Hashtable<String, Location> reset() {
    Hashtable<String, Location> _xblockexpression = null;
    {
      this.countATpython = 0;
      this.countCTpython = 0;
      this.dbTaskTree = "id,,parent,,ordered_children,,location,,numrobots,,joint,,ordered,,consecutive";
      Hashtable<String, Double> _hashtable = new Hashtable<String, Double>();
      this.startTime = _hashtable;
      Hashtable<String, Double> _hashtable_1 = new Hashtable<String, Double>();
      this.endTime = _hashtable_1;
      Hashtable<String, Location> _hashtable_2 = new Hashtable<String, Location>();
      _xblockexpression = this.atLoc = _hashtable_2;
    }
    return _xblockexpression;
  }

  /**
   * Get list of initial and end tasks' time constraints
   */
  public void checkEndStartTimes(final Resource resource) {
    this.resource = resource;
    Iterator<TaskTime> ttimeList = Iterators.<TaskTime>filter(resource.getAllContents(), TaskTime.class);
    String tID = "";
    while (ttimeList.hasNext()) {
      {
        final TaskTime tt = ttimeList.next();
        AtomicTask _at = tt.getAt();
        boolean _tripleNotEquals = (_at != null);
        if (_tripleNotEquals) {
          tID = tt.getAt().getName();
        }
        CompoundTask _ct = tt.getCt();
        boolean _tripleNotEquals_1 = (_ct != null);
        if (_tripleNotEquals_1) {
          tID = tt.getCt().getName();
        }
        MissionTask _mt = tt.getMt();
        boolean _tripleNotEquals_2 = (_mt != null);
        if (_tripleNotEquals_2) {
          tID = tt.getMt().getName();
        }
        String _string = tt.getStartEnd().toString();
        boolean _equals = Objects.equal(_string, "start");
        if (_equals) {
          this.startTime.put(tID, Double.valueOf(tt.getTime()));
        }
        String _string_1 = tt.getStartEnd().toString();
        boolean _equals_1 = Objects.equal(_string_1, "end");
        if (_equals_1) {
          this.endTime.put(tID, Double.valueOf(tt.getTime()));
        }
      }
    }
  }

  /**
   * Get list of atomic tasks reachable from a compound task, recursively
   */
  public List<AtomicTask> getatomictasksinCT(final CompoundTask ct) {
    List<AtomicTask> ats_in_ct = new ArrayList<AtomicTask>();
    EList<TasksModel> _canDoTask = ct.getCanDoTask();
    for (final TasksModel subt : _canDoTask) {
      boolean _matched = false;
      if (subt instanceof AtomicTask) {
        _matched=true;
        ats_in_ct.add(((AtomicTask)subt));
      }
      if (!_matched) {
        if (subt instanceof CompoundTask) {
          _matched=true;
          List<AtomicTask> _atomictasksinCT = this.getatomictasksinCT(((CompoundTask)subt));
          List<AtomicTask> newList = new ArrayList<AtomicTask>(_atomictasksinCT);
          ats_in_ct.addAll(newList);
        }
      }
    }
    return ats_in_ct;
  }

  /**
   * Get closest robot to atomic task
   */
  public Robot getClosestRobot(final String atInstance) {
    final Hashtable<String, Location> loc = this.atLoc;
    Robot closestR = null;
    Double closestD = null;
    List<Robot> _list = IteratorExtensions.<Robot>toList(Iterators.<Robot>filter(this.resource.getAllContents(), Robot.class));
    for (final Robot r : _list) {
      {
        String ithas = "";
        EList<Capability> _capabilities = r.getCapabilities();
        for (final Capability i : _capabilities) {
          String _name = i.getAt().getName();
          String _at_from_atInstance = this.at_from_atInstance(atInstance);
          boolean _equals = Objects.equal(_name, _at_from_atInstance);
          if (_equals) {
            ithas = "true";
          }
        }
        if ((ithas == "true")) {
          double _x = loc.get(atInstance).getX();
          double _y = loc.get(atInstance).getY();
          Pair<Double, Double> coordAT = new Pair<Double, Double>(Double.valueOf(_x), Double.valueOf(_y));
          double _x_1 = r.getInitLoc().getX();
          double _y_1 = r.getInitLoc().getY();
          Pair<Double, Double> coordRob = new Pair<Double, Double>(Double.valueOf(_x_1), Double.valueOf(_y_1));
          double dist = this.distance(coordAT, coordRob);
          if ((closestR == null)) {
            closestR = r;
            closestD = Double.valueOf(dist);
          } else {
            if ((dist < (closestD).doubleValue())) {
              closestR = r;
              closestD = Double.valueOf(dist);
            }
          }
        }
      }
    }
    return closestR;
  }

  /**
   * Euclidian distance
   */
  public double distance(final Pair<Double, Double> coord1, final Pair<Double, Double> coord2) {
    Double _key = coord1.getKey();
    Double _key_1 = coord2.getKey();
    double deltaX = DoubleExtensions.operator_minus(_key, _key_1);
    Double _value = coord1.getValue();
    Double _value_1 = coord2.getValue();
    double deltaY = DoubleExtensions.operator_minus(_value, _value_1);
    double result = Math.sqrt(((deltaX * deltaX) + (deltaY * deltaY)));
    return result;
  }

  /**
   * Return atomic task id without instance number
   */
  public String at_from_atInstance(final String atInstance) {
    String s = atInstance.substring(0, atInstance.lastIndexOf("_"));
    return s;
  }

  /**
   * Return atomic task without instance number
   */
  public AtomicTask at_from_atInstanceT(final String atInstance) {
    String s = atInstance.substring(0, atInstance.lastIndexOf("_"));
    List<AtomicTask> _list = IteratorExtensions.<AtomicTask>toList(Iterators.<AtomicTask>filter(this.resource.getAllContents(), AtomicTask.class));
    for (final AtomicTask at : _list) {
      String _name = at.getName();
      boolean _equals = Objects.equal(_name, s);
      if (_equals) {
        return at;
      }
    }
    throw new UnsupportedOperationException(("ERROR - retrieving task for instance " + s));
  }

  /**
   * Get atomic task instances for all instances of a compound task type ct
   */
  public List<String> getInstanceChildrenFromCTintance(final CompoundTask ct) {
    Enumeration<String> all_ctInstances_IDs = this.compoundTaskInstances.keys();
    InputOutput.<String>println(("All ct instances:" + all_ctInstances_IDs));
    List<String> children = null;
    while (all_ctInstances_IDs.hasMoreElements()) {
      {
        String n = all_ctInstances_IDs.nextElement();
        CompoundTaskInstance ctInstance = this.compoundTaskInstances.get(n);
        boolean _equals = Objects.equal(ctInstance.ct, ct);
        if (_equals) {
          children.addAll(ctInstance.subtasksInstances);
        }
      }
    }
    List<String> at = null;
    for (final String ch : children) {
      boolean _containsKey = this.compoundTaskInstances.containsKey(ch);
      if (_containsKey) {
        children.addAll(this.compoundTaskInstances.get(ch).subtasksInstances);
      } else {
        at.add(ch);
      }
    }
    return at;
  }
}
