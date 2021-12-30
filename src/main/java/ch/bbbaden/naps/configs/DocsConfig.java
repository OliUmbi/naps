package ch.bbbaden.naps.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocsConfig {
	@Bean
	public OpenAPI springShopOpenAPI () {
		return new OpenAPI()
				.info(new Info()
						.title("NAPS API")
						.description("NAPS test application")
						.version("v0.1"));
	}
}
