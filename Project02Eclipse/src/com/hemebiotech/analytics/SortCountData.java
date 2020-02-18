package com.hemebiotech.analytics;

//import java.io.BufferedReader;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Use to count all symptoms in a sorted list
 *
 */

public class SortCountData implements ISymptomWriter {
	
	private ArrayList<String> myList = new ArrayList<String>();
		
	/**
	 * Class constructor 
	 * 
	 * @param SetSymptoms : List of symptom
	 */
	public SortCountData (ArrayList<String> SetSymptoms) {
			myList.addAll(SetSymptoms);
	}
	
	/**
	 * count all the symptoms and return an alphabetic sort map with all the symptoms
	 * 
	 * @return sorted list of symptom
	 */
	@Override
	public TreeMap<String,Integer> SetSymptoms() {
		
		Map<String,Integer> table = new HashMap<String,Integer>();
		
		ValueComparator comparateur = new ValueComparator(table);//
		TreeMap<String,Integer> mapTriee = new TreeMap<String,Integer>(comparateur);//
		
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

		mapTriee.putAll(table);
		
		return mapTriee;
	}
	

}