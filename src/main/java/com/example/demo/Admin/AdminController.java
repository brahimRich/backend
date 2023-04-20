package com.example.demo.Admin;


import com.example.demo.PointLumineux.PointLumineux;
import com.example.demo.PointLumineux.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path ="api/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminSe) {
        this.adminService = adminSe;
    }

    @GetMapping("/getAll")
    public List<Admin> getAdmins() {
        return adminService.getAdmins();
    }

}
