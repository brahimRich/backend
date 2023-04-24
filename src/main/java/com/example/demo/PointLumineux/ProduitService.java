package com.example.demo.PointLumineux;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProduitService {
    private final PointLumineuxRepository PointLumineuxRepository;

    @Autowired
    public ProduitService(PointLumineuxRepository PointLumineuxRepository){
        this.PointLumineuxRepository = PointLumineuxRepository;
    }

    public List<PointLumineux> getPointLumineux() {
        return PointLumineuxRepository.findAll();
    }
    public void addPointLumineux(PointLumineux produit) throws IllegalAccessException {
        System.out.println("ajout ************************************");
        /*Optional<PointLumineux> produitOptional = PointLumineuxRepository.findProduitByName(produit.getName());
        if(produitOptional.isPresent()){
            throw new IllegalAccessException("Name Token");
        }*/
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
        PointLumineux pointLumineux = PointLumineuxRepository.findById(reference).orElseThrow(()-> new IllegalArgumentException("Produit with reference "+reference+" does not exists"));
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
        PointLumineuxRepository.save(pointLumineux);
    }
}
