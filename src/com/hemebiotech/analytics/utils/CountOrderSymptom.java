package com.hemebiotech.analytics.utils;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class CountOrderSymptom with static methods countSymptoms orderSymptoms
 * 
 * @author Rachik Fettache
 *
 */
public class CountOrderSymptom {

	/**
	 * Count each Symptom in a List
	 * 
	 * @param List<String> listSymptomes
	 * @return Map<String,Integer>
	 */
	public static Map<String, Integer> countSymptoms(List<String> listSymptomes) {

		Map<String, Integer> mapSymptomes = new HashMap<>();

		for (String symptome : listSymptomes) {
			mapSymptomes.putIfAbsent(symptome, 0);
			mapSymptomes.put(symptome, mapSymptomes.get(symptome) + 1);
		}

		return mapSymptomes;

	}
	
	/**
	 * Order in alphabetic each symptom
	 * @param Map <String,Integer>mapSymptomes
	 * @return Map<String,Integer>
	 */

	public static Map<String, Integer> orderSymptoms(Map<String, Integer> mapSymptomes) {
		Map<String, Integer> orderSymptoms = new TreeMap<String, Integer>(mapSymptomes);
		return orderSymptoms;
	}

}
