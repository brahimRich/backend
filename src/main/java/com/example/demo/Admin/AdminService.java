package com.example.demo.Admin;


import com.example.demo.PointLumineux.PointLumineux;
import com.example.demo.PointLumineux.PointLumineuxRepository;
import com.example.demo.User.UserRepository;
import com.example.demo.User.utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;


    @Autowired
    public AdminService(AdminRepository AdminRepository,UserRepository userRepository){
        this.adminRepository = AdminRepository;
        this.userRepository=userRepository;
    }

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }
    public void adAdmin(Admin u) {
        userRepository.save(u);
    }

}
