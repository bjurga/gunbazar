package pl.bjur.shooter.commons.Exceptions;


public class ErrorInfo {
	private final ERROR_CODE code;
	private final String message;

	public ErrorInfo(ERROR_CODE code, String message) {
		this.code = code;
		this.message = message;
	}

	public ERROR_CODE getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
