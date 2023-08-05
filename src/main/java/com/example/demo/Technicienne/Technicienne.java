package com.example.demo.Technicienne;

import com.example.demo.User.utilisateur;
import jakarta.persistence.*;

@Entity
public class Technicienne extends utilisateur {

    public Technicienne(String nom, String prenom, String cin) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email="brahim22@gmail.com";
        this.password="rich";
        this.tele="0697943218";
    }

    public Technicienne() {
    }

}
