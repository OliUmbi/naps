package ch.bbbaden.naps.exceptions.alreadyexists;

public class AccountAlreadyExistsException extends RuntimeException {
	public AccountAlreadyExistsException (String email) {
		super("Account already exists: " + email);
	}
}
