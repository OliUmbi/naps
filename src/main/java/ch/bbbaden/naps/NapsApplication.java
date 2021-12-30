package ch.bbbaden.naps;

import ch.bbbaden.naps.configs.SecurityProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(SecurityProperties.class)
public class NapsApplication {
	
	public static void main (String[] args) {
		SpringApplication.run(NapsApplication.class, args);
	}
	
}
