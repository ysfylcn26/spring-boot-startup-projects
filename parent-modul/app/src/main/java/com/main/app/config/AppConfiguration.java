package com.main.app.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.core.security.*")
@ComponentScan(basePackages = "com.core.security.config")
@ComponentScan(basePackages = "com.core.basic.*")
@ComponentScan(basePackages = "com.core.model.*")
@EntityScan("com.core.model.models.entity")
@EnableJpaRepositories("com.core.model.repository")
public class AppConfiguration {
}
