package com.dulain.customer_management_system.repository;

import com.dulain.customer_management_system.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> { }