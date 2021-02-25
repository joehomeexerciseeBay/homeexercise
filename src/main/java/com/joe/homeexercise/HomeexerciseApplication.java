package com.joe.homeexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class HomeexerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeexerciseApplication.class, args);
		System.out.println("Hello eBay from Joe");
	}
	
	@Configuration
	public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
    public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
    }
	}

}
