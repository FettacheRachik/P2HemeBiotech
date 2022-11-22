package com.hemebiotech.analytics.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.analytics.utils.ICountOrderSymptom;
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
	private ICountOrderSymptom countOrderSymptoms;
	
	
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
	
	

	public ICountOrderSymptom getCountOrderSymptoms() {
		return countOrderSymptoms;
	}

	public void setCountOrderSymptoms(ICountOrderSymptom countOrderSymptoms) {
		this.countOrderSymptoms = countOrderSymptoms;
	}

	/**
	 * Methode qui a partir du fichier contenant les symptomes , va les insérer dans une liste
	 * @return liste des Symptomes
	 */
	public List<String> getListSymptoms () {
		
		return this.reader.getSymptoms();
	}
	
	/**
	 * Methode to count occurrence of symptomes
	 * @return Map<String,Integer> 
	 */
	
	public Map <String,Integer> countOccurenceSymptoms (){
		
		List <String> listSymptoms=this.getListSymptoms();
		
		return this.countOrderSymptoms.countSymptoms(listSymptoms);
	}
	
	/**
	 * Method To order symptoms
	 * @return Map<String,Integer
	 */
	public Map<String, Integer> orderOccurenceSymptoms() {
		
		Map<String,Integer> mapSymptoms = this.countOccurenceSymptoms();
		return this.countOrderSymptoms.orderSymptoms(mapSymptoms);
		
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
