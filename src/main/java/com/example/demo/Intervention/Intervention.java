package com.example.demo.Intervention;

import java.util.Date;
import com.example.demo.PointLumineux.PointLumineux;
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
    private long Id_Intervention;

    private Date Date_intervention;

    private String type;

    private String intitule_Intervention;

    private String nom_Intervenant;

    private int dure_Intervention;

    private float etat_intervention;

    private int Id_pt_limineux;

    private int id_intervenant;

    @OneToMany
    private List<PointLumineux> pointLumineuxList;
    public List<PointLumineux> getPointLumineuxList() {
        return pointLumineuxList;
    }

    public void setPointLumineuxList(List<PointLumineux> pointLumineuxList) {
        this.pointLumineuxList = pointLumineuxList;
    }

    // Constructeur par défaut
    public Intervention() {}

    // Constructeur avec paramètres
    public Intervention(int id_Intervention, Date date_intervention, String type,
                        String intitule_Intervention, String nom_Intervenant,
                        int dure_Intervention, float etat_intervention,
                        int id_pt_limineux, int id_intervenant,List<PointLumineux> pointLumineuxList) {
        this.pointLumineuxList = pointLumineuxList;
        this.Date_intervention = date_intervention;
        this.type = type;
        this.intitule_Intervention = intitule_Intervention;
        this.nom_Intervenant = nom_Intervenant;
        this.dure_Intervention = dure_Intervention;
        this.etat_intervention = etat_intervention;
        Id_pt_limineux = id_pt_limineux;
        this.id_intervenant = id_intervenant;
    }

    public long getId_Intervention() {
        return Id_Intervention;
    }

    public void setId_Intervention(int id_Intervention) {
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

    public String getNom_Intervenant() {
        return nom_Intervenant;
    }

    public void setNom_Intervenant(String nom_Intervenant) {
        this.nom_Intervenant = nom_Intervenant;
    }

    public int getDure_Intervention() {
        return dure_Intervention;
    }

    public void setDure_Intervention(int dure_Intervention) {
        this.dure_Intervention = dure_Intervention;
    }

    public float getEtat_intervention() {
        return etat_intervention;
    }

    public void setEtat_intervention(float etat_intervention) {
        this.etat_intervention = etat_intervention;
    }

    public int getId_pt_limineux() {
        return Id_pt_limineux;
    }

    public void setId_pt_limineux(int id_pt_limineux) {
        Id_pt_limineux = id_pt_limineux;
    }

    public int getId_intervenant() {
        return id_intervenant;
    }

    public void setId_intervenant(int id_intervenant) {
        this.id_intervenant = id_intervenant;
    }


}
