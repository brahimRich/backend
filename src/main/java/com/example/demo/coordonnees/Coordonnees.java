package com.example.demo.coordonnees;

import com.example.demo.PointLumineux.PointLumineux;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Coordonnees implements Serializable {
    @Id
    @SequenceGenerator(
            name = "Adresse_sequence",
            sequenceName = "Adresse_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Adresse_sequence"
    )
    private Long id;
    @Column
    private float x;
    private float y;

   /* @OneToOne()
    private PointLumineux pointLumineux;

    public PointLumineux getPointLumineux() {
        return pointLumineux;
    }

    public void setPointLumineux(PointLumineux pointLumineux) {
        this.pointLumineux = pointLumineux;
    }*/

    public Long getId() {
        return id;
    }

    public Coordonnees() {
    }

    public Coordonnees(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
