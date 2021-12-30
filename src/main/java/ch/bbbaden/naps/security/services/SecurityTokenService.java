package ch.bbbaden.naps.security.services;

import ch.bbbaden.naps.configs.SecurityProperties;
import ch.bbbaden.naps.dtos.MessageDTO;
import ch.bbbaden.naps.exceptions.notfound.TokenNotFoundException;
import ch.bbbaden.naps.security.daos.SecurityAccountDAO;
import ch.bbbaden.naps.security.daos.SecurityTokenDAO;
import ch.bbbaden.naps.security.dtos.token.request.SecurityRequestAccessTokenDTO;
import ch.bbbaden.naps.security.dtos.token.request.SecurityRequestRefreshTokenDTO;
import ch.bbbaden.naps.security.mappers.SecurityTokenMapper;
import ch.bbbaden.naps.security.parent.AbstractSecurityService;
import ch.bbbaden.naps.security.repositories.SecurityAccountRepository;
import ch.bbbaden.naps.security.repositories.SecurityTokenRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SecurityTokenService extends AbstractSecurityService {
	
	private final SecurityProperties securityProperties;
	private final SecurityTokenMapper tokenMapper;
	
	public SecurityTokenService (
			SecurityTokenRepository tokenRepository,
			SecurityAccountRepository accountRepository,
			PasswordEncoder passwordEncoder,
			SecurityProperties securityProperties,
			SecurityTokenMapper tokenMapper
	) {
		super(tokenRepository, accountRepository, passwordEncoder);
		this.securityProperties = securityProperties;
		this.tokenMapper = tokenMapper;
	}
	
	public ResponseEntity<Object> getAll () {
		return ResponseEntity.ok().body(tokenRepository.findAll());
	}
	
	public ResponseEntity<Object> login (SecurityRequestAccessTokenDTO accessTokenDTO) {
		
		SecurityAccountDAO accountDAO = login(accessTokenDTO.getEmail(), accessTokenDTO.getPassword());
		
		RandomStringUtils.randomAlphanumeric(10);
		
		SecurityTokenDAO tokenDAO = new SecurityTokenDAO();
		tokenDAO.setAccess(RandomStringUtils.randomAlphanumeric(10));
		tokenDAO.setRefresh(RandomStringUtils.randomAlphanumeric(10));
		tokenDAO.setExpires(calculateExpires());
		tokenDAO.setAccount(accountDAO);
		
		tokenRepository.save(tokenDAO);
		
		return ResponseEntity.ok().body(tokenMapper.mapSecurityTokenDAOToSecurityResponseAccessTokenDTO(tokenDAO));
	}
	
	public ResponseEntity<Object> refresh (SecurityRequestRefreshTokenDTO refreshTokenDTO) {
		
		SecurityTokenDAO tokenDAO = tokenRepository.findByRefresh(refreshTokenDTO.getRefresh())
				.orElseThrow(() -> new TokenNotFoundException(refreshTokenDTO.getRefresh()));
		
		tokenDAO.setAccess(RandomStringUtils.randomAlphanumeric(10));
		tokenDAO.setExpires(calculateExpires());
		
		tokenRepository.save(tokenDAO);
		
		return ResponseEntity.ok().body(tokenMapper.mapSecurityTokenDAOToSecurityResponseRefreshTokenDTO(tokenDAO));
	}
	
	public ResponseEntity<Object> delete (SecurityRequestRefreshTokenDTO refreshTokenDTO) {
		SecurityTokenDAO tokenDAO = tokenRepository.findByRefresh(refreshTokenDTO.getRefresh())
				.orElseThrow(() -> new TokenNotFoundException(refreshTokenDTO.getRefresh()));
		
		tokenRepository.deleteById(tokenDAO.getId());
		
		return ResponseEntity.ok().body(new MessageDTO("Successfully deleted tokens"));
	}
	
	private Date calculateExpires () {
		Date now = new Date();
		
		return new Date(now.getTime() + securityProperties.getExpiresIn());
	}
}
