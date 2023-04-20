package com.example.demo.Admin;


import com.example.demo.PointLumineux.PointLumineux;
import com.example.demo.PointLumineux.PointLumineuxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository AdminRepository){
        this.adminRepository = AdminRepository;
    }

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

}
