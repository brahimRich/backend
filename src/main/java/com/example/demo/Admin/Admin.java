package com.example.demo.Admin;

import com.example.demo.User.utilisateur;
import jakarta.persistence.*;

@Entity
public class Admin extends utilisateur {

    public Admin(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public Admin() {
    }

}
