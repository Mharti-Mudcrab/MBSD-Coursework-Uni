package net.mudcrab.coursework.mbsd.validation

import java.util.ArrayDeque
import net.mudcrab.coursework.mbsd.ifictiondsl.And
import net.mudcrab.coursework.mbsd.ifictiondsl.Comparison
import net.mudcrab.coursework.mbsd.ifictiondsl.Condition
import net.mudcrab.coursework.mbsd.ifictiondsl.Or
import net.mudcrab.coursework.mbsd.ifictiondsl.Parentheses
import sun.security.jca.GetInstance.Instance

class TraversalCondition {
	
	private ArrayDeque<Condition> comparisonChain
	private Condition rootCondition
	private Condition currentCondition
	
	new (Condition condition) {
		comparisonChain = new ArrayDeque<Condition>()
		rootCondition = condition
		currentCondition = condition
	}
	
	public def ArrayDeque<Condition> getComparisonChain() { comparisonChain }
	
	
	public def boolean buildNextComparisonChain() {
		buildConditionHelper(currentCondition)		
	}
	
	public def boolean buildConditionHelper(Condition cond) {
		
		switch (cond) {
			Or: {
				if (buildConditionHelper(cond.left)) {
					return true					
				}
				if (buildConditionHelper(cond.right)) {
					return true					
				}
				return false
			}
			And: {
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
				if (comparisonChain === null) {
					new TraversalComparison(cond)
				} else {
					comparisonChain.add(cond)
				}
				
				return true
			}
		}
	}
}