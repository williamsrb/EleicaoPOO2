package resources.lib.persistence;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class ConfigManager {
	public static String getStorageMethod() {
		String storMtd;
		storMtd = ConfigBuilder.getInstance().getConfig().get("Persistence");
		if(storMtd == null) {
			System.err.println("Não foi possível encontrar configuração de persistência.\nDesabilitando persistência.");
		}
		return storMtd;
	}
	
	public static JdbcConfig getJdbcConfig() {
		String username;
		String password;
		String url;
		String driver;
		JdbcConfig conf = null;
		Map<String, String> config = ConfigBuilder.getInstance().getConfig();
		
		username = config.get("Username");
		password = config.get("Password");
		url = config.get("Url");
		driver = config.get("Driver");
		
		if(username == null || password == null || url == null || driver == null) {
			System.err.println("Não foi possível encontrar configuração do JDBC.\nDesabilitando persistência.");
		} else {
			conf = new JdbcConfig(username, password, url, driver);
		}
		
		return conf;
	}
	
	public static URI getFileConfig() {
		URI fileUri = null;
		try {
			fileUri = new URI(ConfigBuilder.getInstance().getConfig().get("Persistence"));
		} catch (URISyntaxException use) {
			System.err.println(use.getLocalizedMessage());
		}
		if(fileUri == null) {
			System.err.println("Não foi possível encontrar configuração de arquivo.\nDesabilitando persistência.");
		}
		return fileUri;
	}
}
