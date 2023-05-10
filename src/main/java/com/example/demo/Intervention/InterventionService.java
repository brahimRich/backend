package com.example.demo.Intervention;

import com.example.demo.Adresse.AdressRepository;
import com.example.demo.Adresse.Adresse;
import com.example.demo.PointLumineux.PointLumineux;
import com.example.demo.PointLumineux.PointLumineuxRepository;
import com.example.demo.Technicienne.Technicienne;
import com.example.demo.Technicienne.TechnicienneRepository;
import com.example.demo.coordonnees.Coordonnees;
import com.example.demo.coordonnees.CoordonnesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterventionService {
    private final com.example.demo.PointLumineux.PointLumineuxRepository PointLumineuxRepository;
    private final com.example.demo.Adresse.AdressRepository AdressRepository;
    private final CoordonnesRepository CoordonnesRepository;
    private final InterventionRepository interventionRepository;
    private final TechnicienneRepository technicienneRepository;



    @Autowired
    public InterventionService(PointLumineuxRepository PointLumineuxRepository, AdressRepository AdressRepository, CoordonnesRepository CoordonnesRepository,InterventionRepository interventionRepository,TechnicienneRepository technicienneRepository){
        this.PointLumineuxRepository = PointLumineuxRepository;
        this.AdressRepository=AdressRepository;
        this.CoordonnesRepository=CoordonnesRepository;
        this.interventionRepository=interventionRepository;
        this.technicienneRepository=technicienneRepository;
    }

    public List<Intervention> getallIntervention() {
        return interventionRepository.findAll();
    }

    public void addIntervention(Intervention intervention) throws IllegalAccessException {
        /*if (intervention.getPointLumineuxList() == null) {
            intervention.setPointLumineuxList(new ArrayList<>());
        }
        boolean b = PointLumineuxRepository.existsById(intervention.getPointLumineuxList().get(0).getReference());
        if(!b){
            System.out.println("********************Produit with reference "+intervention.getPointLumineuxList().get(0).getReference()+" does not exists");
        }else{
            System.out.println("*******************************************");

        }
        Intervention inte = new Intervention(intervention.getDate_intervention(), intervention.getType(), intervention.getIntitule_Intervention(),
                intervention.getDure_Intervention(), intervention.getEtat_intervention(), intervention.getPointLumineuxList(), intervention.getTechniciennes());
        interventionRepository.save(intervention);
        System.out.println("*******************************************"+intervention.getId_Intervention());*/
    }

    public void deleteInertvention(Long reference) throws IllegalAccessException {
        System.out.println("delete ************************************");
        boolean b = interventionRepository.existsById(reference);
        if(!b){
            throw new IllegalAccessException("Produit with reference "+reference+" does not exists");
        }
        interventionRepository.deleteById(reference);
    }

    @Transactional
    public void updateIntervention(Long reference, Intervention p) throws IllegalAccessException {
        System.out.println("updatee ************************************ "+reference);
        Intervention intervention = interventionRepository.findById(reference).orElseThrow(()-> new IllegalArgumentException("point with reference "+reference+" does not exists"));
        intervention.setDate_intervention(p.getDate_intervention());
        intervention.setDure_Intervention(p.getDure_Intervention());
        //completer ***
    }
}
