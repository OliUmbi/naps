package ch.bbbaden.naps.security.dtos.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityChangeAccountDTO {
	private String email;
	private String password;
	private String newPassword;
}
