package br.ong.pjjpavaozinho.emailsender;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private JavaMailSender sender;

    public EmailService(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("emanuelwellygton@gmail.com");
        message.setTo(email.para());
        message.setSubject(email.assunto());
        message.setText(email.corpo());
        sender.send(message);
    }
}
