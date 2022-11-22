package com.hemebiotech.analytics.utils;

import java.util.HashMap;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Implementation of interface IcountOrderSymptom
 * 
 * @author moi
 *
 */
public class CountOrderSymptom {

	
	
	public static Map<String, Integer> countSymptoms(List<String> listSymptomes) {
		
		Map<String, Integer> mapSymptomes = new HashMap<>();

		for (String symptome : listSymptomes) {
			mapSymptomes.putIfAbsent(symptome, 0);
			mapSymptomes.put(symptome, mapSymptomes.get(symptome) + 1);
		}
		
		

		return mapSymptomes;
		
	}

	
	public static Map<String, Integer> orderSymptoms(Map<String, Integer> mapSymptomes) {
		Map<String, Integer> orderSymptoms = new TreeMap<String, Integer>(mapSymptomes);
		return orderSymptoms;
	}

}
