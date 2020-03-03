package com.hemebiotech.analytics.filefactory.outputdata;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Mother abstract class for write
 * @author s058601
 *
 */
public abstract class FileWriterGeneric implements ISymptomGenericWriter{
	
	protected String filepath; // containt the filepath for childclass
	
	/**
	 * Write File Method : write in the output file the sort list
	 * 
	 * @param myMap : a sorted maps with symptoms
	 * @return boolean value. true if the output file is corrected generated, false if error
	 */

	public boolean writeSymptoms(Map<String,Integer> myMap)  {
		FileWriter writer = null;
		try {
			if (!myMap.isEmpty())
			{	
				try {
					writer = new FileWriter(filepath);
					Set<Entry<String, Integer>> entires = myMap.entrySet();  //mapTree.get(index) is not running. a Set class is used
					
					for(Entry<String,Integer> ent:entires){
			            writer.write (ent.getKey() +"="+ ent.getValue() + "\n");
			        }
		
					//writer.close();
					System.out.println(myMap.size() + " lines wrote in the output file " + this.filepath);
					return true;
				}
				finally {
					writer.close();
				}
			}
			else {
				System.out.println("No datas to write on ouput file " + this.filepath);
				return false;
			}
		} 
		catch (IOException e) {
		e.printStackTrace();
		return false;
		}

	}
	
}
