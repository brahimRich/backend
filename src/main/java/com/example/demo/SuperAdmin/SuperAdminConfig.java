package com.example.demo.SuperAdmin;


import com.example.demo.Technicienne.Technicienne;
import com.example.demo.Technicienne.TechnicienneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SuperAdminConfig {
    @Bean
    CommandLineRunner commandLineRunnerSuperAdmin(SuperAdminRepository SuperAdminRepository){
        return args -> {
            SuperAdmin t1=new SuperAdmin("rich","brahim","admin14@gmail.com","admin");
            SuperAdminRepository.save(t1);
        };
    }
}
