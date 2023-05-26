package com.example.demo.Intervention;

import com.example.demo.Adresse.AdressRepository;
import com.example.demo.Adresse.Adresse;
import com.example.demo.PointLumineux.PointLumineux;
import com.example.demo.PointLumineux.PointLumineuxRepository;
import com.example.demo.Technicienne.Technicienne;
import com.example.demo.Technicienne.TechnicienneRepository;
import com.example.demo.coordonnees.Coordonnees;
import com.example.demo.coordonnees.CoordonnesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class InterventionConfig {
    @Bean
    CommandLineRunner commandLineRunnerInt(PointLumineuxRepository pointLumineuxRepository, AdressRepository adressRepository, CoordonnesRepository coordonnesRepository, TechnicienneRepository technicienneRepository,InterventionRepository interventionRepository){
        return args -> {
            Adresse a=new Adresse("rueeeeeeee", "quatierrrrrrr");
            Coordonnees c=new Coordonnees(6,8);
            adressRepository.save(a);
            coordonnesRepository.save(c);
            PointLumineux p2 = new PointLumineux("point",27.7,7.2,a,c);
            pointLumineuxRepository.save(p2);

            /*Technicienne t=new Technicienne("rich","brahim","jh21d");
            technicienneRepository.save(t);

            ArrayList<PointLumineux> lp=new ArrayList<>();
            lp.add(p2);

            ArrayList<Technicienne> techniciennes=new ArrayList<>();
            techniciennes.add(t);*/

            /*Intervention intervention=new Intervention(null,"type","intetulle",15,0,lp,techniciennes);
            interventionRepository.save(intervention);*/

        };
    }
}
