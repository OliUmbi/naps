package ch.bbbaden.naps.exceptions.notfound;

public class TokenNotFoundException extends RuntimeException {
	public TokenNotFoundException (String token) {
		super("Token not found: " + token);
	}
}
