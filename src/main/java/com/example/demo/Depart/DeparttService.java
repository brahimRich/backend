package com.example.demo.Depart;

import com.example.demo.Adresse.AdressRepository;
import com.example.demo.Armoire.*;
import com.example.demo.Intervention.InterventionRepository;
import com.example.demo.PointLumineux.PointLumineuxRepository;
import com.example.demo.Technicienne.TechnicienneRepository;
import com.example.demo.User.UserRepository;
import com.example.demo.User.utilisateur;
import com.example.demo.coordonnees.CoordonnesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeparttService {
    private final com.example.demo.PointLumineux.PointLumineuxRepository PointLumineuxRepository;
    private final com.example.demo.Adresse.AdressRepository AdressRepository;
    private final CoordonnesRepository CoordonnesRepository;
    private final InterventionRepository interventionRepository;
    private final TechnicienneRepository technicienneRepository;
    private final ArmoireRepository armoireRepository;
    private final ArmoireServiceRepository armoireServiceRepository;
    private final ArmoireCaracteristiqueRepository armoireCaracteristiqueRepository;
    private final DepartRepository departRepository;
    private final CaracteristiqueRepository caracteristiqueRepository;
    private final TypeRepository typeRepository;
    private final UserRepository userRepository;


    @Autowired
    public DeparttService(PointLumineuxRepository PointLumineuxRepository, AdressRepository AdressRepository, CoordonnesRepository CoordonnesRepository, InterventionRepository interventionRepository, TechnicienneRepository technicienneRepository, ArmoireRepository armoireRepository, ArmoireServiceRepository armoireServiceRepository, ArmoireCaracteristiqueRepository armoireCaracteristiqueRepository,DepartRepository departRepository,CaracteristiqueRepository caracteristiqueRepository,TypeRepository typeRepository,UserRepository userRepository){
        this.PointLumineuxRepository = PointLumineuxRepository;
        this.AdressRepository=AdressRepository;
        this.CoordonnesRepository=CoordonnesRepository;
        this.interventionRepository=interventionRepository;
        this.technicienneRepository=technicienneRepository;
        this.armoireRepository=armoireRepository;
        this.armoireServiceRepository=armoireServiceRepository;
        this.armoireCaracteristiqueRepository=armoireCaracteristiqueRepository;
        this.departRepository=departRepository;
        this.caracteristiqueRepository=caracteristiqueRepository;
        this.typeRepository=typeRepository;
        this.userRepository=userRepository;
    }

    public List<Departt> getallDepart() {
        return departRepository.findAll();
    }

    public void addDepart(Departt departt) throws IllegalAccessException {
        System.out.println("add depart-----------------------------");
        utilisateur u= userRepository.findById(departt.getAjouteurUser().getId()).orElseThrow(()-> new IllegalArgumentException("point with reference "+" does not exists"));
        for (Caracteristique caracteristique : departt.getCaracteristiqueList()) {
            //if not existe
            DepartType departType  = typeRepository.findTypeByName(caracteristique.getDepartType().getTypedepart());
            if(departType!=null) caracteristique.setDepartType(departType);
            else typeRepository.save(caracteristique.getDepartType());
            caracteristiqueRepository.save(caracteristique);
        }
        if(u!=null) departt.setAjouteurUser(u);
        departRepository.save(departt);
    }

    public void deleteDepart(Long reference) throws IllegalAccessException {
        System.out.println("delete ************************************");
        boolean b = departRepository.existsById(reference);
        if(!b){
            throw new IllegalAccessException("Produit with reference "+reference+" does not exists");
        }
        departRepository.deleteById(reference);
    }
    public void saveOrUpdateCaracteristique(Caracteristique c) {
        DepartType departType = typeRepository.findTypeByName(c.getDepartType().getTypedepart());
        if (departType == null) {
            if (c.getDepartType() != null) {
                typeRepository.save(c.getDepartType()); // Save the DepartType instance first
            }
        } else {
            c.setDepartType(departType);
        }
        caracteristiqueRepository.save(c); // Then save the Caracteristique instance
    }

    @Transactional
    public void updateDepart(Long reference, Departt p) throws IllegalArgumentException {
        System.out.println("update ************************************ " + reference);
        Departt departt = departRepository.findById(reference)
                .orElseThrow(() -> new IllegalArgumentException("depart with reference " + reference + " does not exist"));
        departt.setCaracteristiqueList(p.getCaracteristiqueList());
        departt.setArmoire(p.getArmoire());
        departt.setObservation(p.getObservation());
        for (Caracteristique caracteristique : departt.getCaracteristiqueList()) {
            this.saveOrUpdateCaracteristique(caracteristique);
        }
        departRepository.save(departt);
    }



}
