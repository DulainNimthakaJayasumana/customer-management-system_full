package com.dulain.customer_management_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Country {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    /* getters / setters */
    public Long getId()               { return id; }
    public void setId(Long id)        { this.id = id; }

    public String getName()           { return name; }
    public void setName(String name)  { this.name = name; }
}