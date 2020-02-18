package com.hemebiotech.analytics;


//import java.io.IOError;
//import java.io.IOException;
import java.util.ArrayList;

/**
 * Main class
 *
 */
public class AnalyticsCounter {
	/**
	 * Main method : get data from input file (one line per symptom), count and sort the datas (alphabetic). write result on output file : 
	 *<p> 		* Read datas in input file with ReadSymptomDataFromFile class</p>
	 *<p>		* Put the datas in symptomsList ArrayList</p>
	 *<p> 		* Count and sort datas with SortCountData class</p>
	 *<p> 		* write datas in output file with WriteSymptomDataToFile class</p>
	 *<p>		This program logs in the console to help the run team (for a best Quality Of Service) </p>
	 * @param args - optional: filepath, input file name, output file name
	 * @throws PersonalExceptions if input file doesn't exist or empty
	 */
	public static void main(String args[]) throws Exception {
		
		// Working directory for files
		String workDirectory = "C:\\Devenv\\git\\P2\\";
		// Name of files
		String inputFile = "symptoms.txt"; //symptom file
		String outputFile = "result.out"; //result file
		boolean result = false;
		
		try
		{
			System.out.println("Start Programm");
			
			//get args if send
			if (args.length > 0) {
				if (args.length>0) {
					workDirectory = args[0].toString();
					System.out.println("work directory in argument "+workDirectory);
				}
				if (args.length>1) {
					inputFile = args[1].toString();
					System.out.println("input file in argument "+inputFile);
				}
				if (args.length>2) {
					outputFile = args[2].toString();
					System.out.println("output file in argument "+outputFile);
				}
			}
			
			// Symptoms list
			ArrayList<String> symptomsList = new ArrayList<String>();
			
			//get all the symptom in the input file
			ReadSymptomDataFromFile getData = new ReadSymptomDataFromFile(workDirectory+inputFile);
						
			symptomsList.addAll(getData.GetSymptoms());
			
			//catch exeception if input file in empty or don't exist
			if (symptomsList.isEmpty()) { 
				throw new PersonalExceptions("Error on input file");
			}
			System.out.println("number of line read in input file "+inputFile+ " : "+ symptomsList.size());
			
			//prepare the sort symptom list
			SortCountData countData = new SortCountData(symptomsList);
			
			// initialize output file
			WriteSymptomDataToFile syntheticOutput = new WriteSymptomDataToFile(workDirectory+outputFile);
			
			//count, sort symptom and write in the output file
			result = syntheticOutput.WriteSymptoms(countData.SetSymptoms());
		
			if (result) {
				System.out.println("File " + inputFile + " treated correctly");
			}
			else {
				System.out.println("File " + inputFile + " treated with errors");
				throw new PersonalExceptions("File " + inputFile + " treated with errors");
			}
			
		}catch (PersonalExceptions e) {
			e.printStackTrace();
			System.out.println("Personnal Error : " + e.getMessage());
		}
		
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		
		

	}

}
