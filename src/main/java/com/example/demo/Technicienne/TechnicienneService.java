package com.example.demo.Technicienne;


import com.example.demo.Admin.Admin;
import com.example.demo.Admin.AdminRepository;
import com.example.demo.Armoire.Armoire;
import com.example.demo.Depart.Departt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TechnicienneService {
    private final AdminRepository adminRepository;
    private final TechnicienneRepository technicienneRepository;

    @Autowired
    public TechnicienneService(AdminRepository AdminRepository,TechnicienneRepository technicienneRepository){
        this.adminRepository = AdminRepository;
        this.technicienneRepository=technicienneRepository;
    }

    public List<Technicienne> getTechns() {
        return technicienneRepository.findAll();
    }


    public void addTechnicienne(Technicienne technicienne) throws IllegalAccessException {
        technicienneRepository.save(technicienne);
    }

    public void deleteTechnicienne(Long reference) throws IllegalAccessException {
        System.out.println("delete ************************************");
        boolean b = technicienneRepository.existsById(reference);
        if(!b){
            throw new IllegalAccessException("Produit with reference "+reference+" does not exists");
        }else{
            technicienneRepository.deleteById(reference);
        }
    }

    @Transactional
    public void updateTechnicienne(Long reference, Technicienne t) throws IllegalAccessException {
        System.out.println("updatee ************************************ "+reference);
        Technicienne technicienne = technicienneRepository.findById(reference).orElseThrow(()-> new IllegalArgumentException("point with reference "+reference+" does not exists"));
        technicienne.setCin(t.getCin());
        technicienne.setNom(t.getNom());
        technicienne.setPrenom(t.getPrenom());
        technicienneRepository.save(technicienne);
    }
}
