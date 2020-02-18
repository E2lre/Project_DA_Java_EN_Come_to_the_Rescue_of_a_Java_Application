package com.hemebiotech.analytics;


import java.util.TreeMap;

/**
 * all the data in a sorted list
 * 
 * 
 */
public interface ISymptomWriter {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a sort list
	 */
	TreeMap<String,Integer> SetSymptoms ();
}
