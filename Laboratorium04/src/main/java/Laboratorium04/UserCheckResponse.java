package Laboratorium04;

public class UserCheckResponse{
			
				private long id;
				private String username;
				private String email;

	public UserCheckResponse(long id, String username, String email) {
		this.id = id;
		this.username = username;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}