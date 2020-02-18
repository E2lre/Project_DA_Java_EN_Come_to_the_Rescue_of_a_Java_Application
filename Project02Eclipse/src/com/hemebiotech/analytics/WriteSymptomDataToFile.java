package com.hemebiotech.analytics;

//import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Set;


public class WriteSymptomDataToFile  {
	
	private String filepath;
	//Map<String,Integer> table = new HashMap<String,Integer>();
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}
	

	public boolean WriteSymptoms(TreeMap<String,Integer> mapTree) {
		try {
			System.out.println (mapTree);// a retirer COMPRENDRE PB CL2 NON TROUVEE DANS TREE ?????
			FileWriter writer = new FileWriter(filepath);
			Set<Entry<String, Integer>> entires = mapTree.entrySet();
			for(Entry<String,Integer> ent:entires){
	            writer.write (ent.getKey() +";"+ ent.getValue() + "\n");
				System.out.println(ent.getKey() +";"+ ent.getValue()); // a retirer
	        }
			//String j="";
			/*for	(String i :mapTree.keySet()) {
				String j = mapTree.keySet().toArray()[0];
				writer.write (i +";"+ mapTree.get(i.toString()) + "\n");
				System.out.println(i +";"+ mapTree.get(i)); // a retirer
				mapTree.en
				if (mapTree.containsKey(i.toString())) {
					System.out.println("contient");
				}
				else {
					System.out.println("ne contient pas"); 
				}
				if (mapTree.containsKey("fever")) {
					System.out.println("contient fever");
				}
				else {
					System.out.println("ne contient pas fever"); 
				}
				
			}
			System.out.println (mapTree);// a retirer
			*/
			writer.close();
			return true;
		} 
		catch (IOException e) {
		e.printStackTrace();
		return false;
		}
	}
		
}