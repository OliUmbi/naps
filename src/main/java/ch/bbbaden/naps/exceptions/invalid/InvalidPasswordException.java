package ch.bbbaden.naps.exceptions.invalid;

public class InvalidPasswordException extends RuntimeException {
	public InvalidPasswordException (String message) {
		super("Invalid password: " + message);
	}
}
