package ch.bbbaden.naps.security.controllers;

import ch.bbbaden.naps.security.dtos.token.request.SecurityRequestAccessTokenDTO;
import ch.bbbaden.naps.security.dtos.token.request.SecurityRequestRefreshTokenDTO;
import ch.bbbaden.naps.security.services.SecurityTokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
@Tag(name = "security")
public class SecurityTokenController {
	
	private final SecurityTokenService securityTokenService;
	
	@Autowired
	public SecurityTokenController (SecurityTokenService securityTokenService) {
		this.securityTokenService = securityTokenService;
	}
	
	@Operation(summary = "get all tokens")
	@GetMapping("/token")
	private ResponseEntity<Object> gelAll () {
		return securityTokenService.getAll();
	}
	
	@Operation(summary = "Login with email + password")
	@PostMapping("/token")
	private ResponseEntity<Object> login (@RequestBody SecurityRequestAccessTokenDTO accessTokenDTO) {
		return securityTokenService.login(accessTokenDTO);
	}
	
	@Operation(summary = "Refresh access token")
	@PutMapping("/token")
	private ResponseEntity<Object> refresh (@RequestBody SecurityRequestRefreshTokenDTO refreshTokenDTO) {
		return securityTokenService.refresh(refreshTokenDTO);
	}
	
	@Operation(summary = "Delete token for logout")
	@DeleteMapping("/token")
	private ResponseEntity<Object> delete (@RequestBody SecurityRequestRefreshTokenDTO refreshTokenDTO) {
		return securityTokenService.delete(refreshTokenDTO);
	}
	
}
