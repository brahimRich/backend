package com.example.demo.Depart;

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

    @ManyToMany
    private List<DepartType> departTypeList ;

    @OneToMany
    private List<Caracteristique> caracteristiqueList;

    public Departt() {
    }

    public Departt(String observation, List<DepartType> departTypeList, List<Caracteristique> caracteristiqueList) {
        Observation = observation;
        this.departTypeList = departTypeList;
        this.caracteristiqueList = caracteristiqueList;
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

    public List<DepartType> getDepartTypeList() {
        return departTypeList;
    }

    public void setDepartTypeList(List<DepartType> departTypeList) {
        this.departTypeList = departTypeList;
    }

    public List<Caracteristique> getCaracteristiqueList() {
        return caracteristiqueList;
    }

    public void setCaracteristiqueList(List<Caracteristique> caracteristiqueList) {
        this.caracteristiqueList = caracteristiqueList;
    }
}
