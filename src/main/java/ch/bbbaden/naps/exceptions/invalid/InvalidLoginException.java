package ch.bbbaden.naps.exceptions.invalid;

public class InvalidLoginException extends RuntimeException {
	public InvalidLoginException (String email) {
		super("Invalid Login: " + email);
	}
}
