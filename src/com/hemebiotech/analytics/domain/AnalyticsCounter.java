package com.hemebiotech.analytics.domain;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.utils.CountOrderSymptom;
import com.hemebiotech.analytics.utils.ISymptomReader;
import com.hemebiotech.analytics.utils.ISymptomWriter;

/**
 * Class define the differents functionnals methods
 * @author moi
 *
 */

public class AnalyticsCounter {
	
	
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	
	
	/*
	 * setter and Getter
	 */
	public ISymptomReader getReader() {
		return reader;
	}

	public void setReader(ISymptomReader reader) {
		this.reader = reader;
		
	}
	
	
	public ISymptomWriter getWriter() {
		return writer;
	}

	public void setWriter(ISymptomWriter writer) {
		this.writer = writer;
	}
	
	

	/**
	 * Methode qui a partir du fichier contenant les symptomes , va les insérer dans une liste
	 * @return liste des Symptomes
	 */
	private List<String> getListSymptoms () {
		
		return this.reader.getSymptoms();
	}
	
	/**
	 * Methode to count occurrence of symptomes
	 * @return Map<String,Integer> 
	 */
	
	private Map <String,Integer> countOccurenceSymptoms (){
		
		List <String> listSymptoms=this.getListSymptoms();
		
		return CountOrderSymptom.countSymptoms(listSymptoms);
	}
	
	/**
	 * Method To order symptoms
	 * @return Map<String,Integer
	 */
	private Map<String, Integer> orderOccurenceSymptoms() {
		
		Map<String,Integer> mapSymptoms = this.countOccurenceSymptoms();
		return CountOrderSymptom.orderSymptoms(mapSymptoms);
		
	}

	
	/**
	 * Method to writer symptoms with numbers of occurence in a file
	 * @param mapOrderSymptoms
	 */
	public void writeSymptoms () {
		
		Map <String,Integer >mapOrderSymptoms= this.orderOccurenceSymptoms();
		this.writer.writeSymptoms(mapOrderSymptoms);
	}
	
	
		
	

	
}
