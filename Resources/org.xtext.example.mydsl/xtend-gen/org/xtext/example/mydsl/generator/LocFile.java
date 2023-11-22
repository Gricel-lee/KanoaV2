package org.xtext.example.mydsl.generator;

import com.google.common.collect.Iterators;
import dsl.Paths;
import dsl.Robot;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class LocFile {
  public static void createLocFile(final Preallocation tree, final Resource resource, final String path) {
    GlobalVar gv = tree.gv;
    String s = "";
    final List<Paths> paths = IteratorExtensions.<Paths>toList(Iterators.<Paths>filter(gv.resource.getAllContents(), Paths.class));
    for (final Paths p : paths) {
      {
        String _s = s;
        String _name = p.getLoc1().getName();
        String _plus = (_name + ",");
        String _name_1 = p.getLoc2().getName();
        String _plus_1 = (_plus + _name_1);
        String _plus_2 = (_plus_1 + ",");
        String _valueOf = String.valueOf(p.getDistance());
        String _plus_3 = (_plus_2 + _valueOf);
        s = (_s + _plus_3);
        String _valueOf_1 = String.valueOf(p.getSuccess());
        String _plus_4 = ("," + _valueOf_1);
        /* (_plus_4 + "\n"); */
      }
    }
    final List<Robot> robs = IteratorExtensions.<Robot>toList(Iterators.<Robot>filter(gv.resource.getAllContents(), Robot.class));
    for (final Robot r : robs) {
      String _s = s;
      String _name = r.getName();
      String _plus = (_name + ",");
      String _name_1 = r.getInitLoc().getName();
      String _plus_1 = (_plus + _name_1);
      String _plus_2 = (_plus_1 + "\n");
      s = (_s + _plus_2);
    }
    int _length = s.length();
    int _minus = (_length - 1);
    s = s.substring(0, _minus);
    Aux.generateFile("worldmodel.txt", s, tree.gv);
  }
}
