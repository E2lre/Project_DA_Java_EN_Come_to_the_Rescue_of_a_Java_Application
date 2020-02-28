package com.hemebiotech.analytics.filefactory.outputdata;


import java.util.Map;

/**
 * Generic interface for symptom writer. All writer class implement this interface
 * @author s058601
 *
 */
public interface ISymptomGenericWriter {
	/**
	 * setSymptoms write symptom report on afile
	 * @param myMap list of symptom with count
	 * @return true if write is ok, false if errors
	 */
	boolean setSymptoms (Map<String,Integer> myMap); 
}
