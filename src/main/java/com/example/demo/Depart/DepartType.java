package com.example.demo.Depart;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class DepartType {

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
    private Long id_Depart;
    private double num_depart;
    private String typedepart;

    @ManyToMany
    private List<Departt> departtList ;

    public DepartType(double num_depart, String typedepart, List<Departt> departtList) {
        this.num_depart = num_depart;
        this.typedepart = typedepart;
        this.departtList = departtList;
    }

    public DepartType() {
    }

    public Long getId_Depart() {
        return id_Depart;
    }

    public void setId_Depart(Long id_Depart) {
        this.id_Depart = id_Depart;
    }

    public double getNum_depart() {
        return num_depart;
    }

    public void setNum_depart(double num_depart) {
        this.num_depart = num_depart;
    }

    public String getTypedepart() {
        return typedepart;
    }

    public void setTypedepart(String typedepart) {
        this.typedepart = typedepart;
    }

    public List<Departt> getDeparttList() {
        return departtList;
    }

    public void setDeparttList(List<Departt> departtList) {
        this.departtList = departtList;
    }
}