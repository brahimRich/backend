package com.example.demo.Armoire;

import com.example.demo.Depart.Departt;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Armoire {
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
    private Long id;

    @ManyToMany
    private List<ArmoireCaracteristique> ArmoireListe=new ArrayList<>();

    @ManyToMany
    private List<TypeArmoire> typeArmoireList=new ArrayList<>();

    @OneToOne
    private Departt departt;

    public Armoire(List<ArmoireCaracteristique> armoireListe, List<TypeArmoire> typeArmoireList, Departt departt) {
        ArmoireListe = armoireListe;
        this.typeArmoireList = typeArmoireList;
        this.departt = departt;
    }

    public Armoire() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ArmoireCaracteristique> getArmoireListe() {
        return ArmoireListe;
    }

    public void setArmoireListe(List<ArmoireCaracteristique> armoireListe) {
        ArmoireListe = armoireListe;
    }

    public List<TypeArmoire> getTypeArmoireList() {
        return typeArmoireList;
    }

    public void setTypeArmoireList(List<TypeArmoire> typeArmoireList) {
        this.typeArmoireList = typeArmoireList;
    }

    public Departt getDepartt() {
        return departt;
    }

    public void setDepartt(Departt departt) {
        this.departt = departt;
    }
}

