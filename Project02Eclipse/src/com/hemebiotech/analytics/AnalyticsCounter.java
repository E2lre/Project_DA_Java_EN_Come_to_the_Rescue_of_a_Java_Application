package com.hemebiotech.analytics;


//import java.io.IOError;
//import java.io.IOException;
//import java.util.ArrayList;

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
		
	
		// Name of files
		//String inputFilePath ; //symptom file path
		//String outputFilePath; //result file path

		boolean result = false;

		try
		{
			//Start message
			System.out.println("Start Programm");
		
			DataFile dataFile = new DataFile(args);

			//get args if send
/*			if (args.length > 0) {
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
*/			
			// Symptoms list
//			ArrayList<String> symptomsList = new ArrayList<String>();
			
			//get all the symptom in the input file
			ISymptomReader getData = new ReadSymptomDataFromFile(dataFile.inputFilePath);
						
//			symptomsList.addAll(getData.GetSymptoms());
			
			//catch exeception if input file in empty or don't exist
/*			if (symptomsList.isEmpty()) { 
				throw new PersonalExceptions("Error on input file");
			}

			System.out.println("number of line read in input file "+inputFile+ " : "+ symptomsList.size());
*/			
			//prepare the sort symptom list
//			ISymptomWriter countData = new SortCountData(symptomsList);
			ISymptomWriter countData = new SortCountData(getData.GetSymptoms());
					
			// initialize output file
			WriteSymptomDataToFile syntheticOutput = new WriteSymptomDataToFile(dataFile.outputFilePath);
			
			//count, sort symptom and write in the output file
			result = syntheticOutput.WriteSymptoms(countData.SetSymptoms());
		
			//End message
			if (result) {
				System.out.println("File " + dataFile.inputFilePath + " treated correctly");
			}
			else {
//				throw new PersonalExceptions("File " + inputFile + " treated with errors");
				System.out.println("File " + dataFile.inputFilePath + " treated with errors");
			}
			
		}
//		catch (PersonalExceptions e) {
//			e.printStackTrace();
//		}
		
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
	}
	
}
