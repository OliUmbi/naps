package ch.bbbaden.naps.exceptions.notfound;

public class AccountNotFoundException extends RuntimeException {
	public AccountNotFoundException (String account) {
		super("Account not found: " + account);
	}
}
