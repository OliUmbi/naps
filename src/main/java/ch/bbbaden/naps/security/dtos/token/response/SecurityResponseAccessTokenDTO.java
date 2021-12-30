package ch.bbbaden.naps.security.dtos.token.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SecurityResponseAccessTokenDTO {
	private String access;
	private String refresh;
	private Date expires;
}
