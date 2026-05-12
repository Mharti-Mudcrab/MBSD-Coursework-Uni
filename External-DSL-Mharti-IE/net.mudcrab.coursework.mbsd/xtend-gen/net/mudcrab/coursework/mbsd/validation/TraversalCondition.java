package net.mudcrab.coursework.mbsd.validation;

import java.util.ArrayDeque;
import java.util.Objects;
import net.mudcrab.coursework.mbsd.ifictiondsl.And;
import net.mudcrab.coursework.mbsd.ifictiondsl.Comparison;
import net.mudcrab.coursework.mbsd.ifictiondsl.Condition;
import net.mudcrab.coursework.mbsd.ifictiondsl.Or;
import net.mudcrab.coursework.mbsd.ifictiondsl.Parentheses;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class TraversalCondition {
  private ArrayDeque<Condition> comparisonChain;

  private Condition rootCondition;

  private Condition currentCondition;

  private Condition previousCondition;

  public TraversalCondition(final Condition condition) {
    ArrayDeque<Condition> _arrayDeque = new ArrayDeque<Condition>();
    this.comparisonChain = _arrayDeque;
    this.rootCondition = condition;
    this.currentCondition = condition;
    this.previousCondition = condition;
  }

  public ArrayDeque<Condition> getComparisonChain() {
    return this.comparisonChain;
  }

  public boolean buildNextComparisonChain() {
    this.comparisonChain.clear();
    while ((this.currentCondition != null)) {
      final Condition cur = this.currentCondition;
      boolean _matched = false;
      if (cur instanceof Or) {
        _matched=true;
        final Condition previousCondition = this.previousCondition;
        boolean _matched_1 = false;
        if (Objects.equals(previousCondition, ((Or)cur))) {
          _matched_1=true;
        }
        if (!_matched_1) {
          EObject _eContainer = ((Or)cur).eContainer();
          if (Objects.equals(previousCondition, _eContainer)) {
            _matched_1=true;
          }
        }
        if (_matched_1) {
          this.previousCondition = cur;
          this.currentCondition = ((Or)cur).getLeft();
        }
        if (!_matched_1) {
          Condition _left = ((Or)cur).getLeft();
          if (Objects.equals(previousCondition, _left)) {
            _matched_1=true;
            this.previousCondition = cur;
            this.currentCondition = ((Or)cur).getRight();
            return true;
          }
        }
        if (!_matched_1) {
          Condition _right = ((Or)cur).getRight();
          if (Objects.equals(previousCondition, _right)) {
            _matched_1=true;
            this.previousCondition = cur;
            if ((cur == this.rootCondition)) {
              this.currentCondition = null;
              return true;
            } else {
              EObject _eContainer_1 = ((Or)cur).eContainer();
              this.currentCondition = ((Condition) _eContainer_1);
            }
          }
        }
      }
      if (!_matched) {
        if (cur instanceof And) {
          _matched=true;
          final Condition previousCondition = this.previousCondition;
          boolean _matched_1 = false;
          if (Objects.equals(previousCondition, ((And)cur))) {
            _matched_1=true;
          }
          if (!_matched_1) {
            EObject _eContainer = ((And)cur).eContainer();
            if (Objects.equals(previousCondition, _eContainer)) {
              _matched_1=true;
            }
          }
          if (_matched_1) {
            this.previousCondition = cur;
            this.currentCondition = ((And)cur).getLeft();
          }
          if (!_matched_1) {
            Condition _left = ((And)cur).getLeft();
            if (Objects.equals(previousCondition, _left)) {
              _matched_1=true;
              this.previousCondition = cur;
              this.currentCondition = ((And)cur).getRight();
            }
          }
          if (!_matched_1) {
            Condition _right = ((And)cur).getRight();
            if (Objects.equals(previousCondition, _right)) {
              _matched_1=true;
              this.previousCondition = cur;
              if ((cur == this.rootCondition)) {
                this.currentCondition = null;
                return true;
              } else {
                EObject _eContainer_1 = ((And)cur).eContainer();
                this.currentCondition = ((Condition) _eContainer_1);
              }
            }
          }
        }
      }
      if (!_matched) {
        if (cur instanceof Parentheses) {
          _matched=true;
        }
        if (!_matched) {
          if (cur instanceof Comparison) {
            _matched=true;
          }
        }
        if (_matched) {
          this.comparisonChain.add(cur);
          this.previousCondition = cur;
          if ((cur == this.rootCondition)) {
            this.currentCondition = null;
            return true;
          } else {
            EObject _eContainer = cur.eContainer();
            this.currentCondition = ((Condition) _eContainer);
          }
        }
      }
      if (!_matched) {
        return false;
      }
    }
    return false;
  }

  public boolean buildConditionHelper(final Condition cond) {
    boolean _matched = false;
    if (cond instanceof Or) {
      _matched=true;
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
        if ((this.comparisonChain == null)) {
          new TraversalComparison(((Comparison)cond));
        } else {
          this.comparisonChain.add(cond);
        }
        return true;
      }
    }
    return false;
  }
}
