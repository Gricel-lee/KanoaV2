package org.xtext.example.mydsl.generator;

import org.eclipse.emf.ecore.resource.Resource;

@SuppressWarnings("all")
public class TreeFile {
  public static void createTreeFile(final Preallocation tree, final Resource resource, final String path) {
    GlobalVar gv = tree.gv;
    String s = "";
    String id = "";
    String parent = "";
    String ordered_children = "";
    String location = "";
    String numrobots = "";
    String joint = "";
    String ordered = "";
    String consecutive = "";
    String start = "";
    String end = "";
    String _s = s;
    s = (_s + "id,,parent,,ordered_children,,location,,numrobots,,joint,,ordered,,consecutive,,start,,end");
    for (final String tID : gv.tasksList) {
      boolean _contains = gv.missionList.keySet().contains(tID);
      if (_contains) {
        id = tID;
        parent = "NaN";
        ordered_children = (("[\'" + gv.missionList.get(tID).child) + "\']");
        location = "NaN";
        numrobots = "NaN";
        joint = "NaN";
        ordered = "NaN";
        consecutive = "NaN";
        start = "NaN";
        end = "NaN";
        String _s_1 = s;
        s = (_s_1 + 
          ((((((((((((((((((("\n" + id) + ",,") + parent) + ",,") + ordered_children) + ",,") + location) + ",,") + numrobots) + ",,") + joint) + ",,") + ordered) + ",,") + consecutive) + ",,") + start) + ",,") + end));
      } else {
        boolean _contains_1 = gv.compoundList.keySet().contains(tID);
        if (_contains_1) {
          id = tID;
          parent = gv.compoundList.get(tID).parent;
          String _join = String.join(",", gv.compoundList.get(tID).children);
          String _plus = ("[\'" + _join);
          String _plus_1 = (_plus + "\']");
          ordered_children = _plus_1;
          location = "NaN";
          numrobots = "NaN";
          joint = "NaN";
          ordered = gv.compoundList.get(tID).ordered;
          consecutive = gv.compoundList.get(tID).ordered;
          start = "NaN";
          end = "NaN";
          String _s_2 = s;
          s = (_s_2 + 
            ((((((((((((((((((("\n" + id) + ",,") + parent) + ",,") + ordered_children) + ",,") + location) + ",,") + numrobots) + ",,") + joint) + ",,") + ordered) + ",,") + consecutive) + ",,") + start) + ",,") + end));
        } else {
          boolean _contains_2 = gv.atomicList.keySet().contains(tID);
          if (_contains_2) {
            id = tID;
            parent = gv.atomicList.get(tID).parent;
            ordered_children = "NaN";
            location = gv.atomicList.get(tID).loc.getName();
            numrobots = String.valueOf(gv.atomicList.get(tID).at.getRobots());
            int _robots = gv.atomicList.get(tID).at.getRobots();
            boolean _greaterThan = (_robots > 1);
            if (_greaterThan) {
              joint = "True";
            } else {
              joint = "False";
            }
            ordered = "NaN";
            consecutive = "NaN";
            if ((gv.atomicList.get(tID).start != null)) {
              start = String.valueOf(gv.atomicList.get(tID).start);
            } else {
              start = "None";
            }
            if ((gv.atomicList.get(tID).end != null)) {
              end = String.valueOf(gv.atomicList.get(tID).end);
            } else {
              end = "None";
            }
            String _s_3 = s;
            s = (_s_3 + 
              ((((((((((((((((((("\n" + id) + ",,") + parent) + ",,") + ordered_children) + ",,") + location) + ",,") + numrobots) + ",,") + joint) + ",,") + ordered) + ",,") + consecutive) + ",,") + start) + ",,") + end));
          }
        }
      }
    }
    Aux.generateFile("modelMissionsTree.txt", s, tree.gv);
  }
}
