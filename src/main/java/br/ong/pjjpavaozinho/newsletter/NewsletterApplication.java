package br.ong.pjjpavaozinho.newsletter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NewsletterApplication {

	@GetMapping("/")
	public String hello() {
		return "Hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(NewsletterApplication.class, args);
	}

}
