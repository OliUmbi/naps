package ch.bbbaden.naps.exceptions.notfound;

public class RoleNotFoundException extends RuntimeException {
	public RoleNotFoundException (String role) {
		super("Role not found: " + role);
	}
}
