package Laboratorium04;

public class UserLoginRequest {
				
	private String identifier; // username or password
	private String password;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserLoginRequest(String identifier, String password) {
		this.identifier = identifier;
		this.password = password;
	}
	public UserLoginRequest(){}
}