package net.mudcrab.coursework.mbsd.validation

import java.util.ArrayDeque
import net.mudcrab.coursework.mbsd.ifictiondsl.And
import net.mudcrab.coursework.mbsd.ifictiondsl.Comparison
import net.mudcrab.coursework.mbsd.ifictiondsl.Condition
import net.mudcrab.coursework.mbsd.ifictiondsl.Or
import net.mudcrab.coursework.mbsd.ifictiondsl.Parentheses
import sun.security.jca.GetInstance.Instance

class TraversalCondition {
	
	private TraversalComparison currentTraversalComparison
	private ArrayDeque<Comparison> comparisonChain
	private Condition rootCondition
	private Condition currentCondition
	private Class<?> currentParentClass
	
	new (Condition condition) {
		comparisonChain = new ArrayDeque<Comparison>()
		rootCondition = condition
		currentCondition = condition
	}
	
	public def TraversalComparison getCurrentTraversalComparison() { currentTraversalComparison }
	
	
	public def boolean buildCondition() {
		buildConditionHelper(currentCondition)		
	}
	
	public def boolean buildConditionHelper(Condition cond) {
		
		switch (cond) {
			Or: {
				currentParentClass = Or
				if (buildConditionHelper(cond.left)) {
					return true					
				}
				if (buildConditionHelper(cond.right)) {
					return true					
				}
				return false
			}
			And: {
				currentParentClass = And
				buildConditionHelper(cond.right)
				buildConditionHelper(cond.right)
				if (cond.eContainer instanceof And)
					return false
				else
					return true
			}
			Parentheses: {
				return true
			}
			Comparison: {
				if (currentTraversalComparison === null) {
					new TraversalComparison(cond)
				} else {
					currentTraversalComparison.addComparison(cond)
				}
				
				return true
			}
		}
	}
}