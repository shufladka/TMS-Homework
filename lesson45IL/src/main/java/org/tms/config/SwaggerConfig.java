package org.tms.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi CarOpenApi() {

        String[] paths = {"/store/cars/**"};

        return GroupedOpenApi.builder()
                .group("il-store-cars")
                .pathsToMatch(paths)
                .build();
    }
}