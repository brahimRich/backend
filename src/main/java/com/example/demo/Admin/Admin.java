package com.example.demo.Admin;

import com.example.demo.User;
import jakarta.persistence.*;

@Entity
public class Admin {
    @Id
    @SequenceGenerator(
            name = "PointLumineux_sequence",
            sequenceName = "PointLumineux_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PointLumineux_sequence"
    )
    private Long id;
    @Column
    private String nom;
    private String prenom;
    private String email;
    private String password;

    public Admin(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public Admin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
