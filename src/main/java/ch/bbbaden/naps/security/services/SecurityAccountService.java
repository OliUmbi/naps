package ch.bbbaden.naps.security.services;

import ch.bbbaden.naps.dtos.MessageDTO;
import ch.bbbaden.naps.exceptions.alreadyexists.AccountAlreadyExistsException;
import ch.bbbaden.naps.exceptions.notfound.RoleNotFoundException;
import ch.bbbaden.naps.security.daos.SecurityAccountDAO;
import ch.bbbaden.naps.security.dtos.account.SecurityChangeAccountDTO;
import ch.bbbaden.naps.security.dtos.account.SecurityCreateAccountDTO;
import ch.bbbaden.naps.security.parent.AbstractSecurityService;
import ch.bbbaden.naps.security.repositories.SecurityAccountRepository;
import ch.bbbaden.naps.security.repositories.SecurityRoleRepository;
import ch.bbbaden.naps.security.repositories.SecurityTokenRepository;
import ch.bbbaden.naps.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityAccountService extends AbstractSecurityService {
	
	private final SecurityRoleRepository roleRepository;
	
	@Autowired
	public SecurityAccountService (
			SecurityTokenRepository tokenRepository,
			SecurityAccountRepository accountRepository,
			PasswordEncoder passwordEncoder,
			SecurityRoleRepository roleRepository
	) {
		super(tokenRepository, accountRepository, passwordEncoder);
		this.roleRepository = roleRepository;
	}
	
	public ResponseEntity<Iterable<SecurityAccountDAO>> getAll () {
		return ResponseEntity.ok().body(accountRepository.findAll());
	}
	
	public ResponseEntity<MessageDTO> create (SecurityCreateAccountDTO createAccountDTO) {
		ValidationUtil.checkIfEmailIsValid(createAccountDTO.getEmail());
		ValidationUtil.checkIfPasswordIsValid(createAccountDTO.getPassword());
		
		if (accountRepository.existsByEmail(createAccountDTO.getEmail())) {
			throw new AccountAlreadyExistsException(createAccountDTO.getEmail());
		}
		
		SecurityAccountDAO accountDAO = new SecurityAccountDAO();
		accountDAO.setEmail(createAccountDTO.getEmail());
		accountDAO.setPassword(passwordEncoder.encode(createAccountDTO.getPassword()));
		accountDAO.setEmail(createAccountDTO.getEmail());
		accountDAO.setRole(roleRepository.findByRole("admin").orElseThrow(() -> new RoleNotFoundException("admin")));
		
		accountRepository.save(accountDAO);
		
		return ResponseEntity.ok().body(new MessageDTO("Successfully created account"));
	}
	
	public ResponseEntity<MessageDTO> update (SecurityChangeAccountDTO changeAccountDTO) {
		
		SecurityAccountDAO accountDAO = login(changeAccountDTO.getEmail(), changeAccountDTO.getPassword());
		
		ValidationUtil.checkIfPasswordIsValid(changeAccountDTO.getNewPassword());
		accountDAO.setPassword(passwordEncoder.encode(changeAccountDTO.getPassword()));
		accountRepository.save(accountDAO);
		
		return ResponseEntity.ok().body(new MessageDTO("Successfully changed password"));
	}
	
	public ResponseEntity<MessageDTO> delete (SecurityCreateAccountDTO createAccountDTO) {
		
		SecurityAccountDAO accountDAO = login(createAccountDTO.getEmail(), createAccountDTO.getPassword());
		
		accountRepository.deleteById(accountDAO.getId());
		
		return ResponseEntity.ok().body(new MessageDTO("Successfully deleted account"));
	}
}
