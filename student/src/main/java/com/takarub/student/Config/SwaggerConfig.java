package com.takarub.student.Config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

import static org.apache.hc.core5.http.HttpHeaders.AUTHORIZATION;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Spring Boot",
        description = "Framework in Spring Boot", version = "v1",
        license = @License(name = "Flexidev", url = "https://www.flexidev.co")))
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
//                .addSecurityItem(new SecurityRequirement().addList(AUTHORIZATION))
                .components(new Components().addSecuritySchemes(AUTHORIZATION,
                        new io.swagger.v3.oas.models.security.SecurityScheme().type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }

    @Bean
    ForwardedHeaderFilter forwardedHeaderFilter() {
        return new ForwardedHeaderFilter();
    }

//http://localhost:4040/swagger-ui/index.html#

}
