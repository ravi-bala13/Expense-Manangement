package com.expense.management;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@SpringBootApplication
@RestController
public class ExpenseManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
		return args -> {
			log.info("=====================  Application started =====================");
		};
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runThisAfterApplicationStarted(){
		log.info("working at port 8080");
	}

	@GetMapping("/home")
	@ResponseStatus(HttpStatus.OK)
	public String index() {
		return "Greetings from Spring Boot!";
	}
}
