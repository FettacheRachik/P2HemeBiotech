package com.hemebiotech.analytics.utils;

import java.util.Map;

public interface ISymptomWriter {
	
	/**
	* 
	* A partir d'une Map triée et ordonnée, ecrire dans un fichier les items de la map
	* 
	* */
	
		 
		public void writeSymptoms (Map <String,Integer> symptomes);

	}


