package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Use to read input file and preparing list of symptom
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * Read File Method : read all the line of the input file and return the data in a list
	 * 
	 * @param filepath : a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
				
				if (result.isEmpty()) {  //check if symptom list is empty
					throw new PersonalExceptions("Symptom List is empty");
				}

				System.out.println("Number of line read in input file "+filepath+ " : "+ result.size());

			} catch (IOException e) {
				e.printStackTrace();
			}
			catch (PersonalExceptions e) {//treat symptom list is empty
				e.printStackTrace();
				System.out.println("Personnal Error : " + e.getMessage());
				
			}
		}
		return result;
	}

}
