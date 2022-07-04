package co.luxoft.nace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
        		.info(
        				new Info()
        					.title("NACE Details Info")
        					.description("This service is responsible for NACE details operations")
        					.version("1.0")
        		);
    }
}
