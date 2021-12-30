package ch.bbbaden.naps.security.dtos.token.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityRequestRefreshTokenDTO {
	private String refresh;
}
