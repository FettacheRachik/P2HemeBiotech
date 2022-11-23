package com.hemebiotech.analytics.main;

import com.hemebiotech.analytics.domain.AnalyticsCounter;
import com.hemebiotech.analytics.utils.ISymptomReader;
import com.hemebiotech.analytics.utils.ISymptomWriter;
import com.hemebiotech.analytics.utils.PathFile;
import com.hemebiotech.analytics.utils.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.utils.WriteSymptomToFile;

/**
 * Main class Programm HemeBiotech Analyse a file symptoms.txt contains symptoms
 * , count occurence for each and order them Write in result.out
 * 
 * @author Rachik Fettache
 * @version 1.0.0
 */
public class MainHBProgramm {

	public static void main(String[] args) {

		// Declare path output and input file
		String inputPathFile = PathFile.INPUT.getPath();
		String outputPathFile = PathFile.OUTPUT.getPath();

		// Create one file to read
		ISymptomReader reader = new ReadSymptomDataFromFile(inputPathFile);
		// Create one file to write
		ISymptomWriter writer = new WriteSymptomToFile(outputPathFile);

		// Create an AnalyticsCounter
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();

		// Use setters methods
		analyticsCounter.setReader(reader);
		analyticsCounter.setWriter(writer);

		// Write symptoms into result.out file
		analyticsCounter.writeSymptoms();

	}

	

}
