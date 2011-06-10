package modulo2.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	private String file;
	
	public FileManager(String file) {
		this.file = file;
	}
	
	public BufferedReader getReader() {
		String file = this.file;
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

	public BufferedWriter getWriter() {
		String file = this.file;
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
	
	public static 
}
