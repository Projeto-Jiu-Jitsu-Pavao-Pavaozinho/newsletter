package br.ong.pjjpavaozinho.newsletter.repositories;

import br.ong.pjjpavaozinho.newsletter.entities.EmailEntity;
import org.springframework.data.repository.Repository;

public interface EmailRepository extends Repository<EmailEntity, Integer> {

    void save(EmailEntity entity);
}
