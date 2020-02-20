package com.hemebiotech.analytics;

/**
 * Use to prepare the inputfile path and outputfile path
 *
 */
public class DataFile{

	public String inputFilePath;
	public String outputFilePath;
	
	
	/**
	 * Data file Method : prepare the inputfile path and outputfile path from param
	 *
	 * @param param - filepath, input file name, output file name
	 */
	public DataFile(String[] param) {
		// Working directory for files
		String workDirectory = "C:\\Devenv\\git\\P2\\";
		// Name of files
		String inputFile = "symptoms.txt"; //symptom file
		String outputFile = "result.out"; //result file
			
		//get param if send
		if (param.length > 0) {
			if (param.length>0) {
				workDirectory = param[0].toString();
				System.out.println("work directory in argument "+workDirectory);
			}
			if (param.length>1) {
				inputFile = param[1].toString();
				System.out.println("input file in argument "+inputFile);
			}
			if (param.length>2) {
				outputFile = param[2].toString();
				System.out.println("output file in argument "+outputFile);
			}
		}
		
		inputFilePath = workDirectory+inputFile;
		outputFilePath = workDirectory+outputFile;
	}
}