package net.mudcrab.coursework.mbsd.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.mudcrab.coursework.mbsd.ifictiondsl.And;
import net.mudcrab.coursework.mbsd.ifictiondsl.ChoiceNode;
import net.mudcrab.coursework.mbsd.ifictiondsl.ChoiceOption;
import net.mudcrab.coursework.mbsd.ifictiondsl.Comparison;
import net.mudcrab.coursework.mbsd.ifictiondsl.Condition;
import net.mudcrab.coursework.mbsd.ifictiondsl.DialogueNode;
import net.mudcrab.coursework.mbsd.ifictiondsl.EndNode;
import net.mudcrab.coursework.mbsd.ifictiondsl.Node;
import net.mudcrab.coursework.mbsd.ifictiondsl.Or;
import net.mudcrab.coursework.mbsd.ifictiondsl.Parentheses;
import net.mudcrab.coursework.mbsd.ifictiondsl.StartNode;
import net.mudcrab.coursework.mbsd.ifictiondsl.StateUpdate;
import net.mudcrab.coursework.mbsd.ifictiondsl.Story;
import net.mudcrab.coursework.mbsd.ifictiondsl.SystemStateChangeNode;
import net.mudcrab.coursework.mbsd.ifictiondsl.Transition;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Traverses a Story model, records visited nodes and snapshots of system state.
 * 
 * - Keeps a visit log (VisitEntry) with the node and a copy of the state at the time
 * - Applies StateUpdate entries on SystemStateChangeNode when visited
 * - Evaluates Transition conditions against the current state and only follows transitions
 *   whose condition evaluates to true (or with no condition)
 * - Avoids infinite loops by tracking visited nodes
 */
@SuppressWarnings("all")
public class StoryTraversal {
  public static class VisitEntry {
    public final Node node;

    public final Map<String, Integer> stateSnapshot;

    public VisitEntry(final Node node, final Map<String, Integer> stateSnapshot) {
      this.node = node;
      this.stateSnapshot = stateSnapshot;
    }

    @Override
    public String toString() {
      String _xblockexpression = null;
      {
        String _xifexpression = null;
        String _name = null;
        if (this.node!=null) {
          _name=this.node.getName();
        }
        boolean _tripleNotEquals = (_name != null);
        if (_tripleNotEquals) {
          _xifexpression = this.node.getName();
        } else {
          _xifexpression = this.node.toString();
        }
        final String name = _xifexpression;
        String _string = this.stateSnapshot.toString();
        String _plus = ((("VisitEntry(" + name) + ", ") + _string);
        _xblockexpression = (_plus + ")");
      }
      return _xblockexpression;
    }
  }

  private final ArrayList<Node> visited = new ArrayList<Node>();

  private final ArrayList<StoryTraversal.VisitEntry> visitLog = new ArrayList<StoryTraversal.VisitEntry>();

  private final HashMap<String, Integer> state = new HashMap<String, Integer>();

  private final HashSet<Transition> visitedTransitions = new HashSet<Transition>();

  public void reset() {
    this.visited.clear();
    this.visitLog.clear();
    this.state.clear();
    this.visitedTransitions.clear();
  }

  /**
   * Traverse whole story starting from the first StartNode found.
   */
  public List<StoryTraversal.VisitEntry> traverse(final Story story) {
    this.reset();
    if ((story == null)) {
      return this.visitLog;
    }
    final Function1<Node, Boolean> _function = (Node it) -> {
      return Boolean.valueOf((it instanceof StartNode));
    };
    Node _findFirst = IterableExtensions.<Node>findFirst(story.getNodes(), _function);
    final StartNode start = ((StartNode) _findFirst);
    if ((start == null)) {
      return this.visitLog;
    }
    this.traverseFrom(start);
    return this.visitLog;
  }

  public List<StoryTraversal.VisitEntry> getVisitLog() {
    return this.visitLog;
  }

  public Set<Transition> getVisitedTransitions() {
    return this.visitedTransitions;
  }

  public Map<String, Integer> getState() {
    return this.state;
  }

  private void traverseFrom(final Node node) {
    if ((node == null)) {
      return;
    }
    boolean _contains = this.visited.contains(node);
    if (_contains) {
      return;
    }
    this.visited.add(node);
    this.applyNodeStateChanges(node);
    Map<String, Integer> _copyState = this.copyState();
    StoryTraversal.VisitEntry _visitEntry = new StoryTraversal.VisitEntry(node, _copyState);
    this.visitLog.add(_visitEntry);
    if ((node instanceof StartNode)) {
      final StartNode s = ((StartNode) node);
      this.traverseTransition(s.getTransition());
    } else {
      if ((node instanceof DialogueNode)) {
        final DialogueNode d = ((DialogueNode) node);
        this.traverseTransition(d.getTransition());
      } else {
        if ((node instanceof SystemStateChangeNode)) {
          final SystemStateChangeNode sc = ((SystemStateChangeNode) node);
          this.traverseTransition(sc.getTransition());
        } else {
          if ((node instanceof ChoiceNode)) {
            final ChoiceNode c = ((ChoiceNode) node);
            EList<ChoiceOption> _options = c.getOptions();
            for (final ChoiceOption opt : _options) {
              EList<Transition> _transitions = opt.getTransitions();
              for (final Transition t : _transitions) {
                this.traverseTransition(t);
              }
            }
          } else {
            if ((node instanceof EndNode)) {
            } else {
              try {
                Object _eGet = node.eGet(node.eClass().getEStructuralFeature("transition"));
                final Transition t_1 = ((Transition) _eGet);
                this.traverseTransition(t_1);
              } catch (final Throwable _t) {
                if (_t instanceof Throwable) {
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
            }
          }
        }
      }
    }
  }

  private void traverseTransition(final Transition t) {
    if ((t == null)) {
      return;
    }
    if (((t.getCondition() != null) && (!this.evaluateCondition(t.getCondition())))) {
      return;
    }
    this.visitedTransitions.add(t);
    final Node dest = t.getDestination();
    this.traverseFrom(dest);
  }

  private void applyNodeStateChanges(final Node node) {
    if ((node instanceof SystemStateChangeNode)) {
      final SystemStateChangeNode sc = ((SystemStateChangeNode) node);
      EList<StateUpdate> _stateUpdates = sc.getStateUpdates();
      for (final StateUpdate upd : _stateUpdates) {
        this.applyStateUpdate(upd);
      }
    }
  }

  private void applyStateUpdate(final StateUpdate upd) {
    if ((upd == null)) {
      return;
    }
    final String varName = upd.getVariable();
    final String op = upd.getOperator();
    final int value = upd.getValue();
    Integer _xifexpression = null;
    boolean _containsKey = this.state.containsKey(varName);
    if (_containsKey) {
      _xifexpression = this.state.get(varName);
    } else {
      _xifexpression = Integer.valueOf(0);
    }
    final Integer cur = _xifexpression;
    boolean _equals = Objects.equals(op, "+=");
    if (_equals) {
      this.state.put(varName, Integer.valueOf(((cur).intValue() + value)));
    } else {
      boolean _equals_1 = Objects.equals(op, "-=");
      if (_equals_1) {
        this.state.put(varName, Integer.valueOf(((cur).intValue() - value)));
      } else {
        boolean _equals_2 = Objects.equals(op, "=");
        if (_equals_2) {
          this.state.put(varName, Integer.valueOf(value));
        } else {
        }
      }
    }
  }

  private boolean evaluateCondition(final Condition cond) {
    if ((cond == null)) {
      return true;
    }
    if ((cond instanceof Parentheses)) {
      return this.evaluateCondition(((Parentheses) cond).getInner());
    }
    if ((cond instanceof And)) {
      final And a = ((And) cond);
      return (this.evaluateCondition(a.getLeft()) && this.evaluateCondition(a.getRight()));
    }
    if ((cond instanceof Or)) {
      final Or o = ((Or) cond);
      return (this.evaluateCondition(o.getLeft()) || this.evaluateCondition(o.getRight()));
    }
    if ((cond instanceof Comparison)) {
      final Comparison c = ((Comparison) cond);
      final String varName = c.getVariable();
      final String op = c.getOperator();
      final int rhs = c.getValue();
      Integer _xifexpression = null;
      boolean _containsKey = this.state.containsKey(varName);
      if (_containsKey) {
        _xifexpression = this.state.get(varName);
      } else {
        _xifexpression = Integer.valueOf(0);
      }
      final Integer lhs = _xifexpression;
      boolean _equals = Objects.equals(op, "==");
      if (_equals) {
        return ((lhs).intValue() == rhs);
      }
      boolean _equals_1 = Objects.equals(op, "!=");
      if (_equals_1) {
        return ((lhs).intValue() != rhs);
      }
      boolean _equals_2 = Objects.equals(op, ">");
      if (_equals_2) {
        return ((lhs).intValue() > rhs);
      }
      boolean _equals_3 = Objects.equals(op, "<");
      if (_equals_3) {
        return ((lhs).intValue() < rhs);
      }
      boolean _equals_4 = Objects.equals(op, ">=");
      if (_equals_4) {
        return ((lhs).intValue() >= rhs);
      }
      boolean _equals_5 = Objects.equals(op, "<=");
      if (_equals_5) {
        return ((lhs).intValue() <= rhs);
      }
      return false;
    }
    return false;
  }

  private Map<String, Integer> copyState() {
    HashMap<String, Integer> _xblockexpression = null;
    {
      final HashMap<String, Integer> m = new HashMap<String, Integer>();
      Set<Map.Entry<String, Integer>> _entrySet = this.state.entrySet();
      for (final Map.Entry<String, Integer> entry : _entrySet) {
        m.put(entry.getKey(), entry.getValue());
      }
      _xblockexpression = m;
    }
    return _xblockexpression;
  }
}
