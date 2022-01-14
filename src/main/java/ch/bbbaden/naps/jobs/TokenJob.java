package ch.bbbaden.naps.jobs;

import ch.bbbaden.naps.security.repositories.SecurityTokenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TokenJob {

    public static final Logger logger = LoggerFactory.getLogger(TokenJob.class);

    private SecurityTokenRepository securityTokenRepository;

    @Autowired
    public TokenJob(SecurityTokenRepository securityTokenRepository) {
        this.securityTokenRepository = securityTokenRepository;
    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void deleteOldTokens() {
        securityTokenRepository.deleteByExpiresFromYesterday();
        logger.info("deleted token that expired more than a day before");
    }
}
