package com.hemebiotech.analytics.utils;
/**
 * Enum PathFile to get input path file and output path file
 * @author Rachik Fettache
 *
 */
public enum PathFile {
	
	INPUT("ressources/symptoms.txt"),
	OUTPUT("ressources/result.out");
	
	private String path;

	PathFile(String path) {
		this.path=path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	

}
