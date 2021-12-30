package ch.bbbaden.naps.security.repositories;

import ch.bbbaden.naps.security.daos.SecurityRoleDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SecurityRoleRepository extends CrudRepository<SecurityRoleDAO, Integer> {
	
	Optional<SecurityRoleDAO> findByRole (String role);
}
