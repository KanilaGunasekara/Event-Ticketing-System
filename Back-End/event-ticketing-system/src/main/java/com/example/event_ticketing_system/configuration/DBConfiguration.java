package com.example.event_ticketing_system.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories (basePackages="com.example.event_ticketing_system.repository")
public class DBConfiguration {
}
