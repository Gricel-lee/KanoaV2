/**
 * Author: Gricel Vazquez
 * Date: 10-02-2022
 */
package org.xtext.example.mydsl.generator;

import com.google.common.base.Objects;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.xtext.example.mydsl.myDsl.AllRobotsDeploy;
import org.xtext.example.mydsl.myDsl.AllRobotsX;
import org.xtext.example.mydsl.myDsl.AllRobotsXX;
import org.xtext.example.mydsl.myDsl.AtomicTask;
import org.xtext.example.mydsl.myDsl.AtomicTaskLoc;
import org.xtext.example.mydsl.myDsl.AtomicTaskNoLoc;
import org.xtext.example.mydsl.myDsl.CompTaskNoLoc;
import org.xtext.example.mydsl.myDsl.CompTaskOneLoc;
import org.xtext.example.mydsl.myDsl.CompoundTask;
import org.xtext.example.mydsl.myDsl.Location;
import org.xtext.example.mydsl.myDsl.Mission;
import org.xtext.example.mydsl.myDsl.NumAllocations;
import org.xtext.example.mydsl.myDsl.NumEvaluations;
import org.xtext.example.mydsl.myDsl.NumPopulation;
import org.xtext.example.mydsl.myDsl.Paths;
import org.xtext.example.mydsl.myDsl.ProblemSpecification;
import org.xtext.example.mydsl.myDsl.QoS;
import org.xtext.example.mydsl.myDsl.Robot;
import org.xtext.example.mydsl.myDsl.Robots2tasksPerformance;
import org.xtext.example.mydsl.myDsl.RobotsX;
import org.xtext.example.mydsl.myDsl.RobotsXX;
import org.xtext.example.mydsl.myDsl.TasksModel;
import org.xtext.example.mydsl.myDsl.WorldModel;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class MyDslGenerator extends AbstractGenerator {
  private String s = "";

  private String s_cap = "";

  private String s_fact = "";

  private int count_capabilities = 0;

  private String p = System.getProperty("user.dir");

  private String path_sigAlloyDeclaration = "//Users//grisv//GitHub//KanoaV2//Resources//org.xtext.example.mydsl//src//org//xtext//example//mydsl//generator//";

  private int alloyIntScope = 7;

  private String dfAllocation = "id,,parent,,ordered_children,,location,,runbyrobot,,joint,,ordered,,consecutive";

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    try {
      TreeIterator<EObject> _allContents = null;
      if (resource!=null) {
        _allContents=resource.getAllContents();
      }
      EObject _head = null;
      if (_allContents!=null) {
        _head=IteratorExtensions.<EObject>head(_allContents);
      }
      final ProblemSpecification root = ((ProblemSpecification) _head);
      String _s = this.s;
      String _readFile = MyDslGenerator.readFile((this.path_sigAlloyDeclaration + "sigAlloyDeclaration.txt"));
      this.s = (_s + _readFile);
      List<AtomicTask> at_missions = new ArrayList<AtomicTask>();
      List<Double> at_x = new ArrayList<Double>();
      List<Double> at_y = new ArrayList<Double>();
      List at_r = new ArrayList<Object>();
      Set<AtomicTask> at_unique = null;
      int countATpython = 0;
      int countCTpython = 0;
      List<Mission> _list = IterableExtensions.<Mission>toList(root.getMission());
      for (final Mission m : _list) {
        boolean _matched = false;
        if (m instanceof AtomicTaskNoLoc) {
          _matched=true;
          Location loc = this.findATloc(((AtomicTaskNoLoc)m).getAt(), root);
          at_missions.add(((AtomicTaskNoLoc)m).getAt());
          at_x.add(Double.valueOf(loc.getX()));
          at_y.add(Double.valueOf(loc.getY()));
          at_r.add(Integer.valueOf(((AtomicTaskNoLoc)m).getAt().getRobots()));
          String id = ((AtomicTaskNoLoc)m).getName();
          String par = "NaN";
          String _name = ((AtomicTaskNoLoc)m).getAt().getName();
          String _plus = ("[\'" + _name);
          String _plus_1 = (_plus + "_");
          String _plus_2 = (_plus_1 + Integer.valueOf(countATpython));
          String child = (_plus_2 + "\']");
          String runbyrobot = "NaN";
          String joint = "NaN";
          String order = "NaN";
          String consec = "NaN";
          String location = "NaN";
          String _dfAllocation = this.dfAllocation;
          String _missionTreeString = this.missionTreeString(id, par, child, location, runbyrobot, joint, order, consec);
          this.dfAllocation = (_dfAllocation + _missionTreeString);
          String _name_1 = ((AtomicTaskNoLoc)m).getAt().getName();
          String _plus_3 = (_name_1 + "_");
          String _plus_4 = (_plus_3 + Integer.valueOf(countATpython));
          id = _plus_4;
          par = ((AtomicTaskNoLoc)m).getName();
          child = "NaN";
          joint = this.Joint(((AtomicTaskNoLoc)m).getAt());
          location = loc.getName();
          String _dfAllocation_1 = this.dfAllocation;
          String _missionTreeString_1 = this.missionTreeString(id, par, child, location, runbyrobot, joint, order, consec);
          this.dfAllocation = (_dfAllocation_1 + _missionTreeString_1);
          int _countATpython = countATpython;
          countATpython = (_countATpython + 1);
        }
        if (!_matched) {
          if (m instanceof AtomicTaskLoc) {
            _matched=true;
            Location loc = ((AtomicTaskLoc)m).getLoc();
            at_missions.add(((AtomicTaskLoc)m).getAt());
            at_x.add(Double.valueOf(loc.getX()));
            at_y.add(Double.valueOf(loc.getY()));
            at_r.add(Integer.valueOf(((AtomicTaskLoc)m).getAt().getRobots()));
            String id = ((AtomicTaskLoc)m).getName();
            String par = "NaN";
            String _name = ((AtomicTaskLoc)m).getAt().getName();
            String _plus = ("[\'" + _name);
            String _plus_1 = (_plus + "_");
            String _plus_2 = (_plus_1 + Integer.valueOf(countATpython));
            String child = (_plus_2 + "\']");
            String runbyrobot = "NaN";
            String joint = "NaN";
            String order = "NaN";
            String consec = "NaN";
            String location = "NaN";
            String _dfAllocation = this.dfAllocation;
            String _missionTreeString = this.missionTreeString(id, par, child, location, runbyrobot, joint, order, consec);
            this.dfAllocation = (_dfAllocation + _missionTreeString);
            String _name_1 = ((AtomicTaskLoc)m).getAt().getName();
            String _plus_3 = (_name_1 + "_");
            String _plus_4 = (_plus_3 + Integer.valueOf(countATpython));
            id = _plus_4;
            par = ((AtomicTaskLoc)m).getName();
            child = "NaN";
            joint = this.Joint(((AtomicTaskLoc)m).getAt());
            location = loc.getName();
            String _dfAllocation_1 = this.dfAllocation;
            String _missionTreeString_1 = this.missionTreeString(id, par, child, location, runbyrobot, joint, order, consec);
            this.dfAllocation = (_dfAllocation_1 + _missionTreeString_1);
            int _countATpython = countATpython;
            countATpython = (_countATpython + 1);
          }
        }
        if (!_matched) {
          if (m instanceof CompTaskNoLoc) {
            _matched=true;
            String id = ((CompTaskNoLoc)m).getName();
            String par = "NaN";
            String _name = ((CompTaskNoLoc)m).getCt().getName();
            String _plus = (" [\'" + _name);
            String _plus_1 = (_plus + "_");
            String _plus_2 = (_plus_1 + Integer.valueOf(countCTpython));
            String child = (_plus_2 + "\']");
            String runbyrobot = "NaN";
            String joint = "NaN";
            String order = "NaN";
            String consec = "NaN";
            String location = "NaN";
            String _dfAllocation = this.dfAllocation;
            String _missionTreeString = this.missionTreeString(id, par, child, location, runbyrobot, joint, order, consec);
            this.dfAllocation = (_dfAllocation + _missionTreeString);
            Location loc = this.findCTOneloc(((CompTaskNoLoc)m).getCt(), root);
            List a = this.getCtSubtasksDF(countATpython, countCTpython, ((CompTaskNoLoc)m).getCt(), root, ((CompTaskNoLoc)m).getName(), loc.getName());
            String _dfAllocation_1 = this.dfAllocation;
            Object _get = a.get(0);
            this.dfAllocation = (_dfAllocation_1 + _get);
            Object _get_1 = a.get(1);
            countATpython = (((Integer) _get_1)).intValue();
            Object _get_2 = a.get(2);
            countCTpython = (((Integer) _get_2)).intValue();
            List<AtomicTask> ATsubtasks = this.getCtSubtasks(((CompTaskNoLoc)m).getCt(), root);
            for (final AtomicTask at : ATsubtasks) {
              {
                at_missions.add(at);
                at_x.add(Double.valueOf(loc.getX()));
                at_y.add(Double.valueOf(loc.getY()));
                at_r.add(Integer.valueOf(at.getRobots()));
              }
            }
          }
        }
        if (!_matched) {
          if (m instanceof CompTaskOneLoc) {
            _matched=true;
            String id = ((CompTaskOneLoc)m).getName();
            String par = "NaN";
            String _name = ((CompTaskOneLoc)m).getCt().getName();
            String _plus = (" [\'" + _name);
            String _plus_1 = (_plus + "_");
            String _plus_2 = (_plus_1 + Integer.valueOf(countCTpython));
            String child = (_plus_2 + "\']");
            String runbyrobot = "NaN";
            String joint = "NaN";
            String order = "NaN";
            String consec = "NaN";
            String location = "NaN";
            String _dfAllocation = this.dfAllocation;
            String _missionTreeString = this.missionTreeString(id, par, child, location, runbyrobot, joint, order, consec);
            this.dfAllocation = (_dfAllocation + _missionTreeString);
            Location loc = ((CompTaskOneLoc)m).getLoc();
            List a = this.getCtSubtasksDF(countATpython, countCTpython, ((CompTaskOneLoc)m).getCt(), root, ((CompTaskOneLoc)m).getName(), loc.getName());
            String _dfAllocation_1 = this.dfAllocation;
            Object _get = a.get(0);
            this.dfAllocation = (_dfAllocation_1 + _get);
            Object _get_1 = a.get(1);
            countATpython = (((Integer) _get_1)).intValue();
            Object _get_2 = a.get(2);
            int _plus_3 = ((((Integer) _get_2)).intValue() + 1);
            countCTpython = _plus_3;
            List<AtomicTask> ATsubtasks = this.getCtSubtasks(((CompTaskOneLoc)m).getCt(), root);
            for (final AtomicTask at : ATsubtasks) {
              {
                at_missions.add(at);
                at_x.add(Double.valueOf(loc.getX()));
                at_y.add(Double.valueOf(loc.getY()));
                at_r.add(Integer.valueOf(at.getRobots()));
              }
            }
          }
        }
      }
      this.generateFile("modelMissionsTree.txt", this.dfAllocation, fsa);
      this.dfAllocation = "";
      HashSet<AtomicTask> _hashSet = new HashSet<AtomicTask>(at_missions);
      at_unique = _hashSet;
      String s_r = "";
      String _s_1 = this.s;
      this.s = (_s_1 + "\n\n// ----------------ROBOTS:\n");
      List<Robot> _list_1 = IterableExtensions.<Robot>toList(root.getRobotsModel().getRobots());
      for (final Robot r : _list_1) {
        {
          String _s_2 = this.s;
          String _name = r.getName();
          String _plus = ("\nsig " + _name);
          String _plus_1 = (_plus + " extends Robot{}\n");
          this.s = (_s_2 + _plus_1);
          String _s_3 = this.s;
          this.s = (_s_3 + "{disj[capability ,  Capability");
          String _name_1 = r.getName();
          String _plus_2 = ("#" + _name_1);
          String _plus_3 = (_plus_2 + "<=1 and");
          s_r = _plus_3;
          List<Robots2tasksPerformance> _list_2 = IterableExtensions.<Robots2tasksPerformance>toList(r.getRobots2tasksPerformance());
          for (final Robots2tasksPerformance t : _list_2) {
            boolean _contains = at_unique.contains(t.getAt());
            if (_contains) {
              String _s_4 = this.s;
              String _name_2 = r.getName();
              String _plus_4 = ("-" + _name_2);
              String _name_3 = t.getAt().getName();
              String _plus_5 = (_plus_4 + _name_3);
              this.s = (_s_4 + _plus_5);
              String _s_cap = this.s_cap;
              String _name_4 = r.getName();
              String _plus_6 = ("\nsig " + _name_4);
              String _name_5 = t.getAt().getName();
              String _plus_7 = (_plus_6 + _name_5);
              String _plus_8 = (_plus_7 + " extends Capability{}\n");
              this.s_cap = (_s_cap + _plus_8);
              String _s_cap_1 = this.s_cap;
              String _name_6 = t.getAt().getName();
              String _plus_9 = ("{all d:do | d in " + _name_6);
              String _plus_10 = (_plus_9 + "}");
              this.s_cap = (_s_cap_1 + _plus_10);
              String _s_fact = this.s_fact;
              String _name_7 = r.getName();
              String _plus_11 = ("#" + _name_7);
              String _name_8 = t.getAt().getName();
              String _plus_12 = (_plus_11 + _name_8);
              String _plus_13 = (_plus_12 + "<=1\n");
              this.s_fact = (_s_fact + _plus_13);
              int _count_capabilities = this.count_capabilities;
              this.count_capabilities = (_count_capabilities + 1);
            }
          }
          String _s_5 = this.s;
          this.s = (_s_5 + "]}");
          String _s_6 = this.s;
          int _length = s_r.length();
          int _minus = (_length - 4);
          String _substring = s_r.substring(0, _minus);
          String _plus_14 = ("\nfact{" + _substring);
          String _plus_15 = (_plus_14 + "}");
          this.s = (_s_6 + _plus_15);
        }
      }
      String _s_2 = this.s;
      this.s = (_s_2 + "\n\n// ----------------CAPABILITIES:\n");
      String _s_3 = this.s;
      this.s = (_s_3 + this.s_cap);
      String _s_4 = this.s;
      this.s = (_s_4 + (("\n\nfact{" + this.s_fact) + "} // robot capabilities appear once (if robot appears, and if capab. tasks assigned)"));
      String _s_5 = this.s;
      this.s = (_s_5 + "\n\n// ----------------ATOMIC TASKS:\n");
      String _s_6 = this.s;
      this.s = (_s_6 + ("\n" + "abstract sig "));
      String s_t = "";
      String s_f = "";
      for (int i = 0; (i < ((Object[])Conversions.unwrapArray(at_unique, Object.class)).length); i++) {
        {
          final Set<AtomicTask> _converted_at_unique = (Set<AtomicTask>)at_unique;
          String at = (((AtomicTask[])Conversions.unwrapArray(_converted_at_unique, AtomicTask.class))[i]).getName();
          String _s_t = s_t;
          s_t = (_s_t + (at + ","));
          String _s_f = s_f;
          int _robots_atName = this.getRobots_atName(at, root);
          String _plus = ((("\nfact{all a:" + at) + " | #do.a=") + Integer.valueOf(_robots_atName));
          String _plus_1 = (_plus + "}\t// number of robots needed");
          s_f = (_s_f + _plus_1);
        }
      }
      String _s_7 = this.s;
      int _length = s_t.length();
      int _minus = (_length - 1);
      String _substring = s_t.substring(0, _minus);
      String _plus = (_substring + " extends AtomicTask {}");
      this.s = (_s_7 + _plus);
      String _s_8 = this.s;
      this.s = (_s_8 + s_f);
      for (int i = 0; (i < ((Object[])Conversions.unwrapArray(at_missions, Object.class)).length); i++) {
        {
          String _s_9 = this.s;
          String _name = at_missions.get(i).getName();
          String _plus_1 = ("\nsig " + _name);
          String _plus_2 = (_plus_1 + "_");
          String _plus_3 = (_plus_2 + Integer.valueOf(i));
          String _plus_4 = (_plus_3 + " extends ");
          String _name_1 = at_missions.get(i).getName();
          String _plus_5 = (_plus_4 + _name_1);
          String _plus_6 = (_plus_5 + "{}");
          this.s = (_s_9 + _plus_6);
          String x = this.cast2IntXY(at_x.get(i));
          String y = this.cast2IntXY(at_y.get(i));
          String _s_10 = this.s;
          this.s = (_s_10 + (((("\n{x=" + x) + "\ny=") + y) + "}"));
        }
      }
      String _s_9 = this.s;
      this.s = (_s_9 + "\n\n// ----------------PREDICATE:\n");
      String _s_10 = this.s;
      this.s = (_s_10 + "\npred TaskAllocation{");
      String _s_11 = this.s;
      this.s = (_s_11 + "\n}");
      String _s_12 = this.s;
      this.s = (_s_12 + "\n\n// ----------------CONSTRAINTS:\n");
      int checkAllRobotDeployed = 0;
      EList<QoS> _qos = root.getQos();
      for (final QoS q : _qos) {
        boolean _matched_1 = false;
        if (q instanceof AllRobotsXX) {
          _matched_1=true;
          String _s_13 = this.s;
          String _coordinate = ((AllRobotsXX)q).getCoordinate();
          String _plus_1 = ("\nfact{no r:Robot | r.capability.do." + _coordinate);
          String _plus_2 = (_plus_1 + "<");
          String _cast2IntXY = this.cast2IntXY(Double.valueOf(((AllRobotsXX)q).getXy1()));
          String _plus_3 = (_plus_2 + _cast2IntXY);
          String _plus_4 = (_plus_3 + " or r.capability.do.");
          String _coordinate_1 = ((AllRobotsXX)q).getCoordinate();
          String _plus_5 = (_plus_4 + _coordinate_1);
          String _plus_6 = (_plus_5 + ">");
          String _cast2IntXY_1 = this.cast2IntXY(Double.valueOf(((AllRobotsXX)q).getXy2()));
          String _plus_7 = (_plus_6 + _cast2IntXY_1);
          String _plus_8 = (_plus_7 + "} // [");
          String _coordinate_2 = ((AllRobotsXX)q).getCoordinate();
          String _plus_9 = (_plus_8 + _coordinate_2);
          String _plus_10 = (_plus_9 + "1,");
          String _coordinate_3 = ((AllRobotsXX)q).getCoordinate();
          String _plus_11 = (_plus_10 + _coordinate_3);
          String _plus_12 = (_plus_11 + "2] constraint over all robots");
          this.s = (_s_13 + _plus_12);
        }
        if (!_matched_1) {
          if (q instanceof AllRobotsX) {
            _matched_1=true;
            String sign = "";
            String _type = ((AllRobotsX)q).getType();
            boolean _equals = Objects.equal(_type, "greater than");
            if (_equals) {
              sign = "<=";
            } else {
              String _type_1 = ((AllRobotsX)q).getType();
              boolean _equals_1 = Objects.equal(_type_1, "lower than");
              if (_equals_1) {
                sign = ">=";
              } else {
                String _type_2 = ((AllRobotsX)q).getType();
                boolean _equals_2 = Objects.equal(_type_2, "geq");
                if (_equals_2) {
                  sign = "<";
                } else {
                  String _type_3 = ((AllRobotsX)q).getType();
                  boolean _equals_3 = Objects.equal(_type_3, "leq");
                  if (_equals_3) {
                    sign = ">";
                  }
                }
              }
            }
            String _s_13 = this.s;
            String _coordinate = ((AllRobotsX)q).getCoordinate();
            String _plus_1 = ("\nfact{no r:Robot | r.capability.do." + _coordinate);
            String _plus_2 = (_plus_1 + sign);
            String _cast2IntXY = this.cast2IntXY(Double.valueOf(((AllRobotsX)q).getXy()));
            String _plus_3 = (_plus_2 + _cast2IntXY);
            String _plus_4 = (_plus_3 + "} // ");
            String _coordinate_1 = ((AllRobotsX)q).getCoordinate();
            String _plus_5 = (_plus_4 + _coordinate_1);
            String _plus_6 = (_plus_5 + " constraint over all robots");
            this.s = (_s_13 + _plus_6);
          }
        }
        if (!_matched_1) {
          if (q instanceof RobotsXX) {
            _matched_1=true;
            String _s_13 = this.s;
            String _name = ((RobotsXX)q).getRobot().getName();
            String _plus_1 = ("\nfact{no r:" + _name);
            String _plus_2 = (_plus_1 + " | r.capability.do.");
            String _coordinate = ((RobotsXX)q).getCoordinate();
            String _plus_3 = (_plus_2 + _coordinate);
            String _plus_4 = (_plus_3 + "<");
            String _cast2IntXY = this.cast2IntXY(Double.valueOf(((RobotsXX)q).getXy1()));
            String _plus_5 = (_plus_4 + _cast2IntXY);
            String _plus_6 = (_plus_5 + " or r.capability.do.");
            String _coordinate_1 = ((RobotsXX)q).getCoordinate();
            String _plus_7 = (_plus_6 + _coordinate_1);
            String _plus_8 = (_plus_7 + ">");
            String _cast2IntXY_1 = this.cast2IntXY(Double.valueOf(((RobotsXX)q).getXy2()));
            String _plus_9 = (_plus_8 + _cast2IntXY_1);
            String _plus_10 = (_plus_9 + "} // [");
            String _coordinate_2 = ((RobotsXX)q).getCoordinate();
            String _plus_11 = (_plus_10 + _coordinate_2);
            String _plus_12 = (_plus_11 + "1,");
            String _coordinate_3 = ((RobotsXX)q).getCoordinate();
            String _plus_13 = (_plus_12 + _coordinate_3);
            String _plus_14 = (_plus_13 + "2] constraint ");
            this.s = (_s_13 + _plus_14);
          }
        }
        if (!_matched_1) {
          if (q instanceof RobotsX) {
            _matched_1=true;
            String sign = "";
            String _type = ((RobotsX)q).getType();
            boolean _equals = Objects.equal(_type, "greater than");
            if (_equals) {
              sign = "<=";
            } else {
              String _type_1 = ((RobotsX)q).getType();
              boolean _equals_1 = Objects.equal(_type_1, "lower than");
              if (_equals_1) {
                sign = ">=";
              } else {
                String _type_2 = ((RobotsX)q).getType();
                boolean _equals_2 = Objects.equal(_type_2, "geq");
                if (_equals_2) {
                  sign = "<";
                } else {
                  String _type_3 = ((RobotsX)q).getType();
                  boolean _equals_3 = Objects.equal(_type_3, "leq");
                  if (_equals_3) {
                    sign = ">";
                  }
                }
              }
            }
            String _s_13 = this.s;
            String _name = ((RobotsX)q).getRobot().getName();
            String _plus_1 = ("\nfact{no r:" + _name);
            String _plus_2 = (_plus_1 + " | r.capability.do.");
            String _coordinate = ((RobotsX)q).getCoordinate();
            String _plus_3 = (_plus_2 + _coordinate);
            String _plus_4 = (_plus_3 + sign);
            String _cast2IntXY = this.cast2IntXY(Double.valueOf(((RobotsX)q).getXy()));
            String _plus_5 = (_plus_4 + _cast2IntXY);
            String _plus_6 = (_plus_5 + "} // ");
            String _coordinate_1 = ((RobotsX)q).getCoordinate();
            String _plus_7 = (_plus_6 + _coordinate_1);
            String _plus_8 = (_plus_7 + " constraint");
            this.s = (_s_13 + _plus_8);
          }
        }
        if (!_matched_1) {
          if (q instanceof AllRobotsDeploy) {
            _matched_1=true;
            checkAllRobotDeployed = 1;
          }
        }
        if (!_matched_1) {
          if (q instanceof NumAllocations) {
            _matched_1=true;
            int numAlloyInstancesToGet = ((NumAllocations)q).getNumber();
          }
        }
        if (!_matched_1) {
          if (q instanceof NumPopulation) {
            _matched_1=true;
            int numPopulationToGet = ((NumPopulation)q).getNumber();
          }
        }
        if (!_matched_1) {
          if (q instanceof NumEvaluations) {
            _matched_1=true;
            int numEvaluationsToGet = ((NumEvaluations)q).getNumber();
          }
        }
      }
      String _s_13 = this.s;
      this.s = (_s_13 + "\n\n// ----------------RUN COMMAND:\n");
      String _s_14 = this.s;
      this.s = (_s_14 + "\nrun TaskAllocation for");
      String _s_15 = this.s;
      this.s = (_s_15 + (("\n" + Integer.valueOf(this.alloyIntScope)) + " Int,"));
      String _s_16 = this.s;
      this.s = (_s_16 + (("\n" + Integer.valueOf(this.count_capabilities)) + " Capability,"));
      String _s_17 = this.s;
      final List<AtomicTask> _converted_at_missions = (List<AtomicTask>)at_missions;
      int _length_1 = ((Object[])Conversions.unwrapArray(_converted_at_missions, Object.class)).length;
      String _plus_1 = (("\n" + "exactly ") + Integer.valueOf(_length_1));
      String _plus_2 = (_plus_1 + " AtomicTask,");
      this.s = (_s_17 + _plus_2);
      if ((checkAllRobotDeployed == 1)) {
        String _s_18 = this.s;
        int _length_2 = ((Object[])Conversions.unwrapArray(IterableExtensions.<Robot>toList(root.getRobotsModel().getRobots()), Object.class)).length;
        String _plus_3 = ("\nexactly " + Integer.valueOf(_length_2));
        String _plus_4 = (_plus_3 + " Robot,");
        String _plus_5 = (_plus_4 + "// deploy all robots");
        this.s = (_s_18 + _plus_5);
      } else {
        String _s_19 = this.s;
        int _length_3 = ((Object[])Conversions.unwrapArray(IterableExtensions.<Robot>toList(root.getRobotsModel().getRobots()), Object.class)).length;
        String _plus_6 = ("\n" + Integer.valueOf(_length_3));
        String _plus_7 = (_plus_6 + " Robot");
        this.s = (_s_19 + _plus_7);
      }
      for (int i = 0; (i < ((Object[])Conversions.unwrapArray(at_missions, Object.class)).length); i++) {
        String _s_20 = this.s;
        String _name = at_missions.get(i).getName();
        String _plus_8 = (",\nexactly 1 " + _name);
        String _plus_9 = (_plus_8 + "_");
        String _plus_10 = (_plus_9 + Integer.valueOf(i));
        this.s = (_s_20 + _plus_10);
      }
      this.generateFile("modelAllocation.als", this.s, fsa);
      this.s = "";
      String sw = this.WorldM(resource);
      this.generateFile("worldmodel.txt", sw, fsa);
      sw = "";
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public String WorldM(final Resource resource) {
    TreeIterator<EObject> _allContents = null;
    if (resource!=null) {
      _allContents=resource.getAllContents();
    }
    EObject _head = null;
    if (_allContents!=null) {
      _head=IteratorExtensions.<EObject>head(_allContents);
    }
    final ProblemSpecification root = ((ProblemSpecification) _head);
    String sw = "";
    EList<WorldModel> _worldModel = root.getWorldModel();
    for (final WorldModel wm : _worldModel) {
      boolean _matched = false;
      if (wm instanceof Paths) {
        _matched=true;
        String _sw = sw;
        String _name = ((Paths)wm).getLoc1().getName();
        String _plus = (_name + ",");
        String _name_1 = ((Paths)wm).getLoc2().getName();
        String _plus_1 = (_plus + _name_1);
        String _plus_2 = (_plus_1 + ",");
        double _distance = ((Paths)wm).getDistance();
        String _plus_3 = (_plus_2 + Double.valueOf(_distance));
        String _plus_4 = (_plus_3 + "\n");
        sw = (_sw + _plus_4);
      }
    }
    List<Robot> _list = IterableExtensions.<Robot>toList(root.getRobotsModel().getRobots());
    for (final Robot r : _list) {
      boolean _matched_1 = false;
      if (r instanceof Robot) {
        _matched_1=true;
        String _sw = sw;
        String _name = r.getName();
        String _plus = (_name + ",");
        String _name_1 = r.getInitLoc().getName();
        String _plus_1 = (_plus + _name_1);
        String _plus_2 = (_plus_1 + "\n");
        sw = (_sw + _plus_2);
      }
    }
    int _length = sw.length();
    int _minus = (_length - 1);
    sw = sw.substring(0, _minus);
    return sw;
  }

  /**
   * Cast object -> int -> string
   */
  public String cast2IntXY(final Double xy) {
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

  public int getRobots_atName(final String at, final ProblemSpecification root) {
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

  /**
   * Get subtasks of compound task
   */
  public ArrayList<AtomicTask> getCtSubtasks(final CompoundTask ct, final ProblemSpecification root) {
    ArrayList<AtomicTask> at = new ArrayList<AtomicTask>();
    int _length = ((Object[])Conversions.unwrapArray(ct.getCanDoTask(), Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      List<TasksModel> _list = IterableExtensions.<TasksModel>toList(ct.getCanDoTask());
      for (final TasksModel subtask : _list) {
        boolean _matched = false;
        if (subtask instanceof CompoundTask) {
          _matched=true;
          at.addAll(this.getCtSubtasks(((CompoundTask)subtask), root));
        }
        if (!_matched) {
          if (subtask instanceof AtomicTask) {
            _matched=true;
            at.add(((AtomicTask)subtask));
          }
        }
      }
      return at;
    }
    throw new UnsupportedOperationException("ERROR: All compound tasks need at least 2 subtasks ");
  }

  /**
   * Get subtasks of compound task for Python
   */
  public List getCtSubtasksDF(final int countATpython, final int countCTpython, final CompoundTask ct, final ProblemSpecification root, final String parent, final String loc) {
    ArrayList<AtomicTask> at = new ArrayList<AtomicTask>();
    String s = "";
    int countAT = countATpython;
    int countCT = countCTpython;
    int _length = ((Object[])Conversions.unwrapArray(ct.getCanDoTask(), Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      int num_current_ct = countCT;
      String _name = ct.getName();
      String _plus = (_name + "_");
      String id = (_plus + Integer.valueOf(countCT));
      String par = parent;
      String child = "";
      int Nat = countAT;
      int Nct = (countCT + 1);
      List<TasksModel> _list = IterableExtensions.<TasksModel>toList(ct.getCanDoTask());
      for (final TasksModel ct_subt : _list) {
        String _typeTask = this.typeTask(ct_subt);
        boolean _equals = Objects.equal(_typeTask, "atomic");
        if (_equals) {
          String _child = child;
          String _name_1 = ct_subt.getName();
          String _plus_1 = ("\'" + _name_1);
          String _plus_2 = (_plus_1 + "_");
          String _plus_3 = (_plus_2 + Integer.valueOf(Nat));
          String _plus_4 = (_plus_3 + "\',");
          child = (_child + _plus_4);
          int _Nat = Nat;
          Nat = (_Nat + 1);
        } else {
          String _typeTask_1 = this.typeTask(ct_subt);
          boolean _equals_1 = Objects.equal(_typeTask_1, "compound");
          if (_equals_1) {
            String _child_1 = child;
            String _name_2 = ct_subt.getName();
            String _plus_5 = ("\'" + _name_2);
            String _plus_6 = (_plus_5 + "_");
            String _plus_7 = (_plus_6 + Integer.valueOf(Nct));
            String _plus_8 = (_plus_7 + "\',");
            child = (_child_1 + _plus_8);
            int _Nct = Nct;
            Nct = (_Nct + 1);
          }
        }
      }
      int _length_1 = child.length();
      int _minus = (_length_1 - 1);
      String _substring = child.substring(0, _minus);
      String _plus_9 = ("[" + _substring);
      String _plus_10 = (_plus_9 + "]");
      child = _plus_10;
      String runbyrobot = "NaN";
      String joint = "NaN";
      String order = this.Order(ct);
      String consec = this.Consecutive(ct);
      String location = loc;
      String _dfAllocation = this.dfAllocation;
      String _missionTreeString = this.missionTreeString(id, par, child, location, runbyrobot, joint, order, consec);
      this.dfAllocation = (_dfAllocation + _missionTreeString);
      List<TasksModel> _list_1 = IterableExtensions.<TasksModel>toList(ct.getCanDoTask());
      for (final TasksModel subtask : _list_1) {
        boolean _matched = false;
        if (subtask instanceof CompoundTask) {
          _matched=true;
          String _name_3 = ct.getName();
          String _plus_11 = (_name_3 + "_");
          String _plus_12 = (_plus_11 + Integer.valueOf(countCT));
          List<Object> l = this.getCtSubtasksDF(countAT, (countCT + 1), ((CompoundTask)subtask), root, _plus_12, location);
          String _s = s;
          Object _get = l.get(0);
          s = (_s + _get);
          Object _get_1 = l.get(1);
          countAT = (((Integer) _get_1)).intValue();
          Object _get_2 = l.get(2);
          countCT = (((Integer) _get_2)).intValue();
        }
        if (!_matched) {
          if (subtask instanceof AtomicTask) {
            _matched=true;
            String _name_3 = ((AtomicTask)subtask).getName();
            String _plus_11 = (_name_3 + "_");
            String _plus_12 = (_plus_11 + Integer.valueOf(countAT));
            id = _plus_12;
            String _name_4 = ct.getName();
            String _plus_13 = (_name_4 + "_");
            String _plus_14 = (_plus_13 + Integer.valueOf(num_current_ct));
            par = _plus_14;
            child = "NaN";
            joint = this.Joint(((AtomicTask)subtask));
            location = loc;
            String _dfAllocation_1 = this.dfAllocation;
            String _missionTreeString_1 = this.missionTreeString(id, par, child, location, runbyrobot, joint, order, consec);
            this.dfAllocation = (_dfAllocation_1 + _missionTreeString_1);
            int _countAT = countAT;
            countAT = (_countAT + 1);
          }
        }
      }
      List<Object> list = new ArrayList<Object>();
      list.add(s);
      list.add(Integer.valueOf(countAT));
      list.add(Integer.valueOf(countCT));
      return list;
    }
    throw new UnsupportedOperationException("ERROR: All compound tasks need at least 2 subtasks ");
  }

  public String typeTask(final TasksModel t) {
    boolean _matched = false;
    if (t instanceof AtomicTask) {
      _matched=true;
      return "atomic";
    }
    if (!_matched) {
      if (t instanceof CompoundTask) {
        _matched=true;
        return "compound";
      }
    }
    throw new UnsupportedOperationException("ERROR: Task not identified as atomic nor compound");
  }

  /**
   * In missions: find the number of robots of an atomic task
   */
  public int findATnumRobots(final AtomicTask at, final ProblemSpecification root) {
    EList<TasksModel> _tasksModel = root.getTasksModel();
    for (final TasksModel t : _tasksModel) {
      boolean _matched = false;
      if (t instanceof AtomicTask) {
        _matched=true;
        String _name = ((AtomicTask)t).getName();
        String _name_1 = at.getName();
        boolean _equals = Objects.equal(_name, _name_1);
        if (_equals) {
          return ((AtomicTask)t).getRobots();
        }
      }
    }
    String _name = at.getName();
    String _plus = ("ERROR: Location needs to be declared for " + _name);
    throw new UnsupportedOperationException(_plus);
  }

  /**
   * In missions: find the location of an atomic task
   */
  public Location findATloc(final AtomicTask at, final ProblemSpecification root) {
    EList<TasksModel> _tasksModel = root.getTasksModel();
    for (final TasksModel t : _tasksModel) {
      boolean _matched = false;
      if (t instanceof AtomicTask) {
        _matched=true;
        String _name = ((AtomicTask)t).getName();
        String _name_1 = at.getName();
        boolean _equals = Objects.equal(_name, _name_1);
        if (_equals) {
          return ((AtomicTask)t).getLoc();
        }
      }
    }
    String _name = at.getName();
    String _plus = ("ERROR: Location needs to be declared for " + _name);
    throw new UnsupportedOperationException(_plus);
  }

  /**
   * Find location of (one loc) compound task
   */
  public Location findCTOneloc(final CompoundTask ct, final ProblemSpecification root) {
    EList<TasksModel> _tasksModel = root.getTasksModel();
    for (final TasksModel t : _tasksModel) {
      boolean _matched = false;
      if (t instanceof CompoundTask) {
        _matched=true;
        String _name = ((CompoundTask)t).getName();
        String _name_1 = ct.getName();
        boolean _equals = Objects.equal(_name, _name_1);
        if (_equals) {
          return ct.getLocation();
        }
      }
    }
    String _name = ct.getName();
    String _plus = ("ERROR: Location needs to be declared for " + _name);
    throw new UnsupportedOperationException(_plus);
  }

  public void generateFile(final String fileName, final String finalString, final IFileSystemAccess2 fsa) {
    fsa.generateFile(fileName, finalString);
  }

  public static String readFile(final String filePath) throws IOException {
    Path path = java.nio.file.Paths.get(filePath);
    System.out.println(path);
    return Files.readString(path);
  }

  public String Joint(final AtomicTask task) {
    int _robots = task.getRobots();
    boolean _greaterThan = (_robots > 1);
    if (_greaterThan) {
      return "True";
    } else {
      return "False";
    }
  }

  public String Consecutive(final CompoundTask task) {
    boolean _isConsecutive = task.isConsecutive();
    if (_isConsecutive) {
      return "True";
    } else {
      return "False";
    }
  }

  public String Order(final CompoundTask task) {
    boolean _isOrdered = task.isOrdered();
    if (_isOrdered) {
      return "True";
    } else {
      return "False";
    }
  }

  /**
   * Row in .txt file used for a dataframe df in python
   */
  public String missionTreeString(final String id, final String par, final String child, final String location, final String runbyrobot, final String joint, final String order, final String consec) {
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
    String _replaceAll_4 = runbyrobot.replaceAll("\\s+", "");
    String _plus_8 = (_plus_7 + _replaceAll_4);
    String _plus_9 = (_plus_8 + separator);
    String _replaceAll_5 = joint.replaceAll("\\s+", "");
    String _plus_10 = (_plus_9 + _replaceAll_5);
    String _plus_11 = (_plus_10 + separator);
    String _replaceAll_6 = order.replaceAll("\\s+", "");
    String _plus_12 = (_plus_11 + _replaceAll_6);
    String _plus_13 = (_plus_12 + separator);
    String _replaceAll_7 = consec.replaceAll("\\s+", "");
    String dfAllocationLine = (_plus_13 + _replaceAll_7);
    return dfAllocationLine;
  }
}
