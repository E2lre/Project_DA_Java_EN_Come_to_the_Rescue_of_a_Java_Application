package com.hemebiotech.analytics.filefactory.outputdata;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;



public class FileWriterConsole extends FileWriterGeneric {
	/**
	 * FileWriterConsole(filepath) is the constructor of FileWriterConsole class to show symptoms report on the console
	 * @param filepath is the .txt filepath
	 */
	public FileWriterConsole(String filepath) {
		super.filepath = filepath;
	}

	@Override
	public  boolean reportSymptoms(Map<String,Integer> myMap) {
			
		System.out.println("Symptom Report write in the console");
		if (!myMap.isEmpty())
		{	
			Set<Entry<String, Integer>> entires = myMap.entrySet();  //mapTree.get(index) is not running. a Set class is used
			
			for(Entry<String,Integer> ent:entires){
				System.out.println(ent.getKey() +"="+ ent.getValue());
	        }
			
			System.out.println(myMap.size() + " symptoms found");
			return true;
		}
		else {
			System.out.println("No datas to print in the console");
			return false;
		}
	}
		
	
}
