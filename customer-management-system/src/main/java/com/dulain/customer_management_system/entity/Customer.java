package com.dulain.customer_management_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "nic"))
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private LocalDate dateOfBirth;

    @NotBlank
    private String nic;

    /* multiple mobiles */
    @ElementCollection
    @CollectionTable(name = "customer_mobiles",
            joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "mobile_number")
    private List<String> mobileNumbers = new ArrayList<>();

    /* multiple addresses */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    /* family members (self-relation) */
    @ManyToMany
    @JoinTable(name = "customer_family",
            joinColumns        = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "family_member_id"))
    private Set<Customer> familyMembers = new HashSet<>();

    /* getters / setters */
    public Long getId()                          { return id; }
    public void setId(Long id)                   { this.id = id; }

    public String getName()                      { return name; }
    public void setName(String name)             { this.name = name; }

    public LocalDate getDateOfBirth()            { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dob)    { this.dateOfBirth = dob; }

    public String getNic()                       { return nic; }
    public void setNic(String nic)               { this.nic = nic; }

    public List<String> getMobileNumbers()       { return mobileNumbers; }
    public void setMobileNumbers(List<String> m) { this.mobileNumbers = m; }

    public List<Address> getAddresses()          { return addresses; }
    public void setAddresses(List<Address> a)    { this.addresses = a; }

    public Set<Customer> getFamilyMembers()      { return familyMembers; }
    public void setFamilyMembers(Set<Customer> f){ this.familyMembers = f; }
}