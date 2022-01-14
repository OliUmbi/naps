package ch.bbbaden.naps.api.services;

import ch.bbbaden.naps.dtos.MessageDTO;
import ch.bbbaden.naps.parent.AbstractService;
import ch.bbbaden.naps.security.repositories.SecurityTokenRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PingService extends AbstractService {
	
	public PingService (SecurityTokenRepository tokenRepository) {
		super(tokenRepository);
	}
	
	public ResponseEntity<MessageDTO> ping (String auth) {
		authenticate(auth, "ping", false);

		return ResponseEntity.ok().body(new MessageDTO("Pong"));
	}
}
