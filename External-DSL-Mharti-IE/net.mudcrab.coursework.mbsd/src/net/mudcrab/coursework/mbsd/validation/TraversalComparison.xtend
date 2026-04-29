package net.mudcrab.coursework.mbsd.validation

import java.util.ArrayList
import net.mudcrab.coursework.mbsd.ifictiondsl.Comparison

class TraversalComparison {
	
	private ArrayList<Comparison> comparisonList
	
	new (Comparison comparison) {
		this.comparisonList = new ArrayList<Comparison>()
		this.comparisonList.add(comparison)
	}
	
	public def addComparison(Comparison comparison) {
		this.comparisonList.add(comparison)
	}
	
	public def ArrayList<Comparison> getComparisonList() { comparisonList }
}