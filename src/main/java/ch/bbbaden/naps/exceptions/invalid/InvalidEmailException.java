package ch.bbbaden.naps.exceptions.invalid;

public class InvalidEmailException extends RuntimeException {
	public InvalidEmailException (String message) {
		super("Invalid email: " + message);
	}
}
