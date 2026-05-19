package net.mudcrab.coursework.mbsd.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ASTTraverser {
  private HashMap<String, Integer> state;

  private ArrayList<TraversalNode> nodeVisitPath;

  private ConcurrentHashMap<Node, TraversalNode> visitedNodes;

  private HashSet<Node> highlyConnectedToNodes;

  private HashSet<Node> conditionlessSearchVisitedNotes;

  private HashSet<Transition> visitedTransitions;

  private HashSet<SystemStateChangeNode> visitedStateChangeNodes;

  private Story story;

  public ASTTraverser() {
    HashMap<String, Integer> _hashMap = new HashMap<String, Integer>();
    this.state = _hashMap;
    ArrayList<TraversalNode> _arrayList = new ArrayList<TraversalNode>();
    this.nodeVisitPath = _arrayList;
    ConcurrentHashMap<Node, TraversalNode> _concurrentHashMap = new ConcurrentHashMap<Node, TraversalNode>();
    this.visitedNodes = _concurrentHashMap;
    HashSet<Node> _hashSet = new HashSet<Node>();
    this.highlyConnectedToNodes = _hashSet;
    HashSet<Node> _hashSet_1 = new HashSet<Node>();
    this.conditionlessSearchVisitedNotes = _hashSet_1;
    HashSet<Transition> _hashSet_2 = new HashSet<Transition>();
    this.visitedTransitions = _hashSet_2;
    HashSet<SystemStateChangeNode> _hashSet_3 = new HashSet<SystemStateChangeNode>();
    this.visitedStateChangeNodes = _hashSet_3;
  }

  public ArrayList<TraversalNode> getNodeVisitPath() {
    return this.nodeVisitPath;
  }

  public ConcurrentHashMap<Node, TraversalNode> getVisitedNodes() {
    return this.visitedNodes;
  }

  public HashSet<Node> getHighlyConnectedToNodes() {
    return this.highlyConnectedToNodes;
  }

  public HashSet<Node> getConditionlessSearchVisitedNotes() {
    return this.conditionlessSearchVisitedNotes;
  }

  public HashSet<Transition> getVisitedTransitions() {
    return this.visitedTransitions;
  }

  public HashSet<SystemStateChangeNode> getVisitedStateChangeNodes() {
    return this.visitedStateChangeNodes;
  }

  public void traverseStory(final Story story) {
    this.state.clear();
    this.visitedNodes.clear();
    this.nodeVisitPath.clear();
    this.highlyConnectedToNodes.clear();
    this.visitedTransitions.clear();
    this.visitedStateChangeNodes.clear();
    this.story = story;
    final Function1<Node, Boolean> _function = (Node it) -> {
      return Boolean.valueOf((it instanceof StartNode));
    };
    final Node startNode = IterableExtensions.<Node>findFirst(story.getNodes(), _function);
    this.traverseStoryHelper(startNode, null);
  }

  public void traverseStoryConditionlessly(final Story story) {
    this.conditionlessSearchVisitedNotes.clear();
    final Function1<Node, Boolean> _function = (Node it) -> {
      return Boolean.valueOf((it instanceof StartNode));
    };
    final Node startNode = IterableExtensions.<Node>findFirst(story.getNodes(), _function);
    this.traverseStoryConditionlesslyHelper(startNode);
  }

  private void traverseStoryConditionlesslyHelper(final Node currentNode) {
    boolean _contains = this.conditionlessSearchVisitedNotes.contains(currentNode);
    if (_contains) {
      return;
    } else {
      this.conditionlessSearchVisitedNotes.add(currentNode);
    }
    boolean _matched = false;
    if (currentNode instanceof ChoiceNode) {
      _matched=true;
      EList<ChoiceOption> _options = ((ChoiceNode)currentNode).getOptions();
      for (final ChoiceOption option : _options) {
        EList<Transition> _transitions = option.getTransitions();
        for (final Transition t : _transitions) {
          this.traverseStoryConditionlesslyHelper(t.getDestination());
        }
      }
    }
    if (!_matched) {
      if (currentNode instanceof EndNode) {
        _matched=true;
        return;
      }
    }
    if (!_matched) {
      {
        final EStructuralFeature structuralFeature = currentNode.eClass().getEStructuralFeature("transition");
        if ((structuralFeature != null)) {
          Object _eGet = currentNode.eGet(structuralFeature);
          final Transition t = ((Transition) _eGet);
          if ((t != null)) {
            this.traverseStoryConditionlesslyHelper(t.getDestination());
          }
        }
      }
    }
  }

  public boolean findNodeFrom(final Node fromNode, final Node toNode) {
    return this.findNodeFrom(fromNode, toNode, false);
  }

  public boolean findNodeFrom(final Node fromNode, final Node toNode, final boolean strictMatch) {
    boolean _containsKey = this.visitedNodes.containsKey(fromNode);
    boolean _not = (!_containsKey);
    if (_not) {
      return false;
    }
    HashMap<String, Integer> _stateSnapshot = this.visitedNodes.get(fromNode).getStateSnapshot();
    HashMap<String, Integer> _hashMap = new HashMap<String, Integer>(_stateSnapshot);
    this.state = _hashMap;
    this.nodeVisitPath.clear();
    if (((this.visitedNodes.containsKey(toNode) || (fromNode == toNode)) && (!strictMatch))) {
      return false;
    }
    HashMap<String, Integer> _hashMap_1 = new HashMap<String, Integer>(this.state);
    TraversalNode _prevNode = this.visitedNodes.get(fromNode).getPrevNode();
    TraversalNode _traversalNode = new TraversalNode(fromNode, _hashMap_1, _prevNode);
    this.nodeVisitPath.add(_traversalNode);
    return this.findNodeFromHelper(fromNode, toNode, strictMatch);
  }

  private boolean findNodeFromHelper(final Node currentNode, final Node toNode, final boolean strictMatch) {
    if (((((Object[])Conversions.unwrapArray(this.nodeVisitPath, Object.class)).length != 1) && (currentNode != toNode))) {
      final Function1<TraversalNode, Boolean> _function = (TraversalNode it) -> {
        Node _node = it.getNode();
        return Boolean.valueOf((_node == currentNode));
      };
      final TraversalNode nodePossiblySeenBeforInPath = IterableExtensions.<TraversalNode>findFirst(this.nodeVisitPath, _function);
      if ((nodePossiblySeenBeforInPath != null)) {
        return false;
      }
    }
    boolean _equals = this.nodeVisitPath.getLast().getNode().equals(currentNode);
    boolean _not = (!_equals);
    if (_not) {
      if ((currentNode instanceof SystemStateChangeNode)) {
        this.updateState(((SystemStateChangeNode)currentNode));
        boolean _contains = this.visitedStateChangeNodes.contains(currentNode);
        boolean _not_1 = (!_contains);
        if (_not_1) {
          this.visitedStateChangeNodes.add(((SystemStateChangeNode)currentNode));
        }
      }
      if ((this.visitedNodes.containsKey(currentNode) && (!this.visitedNodes.get(currentNode).getStateSnapshot().equals(this.state)))) {
        TraversalNode _get = this.visitedNodes.get(currentNode);
        HashMap<String, Integer> _hashMap = new HashMap<String, Integer>(this.state);
        _get.setStateSnapshot(_hashMap);
      }
      HashMap<String, Integer> _hashMap_1 = new HashMap<String, Integer>(this.state);
      TraversalNode _lastOrNull = IterableExtensions.<TraversalNode>lastOrNull(this.nodeVisitPath);
      final TraversalNode traversalNode = new TraversalNode(currentNode, _hashMap_1, _lastOrNull);
      this.nodeVisitPath.add(traversalNode);
      if ((currentNode == toNode)) {
        boolean _containsKey = this.visitedNodes.containsKey(currentNode);
        boolean _not_2 = (!_containsKey);
        if (_not_2) {
          this.visitedNodes.put(currentNode, traversalNode);
        }
        return true;
      }
      boolean _containsKey_1 = this.visitedNodes.containsKey(currentNode);
      boolean _not_3 = (!_containsKey_1);
      if (_not_3) {
        this.visitedNodes.put(currentNode, traversalNode);
        if ((!strictMatch)) {
          return false;
        }
      }
    }
    boolean _matched = false;
    if (currentNode instanceof ChoiceNode) {
      _matched=true;
      EList<ChoiceOption> _options = ((ChoiceNode)currentNode).getOptions();
      for (final ChoiceOption option : _options) {
        {
          final Transition t = this.getBestTransition(((Transition[])Conversions.unwrapArray(option.getTransitions(), Transition.class)));
          if (((t != null) && this.checkCondition(t.getCondition()))) {
            boolean _contains_1 = this.visitedTransitions.contains(t);
            boolean _not_4 = (!_contains_1);
            if (_not_4) {
              this.visitedTransitions.add(t);
            }
            boolean _findNodeFromHelper = this.findNodeFromHelper(t.getDestination(), toNode, strictMatch);
            if (_findNodeFromHelper) {
              return true;
            }
          }
        }
      }
    }
    if (!_matched) {
      if (currentNode instanceof EndNode) {
        _matched=true;
        return false;
      }
    }
    if (!_matched) {
      {
        final EStructuralFeature structuralFeature = currentNode.eClass().getEStructuralFeature("transition");
        if ((structuralFeature != null)) {
          Object _eGet = currentNode.eGet(structuralFeature);
          final Transition t = ((Transition) _eGet);
          if (((t != null) && this.checkCondition(t.getCondition()))) {
            boolean _contains_1 = this.visitedTransitions.contains(t);
            boolean _not_4 = (!_contains_1);
            if (_not_4) {
              this.visitedTransitions.add(t);
            }
            return this.findNodeFromHelper(t.getDestination(), toNode, strictMatch);
          }
        }
      }
    }
    return false;
  }

  private void traverseStoryHelper(final Node node, final TraversalNode prevNode) {
    if ((node == null)) {
      return;
    }
    boolean _matched = false;
    if (node instanceof StartNode) {
      _matched=true;
      HashMap<String, Integer> _hashMap = new HashMap<String, Integer>(this.state);
      TraversalNode _traversalNode = new TraversalNode(node, _hashMap, null);
      this.visitedNodes.put(node, _traversalNode);
      this.addIfHighlyConnectedToNode(node);
      boolean _checkCondition = this.checkCondition(((StartNode)node).getTransition().getCondition());
      if (_checkCondition) {
        this.visitedTransitions.add(((StartNode)node).getTransition());
        boolean _containsKey = this.visitedNodes.containsKey(((StartNode)node).getTransition().getDestination());
        boolean _not = (!_containsKey);
        if (_not) {
          this.traverseStoryHelper(((StartNode)node).getTransition().getDestination(), this.visitedNodes.get(node));
        }
      }
    }
    if (!_matched) {
      if (node instanceof DialogueNode) {
        _matched=true;
        HashMap<String, Integer> _hashMap = new HashMap<String, Integer>(this.state);
        TraversalNode _traversalNode = new TraversalNode(node, _hashMap, prevNode);
        this.visitedNodes.put(node, _traversalNode);
        this.addIfHighlyConnectedToNode(node);
        boolean _checkCondition = this.checkCondition(((DialogueNode)node).getTransition().getCondition());
        if (_checkCondition) {
          this.visitedTransitions.add(((DialogueNode)node).getTransition());
          boolean _containsKey = this.visitedNodes.containsKey(((DialogueNode)node).getTransition().getDestination());
          boolean _not = (!_containsKey);
          if (_not) {
            this.traverseStoryHelper(((DialogueNode)node).getTransition().getDestination(), this.visitedNodes.get(node));
          }
        }
      }
    }
    if (!_matched) {
      if (node instanceof SystemStateChangeNode) {
        _matched=true;
        this.updateState(((SystemStateChangeNode)node));
        this.visitedStateChangeNodes.add(((SystemStateChangeNode)node));
        HashMap<String, Integer> _hashMap = new HashMap<String, Integer>(this.state);
        TraversalNode _traversalNode = new TraversalNode(node, _hashMap, prevNode);
        this.visitedNodes.put(node, _traversalNode);
        this.addIfHighlyConnectedToNode(node);
        boolean _checkCondition = this.checkCondition(((SystemStateChangeNode)node).getTransition().getCondition());
        if (_checkCondition) {
          this.visitedTransitions.add(((SystemStateChangeNode)node).getTransition());
          boolean _containsKey = this.visitedNodes.containsKey(((SystemStateChangeNode)node).getTransition().getDestination());
          boolean _not = (!_containsKey);
          if (_not) {
            this.traverseStoryHelper(((SystemStateChangeNode)node).getTransition().getDestination(), this.visitedNodes.get(node));
          }
        }
      }
    }
    if (!_matched) {
      if (node instanceof ChoiceNode) {
        _matched=true;
        HashMap<String, Integer> _hashMap = new HashMap<String, Integer>(this.state);
        TraversalNode _traversalNode = new TraversalNode(node, _hashMap, prevNode);
        this.visitedNodes.put(node, _traversalNode);
        this.addIfHighlyConnectedToNode(node);
        EList<ChoiceOption> _options = ((ChoiceNode)node).getOptions();
        for (final ChoiceOption choiceOption : _options) {
          {
            final Transition bestTransition = this.getBestTransition(((Transition[])Conversions.unwrapArray(choiceOption.getTransitions(), Transition.class)));
            if ((bestTransition != null)) {
              this.visitedTransitions.add(bestTransition);
              boolean _containsKey = this.visitedNodes.containsKey(bestTransition.getDestination());
              boolean _not = (!_containsKey);
              if (_not) {
                this.traverseStoryHelper(bestTransition.getDestination(), this.visitedNodes.get(node));
              }
            }
          }
        }
      }
    }
    if (!_matched) {
      if (node instanceof EndNode) {
        _matched=true;
        this.addIfHighlyConnectedToNode(node);
        HashMap<String, Integer> _hashMap = new HashMap<String, Integer>(this.state);
        TraversalNode _traversalNode = new TraversalNode(node, _hashMap, prevNode);
        this.visitedNodes.put(node, _traversalNode);
      }
    }
  }

  private void updateState(final SystemStateChangeNode node) {
    EList<StateUpdate> _stateUpdates = node.getStateUpdates();
    for (final StateUpdate stateUpdate : _stateUpdates) {
      String _operator = stateUpdate.getOperator();
      if (_operator != null) {
        switch (_operator) {
          case "=":
            this.state.put(stateUpdate.getVariable(), Integer.valueOf(stateUpdate.getValue()));
            break;
          case "-=":
            String _variable = stateUpdate.getVariable();
            Integer _orDefault = this.state.getOrDefault(stateUpdate.getVariable(), Integer.valueOf(0));
            int _value = stateUpdate.getValue();
            int _minus = ((_orDefault).intValue() - _value);
            this.state.put(_variable, Integer.valueOf(_minus));
            break;
          case "+=":
            String _variable_1 = stateUpdate.getVariable();
            Integer _orDefault_1 = this.state.getOrDefault(stateUpdate.getVariable(), Integer.valueOf(0));
            int _value_1 = stateUpdate.getValue();
            int _plus = ((_orDefault_1).intValue() + _value_1);
            this.state.put(_variable_1, Integer.valueOf(_plus));
            break;
        }
      }
    }
  }

  private void addIfHighlyConnectedToNode(final Node node) {
    int connectCount = 0;
    EList<Node> _nodes = this.story.getNodes();
    for (final Node no : _nodes) {
      boolean _matched = false;
      if (no instanceof ChoiceNode) {
        _matched=true;
        EList<ChoiceOption> _options = ((ChoiceNode)no).getOptions();
        for (final ChoiceOption option : _options) {
          EList<Transition> _transitions = option.getTransitions();
          for (final Transition transition : _transitions) {
            boolean _equals = transition.getDestination().getName().equals(node.getName());
            if (_equals) {
              connectCount++;
            }
          }
        }
      }
      if (!_matched) {
        {
          final EStructuralFeature structuralFeature = no.eClass().getEStructuralFeature("transition");
          if ((structuralFeature != null)) {
            Object _eGet = no.eGet(structuralFeature);
            final Transition transition = ((Transition) _eGet);
            if (((transition != null) && transition.getDestination().getName().equals(node.getName()))) {
              connectCount++;
            }
          }
        }
      }
    }
    if ((connectCount > 1)) {
      this.highlyConnectedToNodes.add(node);
    }
  }

  private Transition getBestTransition(final Transition[] transitions) {
    final Function1<Transition, Boolean> _function = (Transition it) -> {
      return Boolean.valueOf(this.checkCondition(it.getCondition()));
    };
    final Function1<Transition, Integer> _function_1 = (Transition it) -> {
      return Integer.valueOf(it.getPriority());
    };
    return IterableExtensions.<Transition>lastOrNull(IterableExtensions.<Transition, Integer>sortBy(IterableExtensions.<Transition>filter(((Iterable<Transition>)Conversions.doWrapArray(transitions)), _function), _function_1));
  }

  private boolean checkCondition(final Condition cond) {
    return ASTTraverser.checkCondition(cond, this.state);
  }

  public static boolean checkCondition(final Condition cond, final HashMap<String, Integer> state) {
    if ((cond == null)) {
      return true;
    }
    boolean _matched = false;
    if (cond instanceof And) {
      _matched=true;
      return (ASTTraverser.checkCondition(((And)cond).getLeft(), state) && ASTTraverser.checkCondition(((And)cond).getRight(), state));
    }
    if (!_matched) {
      if (cond instanceof Or) {
        _matched=true;
        return (ASTTraverser.checkCondition(((Or)cond).getLeft(), state) || ASTTraverser.checkCondition(((Or)cond).getRight(), state));
      }
    }
    if (!_matched) {
      if (cond instanceof Parentheses) {
        _matched=true;
        return ASTTraverser.checkCondition(((Parentheses)cond).getInner(), state);
      }
    }
    if (!_matched) {
      if (cond instanceof Comparison) {
        _matched=true;
        String _operator = ((Comparison)cond).getOperator();
        if (_operator != null) {
          switch (_operator) {
            case "==":
              Integer _orDefault = state.getOrDefault(((Comparison)cond).getVariable(), Integer.valueOf(0));
              int _value = ((Comparison)cond).getValue();
              return ((_orDefault).intValue() == _value);
            case "!=":
              Integer _orDefault_1 = state.getOrDefault(((Comparison)cond).getVariable(), Integer.valueOf(0));
              int _value_1 = ((Comparison)cond).getValue();
              return ((_orDefault_1).intValue() != _value_1);
            case ">":
              Integer _orDefault_2 = state.getOrDefault(((Comparison)cond).getVariable(), Integer.valueOf(0));
              int _value_2 = ((Comparison)cond).getValue();
              return ((_orDefault_2).intValue() > _value_2);
            case "<":
              Integer _orDefault_3 = state.getOrDefault(((Comparison)cond).getVariable(), Integer.valueOf(0));
              int _value_3 = ((Comparison)cond).getValue();
              return ((_orDefault_3).intValue() < _value_3);
            case ">=":
              Integer _orDefault_4 = state.getOrDefault(((Comparison)cond).getVariable(), Integer.valueOf(0));
              int _value_4 = ((Comparison)cond).getValue();
              return ((_orDefault_4).intValue() >= _value_4);
            case "<=":
              Integer _orDefault_5 = state.getOrDefault(((Comparison)cond).getVariable(), Integer.valueOf(0));
              int _value_5 = ((Comparison)cond).getValue();
              return ((_orDefault_5).intValue() <= _value_5);
          }
        }
      }
    }
    return false;
  }
}
