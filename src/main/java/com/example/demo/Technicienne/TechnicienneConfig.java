package com.example.demo.Technicienne;


import com.example.demo.Admin.Admin;
import com.example.demo.Admin.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class TechnicienneConfig {
    @Bean
    CommandLineRunner commandLineRunnerTechnicienne(TechnicienneRepository technicienneRepository){
        return args -> {
            Technicienne t1=new Technicienne("ellbabe","ahmmed","cin");
            technicienneRepository.save(t1);
        };
    }
}
