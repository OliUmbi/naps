package ch.bbbaden.naps.security.dtos.token.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityRequestAccessTokenDTO {
	private String email;
	private String password;
}
