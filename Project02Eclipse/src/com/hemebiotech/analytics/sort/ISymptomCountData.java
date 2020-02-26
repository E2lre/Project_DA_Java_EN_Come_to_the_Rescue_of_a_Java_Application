package com.hemebiotech.analytics.sort;


//import java.util.TreeMap; // A supprimer
import java.util.Map;
/**
 * all the data in a sorted list
 * 
 * 
 */
public interface ISymptomCountData {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a sort list
	 */
	Map<String,Integer> setSymptoms ();
}
