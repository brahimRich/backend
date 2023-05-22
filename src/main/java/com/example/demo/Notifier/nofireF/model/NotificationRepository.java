package com.example.demo.Notifier.nofireF.model;

import com.example.demo.Adresse.Adresse;
import com.example.demo.Depart.DepartType;
import com.example.demo.Intervention.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    @Query("SELECT p FROM Notification p WHERE p.createdAt = :typedepart")
    Notification findTypeByDate(@Param("typedepart") LocalDateTime typedepart);
    @Query("SELECT p FROM Notification p WHERE p.intervention.Id_Intervention = :typedepart")
    Notification findByIntervention(@Param("typedepart") Long typedepart);

}
