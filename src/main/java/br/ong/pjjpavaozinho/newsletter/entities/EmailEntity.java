package br.ong.pjjpavaozinho.newsletter.entities;

import jakarta.persistence.*;

@Entity(name = "emails")
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;

    public EmailEntity() {
    }

    public EmailEntity(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public EmailEntity(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
