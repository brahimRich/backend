package com.example.demo.Depart;

import com.example.demo.Armoire.Armoire;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Departt {

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
    private String Observation;

   /* @ManyToMany
    private List<DepartType> departTypeList ;*/

    @OneToMany(cascade = CascadeType.ALL)
    private List<Caracteristique> caracteristiqueList;

    @OneToOne
    private Armoire armoire;

    public Armoire getArmoire() {
        return armoire;
    }

    public void setArmoire(Armoire armoire) {
        this.armoire = armoire;
    }

    public Departt() {
    }

    public Departt(String observation,Armoire armoire , List<Caracteristique> caracteristiqueList) {
        Observation = observation;
        this.caracteristiqueList = caracteristiqueList;
        this.armoire=armoire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservation() {
        return Observation;
    }

    public void setObservation(String observation) {
        Observation = observation;
    }

    /*public List<DepartType> getDepartTypeList() {
        return departTypeList;
    }

    public void setDepartTypeList(List<DepartType> departTypeList) {
        this.departTypeList = departTypeList;
    }*/

    public List<Caracteristique> getCaracteristiqueList() {
        return caracteristiqueList;
    }

    public void setCaracteristiqueList(List<Caracteristique> caracteristiqueList) {
        this.caracteristiqueList = caracteristiqueList;
    }
}
