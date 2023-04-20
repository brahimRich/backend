package com.example.demo.PointLumineux;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
        System.out.println(produit);
        /*Optional<PointLumineux> produitOptional = PointLumineuxRepository.findProduitByName(produit.getName());
        if(produitOptional.isPresent()){
            throw new IllegalAccessException("Name Token");
        }*/
        PointLumineuxRepository.save(produit);
    }

    public void deleteProduit(Long reference) throws IllegalAccessException {
        boolean b = PointLumineuxRepository.existsById(reference);
        if(!b){
            throw new IllegalAccessException("Produit with reference "+reference+" does not exists");
        }
        PointLumineuxRepository.deleteById(reference);
    }
    @Transactional
    public void updateProduit(Long reference, String name, String img) throws IllegalAccessException {
        PointLumineux produit = PointLumineuxRepository.findById(reference).orElseThrow(()-> new IllegalArgumentException("Produit with reference "+reference+" does not exists"));
        if(name != null && name.length()>0 && !Objects.equals(produit.getName(),name)){
           /* Optional<Produit> produitOptional = produitRepository.findProduitByName(name);
            if(produitOptional.isPresent()){
                throw new IllegalAccessException("Name Token");
            }*/
            produit.setName(name);
        }
        System.out.println(produit);
    }
}
