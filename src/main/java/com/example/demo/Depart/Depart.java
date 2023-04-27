package com.example.demo.Depart;

import com.example.demo.Armoire.Armoire;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Depart {

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
    private double id_Depart;
    private double id_Armoire;
    private int type_Depart;
    private String r_TensionV_Triphase;
    private String r_TensionV_mono;
    private String s_TensionV_Triphase;
    private String s_TensionV_mono;
    private String t_TensionV_Triphase;
    private String t_TensionV_mono;
    private int r_CourantA;
    private int s_CourantA;
    private int t_CourantA;
    private String r_TensionExt_Triphase;
    private String r_TensionExt_mono;
    private String s_TensionExt_Triphase;
    private String s_TensionExt_mono;
    private String t_TensionExt_Triphase;
    private String t_TensionExt_mono;
    private int r_nb_luminaire;
    private int s_nb_luminaire;
    private int t_nb_luminaire;

    @OneToOne(mappedBy = "depart", optional = false)
    private Armoire armoire;

    public Armoire getArmoire() {
        return armoire;
    }

    public void setArmoire(Armoire armoire) {
        this.armoire = armoire;
    }

    // Constructeur par défaut
    public Depart() {
    }

    // Constructeur avec paramètres
    public Depart(double id_Depart, double id_Armoire, int type_Depart, String r_TensionV_Triphase,
                  String r_TensionV_mono, String s_TensionV_Triphase, String s_TensionV_mono, String t_TensionV_Triphase,
                  String t_TensionV_mono, int r_CourantA, int s_CourantA, int t_CourantA, String r_TensionExt_Triphase,
                  String r_TensionExt_mono, String s_TensionExt_Triphase, String s_TensionExt_mono,
                  String t_TensionExt_Triphase, String t_TensionExt_mono, int r_nb_luminaire, int s_nb_luminaire,
                  int t_nb_luminaire,Armoire armoire) {
        this.armoire = armoire;
        this.id_Depart = id_Depart;
        this.id_Armoire = id_Armoire;
        this.type_Depart = type_Depart;
        this.r_TensionV_Triphase = r_TensionV_Triphase;
        this.r_TensionV_mono = r_TensionV_mono;
        this.s_TensionV_Triphase = s_TensionV_Triphase;
        this.s_TensionV_mono = s_TensionV_mono;
        this.t_TensionV_Triphase = t_TensionV_Triphase;
        this.t_TensionV_mono = t_TensionV_mono;
        this.r_CourantA = r_CourantA;
        this.s_CourantA = s_CourantA;
        this.t_CourantA = t_CourantA;
        this.r_TensionExt_Triphase = r_TensionExt_Triphase;
        this.r_TensionExt_mono = r_TensionExt_mono;
        this.s_TensionExt_Triphase = s_TensionExt_Triphase;
        this.s_TensionExt_mono = s_TensionExt_mono;
        this.t_TensionExt_Triphase = t_TensionExt_Triphase;
        this.t_TensionExt_mono = t_TensionExt_mono;
        this.r_nb_luminaire = r_nb_luminaire;
        this.s_nb_luminaire = s_nb_luminaire;
        this.t_nb_luminaire = t_nb_luminaire;
    }

    // Getters
    public double getId_Depart() {
        return id_Depart;
    }

    public double getId_Armoire() {
        return id_Armoire;
    }

    public void setId_Depart(double id_Depart) {
        this.id_Depart = id_Depart;
    }

    public void setId_Armoire(double id_Armoire) {
        this.id_Armoire = id_Armoire;
    }

    public void setType_Depart(int type_Depart) {
        this.type_Depart = type_Depart;
    }

    public void setR_TensionV_Triphase(String r_TensionV_Triphase) {
        this.r_TensionV_Triphase = r_TensionV_Triphase;
    }

    public void setR_TensionV_mono(String r_TensionV_mono) {
        this.r_TensionV_mono = r_TensionV_mono;
    }

    public void setS_TensionV_Triphase(String s_TensionV_Triphase) {
        this.s_TensionV_Triphase = s_TensionV_Triphase;
    }

    public void setS_TensionV_mono(String s_TensionV_mono) {
        this.s_TensionV_mono = s_TensionV_mono;
    }

    public void setT_TensionV_Triphase(String t_TensionV_Triphase) {
        this.t_TensionV_Triphase = t_TensionV_Triphase;
    }

    public void setT_TensionV_mono(String t_TensionV_mono) {
        this.t_TensionV_mono = t_TensionV_mono;
    }

    public void setR_CourantA(int r_CourantA) {
        this.r_CourantA = r_CourantA;
    }

    public void setS_CourantA(int s_CourantA) {
        this.s_CourantA = s_CourantA;
    }

    public void setT_CourantA(int t_CourantA) {
        this.t_CourantA = t_CourantA;
    }

    public void setR_TensionExt_Triphase(String r_TensionExt_Triphase) {
        this.r_TensionExt_Triphase = r_TensionExt_Triphase;
    }

    public void setR_TensionExt_mono(String r_TensionExt_mono) {
        this.r_TensionExt_mono = r_TensionExt_mono;
    }

    public void setS_TensionExt_Triphase(String s_TensionExt_Triphase) {
        this.s_TensionExt_Triphase = s_TensionExt_Triphase;
    }

    public void setS_TensionExt_mono(String s_TensionExt_mono) {
        this.s_TensionExt_mono = s_TensionExt_mono;
    }

    public void setT_TensionExt_Triphase(String t_TensionExt_Triphase) {
        this.t_TensionExt_Triphase = t_TensionExt_Triphase;
    }

    public void setT_TensionExt_mono(String t_TensionExt_mono) {
        this.t_TensionExt_mono = t_TensionExt_mono;
    }

    public void setR_nb_luminaire(int r_nb_luminaire) {
        this.r_nb_luminaire = r_nb_luminaire;
    }

    public void setS_nb_luminaire(int s_nb_luminaire) {
        this.s_nb_luminaire = s_nb_luminaire;
    }

    public void setT_nb_luminaire(int t_nb_luminaire) {
        this.t_nb_luminaire = t_nb_luminaire;
    }


}