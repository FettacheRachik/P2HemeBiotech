package com.hemebiotech.analytics.utils;

import java.util.List;
import java.util.Map;


/**
 * Interface with two methods :one to count , other to order the symptoms
 * 
 * 
 */
public interface ICountOrderSymptom {
	
	
	/**
	 * Method to count Symptoms
	 * @param listeSymptomes
	 * @return une Map with clé:symptoms and valeur:nombre d 'occurence du symptome
	 */
	public Map<String, Integer> countSymptoms(List<String> listSymptomes);
	
	
	/**
	 * Method to class symptoms
	 * @param mapSymptomes type Map<String,Integer>
	 * @return TreeMap
	 */

	Map<String, Integer> orderSymptoms(Map<String, Integer> mapSymptomes);

}
