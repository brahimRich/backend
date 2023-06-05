package com.example.demo.Technicienne;


import com.example.demo.Admin.Admin;
import com.example.demo.Admin.AdminService;
import com.example.demo.Armoire.Armoire;
import com.example.demo.Role.Role;
import com.example.demo.User.UserService;
import com.example.demo.User.utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path ="api/technicienne")
public class TechnicienneController {
    private final AdminService adminService;
    private final TechnicienneService technicienneService;
    private final UserService userService;

    @Autowired
    public TechnicienneController(AdminService adminSe,TechnicienneService technicienneService, UserService userService) {
        this.adminService = adminSe;
        this.technicienneService=technicienneService;
        this.userService=userService;
    }

    @GetMapping("/getAll")
    public List<Technicienne> getAdmins() {
        return technicienneService.getTechns();
    }

    @GetMapping("/getAllUser")
    public List<utilisateur> getAllUser() {
        return userService.GetAllUser();
    }

    @GetMapping("/getRoles")
    public List<Role> getrole() {
        return technicienneService.getAllrole();
    }


    @GetMapping("/getRolesUser/{reference}")
    public List<Role> getroleUser(@PathVariable("reference") Long reference) {
        return technicienneService.getAllroleUser(reference);
    }

    @PostMapping("/add")
    public void addpointLumineux(@RequestBody utilisateur iner) throws IllegalAccessException {
        System.out.println("typeeee ******/"+iner.getDtype());
        if(Objects.equals(iner.getDtype(), "Admin")){
            Admin admin=new Admin();
            admin.setNom(iner.getNom());
            admin.setPrenom(iner.getPrenom());
            admin.setPassword(iner.getPassword());
            admin.setCin(iner.getCin());
            admin.setEmail(iner.getEmail());
            admin.setTele(iner.getTele());
            adminService.adAdmin(admin);
        }
       if(Objects.equals(iner.getDtype(), "Technicienne")){
           Technicienne admin=new Technicienne();
           admin.setNom(iner.getNom());
           admin.setPrenom(iner.getPrenom());
           admin.setPassword(iner.getPassword());
           admin.setCin(iner.getCin());
           admin.setEmail(iner.getEmail());
           admin.setTele(iner.getTele());
           technicienneService.addTechnicienne(admin);
       }
    }

    @DeleteMapping(value = "/delete/{reference}")
    public void deletepointLumineux(@PathVariable("reference") Long reference) throws IllegalAccessException {
        technicienneService.deleteTechnicienne(reference);
    }

    @PutMapping(value = "update/{reference}")
    public void updatepointLumineux(
            @PathVariable("reference") Long reference,
            @RequestBody utilisateur technicienne
    ) throws IllegalAccessException {
        technicienneService.updateTechnicienne(reference,technicienne);
    }

    @PutMapping(value = "AddRole/{user}/{role}")
    public void AddRole(
            @PathVariable("user") Long reference,
            @PathVariable("role") Long role
    ) throws IllegalAccessException {
        technicienneService.AddOrUpdateRole(reference,role);
    }

    @PutMapping(value = "updNot/{user}/{nbr}")
    public void updatenbrnotifi(
            @PathVariable("user") Long reference,
            @PathVariable("nbr") String role
    ) throws IllegalAccessException {
        technicienneService.updatanbrnotification(reference,role);
    }

    @PutMapping(value = "DelleteRole/{user}/{role}")
    public void DeleteRole(
            @PathVariable("user") Long reference,
            @PathVariable("role") Long role
    ) throws IllegalAccessException {
        technicienneService.delleteRole(reference,role);
    }

}
