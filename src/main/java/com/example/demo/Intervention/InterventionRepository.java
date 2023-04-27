package com.example.demo.Intervention;


import com.example.demo.Adresse.Adresse;
import com.example.demo.coordonnees.Coordonnees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterventionRepository extends JpaRepository<Intervention,Long> {
}
