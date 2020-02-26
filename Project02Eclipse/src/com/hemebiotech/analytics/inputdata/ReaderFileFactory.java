package com.hemebiotech.analytics.inputdata;

import com.hemebiotech.analytics.Exceptions.PersonalExceptions;
import com.hemebiotech.analytics.inputdata.ReaderFile;

/**
 * 
 * @author S058601
 *
 */
public abstract class ReaderFileFactory {

	private String filepath;

	/**
	 * Class Constructor for Pattern Factory. Analyse file extension on 3 char.
	 * ".txt" for a file with 1 line per symptom. ".csv" for a file with all
	 * symptoms in 1line separate by ";"
	 * 
	 * @param filepath is the filepath of the inputfile .txt ou .csv
	 * @return ReaderFile object 
	 */
	public ReaderFile getReadFile(String filepath) {
		String extentionFile = "";
		this.filepath = filepath;
		ReaderFile readerFile = null;
		try {
			extentionFile = this.filepath.substring(this.filepath.length() - 4); //extention file detection 
			switch (extentionFile) {
			case ".txt":
				readerFile = new ReaderFileTxt(filepath);
				break;
			case ".csv":
				readerFile = new ReaderFileCsv(filepath);
				break;
			default: //extention file is not .txt or .csv
				System.out.println("Error : " + extentionFile + " is an unknown file extension");
				throw new PersonalExceptions("Exception : " + extentionFile + " is an unknown file extension");
			}
			return readerFile;
		}

		catch (PersonalExceptions e) {// treat personnal exception
			e.printStackTrace();
			return readerFile;
		}
	}

	/*
	 * @Override public List<String> getSymptoms() { // TODO Auto-generated method
	 * stub return null; }
	 */
}
