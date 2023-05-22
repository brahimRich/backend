package com.example.demo.Role;


import com.example.demo.Technicienne.Technicienne;
import com.example.demo.Technicienne.TechnicienneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class RoleConfig {
    @Bean
    CommandLineRunner commandLineRunnerTechnicienneRole(TechnicienneRepository technicienneRepository,RoleReposotory roleReposotory){
        return args -> {
            Role role1=new Role("Ajout un depart");
            Role role11=new Role("Lister les departs");

            Role role2=new Role("Ajout un Armoire");
            Role role22=new Role("Lister les Armoires");

            Role role3=new Role("Ajout un Intervention");
            Role role33=new Role("liste des Interventions");

            Role role4=new Role("Ajout user");
            Role role44=new Role("liste des users");

            Role role5=new Role("Ajout point");
            Role role55=new Role("liste des points");

            roleReposotory.save(role1);
            roleReposotory.save(role11);
            roleReposotory.save(role2);
            roleReposotory.save(role22);
            roleReposotory.save(role3);
            roleReposotory.save(role33);
            roleReposotory.save(role4);
            roleReposotory.save(role44);
            roleReposotory.save(role5);
            roleReposotory.save(role55);

        };
    }
}
