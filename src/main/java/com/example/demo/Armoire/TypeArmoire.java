package com.example.demo.Armoire;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TypeArmoire {
    @Id
    @SequenceGenerator(
            name = "Armoire_sequence",
            sequenceName = "Armoire_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Armoire_sequence"
    )
    private Long id ;
    private String nom;

    @ManyToMany
    private List<Armoire>armoireList=new ArrayList<>();

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

    public TypeArmoire() {
    }

    public TypeArmoire(String nom, List<Armoire> armoireList) {
        this.nom = nom;
        this.armoireList = armoireList;
    }
}
