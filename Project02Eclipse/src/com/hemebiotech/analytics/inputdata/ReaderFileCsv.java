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
    
	System.out.println("Lecture au format .csv");
    
    ArrayList<String> result = new ArrayList<String>();
    
    if (this.filepath != null) {
		try {
			BufferedReader reader = new BufferedReader (new FileReader(filepath));
			String line = reader.readLine();
			String csvSeparator = ";";
			
			while (line != null) {
				//result.add(line); //TODO E2lre a retirer
				String[] symptomList = line.split(csvSeparator);
				for (String symptom : symptomList) {
					result.add(symptom);
				}
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
