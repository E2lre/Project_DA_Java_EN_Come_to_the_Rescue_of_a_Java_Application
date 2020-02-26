package com.hemebiotech.analytics.inputdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hemebiotech.analytics.io.PersonalExceptions;

public class ReaderFileTxt extends ReaderFile {
	
	private String filepath;
	
	public ReaderFileTxt (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
	    System.out.println("Read .txt format");
	    ArrayList<String> result = new ArrayList<String>();
	    
	    ReadPhysicalFile myFile = new ReadPhysicalFile();
	   
	    result.addAll(myFile.getLines(this.filepath));

	    return result; 
	  }
	}	
