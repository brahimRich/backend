package com.example.demo.PointLumineux;


import com.example.demo.Adresse.Adresse;
import com.example.demo.coordonnees.Coordonnees;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name ="pointlumineux")
public class PointLumineux implements Serializable {
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
    private Long reference;
    @Column
    private String type;
    private double longitude;
    private double latitude;
    private boolean allume;
    private int numero;
    private String marque;
    private String degre_prot;
    private int puissance_max;
    private int temperature;
    private String class_electrique;
    private Date date_accussition;

    @OneToOne()
    private Coordonnees coordonnees;

    @OneToOne
    private Adresse adresse;

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getDegre_prot() {
        return degre_prot;
    }

    public void setDegre_prot(String degre_prot) {
        this.degre_prot = degre_prot;
    }

    public int getPuissance_max() {
        return puissance_max;
    }

    public void setPuissance_max(int puissance_max) {
        this.puissance_max = puissance_max;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getClass_electrique() {
        return class_electrique;
    }

    public void setClass_electrique(String class_electrique) {
        this.class_electrique = class_electrique;
    }

    public Date getDate_accussition() {
        return date_accussition;
    }

    public void setDate_accussition(Date date_accussition) {
        this.date_accussition = date_accussition;
    }

    public PointLumineux() {
        adresse=new Adresse();
        coordonnees=new Coordonnees();
    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public PointLumineux(String type, double longitude, double latitude,Adresse a, Coordonnees c) {
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.allume = false; // Le point lumineux est éteint par défaut
        this.adresse=a;
        this.coordonnees=c;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setAllume(boolean allume) {
        this.allume = allume;
    }
    public boolean getAllume() {return this.allume ;}

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public boolean isAllume() {
        return allume;
    }

    public void allumer() {
        this.allume = true;
    }

    public void eteindre() {
        this.allume = false;
    }
}
