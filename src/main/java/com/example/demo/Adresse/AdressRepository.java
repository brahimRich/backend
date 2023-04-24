package com.example.demo.Adresse;

import com.example.demo.coordonnees.Coordonnees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adresse,Long> {
}
