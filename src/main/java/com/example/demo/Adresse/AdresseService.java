package com.example.demo.Adresse;

import com.example.demo.PointLumineux.PointLumineuxRepository;
import com.example.demo.coordonnees.Coordonnees;
import com.example.demo.coordonnees.CoordonnesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseService {
    private final com.example.demo.PointLumineux.PointLumineuxRepository PointLumineuxRepository;
    private final com.example.demo.Adresse.AdressRepository AdressRepository;
    private final com.example.demo.coordonnees.CoordonnesRepository CoordonnesRepository;

    @Autowired
    public AdresseService(PointLumineuxRepository PointLumineuxRepository, AdressRepository AdressRepository, CoordonnesRepository CoordonnesRepository){
        this.PointLumineuxRepository = PointLumineuxRepository;
        this.AdressRepository=AdressRepository;
        this.CoordonnesRepository=CoordonnesRepository;
    }

    public List<Adresse> getAll() {
        return AdressRepository.findAll();
    }


    /*public void add(Coordonnees c) throws IllegalAccessException {
        System.out.println("ajout ************************************ "+produit.getAdresse().getRue());
        if(c.getAdresse()!=null)
        AdressRepository.save(produit.getAdresse());
        CoordonnesRepository.save(produit.getCoordonnees());
        PointLumineuxRepository.save(c);
    }*/

    public void delete(Long reference) throws IllegalAccessException {
        System.out.println("delete ************************************");
        boolean b = AdressRepository.existsById(reference);
        if(!b){
            throw new IllegalAccessException("Produit with reference "+reference+" does not exists");
        }
        AdressRepository.deleteById(reference);
    }

}
