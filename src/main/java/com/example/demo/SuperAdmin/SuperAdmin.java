package com.example.demo.SuperAdmin;

import com.example.demo.User.utilisateur;
import jakarta.persistence.Entity;

@Entity
public class SuperAdmin extends utilisateur {

    public SuperAdmin(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public SuperAdmin() {
    }

}