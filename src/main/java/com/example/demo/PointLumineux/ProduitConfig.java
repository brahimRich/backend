package com.example.demo.PointLumineux;

import com.example.demo.Adresse.AdressRepository;
import com.example.demo.Adresse.Adresse;
import com.example.demo.coordonnees.Coordonnees;
import com.example.demo.coordonnees.CoordonnesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ProduitConfig {
    @Bean
    CommandLineRunner commandLineRunner(PointLumineuxRepository pointLumineuxRepository, AdressRepository adressRepository, CoordonnesRepository coordonnesRepository){
        return args -> {
            Adresse a=new Adresse("rue", "quatier");
            Coordonnees c=new Coordonnees(1,2);
            adressRepository.save(a);
            coordonnesRepository.save(c);
            PointLumineux p1 = new PointLumineux("Brahim",12.2,16.2,a,c);
            PointLumineux p2 = new PointLumineux("Rida",22.7,2.2,a,c);
            pointLumineuxRepository.save(p1);
            pointLumineuxRepository.save(p2);
        };
    }
}
