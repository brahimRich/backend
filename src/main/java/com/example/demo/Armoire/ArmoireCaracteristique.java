package com.example.demo.Armoire;

import com.example.demo.Depart.DepartType;
import com.example.demo.PointLumineux.PointLumineux;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class ArmoireCaracteristique {

    @Id
    @SequenceGenerator(
            name = "ArmoireCaracteristique_sequence",
            sequenceName = "ArmoireCaracteristique_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ArmoireCaracteristique_sequence"
    )
    private Long id;
    private String marque;
    private String calibre;
    private int nombre;

   /* @ManyToMany
    private List<Armoire> armoireList=new ArrayList<>();*/

    @ManyToOne
    private TypeArmoire typeArmoire;

    public TypeArmoire getTypeArmoire() {
        return typeArmoire;
    }

    public void setTypeArmoire(TypeArmoire typeArmoire) {
        this.typeArmoire = typeArmoire;
    }

    public ArmoireCaracteristique(String marque, String calibre, int nombre, TypeArmoire typeArmoire) {
        this.marque = marque;
        this.calibre = calibre;
        this.nombre = nombre;
       // this.armoireList = armoireList;
        this.typeArmoire=typeArmoire;
    }

    public ArmoireCaracteristique() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

   /* public List<Armoire> getArmoireList() {
        return armoireList;
    }

    public void setArmoireList(List<Armoire> armoireList) {
        this.armoireList = armoireList;
    }*/
}
