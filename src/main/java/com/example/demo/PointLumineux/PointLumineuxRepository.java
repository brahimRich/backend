package com.example.demo.PointLumineux;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointLumineuxRepository extends JpaRepository<PointLumineux,Long> {
    //SELECT * FROM PRODUIT WHERE name = ?
    /*@Query("SELECT p FROM PointLumineux p WHERE p.name = ?1")
    Optional<PointLumineux> findProduitByName(String name);*/
    @Query(nativeQuery = true, value = "SELECT * FROM PointLumineux ")
    //@RestResource(exported = false)
    List<PointLumineux> findAll();
}
