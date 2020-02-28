package com.hemebiotech.analytics;

import com.hemebiotech.analytics.sort.SortCountData;
import com.hemebiotech.analytics.filefactory.DataFile;
import com.hemebiotech.analytics.filefactory.FileFactory;
import com.hemebiotech.analytics.filefactory.inputdata.ISymptomGenericReader;
import com.hemebiotech.analytics.filefactory.outputdata.ISymptomGenericWriter;

/**
 * Main class
 *
 */
public class AnalyticsCounter {

	/**
	 * Main method : get data from input file (one line per symptom for .txt or all symptoms in 1 line separate by ; in .csv), count and sort
	 * the datas (alphabetic). write result on output file :
	 * <p>	 * filepath argugments preparation </p>
	 * <p>
	 * * Read datas in input file with ReadSymptomDataFromFile class
	 * </p>
	 * <p>
	 * * Count and sort datas with SortCountData class
	 * </p>
	 * <p>
	 * * write datas in output file with WriteSymptomDataToFile class
	 * </p>
	 * <p>
	 * This program logs in the console to help the run team (for a best Quality Of
	 * Service)
	 * </p>
	 * 
	 * @param args - optional: filepath, input file name, output file name
	 * @throws Exception if needed
	 */
	public static void main(String args[]) throws Exception {

		// Name of files
		// String inputFilePath ; //symptom file path
		// String outputFilePath; //result file path

		boolean result = false;

		try {
			// Start message
			System.out.println("Start Programm");

			// filepath argugments preparation
			DataFile dataFile = new DataFile(args);

			// get all symptoms in the input file
			FileFactory myFileFactory = new FileFactory();
			ISymptomGenericReader readerFile = myFileFactory.getReader(dataFile.inputFilePath);
			
			// prepare the sort symptom list
			SortCountData countData = new SortCountData(readerFile.getSymptoms());

			// initialize output file
			ISymptomGenericWriter fileWriter = myFileFactory.getWriter(dataFile.outputFilePath);
			
			// count, sort symptom and write in the output file
			result = fileWriter.setSymptoms(countData.sortSymptoms());

			
			// End message
			if (result) {
				System.out.println("Correct treatment for file " + dataFile.inputFilePath);
			} else {
				System.out.println("Error of treatment for File " + dataFile.inputFilePath + " treated with errors");
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
