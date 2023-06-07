package com.example.demo.Armoire;

import com.example.demo.Depart.Departt;
import com.example.demo.PointLumineux.PointLumineux;
import com.example.demo.User.utilisateur;
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
    @ManyToOne
    private utilisateur AjouteurUser;

    @ManyToMany
    private List<ArmoireCaracteristique> ArmoireListe=new ArrayList<>();

    @OneToMany
    private List<PointLumineux> Pointluminexs=new ArrayList<>();

    public List<PointLumineux> getPointluminexs() {
        return Pointluminexs;
    }

    public void setPointluminexs(List<PointLumineux> pointluminexs) {
        Pointluminexs = pointluminexs;
    }

    public utilisateur getAjouteurUser() {
        return AjouteurUser;
    }

    public void setAjouteurUser(utilisateur ajouteurUser) {
        AjouteurUser = ajouteurUser;
    }

    public Armoire(List<ArmoireCaracteristique> armoireListe, List<TypeArmoire> typeArmoireList) {
        ArmoireListe = armoireListe;
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



}

