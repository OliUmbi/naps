package ch.bbbaden.naps.security.repositories;

import ch.bbbaden.naps.security.daos.SecurityAccountDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SecurityAccountRepository extends CrudRepository<SecurityAccountDAO, Integer> {
	Optional<SecurityAccountDAO> findByEmail (String email);
	
	boolean existsByEmail (String email);
}
