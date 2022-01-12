package ch.bbbaden.naps.security.controllers;

import ch.bbbaden.naps.dtos.MessageDTO;
import ch.bbbaden.naps.security.daos.SecurityAccountDAO;
import ch.bbbaden.naps.security.dtos.account.SecurityChangeAccountDTO;
import ch.bbbaden.naps.security.dtos.account.SecurityCreateAccountDTO;
import ch.bbbaden.naps.security.services.SecurityAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
@Tag(name = "security")
public class SecurityAccountController {
	private final SecurityAccountService securityAccountService;
	
	@Autowired
	public SecurityAccountController (SecurityAccountService securityAccountService) {
		this.securityAccountService = securityAccountService;
	}
	
	@Operation(summary = "get all accounts")
	@GetMapping("/account")
	private ResponseEntity<Iterable<SecurityAccountDAO>> getAll () {
		return securityAccountService.getAll();
	}
	
	@Operation(summary = "Create account")
	@PostMapping("/account")
	private ResponseEntity<MessageDTO> login (@RequestBody SecurityCreateAccountDTO securityCreateAccountDTO) {
		return securityAccountService.create(securityCreateAccountDTO);
	}
	
	@Operation(summary = "Change account details")
	@PutMapping("/account")
	private ResponseEntity<MessageDTO> refresh (@RequestBody SecurityChangeAccountDTO securityChangeAccountDTO) {
		return securityAccountService.update(securityChangeAccountDTO);
	}
	
	@Operation(summary = "Delete account")
	@DeleteMapping("/account")
	private ResponseEntity<MessageDTO> delete (@RequestBody SecurityCreateAccountDTO securityCreateAccountDTO) {
		return securityAccountService.delete(securityCreateAccountDTO);
	}
}
