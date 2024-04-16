package br.ong.pjjpavaozinho.newsletter;

import br.ong.pjjpavaozinho.newsletter.dto.EmailDTO;
import br.ong.pjjpavaozinho.newsletter.entities.EmailEntity;
import br.ong.pjjpavaozinho.newsletter.repositories.EmailRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@SpringBootApplication
@RestController
public class NewsletterApplication {
	private EmailRepository repository;

	public NewsletterApplication(EmailRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/")
	public String hello() {
		return "Hello";
	}

	@PostMapping("/")
	@ResponseBody
	public ResponseEntity incricao(@RequestBody EmailDTO request) {
		EmailEntity emailEntity = new EmailEntity(request.getEmail());
		return ResponseEntity.ok(repository.save(emailEntity));
	}

	public static void main(String[] args) {
		SpringApplication.run(NewsletterApplication.class, args);
	}

}
