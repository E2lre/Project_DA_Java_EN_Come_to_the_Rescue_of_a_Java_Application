package com.hemebiotech.analytics.inputdata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hemebiotech.analytics.inputdata.ReaderFile;
import com.hemebiotech.analytics.io.PersonalExceptions;

/**
 * 
 * @author S058601
 *
 */
public abstract class ReadSymptomData implements ISymptomGenericReader {

	private String filepath;

	/**
	 * Class Constructor for PAttern Factory. Analyse file extension on 3 char. ".txt" for a file with 1 line per symptom. ".csv" for a file with all symptoms in 1line separate by ";"
	 * @param filepath
	 */
	public ReaderFile getReadFile(String filepath) {
		String extentionFile =""; 
		this.filepath = filepath;
		ReaderFile readerFile = null;
		try
		{
			extentionFile = this.filepath.substring(this.filepath.length()-4);
			switch (extentionFile) {
			case ".txt":
				readerFile = new ReaderFileTxt(filepath); 
				break;
			case ".csv":
				readerFile = new ReaderFileCsv(filepath);
				break;
			default:
				System.out.println("Error : " +extentionFile + " is an unknown file extension");
				throw new PersonalExceptions("Exception : " +extentionFile + " is an unknown file extension");
				//break;
			}
			return readerFile;
		}
		
		catch (PersonalExceptions e) {//treat personnal exception
			e.printStackTrace();
			return readerFile;
		}
	}
}
