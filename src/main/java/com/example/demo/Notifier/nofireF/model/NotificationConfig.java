package com.example.demo.Notifier.nofireF.model;


import com.example.demo.Admin.Admin;
import com.example.demo.Admin.AdminRepository;
import com.example.demo.Technicienne.Technicienne;
import com.example.demo.Technicienne.TechnicienneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class NotificationConfig {
    @Bean
    CommandLineRunner commandLineRunnerNotification(TechnicienneRepository technicienneRepository,NotificationRepository notificationRepository){
        return args -> {
            /*Technicienne t1=new Technicienne("rich notifier","brahim","cin");
            technicienneRepository.save(t1);
            Notification notification=new Notification("titre b ","mesage b","topic",t1,"ff");
            notificationRepository.save(notification);*/
        };
    }
}
