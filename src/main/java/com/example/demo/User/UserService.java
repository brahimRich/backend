package com.example.demo.User;


import com.example.demo.Admin.AdminRepository;
import com.example.demo.Role.Role;
import com.example.demo.Role.RoleReposotory;
import com.example.demo.Technicienne.Technicienne;
import com.example.demo.Technicienne.TechnicienneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final AdminRepository adminRepository;
    private final TechnicienneRepository technicienneRepository;
    private final RoleReposotory roleReposotory;
    private final UserRepository userRepository;

    @Autowired
    public UserService(AdminRepository AdminRepository, TechnicienneRepository technicienneRepository, RoleReposotory roleReposotory,UserRepository userRepository){
        this.adminRepository = AdminRepository;
        this.technicienneRepository=technicienneRepository;
        this.roleReposotory=roleReposotory;
        this.userRepository=userRepository;
    }

    public List<utilisateur> GetAllUser(){
        return userRepository.findAll();
    }


}
