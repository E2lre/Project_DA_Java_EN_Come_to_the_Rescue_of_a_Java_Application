package com.hemebiotech.analytics.inputdata;

import java.util.ArrayList;
import java.util.List;

public class ReaderFileCsv extends ReaderFile {


	public ReaderFileCsv(String filepath) {
		
		super.filepath = filepath;
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
