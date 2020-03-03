package com.hemebiotech.analytics.filefactory.inputdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hemebiotech.analytics.exceptions.PersonalExceptions;

/**
 * Mother abstract class for read
 * 
 * @author S058601
 *
 */
public abstract class FileReaderGeneric implements ISymptomGenericReader {

	protected String filepath; // containt the filepath for childclass
	
	/**
	 * 
	 * @param filepath is the filepath of the inputfile .txt ou .csv
	 * @return List of symptoms
	 */
	public List<String> getLines(String filepath) {
		BufferedReader reader = null;
		ArrayList<String> result = new ArrayList<String>();
		try {
			if (filepath != null) {
				try {
					reader = new BufferedReader(new FileReader(filepath));
					String line = reader.readLine();
	
					while (line != null) {
						result.add(line);
						line = reader.readLine();
					}
					reader.close();
	
					if (result.isEmpty()) { // check if symptom list is empty
						throw new PersonalExceptions("Symptom List is empty");
					}
	
					System.out.println(result.size() + " lines read in input file " + filepath);
	
				} 
				catch (IOException e) {
					e.printStackTrace();
					return result;
				} 
				catch (PersonalExceptions e) {// treat symptom list is empty
					e.printStackTrace();
					return result;
				}
				finally {
					reader.close();
				}
			}
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
			return result;
		}

	}
}
