package com.example.demo.coordonnees;

import com.example.demo.PointLumineux.PointLumineux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CoordonnesRepository extends JpaRepository<Coordonnees,Long> {
}
