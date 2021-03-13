package com.example.payrollsystem;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.example.com.example.payrollsystem")
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = "com.example.com.example.payrollsystem")
public class SpringConfig {
}
