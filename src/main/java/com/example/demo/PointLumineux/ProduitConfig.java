package com.example.demo.PointLumineux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ProduitConfig {
    @Bean
    CommandLineRunner commandLineRunner(PointLumineuxRepository pointLumineuxRepository){
        return args -> {
            PointLumineux p1 = new PointLumineux("Brahim",12.2,16.2);
            pointLumineuxRepository.save(p1);
        };
    }
}
