package com.example.demo.Armoire;

import com.example.demo.Adresse.AdressRepository;
import com.example.demo.Adresse.Adresse;
import com.example.demo.Intervention.Intervention;
import com.example.demo.Intervention.InterventionRepository;
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
import java.util.List;

@Configuration
public class ArmoireConfig {
    @Bean
    CommandLineRunner commandLineRunnerArmoire(PointLumineuxRepository pointLumineuxRepository, AdressRepository adressRepository, CoordonnesRepository coordonnesRepository, TechnicienneRepository technicienneRepository, InterventionRepository interventionRepository,ArmoireRepository armoireRepository,ArmoireServiceRepository armoireServiceRepository,ArmoireCaracteristiqueRepository armoireCaracteristiqueRepository){
        return args -> {
            Adresse a=new Adresse("rueeeeeeee22", "quatierrrrrrr33");
            Coordonnees c=new Coordonnees(6,8);
            adressRepository.save(a);
            coordonnesRepository.save(c);
            PointLumineux p2 = new PointLumineux("pointtttt",278.7,714.2,a,c);
            pointLumineuxRepository.save(p2);

            Technicienne t=new Technicienne("rida","mihi","jh21d");
            technicienneRepository.save(t);

            ArrayList<PointLumineux> lp=new ArrayList<>();
            lp.add(p2);

            ArrayList<Technicienne> techniciennes=new ArrayList<>();
            techniciennes.add(t);

            Intervention intervention=new Intervention(null,"type","intetulle","15","0",lp,techniciennes,null);
            interventionRepository.save(intervention);

            TypeArmoire typeArmoire=new TypeArmoire("selectionneur",new ArrayList<>());

            //typeArmoire.setId(1L);

            TypeArmoire typeArmoire2=new TypeArmoire("porte fusible",new ArrayList<>());

            //typeArmoire2.setId(2L);

            TypeArmoire typeArmoire3=new TypeArmoire("Repartiteur",new ArrayList<>());

            //typeArmoire3.setId(3L);

            TypeArmoire typeArmoire4=new TypeArmoire("Contacteur",new ArrayList<>());

            //typeArmoire4.setId(4L);

            TypeArmoire typeArmoire5=new TypeArmoire("Horloge",new ArrayList<>());

            //typeArmoire5.setId(5L);

            TypeArmoire typeArmoire6=new TypeArmoire("Disj uni C32",new ArrayList<>());

            //typeArmoire6.setId(6L);

            TypeArmoire typeArmoire7=new TypeArmoire("Bornes",new ArrayList<>());

            //typeArmoire7.setId(7L);

            TypeArmoire typeArmoire8=new TypeArmoire("Cablage",new ArrayList<>());

            //typeArmoire8.setId(8L);

            List<TypeArmoire> lta=new ArrayList<>();
            lta.add(typeArmoire);
            lta.add(typeArmoire2);
            lta.add(typeArmoire3);
            lta.add(typeArmoire4);
            lta.add(typeArmoire5);
            lta.add(typeArmoire6);
            lta.add(typeArmoire7);
            lta.add(typeArmoire8);


            armoireServiceRepository.saveAll(lta);


            ArmoireCaracteristique armoireCaracteristique=new ArmoireCaracteristique("marque1","qualibre2",16,typeArmoire);
            //armoireCaracteristique.setId(1L);
            ArmoireCaracteristique armoireCaracteristique2=new ArmoireCaracteristique("marque2","qualibre2",17,typeArmoire2);
            //armoireCaracteristique2.setId(2L);

//1
           // armoireServiceRepository.save(typeArmoire);

            armoireCaracteristiqueRepository.save(armoireCaracteristique);
//2

            //armoireServiceRepository.save(typeArmoire2);

            armoireCaracteristiqueRepository.save(armoireCaracteristique2);


            ArrayList<ArmoireCaracteristique> lac=new ArrayList<>();
            lac.add(armoireCaracteristique);
            lac.add(armoireCaracteristique2);

            ArrayList<TypeArmoire> lat=new ArrayList<>();
            lat.add(typeArmoire);
            lat.add(typeArmoire2);


            Armoire armoire=new Armoire(lac,lat);
            armoireRepository.save(armoire);

            p2.setArmoire(armoire);

            pointLumineuxRepository.save(p2);

// ajout de donner require



        };
    }
}
