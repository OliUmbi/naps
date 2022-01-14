package ch.bbbaden.naps.security.repositories;

import ch.bbbaden.naps.security.daos.SecurityTokenDAO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface SecurityTokenRepository extends CrudRepository<SecurityTokenDAO, Integer> {
    Optional<SecurityTokenDAO> findByAccess(String access);

    Optional<SecurityTokenDAO> findByRefresh(String refresh);

    @Modifying
    @Transactional
    @Query(
            value = "delete from security_tokens where expires < current_timestamp - interval '1 day';",
            nativeQuery = true
    )
    void deleteByExpiresFromYesterday();
}
