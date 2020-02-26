package com.hemebiotech.analytics.inputdata;

import java.util.ArrayList;
import java.util.List;

public class ReaderFileTxt extends ReaderFile {

	public ReaderFileTxt(String filepath) {
		super.filepath = filepath;
	}

	@Override
	public List<String> getSymptoms() {
		System.out.println("Read .txt format");
		ArrayList<String> result = new ArrayList<String>();

		ReadPhysicalFile myFile = new ReadPhysicalFile();

		result.addAll(myFile.getLines(this.filepath));

		return result;
	}
}
