package com.hemebiotech.analytics.inputdata;

import java.util.ArrayList;
import java.util.List;
/**
 * ReaderFileTxt is the implementationof the mother class of ReaderFile for .txt files.
 * It implements getSymptoms method of the interface ISymptomGenericReader
 * @author S058601
 *
 */
public class FileReaderTxt extends FileReaderGeneric {
	/**
	 * ReaderFileTxt(filepath) in the constructor of ReaderFileTxt class
	 * @param filepath is the .txt filepath
	 */
	public FileReaderTxt(String filepath) {
		super.filepath = filepath;
	}

	@Override
	public List<String> getSymptoms() {
		System.out.println("Read .txt format");
		ArrayList<String> result = new ArrayList<String>();

		result.addAll(this.getLines(this.filepath));// all the symptom are already in line

		return result;
	}
}
