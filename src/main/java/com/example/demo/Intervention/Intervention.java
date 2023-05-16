package com.example.demo.Intervention;

import java.util.Date;

import com.example.demo.Admin.Admin;
import com.example.demo.PointLumineux.PointLumineux;
import com.example.demo.Technicienne.Technicienne;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Intervention {

    @Id
    @SequenceGenerator(
            name = "Intervention_sequence",
            sequenceName = "Intervention_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Intervention_sequence"
    )
    private Long Id_Intervention;

    private Date Date_intervention;

    private String type;

    private String intitule_Intervention;

    private String dure_Intervention;

    private String etat_intervention;

    @ManyToMany
    private List<Technicienne> techniciennes;

    @OneToOne
    private Technicienne completeur;

    @ManyToOne
    private Admin admin;

    @ManyToMany
    private List<PointLumineux> pointLumineuxList;

    public List<PointLumineux> getPointLumineuxList() {
        return pointLumineuxList;
    }

    public Technicienne getCompleteur() {
        return completeur;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setCompleteur(Technicienne completeur) {
        this.completeur = completeur;
    }

    public void setPointLumineuxList(List<PointLumineux> pointLumineuxList) {
        this.pointLumineuxList = pointLumineuxList;
    }

    public void setId_Intervention(long id_Intervention) {
        Id_Intervention = id_Intervention;
    }

    public List<Technicienne> getTechniciennes() {
        return techniciennes;
    }

    public void setTechniciennes(List<Technicienne> techniciennes) {
        this.techniciennes = techniciennes;
    }

    // Constructeur par défaut
    public Intervention() {}

    // Constructeur avec paramètres
    public Intervention( Date date_intervention, String type,
                        String intitule_Intervention,
                        String dure_Intervention, String etat_intervention, List<PointLumineux> pointLumineuxList,List<Technicienne> techniciennes,Admin admin) {
        this.pointLumineuxList = pointLumineuxList;
        this.Date_intervention = date_intervention;
        this.type = type;
        this.intitule_Intervention = intitule_Intervention;
        this.dure_Intervention = dure_Intervention;
        this.etat_intervention = etat_intervention;
        this.techniciennes = techniciennes;
        this.admin=admin;
    }

    public Long getId_Intervention() {
        return Id_Intervention;
    }

    public void setId_Intervention(Long id_Intervention) {
        this.Id_Intervention = id_Intervention;
    }

    public Date getDate_intervention() {
        return Date_intervention;
    }

    public void setDate_intervention(Date date_intervention) {
        this.Date_intervention = date_intervention;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntitule_Intervention() {
        return intitule_Intervention;
    }

    public void setIntitule_Intervention(String intitule_Intervention) {
        this.intitule_Intervention = intitule_Intervention;
    }

    public String getDure_Intervention() {
        return dure_Intervention;
    }

    public void setDure_Intervention(String dure_Intervention) {
        this.dure_Intervention = dure_Intervention;
    }

    public String getEtat_intervention() {
        return etat_intervention;
    }

    public void setEtat_intervention(String etat_intervention) {
        this.etat_intervention = etat_intervention;
    }


}
