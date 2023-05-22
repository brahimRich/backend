package com.example.demo.User;

import com.example.demo.Role.Role;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class utilisateur {
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
    @Column
    protected long id;
    protected String nom;
    protected String prenom;
    protected String cin;
    protected String email;
    protected String password;
    @Column(insertable=false, updatable=false)
    protected String dtype;
    protected String tele;

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
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

    /*@ManyToMany
        private List<Intervention> interventionList=new ArrayList<>();
    */
    public utilisateur(String nom, String prenom, String cin) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email="brahim";
        this.password="rich";
        this.roleList=new ArrayList<>();
    }

    @ManyToMany
    public List<Role> roleList=new ArrayList<>();

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public utilisateur() {
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
