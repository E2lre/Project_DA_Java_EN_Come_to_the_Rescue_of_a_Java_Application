package com.hemebiotech.analytics.inputdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hemebiotech.analytics.Exceptions.PersonalExceptions;

public class ReadPhysicalFile {

	public List<String> getLines(String filepath) {

		ArrayList<String> result = new ArrayList<String>();
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
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

			} catch (IOException e) {
				e.printStackTrace();
			} catch (PersonalExceptions e) {// treat symptom list is empty
				e.printStackTrace();
				// System.out.println("Personnal Error : " + e.getMessage());
			}
		}
		return result;
	}

}
