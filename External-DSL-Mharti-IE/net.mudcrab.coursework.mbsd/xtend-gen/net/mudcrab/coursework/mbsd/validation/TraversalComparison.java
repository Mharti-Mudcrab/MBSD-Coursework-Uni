package net.mudcrab.coursework.mbsd.validation;

import java.util.ArrayList;
import net.mudcrab.coursework.mbsd.ifictiondsl.Comparison;

@SuppressWarnings("all")
public class TraversalComparison {
  private ArrayList<Comparison> comparisonList;

  public TraversalComparison(final Comparison comparison) {
    ArrayList<Comparison> _arrayList = new ArrayList<Comparison>();
    this.comparisonList = _arrayList;
    this.comparisonList.add(comparison);
  }

  public boolean addComparison(final Comparison comparison) {
    return this.comparisonList.add(comparison);
  }

  public ArrayList<Comparison> getComparisonList() {
    return this.comparisonList;
  }
}
