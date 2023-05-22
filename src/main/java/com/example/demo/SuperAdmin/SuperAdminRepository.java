package com.example.demo.SuperAdmin;

import com.example.demo.Technicienne.Technicienne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperAdminRepository extends JpaRepository<SuperAdmin,Long> {

}
