package com.example.demo.Intervention;

import com.example.demo.PointLumineux.PointLumineux;
import com.example.demo.PointLumineux.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/intervention")
public class InterventionController {
    private final InterventionService interventionService;

    @Autowired
    public InterventionController(InterventionService interventionService) {
        this.interventionService = interventionService;
    }

    @GetMapping("/getAll")
    public List<Intervention> getpointLumineux() {
        return interventionService.getallIntervention();
    }

    @PostMapping("/add")
    public void addpointLumineux(@RequestBody Intervention iner) throws IllegalAccessException {
        interventionService.addIntervention(iner);
    }

    @DeleteMapping(value = "/delete/{reference}")
    public void deletepointLumineux(@PathVariable("reference") Long reference) throws IllegalAccessException {
        interventionService.deleteInertvention(reference);
    }

    @PutMapping(value = "update/{reference}")
    public void updatepointLumineux(
            @PathVariable("reference") Long reference,
            @RequestBody Intervention intervention
    ) throws IllegalAccessException {
        interventionService.updateIntervention(reference,intervention);
    }
}
