package com.hemebiotech.analytics;


import java.util.Map;
import java.util.Comparator;


/**
 * Use sort the list of symptom
 *
 */

public class ValueComparator implements Comparator<String> {
	
	private Map<String, Integer> base;
	
	public ValueComparator(Map<String, Integer> base) {
	this.base = base;
	}

	
	public int compare(String a, String b) {
		if (a.compareTo(b) >= 0) {
			return 1;
		} 
		else {
			return -1;
		}
	}
	public int compare2(String a, String b) {
		if (base.get(a) >= base.get(b)) {
			return -1;
		} 
		else {
			return 1;
		}
	}
}
