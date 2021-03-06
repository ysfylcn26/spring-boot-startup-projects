package com.main.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-${spring.profiles.active}-moduls.properties")
@PropertySource("classpath:application-${spring.profiles.active}.properties")
@PropertySource("classpath:application-${spring.profiles.active}-security.properties")
@PropertySource("classpath:application-${spring.profiles.active}-basic.properties")
public class PropertiesConfiguration {
}
