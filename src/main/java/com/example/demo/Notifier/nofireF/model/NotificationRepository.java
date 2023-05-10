package com.example.demo.Notifier.nofireF.model;

import com.example.demo.Adresse.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
