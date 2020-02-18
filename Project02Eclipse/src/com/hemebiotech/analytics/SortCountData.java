package com.hemebiotech.analytics;

//import java.io.BufferedReader;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;



public class SortCountData implements ISymptomWriter {
	
	private ArrayList<String> myList = new ArrayList<String>();
	
	public SortCountData (List myList) {
		this.myList.addAll(myList);
	}
	
	@Override
	public TreeMap<String,Integer> SetSymptoms() {
		
		Map<String,Integer> table = new HashMap<String,Integer>();
		
		ValueComparator comparateur = new ValueComparator(table);//
		TreeMap<String,Integer> mapTriee = new TreeMap<String,Integer>(comparateur);//
		
		int count = 0;
		//String test="";
		
		
		for	(int i = 0; i < myList.size(); i++) {
				
			if (table.containsKey(myList.get(i))) {
				count = table.get(myList.get(i));
				table.put(myList.get(i),count+1);
			}
			else {
				table.put(myList.get(i), 1);
			}
			//test= myList.get(i);
			//count = table.get(myList.get());
		}

		mapTriee.putAll(table);
		
		return mapTriee;
	}
	/*public Map<String,Integer> SetSymptoms() {
		
		Map<String,Integer> table = new HashMap<String,Integer>();
		
		ValueComparator comparateur = new ValueComparator(table);//
		TreeMap<String,Integer> mapTriee = new TreeMap<String,Integer>(comparateur);//
		
		int count = 0;
		String test="";
		
		
		for	(int i = 0; i < myList.size(); i++) {
				
			if (table.containsKey(myList.get(i))) {
				count = table.get(myList.get(i));
				table.put(myList.get(i),count+1);
			}
			else {
				table.put(myList.get(i), 1);
			}
			test= myList.get(i);
			//count = table.get(myList.get());
		}

		mapTriee.putAll(table);
		table.clear();
		table.putAll(mapTriee);
		
		return table;
	}
	*/
	

}