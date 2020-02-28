package com.hemebiotech.analytics.filefactory;

import com.hemebiotech.analytics.exceptions.PersonalExceptions;
import com.hemebiotech.analytics.filefactory.inputdata.FileReaderCsv;
import com.hemebiotech.analytics.filefactory.inputdata.FileReaderGeneric;
import com.hemebiotech.analytics.filefactory.inputdata.FileReaderTxt;
import com.hemebiotech.analytics.filefactory.outputdata.FileWriterConsole;
import com.hemebiotech.analytics.filefactory.outputdata.FileWriterGeneric;
import com.hemebiotech.analytics.filefactory.outputdata.FileWriterOut;

/**
 * 
 * @author S058601
 *
 */
//public abstract class ReaderFileFactory {
public class FileFactory {
	private String filepath;

//TODO E2lre, javadoc à refaire
	/**
	 * Read the input file. Analyse file extension on 4 char. ".txt" for a file with
	 * 1 line per symptom. ".csv" for a file with all symptoms in 1line separate by
	 * ";"
	 * 
	 * @param filepath is the filepath of the inputfile .txt ou .csv
	 * @return fileReader object
	 */
	public FileReaderGeneric getReader(String filepath) {
		String extentionFile = "";
		this.filepath = filepath;
		FileReaderGeneric fileReader = null;
		try {

			extentionFile = this.filepath.substring(this.filepath.length() - 4); // extention file detection
			switch (extentionFile) {
			case ".txt":
				fileReader = new FileReaderTxt(filepath);
				break;
			case ".csv":
				fileReader = new FileReaderCsv(filepath);
				break;
			default: // extention file is not .txt or .csv
				System.out.println("Error : " + extentionFile + " is an unknown file extension");
				throw new PersonalExceptions("Exception : " + extentionFile + " is an unknown file extension");
			}
			return fileReader;

		}

		catch (PersonalExceptions e) {// treat personnal exception
			e.printStackTrace();
			return fileReader;
		}
	}

	/**
	 * write report symptom on a file or in the console. Analyse file extension on 4
	 * chars. ".out" write the report on the .out file. otherwise show the report on the console
	 * 
	 * @param filepath is the filepath of the outputfile .out. if other value, result will be show in the console
	 * @return fileWriter object
	 */
	public FileWriterGeneric getWriter(String filepath) {
		String extentionFile = "";
		this.filepath = filepath;
		FileWriterGeneric fileWriter = null;

		extentionFile = this.filepath.substring(this.filepath.length() - 4); // extention file detection
		if (extentionFile.equals(".out")) {
			fileWriter = new FileWriterOut(filepath);
		} else {
			fileWriter = new FileWriterConsole(filepath);
		}
		return fileWriter;
	}
}
