package com.hemebiotech.analytics.utils;

import java.util.Map;
/**
 * will write symptom data which are order and count 
 */
public interface ISymptomWriter {

	
	/**
	 * 
	 * @param Map<String,Integer> symptomes order and count each of them
	 */
	public void writeSymptoms(Map<String, Integer> symptomes);

}
