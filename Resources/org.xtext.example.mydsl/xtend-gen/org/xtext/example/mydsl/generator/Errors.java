package org.xtext.example.mydsl.generator;

import com.google.common.collect.Iterators;
import dsl.Paths;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class Errors {
  public static void checkDSL(final Resource resource) {
    Errors.checkNoPathsRepeated(resource);
  }

  public static void checkNoPathsRepeated(final Resource resource) {
    ArrayList<String> pathsNames = new ArrayList<String>();
    final List<Paths> paths = IteratorExtensions.<Paths>toList(Iterators.<Paths>filter(resource.getAllContents(), Paths.class));
    for (final Paths p : paths) {
      {
        String _name = p.getLoc1().getName();
        String _plus = (_name + ",");
        String _name_1 = p.getLoc2().getName();
        String s = (_plus + _name_1);
        boolean _contains = pathsNames.contains(s);
        if (_contains) {
          throw new UnsupportedOperationException(("ERROR: Check your paths. Path repeated: " + s));
        } else {
          pathsNames.add(s);
        }
      }
    }
  }
}