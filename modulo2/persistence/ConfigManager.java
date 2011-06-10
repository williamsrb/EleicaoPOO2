package modulo2.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Map;
import java.util.HashMap;

public class ConfigManager {
	private Map config;
	public ConfigManager() {
		BufferedReader storageReader = FileManager.getReader("/resources/config/storage.cfg");
		BufferedReader dbReader = FileManager.getReader("/resources/config/db.cfg");
		if(storageReader != null && dbReader != null)
	}
	public Map getConfig() {
		return this.config;
	}
}
