package modulo2.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This program reads a text file line by line and print to the console. It uses
 * FileOutputStream to read the file.
 * 
 */
public class FileManager {

	private static BufferedReader getReader(String file) {
		FileReader fIn = null;
		BufferedReader brIn = null;
		try {
			fIn = new FileReader(file);
			brIn = new BufferedReader(fIn);
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe.getLocalizedMessage());
		} catch (IllegalArgumentException iae) {
			System.err.println(iae.getLocalizedMessage());
		}
		return brIn;
	}

	private static BufferedWriter getWriter(String file) {
		FileWriter fIn = null;
		BufferedWriter brIn = null;
		try {
			fIn = new FileWriter(file);
			brIn = new BufferedWriter(fIn);
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe.getLocalizedMessage());
		} catch (IllegalArgumentException iae) {
			System.err.println(iae.getLocalizedMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getLocalizedMessage());
		}
		return brIn;
	}
	
	
}
