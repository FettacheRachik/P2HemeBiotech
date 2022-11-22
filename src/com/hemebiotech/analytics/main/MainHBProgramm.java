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

		// List des Symptomes
		List<String> listeSymptoms = analyticsCounter.getListSymptoms();

		System.out.println("Liste des symptomes" + listeSymptoms);
		
		//Creer un objet CountOrderSymptom
		
		ICountOrderSymptom countOrderSymptom = new CountOrderSymptom();
		
		
		analyticsCounter.setCountOrderSymptoms(countOrderSymptom);
		
		Map <String,Integer> mapSymptoms = analyticsCounter.countOccurenceSymptoms();
		
		for (Map.Entry mapentry : mapSymptoms.entrySet()) {
			 System.out.println("clé: "+mapentry.getKey() 
			 + " | valeur: " + mapentry.getValue());
			 }
		
		//
		
		
		
	}

}
