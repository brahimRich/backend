package com.example.demo.Depart;

import com.example.demo.Adresse.AdressRepository;
import com.example.demo.Adresse.Adresse;
import com.example.demo.Armoire.*;
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
import java.util.Collection;

@Configuration
public class DepartConfig {
    @Bean
    CommandLineRunner commandLineRunnerDepart(PointLumineuxRepository pointLumineuxRepository, AdressRepository adressRepository, CoordonnesRepository coordonnesRepository, TechnicienneRepository technicienneRepository, InterventionRepository interventionRepository, ArmoireRepository armoireRepository, ArmoireServiceRepository armoireServiceRepository, ArmoireCaracteristiqueRepository armoireCaracteristiqueRepository,DepartRepository departRepository,CaracteristiqueRepository caracteristiqueRepository,TypeRepository typeRepository){
        return args -> {
            Adresse a=new Adresse("r", "q");
            Coordonnees c=new Coordonnees(67,89);
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

            Intervention intervention=new Intervention(null,"type","intetulle",15,0,lp,techniciennes);
            interventionRepository.save(intervention);

            TypeArmoire typeArmoire=new TypeArmoire("selectionneur",new ArrayList<>());

            TypeArmoire typeArmoire2=new TypeArmoire("porte fusible",new ArrayList<>());


            ArmoireCaracteristique armoireCaracteristique=new ArmoireCaracteristique("marque1","qualibre2",16,typeArmoire);

            ArmoireCaracteristique armoireCaracteristique2=new ArmoireCaracteristique("marque2","qualibre2",17,typeArmoire2);

//1
            armoireServiceRepository.save(typeArmoire);

            armoireCaracteristiqueRepository.save(armoireCaracteristique);
//2

            armoireServiceRepository.save(typeArmoire2);

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


            DepartType departType=new DepartType(1,"R",new ArrayList<>());

            typeRepository.save(departType);

            Caracteristique caracteristique=new Caracteristique("trifase 5","mono 5","courant A","trpfase externe","monoexterne","12w",null,departType);

            caracteristiqueRepository.save(caracteristique);


            ArrayList<DepartType> ltd=new ArrayList<>();
            ltd.add(departType);

            ArrayList<Caracteristique> lcd=new ArrayList<>();
            lcd.add(caracteristique);


            Departt departt=new Departt("je observe",armoire,lcd);

            departRepository.save(departt);

        };
    }
}
