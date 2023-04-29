package com.example.demo.Adresse;

import com.example.demo.coordonnees.Coordonnees;
import com.example.demo.coordonnees.coordonneesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/adresse")
public class AdresseController {
    private final AdresseService adresseService;

    @Autowired
    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @GetMapping("/getAll")
    public List<Adresse> getpointLumineux() {
        return adresseService.getAll();
    }

    /*@PostMapping("/add")
    public void addpointLumineux(@RequestBody PointLumineux pointLumineux) throws IllegalAccessException {
        System.out.println("ajout avant ------------- "+pointLumineux.getAdresse().getRue());
        produitService.addPointLumineux(pointLumineux);
    }*/

    @DeleteMapping(value = "/delete/{reference}")
    public void deletepointLumineux(@PathVariable("reference") Long reference) throws IllegalAccessException {
        adresseService.delete(reference);
    }

}
