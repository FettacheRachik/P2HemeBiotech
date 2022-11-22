package com.hemebiotech.analytics.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hemebiotech.analytics.exceptions.FileEmptyException;
import com.hemebiotech.analytics.exceptions.NotAllowedCharacterException;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> getSymptoms() {

		// Liste contenant les symptomes
		ArrayList<String> listSymptoms = new ArrayList<String>();
		int countLine = 0;/* Pour compter le nombre de lignes */
		if (filepath != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {

				// Ligne du fichier
				String line = reader.readLine();

				// Test si fichier est vide
				if (line == null) {
					throw new FileEmptyException("Le fichier est vide");
				}

				// Lecture ligne par ligne
				while (line != null) {

					// Verifier les lignes
					if (line.matches(".*\\d.*")) {
						throw new NotAllowedCharacterException("Contenu du fichier est invalide");

						// Si ligne vide
					} else if (line.trim().length() == 0) {
						continue;

					} else {
						// Ajouter les lignes a la liste de symptomes
						listSymptoms.add(line);
						line = reader.readLine();

						countLine++;
					}

				}

				// Si aucune ligne
				if (countLine == 0)
					throw new FileEmptyException("Le fichier est vide");

			} catch (IOException | FileEmptyException | NotAllowedCharacterException e) {
				System.err.println(e.getMessage());
				// Sortir de l"application
				System.exit(1);
			}
		}

		return listSymptoms;
	}

}
