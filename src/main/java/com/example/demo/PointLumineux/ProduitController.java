package com.example.demo.PointLumineux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/produit")
public class ProduitController {
    private final ProduitService produitService;

    @Autowired
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/getAll")
    public List<PointLumineux> getpointLumineux() {
        return produitService.getPointLumineux();
    }
    @PostMapping("/add")
    public void addpointLumineux(@RequestBody PointLumineux pointLumineux) throws IllegalAccessException {
        System.out.println("ajout avant ------------- "+pointLumineux.getAdresse().getRue());
        produitService.addPointLumineux(pointLumineux);
    }
    @DeleteMapping(value = "/delete/{reference}")
    public void deletepointLumineux(@PathVariable("reference") Long reference) throws IllegalAccessException {
        produitService.deleteProduit(reference);
    }
    @PutMapping(value = "update/{reference}")
    public void updatepointLumineux(
            @PathVariable("reference") Long reference,
            @RequestBody PointLumineux pointLumineux
    ) throws IllegalAccessException {
        produitService.updateProduit(reference,pointLumineux);
    }
}
