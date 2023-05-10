package com.example.demo.Technicienne;

import jakarta.persistence.*;

@Entity
public class Technicienne {
    @Id
    @SequenceGenerator(
            name = "Intervention_sequence",
            sequenceName = "Intervention_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Intervention_sequence"
    )
    private long id;
    private String nom;
    private String prenom;
    private String cin;
    private String email;
    private String password;

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

    /*@ManyToMany
        private List<Intervention> interventionList=new ArrayList<>();
    */
    public Technicienne(String nom, String prenom, String cin) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email="brahim";
        this.password="rich";
    }

    public Technicienne() {
    }

    public String getIdc() {
        String numberString = String.valueOf(id);
        return numberString;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    /*public List<Intervention> getInterventionList() {
        return interventionList;
    }

    public void setInterventionList(List<Intervention> interventionList) {
        this.interventionList = interventionList;
    }*/
}
