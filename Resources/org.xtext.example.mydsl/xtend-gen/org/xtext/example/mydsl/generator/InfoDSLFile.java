package org.xtext.example.mydsl.generator;

import com.google.common.collect.Iterators;
import dsl.AtomicTask;
import dsl.Capability;
import dsl.CompoundTask;
import dsl.Location;
import dsl.Mission;
import dsl.Paths;
import dsl.RateSucc;
import dsl.Robot;
import dsl.TasksModel;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class InfoDSLFile {
  /**
   * Example of info in this file: (the last 5 are optional)
   * loc,l1,2.0,3.0
   * loc,l2,1.0,7.0
   * path,l1,l2,3.0
   * path,l1,room1,31.0
   * at,at1,2,l1
   * at,at2,1,l1
   * ct,ct1,[at3,at2,],false,false
   * ct,ct2,[at4,ct1,],true,false
   * robot,r1,l1,{[at2,5.0,99.0][at3,4.0,99.0][at4,2.0,99.0]}
   * robot,r5,l5,{[at1,4.0,99.0]}
   * objectives,[minIdle, minTravel, maxSucc]
   * time,120
   * numAlloc,10
   * population,100
   * evaluations,20
   * ratesucc,95.0
   */
  public static void createFile(final Preallocation tree, final Resource resource, final String path) {
    GlobalVar gv = tree.gv;
    String s = "";
    final List<Location> loc = IteratorExtensions.<Location>toList(Iterators.<Location>filter(gv.resource.getAllContents(), Location.class));
    for (final Location l : loc) {
      String _s = s;
      String _name = l.getName();
      String _plus = ("loc,," + _name);
      String _plus_1 = (_plus + ",,");
      double _x = l.getX();
      String _plus_2 = (_plus_1 + Double.valueOf(_x));
      String _plus_3 = (_plus_2 + ",,");
      double _y = l.getY();
      String _plus_4 = (_plus_3 + Double.valueOf(_y));
      String _plus_5 = (_plus_4 + "\n");
      s = (_s + _plus_5);
    }
    final List<Paths> paths = IteratorExtensions.<Paths>toList(Iterators.<Paths>filter(gv.resource.getAllContents(), Paths.class));
    for (final Paths p : paths) {
      String _s_1 = s;
      String _name_1 = p.getLoc1().getName();
      String _plus_6 = ("path,," + _name_1);
      String _plus_7 = (_plus_6 + ",,");
      String _name_2 = p.getLoc2().getName();
      String _plus_8 = (_plus_7 + _name_2);
      String _plus_9 = (_plus_8 + ",,");
      String _valueOf = String.valueOf(p.getDistance());
      String _plus_10 = (_plus_9 + _valueOf);
      String _plus_11 = (_plus_10 + "\n");
      s = (_s_1 + _plus_11);
    }
    final List<AtomicTask> ats = IteratorExtensions.<AtomicTask>toList(Iterators.<AtomicTask>filter(gv.resource.getAllContents(), AtomicTask.class));
    for (final AtomicTask at : ats) {
      String _s_2 = s;
      String _name_3 = at.getName();
      String _plus_12 = ("at,," + _name_3);
      String _plus_13 = (_plus_12 + ",,");
      int _robots = at.getRobots();
      String _plus_14 = (_plus_13 + Integer.valueOf(_robots));
      String _plus_15 = (_plus_14 + ",,");
      String _name_4 = at.getLoc().getName();
      String _plus_16 = (_plus_15 + _name_4);
      String _plus_17 = (_plus_16 + "\n");
      s = (_s_2 + _plus_17);
    }
    final List<CompoundTask> cts = IteratorExtensions.<CompoundTask>toList(Iterators.<CompoundTask>filter(gv.resource.getAllContents(), CompoundTask.class));
    String subt = "";
    for (final CompoundTask ct : cts) {
      {
        subt = "[";
        List<TasksModel> _list = IterableExtensions.<TasksModel>toList(ct.getCanDoTask());
        for (final TasksModel a : _list) {
          boolean _matched = false;
          if (a instanceof AtomicTask) {
            _matched=true;
            String _subt = subt;
            String _name_5 = ((AtomicTask)a).getName();
            String _plus_18 = (_name_5 + ",");
            subt = (_subt + _plus_18);
          }
          if (!_matched) {
            if (a instanceof CompoundTask) {
              _matched=true;
              String _subt = subt;
              String _name_5 = ((CompoundTask)a).getName();
              String _plus_18 = (_name_5 + ",");
              subt = (_subt + _plus_18);
            }
          }
        }
        int _length = subt.length();
        int _minus = (_length - 1);
        subt = subt.substring(0, _minus);
        String _s_3 = s;
        String _name_5 = ct.getName();
        String _plus_18 = ("ct,," + _name_5);
        String _plus_19 = (_plus_18 + ",,");
        String _plus_20 = (_plus_19 + subt);
        String _plus_21 = (_plus_20 + "],,");
        boolean _isOrdered = ct.isOrdered();
        String _plus_22 = (_plus_21 + Boolean.valueOf(_isOrdered));
        String _plus_23 = (_plus_22 + ",,");
        boolean _isConsecutive = ct.isConsecutive();
        String _plus_24 = (_plus_23 + Boolean.valueOf(_isConsecutive));
        String _plus_25 = (_plus_24 + "\n");
        s = (_s_3 + _plus_25);
      }
    }
    final List<Robot> robs = IteratorExtensions.<Robot>toList(Iterators.<Robot>filter(gv.resource.getAllContents(), Robot.class));
    for (final Robot r : robs) {
      {
        String _s_3 = s;
        String _name_5 = r.getName();
        String _plus_18 = ("robot,," + _name_5);
        String _plus_19 = (_plus_18 + ",,");
        String _name_6 = r.getInitLoc().getName();
        String _plus_20 = (_plus_19 + _name_6);
        String _plus_21 = (_plus_20 + ",,");
        String _plus_22 = (_plus_21 + "{");
        s = (_s_3 + _plus_22);
        EList<Capability> _capabilities = r.getCapabilities();
        for (final Capability c : _capabilities) {
          String _s_4 = s;
          String _name_7 = c.getAt().getName();
          String _plus_23 = ("[" + _name_7);
          String _plus_24 = (_plus_23 + ",");
          double _time = c.getTime();
          String _plus_25 = (_plus_24 + Double.valueOf(_time));
          String _plus_26 = (_plus_25 + ",");
          double _success = c.getSuccess();
          String _plus_27 = (_plus_26 + Double.valueOf(_success));
          String _plus_28 = (_plus_27 + "]");
          s = (_s_4 + _plus_28);
        }
        String _s_5 = s;
        double _velocity = r.getVelocity();
        String _plus_29 = (("}" + ",,") + Double.valueOf(_velocity));
        String _plus_30 = (_plus_29 + "\n");
        s = (_s_5 + _plus_30);
      }
    }
    final List<Mission> ms = IteratorExtensions.<Mission>toList(Iterators.<Mission>filter(gv.resource.getAllContents(), Mission.class));
    for (final Mission m : ms) {
      {
        String _s_3 = s;
        String _string = m.getObj().toString();
        String _plus_18 = ("objectives,," + _string);
        String _plus_19 = (_plus_18 + "\n");
        s = (_s_3 + _plus_19);
        int _time = m.getTime();
        boolean _tripleNotEquals = (_time != 0);
        if (_tripleNotEquals) {
          String _s_4 = s;
          int _time_1 = m.getTime();
          String _plus_20 = ("time,," + Integer.valueOf(_time_1));
          String _plus_21 = (_plus_20 + "\n");
          s = (_s_4 + _plus_21);
        }
        int _numAlloc = m.getNumAlloc();
        boolean _tripleNotEquals_1 = (_numAlloc != 0);
        if (_tripleNotEquals_1) {
          String _s_5 = s;
          int _numAlloc_1 = m.getNumAlloc();
          String _plus_22 = ("numAlloc,," + Integer.valueOf(_numAlloc_1));
          String _plus_23 = (_plus_22 + "\n");
          s = (_s_5 + _plus_23);
        }
        int _population = m.getPopulation();
        boolean _tripleNotEquals_2 = (_population != 0);
        if (_tripleNotEquals_2) {
          String _s_6 = s;
          int _population_1 = m.getPopulation();
          String _plus_24 = ("population,," + Integer.valueOf(_population_1));
          String _plus_25 = (_plus_24 + "\n");
          s = (_s_6 + _plus_25);
        }
        int _evaluations = m.getEvaluations();
        boolean _tripleNotEquals_3 = (_evaluations != 0);
        if (_tripleNotEquals_3) {
          String _s_7 = s;
          int _evaluations_1 = m.getEvaluations();
          String _plus_26 = ("evaluations,," + Integer.valueOf(_evaluations_1));
          String _plus_27 = (_plus_26 + "\n");
          s = (_s_7 + _plus_27);
        }
      }
    }
    final List<RateSucc> rs = IteratorExtensions.<RateSucc>toList(Iterators.<RateSucc>filter(gv.resource.getAllContents(), RateSucc.class));
    boolean _isEmpty = rs.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      String _s_3 = s;
      double _rateSucc = rs.get(0).getRateSucc();
      String _plus_18 = ("ratesucc,," + Double.valueOf(_rateSucc));
      String _plus_19 = (_plus_18 + "\n");
      s = (_s_3 + _plus_19);
    }
    int _length = s.length();
    int _minus = (_length - 1);
    s = s.substring(0, _minus);
    Aux.generateFile("infoDSL.txt", s, tree.gv);
  }
}
