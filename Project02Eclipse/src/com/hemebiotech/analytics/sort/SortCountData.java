package com.hemebiotech.analytics.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Use to count all symptoms in a sorted list
 *
 */

public class SortCountData {//TODO a supprimer implements ISymptomCountData {
	
	private ArrayList<String> myList = new ArrayList<String>();
		
	/**
	 * Class constructor 
	 * 
	 * @param setSymptoms : List of symptom
	 */
	public SortCountData (List<String> setSymptoms) {
			myList.addAll(setSymptoms);
	}
	
	/**
	 * count all the symptoms and return an alphabetic sort map with all the symptoms
	 * 
	 * @return sorted list of symptom
	 */
	//@Override
	public Map<String,Integer> setSymptoms() {
		
		Map<String,Integer> table = new HashMap<String,Integer>();

		ValueComparator comparator = new ValueComparator();
		TreeMap<String,Integer> mapSort = new TreeMap<String,Integer>(comparator);
		
		int count = 0;		
		
		for	(int i = 0; i < myList.size(); i++) {
				
			if (table.containsKey(myList.get(i))) {
				count = table.get(myList.get(i));
				table.put(myList.get(i),count+1);
			}
			else {
				table.put(myList.get(i), 1);
			}

		}

		mapSort.putAll(table);
		
		return mapSort;
	}
	

}