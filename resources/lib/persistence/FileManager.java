package resources.lib.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class FileManager {
	private String file;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	public FileManager(String file) {
		this.file = file;
	}
	
	public BufferedReader getReader() {
		String file = this.file;
		FileReader fIn = null;
		BufferedReader brIn = null;
		if(this.reader == null && this.writer == null) {
			try {
				fIn = new FileReader(file);
				brIn = new BufferedReader(fIn);
			} catch (FileNotFoundException fnfe) {
				System.err.println(resources.lib.other.Debug.getTrace(fnfe.getLocalizedMessage()));
			} catch (IllegalArgumentException iae) {
				System.err.println(resources.lib.other.Debug.getTrace(iae.getLocalizedMessage()));
			}
			this.reader = brIn;
		} else {
			if(this.reader != null) {
				brIn = this.reader;
			}
		}
		return brIn;
	}

	public BufferedWriter getWriter() {
		String file = this.file;
		FileWriter fIn = null;
		BufferedWriter bwIn = null;
		if(this.writer == null && this.reader == null) {
			try {
				fIn = new FileWriter(file, true);
				bwIn = new BufferedWriter(fIn);
			} catch (FileNotFoundException fnfe) {
				System.err.println(fnfe.getLocalizedMessage());
			} catch (IllegalArgumentException iae) {
				System.err.println(iae.getLocalizedMessage());
			} catch (IOException ioe) {
				System.err.println(ioe.getLocalizedMessage());
			}
			this.writer = bwIn;
		} else {
			if(this.writer != null) {
				bwIn = this.writer;
			}
		}
		return bwIn;
	}
	
	public static String nextUncommentedLine(BufferedReader reader) {
		String temp = null, returnVal = null;
		boolean got = false;
		try {
			while(!got && ((temp = reader.readLine()) != null)) {
				if(temp.length() > 0 && (temp.charAt(0) != '#')) { //Se a linha não estiver comentada
					got = true;
					returnVal = temp;
				}
			}
		} catch(IOException ioe2) {
			System.err.println(resources.lib.other.Debug.getTrace(ioe2.getLocalizedMessage()));
		}
		return returnVal;
	}
	
	protected void finalize() throws Throwable {
		try {
			this.reader.close();
			this.writer.close();
		} catch (IOException ioe) {
			System.err.println("Os arquivos já estavam fechados.\n" + ioe.getLocalizedMessage());
		}
	}
}