package com.example.demo.Adresse;


import com.example.demo.Adresse.Adresse;
import com.example.demo.PointLumineux.PointLumineux;
import com.example.demo.coordonnees.Coordonnees;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Adresse implements Serializable {
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
    private String rue;
    private String quertier;

    /*@OneToMany
    private List<PointLumineux> pointLumineuxList;

    public List<PointLumineux> getPointLumineuxList() {
        return pointLumineuxList;
    }

    public void setPointLumineuxList(List<PointLumineux> pointLumineuxList) {
        this.pointLumineuxList = pointLumineuxList;
    }*/

    public Adresse() {
    }

    public Adresse(String rue, String quertier) {
        this.rue = rue;
        this.quertier = quertier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getQuertier() {
        return quertier;
    }

    public void setQuertier(String quertier) {
        this.quertier = quertier;
    }
}
