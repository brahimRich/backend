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

            Role role6=new Role("Block le compte");

            Role role7=new Role("Modifier info personnel");

            Role role8=new Role("Modifier Armoire");

            Role role9=new Role("Modifier Depart");

            Role role10=new Role("modifer des users");


            Role role14=new Role("Ajouter de nouveau depart au armoire");

            Role role12=new Role("modifier les departs d'armoire");


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
            roleReposotory.save(role6);
            roleReposotory.save(role7);
            roleReposotory.save(role8);
            roleReposotory.save(role9);
            roleReposotory.save(role10);
            roleReposotory.save(role14);
            roleReposotory.save(role12);



        };
    }
}
