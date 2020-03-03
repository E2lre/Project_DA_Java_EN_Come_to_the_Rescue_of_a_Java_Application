package com.hemebiotech.analytics.filefactory.outputdata;



import java.util.Map;



public class FileWriterOut extends FileWriterGeneric {
	/**
	 * FileWriterOut(filepath) is the constructor of FileWriterOut class to write symptoms report on a .out file
	 * @param filepath is the .txt filepath
	 */
	public FileWriterOut(String filepath) {
		super.filepath = filepath;
	}
	
	@Override
	public  boolean reportSymptoms(Map<String,Integer> myMap) {
		System.out.println("Write .out format");
		return this.writeSymptoms(myMap);
	}
}
