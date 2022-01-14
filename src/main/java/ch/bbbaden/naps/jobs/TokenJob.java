package ch.bbbaden.naps.jobs;

import ch.bbbaden.naps.security.repositories.SecurityTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TokenJob {

    private SecurityTokenRepository securityTokenRepository;

    @Autowired
    public TokenJob(SecurityTokenRepository securityTokenRepository) {
        this.securityTokenRepository = securityTokenRepository;
    }

    @Scheduled(fixedDelay = 1000)
    public void deleteOldTokens() {
        /* not implemented yet */

//        Date now = new Date();
//        boolean result = securityTokenRepository.deleteByExpiresAtBefore(new Date(now.getTime() - 86400000));
//        System.out.println(result);
    }
}
