package ch.bbbaden.naps.exceptions;

public class UnauthorizedException extends RuntimeException {
	public UnauthorizedException (String message) {
		super("Unauthorized: " + message);
	}
}
