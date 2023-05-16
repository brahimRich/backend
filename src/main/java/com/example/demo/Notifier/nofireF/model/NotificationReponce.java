package com.example.demo.Notifier.nofireF.model;

import com.example.demo.Technicienne.Technicienne;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class NotificationReponce {
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

    @OneToOne
    private Notification notification;

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
