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
    private final CaracteristiqueRepository caracteristiqueRepository;


    @Autowired
    public DeparttService(PointLumineuxRepository PointLumineuxRepository, AdressRepository AdressRepository, CoordonnesRepository CoordonnesRepository, InterventionRepository interventionRepository, TechnicienneRepository technicienneRepository, ArmoireRepository armoireRepository, ArmoireServiceRepository armoireServiceRepository, ArmoireCaracteristiqueRepository armoireCaracteristiqueRepository,DepartRepository departRepository,CaracteristiqueRepository caracteristiqueRepository){
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
    }

    public List<Departt> getallDepart() {
        return departRepository.findAll();
    }

    public void addDepart(Departt departt) throws IllegalAccessException {
        caracteristiqueRepository.saveAll(departt.getCaracteristiqueList());
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

    @Transactional
    public void updateDepart(Long reference, Departt p) throws IllegalAccessException {
        System.out.println("updatee ************************************ "+reference);
        Armoire armoire = armoireRepository.findById(reference).orElseThrow(()-> new IllegalArgumentException("point with reference "+reference+" does not exists"));
        //armoire.setTypeArmoireList(p.getTypeArmoireList());
        //armoire.setArmoireListe(p.getArmoireListe());
        //completer ***
    }


}
