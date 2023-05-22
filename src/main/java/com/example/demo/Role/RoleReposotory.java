package com.example.demo.Role;

import com.example.demo.Technicienne.Technicienne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleReposotory extends JpaRepository<Role,Long> {

}
