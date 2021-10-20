package com.hu.familyTree;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext aplctx) {
		return arg -> {
			System.out.println("Let's inpect Spring Boot Beans.");
			String[] beanNames = aplctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for(String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}
}
