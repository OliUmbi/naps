package ch.bbbaden.naps.security.dtos.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityCreateAccountDTO {
	private String email;
	private String password;
}
