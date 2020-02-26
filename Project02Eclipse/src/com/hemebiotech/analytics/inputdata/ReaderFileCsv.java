package com.hemebiotech.analytics.inputdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hemebiotech.analytics.io.PersonalExceptions;

public class ReaderFileCsv extends ReaderFile {
private String filepath;

public ReaderFileCsv (String filepath) {
	this.filepath = filepath;
}

@Override
public List<String> getSymptoms() {
    
	System.out.println("Read .csv format");
    
    ArrayList<String> result = new ArrayList<String>();
    
    ReadPhysicalFile myFile = new ReadPhysicalFile();
    
    List<String> line = myFile.getLines(this.filepath);
	
	String csvSeparator = ";";
    
	for (String myLine : line) {
		String[] symptomList = myLine.split(csvSeparator);
		for (String symptom : symptomList) {
			result.add(symptom);
		}
	}
    return result; 
  }
}	
