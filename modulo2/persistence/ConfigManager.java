package modulo2.persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class ConfigManager {
	private Map<String, String> config;
	public ConfigManager() {
		FileManager storageFile = new FileManager("/resources/config/storage.cfg");
		FileManager dbFile = new FileManager("/resources/config/db.cfg");
		BufferedReader storageReader = storageFile.getReader();
		BufferedReader dbReader = dbFile.getReader();
		Map<String, String> localMap;
		if(storageReader == null || dbReader == null) {
			try {
				storageReader.close();
				dbReader.close();
			} catch(Exception e) {
				System.err.println(e.getLocalizedMessage());
			}
		} else {
			localMap = new HashMap<String, String>();
			this.genMap(storageReader, localMap);
			this.genMap(dbReader, localMap);
			this.config = localMap;
		}
	}
	
	public Map<String, String> getConfig() {
		return this.config;
	}
	
	private String nextUncommentedLine(BufferedReader reader) {
		String temp = null, returnVal = null;
		boolean got = false;
		try {
			while(!got && ((temp = reader.readLine()) != null)) {
				if(temp.charAt(0) != '#') { //Se a linha não estiver comentada
					got = true;
					returnVal = temp;
				}
			}
		} catch(IOException ioe2) {
			System.err.println(ioe2.getLocalizedMessage());
		}
		return returnVal;
	}
	
	private void genMap(BufferedReader reader, Map<String, String> map) {
		String temp, tempArray[];
		temp = this.nextUncommentedLine(reader);
		if(temp != null) {
			do {
				tempArray = temp.split("\t");
				if(tempArray.length == 2) {
					map.put(tempArray[0], tempArray[1]);
				}
				temp = this.nextUncommentedLine(reader);
			} while(temp != null);
		}
	}
}
