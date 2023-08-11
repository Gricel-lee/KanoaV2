package org.xtext.example.mydsl.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import dsl.AllocateT;
import dsl.AtomicTask;
import dsl.Capability;
import dsl.Closest;
import dsl.CompoundTask;
import dsl.Location;
import dsl.MaxTasks;
import dsl.MissionTask;
import dsl.ProblemSpecification;
import dsl.Robot;
import dsl.SpaceXYRobot;
import dsl.TasksModel;
import dsl.XY;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class AlloyFile {
  public static void createAlloyFile(final Tree tree, final Resource resource) {
    try {
      String path_sigAlloyDeclaration = "/Users/grisv/GitHub/KanoaV2/Resources/org.xtext.example.mydsl/src/org/xtext/example/mydsl/generator//";
      String s = AlloyFile.readFile((path_sigAlloyDeclaration + "sigAlloyDeclaration.txt"));
      final List<Robot> rList = IteratorExtensions.<Robot>toList(Iterators.<Robot>filter(resource.getAllContents(), Robot.class));
      List<AtomicTask> at_missions = tree.gv.at_in_mission;
      Set<AtomicTask> at_unique = new HashSet<AtomicTask>(at_missions);
      String s_r = "";
      String s_cap = "";
      int count_capabilities = 0;
      String _s = s;
      s = (_s + "\n\n// ----------------ROBOTS:\n");
      for (final Robot r : rList) {
        {
          String _s_1 = s;
          String _name = r.getName();
          String _plus = ("\nlone sig " + _name);
          String _plus_1 = (_plus + " extends Robot{}\n");
          s = (_s_1 + _plus_1);
          String _s_2 = s;
          s = (_s_2 + "{disj[capability ,  Capability");
          List<Capability> _list = IterableExtensions.<Capability>toList(r.getCapabilities());
          for (final Capability t : _list) {
            boolean _contains = at_unique.contains(t.getAt());
            if (_contains) {
              String _s_3 = s;
              String _name_1 = r.getName();
              String _plus_2 = ("-" + _name_1);
              String _name_2 = t.getAt().getName();
              String _plus_3 = (_plus_2 + _name_2);
              s = (_s_3 + _plus_3);
              String _s_cap = s_cap;
              String _name_3 = r.getName();
              String _plus_4 = ("\nlone sig " + _name_3);
              String _name_4 = t.getAt().getName();
              String _plus_5 = (_plus_4 + _name_4);
              String _plus_6 = (_plus_5 + " extends Capability{}\n");
              s_cap = (_s_cap + _plus_6);
              String _s_cap_1 = s_cap;
              String _name_5 = t.getAt().getName();
              String _plus_7 = ("{all d:do | d in " + _name_5);
              String _plus_8 = (_plus_7 + "}");
              s_cap = (_s_cap_1 + _plus_8);
              int _count_capabilities = count_capabilities;
              count_capabilities = (_count_capabilities + 1);
            }
          }
          String _s_4 = s;
          s = (_s_4 + "]}");
        }
      }
      String _s_1 = s;
      s = (_s_1 + "\n\n// ----------------CAPABILITIES:\n");
      String _s_2 = s;
      s = (_s_2 + s_cap);
      String _s_3 = s;
      s = (_s_3 + "\n\n// ----------------ATOMIC TASKS:\n");
      String _s_4 = s;
      s = (_s_4 + ("\n" + "abstract sig "));
      String s_t = "";
      String s_f = "";
      TreeIterator<EObject> _allContents = null;
      if (resource!=null) {
        _allContents=resource.getAllContents();
      }
      EObject _head = null;
      if (_allContents!=null) {
        _head=IteratorExtensions.<EObject>head(_allContents);
      }
      final ProblemSpecification root = ((ProblemSpecification) _head);
      for (int i = 0; (i < ((Object[])Conversions.unwrapArray(at_unique, Object.class)).length); i++) {
        {
          final Set<AtomicTask> _converted_at_unique = (Set<AtomicTask>)at_unique;
          AtomicTask at = ((AtomicTask[])Conversions.unwrapArray(_converted_at_unique, AtomicTask.class))[i];
          String _s_t = s_t;
          String _name = at.getName();
          String _plus = (_name + ",");
          s_t = (_s_t + _plus);
          String _s_f = s_f;
          String _name_1 = at.getName();
          String _plus_1 = ("\nfact{all a:" + _name_1);
          String _plus_2 = (_plus_1 + " | #do.a=");
          int _robots_atName = AlloyFile.getRobots_atName(at.getName(), root);
          String _plus_3 = (_plus_2 + Integer.valueOf(_robots_atName));
          String _plus_4 = (_plus_3 + "}\t// number of robots needed");
          s_f = (_s_f + _plus_4);
        }
      }
      String _s_5 = s;
      int _length = s_t.length();
      int _minus = (_length - 1);
      String _substring = s_t.substring(0, _minus);
      String _plus = (_substring + " extends AtomicTask {}");
      s = (_s_5 + _plus);
      String _s_6 = s;
      s = (_s_6 + s_f);
      Hashtable<String, Location> taskInstancesLoc = tree.gv.atLoc;
      Enumeration<String> atInstances = tree.gv.atLoc.keys();
      while (atInstances.hasMoreElements()) {
        {
          String atInstance = atInstances.nextElement();
          Location atLoc = taskInstancesLoc.get(atInstance);
          String at = atInstance.split("_")[0];
          String _s_7 = s;
          s = (_s_7 + (((("\none sig " + atInstance) + " extends ") + at) + "{}"));
          String x = AlloyFile.cast2Int(Double.valueOf(atLoc.getX()));
          String y = AlloyFile.cast2Int(Double.valueOf(atLoc.getY()));
          String _s_8 = s;
          s = (_s_8 + ((((" {x=" + x) + " y=") + y) + "}"));
        }
      }
      String _s_7 = s;
      s = (_s_7 + "\n\n// ----------------PREDICATE:\n");
      String _s_8 = s;
      s = (_s_8 + "\npred TaskAllocation{");
      String _s_9 = s;
      s = (_s_9 + "\n}");
      String _s_10 = s;
      s = (_s_10 + "\n\n// ----------------CONSTRAINTS:\n");
      final Iterator<SpaceXYRobot> constrantListXY = Iterators.<SpaceXYRobot>filter(resource.getAllContents(), SpaceXYRobot.class);
      while (constrantListXY.hasNext()) {
        {
          String lg = "";
          final SpaceXYRobot c = constrantListXY.next();
          String _string = c.getLowerGreater().toString();
          boolean _equals = Objects.equal(_string, "lower");
          if (_equals) {
            lg = "<";
          } else {
            String _string_1 = c.getLowerGreater().toString();
            boolean _equals_1 = Objects.equal(_string_1, "greater");
            if (_equals_1) {
              lg = ">";
            } else {
              Robot _robot = c.getRobot();
              String _plus_1 = ("ERROR retrieving constraint SpaceXY for robot" + _robot);
              throw new UnsupportedOperationException(_plus_1);
            }
          }
          final double v = c.getVal();
          String _s_11 = s;
          String _name = c.getRobot().getName();
          String _plus_2 = ("\n fact{ all r:" + _name);
          String _plus_3 = (_plus_2 + "| all c:r.capability | all do:c.do | do.");
          XY _coordinate = c.getCoordinate();
          String _plus_4 = (_plus_3 + _coordinate);
          String _plus_5 = (_plus_4 + lg);
          String _cast2Int = AlloyFile.cast2Int(Double.valueOf(v));
          String _plus_6 = (_plus_5 + _cast2Int);
          String _plus_7 = (_plus_6 + "}");
          s = (_s_11 + _plus_7);
        }
      }
      final Iterator<AllocateT> constrantListAlloc = Iterators.<AllocateT>filter(resource.getAllContents(), AllocateT.class);
      while (constrantListAlloc.hasNext()) {
        {
          final AllocateT c = constrantListAlloc.next();
          AtomicTask _at = c.getAt();
          boolean _tripleNotEquals = (_at != null);
          if (_tripleNotEquals) {
            String _s_11 = s;
            String _name = c.getAt().getName();
            String _plus_1 = ("\n fact {all at: " + _name);
            String _plus_2 = (_plus_1 + "| one d: do.at | d in ");
            String _name_1 = c.getRobot().getName();
            String _plus_3 = (_plus_2 + _name_1);
            String _plus_4 = (_plus_3 + ".capability}");
            s = (_s_11 + _plus_4);
          }
          CompoundTask _ct = c.getCt();
          boolean _tripleNotEquals_1 = (_ct != null);
          if (_tripleNotEquals_1) {
            List<AtomicTask> atsub = tree.gv.getatomictasksinCT(c.getCt());
            for (final AtomicTask at : atsub) {
              String _s_12 = s;
              String _name_2 = at.getName();
              String _plus_5 = ("\n fact {all at: " + _name_2);
              String _plus_6 = (_plus_5 + "| one d: do.at | d in ");
              String _name_3 = c.getRobot().getName();
              String _plus_7 = (_plus_6 + _name_3);
              String _plus_8 = (_plus_7 + ".capability}");
              s = (_s_12 + _plus_8);
            }
          }
          MissionTask _mt = c.getMt();
          boolean _tripleNotEquals_2 = (_mt != null);
          if (_tripleNotEquals_2) {
            ArrayList<String> tintances = tree.gv.missionTask2atomicTasksInstances.get(c.getMt());
            for (final String i : tintances) {
              String _s_13 = s;
              String _name_4 = c.getRobot().getName();
              String _plus_9 = ((("\n fact { one d: do." + i) + " | d in ") + _name_4);
              String _plus_10 = (_plus_9 + ".capability}");
              s = (_s_13 + _plus_10);
            }
          }
        }
      }
      final Iterator<Closest> constrantListClosest = Iterators.<Closest>filter(resource.getAllContents(), Closest.class);
      while (constrantListClosest.hasNext()) {
        {
          final Closest c = constrantListClosest.next();
          String _all = c.getAll();
          boolean _tripleNotEquals = (_all != null);
          if (_tripleNotEquals) {
            atInstances = tree.gv.atLoc.keys();
            while (atInstances.hasMoreElements()) {
              {
                String i = atInstances.nextElement();
                Robot r_1 = tree.gv.getClosestRobot(i);
                String _s_11 = s;
                String _name = r_1.getName();
                String _plus_1 = ((("\n fact { one d: do." + i) + " | d in ") + _name);
                String _plus_2 = (_plus_1 + ".capability}");
                s = (_s_11 + _plus_2);
              }
            }
          } else {
            AtomicTask _at = c.getAt();
            boolean _tripleNotEquals_1 = (_at != null);
            if (_tripleNotEquals_1) {
              Enumeration<String> all_atInstances = tree.gv.atLoc.keys();
              while (all_atInstances.hasMoreElements()) {
                {
                  String i = all_atInstances.nextElement();
                  String _at_from_atInstance = tree.gv.at_from_atInstance(i);
                  AtomicTask _at_1 = c.getAt();
                  boolean _equals = Objects.equal(_at_from_atInstance, _at_1);
                  if (_equals) {
                    Robot r_1 = tree.gv.getClosestRobot(i);
                    String _s_11 = s;
                    String _name = r_1.getName();
                    String _plus_1 = ((("\n fact { one d: do." + i) + " | d in ") + _name);
                    String _plus_2 = (_plus_1 + ".capability}");
                    s = (_s_11 + _plus_2);
                  }
                }
              }
            } else {
              CompoundTask _ct = c.getCt();
              boolean _tripleNotEquals_2 = (_ct != null);
              if (_tripleNotEquals_2) {
                List<String> ctType_all_at_children_instances = tree.gv.getInstanceChildrenFromCTintance(c.getCt());
                for (final String i : ctType_all_at_children_instances) {
                  {
                    Robot r_1 = tree.gv.getClosestRobot(i);
                    String _s_11 = s;
                    String _name = r_1.getName();
                    String _plus_1 = ((("\n fact { one d: do." + i) + " | d in ") + _name);
                    String _plus_2 = (_plus_1 + ".capability}");
                    s = (_s_11 + _plus_2);
                  }
                }
              } else {
                MissionTask _mt = c.getMt();
                boolean _tripleNotEquals_3 = (_mt != null);
                if (_tripleNotEquals_3) {
                  Hashtable<MissionTask, ArrayList<String>> mission_atList = tree.gv.missionTask2atomicTasksInstances;
                  ArrayList<String> _get = mission_atList.get(c.getMt());
                  for (final String i_1 : _get) {
                    {
                      String iAT = tree.gv.at_from_atInstance(i_1);
                      Robot r_1 = tree.gv.getClosestRobot(iAT);
                      String _s_11 = s;
                      String _name = r_1.getName();
                      String _plus_1 = ((("\n fact { one d: do." + i_1) + " | d in ") + _name);
                      String _plus_2 = (_plus_1 + ".capability}");
                      s = (_s_11 + _plus_2);
                    }
                  }
                }
              }
            }
          }
        }
      }
      final Iterator<MaxTasks> constrantListMaxTasks = Iterators.<MaxTasks>filter(resource.getAllContents(), MaxTasks.class);
      while (constrantListMaxTasks.hasNext()) {
        {
          final MaxTasks c = constrantListMaxTasks.next();
          Robot _robot = c.getRobot();
          boolean _tripleNotEquals = (_robot != null);
          if (_tripleNotEquals) {
            String _s_11 = s;
            String _name = c.getRobot().getName();
            String _plus_1 = ("\n fact { all r:" + _name);
            String _plus_2 = (_plus_1 + " | #(r.capability.do ) <= ");
            int _num = c.getNum();
            String _plus_3 = (_plus_2 + Integer.valueOf(_num));
            String _plus_4 = (_plus_3 + "}");
            s = (_s_11 + _plus_4);
          } else {
            String _all = c.getAll();
            boolean _tripleNotEquals_1 = (_all != null);
            if (_tripleNotEquals_1) {
              String _all_1 = c.getAll();
              String _plus_5 = (" READ HERE WAHT IS IT: " + _all_1);
              InputOutput.<String>println(_plus_5);
              for (final Robot r_1 : rList) {
                String _s_12 = s;
                String _name_1 = r_1.getName();
                String _plus_6 = ("\n fact { all r:" + _name_1);
                String _plus_7 = (_plus_6 + " | #(r.capability.do ) <= ");
                int _num_1 = c.getNum();
                String _plus_8 = (_plus_7 + Integer.valueOf(_num_1));
                String _plus_9 = (_plus_8 + "}");
                s = (_s_12 + _plus_9);
              }
            }
          }
        }
      }
      String _s_11 = s;
      s = (_s_11 + "\n\n// ----------------RUN COMMAND:\n");
      String _s_12 = s;
      s = (_s_12 + "\nrun TaskAllocation for");
      String _s_13 = s;
      s = (_s_13 + (("\n" + Integer.valueOf(tree.gv.alloyIntScope)) + " Int,"));
      String _s_14 = s;
      s = (_s_14 + ((" " + Integer.valueOf(count_capabilities)) + " Capability,"));
      String _s_15 = s;
      final List<AtomicTask> _converted_at_missions = (List<AtomicTask>)at_missions;
      int _length_1 = ((Object[])Conversions.unwrapArray(_converted_at_missions, Object.class)).length;
      String _plus_1 = ((" " + "exactly ") + Integer.valueOf(_length_1));
      String _plus_2 = (_plus_1 + " AtomicTask,");
      s = (_s_15 + _plus_2);
      String _s_16 = s;
      int _length_2 = ((Object[])Conversions.unwrapArray(IterableExtensions.<Robot>toList(root.getRobotsModel()), Object.class)).length;
      String _plus_3 = (" " + Integer.valueOf(_length_2));
      String _plus_4 = (_plus_3 + " Robot");
      s = (_s_16 + _plus_4);
      tree.generateFile("modelAllocation.als", s);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Cast object -> int -> string
   */
  public static String cast2Int(final Double xy) {
    String s = xy.toString();
    int dot = s.indexOf(".");
    String integerPart = null;
    if ((dot != (-1))) {
      integerPart = s.substring(0, dot);
    } else {
      integerPart = "0";
    }
    return integerPart;
  }

  /**
   * number of robots
   */
  public static int getRobots_atName(final String at, final ProblemSpecification root) {
    EList<TasksModel> _tasksModel = root.getTasksModel();
    for (final TasksModel t : _tasksModel) {
      boolean _matched = false;
      if (t instanceof AtomicTask) {
        _matched=true;
        String _name = ((AtomicTask)t).getName();
        boolean _equals = Objects.equal(_name, at);
        if (_equals) {
          return ((AtomicTask)t).getRobots();
        }
      }
    }
    throw new UnsupportedOperationException(("ERROR: num of robots don\'t found for task " + at));
  }

  public static String readFile(final String filePath) throws IOException {
    Path path = Paths.get(filePath);
    System.out.println(path);
    return Files.readString(path);
  }
}
