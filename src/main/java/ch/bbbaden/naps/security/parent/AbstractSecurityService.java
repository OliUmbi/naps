package ch.bbbaden.naps.security.parent;

import ch.bbbaden.naps.exceptions.invalid.InvalidLoginException;
import ch.bbbaden.naps.exceptions.notfound.AccountNotFoundException;
import ch.bbbaden.naps.parent.AbstractService;
import ch.bbbaden.naps.security.daos.SecurityAccountDAO;
import ch.bbbaden.naps.security.repositories.SecurityAccountRepository;
import ch.bbbaden.naps.security.repositories.SecurityTokenRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public abstract class AbstractSecurityService extends AbstractService {
	
	protected final SecurityAccountRepository accountRepository;
	protected final PasswordEncoder passwordEncoder;
	
	public AbstractSecurityService (
			SecurityTokenRepository tokenRepository,
			SecurityAccountRepository accountRepository, PasswordEncoder passwordEncoder
	) {
		super(tokenRepository);
		this.accountRepository = accountRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	protected SecurityAccountDAO login (String email, String password) {
		SecurityAccountDAO accountDAO = accountRepository.findByEmail(email)
				.orElseThrow(() -> new AccountNotFoundException(email));
		
		if (! passwordEncoder.matches(password, accountDAO.getPassword())) {
			throw new InvalidLoginException(email);
		}
		
		return accountDAO;
	}
}
