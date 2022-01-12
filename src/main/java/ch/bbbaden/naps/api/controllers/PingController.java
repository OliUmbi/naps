package ch.bbbaden.naps.api.controllers;

import ch.bbbaden.naps.api.services.PingService;
import ch.bbbaden.naps.dtos.MessageDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "testing")
public class PingController {
	
	private final PingService pingService;
	
	@Autowired
	public PingController (PingService pingService) {
		this.pingService = pingService;
	}
	
	@Operation(summary = "Ping")
	@GetMapping("/ping")
	public ResponseEntity<MessageDTO> ping (@RequestHeader("auth") String auth) {
		return pingService.ping(auth);
	}
}
