package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Set;

/**
 * Use to write the sorted list in the output file
 *
 */
public class WriteSymptomDataToFile  {
	
	private String filepath;
	
	
	/**
	 * Class constructor
	 * 
	 * @param filepath a full or partial path to file with treatment result, one symptom and the number of occurency per line
	 */
	public WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Write File Method : write in the output file the sort list
	 * 
	 * @param mapTree : a sorted maps with symptoms
	 * @return : boolean value. true if the output file is corrected generated, false if error
	 */
	public boolean WriteSymptoms(TreeMap<String,Integer> mapTree) {
		try {
			
			FileWriter writer = new FileWriter(filepath);
			Set<Entry<String, Integer>> entires = mapTree.entrySet();  //mapTree.get(index) is not running. a Set class is used
			
			for(Entry<String,Integer> ent:entires){
	            writer.write (ent.getKey() +"="+ ent.getValue() + "\n");
	        }

			writer.close();
			System.out.println("number of line wrote in the output file : "+ mapTree.size());
			return true;
		} 
		catch (IOException e) {
		e.printStackTrace();
		return false;
		}
	}
		
}