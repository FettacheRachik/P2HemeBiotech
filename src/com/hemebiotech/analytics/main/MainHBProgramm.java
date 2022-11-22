package com.hemebiotech.analytics.main;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.domain.AnalyticsCounter;
import com.hemebiotech.analytics.utils.CountOrderSymptom;
import com.hemebiotech.analytics.utils.ICountOrderSymptom;
import com.hemebiotech.analytics.utils.ISymptomReader;
import com.hemebiotech.analytics.utils.ReadSymptomDataFromFile;

/**
 * Main class Programm *
 * 
 * @author Rachik Fettache
 *
 */
public class MainHBProgramm {

	public static void main(String[] args) {

		// Créer un objet ISymptomReader
		ISymptomReader reader = new ReadSymptomDataFromFile("ressources/symptoms.txt");

		// Creer un objet AnalyticsCounter
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		analyticsCounter.setReader(reader);

		

		
		// Creer un objet CountOrderSymptom

		ICountOrderSymptom countOrderSymptom = new CountOrderSymptom();
		analyticsCounter.setCountOrderSymptoms(countOrderSymptom);
		
		//Map avec le nombre d occurences des symptomes
		Map<String, Integer> mapOccurenceSymptoms = analyticsCounter.countOccurenceSymptoms();
		
		//Map ordonne treemap
		Map<String , Integer> orderMapSymptoms = analyticsCounter.orderOccurenceSymptoms();

		for (Map.Entry mapentry : orderMapSymptoms.entrySet()) {
			System.out.println("clé: " + mapentry.getKey()
					+ " | valeur: " + mapentry.getValue());
		}

	

	}

}
