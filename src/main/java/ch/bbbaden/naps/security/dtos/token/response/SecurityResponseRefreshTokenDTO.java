package ch.bbbaden.naps.security.dtos.token.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SecurityResponseRefreshTokenDTO {
	private String access;
	private Date expires;
}
