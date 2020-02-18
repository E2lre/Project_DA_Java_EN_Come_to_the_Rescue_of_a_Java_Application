package com.hemebiotech.analytics;

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

public class AnalyticsCounter {
	// ancienne donnée d'Alex à suprimer
	// private static int headCount = 0; // initialize to 0
	// private static int rashCount = 0; // initialize to 0
	// private static int pupilCount = 0; // initialize to 0

	/**
	 * Main method : gest date from file, sort te datas (alphabetic), write result on output file
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public static void main(String args[]) {
		// Working directory for files
		String workDirectory = "C:\\Devenv\\git\\P2\\";
		// Name of files
		String inputFile = "symptoms.txt"; //symptom file
		String outputFile = "result.out"; //result file
		boolean result = false;
		
		// Symptoms list
		ArrayList<String> symptomsList = new ArrayList<String>();
		// Synthetic Symptom
		//Map<String,Integer> syntheticSymptom = new HashMap<String,Integer>();
		
		ReadSymptomDataFromFile getData = new ReadSymptomDataFromFile(workDirectory+inputFile);
		//getData.GetSymptoms();
		symptomsList.addAll(getData.GetSymptoms());
		
		SortCountData countData = new SortCountData(symptomsList);
		//countData.SetSymptoms();
		
		WriteSymptomDataToFile syntheticOutput = new WriteSymptomDataToFile(workDirectory+outputFile);
		result = syntheticOutput.WriteSymptoms(countData.SetSymptoms());
	
		if (result) {
			System.out.println("File " + inputFile + " treated correctly");
		}
		else {
			System.out.println("File " + inputFile + " treated with errors");
		}
			
			
		
		

	}
	///**
	// * main_old : old method from Elex, must be supress before release******************************
	// * @param filepath a full or partial path to file with symptom strings in it, one per line
	// */
	//public static void main_old(String args[]) throws Exception {
	//	// first get input
	//BufferedReader reader = new BufferedReader(new FileReader(
	//		"C:\\Devenv\\git\\P2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt"));
	//String line = reader.readLine();
	////
	//int i = 0; // set i to 0
	//while (line != null) {
	//	i++; // increment i
	//	System.out.println("symptom from file: " + line);
	//	if (line.equals("headache")) {
	//		headCount++;
	//		System.out.println("number of headaches: " + headCount);
	//	} else if (line.equals("rush")) {
	//		rashCount++;
	//////	} else if (line.contains("pupils")) {
	//			pupilCount++;
	//		}
	//
	//	line = reader.readLine(); // get another symptom
	//}
	//
	//// next generate output
	//FileWriter writer = new FileWriter("result.out");
	//////writer.write("headache: " + headCount + "\n");
	//	writer.write("rash: " + rashCount + "\n");
	//	writer.write("dialated pupils: " + pupilCount + "\n");
	//	writer.close();
	//}
}
