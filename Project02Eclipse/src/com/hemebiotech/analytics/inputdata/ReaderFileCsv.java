package com.hemebiotech.analytics.inputdata;

import java.util.ArrayList;
import java.util.List;

/**
 * ReaderFileCsv is the implementationof the mother class of ReaderFile for .csv file.
 * It implements getSymptoms method of the interface ISymptomGenericReader
 * @author S058601
 *
 */
public class ReaderFileCsv extends ReaderFile {

	/**
	 * ReaderFileCsv(filepath) in the constructor of ReaderFileCsv class
	 * @param filepath  is the .csv filepath
	 */
	public ReaderFileCsv(String filepath) {
		
		super.filepath = filepath;
	}

	@Override
	public List<String> getSymptoms() {

		System.out.println("Read .csv format");

		ArrayList<String> result = new ArrayList<String>();

		ReadPhysicalFile myFile = new ReadPhysicalFile();

		List<String> line = myFile.getLines(this.filepath); // all the symptom are not in line

		String csvSeparator = ";"; 

		for (String myLine : line) { //for all the line in the input file, symptoms are detected between ";" and put the list
			String[] symptomList = myLine.split(csvSeparator);
			for (String symptom : symptomList) {
				result.add(symptom);
			}
		}
		return result;
	}
}
