package com.hemebiotech.analytics.main;

import com.hemebiotech.analytics.domain.AnalyticsCounter;
import com.hemebiotech.analytics.utils.ISymptomReader;
import com.hemebiotech.analytics.utils.ISymptomWriter;
import com.hemebiotech.analytics.utils.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.utils.WriteSymptomToFile;

/**
 * Main class Programm *
 * 
 * @author Rachik Fettache
 *
 */
public class MainHBProgramm {

	public static void main(String[] args) {

		// Create one file to read
		ISymptomReader reader = new ReadSymptomDataFromFile("ressources/symptoms.txt");
		//Create one file to write
		ISymptomWriter writer = new WriteSymptomToFile("ressources/result.out");

		// Cretate an  AnalyticsCounter
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		
		//Use setters methods
		analyticsCounter.setReader(reader);
		analyticsCounter.setWriter(writer);

		
		//Write symptoms into result.out file
		analyticsCounter.writeSymptoms();

	

	}

}
