package com.example.demo.Role;

import jakarta.persistence.*;

@Entity
public class Role {
    @Id
    @SequenceGenerator(
            name = "PointLumineux_sequence",
            sequenceName = "PointLumineux_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PointLumineux_sequence"
    )
    private Long id;
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
