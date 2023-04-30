package com.example.demo.Depart;

import com.example.demo.Armoire.Armoire;
import com.example.demo.Armoire.ArmoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/depart")
public class DepartController {
    private final DeparttService departtService;

    @Autowired
    public DepartController(DeparttService departtService) {
        this.departtService = departtService;
    }

    @GetMapping("/getAll")
    public List<Departt> getpointLumineux() {
        return departtService.getallDepart();
    }
    @PostMapping("/add")
    public void addpointLumineux(@RequestBody Armoire iner) throws IllegalAccessException {
        ///armoireService.addArmoire(iner);
    }

    @DeleteMapping(value = "/delete/{reference}")
    public void deletepointLumineux(@PathVariable("reference") Long reference) throws IllegalAccessException {
        //armoireService.deleteArmoire(reference);
    }

    @PutMapping(value = "update/{reference}")
    public void updatepointLumineux(
            @PathVariable("reference") Long reference,
            @RequestBody Armoire armoire
    ) throws IllegalAccessException {
       // armoireService.updateArmoire(reference,armoire);
    }
}
