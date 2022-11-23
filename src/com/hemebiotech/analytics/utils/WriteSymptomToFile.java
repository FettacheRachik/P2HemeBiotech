package com.hemebiotech.analytics.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomToFile implements ISymptomWriter {

private String filePath;
	
	
	//Constructor
	public WriteSymptomToFile(String filePath) {
	this.filePath =filePath;
	}



	@Override
	public void writeSymptoms(Map<String, Integer> symptomes)  {
		
		//Use to write in a file
		try (FileWriter fileWriter = new FileWriter(filePath, false);
				BufferedWriter writer = new BufferedWriter(fileWriter);)
		
		{
			//Get each symptom with number of occurence and write it in file
			for (Map.Entry<String,Integer> mapentry : symptomes.entrySet()) {
				writer.write(mapentry.getKey() + " : " + mapentry.getValue());
	
				writer.newLine();

			}

		} catch (IOException e) {
			System.err.println (e.getMessage());
			//Exit from application
			System.exit(1);
		}
			      
		
		
	}

	
	
	

}
