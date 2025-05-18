package com.dulain.customer_management_system.repository;


import com.dulain.customer_management_system.entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /** eager-load collections to minimize DB round-trips */
    @EntityGraph(attributePaths = { "addresses", "mobileNumbers", "familyMembers" })
    Optional<Customer> findByNic(String nic);
}