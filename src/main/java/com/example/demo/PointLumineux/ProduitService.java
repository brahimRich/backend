package com.example.demo.PointLumineux;

import com.example.demo.Adresse.AdressRepository;
import com.example.demo.Adresse.Adresse;
import com.example.demo.coordonnees.Coordonnees;
import com.example.demo.coordonnees.CoordonnesRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProduitService {
    private final PointLumineuxRepository PointLumineuxRepository;
    private final com.example.demo.Adresse.AdressRepository AdressRepository;
    private final CoordonnesRepository CoordonnesRepository;

    @Autowired
    public ProduitService(PointLumineuxRepository PointLumineuxRepository,AdressRepository AdressRepository,CoordonnesRepository CoordonnesRepository){
        this.PointLumineuxRepository = PointLumineuxRepository;
        this.AdressRepository=AdressRepository;
        this.CoordonnesRepository=CoordonnesRepository;
    }

    public List<PointLumineux> getPointLumineux() {
        return PointLumineuxRepository.findAll();
    }
    public void addPointLumineux(PointLumineux produit) throws IllegalAccessException {
        System.out.println("ajout ************************************ "+produit.getAdresse().getRue());
        /*Optional<PointLumineux> produitOptional = PointLumineuxRepository.findProduitByName(produit.getName());
        if(produitOptional.isPresent()){
            throw new IllegalAccessException("Name Token");
        }*/
        if(produit.getAdresse()!=null)
        AdressRepository.save(produit.getAdresse());
        CoordonnesRepository.save(produit.getCoordonnees());
        PointLumineuxRepository.save(produit);
    }

    public void deleteProduit(Long reference) throws IllegalAccessException {
        System.out.println("delete ************************************");
        boolean b = PointLumineuxRepository.existsById(reference);
        if(!b){
            throw new IllegalAccessException("Produit with reference "+reference+" does not exists");
        }
        PointLumineuxRepository.deleteById(reference);
    }
    @Transactional
    public void updateProduit(Long reference, PointLumineux p) throws IllegalAccessException {
        System.out.println("updatee ************************************ "+reference);
        System.out.println("type ************************************ "+p.getType());
        PointLumineux pointLumineux = PointLumineuxRepository.findById(reference).orElseThrow(()-> new IllegalArgumentException("point with reference "+reference+" does not exists"));
        Adresse adresse = AdressRepository.findById(p.getAdresse().getId()).orElseThrow(()-> new IllegalArgumentException("adresse with reference "+reference+" does not exists"));
        Coordonnees coordonnees = CoordonnesRepository.findById(p.getCoordonnees().getId()).orElseThrow(()-> new IllegalArgumentException("cordonnes with reference "+reference+" does not exists"));
        pointLumineux.setType(p.getType());
        pointLumineux.setAdresse(p.getAdresse());
        pointLumineux.setAllume(p.getAllume());
        pointLumineux.setCoordonnees(p.getCoordonnees());
        pointLumineux.setNumero(p.getNumero());
        pointLumineux.setMarque(p.getMarque());
        pointLumineux.setLatitude(p.getLatitude());
        pointLumineux.setLongitude(p.getLongitude());
        pointLumineux.setDegre_prot(p.getDegre_prot());
        pointLumineux.setPuissance_max(p.getPuissance_max());
        pointLumineux.setTemperature(p.getTemperature());
        pointLumineux.setClass_electrique(p.getClass_electrique());
        pointLumineux.setDate_accussition(p.getDate_accussition());
        adresse=p.getAdresse();
        coordonnees=p.getCoordonnees();
        AdressRepository.save(adresse);
        CoordonnesRepository.save(coordonnees);
        PointLumineuxRepository.save(pointLumineux);
    }
}
