package com.example.demo.Armoire;

import com.example.demo.Intervention.Intervention;
import com.example.demo.Intervention.InterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/armoire")
public class ArmoireController {
    private final ArmoireService armoireService;

    @Autowired
    public ArmoireController(ArmoireService armoireService) {
        this.armoireService = armoireService;
    }

    @GetMapping("/getAll")
    public List<Armoire> getpointLumineux() {
        return armoireService.getallArmoires();
    }
    @PostMapping("/add")
    public void addpointLumineux(@RequestBody Armoire iner) throws IllegalAccessException {
        armoireService.addArmoire(iner);
    }

    @DeleteMapping(value = "/delete/{reference}")
    public void deletepointLumineux(@PathVariable("reference") Long reference) throws IllegalAccessException {
        armoireService.deleteArmoire(reference);
    }

    @PutMapping(value = "update/{reference}")
    public void updatepointLumineux(
            @PathVariable("reference") Long reference,
            @RequestBody Armoire armoire
    ) throws IllegalAccessException {
        armoireService.updateArmoire(reference,armoire);
    }
}
