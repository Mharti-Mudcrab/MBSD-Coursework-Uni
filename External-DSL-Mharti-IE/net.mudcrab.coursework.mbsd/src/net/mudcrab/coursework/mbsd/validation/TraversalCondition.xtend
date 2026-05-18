package net.mudcrab.coursework.mbsd.validation

import java.util.ArrayDeque
import net.mudcrab.coursework.mbsd.ifictiondsl.And
import net.mudcrab.coursework.mbsd.ifictiondsl.Comparison
import net.mudcrab.coursework.mbsd.ifictiondsl.Condition
import net.mudcrab.coursework.mbsd.ifictiondsl.Or
import net.mudcrab.coursework.mbsd.ifictiondsl.Parentheses

class TraversalCondition {
	
	private ArrayDeque<Condition> comparisonChain
	private Condition rootCondition
	private Condition currentCondition
	private Condition previousCondition
	
	new (Condition condition) {
		comparisonChain = new ArrayDeque<Condition>()
		rootCondition = condition
		currentCondition = condition
		previousCondition = condition
	}
	
	public def ArrayDeque<Condition> getComparisonChain() { comparisonChain }
	
	
	public def boolean buildNextComparisonChain() {
		comparisonChain.clear
		
		while(currentCondition !== null) {
			switch (cur : currentCondition) { // create final temp val to ensure consistent type masking
				Or: {
					switch (previousCondition) {
						// We started out here. This is root. We search left
						case cur, 
						// We came from parent. 			  We search left
						case cur.eContainer: {
							previousCondition = cur
							currentCondition = cur.left							
						}
						// We came from left and should have gotten a hit. Set next search to right before return true
						case cur.left: {
							previousCondition = cur
							currentCondition = cur.right
							return true							
						}
						// We came from right and should have gotten a hit. next search should be determined by parent if there is one
						case cur.right: {
							previousCondition = cur
							// Check for parent
							if (cur === rootCondition) {
								// If not we are done
								currentCondition = null
								return true
							} else {
								currentCondition = cur.eContainer as Condition
							}						
						}
					}
				}
				And: {
					switch (previousCondition) {
						// We started out here. This is root. We search left
						case cur, 
						// We came from parent and need to search left
						case cur.eContainer: {
							previousCondition = cur
							currentCondition = cur.left							
						}
						// We came from left and need to keep searching right
						case cur.left: {
							previousCondition = cur
							currentCondition = cur.right							
						}
						// We came from right and need to go up to possibly continue search
						case cur.right: {
							previousCondition = cur
							// Check for parent
							if (cur === rootCondition) {
								// If so we are done
								currentCondition = null
								return true
							} else {
								currentCondition = cur.eContainer as Condition
							}							
						}
					}
				}
				Parentheses,
					// treat Parentheses as Comparison
				Comparison: {
					comparisonChain.add(cur)
					previousCondition = cur
					if (cur === rootCondition) {
						currentCondition = null
						return true
					} else {
						currentCondition = cur.eContainer as Condition 
					}
				}
				default: {
					// currentCondition must be null -> nothing more to search
					return false
				}
			}
		}	
		return false
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
				comparisonChain.add(cond)
				return true
			}
		}
	}
}