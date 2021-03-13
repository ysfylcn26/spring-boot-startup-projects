package com.main.app.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySources({
        @PropertySource("classpath:application-moduls.properties"),
        @PropertySource("classpath:/db"),
        @PropertySource("classpath:/liquibase"),
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:application-security.properties"),
        @PropertySource("classpath:application-basic.properties")
})
@ComponentScans({
        @ComponentScan(basePackages = "com.core.security.*"),
        @ComponentScan(basePackages = "com.core.security.config"),
        @ComponentScan(basePackages = "com.core.basic.*"),
        @ComponentScan(basePackages = "com.core.model.*")
})
@EnableAutoConfiguration
@EntityScan("com.core.model.models.entity")
@EnableJpaRepositories("com.core.model.repository")
public class DependencyScan {
}
