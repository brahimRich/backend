package com.example.demo.Notifier.nofireF.model;

import com.example.demo.Intervention.Intervention;
import com.example.demo.Technicienne.Technicienne;
import com.google.api.client.util.DateTime;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    @SequenceGenerator(
            name = "Armoire_sequence",
            sequenceName = "Armoire_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Armoire_sequence"
    )
    private Long id;
    private String topic;
    private String title;
    private String message;
    private LocalDateTime createdAt;
    private String token;

    @ManyToOne
    private Technicienne technicienne;

    @ManyToOne
    private Intervention intervention;

    public Notification() {
        createdAt = LocalDateTime.now();
    }

    public Notification(String title, String message,String topic, Technicienne user,String token) {
        this.title = title;
        this.message = message;
        this.technicienne = user;
        this.createdAt = LocalDateTime.now();
        this.topic=topic;
        this.token=token;
    }

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Technicienne getTechnicienne() {
        return technicienne;
    }

    public void setTechnicienne(Technicienne technicienne) {
        this.technicienne = technicienne;
    }
}