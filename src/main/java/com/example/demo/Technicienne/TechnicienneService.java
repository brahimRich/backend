package com.example.demo.Technicienne;


import com.example.demo.Admin.Admin;
import com.example.demo.Admin.AdminRepository;
import com.example.demo.Armoire.Armoire;
import com.example.demo.Depart.Departt;
import com.example.demo.Role.Role;
import com.example.demo.Role.RoleReposotory;
import com.example.demo.User.UserRepository;
import com.example.demo.User.utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicienneService {
    private final AdminRepository adminRepository;
    private final TechnicienneRepository technicienneRepository;
    private final RoleReposotory roleReposotory;
    private final UserRepository userRepository;


    @Autowired
    public TechnicienneService(AdminRepository AdminRepository,TechnicienneRepository technicienneRepository,RoleReposotory roleReposotory,UserRepository userRepository){
        this.adminRepository = AdminRepository;
        this.technicienneRepository=technicienneRepository;
        this.roleReposotory=roleReposotory;
        this.userRepository=userRepository;
    }

    public List<Technicienne> getTechns() {
        return technicienneRepository.findAll();
    }


    public void addTechnicienne(Technicienne technicienne) throws IllegalAccessException {
        userRepository.save(technicienne);
    }

    public void addUser(utilisateur user) throws IllegalAccessException {
        userRepository.save(user);
    }

    public List<Role> getAllrole() {
        return roleReposotory.findAll();
    }


    public List<Role> getAllroleUser(Long id) {
        utilisateur technicienne = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("point with reference "+" does not exists"));
        return technicienne.getRoleList();
    }




    public void deleteTechnicienne(Long reference) throws IllegalAccessException {
        System.out.println("delete ************************************");
        boolean b = technicienneRepository.existsById(reference);
        if(!b){
            throw new IllegalAccessException("Produit with reference "+reference+" does not exists");
        }else{
            technicienneRepository.deleteById(reference);
        }
    }


    public void AddOrUpdateRole(Long reference,Long role) throws IllegalAccessException {
        System.out.println("add role ************************************");
        boolean b = userRepository.existsById(reference);
        Role role1=roleReposotory.findById(role).orElseThrow(()-> new IllegalArgumentException("point with reference "+reference+" does not exists"));
        utilisateur technicienne = userRepository.findById(reference).orElseThrow(()-> new IllegalArgumentException("point with reference "+reference+" does not exists"));
        if(!b){
            throw new IllegalAccessException("Produit with reference "+reference+" does not exists");
        }else{
            int index = technicienne.getRoleList().indexOf(role1);
            if(index != -1){
                Role ancienRole = technicienne.getRoleList().get(index);
                technicienne.getRoleList().set(index, role1);
            }else{
                technicienne.getRoleList().add(role1);
            }
            userRepository.save(technicienne);
        }
    }

    public void delleteRole(Long reference,Long role) throws IllegalAccessException {
        System.out.println("delete ************************************");
        boolean b = userRepository.existsById(reference);
        Role role1=roleReposotory.findById(role).orElseThrow(()-> new IllegalArgumentException("point with reference "+reference+" does not exists"));
        utilisateur technicienne = userRepository.findById(reference).orElseThrow(()-> new IllegalArgumentException("point with reference "+reference+" does not exists"));
        if(!b){
            throw new IllegalAccessException("Produit with reference "+reference+" does not exists");
        }else{
            technicienne.getRoleList().remove(role1);
        }
        userRepository.save(technicienne);
    }

    @Transactional
    public void updateTechnicienne(Long reference, Technicienne t) throws IllegalAccessException {
        System.out.println("updatee ************************************ "+reference);
        Technicienne technicienne = technicienneRepository.findById(reference).orElseThrow(()-> new IllegalArgumentException("point with reference "+reference+" does not exists"));
        technicienne.setCin(t.getCin());
        technicienne.setNom(t.getNom());
        technicienne.setPrenom(t.getPrenom());
        technicienneRepository.save(technicienne);
    }

}
