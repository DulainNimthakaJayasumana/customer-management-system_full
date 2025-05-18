package com.dulain.customer_management_system.repository;


import com.dulain.customer_management_system.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> { }