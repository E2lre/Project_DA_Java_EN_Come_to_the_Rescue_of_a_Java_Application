package com.hemebiotech.analytics.filefactory.inputdata;

import java.util.ArrayList;
import java.util.List;

/**
 * ReaderFileCsv is the implementationof the mother class of ReaderFile for .csv file.
 * It implements getSymptoms method of the interface ISymptomGenericReader
 * @author S058601
 *
 */
public class FileReaderCsv extends FileReaderGeneric {

	/**
	 * ReaderFileCsv(filepath) is the constructor of ReaderFileCsv class to read a .csv file
	 * @param filepath  is the .csv filepath
	 */
	public FileReaderCsv(String filepath) {
		
		super.filepath = filepath;
	}

	@Override
	public List<String> getSymptoms() {

		System.out.println("Read .csv format");

		ArrayList<String> result = new ArrayList<String>();

		List<String> line = this.getLines(this.filepath); // all the symptom are not in line

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
