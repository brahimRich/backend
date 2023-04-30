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
    public void addpointLumineux(@RequestBody Departt departt) throws IllegalAccessException {
        departtService.addDepart(departt);
    }

    @DeleteMapping(value = "/delete/{reference}")
    public void deletepointLumineux(@PathVariable("reference") Long reference) throws IllegalAccessException {
        departtService.deleteDepart(reference);
    }

    @PutMapping(value = "update/{reference}")
    public void updatepointLumineux(
            @PathVariable("reference") Long reference,
            @RequestBody Departt departt
    ) throws IllegalAccessException {
       departtService.updateDepart(reference,departt);
    }
}
