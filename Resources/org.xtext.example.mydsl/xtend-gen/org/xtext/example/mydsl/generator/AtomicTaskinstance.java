package org.xtext.example.mydsl.generator;

import dsl.AtomicTask;
import dsl.Location;
import dsl.Robot;
import org.eclipse.xtext.xbase.lib.InputOutput;

/**
 * Atomic Task instance. Its identifier is the "type of atomic task + _ + counter".
 */
@SuppressWarnings("all")
public class AtomicTaskinstance {
  public AtomicTask at;

  public Integer count;

  public Location loc;

  public String parent;

  public Robot robot;

  public Double start;

  public Double end;

  public int retry;

  public int set(final AtomicTask at, final Integer count, final String parent) {
    int _xblockexpression = (int) 0;
    {
      this.at = at;
      this.count = count;
      this.parent = parent;
      this.loc = at.getLoc();
      _xblockexpression = this.retry = at.getRetry();
    }
    return _xblockexpression;
  }

  /**
   * Get instance id
   */
  public String getId() {
    String _name = this.at.getName();
    String _plus = (_name + "_");
    return (_plus + this.count);
  }

  public String print() {
    String _xblockexpression = null;
    {
      String _id = this.getId();
      String _plus = ("=== atomic task:" + _id);
      String _plus_1 = (_plus + " ===");
      InputOutput.<String>println(_plus_1);
      InputOutput.<String>println(("parent:" + this.parent));
      String _name = this.loc.getName();
      String _plus_2 = ("location:" + _name);
      InputOutput.<String>println(_plus_2);
      if ((this.robot != null)) {
        String _robotId = this.getRobotId();
        String _plus_3 = ("robot:" + _robotId);
        InputOutput.<String>println(_plus_3);
      }
      if ((this.start != null)) {
        InputOutput.<String>println(("startTime:" + this.start));
      }
      if ((this.end != null)) {
        InputOutput.<String>println(("endTime:" + this.end));
      }
      String _xifexpression = null;
      boolean _equals = Integer.valueOf(this.retry).equals(Integer.valueOf(0));
      boolean _not = (!_equals);
      if (_not) {
        _xifexpression = InputOutput.<String>println(("retry:" + Integer.valueOf(this.retry)));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public String getRobotId() {
    return this.robot.getName();
  }

  /**
   * Return the closest robot to the atomic task
   */
  public void closestRobot() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
