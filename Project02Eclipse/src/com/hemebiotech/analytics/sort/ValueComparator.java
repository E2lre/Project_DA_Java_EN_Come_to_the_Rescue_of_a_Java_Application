package com.hemebiotech.analytics.sort;


import java.util.Comparator;


/**
 * Use sort the list of symptom
 *
 */

public class ValueComparator implements Comparator<String> {
	

	@Override
	public int compare(String a, String b) {
		if (a.compareTo(b) >= 0) {
			return 1;
		} 
		else {
			return -1;
		}
	}
}
