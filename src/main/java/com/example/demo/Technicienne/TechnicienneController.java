package com.example.demo.Technicienne;


import com.example.demo.Admin.Admin;
import com.example.demo.Admin.AdminService;
import com.example.demo.Armoire.Armoire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/technicienne")
public class TechnicienneController {
    private final AdminService adminService;
    private final TechnicienneService technicienneService;

    @Autowired
    public TechnicienneController(AdminService adminSe,TechnicienneService technicienneService) {
        this.adminService = adminSe;
        this.technicienneService=technicienneService;
    }

    @GetMapping("/getAll")
    public List<Technicienne> getAdmins() {
        return technicienneService.getTechns();
    }

    @PostMapping("/add")
    public void addpointLumineux(@RequestBody Technicienne iner) throws IllegalAccessException {
        technicienneService.addTechnicienne(iner);
    }

    @DeleteMapping(value = "/delete/{reference}")
    public void deletepointLumineux(@PathVariable("reference") Long reference) throws IllegalAccessException {
        technicienneService.deleteTechnicienne(reference);
    }

    @PutMapping(value = "update/{reference}")
    public void updatepointLumineux(
            @PathVariable("reference") Long reference,
            @RequestBody Technicienne technicienne
    ) throws IllegalAccessException {
        technicienneService.updateTechnicienne(reference,technicienne);
    }

}
