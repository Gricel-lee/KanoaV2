package org.xtext.example.mydsl.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import dsl.AtomicTask;
import dsl.Capability;
import dsl.MaxTasks;
import dsl.ProblemSpecification;
import dsl.Robot;
import dsl.SpaceXYRobot;
import dsl.XY;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class AlloyFile {
  public static void createAlloyFile(final Preallocation tree, final Resource resource, final String path) {
    try {
      final GlobalVar gv = tree.gv;
      String path_sigAlloyDeclaration = path;
      String s = Aux.readFile((path_sigAlloyDeclaration + "sigAlloyDeclaration.txt"));
      final List<Robot> rList = IteratorExtensions.<Robot>toList(Iterators.<Robot>filter(resource.getAllContents(), Robot.class));
      List<AtomicTask> at_missions = Aux.at_in_mission(gv);
      Set<AtomicTask> at_unique = new HashSet<AtomicTask>(at_missions);
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
          int _robots_atName = Aux.getRobots_atName(at.getName(), root);
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
      Set<String> _keySet = gv.atomicList.keySet();
      for (final String atInstance : _keySet) {
        {
          String x = Aux.cast2Int(Double.valueOf(gv.atomicList.get(atInstance).loc.getX()));
          String y = Aux.cast2Int(Double.valueOf(gv.atomicList.get(atInstance).loc.getY()));
          String at = gv.atomicList.get(atInstance).at.getName();
          String _s_7 = s;
          s = (_s_7 + (((("\none sig " + atInstance) + " extends ") + at) + "{}"));
          String _s_8 = s;
          String _name = gv.atomicList.get(atInstance).loc.getName();
          String _plus_1 = (((((" {x=" + x) + " y=") + y) + "} //do at location ") + _name);
          s = (_s_8 + _plus_1);
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
      final List<SpaceXYRobot> constrantListXY = IteratorExtensions.<SpaceXYRobot>toList(Iterators.<SpaceXYRobot>filter(gv.resource.getAllContents(), SpaceXYRobot.class));
      for (final SpaceXYRobot c : constrantListXY) {
        {
          String lg = "";
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
          String _cast2Int = Aux.cast2Int(Double.valueOf(v));
          String _plus_6 = (_plus_5 + _cast2Int);
          String _plus_7 = (_plus_6 + "}");
          s = (_s_11 + _plus_7);
        }
      }
      Set<String> _keySet_1 = gv.atomicList.keySet();
      for (final String atID : _keySet_1) {
        {
          AtomicTaskinstance atInstance_1 = gv.atomicList.get(atID);
          if ((atInstance_1.robot != null)) {
            String _s_11 = s;
            String _name = atInstance_1.robot.getName();
            String _plus_1 = ((("\n fact {all at: " + atID) + "| one d: do.at | d in ") + _name);
            String _plus_2 = (_plus_1 + ".capability}");
            s = (_s_11 + _plus_2);
          }
        }
      }
      final Iterator<MaxTasks> constrantListMaxTasks = Iterators.<MaxTasks>filter(resource.getAllContents(), MaxTasks.class);
      while (constrantListMaxTasks.hasNext()) {
        {
          final MaxTasks c_1 = constrantListMaxTasks.next();
          Robot _robot = c_1.getRobot();
          boolean _tripleNotEquals = (_robot != null);
          if (_tripleNotEquals) {
            String _s_11 = s;
            String _name = c_1.getRobot().getName();
            String _plus_1 = ("\n fact { all r:" + _name);
            String _plus_2 = (_plus_1 + " | #(r.capability.do ) <= ");
            int _num = c_1.getNum();
            String _plus_3 = (_plus_2 + Integer.valueOf(_num));
            String _plus_4 = (_plus_3 + "}");
            s = (_s_11 + _plus_4);
          } else {
            String _all = c_1.getAll();
            boolean _tripleNotEquals_1 = (_all != null);
            if (_tripleNotEquals_1) {
              for (final Robot r_1 : rList) {
                String _s_12 = s;
                String _name_1 = r_1.getName();
                String _plus_5 = ("\n fact { all r:" + _name_1);
                String _plus_6 = (_plus_5 + " | #(r.capability.do ) <= ");
                int _num_1 = c_1.getNum();
                String _plus_7 = (_plus_6 + Integer.valueOf(_num_1));
                String _plus_8 = (_plus_7 + "}");
                s = (_s_12 + _plus_8);
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
      Integer _alloyIntScope = Aux.getAlloyIntScope(gv);
      String _plus_1 = ("\n" + _alloyIntScope);
      String _plus_2 = (_plus_1 + " Int,");
      s = (_s_13 + _plus_2);
      String _s_14 = s;
      s = (_s_14 + ((" " + Integer.valueOf(count_capabilities)) + " Capability,"));
      String _s_15 = s;
      final List<AtomicTask> _converted_at_missions = (List<AtomicTask>)at_missions;
      int _length_1 = ((Object[])Conversions.unwrapArray(_converted_at_missions, Object.class)).length;
      String _plus_3 = ((" " + "exactly ") + Integer.valueOf(_length_1));
      String _plus_4 = (_plus_3 + " AtomicTask,");
      s = (_s_15 + _plus_4);
      String _s_16 = s;
      int _length_2 = ((Object[])Conversions.unwrapArray(IterableExtensions.<Robot>toList(root.getRobotsModel()), Object.class)).length;
      String _plus_5 = (" " + Integer.valueOf(_length_2));
      String _plus_6 = (_plus_5 + " Robot");
      s = (_s_16 + _plus_6);
      Aux.generateFile("modelAllocation.als", s, gv);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
