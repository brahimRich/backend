package com.example.demo.coordonnees;

import com.example.demo.PointLumineux.PointLumineux;
import com.example.demo.PointLumineux.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/coordonnees")
public class coordonneesController {
    private final coordonneesService coordonneesService;

    @Autowired
    public coordonneesController(coordonneesService coordonneesService) {
        this.coordonneesService = coordonneesService;
    }

    @GetMapping("/getAll")
    public List<Coordonnees> getpointLumineux() {
        return coordonneesService.getAll();
    }

    /*@PostMapping("/add")
    public void addpointLumineux(@RequestBody PointLumineux pointLumineux) throws IllegalAccessException {
        System.out.println("ajout avant ------------- "+pointLumineux.getAdresse().getRue());
        produitService.addPointLumineux(pointLumineux);
    }*/

    @DeleteMapping(value = "/delete/{reference}")
    public void deletepointLumineux(@PathVariable("reference") Long reference) throws IllegalAccessException {
        coordonneesService.delete(reference);
    }

}
