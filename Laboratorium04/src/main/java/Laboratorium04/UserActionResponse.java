package Laboratorium04;

public class UserActionResponse{

	private boolean success;
	private String message; // opcjonalne pole używane w przypadku błędu

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserActionResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
}