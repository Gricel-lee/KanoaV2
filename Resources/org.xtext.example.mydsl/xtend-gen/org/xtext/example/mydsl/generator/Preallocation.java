package org.xtext.example.mydsl.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import dsl.AllocateT;
import dsl.AtomicTask;
import dsl.Closest;
import dsl.CompoundTask;
import dsl.Constraints;
import dsl.Location;
import dsl.MissionTask;
import dsl.Robot;
import dsl.TaskTime;
import dsl.TasksModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * Tasks tree - extract information from DSL
 */
@SuppressWarnings("all")
public class Preallocation {
  /**
   * Global variables
   */
  public final GlobalVar gv = new GlobalVar();

  /**
   * Create tree
   */
  public Preallocation(final Resource resource, final IFileSystemAccess2 fsa, final String outputFileName) {
    this.instantiateTasks(resource, fsa);
    this.overrideLocationFromMissionTasks();
    this.assignPreallocatedTasksToRobots();
    this.assignInitEndTimesOfAtomicTasks();
    this.printAll();
    InputOutput.<List<String>>println(this.gv.tasksList);
  }

  /**
   * STEP1. Instantiate tasks. Starting from mission tasks.
   */
  public void instantiateTasks(final Resource resource, final IFileSystemAccess2 fsa) {
    this.gv.fsa = fsa;
    this.gv.resource = resource;
    final Iterator<MissionTask> mtList = Iterators.<MissionTask>filter(resource.getAllContents(), MissionTask.class);
    while (mtList.hasNext()) {
      {
        final MissionTask mt = mtList.next();
        boolean _matched = false;
        if (mt instanceof MissionTask) {
          _matched=true;
          AtomicTask _at = mt.getAt();
          boolean _tripleNotEquals = (_at != null);
          if (_tripleNotEquals) {
            int _counterAT = this.gv.counterAT;
            this.gv.counterAT = (_counterAT + 1);
            MissionTaskInstance mt_instance = new MissionTaskInstance();
            String _name = mt.getAt().getName();
            String _plus = (_name + "_");
            String _plus_1 = (_plus + Integer.valueOf(this.gv.counterAT));
            mt_instance.set(mt, _plus_1);
            this.gv.missionList.put(mt.getName(), mt_instance);
            this.gv.tasksList.add(mt.getName());
            AtomicTaskinstance at_instance = new AtomicTaskinstance();
            at_instance.set(mt.getAt(), Integer.valueOf(this.gv.counterAT), mt.getName());
            String _name_1 = mt.getAt().getName();
            String _plus_2 = (_name_1 + "_");
            String _plus_3 = (_plus_2 + Integer.valueOf(this.gv.counterAT));
            this.gv.atomicList.put(_plus_3, at_instance);
            String _name_2 = mt.getAt().getName();
            String _plus_4 = (_name_2 + "_");
            String _plus_5 = (_plus_4 + Integer.valueOf(this.gv.counterAT));
            this.gv.tasksList.add(_plus_5);
          } else {
            CompoundTask _ct = mt.getCt();
            boolean _tripleNotEquals_1 = (_ct != null);
            if (_tripleNotEquals_1) {
              int _counterCT = this.gv.counterCT;
              this.gv.counterCT = (_counterCT + 1);
              MissionTaskInstance mt_instance_1 = new MissionTaskInstance();
              String _name_3 = mt.getCt().getName();
              String _plus_6 = (_name_3 + "_");
              String _plus_7 = (_plus_6 + Integer.valueOf(this.gv.counterCT));
              mt_instance_1.set(mt, _plus_7);
              this.gv.missionList.put(mt.getName(), mt_instance_1);
              this.gv.tasksList.add(mt.getName());
              this.addRecursivellySubtasks(mt.getCt(), mt.getName(), Integer.valueOf(this.gv.counterCT));
            }
          }
        }
      }
    }
  }

  /**
   * STEP2. Rewrite location of subtasks from mission tasks with locations.
   */
  public void overrideLocationFromMissionTasks() {
    final Iterator<MissionTask> mtList = Iterators.<MissionTask>filter(this.gv.resource.getAllContents(), MissionTask.class);
    while (mtList.hasNext()) {
      {
        final MissionTask mt = mtList.next();
        InputOutput.<String>println("\n");
        boolean _matched = false;
        if (mt instanceof MissionTask) {
          _matched=true;
          Location _loc = mt.getLoc();
          boolean _tripleNotEquals = (_loc != null);
          if (_tripleNotEquals) {
            ArrayList<String> _atomicInstancesReachable = this.gv.missionList.get(mt.getName()).getatomicInstancesReachable(this.gv);
            for (final String at : _atomicInstancesReachable) {
              {
                AtomicTaskinstance _get = this.gv.atomicList.get(at);
                _get.loc = mt.getLoc();
                String _name = mt.getName();
                String _plus = ("*Mission " + _name);
                String _plus_1 = (_plus + " changed location of atomic task instance ");
                String _plus_2 = (_plus_1 + at);
                String _plus_3 = (_plus_2 + " to ");
                String _name_1 = mt.getLoc().getName();
                String _plus_4 = (_plus_3 + _name_1);
                InputOutput.<String>println(_plus_4);
              }
            }
          }
        }
      }
    }
  }

  /**
   * STEP 3. Preallocation tasks assigned to robots
   */
  private void assignPreallocatedTasksToRobots() {
    final Iterator<Constraints> conList = Iterators.<Constraints>filter(this.gv.resource.getAllContents(), Constraints.class);
    while (conList.hasNext()) {
      {
        final Constraints con = conList.next();
        InputOutput.<String>println("\n");
        boolean _matched = false;
        if (con instanceof AllocateT) {
          _matched=true;
          MissionTask _mt = ((AllocateT)con).getMt();
          boolean _tripleNotEquals = (_mt != null);
          if (_tripleNotEquals) {
            ArrayList<String> atReachable = this.gv.missionList.get(((AllocateT)con).getMt().getName()).getatomicInstancesReachable(this.gv);
            for (final String atID : atReachable) {
              {
                Aux.allocateATtoRobot(atID, ((AllocateT)con).getRobot(), this.gv);
                String _name = ((AllocateT)con).getRobot().getName();
                String _plus = ((("*Preallocation: " + atID) + " allocated to ") + _name);
                String _plus_1 = (_plus + " - (by constraint: allocate task ");
                String _name_1 = ((AllocateT)con).getMt().getName();
                String _plus_2 = (_plus_1 + _name_1);
                String _plus_3 = (_plus_2 + " to robot ");
                String _name_2 = ((AllocateT)con).getRobot().getName();
                String _plus_4 = (_plus_3 + _name_2);
                String _plus_5 = (_plus_4 + ")");
                InputOutput.<String>println(_plus_5);
              }
            }
          } else {
            AtomicTask _at = ((AllocateT)con).getAt();
            boolean _tripleNotEquals_1 = (_at != null);
            if (_tripleNotEquals_1) {
              Collection<AtomicTaskinstance> _values = this.gv.atomicList.values();
              for (final AtomicTaskinstance atInstance : _values) {
                String _name = atInstance.at.getName();
                String _name_1 = ((AllocateT)con).getAt().getName();
                boolean _equals = Objects.equal(_name, _name_1);
                if (_equals) {
                  String atID_1 = atInstance.getId();
                  Aux.allocateATtoRobot(atID_1, ((AllocateT)con).getRobot(), this.gv);
                  String _name_2 = ((AllocateT)con).getRobot().getName();
                  String _plus = ((("*Preallocation: " + atID_1) + " allocated to ") + _name_2);
                  String _plus_1 = (_plus + " - (by constraint: allocate task ");
                  String _name_3 = ((AllocateT)con).getAt().getName();
                  String _plus_2 = (_plus_1 + _name_3);
                  String _plus_3 = (_plus_2 + " to robot ");
                  String _name_4 = ((AllocateT)con).getRobot().getName();
                  String _plus_4 = (_plus_3 + _name_4);
                  String _plus_5 = (_plus_4 + ")");
                  InputOutput.<String>println(_plus_5);
                }
              }
            } else {
              CompoundTask _ct = ((AllocateT)con).getCt();
              boolean _tripleNotEquals_2 = (_ct != null);
              if (_tripleNotEquals_2) {
                Collection<CompoundTaskInstance> _values_1 = this.gv.compoundList.values();
                for (final CompoundTaskInstance ctInstance : _values_1) {
                  CompoundTask _ct_1 = ((AllocateT)con).getCt();
                  boolean _tripleEquals = (ctInstance.ct == _ct_1);
                  if (_tripleEquals) {
                    ArrayList<String> _atSubtasks = ctInstance.getatSubtasks(this.gv);
                    for (final String atID_2 : _atSubtasks) {
                      {
                        Aux.allocateATtoRobot(atID_2, ((AllocateT)con).getRobot(), this.gv);
                        String _name_5 = ((AllocateT)con).getRobot().getName();
                        String _plus_6 = ((("*Preallocation: " + atID_2) + " allocated to ") + _name_5);
                        String _plus_7 = (_plus_6 + " - (by constraint: allocate task ");
                        String _name_6 = ((AllocateT)con).getCt().getName();
                        String _plus_8 = (_plus_7 + _name_6);
                        String _plus_9 = (_plus_8 + " to robot ");
                        String _name_7 = ((AllocateT)con).getRobot().getName();
                        String _plus_10 = (_plus_9 + _name_7);
                        String _plus_11 = (_plus_10 + ")");
                        InputOutput.<String>println(_plus_11);
                      }
                    }
                  }
                }
              } else {
                throw new UnsupportedOperationException(("ERROR. No task found on mission constraint:" + con));
              }
            }
          }
        }
        if (!_matched) {
          if (con instanceof Closest) {
            _matched=true;
            MissionTask _mt = ((Closest)con).getMt();
            boolean _tripleNotEquals = (_mt != null);
            if (_tripleNotEquals) {
              ArrayList<String> atReachable = this.gv.missionList.get(((Closest)con).getMt().getName()).getatomicInstancesReachable(this.gv);
              for (final String atID : atReachable) {
                {
                  Robot r = Aux.getClosestRobot(atID, this.gv);
                  AtomicTaskinstance _get = this.gv.atomicList.get(atID);
                  _get.robot = r;
                  String _name = r.getName();
                  String _plus = ((("*Preallocation: " + atID) + " allocated to ") + _name);
                  String _plus_1 = (_plus + " - (by constraint: allocate task ");
                  String _name_1 = ((Closest)con).getMt().getName();
                  String _plus_2 = (_plus_1 + _name_1);
                  String _plus_3 = (_plus_2 + " to closest robot.)");
                  InputOutput.<String>println(_plus_3);
                }
              }
            } else {
              AtomicTask _at = ((Closest)con).getAt();
              boolean _tripleNotEquals_1 = (_at != null);
              if (_tripleNotEquals_1) {
                Collection<AtomicTaskinstance> _values = this.gv.atomicList.values();
                for (final AtomicTaskinstance atInstance : _values) {
                  String _name = atInstance.at.getName();
                  String _name_1 = ((Closest)con).getAt().getName();
                  boolean _equals = Objects.equal(_name, _name_1);
                  if (_equals) {
                    String atID_1 = atInstance.getId();
                    Robot r = Aux.getClosestRobot(atID_1, this.gv);
                    AtomicTaskinstance _get = this.gv.atomicList.get(atID_1);
                    _get.robot = r;
                    String _name_2 = r.getName();
                    String _plus = ((("*Preallocation: " + atID_1) + " allocated to ") + _name_2);
                    String _plus_1 = (_plus + " - (by constraint: allocate task ");
                    String _name_3 = ((Closest)con).getAt().getName();
                    String _plus_2 = (_plus_1 + _name_3);
                    String _plus_3 = (_plus_2 + " to closest robot.)");
                    InputOutput.<String>println(_plus_3);
                  }
                }
              } else {
                CompoundTask _ct = ((Closest)con).getCt();
                boolean _tripleNotEquals_2 = (_ct != null);
                if (_tripleNotEquals_2) {
                  Collection<CompoundTaskInstance> _values_1 = this.gv.compoundList.values();
                  for (final CompoundTaskInstance ctInstance : _values_1) {
                    CompoundTask _ct_1 = ((Closest)con).getCt();
                    boolean _tripleEquals = (ctInstance.ct == _ct_1);
                    if (_tripleEquals) {
                      ArrayList<String> _atSubtasks = ctInstance.getatSubtasks(this.gv);
                      for (final String atID_2 : _atSubtasks) {
                        {
                          Robot r_1 = Aux.getClosestRobot(atID_2, this.gv);
                          AtomicTaskinstance _get_1 = this.gv.atomicList.get(atID_2);
                          _get_1.robot = r_1;
                          String _name_4 = r_1.getName();
                          String _plus_4 = ((("*Preallocation: " + atID_2) + " allocated to ") + _name_4);
                          String _plus_5 = (_plus_4 + " - (by constraint: allocate task ");
                          String _name_5 = ((Closest)con).getCt().getName();
                          String _plus_6 = (_plus_5 + _name_5);
                          String _plus_7 = (_plus_6 + " to closest robot.)");
                          InputOutput.<String>println(_plus_7);
                        }
                      }
                    }
                  }
                } else {
                  Set<String> _keySet = this.gv.atomicList.keySet();
                  for (final String atID_3 : _keySet) {
                    {
                      Robot r_1 = Aux.getClosestRobot(atID_3, this.gv);
                      AtomicTaskinstance _get_1 = this.gv.atomicList.get(atID_3);
                      _get_1.robot = r_1;
                      String _name_4 = r_1.getName();
                      String _plus_4 = ((("*Preallocation: " + atID_3) + " allocated to ") + _name_4);
                      String _plus_5 = (_plus_4 + " - (by constraint: allocate all tasks to closest robot.)");
                      InputOutput.<String>println(_plus_5);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  /**
   * STEP 4. Check time constraints (end/start time)
   */
  private void assignInitEndTimesOfAtomicTasks() {
    final List<TaskTime> timeConstraints = IteratorExtensions.<TaskTime>toList(Iterators.<TaskTime>filter(this.gv.resource.getAllContents(), TaskTime.class));
    for (final TaskTime tcon : timeConstraints) {
      {
        InputOutput.<String>println("\n");
        MissionTask _mt = tcon.getMt();
        boolean _tripleNotEquals = (_mt != null);
        if (_tripleNotEquals) {
          ArrayList<String> atReachable = this.gv.missionList.get(tcon.getMt().getName()).getatomicInstancesReachable(this.gv);
          for (final String atID : atReachable) {
            String _name = tcon.getStartEnd().getName();
            boolean _equals = Objects.equal(_name, "start");
            if (_equals) {
              AtomicTaskinstance _get = this.gv.atomicList.get(atID);
              _get.start = Double.valueOf(tcon.getTime());
              double _time = tcon.getTime();
              String _plus = ("*Start time " + Double.valueOf(_time));
              String _plus_1 = (_plus + " for : ");
              String _plus_2 = (_plus_1 + atID);
              String _plus_3 = (_plus_2 + " - (by constraint: task ");
              String _name_1 = tcon.getMt().getName();
              String _plus_4 = (_plus_3 + _name_1);
              String _plus_5 = (_plus_4 + " with start time ");
              double _time_1 = tcon.getTime();
              String _plus_6 = (_plus_5 + Double.valueOf(_time_1));
              String _plus_7 = (_plus_6 + " )");
              InputOutput.<String>println(_plus_7);
            } else {
              String _name_2 = tcon.getStartEnd().getName();
              boolean _equals_1 = Objects.equal(_name_2, "end");
              if (_equals_1) {
                AtomicTaskinstance _get_1 = this.gv.atomicList.get(atID);
                _get_1.end = Double.valueOf(tcon.getTime());
                double _time_2 = tcon.getTime();
                String _plus_8 = ("*End time " + Double.valueOf(_time_2));
                String _plus_9 = (_plus_8 + " for : ");
                String _plus_10 = (_plus_9 + atID);
                String _plus_11 = (_plus_10 + " - (by constraint: task ");
                String _name_3 = tcon.getMt().getName();
                String _plus_12 = (_plus_11 + _name_3);
                String _plus_13 = (_plus_12 + " with end time ");
                double _time_3 = tcon.getTime();
                String _plus_14 = (_plus_13 + Double.valueOf(_time_3));
                String _plus_15 = (_plus_14 + " )");
                InputOutput.<String>println(_plus_15);
              }
            }
          }
        } else {
          AtomicTask _at = tcon.getAt();
          boolean _tripleNotEquals_1 = (_at != null);
          if (_tripleNotEquals_1) {
            Collection<AtomicTaskinstance> _values = this.gv.atomicList.values();
            for (final AtomicTaskinstance atInstance : _values) {
              String _name_4 = atInstance.at.getName();
              String _name_5 = tcon.getAt().getName();
              boolean _equals_2 = Objects.equal(_name_4, _name_5);
              if (_equals_2) {
                String atID_1 = atInstance.getId();
                String _name_6 = tcon.getStartEnd().getName();
                boolean _equals_3 = Objects.equal(_name_6, "start");
                if (_equals_3) {
                  AtomicTaskinstance _get_2 = this.gv.atomicList.get(atID_1);
                  _get_2.start = Double.valueOf(tcon.getTime());
                  double _time_4 = tcon.getTime();
                  String _plus_16 = ("*Start time " + Double.valueOf(_time_4));
                  String _plus_17 = (_plus_16 + " for : ");
                  String _plus_18 = (_plus_17 + atID_1);
                  String _plus_19 = (_plus_18 + " - (by constraint: task ");
                  String _name_7 = tcon.getAt().getName();
                  String _plus_20 = (_plus_19 + _name_7);
                  String _plus_21 = (_plus_20 + " with start time ");
                  double _time_5 = tcon.getTime();
                  String _plus_22 = (_plus_21 + Double.valueOf(_time_5));
                  String _plus_23 = (_plus_22 + " )");
                  InputOutput.<String>println(_plus_23);
                } else {
                  String _name_8 = tcon.getStartEnd().getName();
                  boolean _equals_4 = Objects.equal(_name_8, "end");
                  if (_equals_4) {
                    AtomicTaskinstance _get_3 = this.gv.atomicList.get(atID_1);
                    _get_3.end = Double.valueOf(tcon.getTime());
                    double _time_6 = tcon.getTime();
                    String _plus_24 = ("*End time " + Double.valueOf(_time_6));
                    String _plus_25 = (_plus_24 + " for : ");
                    String _plus_26 = (_plus_25 + atID_1);
                    String _plus_27 = (_plus_26 + " - (by constraint: task ");
                    String _name_9 = tcon.getAt().getName();
                    String _plus_28 = (_plus_27 + _name_9);
                    String _plus_29 = (_plus_28 + " with end time ");
                    double _time_7 = tcon.getTime();
                    String _plus_30 = (_plus_29 + Double.valueOf(_time_7));
                    String _plus_31 = (_plus_30 + " )");
                    InputOutput.<String>println(_plus_31);
                  }
                }
              }
            }
          } else {
            CompoundTask _ct = tcon.getCt();
            boolean _tripleNotEquals_2 = (_ct != null);
            if (_tripleNotEquals_2) {
              Collection<CompoundTaskInstance> _values_1 = this.gv.compoundList.values();
              for (final CompoundTaskInstance ctInstance : _values_1) {
                CompoundTask _ct_1 = tcon.getCt();
                boolean _tripleEquals = (ctInstance.ct == _ct_1);
                if (_tripleEquals) {
                  ArrayList<String> _atSubtasks = ctInstance.getatSubtasks(this.gv);
                  for (final String atID_2 : _atSubtasks) {
                    String _name_10 = tcon.getStartEnd().getName();
                    boolean _equals_5 = Objects.equal(_name_10, "start");
                    if (_equals_5) {
                      AtomicTaskinstance _get_4 = this.gv.atomicList.get(atID_2);
                      _get_4.start = Double.valueOf(tcon.getTime());
                      double _time_8 = tcon.getTime();
                      String _plus_32 = ("*Start time " + Double.valueOf(_time_8));
                      String _plus_33 = (_plus_32 + " for : ");
                      String _plus_34 = (_plus_33 + atID_2);
                      String _plus_35 = (_plus_34 + " - (by constraint: task ");
                      String _name_11 = tcon.getCt().getName();
                      String _plus_36 = (_plus_35 + _name_11);
                      String _plus_37 = (_plus_36 + " with start time ");
                      double _time_9 = tcon.getTime();
                      String _plus_38 = (_plus_37 + Double.valueOf(_time_9));
                      String _plus_39 = (_plus_38 + " )");
                      InputOutput.<String>println(_plus_39);
                    } else {
                      String _name_12 = tcon.getStartEnd().getName();
                      boolean _equals_6 = Objects.equal(_name_12, "end");
                      if (_equals_6) {
                        AtomicTaskinstance _get_5 = this.gv.atomicList.get(atID_2);
                        _get_5.end = Double.valueOf(tcon.getTime());
                        double _time_10 = tcon.getTime();
                        String _plus_40 = ("*End time " + Double.valueOf(_time_10));
                        String _plus_41 = (_plus_40 + " for : ");
                        String _plus_42 = (_plus_41 + atID_2);
                        String _plus_43 = (_plus_42 + " - (by constraint: task ");
                        String _name_13 = tcon.getCt().getName();
                        String _plus_44 = (_plus_43 + _name_13);
                        String _plus_45 = (_plus_44 + " with end time ");
                        double _time_11 = tcon.getTime();
                        String _plus_46 = (_plus_45 + Double.valueOf(_time_11));
                        String _plus_47 = (_plus_46 + " )");
                        InputOutput.<String>println(_plus_47);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  /**
   * Print tasks info.
   */
  public void printAll() {
    for (final String id : this.gv.tasksList) {
      {
        InputOutput.<String>println("\n");
        boolean _contains = this.gv.atomicList.keySet().contains(id);
        if (_contains) {
          this.gv.atomicList.get(id).print();
        } else {
          boolean _contains_1 = this.gv.compoundList.keySet().contains(id);
          if (_contains_1) {
            this.gv.compoundList.get(id).print();
          } else {
            boolean _contains_2 = this.gv.missionList.keySet().contains(id);
            if (_contains_2) {
              this.gv.missionList.get(id).print();
            }
          }
        }
      }
    }
  }

  /**
   * Recursively add tasks subtasks
   */
  private void addRecursivellySubtasks(final CompoundTask ct, final String parent, final Integer instance) {
    List<String> children = new ArrayList<String>();
    List<Integer> subtaskcounter = new ArrayList<Integer>();
    EList<TasksModel> _canDoTask = ct.getCanDoTask();
    for (final TasksModel t : _canDoTask) {
      boolean _matched = false;
      if (t instanceof AtomicTask) {
        _matched=true;
        int _counterAT = this.gv.counterAT;
        this.gv.counterAT = (_counterAT + 1);
        String _name = ((AtomicTask)t).getName();
        String _plus = (_name + "_");
        String _plus_1 = (_plus + Integer.valueOf(this.gv.counterAT));
        children.add(_plus_1);
        subtaskcounter.add(Integer.valueOf(this.gv.counterAT));
      }
      if (!_matched) {
        if (t instanceof CompoundTask) {
          _matched=true;
          int _counterCT = this.gv.counterCT;
          this.gv.counterCT = (_counterCT + 1);
          String _name = ((CompoundTask)t).getName();
          String _plus = (_name + "_");
          String _plus_1 = (_plus + Integer.valueOf(this.gv.counterCT));
          children.add(_plus_1);
          subtaskcounter.add(Integer.valueOf(this.gv.counterCT));
        }
      }
    }
    CompoundTaskInstance ct_instance = new CompoundTaskInstance();
    ct_instance.set(ct, instance, parent, children);
    String _name = ct.getName();
    String _plus = (_name + "_");
    String _plus_1 = (_plus + instance);
    this.gv.compoundList.put(_plus_1, ct_instance);
    String _name_1 = ct.getName();
    String _plus_2 = (_name_1 + "_");
    String _plus_3 = (_plus_2 + instance);
    this.gv.tasksList.add(_plus_3);
    ListIterator<Integer> sbc = subtaskcounter.listIterator();
    EList<TasksModel> _canDoTask_1 = ct.getCanDoTask();
    for (final TasksModel t_1 : _canDoTask_1) {
      {
        Integer num = sbc.next();
        boolean _matched_1 = false;
        if (t_1 instanceof AtomicTask) {
          _matched_1=true;
          AtomicTaskinstance at_instance = new AtomicTaskinstance();
          String _name_2 = ct.getName();
          String _plus_4 = (_name_2 + "_");
          String _plus_5 = (_plus_4 + instance);
          at_instance.set(((AtomicTask)t_1), num, _plus_5);
          String _name_3 = ((AtomicTask)t_1).getName();
          String _plus_6 = (_name_3 + "_");
          String _plus_7 = (_plus_6 + num);
          this.gv.atomicList.put(_plus_7, at_instance);
          String _name_4 = ((AtomicTask)t_1).getName();
          String _plus_8 = (_name_4 + "_");
          String _plus_9 = (_plus_8 + num);
          this.gv.tasksList.add(_plus_9);
        }
        if (!_matched_1) {
          if (t_1 instanceof CompoundTask) {
            _matched_1=true;
            String _name_2 = ct.getName();
            String _plus_4 = (_name_2 + "_");
            String _plus_5 = (_plus_4 + instance);
            this.addRecursivellySubtasks(((CompoundTask)t_1), _plus_5, num);
          }
        }
      }
    }
  }
}
