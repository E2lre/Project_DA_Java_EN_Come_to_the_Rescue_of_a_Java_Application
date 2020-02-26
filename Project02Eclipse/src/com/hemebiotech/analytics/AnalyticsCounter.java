package com.hemebiotech.analytics;


import com.hemebiotech.analytics.io.ISymptomReader;
import com.hemebiotech.analytics.io.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.io.WriteSymptomDataToFile;
import com.hemebiotech.analytics.sort.ISymptomCountData;
import com.hemebiotech.analytics.sort.SortCountData;

import java.util.List;

import com.hemebiotech.analytics.inputdata.ISymptomGenericReader;
import com.hemebiotech.analytics.inputdata.ReadSymptomData; 
import com.hemebiotech.analytics.inputdata.*;


/**
 * Main class
 *
 */
public class AnalyticsCounter {

	/**
	 * Main method : get data from input file (one line per symptom), count and sort the datas (alphabetic). write result on output file : 
	 *<p> 		* filepath argugments preparation </p>
	 *<p> 		* Read datas in input file with ReadSymptomDataFromFile class</p>
	 *<p> 		* Count and sort datas with SortCountData class</p>
	 *<p> 		* write datas in output file with WriteSymptomDataToFile class</p>
	 *<p>		This program logs in the console to help the run team (for a best Quality Of Service) </p>
	 * @param args - optional: filepath, input file name, output file name
	 * @throws Exception if needed
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
		
			//filepath argugments preparation
			DataFile dataFile = new DataFile(args); 

			
			//get all the symptom in the input file
			// Old Version : ISymptomReader getData = new ReadSymptomDataFromFile(dataFile.inputFilePath);
			ReadSymptomData getData = new ReadSymptomData() //TODO E2lre comprendre cet Override
			{ 
				
				@Override
				public List<String> getSymptoms() {
					// TODO Auto-generated method stub
					return null;
				}
			};
			ReaderFile readerFile = null;
			readerFile = getData.getReadFile(dataFile.inputFilePath);
			
			
			
					
			//prepare the sort symptom list
			// OLD ISymptomCountData countData = new SortCountData(getData.getSymptoms()); //TODO E2lre a retier
			ISymptomCountData countData = new SortCountData(readerFile.getSymptoms());
			
			// initialize output file
			WriteSymptomDataToFile syntheticOutput = new WriteSymptomDataToFile(dataFile.outputFilePath);
			
			//count, sort symptom and write in the output file
			result = syntheticOutput.writeSymptoms(countData.setSymptoms());
		
			//End message
			if (result) {
				System.out.println("File " + dataFile.inputFilePath + " treated correctly");
			}
			else {
				System.out.println("File " + dataFile.inputFilePath + " treated with errors");
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
	}
	
}
