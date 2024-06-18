package br.ong.pjjpavaozinho.newsletter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@SpringBootApplication
public class NewsletterApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsletterApplication.class, args);
	}

}
