package br.ong.pjjpavaozinho.newsletter.controllers;

import br.ong.pjjpavaozinho.emailsender.Email;
import br.ong.pjjpavaozinho.emailsender.EmailService;
import br.ong.pjjpavaozinho.newsletter.dto.EmailDTO;
import br.ong.pjjpavaozinho.newsletter.entities.EmailEntity;
import br.ong.pjjpavaozinho.newsletter.repositories.EmailRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController("/")
public class NewsletterController {
    private EmailRepository repository;
    private EmailService emailService;

    public NewsletterController(EmailRepository repository, JavaMailSender sender) {
        this.repository = repository;
        this.emailService = new EmailService(sender);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity subscribe(@RequestBody EmailDTO request) {
        EmailEntity emailEntity = new EmailEntity(request.getEmail());

        try {
            EmailEntity savedEntity = repository.save(emailEntity);
            Email email = new Email(request.getEmail(), "Inscrição Newsletter Pavãozinho",
                    "Sua inscrição na newsletter da Pavãozinho foi realizada com sucesso.");
            emailService.sendEmail(email);

            return new ResponseEntity(savedEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping
    public String test() {
        return "Hello";
    }
}
