package com.hemebiotech.analytics.inputdata;

import java.util.List;

public interface ISymptomGenericReader {
	/**
	 * 
	 * @return  a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> getSymptoms ();

}
