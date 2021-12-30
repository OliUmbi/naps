package ch.bbbaden.naps.parent;

import ch.bbbaden.naps.exceptions.UnauthorizedException;
import ch.bbbaden.naps.security.daos.SecurityAccessDAO;
import ch.bbbaden.naps.security.daos.SecurityTokenDAO;
import ch.bbbaden.naps.security.repositories.SecurityTokenRepository;

import java.util.Date;

public abstract class AbstractService {
	protected final SecurityTokenRepository tokenRepository;
	
	public AbstractService (SecurityTokenRepository tokenRepository) {
		this.tokenRepository = tokenRepository;
	}
	
	protected void authenticate (String tokenAccess, String accessName, boolean accessEdit) {
		SecurityTokenDAO tokenDAO = tokenRepository.findByAccess(tokenAccess)
				.orElseThrow(() -> new UnauthorizedException("token not found: " + tokenAccess));
		
		if (tokenDAO.getExpires().before(new Date())) {
			throw new UnauthorizedException("token expired");
		}
		
		SecurityAccessDAO accessDAO = tokenDAO.getAccount().getRole().getAccess().stream()
				.filter(securityAccessDAO -> securityAccessDAO.getName().equals(accessName))
				.findFirst()
				.orElseThrow(() -> new UnauthorizedException("access not found"));
		
		if (accessEdit && ! accessDAO.isEdit()) {
			throw new UnauthorizedException("edit rights required");
		}
	}
}
