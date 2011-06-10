package modulo2.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Map;
import java.util.HashMap;

public class ConfigManager {
	private Map<String, String> config;
	public ConfigManager() {
		FileManager storageFile = new FileManager("/resources/config/storage.cfg");
		FileManager dbFile = new FileManager("/resources/config/db.cfg");
		BufferedReader storageReader = storageFile.getReader();
		BufferedReader dbReader = dbFile.getReader();
		if(storageReader != null && dbReader != null) {
			
		}
	}
	public Map<String, String> getConfig() {
		return this.config;
	}
}
