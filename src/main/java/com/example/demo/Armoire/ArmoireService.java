package com.example.demo.Armoire;

import com.example.demo.Adresse.AdressRepository;
import com.example.demo.Intervention.Intervention;
import com.example.demo.Intervention.InterventionRepository;
import com.example.demo.PointLumineux.PointLumineuxRepository;
import com.example.demo.Technicienne.TechnicienneRepository;
import com.example.demo.User.UserRepository;
import com.example.demo.User.utilisateur;
import com.example.demo.coordonnees.CoordonnesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private final UserRepository userRepository;




    @Autowired
    public ArmoireService(PointLumineuxRepository PointLumineuxRepository, AdressRepository AdressRepository, CoordonnesRepository CoordonnesRepository, InterventionRepository interventionRepository, TechnicienneRepository technicienneRepository,ArmoireRepository armoireRepository,ArmoireServiceRepository armoireServiceRepository,ArmoireCaracteristiqueRepository armoireCaracteristiqueRepository,UserRepository userRepository){
        this.PointLumineuxRepository = PointLumineuxRepository;
        this.AdressRepository=AdressRepository;
        this.CoordonnesRepository=CoordonnesRepository;
        this.interventionRepository=interventionRepository;
        this.technicienneRepository=technicienneRepository;
        this.armoireRepository=armoireRepository;
        this.armoireServiceRepository=armoireServiceRepository;
        this.armoireCaracteristiqueRepository=armoireCaracteristiqueRepository;
        this.userRepository=userRepository;
    }

    public List<Armoire> getallArmoires() {
        return armoireRepository.findAll();
    }

    public void addArmoire(Armoire armoire) throws IllegalAccessException {
        Armoire newArmoire = new Armoire();
        utilisateur u= userRepository.findById(armoire.getAjouteurUser().getId()).orElseThrow(()-> new IllegalArgumentException("point with reference "+" does not exists"));
        for (ArmoireCaracteristique armoireCaracteristique : armoire.getArmoireListe()) {
            armoireCaracteristique.setTypeArmoire(armoireCaracteristique.getTypeArmoire());
            System.out.println("id************************* "+armoireCaracteristique.getTypeArmoire().getId());
            armoireServiceRepository.save(armoireCaracteristique.getTypeArmoire());
            newArmoire.getArmoireListe().add(armoireCaracteristique);
            armoireCaracteristiqueRepository.save(armoireCaracteristique);
        }
        if(u!=null) newArmoire.setAjouteurUser(u);
       armoireRepository.save(newArmoire);

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
        for (ArmoireCaracteristique armoireCaracteristique : p.getArmoireListe()) {
            armoireCaracteristiqueRepository.save(armoireCaracteristique);
        }
        armoireRepository.save(armoire);
    }
}
