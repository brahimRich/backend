package com.example.demo.Depart;

import com.example.demo.Adresse.AdressRepository;
import com.example.demo.Armoire.Armoire;
import com.example.demo.Armoire.ArmoireCaracteristiqueRepository;
import com.example.demo.Armoire.ArmoireRepository;
import com.example.demo.Armoire.ArmoireServiceRepository;
import com.example.demo.Intervention.InterventionRepository;
import com.example.demo.PointLumineux.PointLumineuxRepository;
import com.example.demo.Technicienne.TechnicienneRepository;
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




    @Autowired
    public DeparttService(PointLumineuxRepository PointLumineuxRepository, AdressRepository AdressRepository, CoordonnesRepository CoordonnesRepository, InterventionRepository interventionRepository, TechnicienneRepository technicienneRepository, ArmoireRepository armoireRepository, ArmoireServiceRepository armoireServiceRepository, ArmoireCaracteristiqueRepository armoireCaracteristiqueRepository,DepartRepository departRepository){
        this.PointLumineuxRepository = PointLumineuxRepository;
        this.AdressRepository=AdressRepository;
        this.CoordonnesRepository=CoordonnesRepository;
        this.interventionRepository=interventionRepository;
        this.technicienneRepository=technicienneRepository;
        this.armoireRepository=armoireRepository;
        this.armoireServiceRepository=armoireServiceRepository;
        this.armoireCaracteristiqueRepository=armoireCaracteristiqueRepository;
        this.departRepository=departRepository;
    }

    public List<Departt> getallDepart() {
        return departRepository.findAll();
    }

    public void addArmoire(Departt departt) throws IllegalAccessException {

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
