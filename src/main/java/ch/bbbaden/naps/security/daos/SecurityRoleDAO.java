package ch.bbbaden.naps.security.daos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "security_roles")
public class SecurityRoleDAO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "role", unique = true)
	private String role;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(
			name = "security_roles_access",
			joinColumns = @JoinColumn(name = "role"),
			inverseJoinColumns = @JoinColumn(name = "access")
	)
	private Set<SecurityAccessDAO> access = new HashSet<>();
}
