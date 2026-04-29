package net.mudcrab.coursework.mbsd.validation;

import java.util.ArrayDeque;
import net.mudcrab.coursework.mbsd.ifictiondsl.And;
import net.mudcrab.coursework.mbsd.ifictiondsl.Comparison;
import net.mudcrab.coursework.mbsd.ifictiondsl.Condition;
import net.mudcrab.coursework.mbsd.ifictiondsl.Or;
import net.mudcrab.coursework.mbsd.ifictiondsl.Parentheses;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class TraversalCondition {
  private TraversalComparison currentTraversalComparison;

  private ArrayDeque<Comparison> comparisonChain;

  private Condition rootCondition;

  private Condition currentCondition;

  private Class<?> currentParentClass;

  public TraversalCondition(final Condition condition) {
    ArrayDeque<Comparison> _arrayDeque = new ArrayDeque<Comparison>();
    this.comparisonChain = _arrayDeque;
    this.rootCondition = condition;
    this.currentCondition = condition;
  }

  public TraversalComparison getCurrentTraversalComparison() {
    return this.currentTraversalComparison;
  }

  public boolean buildCondition() {
    return this.buildConditionHelper(this.currentCondition);
  }

  public boolean buildConditionHelper(final Condition cond) {
    boolean _matched = false;
    if (cond instanceof Or) {
      _matched=true;
      this.currentParentClass = Or.class;
      boolean _buildConditionHelper = this.buildConditionHelper(((Or)cond).getLeft());
      if (_buildConditionHelper) {
        return true;
      }
      boolean _buildConditionHelper_1 = this.buildConditionHelper(((Or)cond).getRight());
      if (_buildConditionHelper_1) {
        return true;
      }
      return false;
    }
    if (!_matched) {
      if (cond instanceof And) {
        _matched=true;
        this.currentParentClass = And.class;
        this.buildConditionHelper(((And)cond).getRight());
        this.buildConditionHelper(((And)cond).getRight());
        EObject _eContainer = ((And)cond).eContainer();
        if ((_eContainer instanceof And)) {
          return false;
        } else {
          return true;
        }
      }
    }
    if (!_matched) {
      if (cond instanceof Parentheses) {
        _matched=true;
        return true;
      }
    }
    if (!_matched) {
      if (cond instanceof Comparison) {
        _matched=true;
        if ((this.currentTraversalComparison == null)) {
          new TraversalComparison(((Comparison)cond));
        } else {
          this.currentTraversalComparison.addComparison(((Comparison)cond));
        }
        return true;
      }
    }
    return false;
  }
}
