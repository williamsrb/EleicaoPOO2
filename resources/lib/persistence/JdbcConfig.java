package resources.lib.persistence;

public final class JdbcConfig {
	private String username;
	private String password;
	private String url;
	private String driver;
	
	public JdbcConfig(String username, String password, String url, String driver) {
		this.username = username;
		this.password = password;
		this.url = url;
		this.driver = driver;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public String getUrl() {
		return url;
	}
	
	public String getDriver() {
		return driver;
	}

}