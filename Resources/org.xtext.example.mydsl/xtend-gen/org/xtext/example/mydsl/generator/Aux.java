package org.xtext.example.mydsl.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import dsl.AtomicTask;
import dsl.Capability;
import dsl.Location;
import dsl.ProblemSpecification;
import dsl.Robot;
import dsl.SpaceXYRobot;
import dsl.TasksModel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Auxiliary functions.
 */
@SuppressWarnings("all")
public class Aux {
  /**
   * Get closest robot to atomic task
   */
  public static Robot getClosestRobot(final String atID, final GlobalVar gv) {
    AtomicTaskinstance atInstance = gv.atomicList.get(atID);
    Location loc = atInstance.loc;
    double x_at = loc.getX();
    double y_at = loc.getY();
    List<Robot> robots = IteratorExtensions.<Robot>toList(Iterators.<Robot>filter(gv.resource.getAllContents(), Robot.class));
    Robot closestR = null;
    Double closestD = null;
    for (final Robot r : robots) {
      {
        String itcan = "";
        itcan = Aux.checkIfRobotCanDoAtomicTask(r, atInstance);
        if ((itcan == "true")) {
          Pair<Double, Double> coordAT = new Pair<Double, Double>(Double.valueOf(x_at), Double.valueOf(y_at));
          double _x = r.getInitLoc().getX();
          double _y = r.getInitLoc().getY();
          Pair<Double, Double> coordRob = new Pair<Double, Double>(Double.valueOf(_x), Double.valueOf(_y));
          double dist = Aux.distance(coordAT, coordRob);
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
    if ((closestR == null)) {
      String _name = atInstance.at.getName();
      String _plus = ("ERROR. No robot found to perform task:" + _name);
      throw new UnsupportedOperationException(_plus);
    }
    return closestR;
  }

  public static String checkIfRobotCanDoAtomicTask(final Robot r, final AtomicTaskinstance atInstance) {
    String itcan = "";
    EList<Capability> _capabilities = r.getCapabilities();
    for (final Capability cap : _capabilities) {
      String _name = cap.getAt().getName();
      String _name_1 = atInstance.at.getName();
      boolean _equals = Objects.equal(_name, _name_1);
      if (_equals) {
        itcan = "true";
      }
    }
    return itcan;
  }

  /**
   * Euclidian distance
   */
  public static double distance(final Pair<Double, Double> coord1, final Pair<Double, Double> coord2) {
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
   * Allocate atomic task to robot, if robot can perform task
   */
  public static Robot allocateATtoRobot(final String atID, final Robot r, final GlobalVar gv) {
    Robot _xblockexpression = null;
    {
      AtomicTaskinstance atInstance = gv.atomicList.get(atID);
      String itcan = "";
      itcan = Aux.checkIfRobotCanDoAtomicTask(r, atInstance);
      Robot _xifexpression = null;
      if ((itcan == "true")) {
        AtomicTaskinstance _get = gv.atomicList.get(atID);
        _xifexpression = _get.robot = r;
      } else {
        String _name = r.getName();
        String _plus = ((("ERROR. Not possible to assign task:" + atID) + " to robot ") + _name);
        String _plus_1 = (_plus + "\nCheck mission constraints allocating tasks to robots.");
        throw new UnsupportedOperationException(_plus_1);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
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

  /**
   * create new file
   */
  public static void generateFile(final String fileName, final String finalString, final GlobalVar gv) {
    gv.fsa.deleteFile(fileName);
    gv.fsa.generateFile(fileName, finalString);
  }

  public static String readFile(final String filePath) throws IOException {
    Path path = Paths.get(filePath);
    System.out.println(path);
    return Files.readString(path);
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
   * List of atomic tasks needed - NOT instantiated and possibly repeated (e.g., at1_1, at1_1 will return [at1,at1]
   */
  public static List<AtomicTask> at_in_mission(final GlobalVar gv) {
    List<AtomicTask> at_in_mission = new ArrayList<AtomicTask>();
    Collection<AtomicTaskinstance> _values = gv.atomicList.values();
    for (final AtomicTaskinstance atomic : _values) {
      at_in_mission.add(atomic.at);
    }
    return at_in_mission;
  }

  /**
   * Log base 2
   */
  public static double log2(final double v) {
    double _log = Math.log(v);
    double _log_1 = Math.log(2);
    return (_log / _log_1);
  }

  /**
   * Integers Scope for Alloy model
   */
  public static Integer getAlloyIntScope(final GlobalVar gv) {
    ArrayList<Double> n = new ArrayList<Double>();
    Collection<AtomicTaskinstance> _values = gv.atomicList.values();
    for (final AtomicTaskinstance atomic : _values) {
      {
        n.add(Double.valueOf(atomic.loc.getX()));
        n.add(Double.valueOf(atomic.loc.getY()));
      }
    }
    final List<SpaceXYRobot> constrantListXY = IteratorExtensions.<SpaceXYRobot>toList(Iterators.<SpaceXYRobot>filter(gv.resource.getAllContents(), SpaceXYRobot.class));
    for (final SpaceXYRobot c : constrantListXY) {
      n.add(Double.valueOf(c.getVal()));
    }
    Double _max = Collections.<Double>max(n);
    double _plus = ((_max).doubleValue() + 1);
    double _log2 = Aux.log2(_plus);
    double _plus_1 = (_log2 + 1);
    final int max = Double.valueOf(Math.ceil(_plus_1)).intValue();
    return Integer.valueOf(max);
  }
}
