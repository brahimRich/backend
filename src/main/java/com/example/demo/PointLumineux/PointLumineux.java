package com.example.demo.PointLumineux;


import jakarta.persistence.*;

@Entity
@Table(name ="pointlumineux")
public class PointLumineux {
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
    private String name;
    private double longitude;
    private double latitude;
    private boolean allume;

    public PointLumineux() {

    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public PointLumineux(String nom, double longitude, double latitude) {
        this.name = nom;
        this.longitude = longitude;
        this.latitude = latitude;
        this.allume = false; // Le point lumineux est éteint par défaut
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
