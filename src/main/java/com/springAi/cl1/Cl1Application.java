package com.springAi.cl1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ai.model.chat.client.autoconfigure.ChatClientAutoConfiguration;

@SpringBootApplication(exclude = ChatClientAutoConfiguration.class)
public class Cl1Application {

	public static void main(String[] args) {
		SpringApplication.run(Cl1Application.class, args);
	}

}
