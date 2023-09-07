package model;

public class WifiProfile {
	
	private String name;
	private String password;
	
	public WifiProfile(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		
		String out = this.name + ": " + this.password;
		return out;
	}
	
	

}
