package resources.lib.persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import resources.lib.other.Singleton;

public final class ConfigBuilder implements Singleton {
	private Map<String, String> config;
	private static ConfigBuilder singleton;
	
	private ConfigBuilder() {
		FileManager storageFile = new FileManager("resources/config/storage.cfg");
		FileManager dbFile = new FileManager("resources/config/db.cfg");
		BufferedReader storageReader = storageFile.getReader();
		BufferedReader dbReader = dbFile.getReader();
		Map<String, String> localMap;
		if(storageReader == null || dbReader == null) {
			try {
				storageReader.close();
				dbReader.close();
			} catch(Exception e) {
				System.err.println(resources.lib.other.Debug.getTrace(e.getLocalizedMessage()));
			}
		} else {
			localMap = new HashMap<String, String>();
			genMap(storageReader, localMap);
			genMap(dbReader, localMap);
			this.config = localMap;
		}
	}	static synchronized ConfigBuilder getInstance() {
		if(singleton == null) {
			singleton = new ConfigBuilder();
		}
		return singleton;
	}
	
	public static void genMap(BufferedReader reader, Map<String, String> map) {
		String temp, tempArray[];
		temp = FileManager.nextUncommentedLine(reader);
		if(temp != null) {
			do {
				tempArray = temp.split("\t");
				if(tempArray.length == 2) {
					map.put(tempArray[0], tempArray[1]);
				}
				temp = FileManager.nextUncommentedLine(reader);
			} while(temp != null);
		}
	}
	
	Map<String, String> getConfig() {
		return this.config;
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}