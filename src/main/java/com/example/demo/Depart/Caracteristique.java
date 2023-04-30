package com.example.demo.Depart;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Caracteristique {
    @Id
    @SequenceGenerator(
            name = "Depart_sequence",
            sequenceName = "Depart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Depart_sequence"
    )
    private Long id;
    private String tenstion_sortie_triphase;
    private  String tenstion_sortie_mono ;
    private String courantA;

    private String tenstion_extrimite_triphase;
    private  String tenstion_extrimite_mono ;
    private String nbr_lumineux;

    @ManyToOne
    private Departt derpar;

    @OneToOne
    private DepartType departType ;

    public DepartType getDepartType() {
        return departType;
    }

    public void setDepartType(DepartType departType) {
        this.departType = departType;
    }

    public Caracteristique() {
    }

    public Caracteristique(String tenstion_sortie_triphase, String tenstion_sortie_mono, String courantA, String tenstion_extrimite_triphase, String tenstion_extrimite_mono, String nbr_lumineux, Departt derpar,DepartType departType) {
        this.tenstion_sortie_triphase = tenstion_sortie_triphase;
        this.tenstion_sortie_mono = tenstion_sortie_mono;
        this.courantA = courantA;
        this.tenstion_extrimite_triphase = tenstion_extrimite_triphase;
        this.tenstion_extrimite_mono = tenstion_extrimite_mono;
        this.nbr_lumineux = nbr_lumineux;
        this.derpar = derpar;
        this.departType=departType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenstion_sortie_triphase() {
        return tenstion_sortie_triphase;
    }

    public void setTenstion_sortie_triphase(String tenstion_sortie_triphase) {
        this.tenstion_sortie_triphase = tenstion_sortie_triphase;
    }

    public String getTenstion_sortie_mono() {
        return tenstion_sortie_mono;
    }

    public void setTenstion_sortie_mono(String tenstion_sortie_mono) {
        this.tenstion_sortie_mono = tenstion_sortie_mono;
    }

    public String getCourantA() {
        return courantA;
    }

    public void setCourantA(String courantA) {
        this.courantA = courantA;
    }

    public String getTenstion_extrimite_triphase() {
        return tenstion_extrimite_triphase;
    }

    public void setTenstion_extrimite_triphase(String tenstion_extrimite_triphase) {
        this.tenstion_extrimite_triphase = tenstion_extrimite_triphase;
    }

    public String getTenstion_extrimite_mono() {
        return tenstion_extrimite_mono;
    }

    public void setTenstion_extrimite_mono(String tenstion_extrimite_mono) {
        this.tenstion_extrimite_mono = tenstion_extrimite_mono;
    }

    public String getNbr_lumineux() {
        return nbr_lumineux;
    }

    public void setNbr_lumineux(String nbr_lumineux) {
        this.nbr_lumineux = nbr_lumineux;
    }

    public Departt getDerpar() {
        return derpar;
    }

    public void setDerpar(Departt derpar) {
        this.derpar = derpar;
    }
}
