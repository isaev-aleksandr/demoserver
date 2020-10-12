package ru.isaev.demoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoserverApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoserverApplication.class, args);
	}

}
