package ch.bbbaden.naps.security.repositories;

import ch.bbbaden.naps.security.daos.SecurityTokenDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SecurityTokenRepository extends CrudRepository<SecurityTokenDAO, Integer> {
	Optional<SecurityTokenDAO> findByAccess (String access);
	
	Optional<SecurityTokenDAO> findByRefresh (String refresh);
}
