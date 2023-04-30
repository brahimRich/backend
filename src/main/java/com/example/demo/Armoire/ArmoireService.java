package com.example.demo.Armoire;

import com.example.demo.Adresse.AdressRepository;
import com.example.demo.Intervention.Intervention;
import com.example.demo.Intervention.InterventionRepository;
import com.example.demo.PointLumineux.PointLumineuxRepository;
import com.example.demo.Technicienne.TechnicienneRepository;
import com.example.demo.coordonnees.CoordonnesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArmoireService {
    private final com.example.demo.PointLumineux.PointLumineuxRepository PointLumineuxRepository;
    private final com.example.demo.Adresse.AdressRepository AdressRepository;
    private final CoordonnesRepository CoordonnesRepository;
    private final InterventionRepository interventionRepository;
    private final TechnicienneRepository technicienneRepository;
    private final ArmoireRepository armoireRepository;
    private final ArmoireServiceRepository armoireServiceRepository;
    private final ArmoireCaracteristiqueRepository armoireCaracteristiqueRepository;




    @Autowired
    public ArmoireService(PointLumineuxRepository PointLumineuxRepository, AdressRepository AdressRepository, CoordonnesRepository CoordonnesRepository, InterventionRepository interventionRepository, TechnicienneRepository technicienneRepository,ArmoireRepository armoireRepository,ArmoireServiceRepository armoireServiceRepository,ArmoireCaracteristiqueRepository armoireCaracteristiqueRepository){
        this.PointLumineuxRepository = PointLumineuxRepository;
        this.AdressRepository=AdressRepository;
        this.CoordonnesRepository=CoordonnesRepository;
        this.interventionRepository=interventionRepository;
        this.technicienneRepository=technicienneRepository;
        this.armoireRepository=armoireRepository;
        this.armoireServiceRepository=armoireServiceRepository;
        this.armoireCaracteristiqueRepository=armoireCaracteristiqueRepository;
    }

    public List<Armoire> getallArmoires() {
        return armoireRepository.findAll();
    }

    public void addArmoire(Armoire armoire) throws IllegalAccessException {
        //armoireServiceRepository.saveAll(armoire.getTypeArmoireList());
        armoireCaracteristiqueRepository.saveAll(armoire.getArmoireListe());
        armoireRepository.save(armoire);
    }

    public void deleteArmoire(Long reference) throws IllegalAccessException {
        System.out.println("delete ************************************");
        boolean b = armoireRepository.existsById(reference);
        if(!b){
            throw new IllegalAccessException("Produit with reference "+reference+" does not exists");
        }
        armoireRepository.deleteById(reference);
    }

    @Transactional
    public void updateArmoire(Long reference, Armoire p) throws IllegalAccessException {
        System.out.println("updatee ************************************ "+reference);
        Armoire armoire = armoireRepository.findById(reference).orElseThrow(()-> new IllegalArgumentException("point with reference "+reference+" does not exists"));
        //armoire.setTypeArmoireList(p.getTypeArmoireList());
        armoire.setArmoireListe(p.getArmoireListe());
        //completer ***
    }
}
