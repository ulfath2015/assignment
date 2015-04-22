package com.imaginea.assignment;

public class FileComparatorRunner {

	public static void main(String args[]) {

		FileComparator fileComparator = new FileComparator("FileNames.properties");
		fileComparator.findMatchingStrings();
	}

}
