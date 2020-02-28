package com.hemebiotech.analytics.inputdata;

import java.util.List;
/**
 * Generic interface for symptom reader. All reader class implement this interface
 * @author S058601
 *
 */
public interface ISymptomGenericReader {
	/**
	 * getSymptom() give a list of symptoms
	 * @return  a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */

	List<String> getSymptoms ();

	
}
