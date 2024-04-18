package br.ong.pjjpavaozinho.newsletter;

import br.ong.pjjpavaozinho.emailsender.Email;
import br.ong.pjjpavaozinho.emailsender.EmailService;
import br.ong.pjjpavaozinho.newsletter.dto.EmailDTO;
import br.ong.pjjpavaozinho.newsletter.entities.EmailEntity;
import br.ong.pjjpavaozinho.newsletter.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@SpringBootApplication
@RestController
public class NewsletterApplication {
	private EmailRepository repository;
	private EmailService emailService;

	public NewsletterApplication(EmailRepository repository, JavaMailSender sender) {
		this.repository = repository;
		this.emailService = new EmailService(sender);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello";
	}

	@PostMapping("/")
	@ResponseBody
	public ResponseEntity incricao(@RequestBody EmailDTO request) {
		EmailEntity emailEntity = new EmailEntity(request.getEmail());

		try {
			EmailEntity entidadeSalva = repository.save(emailEntity);
			Email email = new Email(request.getEmail(), "Inscrição Newsletter Pavãozinho",
					"Sua incrição na newsletter da Pavãozinho foi realizada com sucesso!");
			emailService.sendEmail(email);
			return new ResponseEntity(entidadeSalva, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(NewsletterApplication.class, args);
	}

}
