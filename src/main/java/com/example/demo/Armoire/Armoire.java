package com.example.demo.Armoire;

import com.example.demo.Depart.Depart;
import com.example.demo.PointLumineux.PointLumineux;
import jakarta.persistence.*;

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
    private double idArmoire;
    private String marqueSectionneur;
    private String calibreSectionneur;
    private int nombreSectionneur;
    private String marquePorteFusible;
    private String calibrePorteFusible;
    private int nombrePorteFusible;
    private String marqueRepartiteur;
    private String calibreRepartiteur;
    private int nombreRepartiteur;
    private String marqueContacteur;
    private String calibreContacteur;
    private int nombreContacteur;
    private String marqueHorloge;
    private String calibreHorloge;
    private int nombreHorloge;
    private String marqueDisjunicC2;
    private String calibreDisjunicC2;
    private int nombreDisjunicC2;
    private String marqueBornes;
    private String calibreBornes;
    private int nombreBornes;
    private String marqueCablage;
    private String calibreCablage;
    private int nombreCablage;

    @OneToOne
    private Depart depart;
    public Depart getDeparts(){return depart; }

    public void setDeparts(Depart depart){
        this.depart = depart;
    }



    @OneToMany(mappedBy = "armoire")
    private List<PointLumineux> pointLumineuxList;

    public List<PointLumineux> getPointLumineuxList() {
        return pointLumineuxList;
    }

    public void setPointLumineuxList(List<PointLumineux> pointLumineuxList) {
        this.pointLumineuxList = pointLumineuxList;
    }

    public Armoire() {
        depart = new Depart();
    }

    public Armoire(double idArmoire, String marqueSectionneur, String calibreSectionneur, int nombreSectionneur,
                   String marquePorteFusible, String calibrePorteFusible, int nombrePorteFusible,
                   String marqueRepartiteur, String calibreRepartiteur, int nombreRepartiteur,
                   String marqueContacteur, String calibreContacteur, int nombreContacteur,
                   String marqueHorloge, String calibreHorloge, int nombreHorloge,
                   String marqueDisjunicC2, String calibreDisjunicC2, int nombreDisjunicC2,
                   String marqueBornes, String calibreBornes, int nombreBornes,
                   String marqueCablage, String calibreCablage, int nombreCablage,Depart depart, List<PointLumineux> pointLimineuxList) {
        this.pointLumineuxList = pointLumineuxList;
        this.depart = depart;
        this.idArmoire = idArmoire;
        this.marqueSectionneur = marqueSectionneur;
        this.calibreSectionneur = calibreSectionneur;
        this.nombreSectionneur = nombreSectionneur;
        this.marquePorteFusible = marquePorteFusible;
        this.calibrePorteFusible = calibrePorteFusible;
        this.nombrePorteFusible = nombrePorteFusible;
        this.marqueRepartiteur = marqueRepartiteur;
        this.calibreRepartiteur = calibreRepartiteur;
        this.nombreRepartiteur = nombreRepartiteur;
        this.marqueContacteur = marqueContacteur;
        this.calibreContacteur = calibreContacteur;
        this.nombreContacteur = nombreContacteur;
        this.marqueHorloge = marqueHorloge;
        this.calibreHorloge = calibreHorloge;
        this.nombreHorloge = nombreHorloge;
        this.marqueDisjunicC2 = marqueDisjunicC2;
        this.calibreDisjunicC2 = calibreDisjunicC2;
        this.nombreDisjunicC2 = nombreDisjunicC2;
        this.marqueBornes = marqueBornes;
        this.calibreBornes = calibreBornes;
        this.nombreBornes = nombreBornes;
        this.marqueCablage = marqueCablage;
        this.calibreCablage = calibreCablage;
        this.nombreCablage = nombreCablage;
    }

    public double getIdArmoire() {
        return idArmoire;
    }

    public void setIdArmoire(double idArmoire) {
        this.idArmoire = idArmoire;
    }

    public String getMarqueSectionneur() {
        return marqueSectionneur;
    }

    public void setMarqueSectionneur(String marqueSectionneur) {
        this.marqueSectionneur = marqueSectionneur;
    }

    public String getCalibreSectionneur() {
        return calibreSectionneur;
    }

    public void setCalibreSectionneur(String calibreSectionneur) {
        this.calibreSectionneur = calibreSectionneur;
    }

    public int getNombreSectionneur() {
        return nombreSectionneur;
    }

    public void setNombreSectionneur(int nombreSectionneur) {
        this.nombreSectionneur = nombreSectionneur;
    }

    public String getMarquePorteFusible() {
        return marquePorteFusible;
    }

    public void setMarquePorteFusible(String marquePorteFusible) {
        this.marquePorteFusible = marquePorteFusible;
    }

    public String getCalibrePorteFusible() {
        return calibrePorteFusible;
    }

    public void setCalibrePorteFusible(String calibrePorteFusible) {
        this.calibrePorteFusible = calibrePorteFusible;
    }

    public int getNombrePorteFusible() {
        return nombrePorteFusible;
    }

    public void setNombrePorteFusible(int nombrePorteFusible) {
        this.nombrePorteFusible = nombrePorteFusible;
    }

    public String getMarqueRepartiteur() {
        return marqueRepartiteur;
    }

    public void setMarqueRepartiteur(String marqueRepartiteur) {
        this.marqueRepartiteur = marqueRepartiteur;
    }

    public String getCalibreRepartiteur() {
        return calibreRepartiteur;
    }

    public void setCalibreRepartiteur(String calibreRepartiteur) {
        this.calibreRepartiteur = calibreRepartiteur;
    }

    public int getNombreRepartiteur() {
        return nombreRepartiteur;
    }

    public void setNombreRepartiteur(int nombreRepartiteur) {
        this.nombreRepartiteur = nombreRepartiteur;
    }

    public String getMarqueContacteur() {
        return marqueContacteur;
    }

    public void setMarqueContacteur(String marqueContacteur) {
        this.marqueContacteur = marqueContacteur;
    }

    public String getCalibreContacteur() {
        return calibreContacteur;
    }

    public void setCalibreContacteur(String calibreContacteur) {
        this.calibreContacteur = calibreContacteur;
    }

    public int getNombreContacteur() {
        return nombreContacteur;
    }

    public void setNombreContacteur(int nombreContacteur) {
        this.nombreContacteur = nombreContacteur;
    }

    public String getMarqueHorloge() {
        return marqueHorloge;
    }

    public void setMarqueHorloge(String marqueHorloge) {
        this.marqueHorloge = marqueHorloge;
    }

    public String getCalibreHorloge() {
        return calibreHorloge;
    }

    public void setCalibreHorloge(String calibreHorloge) {
        this.calibreHorloge = calibreHorloge;
    }

    public int getNombreHorloge() {
        return nombreHorloge;
    }

    public void setNombreHorloge(int nombreHorloge) {
        this.nombreHorloge = nombreHorloge;
    }

    public String getMarqueDisjunicC2() {
        return marqueDisjunicC2;
    }

    public void setMarqueDisjunicC2(String marqueDisjunicC2) {
        this.marqueDisjunicC2 = marqueDisjunicC2;
    }

    public String getCalibreDisjunicC2() {
        return calibreDisjunicC2;
    }

    public void setCalibreDisjunicC2(String calibreDisjunicC2) {
        this.calibreDisjunicC2 = calibreDisjunicC2;
    }

    public int getNombreDisjunicC2() {
        return nombreDisjunicC2;
    }

    public void setNombreDisjunicC2(int nombreDisjunicC2) {
        this.nombreDisjunicC2 = nombreDisjunicC2;
    }

    public String getMarqueBornes() {
        return marqueBornes;
    }

    public void setMarqueBornes(String marqueBornes) {
        this.marqueBornes = marqueBornes;
    }

    public String getCalibreBornes() {
        return calibreBornes;
    }

    public void setCalibreBornes(String calibreBornes) {
        this.calibreBornes = calibreBornes;
    }

    public int getNombreBornes() {
        return nombreBornes;
    }

    public void setNombreBornes(int nombreBornes) {
        this.nombreBornes = nombreBornes;
    }

    public String getMarqueCablage() {
        return marqueCablage;
    }

    public void setMarqueCablage(String marqueCablage) {
        this.marqueCablage = marqueCablage;
    }

    public String getCalibreCablage() {
        return calibreCablage;
    }

    public void setCalibreCablage(String calibreCablage) {
        this.calibreCablage = calibreCablage;
    }

    public int getNombreCablage() {
        return nombreCablage;
    }

    public void setNombreCablage(int nombreCablage) {
        this.nombreCablage = nombreCablage;
    }
}
