package resources.lib.persistence;

public final class JdbcConfig {
	private String username;
	private String password;
	private String url;
	private String driver;
	
	JdbcConfig(String username, String password, String url, String driver) {
		this.username = username;
		this.password = password;
		this.url = url;
		this.driver = driver;
	}
	
	String getUsername() {
		return username;
	}
	
	String getPassword() {
		return password;
	}

	String getUrl() {
		return url;
	}
	
	String getDriver() {
		return driver;
	}

}