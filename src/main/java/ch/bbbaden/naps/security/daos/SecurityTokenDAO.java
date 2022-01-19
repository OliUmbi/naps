package ch.bbbaden.naps.security.daos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "security_tokens")
public class SecurityTokenDAO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "account")
	private SecurityAccountDAO account;
	
	@Column(name = "refresh")
	private String refresh;
	
	@Column(name = "access")
	private String access;
	
	@Column(name = "expires")
	private Date expires;
}
