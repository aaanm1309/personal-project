package br.com.adrianomenezes.generalback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Restfull API with Java 17")
                        .version("v1")
                        .description("Description of this API")
                        .termsOfService("http://www.adrianomenezes.com")
                        .contact(
                        		new Contact()
                        		.name("API Support")
                        		.email("support@example.com")
                        		.url("https://www.example.com/support")
                        		)
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.adrianomenezes.com"))
                );
    }

}
