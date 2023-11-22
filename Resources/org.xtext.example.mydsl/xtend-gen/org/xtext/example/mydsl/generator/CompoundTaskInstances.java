package org.xtext.example.mydsl.generator;

import dsl.CompoundTask;
import java.util.List;

/**
 * Atomic task instance
 */
@SuppressWarnings("all")
public class CompoundTaskInstances {
  /**
   * Compound task
   */
  public CompoundTask ct;

  /**
   * Instance number
   */
  public Integer inum;

  /**
   * subtasks instantiated IDs
   */
  public List<String> subtasksInstances;

  /**
   * Parent ID
   */
  public String parentId;
}
