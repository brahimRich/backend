package com.example.demo.Admin;

import com.example.demo.PointLumineux.PointLumineux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

}
