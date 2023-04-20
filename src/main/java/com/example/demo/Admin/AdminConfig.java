package com.example.demo.Admin;


import com.example.demo.PointLumineux.PointLumineux;
import com.example.demo.PointLumineux.PointLumineuxRepository;
import com.example.demo.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AdminConfig {
    @Bean
    CommandLineRunner commandLineRunnerAdmin(AdminRepository AdminRepository){
        return args -> {
            Admin a1=new Admin("rich","brahim","email","code");
            AdminRepository.save(a1);
        };
    }
}
