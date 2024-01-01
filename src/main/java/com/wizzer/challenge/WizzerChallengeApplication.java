package com.wizzer.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class WizzerChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WizzerChallengeApplication.class, args);
	}

}
