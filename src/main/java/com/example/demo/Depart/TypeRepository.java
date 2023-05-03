package com.example.demo.Depart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TypeRepository extends JpaRepository<DepartType,Long> {
    /*@Query("SELECT p FROM PointLumineux p WHERE p.name = ?1")
    Optional<PointLumineux> findProduitByName(String name);*/
    @Query("SELECT p FROM DepartType p WHERE p.typedepart = :typedepart")
    DepartType findTypeByName(@Param("typedepart") String typedepart);
}
