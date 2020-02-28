package com.hemebiotech.analytics.inputdata;

import com.hemebiotech.analytics.exceptions.PersonalExceptions;
import com.hemebiotech.analytics.inputdata.FileReaderGeneric;

/**
 * 
 * @author S058601
 *
 */
//public abstract class ReaderFileFactory {
public class FileFactory {
	private String filepath;
//TOTO E2lre, javadoc à refaire
	/**
	 * Class Constructor for Pattern Factory. Analyse file extension on 3 char.
	 * ".txt" for a file with 1 line per symptom. ".csv" for a file with all
	 * symptoms in 1line separate by ";"
	 * 
	 * @param filepath is the filepath of the inputfile .txt ou .csv
	 * @return ReaderFile object
	 */
	public FileReaderGeneric getReadFile(String action, String filepath) {
		String extentionFile = "";
		this.filepath = filepath;
		FileReaderGeneric fileReader = null;
		try {
			if (action=="read") {
				
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
			else{
				return fileReader;
			}
			
		}

		catch (PersonalExceptions e) {// treat personnal exception
			e.printStackTrace();
			return fileReader;
		}
	}

}
