package com.example.demo.coordonnees;

import com.example.demo.Adresse.AdressRepository;
import com.example.demo.Adresse.Adresse;
import com.example.demo.PointLumineux.PointLumineux;
import com.example.demo.PointLumineux.PointLumineuxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class coordonneesService {
    private final com.example.demo.PointLumineux.PointLumineuxRepository PointLumineuxRepository;
    private final com.example.demo.Adresse.AdressRepository AdressRepository;
    private final CoordonnesRepository CoordonnesRepository;

    @Autowired
    public coordonneesService(PointLumineuxRepository PointLumineuxRepository, AdressRepository AdressRepository, CoordonnesRepository CoordonnesRepository){
        this.PointLumineuxRepository = PointLumineuxRepository;
        this.AdressRepository=AdressRepository;
        this.CoordonnesRepository=CoordonnesRepository;
    }

    public List<Coordonnees> getAll() {
        return CoordonnesRepository.findAll();
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
        boolean b = CoordonnesRepository.existsById(reference);
        if(!b){
            throw new IllegalAccessException("Produit with reference "+reference+" does not exists");
        }
        CoordonnesRepository.deleteById(reference);
    }

}
